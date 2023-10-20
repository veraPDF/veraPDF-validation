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
package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSKey;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.pd.GFPDStructElem;
import org.verapdf.model.selayer.SEFENote;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.AttributeHelper;
import org.verapdf.tools.TaggedPDFConstants;

import java.util.*;

public class GFSEFENote extends GFPDStructElem implements SEFENote {

    public static final String FE_NOTE_STRUCTURE_ELEMENT_TYPE = "SEFENote";

    @Override
    public String getorphanRefs() {
        COSKey key = simpleCOSObject.getKey();
        if (key == null) {
            return null;
        }
        Set<COSKey> set = StaticContainers.getStructElementsRefs().get(key);
        if (set == null) {
            return null;
        }
        COSObject ref = ((PDStructElem)simplePDObject).getRef();
        Set<COSKey> refsKeys = new HashSet<>();
        if (ref.getType() == COSObjType.COS_ARRAY) {
            for (COSObject elem : (COSArray) ref.getDirectBase()) {
                COSKey elementKey = elem.getKey();
                if (elementKey != null) {
                    refsKeys.add(elementKey);
                }
            }
        }
        Set<String> keys = new HashSet<>();
        for (COSKey refKey : set) {
            if (!refsKeys.contains(refKey)) {
                keys.add(refKey.toString());
            }
        }
        if (!keys.isEmpty()) {
            return String.join(",", keys);
        }
        return null;
    }

    public GFSEFENote(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.FENOTE, FE_NOTE_STRUCTURE_ELEMENT_TYPE);
    }

    @Override
    public String getNoteType() {
        return AttributeHelper.getNoteType(simplePDObject);
    }
}
