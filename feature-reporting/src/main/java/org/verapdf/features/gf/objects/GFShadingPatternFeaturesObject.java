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
import org.verapdf.features.gf.tools.GFCreateNodeHelper;
import org.verapdf.features.tools.FeatureTreeNode;
import org.verapdf.pd.patterns.PDShadingPattern;

/**
 * Features object for shading pattern
 *
 * @author Maksim Bezrukov
 */
public class GFShadingPatternFeaturesObject implements IFeaturesObject {

	private static final String ID = "id";

	private PDShadingPattern shadingPattern;
	private String id;
	private String shadingChild;
	private String extGStateChild;

	/**
	 * Constructs new tilling pattern features object
	 *
	 * @param shadingPattern PDShadingPattern which represents shading pattern for feature report
	 * @param id             id of the object
	 * @param extGStateChild external graphics state id which contains in this shading pattern
	 * @param shadingChild   shading id which contains in this shading pattern
	 */
	public GFShadingPatternFeaturesObject(PDShadingPattern shadingPattern, String id, String shadingChild, String extGStateChild) {
		this.shadingPattern = shadingPattern;
		this.id = id;
		this.shadingChild = shadingChild;
		this.extGStateChild = extGStateChild;
	}

	/**
	 * @return PATTERN instance of the FeatureObjectType enumeration
	 */
	@Override
	public FeatureObjectType getType() {
		return FeatureObjectType.PATTERN;
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
		if (shadingPattern != null && !shadingPattern.empty()) {
			FeatureTreeNode root = FeatureTreeNode.createRootNode("pattern");
			if (id != null) {
				root.setAttribute(ID, id);
			}
			root.setAttribute("type", "shading");

			if (shadingChild != null) {
				FeatureTreeNode shading = root.addChild("shading");
				shading.setAttribute(ID, shadingChild);
			}

			GFCreateNodeHelper.parseMatrix(shadingPattern.getMatrix(), root.addChild("matrix"));

			if (extGStateChild != null) {
				FeatureTreeNode exGState = root.addChild("graphicsState");
				exGState.setAttribute(ID, extGStateChild);
			}

			collection.addNewFeatureTree(FeatureObjectType.PATTERN, root);
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
