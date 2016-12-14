package org.verapdf.features.gf.objects;

import org.verapdf.core.FeatureParsingException;
import org.verapdf.features.FeatureExtractionResult;
import org.verapdf.features.FeatureObjectType;
import org.verapdf.features.FeaturesData;
import org.verapdf.features.IFeaturesObject;
import org.verapdf.features.gf.tools.GFCreateNodeHelper;
import org.verapdf.features.tools.FeatureTreeNode;
import org.verapdf.pd.PDPage;

import java.util.Set;

/**
 * Feature object for page
 *
 * @author Maksim Bezrukov
 */
public class GFPageFeaturesObject implements IFeaturesObject {

	private static final String ID = "id";

	private PDPage page;
	private String thumb;
	private Set<String> annotsId;
	private Set<String> extGStateChild;
	private Set<String> colorSpaceChild;
	private Set<String> patternChild;
	private Set<String> shadingChild;
	private Set<String> xobjectChild;
	private Set<String> fontChild;
	private Set<String> propertiesChild;
	private int index;

	/**
	 * Constructs new Page Feature Object
	 *
	 * @param page            class represents page object
	 * @param thumb           thumbnail image id
	 * @param annotsId        set of annotations id which contains in this page
	 * @param extGStateChild  set of external graphics state id which contains in resource dictionary of this page
	 * @param colorSpaceChild set of ColorSpace id which contains in resource dictionary of this page
	 * @param patternChild    set of pattern id which contains in resource dictionary of this page
	 * @param shadingChild    set of shading id which contains in resource dictionary of this page
	 * @param xobjectChild    set of XObject id which contains in resource dictionary of this page
	 * @param fontChild       set of font id which contains in resource dictionary of this page
	 * @param propertiesChild set of properties id which contains in resource dictionary of this page
	 * @param index           page index
	 */
	public GFPageFeaturesObject(PDPage page,
								String thumb,
								Set<String> annotsId,
								Set<String> extGStateChild,
								Set<String> colorSpaceChild,
								Set<String> patternChild,
								Set<String> shadingChild,
								Set<String> xobjectChild,
								Set<String> fontChild,
								Set<String> propertiesChild,
								int index) {
		this.page = page;
		this.thumb = thumb;
		this.annotsId = annotsId;
		this.extGStateChild = extGStateChild;
		this.colorSpaceChild = colorSpaceChild;
		this.patternChild = patternChild;
		this.shadingChild = shadingChild;
		this.xobjectChild = xobjectChild;
		this.fontChild = fontChild;
		this.propertiesChild = propertiesChild;
		this.index = index;
	}

	/**
	 * @return PAGE instance of the FeatureObjectType enumeration
	 */
	@Override
	public FeatureObjectType getType() {
		return FeatureObjectType.PAGE;
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
		if (page != null && !page.empty()) {
			FeatureTreeNode root = FeatureTreeNode.createRootNode("page");

			root.setAttribute("orderNumber", Integer.toString(index));

			GFCreateNodeHelper.addBoxFeature("mediaBox", page.getMediaBox(), root);
			GFCreateNodeHelper.addBoxFeature("cropBox", page.getCropBox(), root);
			GFCreateNodeHelper.addBoxFeature("trimBox", page.getTrimBox(), root);
			GFCreateNodeHelper.addBoxFeature("bleedBox", page.getBleedBox(), root);
			GFCreateNodeHelper.addBoxFeature("artBox", page.getArtBox(), root);

			Long rotation = page.getRotation();
			if (rotation != null) {
				root.addChild("rotation").setValue(String.valueOf(rotation));
			}

			Double scaling = page.getScaling();
			if (scaling != null) {
				root.addChild("scaling").setValue(String.valueOf(scaling));
			}

			if (thumb != null) {
				FeatureTreeNode thumbNode = root.addChild("thumbnail");
				thumbNode.setAttribute(ID, thumb);
			}

			GFCreateNodeHelper.parseMetadata(page.getMetadata(), "metadata", root, collection);

			GFCreateNodeHelper.parseIDSet(annotsId, "annotation", "annotations", root);

			parseResources(root);

			collection.addNewFeatureTree(FeatureObjectType.PAGE, root);

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
