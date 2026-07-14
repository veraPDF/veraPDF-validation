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

import org.verapdf.wcag.algorithms.semanticalgorithms.utils.StreamInfo;

import java.util.*;

/**
 * @author Maxim Plushchov
 */
public class TextPieces {
	private final Comparator<? super Double> comparator;
	private final SortedSet<TextPiece> textPieces;
	public final boolean isVertical;
	private int currentIndex;
	private double current;

	TextPieces(boolean isVertical) {
		this.isVertical = isVertical;
		this.comparator = isVertical
			? (p1, p2) -> -Double.compare(p1, p2)
			: (p1, p2) -> Double.compare(p1, p2);
		textPieces = isVertical
			? new TreeSet<>(new TextPieceComparatorV())
			: new TreeSet<>(new TextPieceComparatorH());
		currentIndex = 0;
		current = 0;
	}

	public void add(TextPiece textPiece) {
		textPieces.add(textPiece);
		textPiece.startIndex = currentIndex;
		currentIndex += textPiece.value.length();
		current = textPiece.end;
	}

	public String getValue() {
		StringBuilder unicodeValue = new StringBuilder();
		for (TextPiece textPiece : textPieces) {
			unicodeValue.append(textPiece.value);
		}
		return unicodeValue.toString();
	}

	public double getStart() {
		return textPieces.isEmpty() ? 0.0d : textPieces.first().start;
	}

	public double getEnd() {
		return textPieces.stream().map(tp -> tp.end).max(comparator).orElse(getStart());
	}

	public double getCurrent() {
		return current;
	}

	public void setCurrent(double current) {
		this.current = current;
	}

	public void shiftCurrent(double shift) {
		current += shift;
	}
	
	public boolean isEmpty() {
		return textPieces.isEmpty();
	}

	public List<Double> getSymbolEnds() {
		List<Double> ends = new ArrayList<>();
		double start = getStart();
		ends.add(0.0d);
		for (TextPiece textPiece : textPieces) {
			TextChunksHelper.updateSymbolEnds(ends, textPiece.end - textPiece.start, textPiece.start - start,
			                                  textPiece.value != null ? textPiece.value.length() : 0);
		}
		return ends;
	}

	public void addSpaces(double threshold) {
		List<TextPiece> spaces = new ArrayList<>();
		Iterator<TextPiece> validation = textPieces.iterator();
		if (!validation.hasNext()) {
				return;
		}
		TextPiece prev = validation.next();
		double previousEnd = prev.end;

		while (validation.hasNext()) {
				TextPiece piece = validation.next();
				double currentStart = piece.start;
				if (currentStart - previousEnd > threshold) {
						spaces.add(new TextPieces.TextPiece(" ", previousEnd, currentStart));
				}
				previousEnd = piece.end;
		}
		textPieces.addAll(spaces);
	}
	
	public List<StreamInfo> getStreamInfos(int operatorIndex, String xObjectName) {
		List<StreamInfo> streamInfos = new ArrayList<>();
		StreamInfo previousStreamInfo = null;
		for (TextPiece textPiece : textPieces) {
			if (textPiece.startIndex == null) {
				streamInfos.add(new StreamInfo(-1, null, 0, 
						textPiece.value.length()));
				previousStreamInfo = null;
			} else {
				if (previousStreamInfo != null && previousStreamInfo.getEndIndex() == textPiece.startIndex) {
					previousStreamInfo.setEndIndex(textPiece.startIndex + textPiece.value.length());
				} else {
					StreamInfo currentStreamInfo = new StreamInfo(operatorIndex, xObjectName, null, textPiece.startIndex,
							textPiece.startIndex + textPiece.value.length(), currentIndex, null);
					streamInfos.add(currentStreamInfo);
					previousStreamInfo = currentStreamInfo;
				}
			}
		}
		return streamInfos;
	} 

	public static class TextPiece {
		private final String value;

		private final double start;
		private final double center;
		private final double end;

		private Integer startIndex;

		public TextPiece(String value, double start, double end) {
			this.value = value;
			this.start = start;
			this.center = (start + end) / 2;
			this.end = end;
		}
	}

	public static class TextPieceComparatorH implements Comparator<TextPiece> {
		@Override
		public int compare(TextPiece textPiece1, TextPiece textPiece2){
			int res = Double.compare(textPiece1.center, textPiece2.center);
			if (res != 0) {
				return res;
			}
			return Double.compare(textPiece1.end, textPiece2.end);
		}
	}

	public static class TextPieceComparatorV implements Comparator<TextPiece> {
		@Override
		public int compare(TextPiece textPiece1, TextPiece textPiece2){
			int res = -Double.compare(textPiece1.center, textPiece2.center);
			if (res != 0) {
				return res;
			}
			return -Double.compare(textPiece1.end, textPiece2.end);
		}
	}
}
