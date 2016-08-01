package org.verapdf.model.impl.operator.pathpaint;

import org.verapdf.cos.COSBase;
import org.verapdf.model.impl.operator.factory.GraphicState;
import org.verapdf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.Op_FStar;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_FStar extends GFOpFillPaint implements Op_FStar {

	/** Type name for {@code GFOp_FStar} */
	public static final String OP_FSTAR_TYPE = "Op_FStar";

	public GFOp_FStar(List<COSBase> arguments,
					  final GraphicState state,
					  final PDResourcesHandler resourcesHandler) {
		super(arguments, state, resourcesHandler, OP_FSTAR_TYPE);
	}

}
