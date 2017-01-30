/**
 * This file is part of validation-model, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * validation-model is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with validation-model as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * validation-model as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.pdfa;

import org.verapdf.ReleaseDetails;
import org.verapdf.component.ComponentDetails;
import org.verapdf.component.Components;
import org.verapdf.core.EncryptedPdfException;
import org.verapdf.core.ModelParsingException;
import org.verapdf.gf.model.GFModelParser;
import org.verapdf.metadata.fixer.gf.GFMetadataFixerImpl;
import org.verapdf.pdfa.flavours.PDFAFlavour;

import java.io.File;
import java.io.InputStream;
import java.net.URI;

/**
 * @author Maksim Bezrukov
 */
class VeraFoundry extends AbstractFoundry {
	private static final ReleaseDetails greenfieldDetails = ReleaseDetails.addDetailsFromResource(
			ReleaseDetails.APPLICATION_PROPERTIES_ROOT + "validation-model." + ReleaseDetails.PROPERTIES_EXT);
	private static final URI id = URI.create("http://pdfa.verapdf.org/foundry#verapdf");
	private static final ComponentDetails details = Components.veraDetails(id, "VeraPDF Foundry",
			greenfieldDetails.getVersion(), "veraPDF greenfield foundry instance.");
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
	public PDFAParser createParser(InputStream pdfStream) throws ModelParsingException, EncryptedPdfException {
		return createParser(pdfStream, PDFAFlavour.NO_FLAVOUR);
	}

	/**
	 * @see org.verapdf.pdfa.VeraPDFFoundry#newPdfParser(java.io.InputStream,
	 *      org.verapdf.pdfa.flavours.PDFAFlavour)
	 */
	@Override
	public PDFAParser createParser(InputStream pdfStream, PDFAFlavour flavour)
			throws ModelParsingException, EncryptedPdfException {
		return GFModelParser.createModelWithFlavour(pdfStream, flavour);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PDFAParser createParser(File file, PDFAFlavour pdfaFlavour)
			throws ModelParsingException, EncryptedPdfException {
		return GFModelParser.createModelWithFlavour(file, pdfaFlavour);
	}

	@Override
	public PDFAParser createParser(File file)
			throws ModelParsingException, EncryptedPdfException {
		return createParser(file, PDFAFlavour.NO_FLAVOUR);
	}

	/**
	 * @see org.verapdf.pdfa.VeraPDFFoundry#newMetadataFixer(org.verapdf.metadata.fixer.utils.FixerConfig)
	 */
	@Override
	public MetadataFixer createMetadataFixer() {
		return new GFMetadataFixerImpl();
	}

	public static ReleaseDetails getReleaseDetails() {
		return greenfieldDetails;
	}

	static VeraPDFFoundry getInstance() {
		return instance;
	}
}
