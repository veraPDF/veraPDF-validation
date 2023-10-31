/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.pd;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSKey;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.tools.GFIDGenerator;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.pdlayer.PDObject;
import org.verapdf.pd.PDContentStream;
import org.verapdf.pd.PDDocument;
import org.verapdf.pd.font.PDFont;
import org.verapdf.pd.font.cmap.PDCMap;

import java.util.stream.Collectors;

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
			this.simpleCOSObject = simplePDObject.getObject();
			COSKey key = simplePDObject.getObject().getObjectKey();
			id = key != null ?
					key.getNumber() + " " + key.getGeneration() + " obj " + this.getObjectType()
					: super.getID();
		}
	}

	public GFPDObject(PDFont font, final String type) {
		super(type);
		this.pdFont = font;
		if (font != null) {
			this.id = GFIDGenerator.generateID(font);
		}
	}

	public GFPDObject(PDCMap pdcMap, final String type) {
		super(type);
		this.pdcMap = pdcMap;
		this.simplePDObject = pdcMap;

		if (simplePDObject != null && !simplePDObject.getObject().empty()) {
			this.simpleCOSObject = simplePDObject.getObject();
			COSKey key = simplePDObject.getObject().getObjectKey();
			id = key != null ?
					key.getNumber() + " " + key.getGeneration() + " obj " + this.getObjectType()
					: super.getID();
		}
	}

	public GFPDObject(COSObject simpleCOSObject, final String type) {
		super(type);
		this.simpleCOSObject = simpleCOSObject;
	}

	@Override
	public String getentries() {
		if (this.simpleCOSObject != null && !this.simpleCOSObject.empty()) {
			return this.simpleCOSObject.getDirectBase().getKeySet().stream()
					.map(ASAtom::getValue)
					.collect(Collectors.joining("&"));
		}
		return "";
	}
	
	@Override
	public String getobjectKey() {
		return simpleCOSObject != null && !simpleCOSObject.empty() ? simpleCOSObject.getObjectKey().toString() : null;
	}

	@Override
	public String getID() {
		return this.id == null ? super.getID() : this.id;
	}
}
