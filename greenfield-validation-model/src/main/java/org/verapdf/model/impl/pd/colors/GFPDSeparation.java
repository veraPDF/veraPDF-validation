package org.verapdf.model.impl.pd.colors;

import org.verapdf.cos.COSName;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosUnicodeName;
import org.verapdf.model.factory.colors.ColorSpaceFactory;
import org.verapdf.model.impl.containers.StaticContainers;
import org.verapdf.model.impl.cos.GFCosUnicodeName;
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
        if (StaticContainers.separations.containsKey(name)) {
            StaticContainers.separations.get(name).add(this);
        } else {
            final List<GFPDSeparation> separationList = new ArrayList<>();
            separationList.add(this);
            StaticContainers.separations.put(name, separationList);
        }
    }

    @Override
    public Boolean getareTintAndAlternateConsistent() {
        String name = ((org.verapdf.pd.colors.PDSeparation) simplePDObject).getColorantName().getString();

        if (StaticContainers.inconsistentSeparations.contains(name)) {
            return Boolean.FALSE;
        }

        if (StaticContainers.separations.get(name).size() > 1) {
            for (GFPDSeparation gfPDSeparation : StaticContainers.separations.get(name)) {
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
                    StaticContainers.inconsistentSeparations.add(name);
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
            list.add(new GFCosUnicodeName((COSName) name.get()));
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }
}
