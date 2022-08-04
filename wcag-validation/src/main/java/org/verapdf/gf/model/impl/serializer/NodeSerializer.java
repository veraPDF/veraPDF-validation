package org.verapdf.gf.model.impl.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.verapdf.gf.model.impl.sa.*;
import org.verapdf.wcag.algorithms.entities.INode;

import java.io.IOException;

public class NodeSerializer extends StdSerializer<GFSAStructElem> {

	protected NodeSerializer(Class<GFSAStructElem> t) {
		super(t);
	}

	public void serialize(GFSAStructElem elem, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {

		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("type", elem.getstandardType());
		if (!elem.getChildren().isEmpty()) {
			jsonGenerator.writeFieldName("children");
			jsonGenerator.writeStartArray();
			for (Object child : elem.getChildren()) {
				if (child instanceof GFSATextChunk) {
					jsonGenerator.writeObject(((GFSATextChunk) child).getTextChunk());
				} else if (child instanceof GFSAImageChunk) {
					jsonGenerator.writeObject(((GFSAImageChunk) child).imageChunk);
				} else if (child instanceof GFSALineArtChunk) {
					jsonGenerator.writeObject(((GFSALineArtChunk) child).lineArtChunk);
				} else {
					jsonGenerator.writeObject(child);
				}
			}
			for (INode child : elem.getNode().getChildren()) {
				if (child instanceof GFSAAnnotationNode) {
					jsonGenerator.writeObject(child);
				}
			}
			jsonGenerator.writeEndArray();
		}

		jsonGenerator.writeEndObject();
	}
}
