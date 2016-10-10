package org.verapdf.gf.model.impl.operator.type3font;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.impl.operator.base.GFOperator;
import org.verapdf.model.operator.OpType3Font;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOpType3Font extends GFOperator implements OpType3Font {

	protected GFOpType3Font(List<COSBase> arguments, String type) {
		super(arguments, type);
	}

}
