package org.verapdf.features.gf.objects;

import org.verapdf.core.FeatureParsingException;
import org.verapdf.features.FeatureExtractionResult;
import org.verapdf.features.FeatureObjectType;
import org.verapdf.features.FeaturesData;
import org.verapdf.features.IFeaturesObject;
import org.verapdf.features.gf.tools.GFCreateNodeHelper;
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

			GFCreateNodeHelper.addNotEmptyNode("subtype", outInt.getSubtype(), root);
			GFCreateNodeHelper.addNotEmptyNode("outputCondition", outInt.getOutputCondition(), root);
			GFCreateNodeHelper.addNotEmptyNode("outputConditionIdentifier", outInt.getOutputConditionIdentifier(), root);
			GFCreateNodeHelper.addNotEmptyNode("registryName", outInt.getRegistryName(), root);
			GFCreateNodeHelper.addNotEmptyNode("info", outInt.getInfo(), root);

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
