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

	private static final ThreadLocal<PDDocument> document = new ThreadLocal<>();
	private static final ThreadLocal<PDFAFlavour> flavour = new ThreadLocal<>();

	// TaggedPDF
	private static final ThreadLocal<TaggedPDFRoleMapHelper> roleMapHelper = new ThreadLocal<>();

	//PBoxPDSeparation
	private static final ThreadLocal<Map<String, List<GFPDSeparation>>> separations = new ThreadLocal<>();
	private static final ThreadLocal<List<String>> inconsistentSeparations = new ThreadLocal<>();

	//ColorSpaceFactory
	private static final ThreadLocal<Map<String, PDColorSpace>> cachedColorSpaces = new ThreadLocal<>();

	//FontFactory
	private static final ThreadLocal<Map<String, PDFont>> cachedFonts = new ThreadLocal<>();

	private static final ThreadLocal<Set<COSKey>> fileSpecificationKeys = new ThreadLocal<>();

	private static final ThreadLocal<Stack<COSKey>> transparencyVisitedContentStreams = new ThreadLocal<>();
	private static final ThreadLocal<Boolean> validPDF = new ThreadLocal<>();

	private static final ThreadLocal<Map<String, Glyph>> cachedGlyphs = new ThreadLocal<>();

	//SENote
	private static ThreadLocal<Set<String>> noteIDSet = new ThreadLocal<>();

	private static ThreadLocal<Integer> lastHeadingNestingLevel = new ThreadLocal<>();

	public static void clearAllContainers() {
		document.set(null);
		flavour.set(null);
		roleMapHelper.set(null);
		separations.set(new HashMap<>());
		inconsistentSeparations.set(new ArrayList<>());
		cachedColorSpaces.set(new HashMap<>());
		cachedFonts.set(new HashMap<>());
		fileSpecificationKeys.set(new HashSet<>());
		transparencyVisitedContentStreams.set(new Stack<>());
		cachedGlyphs.set(new HashMap<>());
		noteIDSet.set(new HashSet<>());
		validPDF.set(true);
		lastHeadingNestingLevel.set(0);
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
		roleMapHelper.set(new TaggedPDFRoleMapHelper(roleMap));
	}

	public static void setRoleMapHelper(TaggedPDFRoleMapHelper roleMapHelper) {
		StaticContainers.roleMapHelper.set(roleMapHelper);
	}

	public static Map<String, List<GFPDSeparation>> getSeparations() {
		if (separations.get() == null) {
			separations.set(new HashMap<>());
		}
		return separations.get();
	}

	public static void setSeparations(Map<String, List<GFPDSeparation>> separations) {
		StaticContainers.separations.set(separations);
	}

	public static List<String> getInconsistentSeparations() {
		if (inconsistentSeparations.get() == null) {
			inconsistentSeparations.set(new ArrayList<>());
		}
		return inconsistentSeparations.get();
	}

	public static void setInconsistentSeparations(List<String> inconsistentSeparations) {
		StaticContainers.inconsistentSeparations.set(inconsistentSeparations);
	}

	public static Map<String, PDColorSpace> getCachedColorSpaces() {
		if (cachedColorSpaces.get() == null) {
			cachedColorSpaces.set(new HashMap<>());
		}
		return cachedColorSpaces.get();
	}

	public static void setCachedColorSpaces(Map<String, PDColorSpace> cachedColorSpaces) {
		StaticContainers.cachedColorSpaces.set(cachedColorSpaces);
	}

	public static Map<String, PDFont> getCachedFonts() {
		if (cachedFonts.get() == null) {
			cachedFonts.set(new HashMap<>());
		}
		return cachedFonts.get();
	}

	public static void setCachedFonts(Map<String, PDFont> cachedFonts) {
		StaticContainers.cachedFonts.set(cachedFonts);
	}

	public static Set<COSKey> getFileSpecificationKeys() {
		if (fileSpecificationKeys.get() == null) {
			fileSpecificationKeys.set(new HashSet<>());
		}
		return fileSpecificationKeys.get();
	}

	public static void setFileSpecificationKeys(Set<COSKey> fileSpecificationKeys) {
		StaticContainers.fileSpecificationKeys.set(fileSpecificationKeys);
	}

	public static Set<String> getNoteIDSet() {
		if (noteIDSet.get() == null) {
			noteIDSet.set(new HashSet<>());
		}
		return noteIDSet.get();
	}

	public static void setNoteIDSet(Set<String> noteIDSet) {
		StaticContainers.noteIDSet.set(noteIDSet);
	}

	public static Stack<COSKey> getTransparencyVisitedContentStreams() {
		if (transparencyVisitedContentStreams.get() == null) {
			transparencyVisitedContentStreams.set(new Stack<>());
		}
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

	public static Integer getLastHeadingNestingLevel() {
		return lastHeadingNestingLevel.get();
	}

	public static void setLastHeadingNestingLevel(Integer lastHeadingNestingLevel) {
		StaticContainers.lastHeadingNestingLevel.set(lastHeadingNestingLevel);
	}

	public static Map<String, Glyph> getCachedGlyphs() {
		if (cachedGlyphs.get() == null) {
			cachedGlyphs.set(new HashMap<>());
		}
		return cachedGlyphs.get();
	}

	public static void setCachedGlyphs(Map<String, Glyph> cachedGlyphs) {
		StaticContainers.cachedGlyphs.set(cachedGlyphs);
	}
}
