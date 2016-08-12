package org.verapdf.model.impl.operator.specialgs;

import org.verapdf.cos.COSBase;
import org.verapdf.model.impl.operator.generalgs.GFOpGeneralGS;
import org.verapdf.model.operator.Op_q_gsave;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_q_gsave extends GFOpGeneralGS implements Op_q_gsave {

	/** Type name for {@code GFOp_q_gsave} */
    public static final String OP_Q_GSAVE_TYPE = "Op_q_gsave";

    private final int nestingLevel;

    public GFOp_q_gsave(List<COSBase> arguments, int nestingLevel) {
        super(arguments, OP_Q_GSAVE_TYPE);
        this.nestingLevel = nestingLevel;
    }

	/**
	 * @return depth of graphics state
	 */
    @Override
    public Long getnestingLevel() {
        return Long.valueOf(this.nestingLevel);
    }

}
