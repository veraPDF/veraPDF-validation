package org.verapdf.gf.model.impl.operator.generalgs;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosInteger;
import org.verapdf.model.operator.Op_j_line_join;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_j_line_join extends GFOpGeneralGS implements Op_j_line_join {

	/** Type name for {@code GFOp_j_line_join} */
	public static final String OP_J_LINE_JOIN_TYPE = "Op_j_line_join";

	/** Name of link to the line join for */
    public static final String LINE_JOIN = "lineJoin";

    public GFOp_j_line_join(List<COSBase> arguments) {
        super(arguments, OP_J_LINE_JOIN_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (LINE_JOIN.equals(link)) {
            return this.getLineJoin();
        }
        return super.getLinkedObjects(link);
    }

	private List<CosInteger> getLineJoin() {
		return this.getLastInteger();
	}

}
