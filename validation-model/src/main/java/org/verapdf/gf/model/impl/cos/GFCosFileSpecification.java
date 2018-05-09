/**
 * This file is part of validation-model, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * validation-model is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with validation-model as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * validation-model as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.cos;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSEmbeddedFileDict;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSStream;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.external.GFEmbeddedFile;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosFileSpecification;
import org.verapdf.model.external.EmbeddedFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFCosFileSpecification extends GFCosDict implements CosFileSpecification {

	/** Type name for GFCosFileSpecification */
	public static final String COS_FILE_SPECIFICATION_TYPE = "CosFileSpecification";

	public static final String EF = "EF";

	private final String f;
	private final String uf;
	private final String afrelationship;

	/**
	 * Default constructor
	 * 
	 * @param dictionary
	 *            greenfield COSDictionary
	 */
	public GFCosFileSpecification(COSDictionary dictionary) {
		super(dictionary, COS_FILE_SPECIFICATION_TYPE);
		this.f = this.baseObject.getStringKey(ASAtom.F);
		this.uf = this.baseObject.getStringKey(ASAtom.UF);
		this.afrelationship = dictionary.getStringKey(ASAtom.AF_RELATIONSHIP);
	}

	@Override
	public String getF() {
		return this.f;
	}

	@Override
	public String getUF() {
		return this.uf;
	}

	@Override
	public String getAFRelationship() {
		return this.afrelationship;
	}

	@Override
	public Boolean getisAssociatedFile() {
		return Boolean.valueOf(this.baseObject != null
				&& StaticContainers.getFileSpecificationKeys().contains(this.baseObject.getObjectKey()));
	}

	@Override
	public Boolean getcontainsEF() {
		return baseObject != null && this.baseObject.knownKey(ASAtom.EF);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (EF.equals(link)) {
			return this.getEFFile();
		}
		return super.getLinkedObjects(link);
	}

	private List<EmbeddedFile> getEFFile() {
		COSObject efDictionary = this.baseObject.getKey(ASAtom.EF);
		if (efDictionary != null && efDictionary.getType().isDictionaryBased()) {
			COSEmbeddedFileDict embeddedFileDict = new
					COSEmbeddedFileDict((COSDictionary) efDictionary.getDirectBase());
			ArrayList<EmbeddedFile> list = new ArrayList<>();
			for (COSStream embeddedFileStream : embeddedFileDict.getEmbeddedFileStreams()) {
				list.add(new GFEmbeddedFile(embeddedFileStream));
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}
}
