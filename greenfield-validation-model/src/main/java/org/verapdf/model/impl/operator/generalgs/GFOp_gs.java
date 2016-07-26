package org.verapdf.model.impl.operator.generalgs;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.operator.Op_gs;
import org.verapdf.model.pdlayer.PDExtGState;

import java.util.Collections;
import java.util.List;

/**
 * Operator defining the specified parameters in the graphics state.
 *
 * @author Timur Kamalov
 */
public class GFOp_gs extends GFOpGeneralGS implements Op_gs {

	/** Type name for {@code GFOp_gs} */
    public static final String OP_GS_TYPE = "Op_gs";

	/** Name of link to the extended graphic state */
    public static final String EXT_G_STATE = "extGState";

    public GFOp_gs(List<COSBase> arguments) {
        super(arguments, OP_GS_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (EXT_G_STATE.equals(link)) {
            return this.getExtGState();
        }
        return super.getLinkedObjects(link);
    }

    private List<PDExtGState> getExtGState() {
        return Collections.emptyList();
    }
}
