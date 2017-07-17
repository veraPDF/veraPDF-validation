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
package org.verapdf.gf.model.factory.operators;

import org.verapdf.cos.COSName;
import org.verapdf.pd.PDExtGState;
import org.verapdf.pd.colors.PDColorSpace;
import org.verapdf.pd.colors.PDDeviceGray;

/**
 * @author Timur Kamalov
 */
public class GraphicState implements Cloneable {

	private PDColorSpace fillColorSpace = PDDeviceGray.INSTANCE;
	private PDColorSpace strokeColorSpace = PDDeviceGray.INSTANCE;
	private RenderingMode renderingMode = RenderingMode.FILL;
	private COSName fontName;
	private boolean overprintingFlagStroke = false;
	private boolean overprintingFlagNonStroke = false;
	private int opm = 0;
	private GraphicState initialGraphicState = null;

	public GraphicState() {
	}

	public PDColorSpace getFillColorSpace() {
		return fillColorSpace;
	}

	public void setFillColorSpace(PDColorSpace fillColorSpace) {
		this.fillColorSpace = fillColorSpace;
	}

	public PDColorSpace getStrokeColorSpace() {
		return strokeColorSpace;
	}

	public void setStrokeColorSpace(PDColorSpace strokeColorSpace) {
		this.strokeColorSpace = strokeColorSpace;
	}

	public RenderingMode getRenderingMode() {
		return renderingMode;
	}

	public void setRenderingMode(RenderingMode renderingMode) {
		this.renderingMode = renderingMode;
	}

	public COSName getFontName() {
		return fontName;
	}

	public void setFontName(COSName fontName) {
		this.fontName = fontName;
	}

	public boolean isOverprintingFlagStroke() {
		return overprintingFlagStroke;
	}

	public void setOverprintingFlagStroke(boolean overprintingFlagStroke) {
		this.overprintingFlagStroke = overprintingFlagStroke;
	}

	public boolean isOverprintingFlagNonStroke() {
		return overprintingFlagNonStroke;
	}

	public void setOverprintingFlagNonStroke(boolean overprintingFlagNonStroke) {
		this.overprintingFlagNonStroke = overprintingFlagNonStroke;
	}

	public int getOpm() {
		return opm;
	}

	public void setOpm(int opm) {
		this.opm = opm;
	}

	public GraphicState getInitialGraphicState() {
		return initialGraphicState;
	}

	public void setInitialGraphicState(GraphicState initialGraphicState) {
		this.initialGraphicState = initialGraphicState.clone();
	}

	public void copyProperties(GraphicState graphicState) {
		this.fillColorSpace = graphicState.getFillColorSpace();
		this.strokeColorSpace = graphicState.getStrokeColorSpace();
		this.renderingMode = graphicState.getRenderingMode();
		this.fontName = graphicState.getFontName();
		this.overprintingFlagStroke = graphicState.isOverprintingFlagStroke();
		this.overprintingFlagNonStroke = graphicState.isOverprintingFlagNonStroke();
		this.opm = graphicState.getOpm();
		this.initialGraphicState = graphicState.getInitialGraphicState();
	}

	public void copyPropertiesFormExtGState(PDExtGState extGState) {
		if (extGState != null) {
			//TODO : copy font settings
			Boolean oFS = extGState.getStrokingOverprintControl();
			if (oFS != null) {
				this.overprintingFlagStroke = oFS.booleanValue();
			}
			Boolean oFNS = extGState.getNonStrokingOverprintControl();
			if (oFNS != null) {
				this.overprintingFlagNonStroke = oFNS.booleanValue();
			}
			Long opm = extGState.getOverprintMode();
			if (opm != null) {
				this.opm = opm.intValue();
			}
		}
	}

	@Override
	protected GraphicState clone() {
		GraphicState clone = new GraphicState();
		clone.fillColorSpace = this.fillColorSpace;
		clone.strokeColorSpace = this.strokeColorSpace;
		clone.renderingMode = this.renderingMode;
		clone.fontName = this.fontName;
		clone.overprintingFlagStroke = this.overprintingFlagStroke;
		clone.overprintingFlagNonStroke = this.overprintingFlagNonStroke;
		clone.opm = this.opm;
		clone.initialGraphicState = this.initialGraphicState;
		return clone;
	}

}
