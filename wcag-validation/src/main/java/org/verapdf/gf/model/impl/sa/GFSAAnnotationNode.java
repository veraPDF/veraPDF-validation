package org.verapdf.gf.model.impl.sa;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.pd.PDAnnotation;
import org.verapdf.pd.PDNameTreeNode;
import org.verapdf.pd.PDNamesDictionary;
import org.verapdf.pd.PDPage;
import org.verapdf.pd.actions.PDAction;
import org.verapdf.tools.StaticResources;
import org.verapdf.wcag.algorithms.entities.AnnotationNode;
import org.verapdf.wcag.algorithms.entities.geometry.BoundingBox;

import java.util.Objects;

public class GFSAAnnotationNode extends AnnotationNode {

	public GFSAAnnotationNode(PDAnnotation annotation) {
		super(annotation.getSubtype().getValue(), getBoundingBox(annotation), getPageNumber(getDestination(annotation, ASAtom.D)));
	}

	private static BoundingBox getBoundingBox(PDAnnotation annotation) {
		Integer pageNumber = getAnnotationPageNumber(annotation);
		double[] rect = annotation.getRect();
		BoundingBox boundingBox = new BoundingBox(pageNumber, rect);
		if (pageNumber != null) {
			PDPage page = StaticResources.getDocument().getPages().get(pageNumber);
			boundingBox = GFSAPage.createCurrentTransformationMatrix(page).transformBoundingBox(boundingBox);
		}
		return boundingBox;
	}

	private static Integer getAnnotationPageNumber(PDAnnotation annotation) {
		Integer pageNumber = getPageNumber(annotation.getParent());
		if (pageNumber != null) {
			return pageNumber;
		}
		if (annotation.getObject().getKey() == null) {
			return null;
		}
		for (PDPage page : StaticResources.getDocument().getPages()) {
			COSObject annots = page.getKey(ASAtom.ANNOTS);
			if (!annots.empty() && annots.getType() == COSObjType.COS_ARRAY) {
				for (COSObject annot : (COSArray) annots.getDirectBase()) {
					if (annotation.getObject().getKey().equals(annot.getKey())) {
						return page.getPageNumber();
					}
				}
			}
		}
		return null;
	}

	private static Integer getPageNumber(COSObject obj) {
		if (obj != null && ASAtom.PAGE == obj.getNameKey(ASAtom.TYPE)) {
			for (PDPage page : StaticResources.getDocument().getPages()) {
				if (Objects.equals(obj.getKey(), page.getObject().getKey())) {
					return page.getPageNumber();
				}
			}
		}
		return null;
	}

	private static COSObject getDestination(PDAnnotation annot, ASAtom key) {
		COSObject destination = annot.getDestination();
		if (destination == null || destination.empty()) {
			PDAction action = annot.getA();
			if (action != null && ASAtom.GO_TO == action.getSubtype()) {
				destination = action.getObject().getKey(key);
			}
		}
		if (destination == null || destination.empty()) {
			return null;
		}
		if (destination.getType() == COSObjType.COS_STRING || destination.getType() == COSObjType.COS_NAME) {
			PDNamesDictionary namesDictionary = StaticResources.getDocument().getCatalog().getNamesDictionary();
			if (namesDictionary == null) {
				return null;
			}
			PDNameTreeNode dests = namesDictionary.getDests();
			if (dests != null) {
				destination = dests.getObject(destination.getString());
				if (destination == null) {
					return null;
				}
			}
		}
		if (destination.getType() == COSObjType.COS_DICT) {
			destination = destination.getKey(ASAtom.D);
		}
		COSObject obj = null;
		if (destination.getType() == COSObjType.COS_ARRAY && destination.size() > 0) {
			obj = destination.at(0);
		}
		return obj;
	}
}
