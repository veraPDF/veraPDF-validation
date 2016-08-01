package org.verapdf.model.impl.operator.shading;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.impl.operator.base.GFOperator;
import org.verapdf.model.operator.Op_sh;
import org.verapdf.model.pdlayer.PDShading;

import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_sh extends GFOperator implements Op_sh {

	/** Type name for {@code GFOp_sh} */
    public static final String OP_SH_TYPE = "Op_sh";

	/** Name of link to the shading */
    public static final String SHADING = "shading";

    //TODO : implement me
    public GFOp_sh(List<COSBase> arguments) {
        super(arguments, OP_SH_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(
            String link) {
        if (SHADING.equals(link)) {
            return this.getShading();
        }
        return super.getLinkedObjects(link);
    }

    private List<PDShading> getShading() {
        return Collections.emptyList();
    }

}
