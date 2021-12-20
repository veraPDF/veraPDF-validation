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
import org.verapdf.gf.model.factory.chunks.GraphicsState;
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

	private final Integer pageNumber;
	private final COSKey objectKey;
	private List<IChunk> artifacts = null;
	private final ResourceHandler resourceHandler;
	private final GraphicsState inheritedGraphicsState;
	private final org.verapdf.pd.PDContentStream contentStream;
	private double[] cropBox;
	private final Long markedContent;

	public GFSAContentStream(org.verapdf.pd.PDContentStream contentStream, GraphicsState inheritedGraphicsState,
							 ResourceHandler resourceHandler, Integer pageNumber, COSKey objectKey, double[] cropBox,
							 Long markedContent) {
		this.pageNumber = pageNumber;
		this.objectKey = objectKey;
		this.contentStream = contentStream;
		this.resourceHandler = resourceHandler;
		this.inheritedGraphicsState = inheritedGraphicsState;
		this.markedContent = markedContent;
		this.cropBox = cropBox;
		if (this.cropBox == null) {
			this.cropBox = new double[]{0.0, 0.0, 0.0, 0.0};
		}
	}

	public List<IChunk> getArtifacts() {
		if (this.artifacts == null) {
			if (pageNumber != null) {
				parseChunks();
			} else {
				this.artifacts = Collections.emptyList();
			}
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
							this.artifacts = ChunkFactory.chunksFromTokens(pageNumber, objectKey, streamParser.getTokens(),
									inheritedGraphicsState, resourceHandler, cropBox, markedContent);
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
