package org.verapdf.gf.model.impl.operator.markedcontent;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.pd.structure.PDStructTreeRoot;
import org.verapdf.pd.structure.StructureElementAccessObject;

/**
 * @author Sergey Shemyakov
 */
public class MarkedContentHelper {

    public static boolean containsActualText(GFOpMarkedContent markedContent,
                                             StructureElementAccessObject accessObject) {
        if (markedContent != null) {
            if (markedContent.getActualText() != null) {
                return true;
            }

            Long mcid = markedContent.getMCID();
            PDStructTreeRoot structTreeRoot = StaticContainers.getDocument().getStructTreeRoot();
            if (structTreeRoot != null) {
                PDNumberTreeNode parentTreeRoot = structTreeRoot.getParentTree();
                COSObject structureElement = accessObject.getStructureElement(parentTreeRoot, mcid);
                if (structureElement != null && !structureElement.empty()) {
                    COSObject actualText = structureElement.getKey(ASAtom.ACTUAL_TEXT);
                    return actualText != null && !actualText.empty() &&
                            actualText.getType() == COSObjType.COS_STRING;
                }
            }
        }
        return false;
    }

}
