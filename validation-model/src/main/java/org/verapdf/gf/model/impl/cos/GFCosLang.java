package org.verapdf.gf.model.impl.cos;

import org.verapdf.cos.COSString;
import org.verapdf.model.coslayer.CosLang;

/**
 * Lang type.
 * @author Sergey Shemyakov
 */
public class GFCosLang extends GFCosString implements CosLang {

    /** Type name for GFCosLang */
    public static final String COS_LANG_TYPE = "CosLang";

    /**
     * Default constructor
     * @param cosString is Lang object COSString.
     */
    public GFCosLang(COSString cosString) {
        this(cosString, COS_LANG_TYPE);
    }

    /**
     * Constructor for child classes
     * @param cosString is Lang COSString.
     * @param type child class type.
     */
    public GFCosLang(COSString cosString, final String type) {
        super(cosString, type);
    }

}
