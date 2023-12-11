package org.verapdf.gf.model.impl.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.verapdf.wcag.algorithms.entities.content.LineChunk;

import java.io.IOException;

public class LineSerializer extends StdSerializer<LineChunk> {

	protected LineSerializer(Class<LineChunk> t) {
		super(t);
	}

	@Override
	public void serialize(LineChunk lineChunk, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {

		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("type", "LineChunk");
		jsonGenerator.writeNumberField("pageNumber", lineChunk.getPageNumber());
		jsonGenerator.writeNumberField("startX", lineChunk.getStartX());
		jsonGenerator.writeNumberField("startY", lineChunk.getStartY());
		jsonGenerator.writeNumberField("endX", lineChunk.getEndX());
		jsonGenerator.writeNumberField("endY", lineChunk.getEndY());
		jsonGenerator.writeNumberField("width", lineChunk.getWidth());
		jsonGenerator.writeEndObject();
	}
}
