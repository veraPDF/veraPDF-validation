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
package org.verapdf.gf.model.impl.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.verapdf.gf.model.impl.sa.*;

import java.io.IOException;

public class AnnotationNodeSerializer extends StdSerializer<GFSAAnnotationNode> {

	protected AnnotationNodeSerializer(Class<GFSAAnnotationNode> t) {
		super(t);
	}

	@Override
	public void serialize(GFSAAnnotationNode annotationNode, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {

		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("type", "AnnotationNode");
		jsonGenerator.writeStringField("annotationType", annotationNode.getAnnotationType());

		if (annotationNode.getDestinationPageNumber() != null) {
			jsonGenerator.writeNumberField("destinationPageNumber", annotationNode.getDestinationPageNumber());
		}
		if (annotationNode.getDestinationObjectKeyNumber() != null) {
			jsonGenerator.writeNumberField("destinationObjectKeyNumber", annotationNode.getDestinationObjectKeyNumber());
		}
		if (annotationNode.getPageNumber() != null) {
			jsonGenerator.writeNumberField("pageNumber", annotationNode.getPageNumber());
		}
		jsonGenerator.writeArrayFieldStart("boundingBox");
		jsonGenerator.writeNumber(annotationNode.getBoundingBox().getLeftX());
		jsonGenerator.writeNumber(annotationNode.getBoundingBox().getBottomY());
		jsonGenerator.writeNumber(annotationNode.getBoundingBox().getRightX());
		jsonGenerator.writeNumber(annotationNode.getBoundingBox().getTopY());
		jsonGenerator.writeEndArray();

		jsonGenerator.writeEndObject();
	}
}
