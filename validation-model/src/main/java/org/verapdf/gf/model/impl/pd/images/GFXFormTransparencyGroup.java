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
package org.verapdf.gf.model.impl.pd.images;

import org.verapdf.as.ASAtom;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.pdlayer.XFormTransparencyGroup;
import org.verapdf.pd.colors.PDColorSpace;

/**
 * @author Maxim Plushchov
 */
public class GFXFormTransparencyGroup extends GenericModelObject implements XFormTransparencyGroup {

    protected PDColorSpace colorSpace;

    public static final String XFORM_TRANSPARENCY_GROUP_TYPE = "XFormTransparencyGroup";

    public GFXFormTransparencyGroup(PDColorSpace colorSpace, String type) {
        super(type);
        this.colorSpace = colorSpace;
    }

    public GFXFormTransparencyGroup(PDColorSpace colorSpace) {
        this(colorSpace, XFORM_TRANSPARENCY_GROUP_TYPE);
    }

    @Override
    public String getcolorSpaceType() {
        if (colorSpace == null) {
            return null;
        }
        if (ASAtom.ICCBASED.equals(colorSpace.getType())) {
            return ((org.verapdf.pd.colors.PDICCBased)colorSpace).getColorSpaceType();
        }
        return colorSpace.getType().getValue();
    }
}


