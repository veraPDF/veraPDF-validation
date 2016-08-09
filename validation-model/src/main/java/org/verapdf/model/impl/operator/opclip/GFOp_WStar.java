package org.verapdf.model.impl.operator.opclip;

import org.verapdf.cos.COSBase;
import org.verapdf.model.operator.Op_WStar;

import java.util.List;


/**
 * @author Timur Kamalov
 */
public class GFOp_WStar extends GFOpClip implements Op_WStar {

	/** Type name for {@code GFOp_WStar} */
    public static final String OP_WSTAR_TYPE = "Op_WStar";

    public GFOp_WStar(List<COSBase> arguments) {
        super(arguments, OP_WSTAR_TYPE);
    }

}
