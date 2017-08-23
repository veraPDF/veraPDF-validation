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

    public GFGlyph(Boolean glyphPresent, Boolean widthsConsistent, PDFont font, int glyphCode, int renderingMode,
                   GFOpMarkedContent markedContent, StructureElementAccessObject structureElementAccessObject) {
        this(glyphPresent, widthsConsistent, font, glyphCode, GLYPH_TYPE,
                renderingMode, markedContent, structureElementAccessObject);
    }

    public GFGlyph(Boolean glyphPresent, Boolean widthsConsistent, PDFont font, int glyphCode, String type, int renderingMode,
                   GFOpMarkedContent markedContent, StructureElementAccessObject structureElementAccessObject) {
        super(type);
        this.glyphPresent = glyphPresent;
        this.widthsConsistent = widthsConsistent;
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
            if (font instanceof PDType3Font) {
                this.toUnicode = font.cMapToUnicode(glyphCode);
            } else if (font instanceof org.verapdf.pd.font.type1.PDType1Font) {
                this.toUnicode = ((org.verapdf.pd.font.type1.PDType1Font) font).toUnicodePDFA1(glyphCode);
            }
        } else {
            this.toUnicode = font.toUnicode(glyphCode);
        }
        getactualTextPresent();
        this.id = GFIDGenerator.generateID(font.getDictionary().hashCode(),
                font.getName(), glyphCode, renderingMode);
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
                            unicode <= UNICODE_PRIVATE_USE_AREA_ARRAY[5])){
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