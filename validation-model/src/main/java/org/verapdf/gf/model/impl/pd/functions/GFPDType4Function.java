package org.verapdf.gf.model.impl.pd.functions;

import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.cos.GFCosObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosObject;
import org.verapdf.model.pdlayer.PDType4Function;
import org.verapdf.pd.function.PDFunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GFPDType4Function extends GFPDFunction implements PDType4Function {

    public static final String PD_TYPE4_FUNCTION_TYPE = "PDType4Function";
    public static final String OPERATORS = "operators";


    public GFPDType4Function(PDFunction function) {
        super(function, PD_TYPE4_FUNCTION_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case OPERATORS:
                return this.getOperators();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<CosObject> getOperators(){
        PDFunction function = (PDFunction)this.simplePDObject;
        List<CosObject> result = new ArrayList<>();
        for (COSObject obj : function.getOperators()) {
            result.add(GFCosObject.getFromValue(obj.get()));
        }
        return Collections.unmodifiableList(result);
    }
}
