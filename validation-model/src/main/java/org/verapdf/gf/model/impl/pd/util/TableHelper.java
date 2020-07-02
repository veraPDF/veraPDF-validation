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
package org.verapdf.gf.model.impl.pd.util;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.tools.TaggedPDFConstants;

public class TableHelper {

    public static Long getColSpan(org.verapdf.pd.PDObject simplePDObject) {
        return TableHelper.getSpanValue(simplePDObject, ASAtom.COL_SPAN);
    }

    public static Long getRowSpan(org.verapdf.pd.PDObject simplePDObject) {
        return TableHelper.getSpanValue(simplePDObject, ASAtom.ROW_SPAN);
    }

    private static Long getSpanValue(org.verapdf.pd.PDObject simplePDObject, ASAtom spanName) {
        Long defaultValue = 1L;
        COSObject aValue = simplePDObject.getKey(ASAtom.A);
        if (aValue == null) {
            return defaultValue;
        }
        if (aValue.getType() == COSObjType.COS_ARRAY) {
            for (COSObject object : (COSArray) aValue.getDirectBase()) {
                Long spanValue = getSpanValue(object, spanName);
                if (spanValue != null) {
                    return spanValue;
                }
            }
        }
        Long spanValue = getSpanValue(aValue, spanName);
        return spanValue != null ? spanValue : defaultValue;
    }

    private static Long getSpanValue(COSObject object, ASAtom spanName) {
        if (object.getType() == COSObjType.COS_DICT && TaggedPDFConstants.TABLE.equals(object.getStringKey(ASAtom.O))) {
            return object.getIntegerKey(spanName);
        }
        return null;
    }
}
