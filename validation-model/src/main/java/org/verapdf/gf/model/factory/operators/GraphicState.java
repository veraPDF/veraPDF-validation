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
package org.verapdf.gf.model.factory.operators;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSNumber;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.pd.PDExtGState;
import org.verapdf.pd.colors.PDColorSpace;
import org.verapdf.pd.font.PDFont;

/**
 * @author Timur Kamalov
 */
public class GraphicState implements Cloneable {

	private PDColorSpace fillColorSpace;
	private PDColorSpace strokeColorSpace;
	private PDColorSpace fillLastPatternUnderlyingColorSpace = null;
	private PDColorSpace strokeLastPatternUnderlyingColorSpace = null;
	private RenderingMode renderingMode = RenderingMode.FILL;
	private PDFont font;
	private boolean overprintingFlagStroke = false;
	private boolean overprintingFlagNonStroke = false;
	private int opm = 0;
	private GraphicState initialGraphicState = null;
	private boolean processColorOperators = true;
	private Double scaleFactor = null;

	private GraphicState() {
	}

	public GraphicState(PDResourcesHandler resourcesHandler) {
		this.fillColorSpace = resourcesHandler.getColorSpace(ASAtom.DEVICEGRAY);
		this.strokeColorSpace = resourcesHandler.getColorSpace(ASAtom.DEVICEGRAY);
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

	public PDColorSpace getFillLastPatternUnderlyingColorSpace() {
		return fillLastPatternUnderlyingColorSpace;
	}

	public void setFillLastPatternUnderlyingColorSpace(PDColorSpace fillLastPatternUnderlyingColorSpace) {
		this.fillLastPatternUnderlyingColorSpace = fillLastPatternUnderlyingColorSpace;
	}

	public PDColorSpace getStrokeLastPatternUnderlyingColorSpace() {
		return strokeLastPatternUnderlyingColorSpace;
	}

	public void setStrokeLastPatternUnderlyingColorSpace(PDColorSpace strokeLastPatternUnderlyingColorSpace) {
		this.strokeLastPatternUnderlyingColorSpace = strokeLastPatternUnderlyingColorSpace;
	}

	public RenderingMode getRenderingMode() {
		return renderingMode;
	}

	public void setRenderingMode(RenderingMode renderingMode) {
		this.renderingMode = renderingMode;
	}

	public PDFont getFont() {
		return font;
	}

	public void setFont(PDFont font) {
		this.font = font;
	}

	public Double getScaleFactor() {
		return scaleFactor;
	}

	public void setScaleFactor(Double scaleFactor) {
		this.scaleFactor = scaleFactor;
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

	public boolean isProcessColorOperators() {
		return processColorOperators;
	}

	public void disableColorOperators() {
		this.processColorOperators = false;
	}


	public void copyProperties(GraphicState graphicState) {
		this.fillColorSpace = graphicState.getFillColorSpace();
		this.strokeColorSpace = graphicState.getStrokeColorSpace();
		this.fillLastPatternUnderlyingColorSpace = graphicState.getFillLastPatternUnderlyingColorSpace();
		this.strokeLastPatternUnderlyingColorSpace = graphicState.getStrokeLastPatternUnderlyingColorSpace();
		this.renderingMode = graphicState.getRenderingMode();
		this.font = graphicState.getFont();
		this.overprintingFlagStroke = graphicState.isOverprintingFlagStroke();
		this.overprintingFlagNonStroke = graphicState.isOverprintingFlagNonStroke();
		this.opm = graphicState.getOpm();
		this.initialGraphicState = graphicState.getInitialGraphicState();
		this.processColorOperators = graphicState.isProcessColorOperators();
	}

	public void copyPropertiesFormExtGState(PDExtGState extGState) {
		if (extGState != null) {
			PDFont font = extGState.getFont();
			if (font != null) {
				this.font = font;
			}
			COSNumber fontSize = extGState.getCOSFontSize();
			if (fontSize != null) {
				this.scaleFactor = fontSize.getReal();
			}
			Boolean oFS = extGState.getStrokingOverprintControl();
			if (oFS != null) {
				this.overprintingFlagStroke = oFS;
			}
			Boolean oFNS = extGState.getNonStrokingOverprintControl();
			if (oFNS != null) {
				this.overprintingFlagNonStroke = oFNS;
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
		clone.fillLastPatternUnderlyingColorSpace = this.fillLastPatternUnderlyingColorSpace;
		clone.strokeLastPatternUnderlyingColorSpace = this.strokeLastPatternUnderlyingColorSpace;
		clone.renderingMode = this.renderingMode;
		clone.font = this.font;
		clone.scaleFactor = this.scaleFactor;
		clone.overprintingFlagStroke = this.overprintingFlagStroke;
		clone.overprintingFlagNonStroke = this.overprintingFlagNonStroke;
		clone.opm = this.opm;
		clone.initialGraphicState = this.initialGraphicState;
		clone.processColorOperators = this.processColorOperators;
		return clone;
	}

}
