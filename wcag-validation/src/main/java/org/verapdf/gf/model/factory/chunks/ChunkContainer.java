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

import org.verapdf.cos.COSKey;
import org.verapdf.wcag.algorithms.entities.content.IChunk;
import org.verapdf.wcag.algorithms.entities.content.TextChunk;
import org.verapdf.wcag.algorithms.entities.geometry.BoundingBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

/**
 * @author Maxim Plushchov
 */
public class ChunkContainer {

	private final Map<COSKey, Map<Long, List<IChunk>>> chunks;

	public ChunkContainer() {
		chunks = new HashMap<>();
	}

	public boolean containsKey(Long mcid) {
		for (Map<Long, List<IChunk>> map : chunks.values()) {
			if (map.containsKey(mcid)) {
				return true;
			}
		}
		return false;
	}

	public boolean containsKey(COSKey objectNumber, Long mcid) {
		Map<Long, List<IChunk>> map = chunks.get(objectNumber);
		return map != null && map.containsKey(mcid);
	}

	public List<IChunk> get(Long mcid) {
		for (Map<Long, List<IChunk>> map : chunks.values()) {
			if (map.containsKey(mcid)) {
				return map.get(mcid);
			}
		}
		return null;
	}

	public List<IChunk> get(COSKey objectNumber, Long mcid) {
		if (objectNumber == null) {
			return get(mcid);
		}
		Map<Long, List<IChunk>> map = chunks.get(objectNumber);
		return map != null ? map.get(mcid) : null;
	}

	public List<IChunk> get(COSKey objectNumber, BoundingBox boundingBox) {
		if (objectNumber == null) {
			return get(boundingBox);
		}
		Map<Long, List<IChunk>> map = chunks.get(objectNumber);
		if (map != null) {
			return processAllChunks(map, boundingBox);
		}
		return Collections.emptyList();
	}

	public List<IChunk> get(BoundingBox boundingBox) {
		List<IChunk> chunksList = new ArrayList<>();
		for (Map<Long, List<IChunk>> map : chunks.values()) {
			chunksList.addAll(processAllChunks(map, boundingBox));
		}
		return chunksList;
	}

	public List<String> getValues(COSKey objectNumber, BoundingBox boundingBox) {
		if (objectNumber == null) {
			return getValues(boundingBox);
		}
		Map<Long, List<IChunk>> map = chunks.get(objectNumber);
		if (map != null) {
			return processAllChunkValues(map, boundingBox);
		}
		return Collections.emptyList();
	}

	public List<String> getValues(BoundingBox boundingBox) {
		List<String> valueList = new ArrayList<>();
		for (Map<Long, List<IChunk>> map : chunks.values()) {
			valueList.addAll(processAllChunkValues(map, boundingBox));
		}
		return valueList;
	}

	private List<IChunk> processAllChunks(Map<Long, List<IChunk>> map, BoundingBox boundingBox) {
		List<IChunk> chunksList = new ArrayList<>();
		for (List<IChunk> list : map.values()) {
			for (IChunk chunk : list) {
				if (chunk instanceof TextChunk) {
					if (checkTextChunk((TextChunk) chunk, boundingBox)) {
						chunksList.add(chunk);
					}
				} else if (boundingBox.contains(chunk.getBoundingBox())) {
					chunksList.add(chunk);
				}
			}
		}
		return chunksList;
	}

	private boolean checkTextChunk(TextChunk textChunk, BoundingBox boundingBox) {
		BoundingBox textChunkBoundingBox = textChunk.getBoundingBox();
		int numOfSymbols = textChunk.getValue().length();
		double fontSymbolWidth = textChunkBoundingBox.getWidth() / numOfSymbols;
		double fontSymbolHeight = textChunkBoundingBox.getHeight();
		return boundingBox.contains(textChunk.getBoundingBox(), fontSymbolWidth / 2,
		                            fontSymbolHeight / 2);
	}

	private List<String> processAllChunkValues(Map<Long, List<IChunk>> map, BoundingBox boundingBox) {
		List<String> valuesList = new ArrayList<>();
		for (List<IChunk> list : map.values()) {
			for (IChunk chunk : list) {
				if (chunk instanceof TextChunk) {
					String resultValue = checkTextChunkValue((TextChunk) chunk, boundingBox);
					if (resultValue != null) {
						valuesList.add(resultValue);
					}
				}
			}
		}
		return valuesList;
	}

	private String checkTextChunkValue(TextChunk textChunk, BoundingBox boundingBox) {
		BoundingBox textChunkBoundingBox = textChunk.getBoundingBox();
		double widthEps = textChunkBoundingBox.getWidth() / (4 * textChunk.getValue().length());
		double heightEps = textChunkBoundingBox.getHeight() / 4;
		if (boundingBox.contains(textChunkBoundingBox, widthEps, heightEps)) {
			return textChunk.getValue();
		}
		BoundingBox crossBox = BoundingBox.cross(textChunkBoundingBox, boundingBox, widthEps, heightEps);
		if (crossBox == null || crossBox.getHeight() < textChunkBoundingBox.getHeight() - heightEps) {
			return null;
		}

		Integer start = getResultValueStartIndex(textChunk, crossBox.getLeftX());
		Integer end = getResultValueEndIndex(textChunk, crossBox.getRightX());
		if (start == null || end == null) {
			return "";
		}
		return textChunk.getValue().substring(start, end + 1);
	}

	public void add(Long mcid, IChunk chunk) {
		List<IChunk> list = get(mcid);
		if (list != null) {
			list.add(chunk);
		} else {
			list = new ArrayList<>();
			list.add(chunk);
			if (!chunks.containsKey(null)) {
				chunks.put(null, new HashMap<>());
			}
			chunks.get(null).put(mcid, list);
		}
	}

	public void add(COSKey objectNumber, Long mcid, IChunk chunk) {
		List<IChunk> list = get(objectNumber, mcid);
		if (list != null) {
			list.add(chunk);
		} else {
			list = new ArrayList<>();
			list.add(chunk);
			if (!chunks.containsKey(objectNumber)) {
				chunks.put(objectNumber, new HashMap<>());
			}
			chunks.get(objectNumber).put(mcid, list);
		}
	}

	private Integer getResultValueStartIndex(TextChunk textChunk, double leftX) {
		for (int i = 0; i < textChunk.getValue().length(); i++) {
			if (textChunk.getSymbolStartCoordinate(i) >= leftX) {
				return i;
			}
		}
		return null;
	}

	private Integer getResultValueEndIndex(TextChunk textChunk, double rightX) {
		for (int i = textChunk.getValue().length() - 1; i >= 0; i--) {
			if (textChunk.getSymbolEndCoordinate(i) <= rightX) {
				return i;
			}
		}
		return null;
	}

}
