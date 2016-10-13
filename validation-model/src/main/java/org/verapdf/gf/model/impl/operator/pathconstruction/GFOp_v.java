package org.verapdf.gf.model.impl.operator.pathconstruction;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_v;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_v extends GFOpPathConstruction implements Op_v {

	/** Type name for {@code GFOp_v} */
    public static final String OP_V_TYPE = "Op_v";

    public GFOp_v(List<COSBase> arguments) {
        super(arguments, OP_V_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(
            String link) {
        if (CONTROL_POINTS.equals(link)) {
            return this.getControlPoints();
        }
        return super.getLinkedObjects(link);
    }

    private List<CosNumber> getControlPoints() {
        return this.getListOfNumbers();
    }

}
