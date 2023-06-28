package org.verapdf.gf.model.impl.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.verapdf.gf.model.factory.chunks.CurveChunk;
import org.verapdf.wcag.algorithms.entities.IPage;
import org.verapdf.wcag.algorithms.entities.content.IChunk;
import org.verapdf.wcag.algorithms.entities.content.LineArtChunk;

import java.io.IOException;

public class PageSerializer extends StdSerializer<IPage> {

	protected PageSerializer(Class<IPage> t) {
		super(t);
	}

	public void serialize(IPage page, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {

		jsonGenerator.writeStartObject();
		jsonGenerator.writeNumberField("pageNumber", page.getPageNumber());
		jsonGenerator.writeStringField("pageLabel", page.getPageLabel());
		jsonGenerator.writeFieldName("artifacts");
		jsonGenerator.writeStartArray();
		for (IChunk chunk : page.getArtifacts()) {
			if (!(chunk instanceof LineArtChunk) && !(chunk instanceof CurveChunk)) {
				jsonGenerator.writeObject(chunk);
			}
		}
		jsonGenerator.writeEndArray();

		jsonGenerator.writeEndObject();
	}
}
