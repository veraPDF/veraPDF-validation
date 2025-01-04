/**
 * This file is part of veraPDF WCAG Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2025, veraPDF Consortium <info@verapdf.org>
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

import org.verapdf.pd.font.PDFont;

/**
 * @author Maxim Plushchov
 */
public class TextState implements Cloneable {

	private PDFont textFont;
	private Double textFontSize = null;
	private double characterSpacing = 0;
	private double wordSpacing = 0;
 	private double horizontalScaling = 1;
	private double textLeading = 0;
	private double textRise = 0;
	private int renderingMode = 0;

	public TextState() {
	}

	public PDFont getTextFont() {
		return textFont;
	}

	public void setTextFont(PDFont textFont) {
		this.textFont = textFont;
	}

	public Double getTextFontSize() {
		return textFontSize;
	}

	public void setTextFontSize(Double textFontSize) {
		this.textFontSize = textFontSize;
	}

	public double getCharacterSpacing() {
		return characterSpacing;
	}

	public void setCharacterSpacing(double characterSpacing) {
		this.characterSpacing = characterSpacing;
	}

	public double getWordSpacing() {
		return  wordSpacing;
	}

	public void setWordSpacing(double wordSpacing) {
		this.wordSpacing = wordSpacing;
	}

	public double getHorizontalScaling() {
		return horizontalScaling;
	}

	public void setHorizontalScaling(double horizontalScaling) {
		this.horizontalScaling = horizontalScaling;
	}

	public double getTextLeading() {
		return textLeading;
	}

	public void setTextLeading(double textLeading) {
		this.textLeading = textLeading;
	}

	public double getTextRise() {
		return textRise;
	}

	public void setTextRise(double textRise) {
		this.textRise = textRise;
	}

	public int getRenderingMode() {
		return renderingMode;
	}

	public void setRenderingMode(int renderingMode) {
		this.renderingMode = renderingMode;
	}

	public void copyProperties(TextState textState) {
		this.textFont = textState.getTextFont();
		this.textFontSize = textState.getTextFontSize();
		this.characterSpacing = textState.getCharacterSpacing();
		this.textRise = textState.getTextRise();
		this.textLeading = textState.getTextLeading();
		this.horizontalScaling = textState.getHorizontalScaling();
		this.wordSpacing = textState.getWordSpacing();
		this.renderingMode = textState.getRenderingMode();
	}

	@Override
	protected TextState clone() {
		TextState clone = new TextState();
		clone.textFont = this.textFont;
		clone.textFontSize = this.textFontSize;
		clone.characterSpacing = this.characterSpacing;
		clone.wordSpacing = this.wordSpacing;
		clone.horizontalScaling = this.horizontalScaling;
		clone.textLeading = this.textLeading;
		clone.textRise = this.textRise;
		clone.renderingMode = this.renderingMode;
		return clone;
	}

}
