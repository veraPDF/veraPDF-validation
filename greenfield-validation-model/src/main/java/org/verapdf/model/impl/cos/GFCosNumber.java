package org.verapdf.model.impl.cos;

import org.verapdf.cos.*;
import org.verapdf.model.coslayer.CosNumber;

/**
 * @author Timur Kamalov
 */
public class GFCosNumber extends GFCosObject implements CosNumber {

    private final long longVal;
    private final double doubleVal;

    protected GFCosNumber(COSNumber number, final String type) {
        super(number, type);
        this.longVal = number.getInteger();
        this.doubleVal = number.getReal();
    }

    public static GFCosNumber fromPDFParserNumber(COSBase number) {
        if (number.getType() == COSObjType.COS_INTEGER) {
            return new GFCosInteger((COSInteger) number);
        } else if (number.getType() == COSObjType.COS_REAL) {
            return new GFCosReal((COSReal) number);
        }
        return null;
    }

    /**
     * Get the string representing this object
     */
    @Override
    public String getstringValue() {
        return String.valueOf(this.doubleVal);
    }

    /**
     * Get truncated integer value
     */
    @Override
    public Long getintValue() {
        return Long.valueOf(this.longVal);
    }

    /**
     * Get original decimal value
     */
    @Override
    public Double getrealValue() {
        return Double.valueOf(this.doubleVal);
    }

}
