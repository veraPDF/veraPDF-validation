package org.verapdf.gf.model.impl.operator.markedcontent;

import org.verapdf.cos.COSBase;
import org.verapdf.model.operator.Op_EMC;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_EMC extends GFOpMarkedContent implements Op_EMC {

	/** Type name for {@code GFOp_EMC} */
    public static final String OP_EMC_TYPE = "Op_EMC";

    public GFOp_EMC(List<COSBase> arguments) {
        super(arguments, OP_EMC_TYPE);
    }

}
