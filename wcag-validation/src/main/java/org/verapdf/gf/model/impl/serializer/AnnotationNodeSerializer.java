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
