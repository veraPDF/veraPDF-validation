package org.verapdf.model.impl.pd.actions;

import org.verapdf.cos.COSNumber;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosReal;
import org.verapdf.model.impl.cos.GFCosReal;
import org.verapdf.model.pdlayer.PDGoToAction;
import org.verapdf.pd.actions.PDAction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDGoToAction extends GFPDAction implements PDGoToAction {
	public static final String GOTO_ACTION_TYPE = "PDGoToAction";

	public static final String D = "D";

	public GFPDGoToAction(PDAction simplePDObject) {
		super(simplePDObject, GOTO_ACTION_TYPE);
	}

	protected GFPDGoToAction(PDAction simplePDObject, String type) {
		super(simplePDObject, type);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (D.equals(link)) {
			return this.getD();
		}
		return super.getLinkedObjects(link);
	}

	private List<CosReal> getD() {
		List<COSNumber> numbers = ((PDAction) simplePDObject).getCOSArrayD();
		if (!numbers.isEmpty()) {
			List<CosReal> result = new ArrayList<>(numbers.size());
			for (COSNumber number : numbers) {
				result.add(new GFCosReal(number));
			}
			return Collections.unmodifiableList(result);
		}
		return Collections.emptyList();
	}
}
