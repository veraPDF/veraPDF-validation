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
package org.verapdf.gf.model.impl.pd.annotations;

import org.verapdf.as.ASAtom;
import org.verapdf.gf.model.impl.pd.GFPDAnnot;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.gf.model.tools.DictionaryKeysHelper;
import org.verapdf.model.pdlayer.PDMarkupAnnot;
import org.verapdf.pd.PDAnnotation;
import org.verapdf.pd.PDPage;

/**
 * @author Maxim Plushchov
 */
public class GFPDMarkupAnnot extends GFPDAnnot implements PDMarkupAnnot {

	public static final String MARKUP_ANNOTATION_TYPE = "PDMarkupAnnot";

	public GFPDMarkupAnnot(PDAnnotation annot, PDResourcesHandler pageResources, PDPage page) {
		this(annot, pageResources, page, MARKUP_ANNOTATION_TYPE);
	}

	public GFPDMarkupAnnot(PDAnnotation annot, PDResourcesHandler pageResources, PDPage page, String type) {
		super(annot, pageResources, page, type);
	}

	@Override
	public String getRC() {
		return DictionaryKeysHelper.getRichTextStringOrStreamEntryStringRepresentation(simpleCOSObject, ASAtom.RC);
	}

	@Override
	public Boolean getcontainsRC() {
		return simpleCOSObject.knownKey(ASAtom.RC);
	}
}
