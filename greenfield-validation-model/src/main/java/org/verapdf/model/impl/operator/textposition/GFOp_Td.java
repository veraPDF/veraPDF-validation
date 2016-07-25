package org.verapdf.model.impl.operator.textposition;

import org.verapdf.cos.COSBase;
import org.verapdf.model.operator.Op_Td;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_Td extends GFOp_General_Td implements Op_Td {

	/** Type name for {@code GFOp_Td} */
    public static final String OP_TD_TYPE = "Op_Td";

    public GFOp_Td(List<COSBase> arguments) {
        super(arguments, OP_TD_TYPE);
    }

}
