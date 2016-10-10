package org.verapdf.gf.model.impl.operator.generalgs;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.impl.operator.base.GFOperator;
import org.verapdf.gf.model.impl.pd.GFPDExtGState;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.operator.Op_gs;
import org.verapdf.model.pdlayer.PDExtGState;

import java.util.ArrayList;
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

    private final org.verapdf.pd.PDExtGState extGState;

    public GFOp_gs(List<COSBase> arguments, org.verapdf.pd.PDExtGState extGState) {
        super(arguments, OP_GS_TYPE);
        this.extGState = extGState;
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (EXT_G_STATE.equals(link)) {
            return this.getExtGState();
        }
        return super.getLinkedObjects(link);
    }

    private List<PDExtGState> getExtGState() {
        if (this.extGState != null) {
            List<PDExtGState> extGStates = new ArrayList<>(GFOperator.MAX_NUMBER_OF_ELEMENTS);
            extGStates.add(new GFPDExtGState(this.extGState));
            return Collections.unmodifiableList(extGStates);
        }
        return Collections.emptyList();
    }

}
