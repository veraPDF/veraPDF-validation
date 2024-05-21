package org.verapdf.gf.model.impl.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.verapdf.gf.model.impl.sa.*;
import org.verapdf.wcag.algorithms.entities.IAttributesDictionary;
import org.verapdf.wcag.algorithms.entities.INode;
import org.verapdf.wcag.algorithms.entities.SemanticAnnot;

import java.io.IOException;
import java.util.Objects;

public class NodeSerializer extends StdSerializer<GFSAStructElem> {

	protected NodeSerializer(Class<GFSAStructElem> t) {
		super(t);
	}

	@Override
	public void serialize(GFSAStructElem elem, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {

		jsonGenerator.writeStartObject();
		String type = elem.getstandardType();
		if (type == null) {
			type = "NonStandard";
		}
		jsonGenerator.writeStringField("type", type);
		jsonGenerator.writeNumberField("objectKeyNumber", elem.getStructElemDictionary().getObject().getKey().getNumber());
		if (Objects.equals(elem.getstandardType(), "TD") || Objects.equals(elem.getstandardType(), "TH")) {
			IAttributesDictionary AttributesDictionary = elem.getNode().getAttributesDictionary();
			jsonGenerator.writeFieldName("attributes");
			jsonGenerator.writeStartObject();
			jsonGenerator.writeNumberField("colSpan", AttributesDictionary.getColSpan());
			jsonGenerator.writeNumberField("rowSpan", AttributesDictionary.getRowSpan());
			jsonGenerator.writeEndObject();
		}
		if (!elem.getChildren().isEmpty() || !elem.getNode().getChildren().isEmpty()) {
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
				if (child instanceof SemanticAnnot) {
					jsonGenerator.writeObject(((SemanticAnnot)child).getAnnots().get(0));
				}
			}
			jsonGenerator.writeEndArray();
		}

		jsonGenerator.writeEndObject();
	}
}
