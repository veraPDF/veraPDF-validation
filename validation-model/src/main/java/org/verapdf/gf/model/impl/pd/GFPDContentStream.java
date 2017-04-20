/**
 * This file is part of validation-model, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * validation-model is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with validation-model as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * validation-model as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.pd;


import org.verapdf.as.io.ASInputStream;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSStream;
import org.verapdf.gf.model.factory.operators.OperatorFactory;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.Operator;
import org.verapdf.model.pdlayer.PDContentStream;
import org.verapdf.parser.PDFStreamParser;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Timur Kamalov
 */
public class GFPDContentStream extends GFPDObject implements PDContentStream {

	private static final Logger LOGGER = Logger.getLogger(GFPDContentStream.class.getCanonicalName());

	public static final String CONTENT_STREAM_TYPE = "PDContentStream";

	public static final String OPERATORS = "operators";

	private PDResourcesHandler resourcesHandler;

	private List<Operator> operators = null;
	private boolean containsTransparency = false;

	public GFPDContentStream(org.verapdf.pd.PDContentStream contentStream, PDResourcesHandler resourcesHandler) {
		super(contentStream, CONTENT_STREAM_TYPE);
		this.resourcesHandler = resourcesHandler;
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		if (OPERATORS.equals(link)) {
			return this.getOperators();
		}
		return super.getLinkedObjects(link);
	}

	private List<Operator> getOperators() {
		if (this.operators == null) {
			parseOperators();
		}
		return this.operators;
	}

	private void parseOperators() {
		if (this.contentStream == null) {
			this.operators = Collections.emptyList();
		} else {
			try {
				COSObject contentStream = this.contentStream.getContents();
				if (!contentStream.empty() && contentStream.getType() == COSObjType.COS_STREAM) {
					try (ASInputStream opStream = contentStream.getDirectBase().getData(COSStream.FilterFlags.DECODE)) {
						PDFStreamParser streamParser = new PDFStreamParser(opStream);
						try {
							streamParser.parseTokens();
							OperatorFactory operatorFactory = new OperatorFactory();
							List<Operator> result = operatorFactory.operatorsFromTokens(streamParser.getTokens(), resourcesHandler);
							this.containsTransparency = operatorFactory.isLastParsedContainsTransparency();
							this.operators = Collections.unmodifiableList(result);
						} finally {
							streamParser.closeInputStream();
							if (StaticContainers.getDocument() != null &&
									StaticContainers.getDocument().getDocument() != null) {
								StaticContainers.getDocument().getDocument().getResourceHandler().addAll(
										streamParser.getImageDataStreams());
							}
						}
					}
				} else {
					this.operators = Collections.emptyList();
				}
			} catch (IOException e) {
				LOGGER.log(Level.FINE, "Error while parsing content stream. " + e.getMessage(), e);
				this.operators = Collections.emptyList();
			}
		}
	}

	public boolean isContainsTransparency() {
		if (this.operators == null) {
			parseOperators();
		}
		return containsTransparency;
	}
}
