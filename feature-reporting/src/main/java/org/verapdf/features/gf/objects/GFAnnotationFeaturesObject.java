package org.verapdf.features.gf.objects;

import org.verapdf.core.FeatureParsingException;
import org.verapdf.features.FeatureExtractionResult;
import org.verapdf.features.FeatureObjectType;
import org.verapdf.features.FeaturesData;
import org.verapdf.features.IFeaturesObject;
import org.verapdf.features.gf.tools.GFCreateNodeHelper;
import org.verapdf.features.tools.FeatureTreeNode;
import org.verapdf.pd.PDAnnotation;

import java.util.Set;

/**
 * Feature object for annotation
 *
 * @author Maksim Bezrukov
 */
public class GFAnnotationFeaturesObject implements IFeaturesObject {

	private static final String ID = "id";
	private static final int LOCKED_CONTENTS_FLAG = 512;

	private PDAnnotation annot;
	private String id;
	private String popupId;
	private Set<String> formXObjects;


	/**
	 * Constructs new Annotation Feature Object
	 *
	 * @param annot        pdfbox class represents annotation object
	 * @param id           annotation id
	 * @param popupId      id of the popup annotation
	 * @param formXObjects set of id of the form XObjects which used in appearance stream of this annotation
	 */
	public GFAnnotationFeaturesObject(PDAnnotation annot, String id,
									  String popupId, Set<String> formXObjects) {
		this.annot = annot;
		this.id = id;
		this.popupId = popupId;
		this.formXObjects = formXObjects;
	}

	/**
	 * @return ANNOTATION instance of the FeatureObjectType enumeration
	 */
	@Override
	public FeatureObjectType getType() {
		return FeatureObjectType.ANNOTATION;
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
		if (annot != null) {
			FeatureTreeNode root = FeatureTreeNode.createRootNode("annotation");
			if (id != null) {
				root.setAttribute(ID, id);
			}

			GFCreateNodeHelper.addNotEmptyNode("subType", annot.getSubtype(), root);
			GFCreateNodeHelper.addBoxFeature("rectangle", annot.getRect(), root);
			GFCreateNodeHelper.addNotEmptyNode("contents", annot.getContents(), root);
			GFCreateNodeHelper.addNotEmptyNode("annotationName", annot.getAnnotationName(), root);
			GFCreateNodeHelper.addNotEmptyNode("modifiedDate", annot.getModDate(), root);

			if (formXObjects != null && !formXObjects.isEmpty()) {
				FeatureTreeNode resources = root.addChild("resources");
				for (String xObjID : formXObjects) {
					if (xObjID != null) {
						FeatureTreeNode xObjNode = resources.addChild("xobject");
						xObjNode.setAttribute(ID, xObjID);
					}
				}
			}

			if (popupId != null) {
				FeatureTreeNode popup = root.addChild("popup");
				popup.setAttribute(ID, popupId);
			}

			//TODO: finish me
//			GFCreateNodeHelper.addDeviceColorSpaceNode("color", annot.getColor(), root, collection);
//
//			GFCreateNodeHelper.addNotEmptyNode("invisible", String.valueOf(annot.isInvisible()), root);
//			GFCreateNodeHelper.addNotEmptyNode("hidden", String.valueOf(annot.isHidden()), root);
//			GFCreateNodeHelper.addNotEmptyNode("print", String.valueOf(annot.isPrinted()), root);
//			GFCreateNodeHelper.addNotEmptyNode("noZoom", String.valueOf(annot.isNoZoom()), root);
//			GFCreateNodeHelper.addNotEmptyNode("noRotate", String.valueOf(annot.isNoRotate()), root);
//			GFCreateNodeHelper.addNotEmptyNode("noView", String.valueOf(annot.isNoView()), root);
//			GFCreateNodeHelper.addNotEmptyNode("readOnly", String.valueOf(annot.isReadOnly()), root);
//			GFCreateNodeHelper.addNotEmptyNode("locked", String.valueOf(annot.isLocked()), root);
//			GFCreateNodeHelper.addNotEmptyNode("toggleNoView", String.valueOf(annot.isToggleNoView()), root);
//
//			boolean lockedContents = (annot.getAnnotationFlags() & LOCKED_CONTENTS_FLAG) == LOCKED_CONTENTS_FLAG;
//			GFCreateNodeHelper.addNotEmptyNode("lockedContents", String.valueOf(lockedContents), root);

			collection.addNewFeatureTree(FeatureObjectType.ANNOTATION, root);
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
