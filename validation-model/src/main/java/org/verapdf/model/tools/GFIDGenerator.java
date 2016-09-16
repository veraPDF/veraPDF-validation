package org.verapdf.model.tools;


import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSKey;
import org.verapdf.cos.COSObject;
import org.verapdf.pd.PDOutlineItem;
import org.verapdf.pd.font.PDFont;

public final class GFIDGenerator {

	private GFIDGenerator() {
		// Disable default constructor
	}

	public static String generateID(COSKey key) {
		return String.valueOf(key.getNumber() + " " + key.getGeneration());
	}

	public static String generateID(PDFont font) {
		int hashcode = font.getDictionary().hashCode();
		return String.valueOf(hashcode) + ' ' + font.getName();
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
			} else {
			/*
				TODO : according to specification entries Next, Prev, First and Parent
				must be indirect objects, but document can fail specification.
				How we must resolve this situation?
			 */
			}
		}
		return null;
	}

}
