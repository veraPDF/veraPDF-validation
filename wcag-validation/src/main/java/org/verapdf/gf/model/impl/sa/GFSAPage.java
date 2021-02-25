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
package org.verapdf.gf.model.impl.sa;

import org.verapdf.gf.model.impl.sa.util.ResourceHandler;
import org.verapdf.wcag.algorithms.entities.content.IChunk;

import java.util.Collections;
import java.util.List;

/**
 * @author Maxim Plushchov
 */
public class GFSAPage {

	private GFSAContentStream contentStream = null;

	private org.verapdf.pd.PDPage pdPage = null;

	public GFSAPage(org.verapdf.pd.PDPage pdPage) {
		this.pdPage = pdPage;
	}

	private List<IChunk> getArtifacts() {
		if (contentStream == null) {
			parseContentStream();
		}
		if (contentStream != null) {
			return contentStream.getArtifacts();
		}
		return Collections.emptyList();
	}

	public GFSAContentStream getContentStream() {
		if (this.contentStream == null) {
			parseContentStream();
		}
		return this.contentStream;
	}

	private void parseContentStream() {
		GFSAContentStream pdContentStream = null;
		if (pdPage.getContent() != null) {
			ResourceHandler resourceHandler = ResourceHandler.getInstance(pdPage.getResources());
			pdContentStream = new GFSAContentStream(pdPage.getContent(), resourceHandler, pdPage.getPageNumber());
		}
		this.contentStream = pdContentStream;
	}
}
