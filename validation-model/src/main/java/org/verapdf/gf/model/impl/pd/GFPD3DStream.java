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
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.factory.colors.ColorSpaceFactory;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PD3DStream;
import org.verapdf.model.pdlayer.PDColorSpace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maxim Plushchov
 */
public class GFPD3DStream extends GFPDObject implements PD3DStream {

    public static final String STREAM_3D_TYPE = "PD3DStream";

    public static final String COLOR_SPACE = "colorSpace";

    private final PDResourcesHandler resources;

    public GFPD3DStream(org.verapdf.pd.PD3DStream simplePDObject, PDResourcesHandler resources) {
        super(simplePDObject, STREAM_3D_TYPE);
        this.resources = resources;
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case COLOR_SPACE:
                return getColorSpace();
            default:
                return super.getLinkedObjects(link);
        }
    }

    @Override
    public String getSubtype() {
        return ((org.verapdf.pd.PD3DStream)this.simplePDObject).getSubtype();
    }

    private List<PDColorSpace> getColorSpace() {
        COSObject rawColorSpace = simplePDObject.getKey(ASAtom.COLORSPACE);
        ASAtom colorSpaceName = null;
        org.verapdf.pd.colors.PDColorSpace colorSpace = null;
        if (rawColorSpace != null && !rawColorSpace.empty() && rawColorSpace.getType() != COSObjType.COS_NULL) {
            if (rawColorSpace.getType() == COSObjType.COS_NAME) {
                colorSpaceName = rawColorSpace.getName();
            } else if (rawColorSpace.getType() == COSObjType.COS_ARRAY) {
                COSArray array = (COSArray)rawColorSpace.getDirectBase();
                if (array.size() == 1 && array.at(0).getType() == COSObjType.COS_NAME) {
                    colorSpaceName = array.at(0).getName();
                } else {
                    colorSpace = ColorSpaceFactory.getColorSpace(rawColorSpace, null);
                }
            }
        }
        List<PDColorSpace> colorSpaces = new ArrayList<>(GFPDObject.MAX_NUMBER_OF_ELEMENTS);
        if (colorSpaceName != null) {
            colorSpace = resources.getColorSpace(colorSpaceName);
        }
        if (colorSpace != null) {
            colorSpaces.add(org.verapdf.gf.model.factory.colors.ColorSpaceFactory.getColorSpace(colorSpace));
            return Collections.unmodifiableList(colorSpaces);
        }
        return Collections.emptyList();
    }
}
