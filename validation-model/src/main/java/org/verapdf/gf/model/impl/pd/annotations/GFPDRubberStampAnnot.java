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
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.pdlayer.PDRubberStampAnnot;
import org.verapdf.pd.PDAnnotation;
import org.verapdf.pd.PDPage;

/**
 * @author Maxim Plushchov
 */
public class GFPDRubberStampAnnot extends GFPDMarkupAnnot implements PDRubberStampAnnot {

	public static final String RUBBER_STAMP_ANNOTATION_TYPE = "PDRubberStampAnnot";

	public GFPDRubberStampAnnot(PDAnnotation annot, PDResourcesHandler pageResources, PDPage page) {
		super(annot, pageResources, page, RUBBER_STAMP_ANNOTATION_TYPE);
	}

	@Override
	public String getName() {
		return simplePDObject.getNameKeyStringValue(ASAtom.NAME);
	}

}
