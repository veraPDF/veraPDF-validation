package org.verapdf.model.impl.pd.images;

import org.verapdf.model.baselayer.Object;
import org.verapdf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.pdlayer.PDSMaskImage;
import org.verapdf.pd.images.PDXImage;

import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDSMaskImage extends GFPDXImage implements PDSMaskImage {

	public static final String SMASK_IMAGE_TYPE = "PDSMaskImage";

	public GFPDSMaskImage(PDXImage simplePDObject, PDResourcesHandler resourcesHandler) {
		super(simplePDObject, resourcesHandler, SMASK_IMAGE_TYPE);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case IMAGE_CS:
				return Collections.emptyList();
			default:
				return super.getLinkedObjects(link);
		}
	}
}
