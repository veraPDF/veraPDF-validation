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
