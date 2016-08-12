package org.verapdf.model.impl.operator.opcompability;

import org.verapdf.cos.COSBase;
import org.verapdf.model.operator.Op_Undefined;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_Undefined extends GFOpCompatibility implements Op_Undefined {

	/** Type name for {@code GFOp_Undefined} */
    public static final String OP_UNDEFINED_TYPE = "Op_Undefined";

    public GFOp_Undefined(List<COSBase> arguments) {
        super(arguments, OP_UNDEFINED_TYPE);
    }

}
