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
