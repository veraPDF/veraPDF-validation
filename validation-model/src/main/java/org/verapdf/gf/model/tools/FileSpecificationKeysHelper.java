package org.verapdf.gf.model.tools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSDocument;
import org.verapdf.cos.COSKey;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.pd.PDAnnotation;
import org.verapdf.pd.PDAppearanceEntry;
import org.verapdf.pd.PDAppearanceStream;
import org.verapdf.pd.PDCatalog;
import org.verapdf.pd.PDDocument;
import org.verapdf.pd.PDExtGState;
import org.verapdf.pd.PDPage;
import org.verapdf.pd.PDResources;
import org.verapdf.pd.PDStructElem;
import org.verapdf.pd.PDStructTreeNode;
import org.verapdf.pd.font.PDFont;
import org.verapdf.pd.font.PDType3Font;
import org.verapdf.pd.images.PDXForm;
import org.verapdf.pd.images.PDXImage;
import org.verapdf.pd.images.PDXObject;
import org.verapdf.pd.patterns.PDPattern;
import org.verapdf.pd.patterns.PDShadingPattern;
import org.verapdf.pd.patterns.PDTilingPattern;

/**
 * @author Maksim Bezrukov
 */
public class FileSpecificationKeysHelper {
	private final static Logger LOGGER = Logger.getLogger(FileSpecificationKeysHelper.class.getCanonicalName());

	public static void registerFileSpecificationKeys(COSDocument document) {
		PDDocument pdDocument = document.getPDDocument();
		if (pdDocument == null) {
			return;
		}
		try {
			PDCatalog catalog = pdDocument.getCatalog();
			if (catalog != null) {
				registerDictionaryAFKeys(catalog.getObject());
				processStructElements(catalog.getStructTreeRoot());
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Can not get document catalog", e);
		}
		try {
			List<PDPage> pages = pdDocument.getPages();
			for (PDPage page : pages) {
				processPage(page);
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Can not get list of pages", e);
		}
	}

	private static void processStructElements(PDStructTreeNode structureNode) {
		if (structureNode != null) {
			for (PDStructElem obj : structureNode.getChildren()) {
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
		if (xObject != null) {
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
			for (COSObject element : (COSArray) af.getDirectBase()) {
				addElementKey(element);
			}
		}
	}

	private static void processExtGState(PDExtGState extGState) {
		if (extGState == null) {
			return;
		}
		processFont(extGState.getFont());
	}

	private static void processFont(PDFont font) {
		if (font != null && ASAtom.TYPE3.equals(font.getSubtype())) {
			parseResources(((PDType3Font) font).getResources());
		}
	}

	private static void processPattern(PDPattern pattern) {
		if (pattern != null) {
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
			COSKey key = element.getKey();
			if (key != null) {
				StaticContainers.fileSpecificationKeys.add(key);
			}
		}
	}
}
