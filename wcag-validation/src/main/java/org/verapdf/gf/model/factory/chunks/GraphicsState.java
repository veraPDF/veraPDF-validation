/*
 * This file is part of veraPDF WCAG Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2026, veraPDF Consortium <info@verapdf.org>
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
package org.verapdf.gf.model.factory.chunks;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSNumber;
import org.verapdf.pd.PDResourcesHandler;
import org.verapdf.pd.PDExtGState;
import org.verapdf.pd.colors.PDColorSpace;
import org.verapdf.pd.font.PDFont;
import org.verapdf.wcag.algorithms.entities.content.LineChunk;
import org.verapdf.wcag.algorithms.entities.geometry.BoundingBox;

/**
 * @author Maxim Plushchov
 */
public class GraphicsState implements Cloneable {

	private Matrix CTM = new Matrix();
	private TextState textState = new TextState();
	private double[] fillColor = new double[]{0};
	private PDColorSpace fillColorSpace;
	private boolean processColorOperators = true;
	private double lineWidth = 1.0;
	private int lineCap = LineChunk.BUTT_CAP_STYLE;
	/**
	 * The effective clipping path in force, approximated by its bounding box in
	 * page space, or null when nothing has clipped this state yet.
	 *
	 * <p>null means unclipped. An <em>empty</em> box means the clip admits
	 * nothing, and it is kept as an empty box: an empty intersection must never
	 * collapse back to null, because "nothing is visible" and "everything is
	 * visible" are opposite answers.
	 */
	private BoundingBox clipBox;

	private GraphicsState() {

	}

	public GraphicsState(PDResourcesHandler resourcesHandler) {
		this.fillColorSpace = resourcesHandler.getColorSpace(ASAtom.DEVICEGRAY);
	}

	public PDColorSpace getFillColorSpace() {
		return fillColorSpace;
	}

	public void setFillColorSpace(PDColorSpace fillColorSpace) {
		this.fillColorSpace = fillColorSpace;
	}

	public boolean isProcessColorOperators() {
		return processColorOperators;
	}

	public void disableColorOperators() {
		this.processColorOperators = false;
	}

	public Matrix getCTM() {
		return CTM;
	}

	public void setCTM(Matrix CTM) {
		this.CTM = CTM.clone();
	}

	public TextState getTextState() {
		return textState;
	}

	public void setTextState(TextState textState) {
		this.textState = textState.clone();
	}

	public double[] getFillColor() {
		return fillColor;
	}

	public void setFillColor(double[] fillColor) {
		this.fillColor = fillColor.clone();
	}

	public double getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(double lineWidth) {
		this.lineWidth = lineWidth;
	}

	public int getLineCap() {
		return lineCap;
	}

	public void setLineCap(int lineCap) {
		this.lineCap = lineCap;
	}

	/**
	 * @return the bounding box of the effective clipping path in page space, or
	 *         null when this state is unclipped
	 */
	public BoundingBox getClipBox() {
		return clipBox;
	}

	/**
	 * Intersects the effective clipping path with another box, in page space.
	 * The first box to arrive becomes the clip; every later one narrows it.
	 *
	 * @param box the new clip box in page space; null and boxes without a page
	 *            number are ignored, since neither can be compared with a chunk
	 */
	public void intersectClip(BoundingBox box) {
		if (box == null || box.getPageNumber() == null) {
			return;
		}
		this.clipBox = this.clipBox == null ? new BoundingBox(box) : intersection(this.clipBox, box);
	}

	/**
	 * BoundingBox.cross returns null for disjoint boxes and the public
	 * constructors order their corners, so neither can express an empty clip.
	 * Detect the empty case here and answer the canonical empty box, which
	 * reports isEmpty() and does not overlap anything.
	 */
	private static BoundingBox intersection(BoundingBox first, BoundingBox second) {
		double leftX = Math.max(first.getLeftX(), second.getLeftX());
		double rightX = Math.min(first.getRightX(), second.getRightX());
		double bottomY = Math.max(first.getBottomY(), second.getBottomY());
		double topY = Math.min(first.getTopY(), second.getTopY());
		if (leftX > rightX || bottomY > topY) {
			return new BoundingBox(first.getPageNumber());
		}
		return new BoundingBox(first.getPageNumber(), leftX, bottomY, rightX, topY);
	}

	public void copyProperties(GraphicsState graphicState) {
		this.CTM = graphicState.getCTM();
		this.textState = graphicState.getTextState();
		this.fillColor = graphicState.getFillColor();
		this.fillColorSpace = graphicState.getFillColorSpace();
		this.processColorOperators = graphicState.isProcessColorOperators();
		this.lineWidth = graphicState.getLineWidth();
		this.lineCap = graphicState.getLineCap();
		this.clipBox = graphicState.getClipBox();
	}

	public void copyPropertiesFromExtGState(PDExtGState extGState) {
		if (extGState != null) {
			PDFont font = extGState.getFont();
			if (font != null) {
				this.getTextState().setTextFont(font);
			}
			COSNumber fontSize = extGState.getCOSFontSize();
			if (fontSize != null) {
				this.getTextState().setTextFontSize(fontSize.getReal());
			}
		}
	}

	@Override
	public GraphicsState clone() {
		GraphicsState clone = new GraphicsState();
		clone.CTM = this.CTM.clone();
		clone.textState = this.textState.clone();
		clone.fillColor = this.fillColor;
		clone.fillColorSpace = this.fillColorSpace;
		clone.processColorOperators = this.processColorOperators;
		clone.lineWidth = this.lineWidth;
		clone.lineCap = this.lineCap;
		clone.clipBox = this.clipBox == null ? null : new BoundingBox(this.clipBox);
		return clone;
	}
}
