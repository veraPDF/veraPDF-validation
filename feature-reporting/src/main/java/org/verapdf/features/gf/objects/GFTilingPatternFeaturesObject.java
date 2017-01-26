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
import org.verapdf.pd.patterns.PDTilingPattern;

import java.util.Set;

/**
 * Feature object for tilling pattern
 *
 * @author Maksim Bezrukov
 */
public class GFTilingPatternFeaturesObject implements IFeaturesObject {

	private static final String ID = "id";

	private PDTilingPattern tilingPattern;
	private String id;
	private Set<String> extGStateChild;
	private Set<String> colorSpaceChild;
	private Set<String> patternChild;
	private Set<String> shadingChild;
	private Set<String> xobjectChild;
	private Set<String> fontChild;
	private Set<String> propertiesChild;

	/**
	 * Constructs new tilling pattern features object
	 *
	 * @param tilingPattern   PDTilingPattern which represents tilling pattern for feature report
	 * @param id              id of the object
	 * @param extGStateChild  set of external graphics state id which contains in resource dictionary of this pattern
	 * @param colorSpaceChild set of ColorSpace id which contains in resource dictionary of this pattern
	 * @param patternChild    set of pattern id which contains in resource dictionary of this pattern
	 * @param shadingChild    set of shading id which contains in resource dictionary of this pattern
	 * @param xobjectChild    set of XObject id which contains in resource dictionary of this pattern
	 * @param fontChild       set of font id which contains in resource dictionary of this pattern
	 * @param propertiesChild set of properties id which contains in resource dictionary of this pattern
	 */
	public GFTilingPatternFeaturesObject(PDTilingPattern tilingPattern, String id, Set<String> extGStateChild,
										 Set<String> colorSpaceChild, Set<String> patternChild, Set<String> shadingChild,
										 Set<String> xobjectChild, Set<String> fontChild, Set<String> propertiesChild) {
		this.tilingPattern = tilingPattern;
		this.id = id;
		this.extGStateChild = extGStateChild;
		this.colorSpaceChild = colorSpaceChild;
		this.patternChild = patternChild;
		this.shadingChild = shadingChild;
		this.xobjectChild = xobjectChild;
		this.fontChild = fontChild;
		this.propertiesChild = propertiesChild;
	}

	/**
	 * @return PATTERN instance of the FeaturesObjectTypesEnum enumeration
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
		if (tilingPattern != null && !tilingPattern.empty()) {
			FeatureTreeNode root = FeatureTreeNode.createRootNode("pattern");
			if (id != null) {
				root.setAttribute(ID, id);
			}
			root.setAttribute("type", "tiling");

			root.addChild("paintType").setValue(String.valueOf(tilingPattern.getPaintType()));
			root.addChild("tilingType").setValue(String.valueOf(tilingPattern.getTilingType()));

			GFCreateNodeHelper.addBoxFeature("bbox", tilingPattern.getBBox(), root);

			root.addChild("xStep").setValue(String.valueOf(tilingPattern.getXStep()));
			root.addChild("yStep").setValue(String.valueOf(tilingPattern.getYStep()));

			GFCreateNodeHelper.parseMatrix(tilingPattern.getMatrix(), root.addChild("matrix"));

			parseResources(root);

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

	private void parseResources(FeatureTreeNode root) throws FeatureParsingException {

		if ((extGStateChild != null && !extGStateChild.isEmpty()) ||
				(colorSpaceChild != null && !colorSpaceChild.isEmpty()) ||
				(patternChild != null && !patternChild.isEmpty()) ||
				(shadingChild != null && !shadingChild.isEmpty()) ||
				(xobjectChild != null && !xobjectChild.isEmpty()) ||
				(fontChild != null && !fontChild.isEmpty()) ||
				(propertiesChild != null && !propertiesChild.isEmpty())) {
			FeatureTreeNode resources = root.addChild("resources");

			GFCreateNodeHelper.parseIDSet(extGStateChild, "graphicsState", "graphicsStates", resources);
			GFCreateNodeHelper.parseIDSet(colorSpaceChild, "colorSpace", "colorSpaces", resources);
			GFCreateNodeHelper.parseIDSet(patternChild, "pattern", "patterns", resources);
			GFCreateNodeHelper.parseIDSet(shadingChild, "shading", "shadings", resources);
			GFCreateNodeHelper.parseIDSet(xobjectChild, "xobject", "xobjects", resources);
			GFCreateNodeHelper.parseIDSet(fontChild, "font", "fonts", resources);
			GFCreateNodeHelper.parseIDSet(propertiesChild, "propertiesDict", "propertiesDicts", resources);
		}
	}
}
