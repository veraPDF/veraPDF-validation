/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2025, veraPDF Consortium <info@verapdf.org>
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

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDocument;
import org.verapdf.extensions.ExtensionObjectType;
import org.verapdf.gf.model.impl.arlington.*;
import org.verapdf.parser.PDFFlavour;
import org.verapdf.pd.PDCatalog;
import org.verapdf.pdfa.flavours.PDFFlavours;
import org.verapdf.tools.StaticResources;
import org.verapdf.xmp.XMPException;
import org.verapdf.containers.StaticCoreContainers;
import org.verapdf.xmp.containers.StaticXmpCoreContainers;
import org.verapdf.xmp.impl.VeraPDFMeta;
import org.verapdf.ReleaseDetails;
import org.verapdf.pdfa.flavours.PDFAFlavours;
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
import java.util.Collections;
import java.util.LinkedList;
import java.util.EnumSet;
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

	private final PDDocument document;

	private List<PDFAFlavour> flavour;

	private GFModelParser(final InputStream docStream, PDFAFlavour flavour, PDFAFlavour defaultFlavour, String password,
						  EnumSet<ExtensionObjectType> enabledExtensions)
			throws IOException {
		try {
			clearStaticContainers();
			initializeStaticResources(password);
			this.document = new PDDocument(docStream);
			setFlavours(detectFlavour(this.document, flavour, defaultFlavour));
			initializeStaticContainers(this.document, enabledExtensions);
		} catch (Throwable t) {
			this.close();
			throw t;
		}
	}

	private GFModelParser(final File pdfFile, PDFAFlavour flavour, PDFAFlavour defaultFlavour, String password,
						  EnumSet<ExtensionObjectType> enabledExtensions)
			throws IOException {
		try {
			clearStaticContainers();
			initializeStaticResources(password);
			this.document = new PDDocument(pdfFile.getAbsolutePath());
			setFlavours(detectFlavour(this.document, flavour, defaultFlavour));
			initializeStaticContainers(this.document, enabledExtensions);
		} catch (Throwable t) {
			this.close();
			throw t;
		}
	}

	private static List<PDFAFlavour> detectFlavour(PDDocument document, PDFAFlavour flavour, PDFAFlavour defaultFlavour) {
		return flavour == PDFAFlavour.NO_FLAVOUR || flavour == PDFAFlavour.NO_ARLINGTON_FLAVOUR ? Collections.singletonList(obtainArlingtonFlavour(document, defaultFlavour != PDFAFlavour.NO_FLAVOUR &&
				defaultFlavour != PDFAFlavour.NO_ARLINGTON_FLAVOUR ? defaultFlavour : PDFAFlavour.ARLINGTON1_4)) : Collections.singletonList(flavour);
	}

	public static GFModelParser createModelWithFlavour(InputStream toLoad, PDFAFlavour flavour)
			throws ModelParsingException, EncryptedPdfException {
		return createModelWithFlavour(toLoad, flavour, PDFAFlavour.NO_FLAVOUR);
	}

	public static GFModelParser createModelWithFlavour(InputStream toLoad, PDFAFlavour flavour, PDFAFlavour defaultFlavour)
			throws ModelParsingException, EncryptedPdfException {
		return createModelWithFlavour(toLoad, flavour, defaultFlavour, null, EnumSet.noneOf(ExtensionObjectType.class));
	}

	public static GFModelParser createModelWithFlavour(InputStream toLoad, PDFAFlavour flavour, String password)
			throws ModelParsingException, EncryptedPdfException {
		return createModelWithFlavour(toLoad, flavour, PDFAFlavour.NO_FLAVOUR, password, EnumSet.noneOf(ExtensionObjectType.class));
	}

	public static GFModelParser createModelWithFlavour(InputStream toLoad, PDFAFlavour flavour, PDFAFlavour defaultFlavour,
													   String password, EnumSet<ExtensionObjectType> enabledExtensions)
			throws ModelParsingException, EncryptedPdfException {
		try {
			return new GFModelParser(toLoad, flavour, defaultFlavour, password, enabledExtensions);
		} catch (InvalidPasswordException excep) {
			throw new EncryptedPdfException("The PDF stream appears to be encrypted.", excep);
		} catch (IOException e) {
			throw new ModelParsingException("Couldn't parse stream", e);
		}
	}

	public static GFModelParser createModelWithFlavour(File pdfFile, PDFAFlavour flavour)
			throws ModelParsingException, EncryptedPdfException {
		return createModelWithFlavour(pdfFile, flavour, PDFAFlavour.NO_FLAVOUR);
	}

	public static GFModelParser createModelWithFlavour(File pdfFile, PDFAFlavour flavour, PDFAFlavour defaultFlavour)
			throws ModelParsingException, EncryptedPdfException {
		return createModelWithFlavour(pdfFile, flavour, defaultFlavour, null, EnumSet.noneOf(ExtensionObjectType.class));
	}

	public static GFModelParser createModelWithFlavour(File pdfFile, PDFAFlavour flavour, String password)
			throws ModelParsingException, EncryptedPdfException {
		return createModelWithFlavour(pdfFile, flavour, PDFAFlavour.NO_FLAVOUR, password, EnumSet.noneOf(ExtensionObjectType.class));
	}

	public static GFModelParser createModelWithFlavour(File pdfFile, PDFAFlavour flavour, PDFAFlavour defaultFlavour,
	                                                   String password, EnumSet<ExtensionObjectType> enabledExtensions)
			throws ModelParsingException, EncryptedPdfException {
		try {
			return new GFModelParser(pdfFile, flavour, defaultFlavour, password, enabledExtensions);
		} catch (InvalidPasswordException excep) {
			throw new EncryptedPdfException("The PDF stream appears to be encrypted.", excep);
		} catch (IOException e) {
			throw new ModelParsingException("Couldn't parse stream", e);
		}
	}

	private static List<PDFAFlavour> obtainFlavours(PDDocument document, PDFAFlavour defaultFlavour) {
		if (document == null || document.getCatalog() == null) {
			return Collections.singletonList(defaultFlavour);
		}
		PDMetadata metadata = document.getCatalog().getMetadata();
		if (metadata == null) {
			return Collections.singletonList(defaultFlavour);
		}
		List<PDFAFlavour> flavours = new LinkedList<>();
		try (InputStream is = metadata.getStream()) {
			VeraPDFMeta veraPDFMeta = VeraPDFMeta.parse(is);
			PDFAFlavour pdfaFlavour = detectPDFAFlavour(veraPDFMeta);
			if (!PDFFlavours.isFlavour(pdfaFlavour, PDFAFlavour.NO_FLAVOUR)) {
				flavours.add(pdfaFlavour);
			}
			PDFAFlavour pdfuaFlavour = detectPDFUAFlavour(veraPDFMeta);
			if (!PDFFlavours.isFlavour(pdfuaFlavour, PDFAFlavour.NO_FLAVOUR)) {
				flavours.add(pdfuaFlavour);
			}
			flavours.addAll(detectWTPDFFlavour(veraPDFMeta));
			
			return flavours.isEmpty() ? Collections.singletonList(defaultFlavour) : flavours;
		} catch (XMPException | IOException e) {
			logger.log(Level.FINE, e.getMessage(), e);
			return Collections.singletonList(defaultFlavour);
		}
	}

	private static PDFAFlavour obtainArlingtonFlavour(PDDocument document, PDFAFlavour defaultFlavour) {
		if (document == null) {
			return defaultFlavour;
		}
		COSDocument cosDocument = document.getDocument();
		Float version = cosDocument != null ? cosDocument.getHeader().getVersion() : null;
		if (version == null) {
			PDCatalog catalog = document.getCatalog();
			ASAtom versionValue = catalog != null ? catalog.getNameKey(ASAtom.VERSION) : null;
			version = versionValue != null ? Float.valueOf(versionValue.getValue()) : null;
		}
		if (version == null) {
			return defaultFlavour;
		}
		if (version <= PDFAFlavours.VERSION_1_4) {
			version = PDFAFlavours.VERSION_1_4;
		} else if (version <= PDFAFlavours.VERSION_1_7) {
			version = PDFAFlavours.VERSION_1_7;
		}
		PDFAFlavour flavour = PDFAFlavour.byFlavourId(PDFAFlavours.ARLINGTON_PREFIX + version);
		return flavour != PDFAFlavour.NO_FLAVOUR ? flavour : defaultFlavour;
	}

	private static PDFAFlavour detectPDFAFlavour(VeraPDFMeta veraPDFMeta) {
		try {
			Integer identificationPart = veraPDFMeta.getPDFAIdentificationPart();
			String identificationConformance = veraPDFMeta.getPDFAIdentificationConformance();
			if (identificationConformance == null) {
				identificationConformance = "";
			}
			return PDFAFlavour.byFlavourId(identificationPart + identificationConformance);
		} catch (XMPException e) {
			logger.log(Level.FINE, e.getMessage(), e);
			return PDFAFlavour.NO_FLAVOUR;
		}
	}

	private static List<PDFAFlavour> detectWTPDFFlavour(VeraPDFMeta veraPDFMeta) {
		List<PDFAFlavour> wtpdfFlavours = new LinkedList<>();
		if (veraPDFMeta.containsDeclaration("http://pdfa.org/declarations/wtpdf#accessibility1.0")) {
			wtpdfFlavours.add(PDFAFlavour.WTPDF_1_0_ACCESSIBILITY);
		}
		if (veraPDFMeta.containsDeclaration("http://pdfa.org/declarations/wtpdf#reuse1.0")) {
			wtpdfFlavours.add(PDFAFlavour.WTPDF_1_0_REUSE);
		}
		return wtpdfFlavours;
	}

	private static PDFAFlavour detectPDFUAFlavour(VeraPDFMeta veraPDFMeta) {
		try {
			Integer identificationPart = veraPDFMeta.getPDFUAIdentificationPart();
			return PDFAFlavour.byFlavourId(PDFUA_PREFIX + identificationPart);
		} catch (XMPException e) {
			logger.log(Level.FINE, e.getMessage(), e);
			return PDFAFlavour.NO_FLAVOUR;
		}
	}

	private static void initializeStaticContainers(final PDDocument document, final EnumSet<ExtensionObjectType> enabledExtensions) {
		StaticResources.setDocument(document);
		StaticContainers.setEnabledExtensions(enabledExtensions);
		StaticResources.setFlavour(Collections.singletonList(PDFFlavour.NO_FLAVOUR));
	}
	
	public static List<PDFFlavour> getPDFFlavours(List<PDFAFlavour> flavours) {
		List<PDFFlavour> resultFlavours = new LinkedList<>();
		for (PDFAFlavour flavour : flavours) {
			resultFlavours.add(flavour != null ? PDFFlavour.valueOf(flavour.name()) : null);
		}
		return resultFlavours;
	}

	private static void initializeStaticResources(String password) {
		StaticResources.setPassword(password);
	}

	private static void clearStaticContainers() {
		StaticContainers.clearAllContainers();
		StaticCoreContainers.clearAllContainers();
		StaticResources.clear();
		StaticXmpCoreContainers.clearAllContainers();
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
		if (PDFAFlavour.SpecificationFamily.ARLINGTON == this.flavour.get(0).getPart().getFamily()) {
			GFAObject.clearAllContainers();
			return new GFADocument(null, null, null);
		}
		return new GFCosDocument(this.document.getDocument());
	}

	@Override
	public ComponentDetails getDetails() {
		return details;
	}

	@Override
	public PDFAFlavour getFlavour() {
		return this.flavour.get(0);
	}

	@Override
	public List<PDFAFlavour> getFlavours() {
		return this.flavour;
	}

	@Override
	public void setFlavours(List<PDFAFlavour> flavours) {
		this.flavour = flavours;
		StaticContainers.setFlavour(flavour);
		StaticCoreContainers.setFlavour(flavour);
		StaticResources.setFlavour(Collections.singletonList(PDFFlavour.NO_FLAVOUR));
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
