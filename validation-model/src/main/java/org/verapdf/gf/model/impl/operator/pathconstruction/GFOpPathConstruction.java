package org.verapdf.gf.model.impl.operator.pathconstruction;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.impl.operator.base.GFOperator;
import org.verapdf.model.operator.OpPathConstruction;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public abstract class GFOpPathConstruction extends GFOperator
        implements OpPathConstruction {

	/** Name of link to the control points */
    public static final String CONTROL_POINTS = "controlPoints";

    public GFOpPathConstruction(List<COSBase> arguments, final String opType) {
        super(arguments, opType);
    }

}
