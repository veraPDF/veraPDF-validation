package org.verapdf.gf.model.impl.operator.pathpaint;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.factory.operators.GraphicState;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.Op_S_stroke;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_S_stroke extends GFOpStrokePaint implements Op_S_stroke {

	/** Type name for {@code GFOp_S_stroke} */
	public static final String OP_S_STROKE_TYPE = "Op_S_stroke";

	public GFOp_S_stroke(List<COSBase> arguments, final GraphicState state,
						 final PDResourcesHandler resourcesHandler) {
		super(arguments, state, resourcesHandler, OP_S_STROKE_TYPE);
	}

}
