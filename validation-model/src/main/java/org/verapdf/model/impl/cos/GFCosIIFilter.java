package org.verapdf.model.impl.cos;

import org.verapdf.cos.COSName;
import org.verapdf.model.coslayer.CosIIFilter;

/**
 * @author Timur Kamalov
 */
public class GFCosIIFilter extends GFCosName implements CosIIFilter {

    public static final String COS_II_FILTER_TYPE = "CosIIFilter";

    public GFCosIIFilter(final COSName filter) {
        super(filter, COS_II_FILTER_TYPE);
    }

    public GFCosIIFilter(final String filter) {
        this((COSName) COSName.fromValue(filter));
    }

}
