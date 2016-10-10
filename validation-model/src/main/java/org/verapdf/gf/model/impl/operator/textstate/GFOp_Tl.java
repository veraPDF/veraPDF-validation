package org.verapdf.gf.model.impl.operator.textstate;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_Tl;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_Tl extends GFOpTextState implements Op_Tl {

	public static final String OP_TL_TYPE = "Op_Tl";

	public static final String LEADING = "leading";

	public GFOp_Tl(List<COSBase> arguments) {
		super(arguments, OP_TL_TYPE);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (LEADING.equals(link)) {
			return this.getLeading();
		}
		return super.getLinkedObjects(link);
	}

	private List<CosNumber> getLeading() {
		return this.getLastNumber();
	}

}
