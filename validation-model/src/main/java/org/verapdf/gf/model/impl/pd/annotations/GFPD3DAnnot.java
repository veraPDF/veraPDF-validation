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
package org.verapdf.gf.model.impl.pd.annotations;

import org.verapdf.gf.model.impl.pd.GFPD3DStream;
import org.verapdf.gf.model.impl.pd.GFPDAnnot;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PD3DAnnot;
import org.verapdf.model.pdlayer.PD3DStream;
import org.verapdf.pd.PDAnnotation;
import org.verapdf.pd.PDPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maxim Plushchov
 */
public class GFPD3DAnnot extends GFPDAnnot implements PD3DAnnot {

	public static final String ANNOTATION_3D_TYPE = "PD3DAnnot";

	public static final String stream3D = "stream3D";

	public GFPD3DAnnot(PDAnnotation annot, PDResourcesHandler pageResources, PDPage page) {
		super(annot, pageResources, page, ANNOTATION_3D_TYPE);
	}

	private List<PD3DStream> get3DStream() {
		org.verapdf.pd.PD3DStream stream = ((PDAnnotation) simplePDObject).get3DD();
		if (stream != null) {
			List<PD3DStream> streams = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			streams.add(new GFPD3DStream(stream, resources));
			return streams;
		}
		return Collections.emptyList();
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case stream3D:
				return this.get3DStream();
			default:
				return super.getLinkedObjects(link);
		}
	}

}
