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
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.factory.operators.RenderingMode;
import org.verapdf.model.pdlayer.PDSimpleFont;

/**
 * Represents one of the simple font types (Type 1, TrueType, Type 3).
 *
 * @author Sergey Shemyakov
 */
public abstract class GFPDSimpleFont extends GFPDFont implements PDSimpleFont {

    protected GFPDSimpleFont(org.verapdf.pd.font.PDSimpleFont font,
                             RenderingMode renderingMode, final String type) {
        super(font, renderingMode, type);
    }

    /**
     * @return true if the font is one of the 14 standard fonts defined in PDF
     * 1.4 Reference.
     */
    @Override
    public abstract Boolean getisStandard();

    /**
     * @return FirstChar entry; null if LastChar entry is not present or has
     * invalid type.
     */
    @Override
    public Long getFirstChar() {
        return this.pdFont.getFirstChar();
    }

    /**
     * @return LastChar entry; null if LastChar entry is not present or has
     * invalid type.
     */
    @Override
    public Long getLastChar() {
        return this.pdFont.getLastChar();
    }

    /**
     * @return The size of the Widths array; null if the Widths array is not
     * present or has invalid type.
     */
    @Override
    public Long getWidths_size() {
        COSObject widths = this.pdFont.getWidths();
        if (widths.empty() || widths.getType() != COSObjType.COS_ARRAY) {
            return null;
        }
        return Long.valueOf((widths.getDirectBase()).size().longValue());
    }

    /**
     * @return String representation of the font encoding:
     * null if the /Encoding entry is not present in the font dictionary;
     * if /Encoding entry in the font dictionary of Name type, then
     * the value of this entry;
     * if /Encoding entry is a dictionary, which does not contain /Differences
     * array, then the value of /BaseEncoding entry in this dictionary
     * (or null, if /BaseEncoding is also not present);
     */
    @Override
    public String getEncoding() {
        COSObject encoding = this.pdFont.getEncoding();
        if (encoding.empty()) {
            return null;
        }
        if (encoding.getType() == COSObjType.COS_NAME) {
            return encoding.getString();
        }
        return encoding.getKey(ASAtom.BASE_ENCODING).getString();
    }

    @Override
    public Boolean getcontainsDifferences() {
        COSObject encoding = this.pdFont.getEncoding();
        return encoding.getType() == COSObjType.COS_DICT && encoding.knownKey(ASAtom.DIFFERENCES);
    }
}
