package org.verapdf.gf.model.impl.pd.functions;

import org.verapdf.gf.model.factory.functions.FunctionFactory;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDType3Function;
import org.verapdf.pd.function.PDFunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GFPDType3Function extends GFPDFunction implements PDType3Function {

    public static final String PD_TYPE3_FUNCTION_TYPE = "PDType3Function";

    public static final String FUNCTIONS = "Functions";


    public GFPDType3Function(org.verapdf.pd.function.PDType3Function function) {
        super(function, PD_TYPE3_FUNCTION_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case FUNCTIONS:
                return this.getFunctions();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<GFPDFunction> getFunctions() {
        List<GFPDFunction> functionList = new ArrayList<>();
        for (PDFunction pdFunction : ((org.verapdf.pd.function.PDType3Function)this.simplePDObject).getFunctions()) {
            GFPDFunction function = FunctionFactory.createFunction(pdFunction);
            functionList.add(function);
        }
        return Collections.unmodifiableList(functionList);
    }
}
