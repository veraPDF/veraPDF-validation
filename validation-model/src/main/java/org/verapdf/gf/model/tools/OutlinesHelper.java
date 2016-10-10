package org.verapdf.gf.model.tools;

import org.verapdf.gf.model.impl.pd.GFPDOutline;
import org.verapdf.model.pdlayer.PDOutline;
import org.verapdf.pd.PDCatalog;
import org.verapdf.pd.PDOutlineDictionary;
import org.verapdf.pd.PDOutlineItem;

import java.util.*;

/**
 * @author Maksim Bezrukov
 */
public class OutlinesHelper {

	private OutlinesHelper() {
		// disable default constructor
	}

	public static List<PDOutline> getOutlines(PDCatalog catalog) {
		Map<String, PDOutlineItem> outlines = getOutlinesMap(catalog);
		if (outlines.size() > 0) {
			List<PDOutline> result = new ArrayList<>(outlines.size());
			for (Map.Entry<String, PDOutlineItem> entry : outlines.entrySet()) {
				result.add(new GFPDOutline(entry.getValue(), entry.getKey()));
			}
			outlines.clear();
			return Collections.unmodifiableList(result);
		}
		return Collections.emptyList();
	}

	private static Map<String, PDOutlineItem> getOutlinesMap(PDCatalog catalog) {
		if (catalog != null) {
			PDOutlineDictionary documentOutline = catalog.getOutlines();
			if (documentOutline != null) {
				PDOutlineItem firstChild = documentOutline.getFirst();
				if (firstChild != null) {
					Deque<PDOutlineItem> stack = new ArrayDeque<>();
					stack.push(firstChild);
					return getOutlinesMap(stack);
				}
			}
		}

		return Collections.emptyMap();
	}

	private static Map<String, PDOutlineItem> getOutlinesMap(Deque<PDOutlineItem> stack) {
		Map<String, PDOutlineItem> result = new HashMap<>();
		do {
			PDOutlineItem item = stack.pop();
			PDOutlineItem nextSibling = item.getNext();
			PDOutlineItem firstChild = item.getFirst();
			if (nextSibling != null && !result.containsKey(nextSibling)) {
				stack.add(nextSibling);
			}
			if (firstChild != null && !result.containsKey(firstChild)) {
				stack.add(firstChild);
			}
			result.put(GFIDGenerator.generateID(item), item);
		} while (!stack.isEmpty());

		return result;
	}
}
