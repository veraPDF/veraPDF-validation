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
package org.verapdf.gf.model.impl.external;

import org.verapdf.model.external.TrueTypeFontProgram;
import org.verapdf.pd.font.FontProgram;
import org.verapdf.pd.font.opentype.OpenTypeFontProgram;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Instance of this class represents TrueType font program embedded into PDF
 * document.
 *
 * @author Sergey Shemyakov
 */
public class GFTrueTypeFontProgram extends GFFontProgram implements TrueTypeFontProgram {

    private static final Logger LOGGER = Logger.getLogger(GFTrueTypeFontProgram.class.getCanonicalName());

    private org.verapdf.pd.font.truetype.TrueTypeFontProgram trueTypeFont;

    /**
     * Type name for GFTrueTypeFontProgram
     */
    public static final String TRUE_TYPE_PROGRAM_TYPE = "TrueTypeFontProgram";

    public GFTrueTypeFontProgram(FontProgram trueTypeFont) {
        super(TRUE_TYPE_PROGRAM_TYPE);
        try {
            if (trueTypeFont instanceof OpenTypeFontProgram) {
                this.trueTypeFont = (org.verapdf.pd.font.truetype.TrueTypeFontProgram)
                        ((OpenTypeFontProgram) trueTypeFont).getFont();
            } else {
                this.trueTypeFont = (org.verapdf.pd.font.truetype.TrueTypeFontProgram) trueTypeFont;
            }
            this.trueTypeFont.parseFont();
        } catch (IOException e) {
            LOGGER.log(Level.FINE, "Error in parsing embedded True Type font file", e);
        }
    }

    /**
     * @return true / false if the corresponding PDF Font is marked as
     * symbolic / non-symbolic in its font dictionary.
     */
    @Override
    public Boolean getisSymbolic() {
        return Boolean.valueOf(this.trueTypeFont.isSymbolic());
    }

    /**
     * @return number of cmap subtables in the font program.
     */
    @Override
    public Long getnrCmaps() {
        return new Long(this.trueTypeFont.getNrOfCMaps());
    }

    /**
     * @return true if the font program contains the Microsoft Symbol
     * (3,0 – Platform ID=3, Encoding ID=0) cmap subtable.
     */
    @Override
    public Boolean getcmap30Present() {
    	return this.trueTypeFont.isCmapPresent(3, 0);
    }

    /**
     * @return true if the font program contains the Microsoft Symbol
     * (3,1 – Platform ID=3, Encoding ID=1) cmap subtable.
     */
    @Override
    public Boolean getcmap31Present() {
        return Boolean.valueOf(this.trueTypeFont.isCmapPresent(3, 1));
    }

    /**
     * @return true if the font program contains the Microsoft Symbol
     * (1,0 – Platform ID=1, Encoding ID=0) cmap subtable.
     */
    @Override
    public Boolean getcmap10Present() {
        return Boolean.valueOf(this.trueTypeFont.isCmapPresent(1, 0));
    }

}
