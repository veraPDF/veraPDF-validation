/**
 * This file is part of feature-reporting, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * feature-reporting is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with feature-reporting as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * feature-reporting as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.features.gf.objects;

import org.verapdf.core.FeatureParsingException;
import org.verapdf.features.FeatureExtractionResult;
import org.verapdf.features.FeatureObjectType;
import org.verapdf.features.FeaturesData;
import org.verapdf.features.IFeaturesObject;
import org.verapdf.features.gf.tools.ColorComponent;
import org.verapdf.features.gf.tools.GFAdapterHelper;
import org.verapdf.features.tools.ErrorsHelper;
import org.verapdf.features.tools.FeatureTreeNode;
import org.verapdf.pd.PDOutlineDictionary;
import org.verapdf.pd.PDOutlineItem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Feature object for outlines
 *
 * @author Maksim Bezrukov
 */
public class GFOutlinesFeaturesObject implements IFeaturesObject {

	private PDOutlineDictionary outline;

	/**
	 * Constructs new OutputIntent Feature Object
	 *
	 * @param outline class represents outlines object
	 */
	public GFOutlinesFeaturesObject(PDOutlineDictionary outline) {
		this.outline = outline;
	}

	/**
	 * @return OUTLINES instance of the FeatureObjectType enumeration
	 */
	@Override
	public FeatureObjectType getType() {
		return FeatureObjectType.OUTLINES;
	}

	/**
	 * Reports featurereport into collection
	 *
	 * @param collection collection for feature report
	 * @return FeatureTreeNode class which represents a root node of the
	 * constructed collection tree
	 * @throws FeatureParsingException occurs when wrong features tree node constructs
	 */
	@Override
	public FeatureTreeNode reportFeatures(FeatureExtractionResult collection)
			throws FeatureParsingException {
		if (outline != null && !outline.empty()) {
			FeatureTreeNode root = FeatureTreeNode.createRootNode("outlines");

			Set<PDOutlineItem> items = new HashSet<>();
			for (PDOutlineItem item : getChildren(outline)) {
				if (!items.contains(item)) {
					createItem(item, root, collection, items);
				}
			}

			collection
					.addNewFeatureTree(FeatureObjectType.OUTLINES, root);
			return root;
		}
		return null;
	}

	/**
	 * @return null
	 */
	@Override
	public FeaturesData getData() {
		return null;
	}

	private static void createItem(PDOutlineItem item, FeatureTreeNode root,
								   FeatureExtractionResult collection, Set<PDOutlineItem> items) throws FeatureParsingException {
		if (item != null && !item.empty()) {
			items.add(item);
			FeatureTreeNode itemNode = root.addChild("outline");

			GFAdapterHelper.addNotEmptyNode("title", item.getTitle(), itemNode);

			FeatureTreeNode color = itemNode.addChild("color");
			double[] clr = item.getColor();
			if (clr != null) {
				color.setAttributes(ColorComponent.RGB_COMPONENTS.createAttributesMap(clr));
			} else {
				ErrorsHelper.addErrorIntoCollection(collection,
						color,
						"Color must be in rgb form");
			}


			FeatureTreeNode style = itemNode.addChild("style");
			style.setAttribute("italic", String.valueOf(item.isItalic()));
			style.setAttribute("bold", String.valueOf(item.isBold()));

			for (PDOutlineItem child : getChildren(item)) {
				if (!items.contains(child)) {
					createItem(child, itemNode, collection, items);
				}
			}
		}
	}


	public static List<PDOutlineItem> getChildren(PDOutlineDictionary dictionary) {
		List<PDOutlineItem> res = new ArrayList<>();
		PDOutlineItem curr = dictionary.getFirst();
		while (curr != null) {
			res.add(curr);
			curr = curr.getNext();
		}
		return res;
	}
}
