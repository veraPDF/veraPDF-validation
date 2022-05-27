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

public class AttributeHelper {

    public static Long getColSpan(org.verapdf.pd.PDObject simplePDObject) {
        return AttributeHelper.getIntegerAttributeValue(simplePDObject, ASAtom.COL_SPAN, TaggedPDFConstants.TABLE, 1L);
    }

    public static Long getRowSpan(org.verapdf.pd.PDObject simplePDObject) {
        return AttributeHelper.getIntegerAttributeValue(simplePDObject, ASAtom.ROW_SPAN, TaggedPDFConstants.TABLE, 1L);
    }

    public static String getScope(org.verapdf.pd.PDObject simplePDObject) {
        return AttributeHelper.getNameAttributeValue(simplePDObject, ASAtom.SCOPE, TaggedPDFConstants.TABLE, null);
    }

    public static COSArray getArrayAttributeValue(org.verapdf.pd.PDObject simplePDObject, ASAtom attributeName, String O,
                                                   COSArray defaultValue) {
        COSObject object = getAttributeValue(simplePDObject, attributeName, O, COSObjType.COS_ARRAY);
        if (object.getType() == COSObjType.COS_ARRAY) {
            return (COSArray) object.getDirectBase();
        }
        return defaultValue;
    }

    private static String getNameAttributeValue(org.verapdf.pd.PDObject simplePDObject, ASAtom attributeName, String O,
                                                  String defaultValue) {
        COSObject object = getAttributeValue(simplePDObject, attributeName, O, COSObjType.COS_NAME);
        if (object.getType() == COSObjType.COS_NAME) {
            return object.getString();
        }
        return defaultValue;
    }

    private static Long getIntegerAttributeValue(org.verapdf.pd.PDObject simplePDObject, ASAtom attributeName, String O,
                                                 Long defaultValue) {
        COSObject object = getAttributeValue(simplePDObject, attributeName, O, COSObjType.COS_INTEGER);
        if (object.getType() == COSObjType.COS_INTEGER) {
            return object.getInteger();
        }
        return defaultValue;
    }

    private static COSObject getAttributeValue(org.verapdf.pd.PDObject simplePDObject, ASAtom attributeName, String O,
                                          COSObjType type) {
        COSObject aValue = simplePDObject.getKey(ASAtom.A);
        if (aValue == null) {
            return COSObject.getEmpty();
        }
        if (aValue.getType() == COSObjType.COS_ARRAY) {
            for (COSObject object : (COSArray) aValue.getDirectBase()) {
                COSObject value = getAttributeValue(object, attributeName, O);
                if (value.getType() == type) {
                    return value;
                }
            }
        }
        COSObject value = getAttributeValue(aValue, attributeName, O);
        return value.getType() == type ? value : COSObject.getEmpty();
    }

    private static COSObject getAttributeValue(COSObject object, ASAtom attributeName, String O) {
        if (object.getType() == COSObjType.COS_DICT && O.equals(object.getStringKey(ASAtom.O))) {
            return object.getKey(attributeName);
        }
        return COSObject.getEmpty();
    }
}
