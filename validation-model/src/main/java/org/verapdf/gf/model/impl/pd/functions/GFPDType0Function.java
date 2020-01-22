package org.verapdf.gf.model.impl.pd.functions;

import org.verapdf.model.pdlayer.PDType0Function;
import org.verapdf.pd.function.PDFunction;


public class GFPDType0Function extends GFPDFunction implements PDType0Function {

    public static final String PD_TYPE0_FUNCTION_TYPE = "PDType0Function";

    public GFPDType0Function(PDFunction function) {
        super(function, PD_TYPE0_FUNCTION_TYPE);
    }

}
