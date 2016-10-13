package org.verapdf.gf.model.impl.operator.shading;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.impl.operator.base.GFOperator;
import org.verapdf.gf.model.impl.pd.patterns.GFPDShading;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.operator.Op_sh;
import org.verapdf.model.pdlayer.PDShading;

import java.util.ArrayList;
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

    private final org.verapdf.pd.patterns.PDShading rawShading;

    public GFOp_sh(List<COSBase> arguments, org.verapdf.pd.patterns.PDShading rawShading) {
        super(arguments, OP_SH_TYPE);
        this.rawShading = rawShading;
    }

    @Override
    public List<? extends Object> getLinkedObjects(
            String link) {
        if (SHADING.equals(link)) {
            return this.getShading();
        }
        return super.getLinkedObjects(link);
    }

    private List<org.verapdf.model.pdlayer.PDShading> getShading() {
        if (this.rawShading != null) {
            List<PDShading> list =
                    new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            list.add(new GFPDShading(this.rawShading));
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

}
