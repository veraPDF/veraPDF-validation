package org.verapdf.pdfa;

import java.io.InputStream;

import org.verapdf.core.EncryptedPdfException;
import org.verapdf.core.ModelParsingException;
import org.verapdf.gf.model.GFModelParser;
import org.verapdf.pdfa.MetadataFixer;
import org.verapdf.pdfa.PDFParser;
import org.verapdf.pdfa.VeraPDFFoundry;
import org.verapdf.pdfa.flavours.PDFAFlavour;

/**
 * @author Maksim Bezrukov
 */
class GreenfieldFoundry extends AbstractFoundry {
	private static final VeraPDFFoundry instance = new GreenfieldFoundry();
	private GreenfieldFoundry() {
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
	
	static VeraPDFFoundry getInstance() {
		return instance;
	}
}
