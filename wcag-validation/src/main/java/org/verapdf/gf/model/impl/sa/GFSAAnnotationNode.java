package org.verapdf.gf.model.impl.sa;

import org.verapdf.as.ASAtom;
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
		super(annotation.getSubtype().getValue(), new BoundingBox(getPageNumber(annotation.getParent()),
						annotation.getRect()), getPageNumber(getDestination(annotation)));
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

	private static COSObject getDestination(PDAnnotation annot) {
		COSObject destination = annot.getDestination();
		if (destination == null || destination.empty()) {
			PDAction action = annot.getA();
			if (action != null && ASAtom.GO_TO == action.getSubtype()) {
				destination = action.getStructureDestination();
				if (destination == null || destination.empty()) {
					destination = action.getDestination();
				}
			}
		}
		if (destination == null) {
			return null;
		}
		if (destination.getType() == COSObjType.COS_STRING || destination.getType() == COSObjType.COS_NAME) {
			PDNamesDictionary namesDictionary = StaticResources.getDocument().getCatalog().getNamesDictionary();
			PDNameTreeNode dests = namesDictionary.getDests();
			if (dests != null) {
				destination = dests.getObject(destination.getString());
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
