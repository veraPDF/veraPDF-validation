/**
 * This file is part of veraPDF WCAG Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2025, veraPDF Consortium <info@verapdf.org>
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
import org.verapdf.wcag.algorithms.entities.content.ImageChunk;

import java.io.IOException;

public class ImageSerializer extends StdSerializer<ImageChunk> {

	protected ImageSerializer(Class<ImageChunk> t) {
		super(t);
	}

	@Override
	public void serialize(ImageChunk imageChunk, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {

		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("type", "ImageChunk");
		jsonGenerator.writeNumberField("pageNumber", imageChunk.getPageNumber());
		jsonGenerator.writeArrayFieldStart("boundingBox");
		jsonGenerator.writeNumber(imageChunk.getLeftX());
		jsonGenerator.writeNumber(imageChunk.getBottomY());
		jsonGenerator.writeNumber(imageChunk.getRightX());
		jsonGenerator.writeNumber(imageChunk.getTopY());
		jsonGenerator.writeEndArray();
		jsonGenerator.writeEndObject();
	}
}
