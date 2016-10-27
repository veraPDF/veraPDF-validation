package org.verapdf.pdfa;

import java.io.InputStream;
import java.net.URI;

import org.verapdf.ReleaseDetails;
import org.verapdf.component.ComponentDetails;
import org.verapdf.component.Components;
import org.verapdf.core.EncryptedPdfException;
import org.verapdf.core.ModelParsingException;
import org.verapdf.gf.model.GFModelParser;
import org.verapdf.pdfa.flavours.PDFAFlavour;

/**
 * @author Maksim Bezrukov
 */
class GreenfieldFoundry extends AbstractFoundry {
	private static final URI id = URI.create("http://foundries.verapdf.org#greenfield");
	private static final ComponentDetails details = Components.detailsFromValues(id, "VeraPDF Greenfield Foundry", "0.1.0");
	private static final VeraPDFFoundry instance = new GreenfieldFoundry();

	private GreenfieldFoundry() {
		super();
	}

	@Override
	public ComponentDetails getDetails() {
		return details;
	}
	/**
	 * @see org.verapdf.pdfa.VeraPDFFoundry#newPdfParser(java.io.InputStream)
	 */
	@Override
	public PDFParser newPdfParser(InputStream pdfStream) throws ModelParsingException, EncryptedPdfException {
		return newPdfParser(pdfStream, PDFAFlavour.AUTO);
	}

	/**
	 * @see org.verapdf.pdfa.VeraPDFFoundry#newPdfParser(java.io.InputStream,
	 *      org.verapdf.pdfa.flavours.PDFAFlavour)
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
