/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2025, veraPDF Consortium <info@verapdf.org>
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
package org.verapdf.gf.model.impl.operator.textshow;

import org.verapdf.as.ASAtom;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOpMarkedContent;
import org.verapdf.gf.model.impl.operator.markedcontent.MarkedContentHelper;
import org.verapdf.gf.model.tools.GFIDGenerator;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.operator.Glyph;
import org.verapdf.pd.font.*;
import org.verapdf.pd.font.truetype.PDTrueTypeFont;
import org.verapdf.pd.font.type3.PDType3Font;
import org.verapdf.pd.structure.StructureElementAccessObject;
import org.verapdf.pdfa.flavours.PDFAFlavour;
import org.verapdf.pdfa.flavours.PDFFlavours;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents glyph used in text.
 *
 * @author Sergey Shemyakov
 */
public class GFGlyph extends GenericModelObject implements Glyph {

    private static final Logger LOGGER = Logger.getLogger(GFGlyph.class.getCanonicalName());

    public static final String GLYPH_TYPE = "Glyph";

    private final String id;

    private Boolean glyphPresent;
    private Double widthFromDictionary;
    private Double widthFromFontProgram;
    private String name;
    private final String toUnicode;
    private final Long renderingMode;
    private final GFOpMarkedContent markedContent;
    private final StructureElementAccessObject structureElementAccessObject;

    private final boolean isRealContent;

    protected GFGlyph(PDFont font, int glyphCode, int renderingMode, String id, GFOpMarkedContent markedContent, 
                      StructureElementAccessObject structureElementAccessObject, boolean isRealContent) {
        this(font, glyphCode, renderingMode, id, markedContent, structureElementAccessObject, isRealContent, GLYPH_TYPE);
    }

    protected GFGlyph(PDFont font, int glyphCode, int renderingMode, String id,
                   GFOpMarkedContent markedContent, StructureElementAccessObject structureElementAccessObject, boolean isRealContent, String type) {
        super(type);

        FontProgram fontProgram = font.getFontProgram();
        boolean fontProgramIsInvalid = (fontProgram == null || !font.isSuccessfullyParsed())
                && font.getSubtype() != ASAtom.TYPE3;

        if (font.getSubtype() != ASAtom.TYPE3) {
            initForNotType3(fontProgramIsInvalid, fontProgram, font, glyphCode);
        } else {
            initForType3(font, glyphCode);
        }
        this.renderingMode = (long) renderingMode;
        this.markedContent = markedContent;
        this.structureElementAccessObject = structureElementAccessObject;

        if (font instanceof PDSimpleFont) {
            Encoding encoding = font.getEncodingMapping();
            this.name = encoding == null ? null : encoding.getName(glyphCode);
            if (this.name == null && glyphCode == 0 && font instanceof PDTrueTypeFont) {
                this.name = ".notdef";
            }
        } else if (font instanceof PDType0Font) {
            try {
                FontProgram pr = font.getFontProgram();
                if (pr == null || !pr.isSuccessfulParsing()) {
                    this.name = null;
                } else {
                    pr.parseFont();
                    this.name = font.glyphIsPresent(glyphCode) ? null : ".notdef";
                }
            } catch (IOException e) {
                LOGGER.log(Level.FINE, "Can't convert code to glyph", e);
                this.name = null;
            }
        }
        List<PDFAFlavour> flavour = StaticContainers.getFlavours();
        if (!PDFFlavours.isFlavour(flavour, PDFAFlavour.PDFA_1_B) && 
                !PDFFlavours.isFlavour(flavour, PDFAFlavour.PDFA_2_B) && 
                !PDFFlavours.isFlavour(flavour, PDFAFlavour.PDFA_3_B)) {
            if (PDFFlavours.isPDFSpecification(flavour, PDFAFlavour.PDFSpecification.PDF_REFERENCE_1_4)) {
                this.toUnicode = getToUnicodePDFA1(font, glyphCode);
            } else {
                this.toUnicode = font.toUnicode(glyphCode);
            }
        } else {
            this.toUnicode = null;
        }
        this.id = id;
        this.isRealContent = isRealContent;
    }

