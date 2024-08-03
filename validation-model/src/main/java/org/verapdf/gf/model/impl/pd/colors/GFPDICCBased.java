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
package org.verapdf.gf.model.impl.pd.colors;

import org.verapdf.as.ASAtom;
import org.verapdf.external.ICCProfile;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.external.GFICCInputProfile;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.external.ICCInputProfile;
import org.verapdf.model.pdlayer.PDICCBased;
import org.verapdf.pd.colors.PDColorSpace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Maksim Bezrukov
 */
public class GFPDICCBased extends GFPDColorSpace implements PDICCBased {

    private static final Logger LOGGER = Logger.getLogger(GFPDICCBased.class.getCanonicalName());

    public static final String ICC_BASED_TYPE = "PDICCBased";

    public static final String ICC_PROFILE = "iccProfile";

    public GFPDICCBased(org.verapdf.pd.colors.PDICCBased simplePDObject) {
        this(simplePDObject, ICC_BASED_TYPE);
    }

    protected GFPDICCBased(org.verapdf.pd.colors.PDICCBased simplePDObject, String type) {
        super(simplePDObject, type);
        checkAlternateComponentsNumber();
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

    @Override
    public String getICCProfileMD5() {
        return ((org.verapdf.pd.colors.PDICCBased) simplePDObject).getICCProfileMD5();
    }

    @Override
    public String getcurrentTransparencyProfileIndirect() {
        PDColorSpace currentColorSpace = StaticContainers.getCurrentTransparencyColorSpace();
        if (currentColorSpace != null && ASAtom.ICCBASED.equals(currentColorSpace.getType())) {
            return ((org.verapdf.pd.colors.PDICCBased)currentColorSpace).getICCProfileIndirect();
        }
        return null;
    }

    @Override
    public String getcurrentTransparencyICCProfileMD5() {
        PDColorSpace currentColorSpace = StaticContainers.getCurrentTransparencyColorSpace();
        if (currentColorSpace != null && ASAtom.ICCBASED.equals(currentColorSpace.getType())) {
            return ((org.verapdf.pd.colors.PDICCBased)currentColorSpace).getICCProfileMD5();
        }
        return null;
    }

    private void checkAlternateComponentsNumber() {
        org.verapdf.pd.colors.PDICCBased colorSpace = ((org.verapdf.pd.colors.PDICCBased) simplePDObject);
        PDColorSpace alternate = colorSpace.getAlternate();
        if (alternate != null && colorSpace.getNumberOfComponents() != alternate.getNumberOfComponents()) {
            LOGGER.warning("Alternate color space does not match the number of components in the ICC profile");
        }

    }

    @Override
    public String getICCProfileIndirect() {
        return ((org.verapdf.pd.colors.PDICCBased) simplePDObject).getICCProfileIndirect();
    }
}
