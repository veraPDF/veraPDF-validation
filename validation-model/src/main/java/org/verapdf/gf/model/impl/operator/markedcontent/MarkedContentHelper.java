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
package org.verapdf.gf.model.impl.operator.markedcontent;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.pd.structure.PDStructTreeRoot;
import org.verapdf.pd.structure.StructureElementAccessObject;
import org.verapdf.tools.StaticResources;

/**
 * @author Sergey Shemyakov
 */
public class MarkedContentHelper {

    public static boolean containsStringKey(ASAtom key, GFOpMarkedContent markedContent,
                                            StructureElementAccessObject accessObject) {
        if (markedContent != null) {
            if (markedContent.getInheritedStringAttribute(key) != null) {
                return true;
            }

            PDStructTreeRoot structTreeRoot = StaticResources.getDocument().getStructTreeRoot();
            if (structTreeRoot != null) {
                PDNumberTreeNode parentTreeRoot = structTreeRoot.getParentTree();
                if (parentTreeRoot != null) {
                    Long mcid = markedContent.getInheritedMCID();
                    COSObject structureElement = accessObject.getStructureElement(parentTreeRoot, mcid);
                    if (structureElement != null && !structureElement.empty()) {
                        COSObject value = structureElement.getKey(key);
                        return value != null && !value.empty() &&
                               value.getType() == COSObjType.COS_STRING;
                    }
                }
            }
        }
        return false;
    }

}
