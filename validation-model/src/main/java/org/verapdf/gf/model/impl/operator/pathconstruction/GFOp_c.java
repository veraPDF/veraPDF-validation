package org.verapdf.gf.model.impl.operator.pathconstruction;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_c;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_c extends GFOpPathConstruction implements Op_c {

	/** Type name for {@code GFOp_c} */
    public static final String OP_C_TYPE = "Op_c";

    public GFOp_c(List<COSBase> arguments) {
        super(arguments, OP_C_TYPE);
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
