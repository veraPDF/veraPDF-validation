package org.verapdf.gf.model.impl.operator.generalgs;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_w_line_width;

import java.util.List;

/**
 * Operator defining the line width in the graphics state
 *
 * @author Timur Kamalov
 */
public class GFOp_w_line_width extends GFOpGeneralGS
		implements Op_w_line_width {

	/** Type name for {@code GFOp_w_line_width} */
	public static final String OP_W_LINE_WIDTH_TYPE = "Op_w_line_width";

	/** Name of link to the width for */
    public static final String LINE_WIDTH = "lineWidth";

    public GFOp_w_line_width(List<COSBase> arguments) {
        super(arguments, OP_W_LINE_WIDTH_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (LINE_WIDTH.equals(link)) {
            return this.getLineWidth();
        }
        return super.getLinkedObjects(link);
    }

    private List<CosNumber> getLineWidth() {
        return this.getLastNumber();
    }

}
