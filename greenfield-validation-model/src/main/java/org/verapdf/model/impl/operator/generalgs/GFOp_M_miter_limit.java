package org.verapdf.model.impl.operator.generalgs;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_M_miter_limit;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_M_miter_limit extends GFOpGeneralGS implements Op_M_miter_limit {

	/** Type name for {@code GFOp_M_miter_limit} */
    public static final String OP_M_MITER_LIMIT_TYPE = "Op_M_miter_limit";

	/** Name of link to the miter limit */
    public static final String MITER_LIMIT = "miterLimit";

    public GFOp_M_miter_limit(List<COSBase> arguments) {
        super(arguments, OP_M_MITER_LIMIT_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (MITER_LIMIT.equals(link)) {
            return this.getMiterLimit();
        }
        return super.getLinkedObjects(link);
    }

    private List<CosNumber> getMiterLimit() {
        return this.getLastNumber();
    }

}
