package org.verapdf.gf.model.impl.operator.pathconstruction;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_y;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_y extends GFOpPathConstruction implements Op_y {

	/** Type name for {@code GFOp_y} */
    public static final String OP_Y_TYPE = "Op_y";

    public GFOp_y(List<COSBase> arguments) {
        super(arguments, OP_Y_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (CONTROL_POINTS.equals(link)) {
            return this.getControlPoints();
        }
        return super.getLinkedObjects(link);
    }

    private List<CosNumber> getControlPoints() {
        return this.getListOfNumbers();
    }

}
