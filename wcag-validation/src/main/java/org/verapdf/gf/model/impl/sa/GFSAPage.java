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
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.salayer.SAAnnotation;
import org.verapdf.model.salayer.SAChunk;
import org.verapdf.model.salayer.SAPage;
import org.verapdf.pd.PDAnnotation;
import org.verapdf.wcag.algorithms.entities.IPage;
import org.verapdf.wcag.algorithms.entities.content.IChunk;
import org.verapdf.wcag.algorithms.entities.content.ImageChunk;
import org.verapdf.wcag.algorithms.entities.content.TextChunk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maxim Plushchov
 */
public class GFSAPage extends GenericModelObject implements SAPage, IPage {

	public static final String PAGE_TYPE = "SAPage";

	public static final String ARTIFACTS = "artifacts";

	private static final String ANNOTS = "annots";

	private GFSAContentStream contentStream = null;

	private List<SAChunk> artifacts = null;

	private final org.verapdf.pd.PDPage pdPage;

	private List<SAAnnotation> annotations = null;

	public GFSAPage(org.verapdf.pd.PDPage pdPage) {
		super(PAGE_TYPE);
		this.pdPage = pdPage;
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case ARTIFACTS:
				return getartifacts();
			case ANNOTS:
				return this.getAnnotations();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<SAAnnotation> parseAnnotataions() {
		List<PDAnnotation> annots = pdPage.getAnnotations();
		if (annots.size() > 0) {
			List<SAAnnotation> res = new ArrayList<>(annots.size());
			for (PDAnnotation annot : annots) {
				res.add(GFSAAnnotation.createAnnot(annot, pdPage));
			}
			return Collections.unmodifiableList(res);
		}
		return Collections.emptyList();
	}

	private List<SAAnnotation> getAnnotations() {
		if (this.annotations == null) {
			this.annotations = parseAnnotataions();
		}

		return this.annotations;
	}

	private List<SAChunk> getartifacts() {
		if (this.artifacts == null) {
			List<IChunk> artifacts = getArtifacts();
			this.artifacts = new ArrayList<>(artifacts.size());
			for (IChunk chunk : artifacts) {
				if (chunk instanceof TextChunk) {
					this.artifacts.add(new GFSATextChunk((TextChunk) chunk, ""));
				} else if (chunk instanceof ImageChunk) {
					this.artifacts.add(new GFSAImageChunk((ImageChunk) chunk));
				}
			}
		}
		return artifacts;
	}

	@Override
	public List<IChunk> getArtifacts() {
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
			pdContentStream = new GFSAContentStream(pdPage.getContent(), null, resourceHandler, pdPage.getPageNumber(),
			                                        pdPage.getObject().getKey(), pdPage.getCropBox(), null);
		}
		this.contentStream = pdContentStream;
	}

	public int getPageNumber() {
		return pdPage.getPageNumber();
	}
}
