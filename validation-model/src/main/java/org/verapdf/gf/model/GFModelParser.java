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
package org.verapdf.gf.model;

import org.verapdf.xmp.XMPException;
import org.verapdf.xmp.impl.VeraPDFMeta;
import org.verapdf.ReleaseDetails;
import org.verapdf.component.ComponentDetails;
import org.verapdf.component.Components;
import org.verapdf.core.EncryptedPdfException;
import org.verapdf.core.ModelParsingException;
import org.verapdf.exceptions.InvalidPasswordException;
import org.verapdf.features.AbstractFeaturesExtractor;
import org.verapdf.features.FeatureExtractionResult;
import org.verapdf.features.FeatureExtractorConfig;
import org.verapdf.features.gf.GFFeatureParser;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.cos.GFCosDocument;
import org.verapdf.metadata.fixer.entity.PDFDocument;
import org.verapdf.metadata.fixer.gf.impl.model.PDFDocumentImpl;
import org.verapdf.pd.PDDocument;
import org.verapdf.pd.PDMetadata;
import org.verapdf.pdfa.Foundries;
import org.verapdf.pdfa.PDFAParser;
import org.verapdf.pdfa.flavours.PDFAFlavour;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Timur Kamalov
 */
public class GFModelParser implements PDFAParser {
	private static final ReleaseDetails greenfieldDetails = ReleaseDetails.addDetailsFromResource(
			ReleaseDetails.APPLICATION_PROPERTIES_ROOT + "validation-model." + ReleaseDetails.PROPERTIES_EXT);
	private static final URI id = URI.create("http://pdfa.verapdf.org/parser#verapdf");
	private static final ComponentDetails details = Components.veraDetails(id, "VeraPDF Parser",
			greenfieldDetails.getVersion(), "veraPDF greenfield PDF parser.");
	private static final Logger logger = Logger.getLogger(GFModelParser.class.getCanonicalName());

	private static final String PDFUA_PREFIX = "ua";

	private PDDocument document;

	private final PDFAFlavour flavour;

	private GFModelParser(final InputStream docStream, PDFAFlavour flavour) throws IOException {
		try {
			this.document = new PDDocument(docStream);
			this.flavour = (flavour == PDFAFlavour.NO_FLAVOUR) ? obtainFlavour(this.document) : flavour;
			initializeStaticContainers(this.document, this.flavour);
		} catch (Throwable t) {
			this.close();
			throw t;
		}
	}

	private GFModelParser(final File pdfFile, PDFAFlavour flavour) throws IOException {
		try {
			this.document = new PDDocument(pdfFile.getAbsolutePath());
			this.flavour = (flavour == PDFAFlavour.NO_FLAVOUR) ? obtainFlavour(this.document) : flavour;
			initializeStaticContainers(this.document, this.flavour);
		} catch (Throwable t) {
			this.close();
			throw t;
		}
	}

	private GFModelParser(final File pdfFile, PDFAFlavour flavour, PDFAFlavour defaultFlavour) throws IOException {
		try {
			this.document = new PDDocument(pdfFile.getAbsolutePath());
			this.flavour = (flavour == PDFAFlavour.NO_FLAVOUR) ? ((defaultFlavour == PDFAFlavour.NO_FLAVOUR) ? obtainFlavour(this.document) : obtainFlavour(this.document, defaultFlavour)) : flavour;
			initializeStaticContainers(this.document, this.flavour);
		} catch (Throwable t) {
			this.close();
			throw t;
		}
	}

	public static GFModelParser createModelWithFlavour(InputStream toLoad, PDFAFlavour flavour)
			throws ModelParsingException, EncryptedPdfException {
		try {
			return new GFModelParser(toLoad, flavour);
		} catch (InvalidPasswordException excep) {
			throw new EncryptedPdfException("The PDF stream appears to be encrypted.", excep);
		} catch (IOException e) {
			throw new ModelParsingException("Couldn't parse stream", e);
		}
	}

	public static GFModelParser createModelWithFlavour(File pdfFile, PDFAFlavour flavour)
			throws ModelParsingException, EncryptedPdfException {
		try {
			return new GFModelParser(pdfFile, flavour);
		} catch (InvalidPasswordException excep) {
			throw new EncryptedPdfException("The PDF stream appears to be encrypted.", excep);
		} catch (IOException e) {
			throw new ModelParsingException("Couldn't parse stream", e);
		}
	}

