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
class VeraFoundry extends AbstractFoundry {
	private static final ReleaseDetails greenfieldDetails = ReleaseDetails.addDetailsFromResource(
			ReleaseDetails.APPLICATION_PROPERTIES_ROOT + "validation-model." + ReleaseDetails.PROPERTIES_EXT);
	private static final URI id = URI.create("http://pdfa.verapdf.org/foundry#verapdf");
	private static final ComponentDetails details = Components.veraDetails(id, "VeraPDF Foundry",
			greenfieldDetails.getVersion());
	private static final VeraPDFFoundry instance = new VeraFoundry();

	private VeraFoundry() {
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
		return newPdfParser(pdfStream, PDFAFlavour.NO_FLAVOUR);
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

	public static ReleaseDetails getReleaseDetails() {
		return greenfieldDetails;
	}

	static VeraPDFFoundry getInstance() {
		return instance;
	}
}
