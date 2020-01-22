package org.verapdf.gf.model.impl.pd.functions;

import org.verapdf.gf.model.impl.pd.GFPDObject;
import org.verapdf.model.pdlayer.PDFunction;

public class GFPDFunction extends GFPDObject implements PDFunction {

    public static final String PD_FUNCTION_TYPE = "PDFunction";

    protected GFPDFunction(org.verapdf.pd.function.PDFunction function, String type) {
        super(function, type);
    }

    public GFPDFunction(org.verapdf.pd.function.PDFunction function) {
        super(function, PD_FUNCTION_TYPE);
    }

    @Override
    public Long getFunctionType() {
        return ((org.verapdf.pd.function.PDFunction)this.simplePDObject).getFunctionType();
    }
}
