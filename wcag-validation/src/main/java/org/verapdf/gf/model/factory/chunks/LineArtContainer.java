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
import org.verapdf.gf.model.impl.containers.StaticStorages;
import org.verapdf.wcag.algorithms.entities.content.LineArtChunk;
import org.verapdf.wcag.algorithms.entities.geometry.BoundingBox;

import java.util.*;

/**
 * @author Maxim Plushchov
 */
public class LineArtContainer {
	private final Map<Long, List<BoundingBox>> lineArtBBoxes;
	private final Map<Long, LineArtChunk> lineArts;
	private final COSKey objectKey;
	private final COSKey parentObjectKey;
	private final Long parentMarkedContent;

	public LineArtContainer(COSKey objectKey, COSKey parentObjectKey, Long parentMarkedContent) {
		lineArtBBoxes = new HashMap<>();
		lineArts = new HashMap<>();
		this.objectKey = objectKey;
		this.parentObjectKey = parentObjectKey;
		this.parentMarkedContent = parentMarkedContent;
	}

	public List<BoundingBox> getBoundingBoxes(Long mcid) {
		return lineArtBBoxes.get(mcid);
	}

	public LineArtChunk getLineArt(Long mcid) {
		return lineArts.get(mcid);
	}

	public void add(Long mcid, BoundingBox boundingBox) {
		List<BoundingBox> list = getBoundingBoxes(mcid);
		if (list != null) {
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
		} else {
			if (mcid != null || parentMarkedContent != null) {
				LineArtChunk lineArtChunk = new LineArtChunk();
				if (mcid != null) {
					StaticStorages.getChunks().add(objectKey, mcid, lineArtChunk);
				} else {
					StaticStorages.getChunks().add(parentObjectKey, parentMarkedContent, lineArtChunk);
				}
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
