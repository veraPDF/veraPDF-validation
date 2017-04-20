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
package org.verapdf.gf.model.impl.pd.patterns;

import org.verapdf.gf.model.impl.pd.GFPDContentStream;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDContentStream;
import org.verapdf.model.pdlayer.PDTilingPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDTilingPattern extends GFPDPattern implements PDTilingPattern {

	public static final String TILING_PATTERN_TYPE = "PDTilingPattern";

	public static final String CONTENT_STREAM = "contentStream";

	private final PDResourcesHandler resourcesHandler;

	private List<PDContentStream> contentStreams = null;
	private boolean containsTransparency = false;

	public GFPDTilingPattern(
			org.verapdf.pd.patterns.PDTilingPattern simplePDObject, PDResourcesHandler resourcesHandler) {
		super(simplePDObject, TILING_PATTERN_TYPE);
		this.resourcesHandler = resourcesHandler;
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {

		if (CONTENT_STREAM.equals(link)) {
			return this.getContentStream();
		}
		return super.getLinkedObjects(link);
	}

	private List<PDContentStream> getContentStream() {
		if (this.contentStreams == null) {
			parseContentStream();
		}
		return this.contentStreams;
	}

	/**
	 * @return true if content stream of the pattern contains transparency
	 */
	public boolean isContainsTransparency() {
		if (this.contentStreams == null) {
			parseContentStream();
		}
		return this.containsTransparency;
	}

	private void parseContentStream() {
		List<PDContentStream> contentStreams = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
		GFPDContentStream contentStream = new GFPDContentStream((org.verapdf.pd.PDContentStream) this.simplePDObject, this.resourcesHandler);
		this.containsTransparency |= contentStream.isContainsTransparency();
		contentStreams.add(contentStream);
		this.contentStreams = contentStreams;
	}

}
