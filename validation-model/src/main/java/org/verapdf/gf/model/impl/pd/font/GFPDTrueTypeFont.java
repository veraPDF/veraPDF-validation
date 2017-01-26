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
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.factory.operators.RenderingMode;
import org.verapdf.model.pdlayer.PDTrueTypeFont;
import org.verapdf.pd.font.FontProgram;
import org.verapdf.pd.font.opentype.OpenTypeFontProgram;
import org.verapdf.pd.font.truetype.AdobeGlyphList;
import org.verapdf.pd.font.truetype.TrueTypeFontProgram;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents TrueType font dictionary.
 *
 * @author Sergey Shemyakov
 */
public class GFPDTrueTypeFont extends GFPDSimpleFont implements PDTrueTypeFont {

    private static final Logger LOGGER = Logger.getLogger(GFPDTrueTypeFont.class.getCanonicalName());

    public static final String TRUETYPE_FONT_TYPE = "PDTrueTypeFont";

    public GFPDTrueTypeFont(org.verapdf.pd.font.truetype.PDTrueTypeFont font,
                            RenderingMode renderingMode) {
        super(font, renderingMode, TRUETYPE_FONT_TYPE);
        if (font != null) {
            FontProgram program = font.getFontProgram();
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
     * @return true if all glyph names in the differences array of the Encoding
     * dictionary are a part of the Adobe Glyph List and the embedded font
     * program contains the Microsoft Unicode (3,1 - Platform ID=3,
     * Encoding ID=1) cmap subtable.
     */
    @Override
    public Boolean getdifferencesAreUnicodeCompliant() {
        if (!fontProgramParsed) {
            return Boolean.valueOf(false);
        }

        FontProgram font = this.pdFont.getFontProgram();
        if ((font instanceof OpenTypeFontProgram)) {
            font = ((OpenTypeFontProgram) font).getFont();
        }
        if (!((TrueTypeFontProgram) font).isCmapPresent(3, 1)) {
            return Boolean.valueOf(false);
        }
        COSObject encoding = this.pdFont.getEncoding();
        if (!encoding.empty() && encoding.getType() != COSObjType.COS_NAME) {
            COSObject differences = encoding.getKey(ASAtom.DIFFERENCES);
            if (!differences.empty()) {
                for (COSObject diff : (COSArray) differences.getDirectBase()) {
                    if (diff.getType() == COSObjType.COS_NAME &&
                            !AdobeGlyphList.contains(diff.getString())) {
                        return Boolean.valueOf(false);
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
        return Boolean.valueOf(false);
    }
}
