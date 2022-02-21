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

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Maxim Plushchov
 */
public class TextPieces {

	private final SortedSet<TextPiece> textPieces = new TreeSet<>(new TextPieceComparator());
	private double currentX = 0;

	public void add(TextPiece textPiece) {
		textPieces.add(textPiece);
		currentX = textPiece.endX;
	}

	public String getValue() {
		StringBuilder unicodeValue = new StringBuilder();
		for (TextPiece textPiece : textPieces) {
			unicodeValue.append(textPiece.value);
		}
		return unicodeValue.toString();
	}

	public double getStartX() {
		return textPieces.first().startX;
	}

	public double getEndX() {
		return textPieces.stream().map(TextPiece::getEndX).max(Double::compare).orElse(getStartX());
	}

	public double getCurrentX() {
		return currentX;
	}

	public void shiftCurrentX(double shift) {
		currentX += shift;
	}

	public void setCurrentX(double currentX) {
		this.currentX = currentX;
	}

	public List<Double> getSymbolEnds() {
		return textPieces.stream().map(TextPiece::getEndX).collect(Collectors.toList());
	}

	public static class TextPiece {
		private final String value;
		private final double startX;
		private final double endX;

		public TextPiece(String value, double startX, double endX) {
			this.value = value;
			this.startX = startX;
			this.endX = endX;
		}

		public double getEndX() {
			return endX;
		}
	}

	public static class TextPieceComparator implements Comparator<TextPiece> {

		public int compare(TextPiece textPiece1, TextPiece textPiece2){
			int res = Double.compare(textPiece1.startX, textPiece2.startX);
			if (res != 0) {
				return res;
			}
			return Double.compare(textPiece1.endX, textPiece2.endX);
		}
	}
}