    public static Glyph getGlyph(PDFont font, int glyphCode, int renderingMode, GFOpMarkedContent markedContent,
                                 StructureElementAccessObject structureElementAccessObject, boolean isRealContent) {
        String fontId = GFIDGenerator.generateID(font);
        String id = GFIDGenerator.generateID(fontId,
                font.getName(), glyphCode, renderingMode, markedContent, structureElementAccessObject, isRealContent);
        Glyph cachedGlyph = null;
        Map<String, Glyph> map = StaticContainers.getCachedGlyphs().get(fontId);
        if (map != null) {
            cachedGlyph = map.get(id);
        }
        if (cachedGlyph == null) {
            if (font.getSubtype() == ASAtom.CID_FONT_TYPE0 || font.getSubtype() == ASAtom.CID_FONT_TYPE2 ||
                    font.getSubtype() == ASAtom.TYPE0) {
                cachedGlyph = new GFCIDGlyph(font, glyphCode, renderingMode, id,
                        markedContent, structureElementAccessObject, isRealContent);
            } else {
                cachedGlyph = new GFGlyph(font, glyphCode, renderingMode, id,
                        markedContent, structureElementAccessObject, isRealContent);
            }
            if (map == null) {
                map = new HashMap<>();
                map.put(id, cachedGlyph);
                StaticContainers.getCachedGlyphs().put(fontId, map);
            } else {
                map.put(id, cachedGlyph);
            }
        }
        return cachedGlyph;
    }

    private String getToUnicodePDFA1(PDFont font, int glyphCode) {
        if (font instanceof PDType3Font) {
            return font.cMapToUnicode(glyphCode);
        } else if (font instanceof org.verapdf.pd.font.type1.PDType1Font) {
            return ((org.verapdf.pd.font.type1.PDType1Font) font).toUnicodePDFA1(glyphCode);
        } else {
            return font.toUnicode(glyphCode);
        }
    }

    private void initForType3(PDFont font, int glyphCode) {
        glyphPresent = ((PDType3Font) font).containsCharString(glyphCode);
        this.widthFromFontProgram = getWidthFromProgram(glyphCode, font);
        this.widthFromDictionary = getWidthFromDictionary(glyphCode, font);
    }

    private void initForNotType3(boolean fontProgramIsInvalid, FontProgram fontProgram,
                                 PDFont font, int glyphCode) {
        try {
            glyphPresent = null;
            widthFromDictionary = null;
            widthFromFontProgram = null;
            if (!fontProgramIsInvalid) {
                fontProgram.parseFont();
                // every font contains notdef glyph. But if we call method
                // of font program we can't distinguish case of code 0
                // and glyph that is not present indeed.
                glyphPresent = glyphCode == 0 || font.glyphIsPresent(glyphCode);
                widthFromFontProgram = getWidthFromProgram(glyphCode, font);
                widthFromDictionary = getWidthFromDictionary(glyphCode, font);
            }
        } catch (IOException e) {
            LOGGER.log(Level.FINE, "Error in parsing font program", e);
        }
    }

    private static Double getWidthFromDictionary(int glyphCode, PDFont font) {
        Double fontWidth = font.getWidth(glyphCode);
        return fontWidth == null ? 0 : fontWidth;
    }

    private static Double getWidthFromProgram(int glyphCode, PDFont font) {
        double foundWidth = font.getWidthFromProgram(glyphCode);
        if (foundWidth == -1) {
            foundWidth = font.getDefaultWidth() == null ? 0 : font.getDefaultWidth();
        }
        return foundWidth;
    }

    private static Boolean checkWidths(int glyphCode, PDFont font) {
        Double fontWidth = font.getWidth(glyphCode);
        double expectedWidth = fontWidth == null ? 0 : fontWidth;
        double foundWidth = font.getWidthFromProgram(glyphCode);
        if (foundWidth == -1) {
            foundWidth = font.getDefaultWidth() == null ? 0 : font.getDefaultWidth();
        }
        // consistent is defined to be a difference of no more than 1/1000 unit.
        return Math.abs(foundWidth - expectedWidth) > 1 ? Boolean.FALSE : Boolean.TRUE;
    }

    @Override
    public String getname() {
        return this.name;
    }

    @Override
    public Double getwidthFromDictionary() {
        return widthFromDictionary;
    }

    @Override
    public Double getwidthFromFontProgram() {
        return widthFromFontProgram;
    }

    @Override
    public Boolean getisGlyphPresent() {
        return this.glyphPresent;
    }

    @Override
    public String gettoUnicode() {
        return this.toUnicode;
    }

    @Override
    public Long getrenderingMode() {
        return this.renderingMode;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public Boolean getunicodePUA() {
        return PUAHelper.containPUA(toUnicode);
    }

    @Override
    public Boolean getactualTextPresent() {
        return MarkedContentHelper.containsStringKey(ASAtom.ACTUAL_TEXT, markedContent, structureElementAccessObject);
    }

    @Override
    public Boolean getaltPresent() {
        return MarkedContentHelper.containsStringKey(ASAtom.ALT, markedContent, structureElementAccessObject);
    }

    @Override
    public Boolean getisRealContent() {
        return isRealContent;
    }
}
