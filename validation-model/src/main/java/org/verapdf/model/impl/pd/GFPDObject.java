package org.verapdf.model.impl.pd;

import org.verapdf.cos.COSKey;
import org.verapdf.cos.COSObject;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.impl.pd.actions.GFPDAction;
import org.verapdf.model.pdlayer.PDAction;
import org.verapdf.model.pdlayer.PDObject;
import org.verapdf.model.tools.GFIDGenerator;
import org.verapdf.pd.PDContentStream;
import org.verapdf.pd.PDDocument;
import org.verapdf.pd.font.PDFont;
import org.verapdf.pd.font.cmap.PDCMap;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFPDObject extends GenericModelObject implements PDObject {

	public static final int MAX_NUMBER_OF_ELEMENTS = 1;

	protected PDDocument document;
	protected PDContentStream contentStream;
	protected org.verapdf.pd.PDObject simplePDObject;
	protected PDFont pdFont;
	protected PDCMap pdcMap;
	protected COSObject simpleCOSObject;

	protected String id;

	public GFPDObject(PDDocument document, final String type) {
		super(type);
		this.document = document;
	}

	public GFPDObject(PDContentStream contentStream, final String type) {
		super(type);
		this.contentStream = contentStream;

		COSObject simpleObject = ((org.verapdf.pd.PDObject) contentStream).getObject();
		if (simpleObject != null && !simpleObject.empty()) {
			COSKey key = simpleObject.getObjectKey();
			id = key != null ?
					key.getNumber() + " " + key.getGeneration() + " obj " + this.getObjectType()
					: super.getID();
		}
	}

	public GFPDObject(org.verapdf.pd.PDObject simplePDObject, final String type) {
		super(type);
		this.simplePDObject = simplePDObject;

		if (simplePDObject != null && !simplePDObject.getObject().empty()) {
			COSKey key = simplePDObject.getObject().getObjectKey();
			id = key != null ?
					key.getNumber() + " " + key.getGeneration() + " obj " + this.getObjectType()
					: super.getID();
		}
	}

	public GFPDObject(PDFont font, final String type) {
		super(type);
		this.pdFont = font;
		this.id = GFIDGenerator.generateID(font);
	}

	public GFPDObject(PDCMap pdcMap, final String type) {
		super(type);
		this.pdcMap = pdcMap;
	}

	public GFPDObject(COSObject simpleCOSObject, final String type) {
		super(type);
		this.simpleCOSObject = simpleCOSObject;
	}

	protected void addAction(List<PDAction> actions, org.verapdf.pd.actions.PDAction raw) {
		PDAction action = GFPDAction.getAction(raw);
		if (action != null) {
			actions.add(action);
		}
	}

	@Override
	public String getID() {
		return this.id == null ? super.getID() : this.id;
	}
}
