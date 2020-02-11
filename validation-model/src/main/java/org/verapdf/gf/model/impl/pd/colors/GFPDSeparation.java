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
package org.verapdf.gf.model.impl.pd.colors;

import org.verapdf.cos.COSName;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.factory.colors.ColorSpaceFactory;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.cos.GFCosUnicodeName;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosUnicodeName;
import org.verapdf.model.pdlayer.PDColorSpace;
import org.verapdf.model.pdlayer.PDSeparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDSeparation extends GFPDColorSpace implements PDSeparation {
    public static final String SEPARATION_TYPE = "PDSeparation";

    public static final String ALTERNATE = "alternate";
    public static final String COLORANT_NAME = "colorantName";

    public GFPDSeparation(org.verapdf.pd.colors.PDSeparation simplePDObject) {
        super(simplePDObject, SEPARATION_TYPE);
        String name = simplePDObject.getColorantName().getString();
        if (StaticContainers.getSeparations().containsKey(name)) {
            StaticContainers.getSeparations().get(name).add(this);
        } else {
            final List<GFPDSeparation> separationList = new ArrayList<>();
            separationList.add(this);
            StaticContainers.getSeparations().put(name, separationList);
        }
    }

    @Override
    public Boolean getareTintAndAlternateConsistent() {
        String name = ((org.verapdf.pd.colors.PDSeparation) simplePDObject).getColorantName().getString();

        if (StaticContainers.getInconsistentSeparations().contains(name)) {
            return Boolean.FALSE;
        }

        if (StaticContainers.getSeparations().get(name).size() > 1) {
            for (GFPDSeparation gfPDSeparation : StaticContainers.getSeparations().get(name)) {
                if (gfPDSeparation.equals(this)) {
                    continue;
                }

                COSObject alternateSpaceToCompare =
                        ((org.verapdf.pd.colors.PDSeparation) gfPDSeparation.simplePDObject).getAlternate().getObject();
                COSObject tintTransformToCompare =
                        ((org.verapdf.pd.colors.PDSeparation) gfPDSeparation.simplePDObject).getTintTransform();

                COSObject alternateSpaceCurrent =
                        ((org.verapdf.pd.colors.PDSeparation) simplePDObject).getAlternate().getObject();
                COSObject tintTransformCurrent =
                        ((org.verapdf.pd.colors.PDSeparation) simplePDObject).getTintTransform();

                if (!alternateSpaceToCompare.equals(alternateSpaceCurrent) || !tintTransformToCompare.equals(tintTransformCurrent)) {
                    StaticContainers.getInconsistentSeparations().add(name);
                    return Boolean.FALSE;
                }
            }
        }

        return Boolean.TRUE;
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case ALTERNATE:
                return this.getAlternate();
            case COLORANT_NAME:
                return this.getColorantName();
            default:
                return super.getLinkedObjects(link);
        }
    }

    /**
     * @return a {@link List} of alternate {@link PDColorSpace} objects
     */
    public List<PDColorSpace> getAlternate() {
        org.verapdf.pd.colors.PDColorSpace space =
                ((org.verapdf.pd.colors.PDSeparation) this.simplePDObject).getAlternate();
        PDColorSpace currentSpace = ColorSpaceFactory.getColorSpace(space);
        if (currentSpace != null) {
            List<PDColorSpace> colorSpace = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            colorSpace.add(currentSpace);
            return Collections.unmodifiableList(colorSpace);
        }
        return Collections.emptyList();
    }

    private List<CosUnicodeName> getColorantName() {
        COSObject name = ((org.verapdf.pd.colors.PDSeparation) this.simplePDObject).getColorantName();
        if (name.getType() == COSObjType.COS_NAME) {
            List<CosUnicodeName> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            list.add(new GFCosUnicodeName((COSName) name.getDirectBase()));
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }
}
