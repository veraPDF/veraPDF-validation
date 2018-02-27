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
package org.verapdf.gf.model.impl.containers;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSKey;
import org.verapdf.gf.model.impl.pd.colors.GFPDSeparation;
import org.verapdf.gf.model.impl.pd.util.TaggedPDFRoleMapHelper;
import org.verapdf.model.operator.Glyph;
import org.verapdf.model.pdlayer.PDColorSpace;
import org.verapdf.model.pdlayer.PDFont;
import org.verapdf.pd.PDDocument;
import org.verapdf.pdfa.flavours.PDFAFlavour;

import java.util.*;

/**
 * @author Timur Kamalov
 */
public class StaticContainers {

	private static ThreadLocal<PDDocument> document;
	private static ThreadLocal<PDFAFlavour> flavour;

	// TaggedPDF
	private static ThreadLocal<TaggedPDFRoleMapHelper> roleMapHelper;

	//PBoxPDSeparation
	private static ThreadLocal<Map<String, List<GFPDSeparation>>> separations = new ThreadLocal<>();
	private static ThreadLocal<List<String>> inconsistentSeparations = new ThreadLocal<>();

	//ColorSpaceFactory
	private static ThreadLocal<Map<String, PDColorSpace>> cachedColorSpaces = new ThreadLocal<>();

	//FontFactory
	private static ThreadLocal<Map<String, PDFont>> cachedFonts = new ThreadLocal<>();

	private static ThreadLocal<Set<COSKey>> fileSpecificationKeys = new ThreadLocal<>();

	private static ThreadLocal<Stack<COSKey>> transparencyVisitedContentStreams = new ThreadLocal<>();
	private static ThreadLocal<Boolean> validPDF  = new ThreadLocal<>();

	private static ThreadLocal<Map<String, Glyph>> cachedGlyphs = new ThreadLocal<>();

	static {
		separations.set(new HashMap<>());
		inconsistentSeparations.set(new ArrayList<>());
		cachedColorSpaces.set(new HashMap<>());
		cachedFonts.set(new HashMap<>());
		fileSpecificationKeys.set(new HashSet<>());
		transparencyVisitedContentStreams.set(new Stack<>());

		validPDF.set(true);
	}

	public static void clearAllContainers() {
		if (document != null) {
			document = null;
		}
		flavour = null;
		roleMapHelper = null;
		separations.set(new HashMap<>());
		inconsistentSeparations.set(new ArrayList<>());
		cachedColorSpaces.set(new HashMap<>());
		cachedFonts.set(new HashMap<>());
		fileSpecificationKeys.set(new HashSet<>());
		transparencyVisitedContentStreams.set(new Stack<>());
		cachedGlyphs.set(new HashMap<>());
		validPDF.set(true);
	}

	public static PDDocument getDocument() {
		return document.get();
	}

	public static void setDocument(PDDocument document) {
		StaticContainers.document.set(document);
	}

	public static PDFAFlavour getFlavour() {
		return flavour.get();
	}

	public static void setFlavour(PDFAFlavour flavour) {
		StaticContainers.flavour.set(flavour);
	}

	public static TaggedPDFRoleMapHelper getRoleMapHelper() {
		return roleMapHelper.get();
	}

	public static void setRoleMapHelper(Map<ASAtom, ASAtom> roleMap) {
		StaticContainers.roleMapHelper = new ThreadLocal<>();
		roleMapHelper.set(new TaggedPDFRoleMapHelper(roleMap));
	}

	public static void setRoleMapHelper(TaggedPDFRoleMapHelper roleMapHelper) {
		StaticContainers.roleMapHelper.set(roleMapHelper);
	}

	public static Map<String, List<GFPDSeparation>> getSeparations() {
		return separations.get();
	}

	public static void setSeparations(Map<String, List<GFPDSeparation>> separations) {
		StaticContainers.separations.set(separations);
	}

	public static List<String> getInconsistentSeparations() {
		return inconsistentSeparations.get();
	}

	public static void setInconsistentSeparations(List<String> inconsistentSeparations) {
		StaticContainers.inconsistentSeparations.set(inconsistentSeparations);
	}

	public static Map<String, PDColorSpace> getCachedColorSpaces() {
		return cachedColorSpaces.get();
	}

	public static void setCachedColorSpaces(Map<String, PDColorSpace> cachedColorSpaces) {
		StaticContainers.cachedColorSpaces.set(cachedColorSpaces);
	}

	public static Map<String, PDFont> getCachedFonts() {
		return cachedFonts.get();
	}

	public static void setCachedFonts(Map<String, PDFont> cachedFonts) {
		StaticContainers.cachedFonts.set(cachedFonts);
	}

	public static Set<COSKey> getFileSpecificationKeys() {
		return fileSpecificationKeys.get();
	}

	public static void setFileSpecificationKeys(Set<COSKey> fileSpecificationKeys) {
		StaticContainers.fileSpecificationKeys.set(fileSpecificationKeys);
	}

	public static Stack<COSKey> getTransparencyVisitedContentStreams() {
		return transparencyVisitedContentStreams.get();
	}

	public static void setTransparencyVisitedContentStreams(Stack<COSKey> transparencyVisitedContentStreams) {
		StaticContainers.transparencyVisitedContentStreams.set(transparencyVisitedContentStreams);
	}

	public static boolean getValidPDF() {
		return validPDF.get();
	}

	public static void setValidPDF(boolean validPDF) {
		StaticContainers.validPDF.set(validPDF);
	}

	public static Map<String, Glyph> getCachedGlyphs() {
		return cachedGlyphs.get();
	}

	public static void setCachedGlyphs(Map<String, Glyph> cachedGlyphs) {
		StaticContainers.cachedGlyphs.set(cachedGlyphs);
	}
}
