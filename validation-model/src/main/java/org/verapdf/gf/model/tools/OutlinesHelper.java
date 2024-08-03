/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2024, veraPDF Consortium <info@verapdf.org>
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
		if (!outlines.isEmpty()) {
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
		while (!stack.isEmpty()) {
			PDOutlineItem item = stack.pop();
			PDOutlineItem nextSibling = item.getNext();
			PDOutlineItem firstChild = item.getFirst();
			if (nextSibling != null && !result.containsKey(GFIDGenerator.getOutlineID(nextSibling))) {
				stack.add(nextSibling);
			}
			if (firstChild != null && !result.containsKey(GFIDGenerator.getOutlineID(firstChild))) {
				stack.add(firstChild);
			}
			result.put(GFIDGenerator.getOutlineID(item), item);
		}

		return result;
	}
}
