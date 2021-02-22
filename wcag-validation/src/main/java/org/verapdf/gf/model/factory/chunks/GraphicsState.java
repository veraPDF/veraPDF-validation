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
package org.verapdf.gf.model.factory.chunks;

/**
 * @author Maxim Plushchov
 */
public class GraphicsState implements Cloneable {

	private Matrix CTM = new Matrix();
	private TextState textState = new TextState();
	private double[] fillColor = new double[]{0};

	public GraphicsState() {
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

	public void copyProperties(GraphicsState graphicState) {
		this.CTM = graphicState.getCTM();
		this.textState = graphicState.getTextState();
		this.fillColor = graphicState.getFillColor();
	}

	@Override
	public GraphicsState clone() {
		GraphicsState clone = new GraphicsState();
		clone.CTM = this.CTM.clone();
		clone.textState = this.textState.clone();
		clone.fillColor = this.fillColor;
		return clone;
	}

}
