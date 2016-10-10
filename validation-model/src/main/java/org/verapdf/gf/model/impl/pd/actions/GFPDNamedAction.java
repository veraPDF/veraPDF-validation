package org.verapdf.gf.model.impl.pd.actions;

import org.verapdf.as.ASAtom;
import org.verapdf.model.pdlayer.PDNamedAction;
import org.verapdf.pd.actions.PDAction;

/**
 * @author Maksim Bezrukov
 */
public class GFPDNamedAction extends GFPDAction implements PDNamedAction {
	public static final String NAMED_ACTION_TYPE = "PDNamedAction";

	public GFPDNamedAction(PDAction simplePDObject) {
		super(simplePDObject, NAMED_ACTION_TYPE);
	}

	@Override
	public String getN() {
		ASAtom n =((PDAction) this.simplePDObject).getN();
		return n == null ? null : n.getValue();
	}
}
