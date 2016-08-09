package org.verapdf.model.impl.pd.actions;

import org.verapdf.model.pdlayer.PDGoToRemoteAction;
import org.verapdf.pd.actions.PDAction;

/**
 * @author Maksim Bezrukov
 */
public class GFPDGoToRemoteAction extends GFPDGoToAction implements PDGoToRemoteAction {

	public static final String GOTO_REMOTE_ACTION_TYPE = "PDGoToRemoteAction";

	public GFPDGoToRemoteAction(PDAction simplePDObject) {
		super(simplePDObject, GOTO_REMOTE_ACTION_TYPE);
	}
}
