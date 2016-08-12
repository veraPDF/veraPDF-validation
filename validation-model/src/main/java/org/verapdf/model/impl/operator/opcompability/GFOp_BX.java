package org.verapdf.model.impl.operator.opcompability;

import org.verapdf.cos.COSBase;
import org.verapdf.model.operator.Op_BX;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_BX extends GFOpCompatibility implements Op_BX {

	/** Type name for {@code GFOp_BX} */
    public static final String OP_BX_TYPE = "Op_BX";

    public GFOp_BX(List<COSBase> arguments) {
        super(arguments, OP_BX_TYPE);
    }

}
