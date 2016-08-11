package org.verapdf.model.impl.operator.pathpaint;

import org.verapdf.cos.COSBase;
import org.verapdf.model.factory.operators.GraphicState;
import org.verapdf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.Op_f_fill;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_f_fill extends GFOpFillPaint implements Op_f_fill {

	/** Type name for {@code GFOp_f_fill} */
	public static final String OP_F_FILL_TYPE = "Op_f_fill";

	public GFOp_f_fill(List<COSBase> arguments, final GraphicState state,
					   final PDResourcesHandler resourcesHandler) {
		super(arguments, state, resourcesHandler, OP_F_FILL_TYPE);
	}

}
