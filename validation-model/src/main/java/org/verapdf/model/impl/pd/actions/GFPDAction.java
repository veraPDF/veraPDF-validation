package org.verapdf.model.impl.pd.actions;

import org.verapdf.as.ASAtom;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.impl.pd.GFPDObject;
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
			case "Named":
				return new GFPDNamedAction(action);
			case "GoTo":
				return new GFPDGoToAction(action);
			case "GoToR":
				return new GFPDGoToRemoteAction(action);
			default:
				return new GFPDAction(action);
		}
	}
}
