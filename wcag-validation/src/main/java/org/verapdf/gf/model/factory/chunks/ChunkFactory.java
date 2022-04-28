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
package org.verapdf.gf.model.factory.chunks;

import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSKey;
import org.verapdf.gf.model.impl.sa.util.ResourceHandler;
import org.verapdf.operator.Operator;
import org.verapdf.wcag.algorithms.entities.content.IChunk;

import java.util.*;

/**
 * @author Maxim Plushchov
 */
public final class ChunkFactory {

	public static List<IChunk> chunksFromTokens(Integer pageNumber, COSKey objectKey, List<Object> rawTokens,
										 GraphicsState inheritedGraphicState, ResourceHandler resourceHandler,
										 COSKey parentObjectKey, Long markedContent) {
		List<COSBase> arguments = new ArrayList<>();
		ChunkParser parser = new ChunkParser(pageNumber, objectKey, inheritedGraphicState, resourceHandler,
				parentObjectKey, markedContent);
		for (Object rawToken : rawTokens) {
			if (rawToken instanceof COSBase) {
				arguments.add((COSBase) rawToken);
			} else if (rawToken instanceof Operator) {
				parser.parseChunk(((Operator) rawToken), arguments);
				arguments = new ArrayList<>();
			}
		}
		parser.parseLineArts();
		return parser.getArtifacts();
	}
}
