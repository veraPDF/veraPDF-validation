package org.verapdf.model.impl.pd.colors;

import org.verapdf.external.ICCProfile;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.external.ICCInputProfile;
import org.verapdf.model.impl.external.GFICCInputProfile;
import org.verapdf.model.pdlayer.PDICCBased;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDICCBased extends GFPDColorSpace implements PDICCBased {

    public static final String ICC_BASED_TYPE = "PDICCBased";

    public static final String ICC_PROFILE = "iccProfile";

    public GFPDICCBased(
            org.verapdf.pd.colors.PDICCBased simplePDObject) {
        super(simplePDObject, ICC_BASED_TYPE);
    }

    protected GFPDICCBased(
            org.verapdf.pd.colors.PDICCBased simplePDObject, String type) {
        super(simplePDObject, type);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (ICC_PROFILE.equals(link)) {
            return this.getICCProfile();
        }
        return super.getLinkedObjects(link);
    }

    private List<ICCInputProfile> getICCProfile() {
        ICCProfile iccProfile = ((org.verapdf.pd.colors.PDICCBased) simplePDObject).getICCProfile();
        if (iccProfile != null) {
            List<ICCInputProfile> profiles = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            profiles.add(new GFICCInputProfile(iccProfile));
            return Collections.unmodifiableList(profiles);
        }
        return Collections.emptyList();
    }
}
