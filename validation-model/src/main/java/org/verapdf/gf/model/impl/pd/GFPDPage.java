/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.pd;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSArray;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.cos.GFCosBBox;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosBBox;
import org.verapdf.model.pdlayer.*;
import org.verapdf.pd.PDAnnotation;
import org.verapdf.pd.actions.PDPageAdditionalActions;
import org.verapdf.pd.structure.StructureElementAccessObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * the object representing PDF page.
 *
 * @author Sergey Shemyakov
 */
public class GFPDPage extends GFPDObject implements PDPage {

	/**
	 * Type name for GFPDPage
	 */
	public static final String PD_PAGE_TYPE = "PDPage";

	/**
	 * Link name for page annotations
	 */
	private static final String ANNOTS = "annots";
	/**
	 * Link name for page additional actions
	 */
	private static final String ACTION = "AA";
	/**
	 * Link name for page content stream
	 */
	private static final String CONTENT_STREAM = "contentStream";
	/**
	 * Link name for page transparency group
	 */
	private static final String GROUP = "Group";
	/**
	 * Link name for page media box
	 */
	private static final String MEDIA_BOX = "MediaBox";
	/**
	 * Link name for page crop box
	 */
	private static final String CROP_BOX = "CropBox";
	/**
	 * Link name for page bleed box
	 */
	private static final String BLEED_BOX = "BleedBox";
	/**
	 * Link name for trim media box
	 */
	private static final String TRIM_BOX = "TrimBox";
	/**
	 * Link name for page art box
	 */
	private static final String ART_BOX = "ArtBox";

	public static final int MAX_NUMBER_OF_ACTIONS = 2;

	private boolean containsTransparency = false;
	private List<PDContentStream> contentStreams = null;
	private List<PDAnnot> annotations = null;

