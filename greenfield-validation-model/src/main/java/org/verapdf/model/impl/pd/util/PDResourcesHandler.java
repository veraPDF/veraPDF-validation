package org.verapdf.model.impl.pd.util;

import org.verapdf.pd.PDResources;

/**
 * @author Timur Kamalov
 */
public class PDResourcesHandler {

	private final PDResources resources;
	private final boolean inheritedResources;

	private PDResourcesHandler(PDResources resources, boolean inheritedResources) {
		this.resources = resources;
		this.inheritedResources = inheritedResources;
	}

	public static PDResourcesHandler getInstance(PDResources pageResources) {
		return getInstance(null, pageResources);
	}

	public static PDResourcesHandler getInstance(PDResources resources, boolean inheritedResources) {
		return new PDResourcesHandler(resources, inheritedResources);
	}

	public static PDResourcesHandler getInstance(PDResources inheritedResources, PDResources currentResources) {
		boolean isInheritedResources = inheritedResources != null && currentResources == null;
		if (isInheritedResources) {
			return new PDResourcesHandler(inheritedResources, true);
		} else {
			return new PDResourcesHandler(currentResources, false);
		}
	}

}
