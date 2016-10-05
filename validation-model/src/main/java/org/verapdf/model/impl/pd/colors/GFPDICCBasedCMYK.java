package org.verapdf.model.impl.pd.colors;

import org.verapdf.model.pdlayer.PDICCBasedCMYK;

/**
 * @author Maksim Bezrukov
 */
public class GFPDICCBasedCMYK extends GFPDICCBased implements PDICCBasedCMYK {

    public static final String ICC_BASED_CMYK_TYPE = "PDICCBasedCMYK";

    private final Long opm;
    private final Boolean overprintingFlag;

    public GFPDICCBasedCMYK(org.verapdf.pd.colors.PDICCBased simplePDObject, int op, boolean overprintingFlag) {
        super(simplePDObject, ICC_BASED_CMYK_TYPE);
        this.opm = Long.valueOf(op);
        this.overprintingFlag = Boolean.valueOf(overprintingFlag);
    }

    @Override
    public Long getOPM() {
        return this.opm;
    }

    @Override
    public Boolean getoverprintFlag() {
        return this.overprintingFlag;
    }

    @Override
    public String getID() {
        return super.getID() + " " + this.opm + " " + this.overprintingFlag;
    }
}
