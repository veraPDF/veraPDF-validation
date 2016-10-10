package org.verapdf.gf.model.impl.pd;

import org.verapdf.gf.model.impl.pd.actions.GFPDAction;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDAction;
import org.verapdf.model.pdlayer.PDOutline;
import org.verapdf.pd.PDOutlineItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDOutline extends GFPDObject implements PDOutline {

	public static final String OUTLINE_TYPE = "PDOutline";

	public static final String ACTION = "A";

	private final String id;

	public GFPDOutline(PDOutlineItem simplePDObject, String id) {
		super(simplePDObject, OUTLINE_TYPE);
		this.id = id;
	}

	@Override
	public String getID() {
		return this.id;
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (ACTION.equals(link)) {
			return this.getAction();
		}
		return super.getLinkedObjects(link);
	}

	private List<PDAction> getAction() {
		org.verapdf.pd.actions.PDAction action = ((PDOutlineItem) this.simplePDObject).getAction();
		if (action != null) {
			List<PDAction> actions = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			PDAction pdAction = GFPDAction.getAction(action);
			actions.add(pdAction);
			return Collections.unmodifiableList(actions);
		}
		return Collections.emptyList();
	}
}
