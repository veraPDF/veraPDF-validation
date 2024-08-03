/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2024, veraPDF Consortium <info@verapdf.org>
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
package org.verapdf.gf.model.impl.pd;

import org.verapdf.as.ASAtom;
import org.verapdf.external.ICCProfile;
import org.verapdf.gf.model.impl.external.GFICCOutputProfile;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.external.ICCOutputProfile;
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

    public GFPDOutputIntent(org.verapdf.pd.PDOutputIntent simplePDObject) {
        super(simplePDObject, OUTPUT_INTENT_TYPE);
    }

    @Override
    public String getdestOutputProfileIndirect() {
        return ((org.verapdf.pd.PDOutputIntent) simplePDObject).getDestOutputProfileIndirect();
    }

    @Override
    public String getS() {
        org.verapdf.pd.PDOutputIntent outInt =
                (org.verapdf.pd.PDOutputIntent) simplePDObject;
        return outInt.getSubtype();
    }

    @Override
    public String getOutputConditionIdentifier() {
        org.verapdf.pd.PDOutputIntent outInt =
                (org.verapdf.pd.PDOutputIntent) simplePDObject;
        return outInt.getOutputConditionIdentifier();
    }

    @Override
    public Boolean getcontainsDestOutputProfileRef() {
        return this.simplePDObject.knownKey(ASAtom.DEST_OUTPUT_PROFILE_REF);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case DEST_PROFILE:
                return this.getDestProfile();
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

    @Override
    public String getICCProfileMD5() {
        ICCProfile iccProfile = ((org.verapdf.pd.PDOutputIntent) simplePDObject).getDestOutputProfile();
        return iccProfile != null ? iccProfile.getMD5() : null;
    }

}
