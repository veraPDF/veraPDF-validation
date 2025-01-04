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
import org.verapdf.wcag.algorithms.entities.content.TextChunk;

import java.io.IOException;

public class TextSerializer extends StdSerializer<TextChunk> {

	protected TextSerializer(Class<TextChunk> t) {
		super(t);
	}

	@Override
	public void serialize(TextChunk textChunk, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {

		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("type", "TextChunk");
		jsonGenerator.writeNumberField("pageNumber", textChunk.getPageNumber());
		jsonGenerator.writeStringField("value", textChunk.getValue());
		jsonGenerator.writeNumberField("baseLine", textChunk.getBaseLine());
		jsonGenerator.writeNumberField("fontWeight", textChunk.getFontWeight());
		jsonGenerator.writeNumberField("italicAngle", textChunk.getItalicAngle());
		jsonGenerator.writeNumberField("fontSize", textChunk.getFontSize());
		jsonGenerator.writeArrayFieldStart("boundingBox");
		jsonGenerator.writeNumber(textChunk.getLeftX());
		jsonGenerator.writeNumber(textChunk.getBottomY());
		jsonGenerator.writeNumber(textChunk.getRightX());
		jsonGenerator.writeNumber(textChunk.getTopY());
		jsonGenerator.writeEndArray();
		jsonGenerator.writeStringField("fontName", textChunk.getFontName());
		jsonGenerator.writeArrayFieldStart("color");
		for (Double num : textChunk.getFontColor()) {
			jsonGenerator.writeNumber(num);
		}
		jsonGenerator.writeEndArray();
		jsonGenerator.writeArrayFieldStart("symbolEnds");
		for (Double num : textChunk.getSymbolEnds()) {
			jsonGenerator.writeNumber(num);
		}
		jsonGenerator.writeEndArray();
		jsonGenerator.writeNumberField("slantDegree", textChunk.getSlantDegree());

		jsonGenerator.writeEndObject();
	}
}
