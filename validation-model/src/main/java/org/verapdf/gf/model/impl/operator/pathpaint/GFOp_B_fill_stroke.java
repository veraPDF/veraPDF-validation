package org.verapdf.gf.model.impl.operator.pathpaint;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.factory.operators.GraphicState;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.Op_B_fill_stroke;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_B_fill_stroke extends GFOpFillAndStroke
		implements Op_B_fill_stroke {

	/** Type name for {@code GFOp_B_fill_stroke} */
	public static final String OP_B_FILL_STROKE_TYPE = "Op_B_fill_stroke";

	public GFOp_B_fill_stroke(List<COSBase> arguments, final GraphicState state,
							  final PDResourcesHandler resourcesHandler) {
		super(arguments, state, resourcesHandler, OP_B_FILL_STROKE_TYPE);
	}

}
