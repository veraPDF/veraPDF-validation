package org.verapdf.gf.model.impl.pd.actions;

import org.verapdf.as.ASAtom;
import org.verapdf.gf.model.impl.pd.GFPDObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDAction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDAction extends GFPDObject implements PDAction {

	public static final String ACTION_TYPE = "PDAction";

	public static final String NEXT = "Next";

	public static final String NAMED_SUBTYPE = "Named";
	public static final String GO_TO_SUBTYPE = "GoTo";
	public static final String GO_TO_R_SUBTYPE = "GoToR";

	public GFPDAction(
			org.verapdf.pd.actions.PDAction simplePDObject) {
		this(simplePDObject, ACTION_TYPE);
	}

	public GFPDAction(
			org.verapdf.pd.actions.PDAction simplePDObject,
			final String type) {
		super(simplePDObject, type);
	}

	@Override
	public String getS() {
		ASAtom subtype =((org.verapdf.pd.actions.PDAction) simplePDObject)
				.getSubtype();
		return subtype == null ? null : subtype.getValue();
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (NEXT.equals(link)) {
			return this.getNext();
		}
		return super.getLinkedObjects(link);
	}

	private List<PDAction> getNext() {
		List<org.verapdf.pd.actions.PDAction> nextActionList =
				((org.verapdf.pd.actions.PDAction) this.simplePDObject)
						.getNext();
		if (!nextActionList.isEmpty()) {
			List<PDAction> actions = new ArrayList<>(nextActionList.size());
			for (org.verapdf.pd.actions.PDAction action : nextActionList) {
				PDAction result = getAction(action);
				if (result != null) {
					actions.add(result);
				}
			}
			return Collections.unmodifiableList(actions);
		}
		return Collections.emptyList();
	}

	public static PDAction getAction(org.verapdf.pd.actions.PDAction action) {
		if (action == null) {
			return null;
		}
		ASAtom subtype = action.getSubtype();
		if (subtype == null) {
			return new GFPDAction(action);
		}

		switch (subtype.getValue()) {
			case NAMED_SUBTYPE:
				return new GFPDNamedAction(action);
			case GO_TO_SUBTYPE:
				return new GFPDGoToAction(action);
			case GO_TO_R_SUBTYPE:
				return new GFPDGoToRemoteAction(action);
			default:
				return new GFPDAction(action);
		}
	}
}
