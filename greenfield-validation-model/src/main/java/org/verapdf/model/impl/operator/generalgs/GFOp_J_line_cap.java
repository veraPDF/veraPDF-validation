package org.verapdf.model.impl.operator.generalgs;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosInteger;
import org.verapdf.model.operator.Op_J_line_cap;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_J_line_cap extends GFOpGeneralGS implements Op_J_line_cap {

	/** Type name for {@code GFOp_J_line_cap} */
    public static final String OP_J_LINE_CAP_TYPE = "Op_J_line_cap";

	/** Name of link to the line cap */
    public static final String LINE_CAP = "lineCap";

    public GFOp_J_line_cap(List<COSBase> arguments) {
        super(arguments, OP_J_LINE_CAP_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (LINE_CAP.equals(link)) {
            return this.getLineCap();
        }
        return super.getLinkedObjects(link);
    }

    private List<CosInteger> getLineCap() {
		return this.getLastInteger();
    }

}
