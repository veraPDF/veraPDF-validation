package org.verapdf.gf.model.impl.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.verapdf.wcag.algorithms.entities.content.LineArtChunk;
import org.verapdf.wcag.algorithms.entities.content.LineChunk;

import java.io.IOException;

public class LineArtSerializer extends StdSerializer<LineArtChunk> {

	protected LineArtSerializer(Class<LineArtChunk> t) {
		super(t);
	}

	public void serialize(LineArtChunk lineArtChunk, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {

		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("type", "LineArtChunk");
		jsonGenerator.writeNumberField("pageNumber", lineArtChunk.getPageNumber());
		jsonGenerator.writeArrayFieldStart("boundingBox");
		jsonGenerator.writeNumber(lineArtChunk.getLeftX());
		jsonGenerator.writeNumber(lineArtChunk.getBottomY());
		jsonGenerator.writeNumber(lineArtChunk.getRightX());
		jsonGenerator.writeNumber(lineArtChunk.getTopY());
		jsonGenerator.writeEndArray();
		if (!lineArtChunk.getLineChunks().isEmpty()) {
			jsonGenerator.writeArrayFieldStart("lines");
			for (LineChunk line : lineArtChunk.getLineChunks()) {
				jsonGenerator.writeObject(line);
			}
			jsonGenerator.writeEndArray();
		}
		jsonGenerator.writeEndObject();
	}
}
