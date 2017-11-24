/**
 * This file is part of validation-model, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * validation-model is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with validation-model as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * validation-model as the LICENSE.MPL file in the root of the source tree.
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
import org.verapdf.pd.font.type3.PDType3Font;
import org.verapdf.pd.structure.StructureElementAccessObject;
import org.verapdf.pdfa.flavours.PDFAFlavour;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents glyph used in text.
 *
 * @author Sergey Shemyakov
 */
public class GFGlyph extends GenericModelObject implements Glyph {

    private static final Logger LOGGER = Logger.getLogger(GFGlyph.class.getCanonicalName());

    public final static String GLYPH_TYPE = "Glyph";

    private static final int[] UNICODE_PRIVATE_USE_AREA_ARRAY = {0xE000, 0xF8FF, 0xF0000, 0xFFFFD, 0x100000, 0x10FFFD};

    private final String id;

    private Boolean glyphPresent;
    private Boolean widthsConsistent;
    private String name;
    private String toUnicode;
    private Long renderingMode;
    private GFOpMarkedContent markedContent;
    private StructureElementAccessObject structureElementAccessObject;

    protected GFGlyph(PDFont font, int glyphCode, int renderingMode, String id,
                   GFOpMarkedContent markedContent, StructureElementAccessObject structureElementAccessObject) {
        this(font, glyphCode, GLYPH_TYPE, renderingMode, id, markedContent, structureElementAccessObject);
    }

    protected GFGlyph(PDFont font, int glyphCode, String type, int renderingMode, String id,
                   GFOpMarkedContent markedContent, StructureElementAccessObject structureElementAccessObject) {
        super(type);

        FontProgram fontProgram = font.getFontProgram();
        boolean fontProgramIsInvalid = (fontProgram == null || !font.isSuccessfullyParsed())
                && font.getSubtype() != ASAtom.TYPE3;

        if (font.getSubtype() != ASAtom.TYPE3) {
            initForNotType3(fontProgramIsInvalid, fontProgram, font, glyphCode);
        } else {
            initForType3(font, glyphCode);
        }
        this.renderingMode = Long.valueOf(renderingMode);
        this.markedContent = markedContent;
        this.structureElementAccessObject = structureElementAccessObject;

        if (font instanceof PDSimpleFont) {
            Encoding encoding = font.getEncodingMapping();
            this.name = encoding == null ? null : encoding.getName(glyphCode);
        } else if (font instanceof PDType0Font) {
            try {
                FontProgram pr = font.getFontProgram();
                if (pr == null) {
                    this.name = null;
                } else {
                    pr.parseFont();
                    if (glyphCode == 0 || !font.glyphIsPresent(glyphCode)) {
                        this.name = ".notdef";
                    } else {
                        this.name = null;
                    }
                }
            } catch (IOException e) {
                LOGGER.log(Level.FINE, "Can't convert code to glyph", e);
                this.name = null;
            }
        }
        if (StaticContainers.getFlavour().getPart() == PDFAFlavour.Specification.ISO_19005_1) {
            this.toUnicode = getToUnicodePDFA1(font, glyphCode);
        } else {
            this.toUnicode = font.toUnicode(glyphCode);
        }
        getactualTextPresent();
        this.id = id;
    }

    public static Glyph getGlyph(PDFont font, int glyphCode, int renderingMode,
                                 GFOpMarkedContent markedContent, StructureElementAccessObject structureElementAccessObject) {
        String id = GFIDGenerator.generateID(font.getDictionary().hashCode(),
                font.getName(), glyphCode, renderingMode, markedContent, structureElementAccessObject);
        Glyph cachedGlyph = StaticContainers.cachedGlyphs.get(id);
        if (cachedGlyph == null) {
            if (font.getSubtype() == ASAtom.CID_FONT_TYPE0 || font.getSubtype() == ASAtom.CID_FONT_TYPE2 ||
                    font.getSubtype() == ASAtom.TYPE0) {
                cachedGlyph = new GFCIDGlyph(font, glyphCode, renderingMode, id,
                        markedContent, structureElementAccessObject);
            } else {
                cachedGlyph = new GFGlyph(font, glyphCode, GLYPH_TYPE, renderingMode, id,
                        markedContent, structureElementAccessObject);
            }
            StaticContainers.cachedGlyphs.put(id, cachedGlyph);
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
        this.widthsConsistent = checkWidths(glyphCode, font);
    }

    private void initForNotType3(boolean fontProgramIsInvalid, FontProgram fontProgram,
                                 PDFont font, int glyphCode) {
        try {
            glyphPresent = null;
            widthsConsistent = null;
            if (!fontProgramIsInvalid) {
                fontProgram.parseFont();
                // every font contains notdef glyph. But if we call method
                // of font program we can't distinguish case of code 0
                // and glyph that is not present indeed.
                glyphPresent = glyphCode == 0 ? true :
                        Boolean.valueOf(font.glyphIsPresent(glyphCode));
                widthsConsistent = checkWidths(glyphCode, font);
            }
        } catch (IOException e) {
            LOGGER.log(Level.FINE, "Error in parsing font program", e);
            StaticContainers.validPDF = false;
        }
    }

    private static Boolean checkWidths(int glyphCode, org.verapdf.pd.font.PDFont font) {
        Double fontWidth = font.getWidth(glyphCode);
        double expectedWidth = fontWidth == null ? 0 : fontWidth.doubleValue();
        double foundWidth = font.getWidthFromProgram(glyphCode);
        if (foundWidth == -1) {
            foundWidth = font.getDefaultWidth() == null ? 0 : font.getDefaultWidth().doubleValue();
        }
        // consistent is defined to be a difference of no more than 1/1000 unit.
        return Math.abs(foundWidth - expectedWidth) > 1 ? Boolean.FALSE : Boolean.TRUE;
    }

    @Override
    public String getname() {
        return this.name;
    }

    @Override
    public Boolean getisWidthConsistent() {
        return this.widthsConsistent;
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
        if (toUnicode == null) {
            return false;
        }
        for (int i = 0; i < toUnicode.length(); ++i) {
            int unicode = this.toUnicode.codePointAt(i);
            if ((unicode >= UNICODE_PRIVATE_USE_AREA_ARRAY[0] &&
                    unicode <= UNICODE_PRIVATE_USE_AREA_ARRAY[1]) ||
                    (unicode >= UNICODE_PRIVATE_USE_AREA_ARRAY[2] &&
                            unicode <= UNICODE_PRIVATE_USE_AREA_ARRAY[3]) ||
                    (unicode >= UNICODE_PRIVATE_USE_AREA_ARRAY[4] &&
                            unicode <= UNICODE_PRIVATE_USE_AREA_ARRAY[5])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean getactualTextPresent() {
        return MarkedContentHelper.containsActualText(markedContent, structureElementAccessObject);
    }
}