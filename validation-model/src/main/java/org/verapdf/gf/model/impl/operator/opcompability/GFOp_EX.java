package org.verapdf.gf.model.impl.operator.opcompability;

import org.verapdf.cos.COSBase;
import org.verapdf.model.operator.Op_EX;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_EX extends GFOpCompatibility implements Op_EX {

	/** Type name for {@code GFOp_EX} */
    public static final String OP_EX_TYPE = "Op_EX";

    public GFOp_EX(List<COSBase> arguments) {
        super(arguments, OP_EX_TYPE);
    }

}