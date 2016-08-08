package org.verapdf.model.impl.cos;

import org.verapdf.cos.COSName;
import org.verapdf.model.coslayer.CosName;

/**
 * Created by Timur on 4/10/2016.
 */
public class GFCosName extends GFCosObject implements CosName {

    /** Type name for GFCosName */
    public static final String COS_NAME_TYPE = "CosName";

    private final String internalRepresentation;

    /**
     * Default constructor
     * @param cosName greenfield COSName
     */
    public GFCosName(COSName cosName) {
        this(cosName, COS_NAME_TYPE);
    }

    /**
     * Constructor for child classes
     * @param cosName greenfield COSName
     * @param type child class type
     */
    public GFCosName(COSName cosName, final String type) {
        super(cosName, type);
        this.internalRepresentation = cosName.getString();
    }

    /**
     * Get Unicode string representation of the Name object after applying
     * escape mechanism and converting to Unicode using Utf8 encoding
     */
    @Override
    public String getinternalRepresentation() {
        return this.internalRepresentation;
    }

}
