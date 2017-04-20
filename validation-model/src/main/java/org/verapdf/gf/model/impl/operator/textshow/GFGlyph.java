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

import org.verapdf.gf.model.tools.GFIDGenerator;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.operator.Glyph;
import org.verapdf.pd.font.*;

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
    private final String id;

    private Boolean glyphPresent;
    private Boolean widthsConsistent;
    private String name;
    private String toUnicode;
    private Long renderingMode;

    public GFGlyph(Boolean glyphPresent, Boolean widthsConsistent, PDFont font, int glyphCode, int renderingMode) {
        this(glyphPresent, widthsConsistent, font, glyphCode, GLYPH_TYPE, renderingMode);
    }

    public GFGlyph(Boolean glyphPresent, Boolean widthsConsistent, PDFont font, int glyphCode, String type, int renderingMode) {
        super(type);
        this.glyphPresent = glyphPresent;
        this.widthsConsistent = widthsConsistent;
        this.renderingMode = Long.valueOf(renderingMode);

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
                    if (glyphCode == 0 || !pr.containsCode(glyphCode)) {
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
        this.toUnicode = font.toUnicode(glyphCode);
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
}
