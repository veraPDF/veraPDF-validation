/**
 * This file is part of validation-model, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * validation-model is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with validation-model as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * validation-model as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.pd.images;

import org.verapdf.as.ASAtom;
import org.verapdf.gf.model.factory.operators.GraphicState;
import org.verapdf.gf.model.impl.pd.GFPDContentStream;
import org.verapdf.gf.model.impl.pd.GFPDGroup;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDContentStream;
import org.verapdf.model.pdlayer.PDGroup;
import org.verapdf.model.pdlayer.PDXForm;
import org.verapdf.pd.structure.StructureElementAccessObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDXForm extends GFPDXObject implements PDXForm {

	public static final String X_FORM_TYPE = "PDXForm";

	public static final String GROUP = "Group";
	public static final String CONTENT_STREAM = "contentStream";

	private List<PDContentStream> contentStreams = null;
	private List<PDGroup> groups = null;
	private boolean groupContainsTransparency = false;
	private boolean contentStreamContainsTransparency = false;
	private final GraphicState inheritedGraphicState;

	public GFPDXForm(org.verapdf.pd.images.PDXForm simplePDObject, PDResourcesHandler resourcesHandler,
					 GraphicState inheritedGraphicState) {
		super(simplePDObject, resourcesHandler.getExtendedResources(simplePDObject.getResources()), X_FORM_TYPE);
		this.inheritedGraphicState = inheritedGraphicState;
	}

	@Override
	public String getSubtype2() {
		ASAtom subtype2 = ((org.verapdf.pd.images.PDXForm) this.simplePDObject).getSubtype2();
		return subtype2 == null ? null : subtype2.getValue();
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case GROUP:
				return this.getGroup();
			case CONTENT_STREAM:
				return this.getContentStream();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<PDGroup> getGroup() {
		if (this.groups == null) {
			initializeGroups();
		}
		return this.groups;
	}

	@Override
	public Boolean getcontainsPS() {
		// See 7.11.5 in PDF 1.2 specification
		return this.simplePDObject.knownKey(ASAtom.PS);
	}

	@Override
	public Boolean getcontainsRef() {
		return this.simplePDObject.knownKey(ASAtom.REF);
	}

	private List<PDContentStream> getContentStream() {
		if (this.contentStreams == null) {
			parseContentStream();
		}
		return this.contentStreams;
	}

	private void initializeGroups() {
		org.verapdf.pd.images.PDXForm form = (org.verapdf.pd.images.PDXForm) this.simplePDObject;
		org.verapdf.pd.PDGroup group = form.getGroup();
		if (group != null) {
			this.groupContainsTransparency = ASAtom.TRANSPARENCY.equals(group.getSubtype());
			List<PDGroup> groups = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			groups.add(new GFPDGroup(group, resourcesHandler.getObjectResources()));
			this.groups = Collections.unmodifiableList(groups);
		} else {
			this.groups = Collections.emptyList();
		}
	}

	private void parseContentStream() {
		List<PDContentStream> streams = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
		GFPDContentStream gfContentStream = new GFPDContentStream(
				(org.verapdf.pd.images.PDXForm) this.simplePDObject, resourcesHandler,
				this.inheritedGraphicState, new StructureElementAccessObject(this.simpleCOSObject));
		this.contentStreamContainsTransparency = gfContentStream.isContainsTransparency();
		streams.add(gfContentStream);
		this.contentStreams = streams;
	}

	/**
	 * @return true if current form object contains transparency group or transparency in its content stream
	 */
	public boolean containsTransparency() {
		if (groups == null) {
			initializeGroups();
		}
		if (contentStreams == null) {
			parseContentStream();
		}

		return groupContainsTransparency || contentStreamContainsTransparency;
	}
}
