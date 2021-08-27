package org.verapdf.gf.model.factory.chunks;

import org.verapdf.cos.COSKey;
import org.verapdf.wcag.algorithms.entities.content.IChunk;
import org.verapdf.wcag.algorithms.entities.geometry.BoundingBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public boolean containsKey(COSKey pageObjectNumber, Long mcid) {
		Map<Long, List<IChunk>> map = chunks.get(pageObjectNumber);
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

	public List<IChunk> get(COSKey pageObjectNumber, Long mcid) {
		if (pageObjectNumber == null) {
			return get(mcid);
		}
		Map<Long, List<IChunk>> map = chunks.get(pageObjectNumber);
		return map != null ? map.get(mcid) : null;
	}

	public List<IChunk> get(COSKey pageObjectNumber, BoundingBox boundingBox) {
		if (pageObjectNumber == null) {
			return get(boundingBox);
		}
		Map<Long, List<IChunk>> map = chunks.get(pageObjectNumber);
		List<IChunk> chunksList = new ArrayList<>();
		if (map != null) {
			for (List<IChunk> list : map.values()) {
				for (IChunk chunk : list) {
					if (boundingBox.contains(chunk.getBoundingBox())) {
						chunksList.add(chunk);
					}
				}
			}
		}
		return chunksList;
	}

	public List<IChunk> get(BoundingBox boundingBox) {
		List<IChunk> chunksList = new ArrayList<>();
		for (Map<Long, List<IChunk>> map : chunks.values()) {
			for (List<IChunk> list : map.values()) {
				for (IChunk chunk : list) {
					if (boundingBox.contains(chunk.getBoundingBox())) {
						chunksList.add(chunk);
					}
				}
			}
		}
		return chunksList;
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

	public void add(COSKey pageObjectNumber, Long mcid, IChunk chunk) {
		List<IChunk> list = get(pageObjectNumber, mcid);
		if (list != null) {
			list.add(chunk);
		} else {
			list = new ArrayList<>();
			list.add(chunk);
			if (!chunks.containsKey(pageObjectNumber)) {
				chunks.put(pageObjectNumber, new HashMap<>());
			}
			chunks.get(pageObjectNumber).put(mcid, list);
		}
	}

}
