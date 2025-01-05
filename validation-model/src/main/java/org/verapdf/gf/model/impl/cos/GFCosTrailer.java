/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2025, veraPDF Consortium <info@verapdf.org>
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
package org.verapdf.gf.model.impl.cos;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.pd.GFPDEncryption;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosInfo;
import org.verapdf.model.coslayer.CosTrailer;
import org.verapdf.model.pdlayer.PDEncryption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Timur Kamalov
 */
public class GFCosTrailer extends GFCosDict implements CosTrailer {

	private static final Logger LOGGER = Logger.getLogger(GFCosTrailer.class.getCanonicalName());

	/** Type name for GFCosTrailer */
	public static final String COS_TRAILER_TYPE = "CosTrailer";

	public static final String ENCRYPT = "Encrypt";
	public static final String INFO = "Info";

	private final boolean isEncrypted;

	/**
	 * Default constructor
	 * @param dictionary greenfield COSDictionary
	 */
	public GFCosTrailer(COSDictionary dictionary) {
		super(dictionary, COS_TRAILER_TYPE);
		this.isEncrypted = dictionary.getKey(ASAtom.ENCRYPT).get() != null;
	}

	/**
	 * @return true if the current document is encrypted
	 */
	@Override
	public Boolean getisEncrypted() {
		return this.isEncrypted;
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case ENCRYPT:
				return this.getEncrypt();
			case INFO:
				return this.getInfo();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<PDEncryption> getEncrypt() {
		COSObject object = this.baseObject.getKey(ASAtom.ENCRYPT);
		if (object != null && object.getType() == COSObjType.COS_DICT) {
			List<PDEncryption> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(new GFPDEncryption(new org.verapdf.pd.encryption.PDEncryption(object)));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<CosInfo> getInfo() {
		COSObject object = this.baseObject.getKey(ASAtom.INFO);
		if (object != null && object.getType() == COSObjType.COS_DICT) {
			List<CosInfo> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(new GFCosInfo((COSDictionary)object.getDirectBase()));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}
}
