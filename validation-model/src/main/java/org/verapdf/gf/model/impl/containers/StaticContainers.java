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
package org.verapdf.gf.model.impl.containers;

import org.verapdf.cos.COSKey;
import org.verapdf.gf.model.impl.pd.colors.GFPDSeparation;
import org.verapdf.model.operator.Glyph;
import org.verapdf.model.pdlayer.PDColorSpace;
import org.verapdf.model.pdlayer.PDFont;
import org.verapdf.pdfa.flavours.PDFAFlavour;

import java.util.*;

/**
 * @author Timur Kamalov
 */
public class StaticContainers {

	private static final ThreadLocal<List<PDFAFlavour>> flavour = new ThreadLocal<>();

	//GFPDSeparation
	private static final ThreadLocal<Map<String, List<GFPDSeparation>>> separations = new ThreadLocal<>();
	private static final ThreadLocal<List<String>> inconsistentSeparations = new ThreadLocal<>();

	private static final ThreadLocal<Map<COSKey, Set<COSKey>>> structElementsRefs = new ThreadLocal<>();

	//ColorSpaceFactory
	private static final ThreadLocal<Map<String, PDColorSpace>> cachedColorSpaces = new ThreadLocal<>();

	//FontFactory
	private static final ThreadLocal<Map<String, PDFont>> cachedFonts = new ThreadLocal<>();

	private static final ThreadLocal<Set<COSKey>> fileSpecificationKeys = new ThreadLocal<>();

	private static final ThreadLocal<Map<COSKey, Set<COSKey>>> destinationToStructParentsMap = new ThreadLocal<>();

	private static final ThreadLocal<Stack<COSKey>> transparencyVisitedContentStreams = new ThreadLocal<>();

	private static final ThreadLocal<Map<String, Map<String, Glyph>>> cachedGlyphs = new ThreadLocal<>();

	//SENote
	private static final ThreadLocal<Set<String>> noteIDSet = new ThreadLocal<>();

	private static final ThreadLocal<Integer> lastHeadingNestingLevel = new ThreadLocal<>();

	private static final ThreadLocal<org.verapdf.pd.colors.PDColorSpace> currentTransparencyColorSpace = new ThreadLocal<>();

	//PDXForm
	private static final ThreadLocal<Set<COSKey>> xFormKeysSet = new ThreadLocal<>();

	public static void clearAllContainers() {
		flavour.set(new LinkedList<>());
		separations.set(new HashMap<>());
		structElementsRefs.set(new HashMap<>());
		inconsistentSeparations.set(new ArrayList<>());
		cachedColorSpaces.set(new HashMap<>());
		cachedFonts.set(new HashMap<>());
		fileSpecificationKeys.set(new HashSet<>());
		destinationToStructParentsMap.set(new HashMap<>());
		transparencyVisitedContentStreams.set(new Stack<>());
		cachedGlyphs.set(new HashMap<>());
		noteIDSet.set(new HashSet<>());
		lastHeadingNestingLevel.set(0);
		currentTransparencyColorSpace.set(null);
		xFormKeysSet.set(new HashSet<>());
	}

	public static List<PDFAFlavour> getFlavour() {
		return flavour.get();
	}

	public static void setFlavour(List<PDFAFlavour> flavour) {
		StaticContainers.flavour.set(flavour);
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

	public static Map<COSKey, Set<COSKey>> getStructElementsRefs() {
		if (structElementsRefs.get() == null) {
			structElementsRefs.set(new HashMap<>());
		}
		return structElementsRefs.get();
	}

	public static void setStructElementsRefs(Map<COSKey, Set<COSKey>> structElementsRefs) {
		StaticContainers.structElementsRefs.set(structElementsRefs);
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

	public static Map<COSKey, Set<COSKey>> getDestinationToStructParentsMap() {
		if (destinationToStructParentsMap.get() == null) {
			destinationToStructParentsMap.set(new HashMap<>());
		}
		return destinationToStructParentsMap.get();
	}

	public static void setDestinationToStructParentsMap(Map<COSKey, Set<COSKey>> destinationToStructParentsMap) {
		StaticContainers.destinationToStructParentsMap.set(destinationToStructParentsMap);
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

	public static Set<COSKey> getXFormKeysSet() {
		if (xFormKeysSet.get() == null) {
			xFormKeysSet.set(new HashSet<>());
		}
		return xFormKeysSet.get();
	}

	public static void setXFormKeysSet(Set<COSKey> xFormKeysSet) {
		StaticContainers.xFormKeysSet.set(xFormKeysSet);
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

	public static Integer getLastHeadingNestingLevel() {
		return lastHeadingNestingLevel.get();
	}

	public static void setLastHeadingNestingLevel(Integer lastHeadingNestingLevel) {
		StaticContainers.lastHeadingNestingLevel.set(lastHeadingNestingLevel);
	}

	public static org.verapdf.pd.colors.PDColorSpace getCurrentTransparencyColorSpace() {
		return currentTransparencyColorSpace.get();
	}

	public static void setCurrentTransparencyColorSpace(org.verapdf.pd.colors.PDColorSpace currentTransparencyColorSpace) {
		StaticContainers.currentTransparencyColorSpace.set(currentTransparencyColorSpace);
	}

	public static Map<String, Map<String, Glyph>> getCachedGlyphs() {
		if (cachedGlyphs.get() == null) {
			cachedGlyphs.set(new HashMap<>());
		}
		return cachedGlyphs.get();
	}

	public static void setCachedGlyphs(Map<String, Map<String, Glyph>> cachedGlyphs) {
		StaticContainers.cachedGlyphs.set(cachedGlyphs);
	}
}
