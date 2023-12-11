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
