package org.verapdf.gf.model.impl.operator.color;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.impl.operator.base.GFOperator;
import org.verapdf.model.operator.OpSetColor;

import java.util.List;


/**
 * Set color operators without colorspace, Op_SC, Op_sc.
 *
 * @author Sergey Shemyakov
 */
public class GFOpSetColor extends GFOperator implements OpSetColor {

    /** Type name for {@code GFOpColor} */
    public static final String OP_SET_COLOR_TYPE = "OpSetColor";

    public GFOpSetColor(List<COSBase> arguments) {
        super(arguments, OP_SET_COLOR_TYPE);
    }

}
