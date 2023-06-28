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
package org.verapdf.gf.model.impl.pd;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSName;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.cos.GFCosUnicodeName;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosUnicodeName;
import org.verapdf.model.pdlayer.PDResources;
import org.verapdf.pd.colors.PDColorSpace;
import org.verapdf.pd.colors.PDDeviceN;
import org.verapdf.pd.colors.PDSeparation;
import org.verapdf.pd.font.PDFont;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxim Plushchov
 */
public class GFPDResources extends GFPDObject implements PDResources {

    public static final String RESOURCES_TYPE = "PDResources";

    public static final String RESOURCES_NAMES = "resourcesNames";

    public GFPDResources(org.verapdf.pd.PDResources resources) {
        super(resources, RESOURCES_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case RESOURCES_NAMES:
                return this.getResourcesNames();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<CosUnicodeName> getResourcesNames() {
        List<CosUnicodeName> names = new ArrayList<>();
        org.verapdf.pd.PDResources resources = ((org.verapdf.pd.PDResources)simplePDObject);
        for (ASAtom fontName : resources.getFontNames()) {
            PDFont font = resources.getFont(fontName);
            if (font != null) {
                String name = font.getName();
                if (name != null) {
                    names.add(new GFCosUnicodeName((COSName) COSName.construct(ASAtom.getASAtom(name)).get()));
                }
            }
        }
        for (ASAtom colorName : resources.getColorSpaceNames()) {
            PDColorSpace color = resources.getColorSpace(colorName);
            if (color instanceof PDSeparation) {
                COSObject name = ((PDSeparation) color).getColorantName();
                if (name.getType() == COSObjType.COS_NAME) {
                    names.add(new GFCosUnicodeName((COSName) name.getDirectBase()));
                }
            } else if (color instanceof PDDeviceN) {
                List<COSObject> colorants = ((PDDeviceN) color).getNames();
                for (COSObject colorant : colorants) {
                    if (colorant.getType() == COSObjType.COS_NAME) {
                        names.add(new GFCosUnicodeName((COSName) colorant.getDirectBase()));
                    }
                }
            }
        }
        return names;
    }

}