	/**
	 * Default constructor
	 *
	 * @param pdPage is greenfield parser PDPage.
	 */
	public GFPDPage(org.verapdf.pd.PDPage pdPage) {
		super(pdPage, PD_PAGE_TYPE);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case GROUP:
				return this.getGroup();
			case ANNOTS:
				return this.getAnnotations();
			case ACTION:
				return this.getActions();
			case CONTENT_STREAM:
				return this.getContentStream();
			case MEDIA_BOX:
				return this.getMediaBox();
			case CROP_BOX:
				return this.getCropBox();
			case BLEED_BOX:
				return this.getBleedBox();
			case TRIM_BOX:
				return this.getTrimBox();
			case ART_BOX:
				return this.getArtBox();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<PDGroup> getGroup() {
		org.verapdf.pd.PDPage page = (org.verapdf.pd.PDPage) this.simplePDObject;
		org.verapdf.pd.PDGroup group = page.getGroup();
		if (group != null) {
			List<PDGroup> res = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			PDResourcesHandler resourcesHandler = PDResourcesHandler.getInstance(page.getResources(),
					page.isInheritedResources().booleanValue());
			res.add(new GFPDGroup(group, resourcesHandler.getPageResources()));
			return Collections.unmodifiableList(res);
		}
		return Collections.emptyList();
	}

	private List<PDAnnot> getAnnotations() {
		if (this.annotations == null) {
			this.annotations = parseAnnotataions();
		}

		return this.annotations;
	}

	private List<PDAnnot> parseAnnotataions() {
		StaticContainers.getTransparencyVisitedContentStreams().clear();
		List<PDAnnotation> annots = ((org.verapdf.pd.PDPage) simplePDObject).getAnnotations();
		if (annots.size() > 0) {
			List<PDAnnot> res = new ArrayList<>(annots.size());
			for (PDAnnotation annot : annots) {
				org.verapdf.pd.PDPage page = (org.verapdf.pd.PDPage) this.simplePDObject;
				PDResourcesHandler resourcesHandler = PDResourcesHandler.getInstance(page.getResources(), page.isInheritedResources().booleanValue());
				GFPDAnnot annotation = new GFPDAnnot(annot, resourcesHandler);
				this.containsTransparency |= annotation.isContainsTransparency();
				res.add(annotation);
			}
			return Collections.unmodifiableList(res);
		}
		return Collections.emptyList();
	}

	private List<PDAction> getActions() {
		PDPageAdditionalActions additionalActions =
				((org.verapdf.pd.PDPage) this.simplePDObject).getAdditionalActions();
		if (additionalActions != null) {
			List<PDAction> actions = new ArrayList<>(MAX_NUMBER_OF_ACTIONS);

			org.verapdf.pd.actions.PDAction raw;

			raw = additionalActions.getC();
			this.addAction(actions, raw);

			raw = additionalActions.getO();
			this.addAction(actions, raw);

			return Collections.unmodifiableList(actions);
		}
		return Collections.emptyList();
	}

	private List<PDContentStream> getContentStream() {
		if (this.contentStreams == null) {
			this.contentStreams = parseContentStream();
		}
		return this.contentStreams;
	}

	private List<PDContentStream> parseContentStream() {
		StaticContainers.getTransparencyVisitedContentStreams().clear();
		List<PDContentStream> pdContentStreams = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
		org.verapdf.pd.PDPage page = (org.verapdf.pd.PDPage) this.simplePDObject;
		if (page.getContent() != null) {
			PDResourcesHandler resourcesHandler = PDResourcesHandler.getInstance(page.getResources(), page.isInheritedResources().booleanValue());
			GFPDContentStream pdContentStream = new GFPDContentStream(page.getContent(), resourcesHandler, null,
					new StructureElementAccessObject(this.simpleCOSObject));
			this.containsTransparency |= pdContentStream.isContainsTransparency();
			pdContentStreams.add(pdContentStream);
		}
		return pdContentStreams;
	}

	private List<CosBBox> getMediaBox() {
		return getBBox(((org.verapdf.pd.PDPage) simplePDObject).getCOSMediaBox());
	}

	private List<CosBBox> getCropBox() {
		return getBBox(((org.verapdf.pd.PDPage) simplePDObject).getCOSCropBox());
	}

	private List<CosBBox> getBleedBox() {
		return getBBox(((org.verapdf.pd.PDPage) simplePDObject).getCOSBleedBox());
	}

	private List<CosBBox> getTrimBox() {
		return getBBox(((org.verapdf.pd.PDPage) simplePDObject).getCOSTrimBox());
	}

	private List<CosBBox> getArtBox() {
		return getBBox(((org.verapdf.pd.PDPage) simplePDObject).getCOSArtBox());
	}

	private static List<CosBBox> getBBox(COSArray array) {
		if (array != null) {
			List<CosBBox> res = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			res.add(new GFCosBBox(array));
			return Collections.unmodifiableList(res);
		}
		return Collections.emptyList();
	}

	/**
	 * @return true if the page contains presentation steps
	 * (/PresSteps in the page dictionary).
	 */
	@Override
	public Boolean getcontainsPresSteps() {
		return Boolean.valueOf(((org.verapdf.pd.PDPage) simplePDObject).getCOSPresSteps() != null);
	}

	/**
	 * @return true if the page contains transparency.
	 */
	@Override
	public Boolean getcontainsTransparency() {
		if (this.contentStreams == null) {
			this.contentStreams = parseContentStream();
		}
		if (this.annotations == null) {
			this.annotations = parseAnnotataions();
		}
		return Boolean.valueOf(this.containsTransparency);
	}

	/**
	 * @return true if the page contains group which contains color space
	 */
	@Override
	public Boolean getcontainsGroupCS() {
		org.verapdf.pd.PDGroup group = ((org.verapdf.pd.PDPage) this.simplePDObject).getGroup();
		return Boolean.valueOf(group != null && group.getColorSpace() != null);
	}

	@Override
	public Boolean getcontainsAA() {
		return this.simplePDObject == null ? Boolean.valueOf(false) :
				this.simplePDObject.knownKey(ASAtom.AA);
	}
}
