/**
 * This file is part of validation-model, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * validation-model is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with validation-model as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * validation-model as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.pd;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSKey;
import org.verapdf.cos.COSObject;
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
        COSObject obj = simplePDObject.getKey(ASAtom.DEST_OUTPUT_PROFILE);
        if (!obj.empty() && obj.isIndirect().booleanValue()) {
            COSKey key = obj.getKey();
            return String.valueOf(key.getNumber() + " " + key.getGeneration());
        }
        return null;
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
}
