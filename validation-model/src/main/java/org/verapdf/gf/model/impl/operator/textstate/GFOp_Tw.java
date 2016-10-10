package org.verapdf.gf.model.impl.operator.textstate;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_Tw;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_Tw extends GFOpTextState implements Op_Tw {

	public static final String OP_TW_TYPE = "Op_Tw";

	public static final String WORD_SPACE = "wordSpace";

	public GFOp_Tw(List<COSBase> arguments) {
		super(arguments, OP_TW_TYPE);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (WORD_SPACE.equals(link)) {
			return this.getWordSpace();
		}
		return super.getLinkedObjects(link);
	}

	private List<CosNumber> getWordSpace() {
		return this.getLastNumber();
	}

}
