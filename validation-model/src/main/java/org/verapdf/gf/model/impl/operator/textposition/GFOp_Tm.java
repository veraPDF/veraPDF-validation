package org.verapdf.gf.model.impl.operator.textposition;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_Tm;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_Tm extends GFOpTextPosition implements Op_Tm {

	public static final String OP_TM_TYPE = "Op_Tm";

	public static final String CONTROL_POINTS = "controlPoints";

	public GFOp_Tm(List<COSBase> arguments) {
		super(arguments, OP_TM_TYPE);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (CONTROL_POINTS.equals(link)) {
			return this.getControlPoints();
		}
		return super.getLinkedObjects(link);
	}

	private List<CosNumber> getControlPoints() {
		return this.getListOfNumbers();
	}

}
