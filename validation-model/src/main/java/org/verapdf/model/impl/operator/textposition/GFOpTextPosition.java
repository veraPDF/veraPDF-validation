package org.verapdf.model.impl.operator.textposition;

import org.verapdf.cos.COSBase;
import org.verapdf.model.impl.operator.base.GFOperator;
import org.verapdf.model.operator.OpTextPosition;

import java.util.List;

/**
 * Base class for all text position operators
 *
 * @author Timur Kamalov
 */
public class GFOpTextPosition extends GFOperator implements OpTextPosition {

	/**
	 * Type name for {@code GFOpTextPosition}. Current type applies to
	 * Tm and T* operators
	 */
    public static final String OP_TEXT_POSITION_TYPE = "OpTextPosition";

    public GFOpTextPosition(List<COSBase> arguments) {
        this(arguments, OP_TEXT_POSITION_TYPE);
    }

    public GFOpTextPosition(List<COSBase> arguments, final String opType) {
        super(arguments, opType);
    }

}
