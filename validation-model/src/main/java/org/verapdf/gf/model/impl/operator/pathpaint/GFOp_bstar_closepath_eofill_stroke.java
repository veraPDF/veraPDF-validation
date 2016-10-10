package org.verapdf.gf.model.impl.operator.pathpaint;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.factory.operators.GraphicState;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.Op_bstar_closepath_eofill_stroke;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_bstar_closepath_eofill_stroke extends GFOpFillAndStroke
		implements Op_bstar_closepath_eofill_stroke {

	/** Type name for {@code GFOp_bstar_closepath_eofill_stroke} */
	public static final String OP_BSTAR_CLOSEPATH_EOFILL_STROKE_TYPE = "Op_bstar_closepath_eofill_stroke";

	public GFOp_bstar_closepath_eofill_stroke(List<COSBase> arguments, final GraphicState state,
											  final PDResourcesHandler resourcesHandler) {
		super(arguments, state, resourcesHandler, OP_BSTAR_CLOSEPATH_EOFILL_STROKE_TYPE);
	}
}
