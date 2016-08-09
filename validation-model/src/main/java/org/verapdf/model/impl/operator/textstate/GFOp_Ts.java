package org.verapdf.model.impl.operator.textstate;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_Ts;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_Ts extends GFOpTextState implements Op_Ts {

	public static final String OP_TS_TYPE = "Op_Ts";

	public static final String RISE = "rise";

	public GFOp_Ts(List<COSBase> arguments) {
		super(arguments, OP_TS_TYPE);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (RISE.equals(link)) {
			return this.getRise();
		}
		return super.getLinkedObjects(link);
	}

	private List<CosNumber> getRise() {
		return this.getLastNumber();
	}

}
