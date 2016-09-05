package org.verapdf.model.impl.pd;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSKey;
import org.verapdf.cos.COSObject;
import org.verapdf.external.ICCProfile;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosObject;
import org.verapdf.model.external.ICCOutputProfile;
import org.verapdf.model.impl.cos.GFCosObject;
import org.verapdf.model.impl.external.GFICCOutputProfile;
import org.verapdf.model.pdlayer.PDOutputIntent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDOutputIntent extends GFPDObject implements PDOutputIntent {

    public static final String OUTPUT_INTENT_TYPE = "PDOutputIntent";

    public static final String DEST_PROFILE = "destProfile";
    public static final String DEST_OUTPUT_PROFILE_REF = "DestOutputProfileRef";

    public GFPDOutputIntent(org.verapdf.pd.PDOutputIntent simplePDObject) {
        super(simplePDObject, OUTPUT_INTENT_TYPE);
    }

    @Override
    public String getdestOutputProfileIndirect() {
        COSObject obj = simplePDObject.getKey(ASAtom.DEST_OUTPUT_PROFILE);
        if (obj.isIndirect()) {
            COSKey key = obj.getKey();
            return String.valueOf(key.getNumber() + " " + key.getGeneration());
        }
        return null;
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case DEST_PROFILE:
                return this.getDestProfile();
            case DEST_OUTPUT_PROFILE_REF:
                return this.getDestOutputProfileRef();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<ICCOutputProfile> getDestProfile() {
        ICCProfile iccProfile = ((org.verapdf.pd.PDOutputIntent) simplePDObject).getDestOutputProfile();
        if (iccProfile != null) {
            List<ICCOutputProfile> profile = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            String subtype = ((org.verapdf.pd.PDOutputIntent) simplePDObject).getSubtype();
            profile.add(new GFICCOutputProfile(iccProfile, subtype));
            return Collections.unmodifiableList(profile);
        }
        return Collections.emptyList();
    }

    private List<CosObject> getDestOutputProfileRef() {
        COSObject ref = ((org.verapdf.pd.PDOutputIntent) simplePDObject).getCOSDestOutputProfileRef();
        CosObject value = ref == null ? null : GFCosObject.getFromValue(ref.get());
        if (value != null) {
            ArrayList<CosObject> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            list.add(value);
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }
}
