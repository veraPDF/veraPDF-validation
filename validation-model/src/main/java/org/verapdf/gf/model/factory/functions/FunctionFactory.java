package org.verapdf.gf.model.factory.functions;

import org.verapdf.gf.model.impl.pd.functions.*;
import org.verapdf.pd.function.PDFunction;
import org.verapdf.pd.function.PDType3Function;

import java.util.logging.Logger;

public class FunctionFactory {

    private static final Logger LOGGER = Logger.getLogger(FunctionFactory.class.getCanonicalName());

    private FunctionFactory() {
        //Disable default constructor
    }

    public static GFPDFunction createFunction(PDFunction function) {
        Long functionType = function.getFunctionType();

        if (functionType == null) {
            return new GFPDFunction(function);
        }

        switch (functionType.intValue()) {
            case 0:
                return new GFPDType0Function(function);
            case 2:
                return new GFPDType2Function(function);
            case 3:
                return new GFPDType3Function((PDType3Function) function);
            case 4:
                return new GFPDType4Function(function);
            default:
                LOGGER.warning("Function type key must be {0, 2, 3, 4}");
                return new GFPDFunction(function);
        }
    }
}
