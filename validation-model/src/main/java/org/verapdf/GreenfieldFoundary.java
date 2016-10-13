package org.verapdf;

import org.verapdf.core.EncryptedPdfException;
import org.verapdf.core.ModelParsingException;
import org.verapdf.gf.model.GFModelParser;
import org.verapdf.pdfa.MetadataFixer;
import org.verapdf.pdfa.PDFParser;
import org.verapdf.pdfa.VeraPDFFoundry;
import org.verapdf.pdfa.flavours.PDFAFlavour;
import org.verapdf.pdfa.validators.ReferenceBatchValidator;
import org.verapdf.processor.ProcessorImpl;

import java.io.InputStream;

/**
 * @author Maksim Bezrukov
 */
public class GreenfieldFoundary implements VeraPDFFoundry {
	private static GreenfieldFoundary INSTANCE = new GreenfieldFoundary();

	private GreenfieldFoundary() {
	}

	public static void initialise() {
		ProcessorImpl.initialise(INSTANCE);
		ReferenceBatchValidator.initialise(INSTANCE);
	}


	/**
	 * @see org.verapdf.pdfa.VeraPDFFoundry#newPdfParser(java.io.InputStream)
	 */
	@Override
	public PDFParser newPdfParser(InputStream pdfStream) throws ModelParsingException, EncryptedPdfException {
		return newPdfParser(pdfStream, PDFAFlavour.AUTO);
	}

	/**
	 * @see org.verapdf.pdfa.VeraPDFFoundry#newPdfParser(java.io.InputStream, org.verapdf.pdfa.flavours.PDFAFlavour)
	 */
	@Override
	public PDFParser newPdfParser(InputStream pdfStream, PDFAFlavour flavour)
			throws ModelParsingException, EncryptedPdfException {
		return GFModelParser.createModelWithFlavour(pdfStream, flavour);
	}

	/**
	 * @see org.verapdf.pdfa.VeraPDFFoundry#newMetadataFixer(org.verapdf.metadata.fixer.utils.FixerConfig)
	 */
	@Override
	public MetadataFixer newMetadataFixer() {
		// TODO: implement me with metadata fixer
		return null;
	}
}
