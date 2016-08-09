package org.verapdf.model.impl.pd;

import org.verapdf.model.GenericModelObject;
import org.verapdf.model.pdlayer.PDObject;
import org.verapdf.pd.PDContentStream;
import org.verapdf.pd.PDDocument;

/**
 * @author Timur Kamalov
 */
public class GFPDObject extends GenericModelObject implements PDObject {

	public static final int MAX_NUMBER_OF_ELEMENTS = 1;

	protected PDDocument document;
	protected PDContentStream contentStream;
	protected org.verapdf.pd.PDObject simplePDObject;

	public GFPDObject(PDDocument document, final String type) {
		super(type);
		this.document = document;
	}

	public GFPDObject(PDContentStream contentStream, final String type) {
		super(type);
		this.contentStream = contentStream;
	}

	public GFPDObject(org.verapdf.pd.PDObject simplePDObject, final String type) {
		super(type);
		this.simplePDObject = simplePDObject;
	}

}
