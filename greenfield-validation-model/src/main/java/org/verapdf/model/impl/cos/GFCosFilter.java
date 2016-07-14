package org.verapdf.model.impl.cos;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSName;
import org.verapdf.model.coslayer.CosFilter;

/**
 * @author Timur Kamalov
 */
public class GFCosFilter extends GFCosName implements CosFilter {

    public static final String COS_FILTER_TYPE = "CosFilter";

    private static final String IDENTITY = "Identity";
    private static final String CUSTOM = "Custom";
    private static final String DEFAULT = "Default";

    private final String decodeParms;

    public GFCosFilter(final COSName filterName, final COSDictionary decodeParms) {
        super(filterName, COS_FILTER_TYPE);
        if (filterName.equals(COSName.construct(ASAtom.CRYPT))) {
            if (decodeParms == null) {
                this.decodeParms = IDENTITY;
            } else {
                this.decodeParms = decodeParms.getStringKey(ASAtom.NAME);
            }
        } else if (decodeParms == null) {
            this.decodeParms = DEFAULT;
        } else {
            this.decodeParms = CUSTOM;
        }
    }

    @Override
    public String getdecodeParms() {
        return this.decodeParms;
    }

}
