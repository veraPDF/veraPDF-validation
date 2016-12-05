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
		return super.fixMetadata(outputRepaired, new PDFDocumentImpl(toFix), result, true,
				XMLProcessedObjectsParser.getInstance());
	}

	@Override
	public MetadataFixerResult fixMetadata(PDFAParser parser, OutputStream outputRepaired, ValidationResult result) {
		return super.fixMetadata(outputRepaired, parser.getPDFDocument(), result, true,
				XMLProcessedObjectsParser.getInstance());
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
