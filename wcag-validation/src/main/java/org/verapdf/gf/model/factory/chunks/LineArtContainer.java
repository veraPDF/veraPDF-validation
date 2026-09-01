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

import org.verapdf.cos.COSKey;
import org.verapdf.gf.model.impl.containers.StaticStorages;
import org.verapdf.wcag.algorithms.entities.content.LineArtChunk;
import org.verapdf.wcag.algorithms.entities.content.LineChunk;
import org.verapdf.wcag.algorithms.entities.geometry.BoundingBox;
import org.verapdf.wcag.algorithms.semanticalgorithms.containers.StaticContainers;
import org.verapdf.wcag.algorithms.semanticalgorithms.utils.StreamInfo;

import java.util.*;

/**
 * @author Maxim Plushchov
 */
public class LineArtContainer {
	private final Map<Long, List<BoundingBox>> lineArtBBoxes;
	private final Map<Long, LineArtChunk> lineArts;
	private final Map<Long, List<LineChunk>> lineArtLines;
	/**
	 * Stream position of the first paint operator seen for each mcid.
	 *
	 * <p>Kept because the chunk for an untagged region is not built here — it is
	 * built in {@code ChunkParser.parseLineArts}, once the stream has been read,
	 * where no single operator is in scope any more. Without somewhere to hold
	 * the position, a region whose marks carry no mcid can never be given one.
	 */
	private final Map<Long, List<StreamInfo>> lineArtStreamInfos;
	private final COSKey objectKey;

	public LineArtContainer(COSKey objectKey) {
		lineArtBBoxes = new HashMap<>();
		lineArts = new HashMap<>();
		lineArtLines = new HashMap<>();
		lineArtStreamInfos = new HashMap<>();
		this.objectKey = objectKey;
	}

	public List<BoundingBox> getBoundingBoxes(Long mcid) {
		return lineArtBBoxes.get(mcid);
	}

	public List<LineChunk> getLineChunks(Long mcid) {
		return lineArtLines.get(mcid);
	}

	public LineArtChunk getLineArt(Long mcid) {
		return lineArts.get(mcid);
	}

	/** Stream positions recorded for this mcid, empty when none were. */
	public List<StreamInfo> getStreamInfos(Long mcid) {
		List<StreamInfo> infos = lineArtStreamInfos.get(mcid);
		return infos == null ? Collections.emptyList() : infos;
	}

	/**
	 * Forgets the position for this mcid, so the next region under it records its
	 * own. Called where the boxes are cleared: keeping the old position would
	 * hand a later region the operator that drew an earlier one.
	 */
	public void clearStreamInfos(Long mcid) {
		lineArtStreamInfos.remove(mcid);
	}

	public void add(Long mcid, LineChunk lineChunk) {
		add(mcid, lineChunk, null, null);
	}

	/**
	 * @param operatorIndex index of the paint operator that drew this line, or
	 *                      null when it is not known
	 * @param xObjectName   name of the form the line was drawn inside, or null
	 */
	public void add(Long mcid, LineChunk lineChunk, Integer operatorIndex, String xObjectName) {
		List<LineChunk> lineChunks = getLineChunks(mcid);
		if (lineChunks != null) {
			lineChunks.add(lineChunk);
		} else {
			lineChunks = new LinkedList<>();
			lineChunks.add(lineChunk);
			lineArtLines.put(mcid, lineChunks);
		}
		add(mcid, lineChunk.getBoundingBox(), operatorIndex, xObjectName);
	}

	public void add(Long mcid, BoundingBox boundingBox) {
		add(mcid, boundingBox, null, null);
	}

	public void add(Long mcid, BoundingBox boundingBox, Integer operatorIndex, String xObjectName) {
		if (boundingBox.isEmpty()) {
			return;
		}
		// Every paint operator, not just the first. A StreamInfo names one
		// operator, so a region an infographic draws with thousands of them needs
		// one entry each: recording only the first wrapped one operator and left
		// the rest of the region outside the tree.
		if (StaticContainers.isDataLoader() && operatorIndex != null) {
			List<StreamInfo> infos = lineArtStreamInfos.computeIfAbsent(mcid, k -> new ArrayList<>());
			if (infos.isEmpty() || infos.get(infos.size() - 1).getOperatorIndex() != operatorIndex) {
				infos.add(new StreamInfo(operatorIndex, xObjectName, null));
			}
		}
		List<BoundingBox> list = getBoundingBoxes(mcid);
		if (list != null && !StaticStorages.getIsIgnoreMCIDs()) {
			boolean isSeparateBoundingBox = true;
			for (int i = 0; i < list.size(); i++) {
				if (boundingBox.overlaps(list.get(i))) {
					isSeparateBoundingBox = false;
					list.set(i, list.get(i).union(boundingBox));
					break;
				}
			}
			if (isSeparateBoundingBox) {
				list.add(new BoundingBox(boundingBox));
			}
		} else if (list != null && !list.isEmpty() && StaticStorages.getIsIgnoreMCIDs()) {
			list.get(list.size() - 1).union(boundingBox);
		} else {
			if (mcid != null) {
				LineArtChunk lineArtChunk = new LineArtChunk();
				// No stream info attached here on purpose: only the region's first
				// operator has been seen at this point. ChunkParser.parseLineArts
				// sets the complete list once the stream has been read.
				StaticStorages.getChunks().add(objectKey, mcid, lineArtChunk);
				lineArts.put(mcid, lineArtChunk);
			}
			list = new ArrayList<>();
			list.add(new BoundingBox(boundingBox));
			lineArtBBoxes.put(mcid, list);
		}
	}

	public void unionBoundingBoxes() {
		for (List<BoundingBox> list : lineArtBBoxes.values()) {
			for (int i = list.size() - 2; i >= 0; i--) {
				BoundingBox box = list.get(i);
				for (int j = i + 1; j < list.size();) {
					BoundingBox box2 = list.get(j);
					if (box.overlaps(box2)) {
						box.union(box2);
						list.remove(j);
					} else {
						j++;
					}
				}
			}
		}
	}

	public Set<Map.Entry<Long, List<BoundingBox>>> entrySet() {
		return lineArtBBoxes.entrySet();
	}
}
