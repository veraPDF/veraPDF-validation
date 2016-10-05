package org.verapdf.model.impl.pd.signature;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSObject;
import org.verapdf.model.impl.pd.GFPDObject;
import org.verapdf.model.pdlayer.PDPerms;

import java.util.Set;

/**
 * Represents permissions dictionary referred by /Perms key from the document
 * catalog.
 *
 * @author Sergey Shemyakov
 */
public class GFPDPerms extends GFPDObject implements PDPerms {

    /**
     * Type name for {@code GFPDPerms}
     */
    public static final String PERMS_TYPE = "PDPerms";

    private static final ASAtom UC3 = ASAtom.getASAtom("UC3");
    public static final ASAtom DOC_MDP = ASAtom.getASAtom("DocMDP");

    /**
     * @param dictionary is permissions dictionary.
     */
    public GFPDPerms(COSObject dictionary) {
        super(dictionary, PERMS_TYPE);
    }

    /**
     * @return true if the permissions dictionary contains entries other than
     * DocMDP and UC3.
     */
    @Override
    public Boolean getcontainsOtherEntries() {
        if (!this.simpleCOSObject.empty()) {
            Set<ASAtom> names = this.simpleCOSObject.get().getKeySet();
            for (ASAtom name : names) {
                if (name != UC3 && name != DOC_MDP) {
                    return true;
                }
            }
        }
        return false;
    }

}
