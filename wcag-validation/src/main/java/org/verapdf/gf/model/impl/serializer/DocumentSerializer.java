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
import org.verapdf.gf.model.impl.sa.GFSAPDFDocument;
import org.verapdf.gf.model.impl.sa.GFSAStructTreeRoot;
import org.verapdf.wcag.algorithms.entities.IPage;

import java.io.IOException;

public class DocumentSerializer extends StdSerializer<GFSAPDFDocument> {

	protected DocumentSerializer(Class<GFSAPDFDocument> t) {
		super(t);
	}

	@Override
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
