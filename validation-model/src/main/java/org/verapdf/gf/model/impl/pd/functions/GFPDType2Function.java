package org.verapdf.gf.model.impl.pd.functions;

import org.verapdf.model.pdlayer.PDType2Function;
import org.verapdf.pd.function.PDFunction;


public class GFPDType2Function extends GFPDFunction implements PDType2Function {

    public static final String PD_TYPE2_FUNCTION_TYPE = "PDType2Function";

    public GFPDType2Function(PDFunction function) {
        super(function, PD_TYPE2_FUNCTION_TYPE);
    }

}
