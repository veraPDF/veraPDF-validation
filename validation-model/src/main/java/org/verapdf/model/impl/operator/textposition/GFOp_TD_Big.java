package org.verapdf.model.impl.operator.textposition;

import org.verapdf.cos.COSBase;
import org.verapdf.model.operator.Op_TD_Big;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_TD_Big extends GFOp_General_Td implements Op_TD_Big {

	/** Type name for {@code GFOp_TD_Big} */
    public static final String OP_TD_BIG_TYPE = "Op_TD_Big";

    public GFOp_TD_Big(List<COSBase> arguments) {
        super(arguments, OP_TD_BIG_TYPE);
    }

}
