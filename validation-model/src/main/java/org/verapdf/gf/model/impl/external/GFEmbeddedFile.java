/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2024, veraPDF Consortium <info@verapdf.org>
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
package org.verapdf.gf.model.impl.external;

import org.verapdf.as.ASAtom;
import org.verapdf.core.VeraPDFException;
import org.verapdf.cos.COSKey;
import org.verapdf.cos.COSStream;
import org.verapdf.gf.model.GFModelParser;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.pd.colors.GFPDSeparation;
import org.verapdf.parser.PDFFlavour;
import org.verapdf.tools.TaggedPDFRoleMapHelper;
import org.verapdf.model.external.EmbeddedFile;
import org.verapdf.model.operator.Glyph;
import org.verapdf.model.pdlayer.PDColorSpace;
import org.verapdf.model.pdlayer.PDFont;
import org.verapdf.pd.PDDocument;
import org.verapdf.pd.font.FontProgram;
import org.verapdf.pd.font.cmap.CMap;
import org.verapdf.pd.structure.PDStructureNameSpace;
import org.verapdf.pdfa.PDFAValidator;
import org.verapdf.pdfa.flavours.PDFAFlavour;
import org.verapdf.pdfa.results.ValidationResult;
import org.verapdf.pdfa.validation.validators.ValidatorFactory;
import org.verapdf.tools.StaticResources;
import org.verapdf.xmp.containers.StaticXmpCoreContainers;
import org.verapdf.containers.StaticCoreContainers;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Maksim Bezrukov
 */
public class GFEmbeddedFile extends GFExternal implements EmbeddedFile {

	private static final Logger LOGGER = Logger.getLogger(GFEmbeddedFile.class.getCanonicalName());

	/** Type name for {@code GFEmbeddedFile} */
	public static final String EMBEDDED_FILE_TYPE = "EmbeddedFile";

	private final COSStream stream;

	public GFEmbeddedFile(COSStream stream) {
		super(EMBEDDED_FILE_TYPE);
		this.stream = stream;
	}

	@Override
	public String getSubtype() {
		if (this.stream != null) {
			return this.stream.getNameKeyStringValue(ASAtom.SUBTYPE);
		}
		return null;
	}

	@Override
	public Boolean getisValidPDFA12() {
		return isValidPDFA(new PDFAFlavour[]{PDFAFlavour.PDFA_1_B, PDFAFlavour.PDFA_2_B});
	}

	@Override
	public Boolean getisValidPDFA124() {
		return isValidPDFA(new PDFAFlavour[]{PDFAFlavour.PDFA_1_B, PDFAFlavour.PDFA_2_B,  PDFAFlavour.PDFA_4});
	}
	
	private boolean isValidPDFA(PDFAFlavour[] flavours) {
		if (this.stream == null) {
			return Boolean.TRUE;
		}
		saveStaticContainersState();
		boolean retVal = false;
		try (InputStream unfilteredStream = stream.getData(COSStream.FilterFlags.DECODE)) {
			for (PDFAFlavour flavour : flavours) {
				retVal = isValidPdfaStream(unfilteredStream, flavour);
				if (retVal) {
					break;
				}
				unfilteredStream.reset();
			}
		} catch (VeraPDFException | IOException e) {
			LOGGER.log(Level.FINE, "Exception during validation of embedded file", e);
		}
		restoreSavedSCState();
		return retVal;
	}

	private static boolean isValidPdfaStream(final InputStream toValidate, final PDFAFlavour flavour)
			throws VeraPDFException {
		try (GFModelParser parser = GFModelParser.createModelWithFlavour(toValidate, flavour)) {
			PDFAValidator validator = ValidatorFactory.createValidator(flavour, false, 1);
			ValidationResult result = validator.validate(parser);
			parser.close();
			return result.isCompliant();
		}
	}

	// We need to save data from StaticContainers, StaticResources and StaticXmpCoreContainers before validating embedded
	// documents
	private PDDocument document;
	private List<PDFAFlavour> flavour;
	private String password;
	private TaggedPDFRoleMapHelper roleMapHelper;
	private Map<String, List<GFPDSeparation>> separations;
	private Map<COSKey, Set<COSKey>> structElementsRefs;
	private List<String> inconsistentSeparations;
	private Map<String, PDColorSpace> cachedColorSpaces;
	private Set<String> noteIDSet;
	private Set<COSKey> xFormKeysSet;
	private Set<COSKey> fileSpecificationKeys;
	private Map<COSKey, Set<COSKey>> destinationToStructParentsMap;
	private Stack<COSKey> transparencyVisitedContentStreams;
	private Map<String, PDFont> cachedPDFonts;
	private Map<String, Map<String, Glyph>> cachedGlyphs;
	private Integer lastHeadingNestingLevel;
	private org.verapdf.pd.colors.PDColorSpace currentTransparencyColorSpace;

