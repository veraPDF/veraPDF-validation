package org.verapdf.model.impl.operator.pathconstruction;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_l;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_l extends GFOpPathConstruction implements Op_l {

	/** Type name for {@code GFOp_l} */
    public static final String OP_L_TYPE = "Op_l";

	/** Name of link to the point */
    public static final String POINT = "point";

    public GFOp_l(List<COSBase> arguments) {
        super(arguments, OP_L_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (POINT.equals(link)) {
            return this.getPoint();
        }
        return super.getLinkedObjects(link);
    }

    private List<CosNumber> getPoint() {
        return this.getListOfNumbers();
    }

}
