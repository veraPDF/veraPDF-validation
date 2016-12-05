package org.verapdf.features.gf.objects;

import org.verapdf.as.ASAtom;
import org.verapdf.core.FeatureParsingException;
import org.verapdf.features.FeatureExtractionResult;
import org.verapdf.features.FeatureObjectType;
import org.verapdf.features.FeaturesData;
import org.verapdf.features.IFeaturesObject;
import org.verapdf.features.gf.tools.GFCreateNodeHelper;
import org.verapdf.features.tools.FeatureTreeNode;
import org.verapdf.pd.PDGroup;
import org.verapdf.pd.images.PDXForm;

import java.util.Set;

/**
 * Feature object for form xobjects
 *
 * @author Maksim Bezrukov
 */
public class GFFormXObjectFeaturesObject implements IFeaturesObject {

	private static final String ID = "id";

	private PDXForm formXObject;
	private String id;
	private String groupColorSpaceChild;
	private Set<String> extGStateChild;
	private Set<String> colorSpaceChild;
	private Set<String> patternChild;
	private Set<String> shadingChild;
	private Set<String> xobjectChild;
	private Set<String> fontChild;
	private Set<String> propertiesChild;

	/**
	 * Constructs new form xobject features object
	 *
	 * @param formXObject          PDFormXObject which represents form xobject for feature report
	 * @param id                   id of the object
	 * @param groupColorSpaceChild id of the group xobject which contains in the given form xobject
	 * @param extGStateChild       set of external graphics state id which contains in resource dictionary of this xobject
	 * @param colorSpaceChild      set of ColorSpace id which contains in resource dictionary of this xobject
	 * @param patternChild         set of pattern id which contains in resource dictionary of this xobject
	 * @param shadingChild         set of shading id which contains in resource dictionary of this xobject
	 * @param xobjectChild         set of XObject id which contains in resource dictionary of this xobject
	 * @param fontChild            set of font id which contains in resource dictionary of this pattern
	 * @param propertiesChild      set of properties id which contains in resource dictionary of this xobject
	 */
	public GFFormXObjectFeaturesObject(PDXForm formXObject, String id, String groupColorSpaceChild,
									   Set<String> extGStateChild, Set<String> colorSpaceChild, Set<String> patternChild,
									   Set<String> shadingChild, Set<String> xobjectChild, Set<String> fontChild,
									   Set<String> propertiesChild) {
		this.formXObject = formXObject;
		this.id = id;
		this.groupColorSpaceChild = groupColorSpaceChild;
		this.extGStateChild = extGStateChild;
		this.colorSpaceChild = colorSpaceChild;
		this.patternChild = patternChild;
		this.shadingChild = shadingChild;
		this.xobjectChild = xobjectChild;
		this.fontChild = fontChild;
		this.propertiesChild = propertiesChild;
	}

	/**
	 * @return FORM_XOBJECT instance of the FeaturesObjectTypesEnum enumeration
	 */
	@Override
	public FeatureObjectType getType() {
		return FeatureObjectType.FORM_XOBJECT;
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
		if (formXObject != null && !formXObject.empty()) {
			FeatureTreeNode root = FeatureTreeNode.createRootNode("xobject");
			root.setAttribute("type", "form");
			if (id != null) {
				root.setAttribute(ID, id);
			}

			GFCreateNodeHelper.addBoxFeature("bbox", formXObject.getBBox(), root);
			GFCreateNodeHelper.parseMatrix(formXObject.getMatrix(), root.addChild("matrix"));

			PDGroup group = formXObject.getGroup();
			if (group != null) {
				FeatureTreeNode groupNode = root.addChild("group");
				ASAtom groupSubtype = group.getSubtype();
				if (groupSubtype != null) {
					GFCreateNodeHelper.addNotEmptyNode("subtype", groupSubtype, groupNode);
					if (ASAtom.TRANSPARENCY.equals(groupSubtype)) {
						if (groupColorSpaceChild != null) {
							FeatureTreeNode clr = groupNode.addChild("colorSpace");
							clr.setAttribute(ID, groupColorSpaceChild);
						}
						groupNode.addChild("isolated").setValue(String.valueOf(group.isIsolated()));
						groupNode.addChild("knockout").setValue(String.valueOf(group.isKnockout()));
					}

				}
			}

			Long structParents = formXObject.getStructParents();
			if (structParents != null) {
				root.addChild("structParents").setValue(String.valueOf(structParents));
			}

			GFCreateNodeHelper.parseMetadata(formXObject.getMetadata(), "metadata", root, collection);

			parseResources(root);

			collection.addNewFeatureTree(FeatureObjectType.FORM_XOBJECT, root);
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
