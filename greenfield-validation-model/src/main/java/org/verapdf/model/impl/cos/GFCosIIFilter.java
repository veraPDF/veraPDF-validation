package org.verapdf.model.impl.cos;

import org.verapdf.cos.COSName;
import org.verapdf.model.coslayer.CosIIFilter;

/**
 * Created by Timur on 4/10/2016.
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
