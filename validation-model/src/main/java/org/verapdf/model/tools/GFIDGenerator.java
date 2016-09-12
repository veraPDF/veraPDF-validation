package org.verapdf.model.tools;


import org.verapdf.cos.COSKey;
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

}
