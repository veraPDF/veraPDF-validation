package org.verapdf.model.impl.operator.pathpaint;

import org.verapdf.cos.COSBase;
import org.verapdf.model.impl.operator.factory.GraphicState;
import org.verapdf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.Op_BStar_eofill_stroke;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_BStar_eofill_stroke extends GFOpFillAndStroke
		implements Op_BStar_eofill_stroke {

	/** Type name for {@code GFOp_BStar_eofill_stroke} */
	public static final String OP_BSTAR_EOFILL_STROKE_TYPE = "Op_BStar_eofill_stroke";

	public GFOp_BStar_eofill_stroke(List<COSBase> arguments, final GraphicState state,
									final PDResourcesHandler resourcesHandler) {
		super(arguments, state, resourcesHandler, OP_BSTAR_EOFILL_STROKE_TYPE);
	}

}
