package org.verapdf.model.impl.operator.textshow;

import org.verapdf.cos.COSBase;
import org.verapdf.model.impl.operator.factory.GraphicState;
import org.verapdf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.Op_Tj;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_Tj extends GFOpStringTextShow implements Op_Tj {

	/** Type name for {@code GFOp_Tj} */
    public static final String OP_TJ_TYPE = "Op_Tj";

    public GFOp_Tj(List<COSBase> arguments, GraphicState state,
                   PDResourcesHandler resourcesHandler) {
        super(arguments, state, resourcesHandler, OP_TJ_TYPE);
    }
}
