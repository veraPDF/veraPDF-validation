package org.verapdf.gf.model.impl.operator.color;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.impl.operator.base.GFOperator;
import org.verapdf.model.operator.OpColor;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOpColor extends GFOperator implements OpColor {

	/** Type name for {@code GFOpColor} */
    public static final String OP_COLOR_TYPE = "OpColor";

    public GFOpColor(List<COSBase> arguments) {
        super(arguments, OP_COLOR_TYPE);
    }

}
