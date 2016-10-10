package org.verapdf.gf.model.impl.operator.specialgs;

import org.verapdf.cos.COSBase;
import org.verapdf.model.operator.Op_Q_grestore;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_Q_grestore extends GFOpSpecialGS implements Op_Q_grestore {

	/** Type name for {@code GFOp_Q_grestore} */
    public static final String OP_Q_GRESTORE_TYPE = "Op_Q_grestore";

    public GFOp_Q_grestore(List<COSBase> arguments) {
        super(arguments, OP_Q_GRESTORE_TYPE);
    }

}
