package org.verapdf.model.impl.cos;

import org.verapdf.cos.COSInteger;
import org.verapdf.model.coslayer.CosInteger;

/**
 * Created by Timur on 4/8/2016.
 */
public class GFCosInteger extends GFCosNumber implements CosInteger {

    /** Type name for GFCosInteger */
    public static final String COS_INTEGER_TYPE = "CosInteger";

    /**
     * Default constructor
     * @param value greenfield COSInteger
     */
    public GFCosInteger(COSInteger value) {
        super(value, COS_INTEGER_TYPE);
    }

}
