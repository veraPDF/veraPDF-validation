package org.verapdf.gf.model.impl.operator.pathconstruction;

import org.verapdf.cos.COSBase;
import org.verapdf.model.operator.Op_h;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_h extends GFOpPathConstruction implements Op_h {

	/** Type name for {@code GFOp_h} */
    public static final String OP_H_TYPE = "Op_h";

    public GFOp_h(List<COSBase> arguments) {
        super(arguments, OP_H_TYPE);
    }

}
