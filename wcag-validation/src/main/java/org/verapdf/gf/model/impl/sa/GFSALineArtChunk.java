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
package org.verapdf.gf.model.impl.sa;

import org.verapdf.model.salayer.SALineArtChunk;
import org.verapdf.wcag.algorithms.entities.content.LineArtChunk;

/**
 * @author Maxim Plushchov
 */
public class GFSALineArtChunk extends GFSAChunk implements SALineArtChunk {

	public static final String LINE_ART_CHUNK_TYPE = "SALineArtChunk";

	public final LineArtChunk lineArtChunk;

	public GFSALineArtChunk(LineArtChunk lineArtChunk) {
		super(LINE_ART_CHUNK_TYPE);
		this.lineArtChunk = lineArtChunk;
	}

	@Override
	public String getContext() {
		return lineArtChunk.getBoundingBox().getLocation();
	}

}
