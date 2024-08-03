/**
 * This file is part of veraPDF WCAG Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2024, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF WCAG Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF WCAG Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF WCAG Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.sa;

import org.verapdf.gf.model.factory.chunks.GraphicsState;
import org.verapdf.gf.model.factory.chunks.Matrix;
import org.verapdf.gf.model.impl.sa.util.ResourceHandler;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.salayer.SAAnnotation;
import org.verapdf.model.salayer.SAChunk;
import org.verapdf.model.salayer.SAPage;
import org.verapdf.model.salayer.SATableBorder;
import org.verapdf.gf.model.impl.sa.tables.GFSATableBorder;
import org.verapdf.pd.PDAnnotation;
import org.verapdf.pd.PDPage;
import org.verapdf.wcag.algorithms.entities.IPage;
import org.verapdf.wcag.algorithms.entities.content.IChunk;
import org.verapdf.wcag.algorithms.entities.content.ImageChunk;
import org.verapdf.wcag.algorithms.entities.content.LineArtChunk;
import org.verapdf.wcag.algorithms.entities.content.TextChunk;
import org.verapdf.wcag.algorithms.entities.tables.tableBorders.TableBorder;
import org.verapdf.wcag.algorithms.semanticalgorithms.containers.StaticContainers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maxim Plushchov
 */
public class GFSAPage extends GenericModelObject implements SAPage, IPage {

	public static final String PAGE_TYPE = "SAPage";

	private static final String ARTIFACTS = "artifacts";
	private static final String TABLE_BORDERS = "tableBorders";
	private static final String ANNOTS = "annots";

	private GFSAContentStream contentStream = null;

	private List<SAChunk> artifacts = null;

	private final PDPage pdPage;

	private final String pageLabel;

	private List<SAAnnotation> annotations = null;

	public GFSAPage(PDPage pdPage, String pageLabel) {
		super(PAGE_TYPE);
		this.pdPage = pdPage;
		this.pageLabel = pageLabel;
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case ARTIFACTS:
				return getartifacts();
			case ANNOTS:
				return this.getAnnotations();
			case TABLE_BORDERS:
				return this.getTableBorders();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<SAAnnotation> parseAnnotations() {
		List<PDAnnotation> annots = pdPage.getAnnotations();
		if (!annots.isEmpty()) {
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
			this.annotations = parseAnnotations();
		}
		return Collections.unmodifiableList(this.annotations);
	}

	private List<SATableBorder> getTableBorders() {
		if (StaticContainers.getTableBordersCollection() == null) {
			return Collections.emptyList();
		}
		List<SATableBorder> tableBorders = new ArrayList<>();
		for (TableBorder tableBorder : StaticContainers.getTableBordersCollection().getTableBorders(pdPage.getPageNumber())) {
			tableBorders.add(new GFSATableBorder(tableBorder));
		}
		return tableBorders;
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
				} else if (chunk instanceof LineArtChunk) {
					this.artifacts.add(new GFSALineArtChunk((LineArtChunk) chunk));
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
			GraphicsState graphicsState = new GraphicsState(resourceHandler);
			graphicsState.setCTM(createCurrentTransformationMatrix(pdPage));
			pdContentStream = new GFSAContentStream(pdPage.getContent(), graphicsState, resourceHandler,
					pdPage.getPageNumber(), pdPage.getObject().getKey(), null, null);
		}
		this.contentStream = pdContentStream;
	}

	public static Matrix createCurrentTransformationMatrix(PDPage pdPage) {
		double[] cropBox = pdPage.getCropBox();
		if (cropBox == null) {
			cropBox = new double[]{0.0, 0.0, 0.0, 0.0};
		}
		Matrix currentTransformationMatrix = new Matrix();
		long rotation = pdPage.getRotation() % 360;
		if (rotation == 90L) {
			currentTransformationMatrix.translate(0, cropBox[2] - cropBox[0]);
			currentTransformationMatrix.rotate(1.5 * Math.PI);
		} if (rotation == 180L) {
			currentTransformationMatrix.translate(cropBox[2] - cropBox[0], cropBox[3] - cropBox[1]);
			currentTransformationMatrix.rotate(Math.PI);
		} if (rotation == 270L) {
			currentTransformationMatrix.translate(cropBox[3], -cropBox[0]);
			currentTransformationMatrix.rotate(0.5 * Math.PI);
		} else {
			currentTransformationMatrix.translate(-cropBox[0], -cropBox[1]);
		}
		return currentTransformationMatrix;
	}

	@Override
	public int getPageNumber() {
		return pdPage.getPageNumber();
	}

	@Override
	public String getPageLabel() {
		return pageLabel;
	}
}
