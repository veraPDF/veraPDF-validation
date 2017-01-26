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
package org.verapdf.gf.model.impl.pd.font;

import org.verapdf.as.ASAtom;
import org.verapdf.gf.model.factory.operators.RenderingMode;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.model.pdlayer.PDType1Font;
import org.verapdf.pd.font.FontProgram;
import org.verapdf.pd.font.cff.CFFFontProgram;
import org.verapdf.pd.font.cff.CFFType1FontProgram;
import org.verapdf.pd.font.opentype.OpenTypeFontProgram;
import org.verapdf.pd.font.type1.Type1FontProgram;

import java.io.IOException;
import java.util.Set;
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
                    LOGGER.log(Level.WARNING, "Can't parse font program of font " + pdFont.getName(), e);
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
        String[] fontProgramCharSet;
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
            fontProgramCharSet = new String[] {};
        }
        if (!(descriptorCharSet.size() == fontProgramCharSet.length ||
            descriptorCharSet.size() == fontProgramCharSet.length - 1) ) {
            return Boolean.valueOf(false);
        }
        for (String glyphName : fontProgramCharSet) {
            if (!glyphName.equals(NOTDEF_STRING) &&
                    !descriptorCharSet.contains(glyphName)) {
                return Boolean.valueOf(false);
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
