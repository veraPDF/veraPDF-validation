package org.verapdf.model.impl.operator.textshow;

import org.verapdf.cos.COSBase;
import org.verapdf.model.factory.operators.GraphicState;
import org.verapdf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.Op_Quote;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_Quote extends GFOpStringTextShow implements Op_Quote {

	/** Type name for {@code GFOp_Quote} */
    public static final String OP_QUOTE_TYPE = "Op_Quote";

    public GFOp_Quote(List<COSBase> arguments, GraphicState state, PDResourcesHandler resourcesHandler) {
        super(arguments, state, resourcesHandler, OP_QUOTE_TYPE);
    }

}
