package org.verapdf.model.impl.operator.pathpaint;

import org.verapdf.cos.COSBase;
import org.verapdf.model.impl.operator.factory.GraphicState;
import org.verapdf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.Op_s_close_stroke;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_s_close_stroke extends GFOpStrokePaint implements
		Op_s_close_stroke {

	/** Type name for {@code GFOp_s_close_stroke} */
	public static final String OP_S_CLOSE_STROKE_TYPE = "Op_s_close_stroke";

	public GFOp_s_close_stroke(List<COSBase> arguments,
							   final GraphicState state,
							   final PDResourcesHandler resourcesHandler) {
		super(arguments, state, resourcesHandler, OP_S_CLOSE_STROKE_TYPE);
	}

}
