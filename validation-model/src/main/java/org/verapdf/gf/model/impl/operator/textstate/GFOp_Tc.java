package org.verapdf.gf.model.impl.operator.textstate;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_Tc;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_Tc extends GFOpTextState implements Op_Tc {

	public static final String OP_TC_TYPE = "Op_Tc";

	public static final String CHAR_SPACING = "charSpace";

	public GFOp_Tc(List<COSBase> arguments) {
		super(arguments, OP_TC_TYPE);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (CHAR_SPACING.equals(link)) {
			return this.getCharSpacing();
		}
		return super.getLinkedObjects(link);
	}

	private List<CosNumber> getCharSpacing() {
		return this.getLastNumber();
	}

}
