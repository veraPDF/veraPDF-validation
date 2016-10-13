package org.verapdf.gf.model.impl.operator.pathpaint;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.factory.operators.GraphicState;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.Op_F_fill_obsolete;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_F_fill_obsolete extends GFOpFillPaint implements Op_F_fill_obsolete {

	/** Type name for {@code GFOp_F_fill_obsolete} */
	public static final String OP_F_FILL_OBSOLETE_TYPE = "Op_F_fill_obsolete";

	public GFOp_F_fill_obsolete(List<COSBase> arguments, final GraphicState state,
								final PDResourcesHandler resourcesHandler) {
		super(arguments, state, resourcesHandler, OP_F_FILL_OBSOLETE_TYPE);
	}

}
