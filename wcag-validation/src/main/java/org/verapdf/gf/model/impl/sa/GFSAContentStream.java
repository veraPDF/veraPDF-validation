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

import org.verapdf.as.io.ASInputStream;
import org.verapdf.cos.COSKey;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSStream;
import org.verapdf.gf.model.factory.chunks.ChunkFactory;
import org.verapdf.gf.model.impl.sa.util.ResourceHandler;
import org.verapdf.parser.PDFStreamParser;
import org.verapdf.wcag.algorithms.entities.content.IChunk;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Maxim Plushchov
 */
public class GFSAContentStream {

	private static final Logger LOGGER = Logger.getLogger(GFSAContentStream.class.getName());

	private Integer pageNumber;
	private COSKey pageObjectNumber;
	private List<IChunk> artifacts = null;
	private ResourceHandler resourceHandler;
	private org.verapdf.pd.PDContentStream contentStream = null;

	public GFSAContentStream(org.verapdf.pd.PDContentStream contentStream,
	                         ResourceHandler resourceHandler, Integer pageNumber, COSKey pageObjectNumber) {
		this.pageNumber = pageNumber;
		this.pageObjectNumber = pageObjectNumber;
		this.contentStream = contentStream;
		this.resourceHandler = resourceHandler;
	}

	public List<IChunk> getArtifacts() {
		if (pageNumber != null) {
			if (this.artifacts == null) {
				parseChunks();
			}
		}
		if (this.artifacts == null) {
			this.artifacts = Collections.emptyList();
		}
		return this.artifacts;
	}

	protected void parseChunks() {
		if (this.contentStream != null) {
			try {
				COSObject contentStream = this.contentStream.getContents();
				if (contentStream.getType() == COSObjType.COS_STREAM || contentStream.getType() == COSObjType.COS_ARRAY) {
					try (ASInputStream opStream = contentStream.getDirectBase().getData(COSStream.FilterFlags.DECODE)) {
						try (PDFStreamParser streamParser = new PDFStreamParser(opStream)) {
							streamParser.parseTokens();
							ChunkFactory chunkFactory = new ChunkFactory();
							this.artifacts = chunkFactory.chunksFromTokens(pageNumber, pageObjectNumber, streamParser.getTokens(), resourceHandler);
						}
					}
				}
			} catch (IOException e) {
				LOGGER.log(Level.FINE, "Error while parsing content stream. " + e.getMessage(), e);
				this.artifacts = Collections.emptyList();
			}
		}
	}

}
