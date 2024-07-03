/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.foundry;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.util.EnumSet;

import org.verapdf.ReleaseDetails;
import org.verapdf.component.ComponentDetails;
import org.verapdf.component.Components;
import org.verapdf.core.EncryptedPdfException;
import org.verapdf.core.ModelParsingException;
import org.verapdf.extensions.ExtensionObjectType;
import org.verapdf.gf.model.GFModelParser;
import org.verapdf.metadata.fixer.gf.GFMetadataFixerImpl;
import org.verapdf.pdfa.*;
import org.verapdf.pdfa.flavours.PDFAFlavour;

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
	 * @see org.verapdf.pdfa.VeraPDFFoundry#createParser(InputStream)
	 */
	@Override
	public PDFAParser createParser(InputStream pdfStream) throws ModelParsingException, EncryptedPdfException {
		return createParser(pdfStream, PDFAFlavour.NO_FLAVOUR);
	}

	/**
	 * @see org.verapdf.pdfa.VeraPDFFoundry#createParser(InputStream, PDFAFlavour)
	 */
	@Override
	public PDFAParser createParser(InputStream pdfStream, PDFAFlavour flavour)
			throws ModelParsingException, EncryptedPdfException {
		return GFModelParser.createModelWithFlavour(pdfStream, flavour);
	}

	@Override
	public PDFAParser createParser(InputStream pdfStream, PDFAFlavour flavour, PDFAFlavour defaultFlavour)
			throws ModelParsingException, EncryptedPdfException {
		return GFModelParser.createModelWithFlavour(pdfStream, flavour, defaultFlavour);
	}

	@Override
	public PDFAParser createParser(InputStream pdfStream, PDFAFlavour flavour, String password)
			throws ModelParsingException, EncryptedPdfException {
		return GFModelParser.createModelWithFlavour(pdfStream, flavour, password);
	}

	@Override
	public PDFAParser createParser(InputStream pdfStream, PDFAFlavour flavour, PDFAFlavour defaultFlavour, String password,
								   EnumSet<ExtensionObjectType> enabledExtensions)
			throws ModelParsingException, EncryptedPdfException {
		return GFModelParser.createModelWithFlavour(pdfStream, flavour, defaultFlavour, password, enabledExtensions);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PDFAParser createParser(File file, PDFAFlavour flavour)
			throws ModelParsingException, EncryptedPdfException {
		return GFModelParser.createModelWithFlavour(file, flavour);
	}

	@Override
	public PDFAParser createParser(File file, PDFAFlavour flavour, PDFAFlavour defaultFlavour)
			throws ModelParsingException, EncryptedPdfException {
		return GFModelParser.createModelWithFlavour(file, flavour, defaultFlavour);
	}

	@Override
	public PDFAParser createParser(File file, PDFAFlavour flavour, String password)
			throws ModelParsingException, EncryptedPdfException {
		return GFModelParser.createModelWithFlavour(file, flavour, password);
	}

	@Override
	public PDFAParser createParser(File file, PDFAFlavour flavour, PDFAFlavour defaultFlavour, String password,
								   EnumSet<ExtensionObjectType> enabledExtensions)
			throws ModelParsingException, EncryptedPdfException {
		return GFModelParser.createModelWithFlavour(file, flavour, defaultFlavour, password, enabledExtensions);
	}

	@Override
	public PDFAParser createParser(File file)
			throws ModelParsingException, EncryptedPdfException {
		return createParser(file, PDFAFlavour.NO_FLAVOUR);
	}

	/**
	 * @see VeraPDFFoundry#createMetadataFixer()
	 */
	@Override
	public MetadataFixer createMetadataFixer() {
		return new GFMetadataFixerImpl();
	}

	@Override
	public String getParserId() {
		return "GreenField";
	}

	public static ReleaseDetails getReleaseDetails() {
		return greenfieldDetails;
	}

	static VeraPDFFoundry getInstance() {
		return instance;
	}
}
