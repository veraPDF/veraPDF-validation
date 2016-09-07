package org.verapdf.model.tools;


import org.verapdf.cos.COSKey;

public final class GFIDGenerator {

    private GFIDGenerator() {
        // Disable default constructor
    }

    public static String generateID(COSKey key) {
            return String.valueOf(key.getNumber() + " " + key.getGeneration());
    }

}
