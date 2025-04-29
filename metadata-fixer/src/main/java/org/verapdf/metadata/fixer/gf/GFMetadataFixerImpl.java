/**
 * This file is part of veraPDF Metadata Fixer, a module of the veraPDF project.
 * Copyright (c) 2015-2025, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Metadata Fixer is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Metadata Fixer as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Metadata Fixer as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.metadata.fixer.gf;

import org.verapdf.metadata.fixer.gf.impl.model.PDFDocumentImpl;
import org.verapdf.metadata.fixer.utils.parser.XMLProcessedObjectsParser;
import org.verapdf.pdfa.PDFAParser;
import org.verapdf.pdfa.results.MetadataFixerResult;
import org.verapdf.pdfa.results.ValidationResult;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Maksim Bezrukov
 */
public final class GFMetadataFixerImpl extends MetadataFixerImpl {

	public GFMetadataFixerImpl() {

	}

	@Override
	public MetadataFixerResult fixMetadata(InputStream toFix, OutputStream outputRepaired, ValidationResult result)
			throws IOException {
		return fixMetadata(outputRepaired, new PDFDocumentImpl(toFix), result, true,
				XMLProcessedObjectsParser.getInstance());
	}

	@Override
	public MetadataFixerResult fixMetadata(PDFAParser parser, OutputStream outputRepaired, ValidationResult result) {
		return fixMetadata(outputRepaired, parser.getPDFDocument(), result, true,
				XMLProcessedObjectsParser.getInstance());
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
