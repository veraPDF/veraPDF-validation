package org.verapdf.features.gf.objects;

import org.verapdf.features.gf.tools.GFAdapterHelper;
import org.verapdf.features.objects.ActionFeaturesObjectAdapter;
import org.verapdf.pd.actions.PDAction;

import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFActionFeaturesObjectAdapter implements ActionFeaturesObjectAdapter {

	private final PDAction action;
	private final Location location;

	public GFActionFeaturesObjectAdapter(PDAction action, Location location) {
		this.action = action;
		this.location = location;
	}

	@Override
	public String getType() {
		return GFAdapterHelper.getStringFromASAtom(this.action.getSubtype());
	}

	@Override
	public Location getLocation() {
		return this.location;
	}

	@Override
	public boolean isPDFObjectPresent() {
		return this.action != null && !this.action.empty();
	}

	@Override
	public List<String> getErrors() {
		return Collections.emptyList();
	}
}
