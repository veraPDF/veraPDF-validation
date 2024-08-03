/**
 * This file is part of veraPDF WCAG Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2024, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF WCAG Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF WCAG Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF WCAG Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.sa;

import org.verapdf.model.salayer.SATextChunk;
import org.verapdf.wcag.algorithms.entities.content.TextChunk;

/**
 * @author Maxim Plushchov
 */
public class GFSATextChunk extends GFSAChunk implements SATextChunk {

	public static final String TEXT_CHUNK_TYPE = "SATextChunk";

	private final TextChunk textChunk;
	private final String parentsStandardTypes;

	public GFSATextChunk(TextChunk textChunk, String parentsStandardTypes) {
		super(TEXT_CHUNK_TYPE);
		this.textChunk = textChunk;
		this.parentsStandardTypes = parentsStandardTypes;
	}

	public TextChunk getTextChunk() {
		return textChunk;
	}

	@Override
	public Double gettextSize() {
		return textChunk.getFontSize();
	}

	@Override
	public Double getcontrastRatio() {
		return textChunk.getContrastRatio();
	}

	@Override
	public Double gettextWeight() {
		return textChunk.getFontWeight();
	}

	@Override
	public String getContext() {
		return textChunk.getBoundingBox().getLocation();
	}

	@Override
	public String getExtraContext() {
		return textChunk.getValue();
	}

	@Override
	public Boolean gethasSpecialStyle() {
		return textChunk.getHasSpecialStyle();
	}

	@Override
	public Boolean gethasSpecialBackground() {
		return textChunk.getHasSpecialBackground();
	}

	@Override
	public Boolean getisUnderlined() {
		return textChunk.getIsUnderlinedText();
	}

	@Override
	public String getparentsStandardTypes() {
		return parentsStandardTypes;
	}

	@Override
	public Boolean getisWhiteSpaceChunk() {
		return textChunk.isWhiteSpaceChunk();
	}
}
