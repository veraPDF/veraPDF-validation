package org.verapdf.model.impl.operator.textstate;

import org.verapdf.cos.COSBase;
import org.verapdf.model.impl.operator.base.GFOperator;
import org.verapdf.model.operator.OpTextState;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOpTextState extends GFOperator implements OpTextState {

    protected GFOpTextState(List<COSBase> arguments, final String opType) {
        super(arguments, opType);
    }

}
