package org.verapdf.gf.model.impl.operator.inlineimage;

import org.verapdf.cos.COSBase;
import org.verapdf.model.operator.Op_BI;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_BI extends GFOpInlineImage implements Op_BI {

	public static final String OP_BI_TYPE = "Op_BI";

	public GFOp_BI(List<COSBase> arguments) {
		super(arguments, OP_BI_TYPE);
	}
}
