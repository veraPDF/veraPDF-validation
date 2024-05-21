/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.pd.font;

import org.verapdf.as.io.ASInputStream;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSStream;
import org.verapdf.gf.model.factory.operators.RenderingMode;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.model.operator.CIDGlyph;
import org.verapdf.model.operator.Glyph;
import org.verapdf.model.pdlayer.PDCIDFont;
import org.verapdf.pd.font.FontProgram;
import org.verapdf.pd.font.PDFont;
import org.verapdf.pdfa.flavours.PDFAFlavour;
import org.verapdf.tools.StaticResources;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents CID Font dictionary.
 *
 * @author Sergey Shemyakov
 */
public class GFPDCIDFont extends GFPDFont implements PDCIDFont {

    private static final Logger LOGGER = Logger.getLogger(GFPDCIDFont.class.getCanonicalName());

    public static final String CID_FONT_TYPE = "PDCIDFont";

    public static final String IDENTITY = "Identity";
    public static final String CUSTOM = "Custom";
    public static final int maxSize = 16384;
    public static final int bufferSize = 2048;
    private final String externalFontID;

    public GFPDCIDFont(PDFont font, RenderingMode renderingMode, String externalFontID) {
        super(font, renderingMode, CID_FONT_TYPE);
        this.externalFontID = externalFontID;
        if (font != null) {
            FontProgram program = font.getFontProgram();
            if (program != null) {
                StaticResources.getDocument().getDocument().getResourceHandler().addResource(
                        program.getFontProgramResource());
            }
            if (program != null) {
                try {
                    if (!program.isAttemptedParsing()) {
                        program.parseFont();
                    }
                    this.fontProgramParsed = program.isSuccessfulParsing();
                    this.pdFont.setSuccessfullyParsed(program.isSuccessfulParsing());
                } catch (IOException e) {
                    LOGGER.log(Level.FINE, "Can't parse font program of font " + font.getName(), e);
                    this.fontProgramParsed = false;
                    this.pdFont.setSuccessfullyParsed(false);
                }
            }
        }
    }

    /**
     * @return string representation of the CIDtoGIDMap entry ("Identity", or
     * "Custom" in case of stream value).
     */
    @Override
    public String getCIDToGIDMap() {
        COSObject cidToGidObject =
                ((org.verapdf.pd.font.PDCIDFont) this.pdFont).getCIDToGIDMap();
        if (cidToGidObject.getType() == COSObjType.COS_STREAM) {
            return CUSTOM;
        }
        if (cidToGidObject.getType() == COSObjType.COS_NAME &&
                IDENTITY.equals(cidToGidObject.getString())) {
            return IDENTITY;
        }
        return null;
    }

    @Override
    public Boolean getcontainsCIDSet() {
        return ((org.verapdf.pd.font.PDCIDFont) this.pdFont).getCIDSet() != null;
    }

    /**
     * @return true if the CIDSet is present and correctly lists all glyphs
     * present in the embedded font program.
     */
    @Override
    public Boolean getcidSetListsAllGlyphs() {
        if (!fontProgramParsed) {
            return Boolean.FALSE;
        }

        try {
            COSStream cidSet = getCIDSetStream();
            if (cidSet != null) {
                byte[] cidSetBytes;
                try (ASInputStream stream = cidSet.getData(COSStream.FilterFlags.DECODE)) {
                    cidSetBytes = getCIDsFromCIDSet(stream);
                }

                //reverse bit order in bit set (convert to big endian)
                BitSet bitSet = toBitSetBigEndian(cidSetBytes);

                FontProgram cidFont = this.pdFont.getFontProgram();

                PDFAFlavour flavour = StaticContainers.getFlavour();
                if (flavour.getPart() != PDFAFlavour.Specification.ISO_19005_1) {
                    //on these levels we need to ensure that all glyphs present in font program are described in cid set
                    List<Integer> fontCIDs = cidFont != null ? cidFont.getCIDList() : Collections.emptyList();
                    for (int cid : fontCIDs) {
                        if (cid != 0 && !bitSet.get(cid)) {
                            return Boolean.FALSE;
                        }
                    }
                    // we skip i = 0 which corresponds to .notdef glyph
                    for (int i = 1; i < bitSet.length(); i++) {
                        if (bitSet.get(i) && !cidFont.containsCID(i)) {
                            return Boolean.FALSE;
                        }
                    }
                } else {
                    Map<String, Glyph> map = StaticContainers.getCachedGlyphs().get(externalFontID);
                    if (map != null) {
                        for (Glyph glyph : map.values()) {
                            if (glyph instanceof CIDGlyph) {
                                int cid = ((CIDGlyph)glyph).getCID().intValue();
                                if (cid != 0 && cidFont.containsCID(cid) && !bitSet.get(cid)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.FINE, "Error while parsing embedded font program. " + e.getMessage(), e);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private COSStream getCIDSetStream() {
        return ((org.verapdf.pd.font.PDCIDFont) this.pdFont).getCIDSet();
    }

    private static byte[] getCIDsFromCIDSet(ASInputStream cidSet) throws IOException {
        byte[] cidSetBytes = new byte[maxSize];
        byte[] temp = new byte[bufferSize];
        int size = 0;
        int read = cidSet.read(temp, bufferSize);
        while (read != -1) {
            if (size + read >= maxSize) {
                System.arraycopy(temp, 0, cidSetBytes, size, maxSize - size);
                return cidSetBytes;
            }
            System.arraycopy(temp, 0, cidSetBytes, size, read);
            size += read;
            if (read < bufferSize) {
                return Arrays.copyOf(cidSetBytes, size);
            }
            read = cidSet.read(temp, bufferSize);
        }
        return Arrays.copyOf(cidSetBytes, size);
    }

    private static BitSet toBitSetBigEndian(byte[] source) {
        BitSet bitSet = new BitSet(source.length * 8);
        int i = 0;
        for (byte value : source) {
            int b = value >= 0 ? value : 256 + value;
            for (int k = 0; k < 8; k++) {
                bitSet.set(i++, (b & 0x80) != 0);
                b = b << 1;
            }
        }
        return bitSet;
    }
}
