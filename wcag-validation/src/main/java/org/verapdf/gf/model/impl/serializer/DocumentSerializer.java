package org.verapdf.gf.model.impl.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.verapdf.gf.model.impl.sa.GFSAPDFDocument;
import org.verapdf.gf.model.impl.sa.GFSAStructTreeRoot;
import org.verapdf.wcag.algorithms.entities.IPage;

import java.io.IOException;

public class DocumentSerializer extends StdSerializer<GFSAPDFDocument> {

	protected DocumentSerializer(Class<GFSAPDFDocument> t) {
		super(t);
	}

	public void serialize(GFSAPDFDocument document, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("type", "PDFDocument");
		jsonGenerator.writeFieldName("children");
		jsonGenerator.writeStartArray();
		if (!document.getStructureTreeRoot().isEmpty()) {
			GFSAStructTreeRoot root = (GFSAStructTreeRoot) document.getStructureTreeRoot().get(0);
			if (root.getChildren() != null) {
				for (Object child : root.getChildren()) {
					jsonGenerator.writeObject(child);
				}
			}
		}

		jsonGenerator.writeEndArray();
		jsonGenerator.writeFieldName("pages");
		jsonGenerator.writeStartArray();
		if (document.getPages() != null) {
			for (IPage page : document.getPages()) {
				jsonGenerator.writeObject(page);
			}
		}
		jsonGenerator.writeEndArray();
		jsonGenerator.writeEndObject();
	}
}
