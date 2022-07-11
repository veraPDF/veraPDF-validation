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

import org.verapdf.cos.COSBase;
import org.verapdf.model.tools.constants.Operators;
import org.verapdf.pd.font.PDFont;
import org.verapdf.wcag.algorithms.entities.geometry.BoundingBox;
import org.verapdf.wcag.algorithms.semanticalgorithms.utils.NodeUtils;

import java.util.List;

/**
 * @author Maxim Plushchov
 */
public class TextChunksHelper {

	protected static COSBase getArgument(List<COSBase> arguments, String operatorType) {
		if (Operators.DOUBLE_QUOTE.equals(operatorType)) {
			if (arguments.size() > 2) {
				return arguments.get(2);
			}
		} else if (!arguments.isEmpty()) {
			return arguments.get(0);
		}
		return null;
	}

	protected static BoundingBox calculateTextBoundingBox(Matrix textRenderingMatrixBefore, Matrix textRenderingMatrixAfter,
												 PDFont font, Integer pageNumber) {
		double[] fontBoundingBox = font.getBoundingBox();
		Double descent = font.getDescent();
		if (descent == null) {
			descent = fontBoundingBox[1];
		}
		Double ascent = font.getAscent();
		if (ascent == null) {
			ascent = fontBoundingBox[3];
		}
		double x1;
		double x2;
		if (textRenderingMatrixBefore.getScaleX() >= 0 && textRenderingMatrixBefore.getShearX() >= 0) {
			x1 = textRenderingMatrixBefore.getTranslateX() + descent * textRenderingMatrixBefore.getShearX() / 1000;
			x2 = textRenderingMatrixAfter.getTranslateX() + ascent * textRenderingMatrixAfter.getShearX() / 1000;
		} else if (textRenderingMatrixBefore.getScaleX() < 0 && textRenderingMatrixBefore.getShearX() < 0) {
			x1 = textRenderingMatrixAfter.getTranslateX() + ascent * textRenderingMatrixAfter.getShearX() / 1000;
			x2 = textRenderingMatrixBefore.getTranslateX() + descent * textRenderingMatrixBefore.getShearX() / 1000;
		} else if (textRenderingMatrixBefore.getScaleX() >= 0) {
			x1 = textRenderingMatrixBefore.getTranslateX() + ascent * textRenderingMatrixBefore.getShearX() / 1000;
			x2 = textRenderingMatrixAfter.getTranslateX() + descent * textRenderingMatrixAfter.getShearX() / 1000;
		} else {
			x1 = textRenderingMatrixAfter.getTranslateX() + descent * textRenderingMatrixAfter.getShearX() / 1000;
			x2 = textRenderingMatrixBefore.getTranslateX() + ascent * textRenderingMatrixBefore.getShearX() / 1000;
		}
		double y1;
		double y2;
		if (textRenderingMatrixBefore.getScaleY() >= 0 && textRenderingMatrixBefore.getShearY() >= 0) {
			y1 = textRenderingMatrixBefore.getTranslateY() + descent * textRenderingMatrixBefore.getScaleY() / 1000;
			y2 = textRenderingMatrixAfter.getTranslateY() + ascent * textRenderingMatrixAfter.getScaleY() / 1000;
		} else if (textRenderingMatrixBefore.getScaleY() < 0 && textRenderingMatrixBefore.getShearY() < 0) {
			y1 = textRenderingMatrixAfter.getTranslateY() + ascent * textRenderingMatrixAfter.getScaleY() / 1000;
			y2 = textRenderingMatrixBefore.getTranslateY() + descent * textRenderingMatrixBefore.getScaleY() / 1000;
		} else if (textRenderingMatrixBefore.getScaleY() >= 0) {
			y1 = textRenderingMatrixAfter.getTranslateY() + descent * textRenderingMatrixAfter.getScaleY() / 1000;
			y2 = textRenderingMatrixBefore.getTranslateY() + ascent * textRenderingMatrixBefore.getScaleY() / 1000;
		} else {
			y1 = textRenderingMatrixBefore.getTranslateY() + ascent * textRenderingMatrixBefore.getScaleY() / 1000;
			y2 = textRenderingMatrixAfter.getTranslateY() + descent * textRenderingMatrixAfter.getScaleY() / 1000;
		}
		return new BoundingBox(pageNumber, x1, y1, x2, y2);
	}
	
	protected static double calculateTextBaseLine(Matrix textMatrix) {
		double rotationDegree = textMatrix.getRotationDegree();
		if (NodeUtils.areCloseNumbers(Math.abs(rotationDegree), 90.0)) {
			return textMatrix.getTranslateX();
		}
		return textMatrix.getTranslateY();
	}

	protected static double calculateTextSize(Matrix textMatrix) {
		return Math.sqrt(textMatrix.getScaleY() * textMatrix.getScaleY() + textMatrix.getShearX() * textMatrix.getShearX());
	}

	protected static double calculateFontWeight(int renderingMode, PDFont font) {
		return renderingMode == 2 ? getBolderFontWeight(font.getFontWeight()) : font.getFontWeight();
	}

	protected static void updateSymbolEnds(List<Double> symbolEnds, double shift, double left, int length) {
		if (length <= 1) {
			symbolEnds.add(left + shift);
		} else {
			double newShift = shift / length;
			for (int i = 1; i <= length; i++) {
				symbolEnds.add(left + i * newShift);
			}
		}
	}

	private static double getBolderFontWeight(Double fontWeight) {
		if (fontWeight < 400) {
			return 400.0;
		}
		if (fontWeight < 600) {
			return 700.0;
		}
		return 900.0;
	}
}
