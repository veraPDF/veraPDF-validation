package org.verapdf.model.impl.operator.specialgs;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_cm;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_cm extends GFOpSpecialGS implements Op_cm {

	/** Type name for {@code GFOp_cm} */
    public static final String OP_CM_TYPE = "Op_cm";

	/** Name of link to the concatenate matrix values */
    public static final String MATRIX = "matrix";

    public GFOp_cm(List<COSBase> arguments) {
        super(arguments, OP_CM_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (MATRIX.equals(link)) {
            return this.getMatrix();
        }
        return super.getLinkedObjects(link);
    }

    private List<CosNumber> getMatrix() {
        return this.getListOfNumbers();
    }

}