	public static GFModelParser createModelWithFlavour(File pdfFile, PDFAFlavour flavour, PDFAFlavour defaultFlavour)
			throws ModelParsingException, EncryptedPdfException {
		try {
			return new GFModelParser(pdfFile, flavour, defaultFlavour);
		} catch (InvalidPasswordException excep) {
			throw new EncryptedPdfException("The PDF stream appears to be encrypted.", excep);
		} catch (IOException e) {
			throw new ModelParsingException("Couldn't parse stream", e);
		}
	}

	private static PDFAFlavour obtainFlavour(PDDocument document) {
		return obtainFlavour(document, Foundries.defaultInstance().defaultFlavour());
	}

		private static PDFAFlavour obtainFlavour(PDDocument document, PDFAFlavour defaultFlavour) {
		if (document == null || document.getCatalog() == null) {
			return defaultFlavour;
		}
		PDMetadata metadata = document.getCatalog().getMetadata();
		if (metadata == null) {
			return defaultFlavour;
		}
		try (InputStream is = metadata.getStream()) {
			VeraPDFMeta veraPDFMeta = VeraPDFMeta.parse(is);
			Integer identificationPart = veraPDFMeta.getIdentificationPart();
			String identificationConformance = veraPDFMeta.getIdentificationConformance();
			String prefix = "";
			if (identificationPart == null && identificationConformance == null) {
				identificationPart = veraPDFMeta.getUAIdentificationPart();
				if (identificationPart != null) {
					prefix = PDFUA_PREFIX;
				}
			}
			if (identificationConformance == null) {
				identificationConformance = "";
			}
			PDFAFlavour pdfaFlavour = PDFAFlavour.byFlavourId(prefix + identificationPart + identificationConformance);
			// TODO: remove that logic after updating NO_FLAVOUR into base pdf validation flavour
			if (pdfaFlavour == PDFAFlavour.NO_FLAVOUR) {
				return defaultFlavour;
			}
			return pdfaFlavour;
		} catch (XMPException e) {
			logger.log(Level.FINE, e.getMessage(), e);
			return defaultFlavour;
		} catch (IOException e) {
			logger.log(Level.FINE, e.getMessage(), e);
			return defaultFlavour;
		}
	}

	private static void initializeStaticContainers(final PDDocument document, final PDFAFlavour flavour) {
		StaticContainers.clearAllContainers();
		StaticContainers.setDocument(document);
		StaticContainers.setFlavour(flavour);
	}

	/**
	 * Get {@code PDDocument} object for current file.
	 *
	 * @return {@link org.verapdf.pd.PDDocument} object of greenfield library.
	 * @throws IOException when target file is not pdf or pdf file is not contain root
	 *                     object
	 */
	public PDDocument getPDDocument() {
		return this.document;
	}

	/**
	 * Method return root object of model implementation from greenfield model
	 * together with the hierarchy.
	 *
	 * @return root object representing by
	 * {@link org.verapdf.model.coslayer.CosDocument}
	 * @throws IOException when target file is not pdf or pdf file is not contain root
	 *                     object
	 */
	@Override
	public org.verapdf.model.baselayer.Object getRoot() {
		return new GFCosDocument(this.document.getDocument());
	}

	@Override
	public ComponentDetails getDetails() {
		return details;
	}

	@Override
	public PDFAFlavour getFlavour() {
		return this.flavour;
	}

	@Override
	public PDFDocument getPDFDocument() {
		return new PDFDocumentImpl(this.document);
	}

	@Override
	public FeatureExtractionResult getFeatures(FeatureExtractorConfig config) {
		return GFFeatureParser.getFeaturesCollection(this.document, config);
	}

	@Override
	public FeatureExtractionResult getFeatures(FeatureExtractorConfig config,
											   List<AbstractFeaturesExtractor> extractors) {
		return GFFeatureParser.getFeaturesCollection(this.document, extractors, config);
	}

	@Override
	public void close() {
		if (this.document != null) {
			this.document.close();
		}
	}

}
