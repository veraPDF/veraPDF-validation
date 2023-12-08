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
package org.verapdf.gf.model.tools;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.pd.*;
import org.verapdf.pd.font.PDFont;
import org.verapdf.pd.font.type3.PDType3Font;
import org.verapdf.pd.images.PDXForm;
import org.verapdf.pd.images.PDXImage;
import org.verapdf.pd.images.PDXObject;
import org.verapdf.pd.patterns.PDPattern;
import org.verapdf.pd.patterns.PDShadingPattern;
import org.verapdf.pd.patterns.PDTilingPattern;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.pd.structure.PDStructTreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Maksim Bezrukov
 */
public class FileSpecificationKeysHelper {

	private static final Set<COSKey> visitedKeys = new HashSet<>();

	public static void registerFileSpecificationKeys(COSDocument document) {
		PDDocument pdDocument = document.getPDDocument();
		if (pdDocument == null) {
			return;
		}
		PDCatalog catalog = pdDocument.getCatalog();
		if (catalog != null) {
			registerDictionaryAFKeys(catalog.getObject());
			processStructElements(catalog.getStructTreeRoot());
		}
		List<PDPage> pages = pdDocument.getPages();
		for (PDPage page : pages) {
			processPage(page);
		}
		visitedKeys.clear();
	}

	public static void registerFileSpecificationKeys(COSArray array) {
		for (COSObject element : array) {
			addElementKey(element);
		}
	}

	private static void processStructElements(PDStructTreeNode structureNode) {
		if (structureNode != null) {
			for (PDStructElem obj : structureNode.getStructChildren()) {
				registerDictionaryAFKeys(obj.getObject());
				processStructElements(obj);
			}
		}
	}

	private static void processPage(PDPage page) {
		if (page != null) {
			registerDictionaryAFKeys(page.getObject());
			for (PDAnnotation annotation : page.getAnnotations()) {
				if (annotation != null) {
					registerDictionaryAFKeys(annotation.getObject());
					for (PDAppearanceStream stream : getAllAppearances(annotation)) {
						processXObject(stream);
					}
				}
			}
			parseResources(page.getResources());
		}
	}

	private static void processXObject(PDXObject xObject) {
		if (xObject != null && !isKeyVisited(xObject.getObject().getKey())) {
			registerDictionaryAFKeys(xObject.getObject());
			if (ASAtom.FORM.equals(xObject.getType())) {
				parseResources(((PDXForm) xObject).getResources());
			} else if (ASAtom.FORM.equals(xObject.getType())) {
				PDXImage image = (PDXImage) xObject;
				processXObject(image.getMask());
				processXObject(image.getMask());
				for (PDXImage obj : image.getAlternates()) {
					processXObject(obj);
				}
			}
		}
	}

	private static List<PDAppearanceStream> getAllAppearances(PDAnnotation annotation) {
		List<PDAppearanceStream> res = new ArrayList<>();
		if (annotation != null) {
			addAllAppearances(annotation.getNormalAppearance(), res);
			addAllAppearances(annotation.getDownAppearance(), res);
			addAllAppearances(annotation.getRolloverAppearance(), res);
		}
		return res;
	}

	private static void addAllAppearances(PDAppearanceEntry appearance, List<PDAppearanceStream> list) {
		if (appearance == null) {
			return;
		}
		if (appearance.isSubDictionary()) {
			for (PDAppearanceStream appearanceStream : appearance.getSubDictionary().values()) {
				if (appearanceStream != null) {
					list.add(appearanceStream);
				}
			}
		} else {
			PDAppearanceStream appearanceStream = appearance.getAppearanceStream();
			if (appearanceStream != null) {
				list.add(appearanceStream);
			}
		}
	}

	private static void registerDictionaryAFKeys(COSObject dictionary) {
		if (dictionary == null || !(dictionary.getType().isDictionaryBased())) {
			return;
		}
		COSObject af = dictionary.getKey(ASAtom.AF);
		if (af != null && af.getType() == COSObjType.COS_ARRAY) {
			registerFileSpecificationKeys((COSArray) af.getDirectBase());
		}
	}

	private static void processExtGState(PDExtGState extGState) {
		if (extGState != null && !isKeyVisited(extGState.getObject().getKey())) {
			processFont(extGState.getFont());
		}
	}

	private static void processFont(PDFont font) {
		if (font != null
				&& !isKeyVisited(font.getObject().getKey())
				&& ASAtom.TYPE3.equals(font.getSubtype())) {
			parseResources(((PDType3Font) font).getResources());
		}
	}

	private static void processPattern(PDPattern pattern) {
		if (pattern != null && !isKeyVisited(pattern.getObject().getKey())) {
			if (pattern.getPatternType() == 1) {
				parseResources(((PDTilingPattern) pattern).getResources());
			} else if (pattern.getPatternType() == 2) {
				processExtGState(((PDShadingPattern) pattern).getExtGState());
			}
		}
	}

	private static void parseResources(PDResources resources) {
		if (resources != null) {
			parseResourcesXObjects(resources);
			parseResourcesExtGState(resources);
			parseResourcesPatterns(resources);
			parseResourcesFonts(resources);
		}
	}

	private static void parseResourcesPatterns(PDResources resources) {
		for (ASAtom name : resources.getPatternNames()) {
			PDPattern pattern = resources.getPattern(name);
			processPattern(pattern);
		}
	}

	private static void parseResourcesExtGState(PDResources resources) {
		for (ASAtom name : resources.getExtGStateNames()) {
			PDExtGState extGState = resources.getExtGState(name);
			processExtGState(extGState);
		}
	}

	private static void parseResourcesXObjects(PDResources resources) {
		for (ASAtom name : resources.getXObjectNames()) {
			PDXObject xObject = resources.getXObject(name);
			processXObject(xObject);

		}
	}

	private static void parseResourcesFonts(PDResources resources) {
		for (ASAtom name : resources.getFontNames()) {
			PDFont font = resources.getFont(name);
			processFont(font);
		}
	}

	private static void addElementKey(COSObject element) {
		if (element != null) {
			COSBase directBase = element.getDirectBase();
			if (directBase != null) {
				COSKey key = directBase.getObjectKey();
				if (key != null) {
					StaticContainers.getFileSpecificationKeys().add(key);
				}
			}
		}
	}

	private static boolean isKeyVisited(COSKey key) {
		if (visitedKeys.contains(key)) {
			return true;
		}
		visitedKeys.add(key);
		return false;
	}
}
