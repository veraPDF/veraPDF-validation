package org.verapdf.model.impl.operator.pathpaint;

import org.verapdf.cos.COSBase;
import org.verapdf.model.operator.Op_n;

import java.util.List;


/**
 * @author Timur Kamalov
 */
public class GFOp_n extends GFOpPathPaint implements Op_n {

	/** Type name for {@code GFOp_n} */
	public static final String OP_N_TYPE = "Op_n";

	public GFOp_n(List<COSBase> arguments) {
		super(arguments, null, OP_N_TYPE);
	}

}
