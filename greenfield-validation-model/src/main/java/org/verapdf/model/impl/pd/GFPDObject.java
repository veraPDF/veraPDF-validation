package org.verapdf.model.impl.pd;

import org.verapdf.model.GenericModelObject;
import org.verapdf.model.pdlayer.PDObject;
import org.verapdf.pd.PDDocument;

/**
 * @author Timur Kamalov
 */
public class GFPDObject extends GenericModelObject implements PDObject {

	protected PDDocument document;

	public GFPDObject(PDDocument document, final String type) {
		super(type);
		this.document = document;
	}

}
