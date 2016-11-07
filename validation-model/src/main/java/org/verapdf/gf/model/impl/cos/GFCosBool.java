package org.verapdf.gf.model.impl.cos;

import org.verapdf.cos.COSBoolean;
import org.verapdf.model.coslayer.CosBool;

/**
 * @author Timur Kamalov
 */
public class GFCosBool extends GFCosObject implements CosBool {

    public static final CosBool TRUE = new GFCosBool(COSBoolean.TRUE);
    public static final CosBool FALSE = new GFCosBool(COSBoolean.FALSE);

    /** Type name for GFCosBool */
    public static final String COS_BOOLEAN_TYPE = "CosBool";
    private boolean value;

    private GFCosBool(COSBoolean cosBoolean) {
        super(cosBoolean, COS_BOOLEAN_TYPE);
        this.value = cosBoolean.getBoolean().booleanValue();
    }

    /**
     * Get value of this object
     */
    @Override
    public Boolean getvalue() {
        return Boolean.valueOf(this.value);
    }

    /**
     * This method will create CosBool object instance from greenfield COSBoolean
     * @param bool greenfield COSBoolean
     * @return instance of CosBool
     */
    public static CosBool valueOf(COSBoolean bool) {
        return bool.getBoolean().booleanValue() ? TRUE : FALSE;
    }

}
