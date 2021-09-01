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

import org.verapdf.as.ASAtom;
import org.verapdf.gf.model.factory.operators.RenderingMode;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.tools.GFIDGenerator;
import org.verapdf.model.operator.Glyph;
import org.verapdf.model.pdlayer.PDType1Font;
import org.verapdf.pd.font.FontProgram;
import org.verapdf.pd.font.cff.CFFFontProgram;
import org.verapdf.pd.font.cff.CFFType1FontProgram;
import org.verapdf.pd.font.opentype.OpenTypeFontProgram;
import org.verapdf.pd.font.type1.Type1FontProgram;
import org.verapdf.pdfa.flavours.PDFAFlavour;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents Type1 font dictionary.
 *
 * @author Sergey Shemyakov
 */
public class GFPDType1Font extends GFPDSimpleFont implements PDType1Font {

    private static final Logger LOGGER = Logger.getLogger(GFPDType1Font.class.getCanonicalName());

    public static final String TYPE1_FONT_TYPE = "PDType1Font";

    public static final String NOTDEF_STRING = ".notdef";

    public GFPDType1Font(org.verapdf.pd.font.type1.PDType1Font pdFont,
                         RenderingMode renderingMode) {
        super(pdFont, renderingMode, TYPE1_FONT_TYPE);
        if (pdFont != null) {
            FontProgram program = pdFont.getFontProgram();
            if (program != null) {
                StaticContainers.getDocument().getDocument().getResourceHandler().addResource(
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
                    LOGGER.log(Level.FINE, "Can't parse font program of font " + pdFont.getName(), e);
                    this.fontProgramParsed = false;
                    this.pdFont.setSuccessfullyParsed(false);
                }
            }
        }
    }

    /**
     * @return the value of the CharSet entry in the font descriptor dictionary.
     */
    @Override
    public String getCharSet() {
        String res = this.pdFont.getFontDescriptor().getStringKey(ASAtom.CHAR_SET);
        return res;
    }

    /**
     * @return true if the CharSet is present and correctly lists all glyphs
     * present in the embedded font program.
     */
    @Override
    public Boolean getcharSetListsAllGlyphs() {
        if (!fontProgramParsed) {
            return Boolean.valueOf(false);
        }

        Set<String> descriptorCharSet = ((org.verapdf.pd.font.type1.PDType1Font)
                this.pdFont).getDescriptorCharSet();
        Set<String> fontProgramCharSet;
        if (this.pdFont.getFontProgram() instanceof Type1FontProgram) {
            fontProgramCharSet =
                    ((Type1FontProgram) this.pdFont.getFontProgram()).getCharSet();
        } else if (this.pdFont.getFontProgram() instanceof CFFFontProgram) {
            // Type1 program is contained inside CFF program.
            fontProgramCharSet = ((CFFType1FontProgram)
                    ((CFFFontProgram)
                            this.pdFont.getFontProgram()).getFont()).getCharSet();
        } else if (this.pdFont.getFontProgram() instanceof OpenTypeFontProgram) {
            // Type1 program is contained inside CFF program that is contained
            // inside OpenType program.
            CFFFontProgram cff = (CFFFontProgram)
                    ((OpenTypeFontProgram) this.pdFont.getFontProgram()).getFont();
            fontProgramCharSet = ((CFFType1FontProgram)
                    (cff.getFont())).getCharSet();
        } else {
            fontProgramCharSet = new TreeSet<>();
        }
        if (StaticContainers.getFlavour().getPart() != PDFAFlavour.Specification.ISO_19005_1) {
            if (!(descriptorCharSet.size() == fontProgramCharSet.size() ||
                  descriptorCharSet.size() == fontProgramCharSet.size() - 1) ) {
                return Boolean.valueOf(false);
            }
            for (String glyphName : descriptorCharSet) {
                if (!NOTDEF_STRING.equals(glyphName) && !fontProgramCharSet.contains(glyphName)) {
                    return Boolean.valueOf(false);
                }
            }
            for (String glyphName : fontProgramCharSet) {
                if (!NOTDEF_STRING.equals(glyphName) &&
                    !descriptorCharSet.contains(glyphName)) {
                    return Boolean.valueOf(false);
                }
            }
        } else {
            Map<String, Glyph> map = StaticContainers.getCachedGlyphs().get(GFIDGenerator.generateID(pdFont));
            if (map != null) {
                for (Glyph glyph : map.values()) {
                    String glyphName = glyph.getname();
                    if (fontProgramCharSet.contains(glyphName) && !descriptorCharSet.contains(glyphName)) {
                        return false;
                    }
                }
            }
        }
        return Boolean.valueOf(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getisStandard() {
        return ((org.verapdf.pd.font.type1.PDType1Font) this.pdFont).isStandard();
    }
}