	// StaticResources have to be saved too
	private Map<String, CMap> cMapCache;
	private Map<COSKey, PDStructureNameSpace> structureNameSpaceCache;
	private Map<String, FontProgram> cachedFonts;
	private Map<String, String> namespaceToPrefixMap;
	private Map<String, String> prefixToNamespaceMap;

	private void saveStaticContainersState() {
		this.document = StaticResources.getDocument();
		this.flavour = StaticContainers.getFlavour();
		this.password = StaticResources.getPassword();
		this.roleMapHelper = StaticResources.getRoleMapHelper();
		this.separations = StaticContainers.getSeparations();
		this.structElementsRefs = StaticContainers.getStructElementsRefs();
		this.inconsistentSeparations = StaticContainers.getInconsistentSeparations();
		this.cachedColorSpaces = StaticContainers.getCachedColorSpaces();
		this.cachedPDFonts = StaticContainers.getCachedFonts();
		this.fileSpecificationKeys = StaticContainers.getFileSpecificationKeys();
		this.destinationToStructParentsMap = StaticContainers.getDestinationToStructParentsMap();
		this.noteIDSet = StaticContainers.getNoteIDSet();
		this.xFormKeysSet = StaticContainers.getXFormKeysSet();
		this.transparencyVisitedContentStreams = StaticContainers.getTransparencyVisitedContentStreams();
		this.lastHeadingNestingLevel = StaticContainers.getLastHeadingNestingLevel();
		this.cachedGlyphs = StaticContainers.getCachedGlyphs();
		this.currentTransparencyColorSpace = StaticContainers.getCurrentTransparencyColorSpace();

		Map<String, CMap> cMaps = StaticResources.getcMapCache();
		this.cMapCache = cMaps == null ? null : new HashMap<>(cMaps);

		Map<COSKey, PDStructureNameSpace> structureNameSpaceMap = StaticResources.getStructureNameSpaceCache();
		this.structureNameSpaceCache = structureNameSpaceMap == null ? null : new HashMap<>(structureNameSpaceMap);

		Map<String, FontProgram> cachedFonts = StaticResources.getCachedFonts();
		this.cachedFonts = cachedFonts == null ? null : new HashMap<>(cachedFonts);

		this.namespaceToPrefixMap = StaticXmpCoreContainers.getNamespaceToPrefixMap();
		this.prefixToNamespaceMap = StaticXmpCoreContainers.getPrefixToNamespaceMap();
	}

	private void restoreSavedSCState() {
		StaticContainers.setFlavour(this.flavour);
		StaticCoreContainers.setFlavour(this.flavour);
		StaticContainers.setSeparations(this.separations);
		StaticContainers.setStructElementsRefs(this.structElementsRefs);
		StaticContainers.setInconsistentSeparations(this.inconsistentSeparations);
		StaticContainers.setCachedColorSpaces(this.cachedColorSpaces);
		StaticContainers.setCachedFonts(this.cachedPDFonts);
		StaticContainers.setFileSpecificationKeys(this.fileSpecificationKeys);
		StaticContainers.setDestinationToStructParentsMap(this.destinationToStructParentsMap);
		StaticContainers.setNoteIDSet(this.noteIDSet);
		StaticContainers.setXFormKeysSet(this.xFormKeysSet);
		StaticContainers.setTransparencyVisitedContentStreams(this.transparencyVisitedContentStreams);
		StaticContainers.setLastHeadingNestingLevel(this.lastHeadingNestingLevel);
		StaticContainers.setCachedGlyphs(this.cachedGlyphs);
		StaticContainers.setCurrentTransparencyColorSpace(this.currentTransparencyColorSpace);
		StaticResources.setDocument(this.document);
		StaticResources.setPassword(this.password);
		StaticResources.setRoleMapHelper(this.roleMapHelper);
		StaticResources.setcMapCache(this.cMapCache);
		StaticResources.setStructureNameSpaceCache(this.structureNameSpaceCache);
		StaticResources.setCachedFonts(this.cachedFonts);
		StaticResources.setFlavour(GFModelParser.getPDFFlavours(flavour));

		StaticXmpCoreContainers.setNamespaceToPrefixMap(this.namespaceToPrefixMap);
		StaticXmpCoreContainers.setPrefixToNamespaceMap(this.prefixToNamespaceMap);
	}
}
