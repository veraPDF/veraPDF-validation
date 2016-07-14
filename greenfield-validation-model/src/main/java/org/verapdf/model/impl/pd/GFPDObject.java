package org.verapdf.model.impl.pd;

import org.verapdf.cos.COSObject;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.pdlayer.PDObject;
import org.verapdf.pd.PDDocument;

/**
 * @author Timur Kamalov
 */
public class GFPDObject extends GenericModelObject implements PDObject {

	protected PDDocument document;
	protected org.verapdf.pd.PDObject simplePDDObject;

	public GFPDObject(PDDocument document, final String type) {
		super(type);
		this.document = document;
	}

	public GFPDObject(org.verapdf.pd.PDObject simplePDObject, final String type) {
		super(type);
		this.simplePDDObject = simplePDObject;
	}

}
