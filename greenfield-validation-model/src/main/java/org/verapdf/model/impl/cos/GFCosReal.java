package org.verapdf.model.impl.cos;

import org.verapdf.cos.COSNumber;
import org.verapdf.model.coslayer.CosReal;

/**
 * @author Timur Kamalov
 */
public class GFCosReal extends GFCosNumber implements CosReal {

    /** Type name for GFCosReal */
    public static final String COS_REAL_TYPE = "CosReal";

    /**
     * Default constructor
     * @param value greenfield COSNumber
     */
    public GFCosReal(COSNumber value) {
        super(value, COS_REAL_TYPE);
    }

}
