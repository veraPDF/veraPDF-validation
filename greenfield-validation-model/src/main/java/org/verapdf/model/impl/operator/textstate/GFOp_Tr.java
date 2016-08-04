package org.verapdf.model.impl.operator.textstate;

import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSInteger;
import org.verapdf.model.operator.Op_Tr;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_Tr extends GFOpTextState implements Op_Tr {

	/** Type name for {@code GFOp_Tr} */
    public static final String OP_TR_TYPE = "Op_Tr";

    public GFOp_Tr(List<COSBase> arguments) {
        super(arguments, OP_TR_TYPE);
    }

    @Override
    public Long getrenderingMode() {
        if (!this.arguments.isEmpty()) {
            COSBase renderingMode = this.arguments.get(0);
            if (renderingMode instanceof COSInteger) {
                return Long.valueOf((renderingMode).getInteger());
            }
        }
        return null;
    }

}
