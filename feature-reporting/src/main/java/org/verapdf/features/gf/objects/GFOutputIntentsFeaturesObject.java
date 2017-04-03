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
import org.verapdf.features.gf.tools.GFAdapterHelper;
import org.verapdf.features.tools.FeatureTreeNode;
import org.verapdf.pd.PDOutputIntent;

/**
 * Feature object for output intents
 *
 * @author Maksim Bezrukov
 */
public class GFOutputIntentsFeaturesObject implements IFeaturesObject {

	private PDOutputIntent outInt;
	private String iccProfileID;

	/**
	 * Constructs new OutputIntent Feature Object
	 *
	 * @param outInt       class represents OutputIntent object
	 * @param iccProfileID id of the icc profile which use in this outputIntent
	 */
	public GFOutputIntentsFeaturesObject(PDOutputIntent outInt, String iccProfileID) {
		this.outInt = outInt;
		this.iccProfileID = iccProfileID;
	}

	/**
	 * @return OUTPUTINTENT instance of the FeatureObjectType enumeration
	 */
	@Override
	public FeatureObjectType getType() {
		return FeatureObjectType.OUTPUTINTENT;
	}

	/**
	 * Reports featurereport into collection
	 *
	 * @param collection collection for feature report
	 * @return FeatureTreeNode class which represents a root node of the constructed collection tree
	 * @throws FeatureParsingException occurs when wrong features tree node constructs
	 */
	@Override
	public FeatureTreeNode reportFeatures(FeatureExtractionResult collection) throws FeatureParsingException {
		if (outInt != null && !outInt.empty()) {
			FeatureTreeNode root = FeatureTreeNode.createRootNode("outputIntent");

			GFAdapterHelper.addNotEmptyNode("subtype", outInt.getSubtype(), root);
			GFAdapterHelper.addNotEmptyNode("outputCondition", outInt.getOutputCondition(), root);
			GFAdapterHelper.addNotEmptyNode("outputConditionIdentifier", outInt.getOutputConditionIdentifier(), root);
			GFAdapterHelper.addNotEmptyNode("registryName", outInt.getRegistryName(), root);
			GFAdapterHelper.addNotEmptyNode("info", outInt.getInfo(), root);

			if (iccProfileID != null) {
				FeatureTreeNode destOutInt = root.addChild("destOutputIntent");
				destOutInt.setAttribute("id", iccProfileID);
			}

			collection.addNewFeatureTree(FeatureObjectType.OUTPUTINTENT, root);

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
}
