package org.verapdf.model.impl.pd;

import org.verapdf.pd.PDHalftone;

/**
 * @author Maksim Bezrukov
 */
public class GFPDHalftone extends GFPDObject implements org.verapdf.model.pdlayer.PDHalftone {

    public static final String HALFTONE_TYPE = "PDHalftone";

    public GFPDHalftone(PDHalftone dict) {
        super(dict, HALFTONE_TYPE);
    }

    @Override
    public Long getHalftoneType() {
        return ((PDHalftone) simplePDObject).getHalftoneType();
    }

    @Override
    public String getHalftoneName() {
        return ((PDHalftone) simplePDObject).getHalftoneName();
    }
}
