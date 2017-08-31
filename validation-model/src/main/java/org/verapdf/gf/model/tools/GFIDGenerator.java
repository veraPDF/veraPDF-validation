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
package org.verapdf.gf.model.tools;


import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSKey;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.factory.operators.RenderingMode;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOpMarkedContent;
import org.verapdf.pd.PDOutlineItem;
import org.verapdf.pd.font.PDFont;
import org.verapdf.pd.font.PDType0Font;
import org.verapdf.pd.structure.StructureElementAccessObject;

public final class GFIDGenerator {

	private GFIDGenerator() {
		// Disable default constructor
	}

	public static String generateID(COSKey key) {
		return String.valueOf(key.getNumber() + " " + key.getGeneration());
	}

	public static String generateID(PDFont font) {
		if(font instanceof PDType0Font) {
			return generateID((PDType0Font) font);
		}
		int hashcode = font.getDictionary().hashCode();
		return String.valueOf(hashcode) + ' ' + font.getName();
	}

	public static String generateID(PDType0Font font) {
		int hashcode = font.getType0FontDict().hashCode();
		return String.valueOf(hashcode) + ' ' + font.getName();
	}

	public static String generateID(int hashcode, String fontName, int glyphCode, int renderingMode,
									GFOpMarkedContent markedContent,
									StructureElementAccessObject structureElementAccessObject) {
		String markedContentID = markedContent == null ? "" : String.valueOf(markedContent.hashCode());
		String structureElementAccessID = structureElementAccessObject == null ? "" :
				String.valueOf(structureElementAccessObject.hashCode());
		return String.valueOf(hashcode) + ' ' + fontName + ' ' + glyphCode + ' ' + renderingMode + ' ' +
				markedContentID + ' ' + structureElementAccessID;
	}

	public static String generateID(PDFont rawFont, RenderingMode renderingMode) {
		String fontID = generateID(rawFont);
		return fontID + renderingMode.getValue();
	}

	public static String generateID(PDOutlineItem item) {
		COSObject dictionary = item.getObject();
		String value = getOutlineID(dictionary, ASAtom.PREV, ASAtom.NEXT);
		return value != null ? value :
				getOutlineID(dictionary, ASAtom.PARENT, ASAtom.FIRST);
	}

	private static String getOutlineID(COSObject dictionary, ASAtom kind, ASAtom key) {
		COSObject base = dictionary.getKey(kind);
		if (base != null && base.getType().isDictionaryBased()) {
			COSObject current = base.getKey(key);
			if (current != null && current.getKey() != null) {
				String value = GFIDGenerator.generateID(current.getKey());
				return "outline " + value;
			}
			/*
				TODO : according to specification entries Next, Prev, First and Parent
				must be indirect objects, but document can fail specification.
				How we must resolve this situation?
			 */
		}
		return null;
	}

}
