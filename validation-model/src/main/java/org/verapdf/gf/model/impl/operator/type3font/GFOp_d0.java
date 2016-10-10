package org.verapdf.gf.model.impl.operator.type3font;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.impl.cos.GFCosNumber;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_d0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_d0 extends GFOpType3Font implements Op_d0 {

	public static final String OP_D0_TYPE = "Op_d0";

	public static final String HORIZONTAL_DISPLACEMENT = "horizontalDisplacement";
	public static final String VERTICAL_DISPLACEMENT = "verticalDisplacement";

	public GFOp_d0(List<COSBase> arguments) {
		super(arguments, OP_D0_TYPE);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case HORIZONTAL_DISPLACEMENT:
				return this.getHorizontalDisplacement();
			case VERTICAL_DISPLACEMENT:
				return this.getVerticalDisplacement();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<CosNumber> getHorizontalDisplacement() {
		if (this.arguments.size() > 1) {
			COSBase base = this.arguments.get(this.arguments.size() - 2);
			if (base.getType().isNumber()) {
				List<CosNumber> real = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
				real.add(GFCosNumber.fromPDFParserNumber(base));
				return Collections.unmodifiableList(real);
			}
		}
		return Collections.emptyList();
	}

	private List<CosNumber> getVerticalDisplacement() {
		return this.getLastNumber();
	}

}
