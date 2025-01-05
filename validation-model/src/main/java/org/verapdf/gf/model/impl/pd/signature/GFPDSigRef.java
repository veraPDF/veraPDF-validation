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
package org.verapdf.gf.model.impl.pd.signature;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.pd.GFPDObject;
import org.verapdf.model.pdlayer.PDSigRef;
import org.verapdf.pd.PDCatalog;
import org.verapdf.tools.StaticResources;

import java.util.logging.Logger;

/**
 * Represents signature references dictionary referred by /Reference key from
 * the signature dictionary.
 *
 * @author Sergey Shemyakov
 */
public class GFPDSigRef extends GFPDObject implements PDSigRef {

	private static final Logger LOGGER = Logger.getLogger(GFPDSigRef.class.getCanonicalName());

	/** Type name for {@code GFPDSigRef} */
	public static final String SIGNATURE_REFERENCE_TYPE = "PDSigRef";

	/**
	 * @param dictionary
	 *            is signature reference dictionary.
	 */
	public GFPDSigRef(COSDictionary dictionary) {
		super(new COSObject(dictionary), SIGNATURE_REFERENCE_TYPE);
	}

	/**
	 * @return true if the document permissions dictionary contains DocMDP
	 *         entry.
	 */
	@Override
	public Boolean getpermsContainDocMDP() {
		PDCatalog catalog = StaticResources.getDocument().getCatalog();
		COSDictionary perms = (COSDictionary) catalog.getKey(ASAtom.PERMS).getDirectBase();
		if (perms != null) {
			return perms.knownKey(ASAtom.DOC_MDP);
		}
		return Boolean.FALSE;
	}
}
