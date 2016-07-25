package org.verapdf.model.impl.operator.opcompability;

import org.verapdf.cos.COSBase;
import org.verapdf.model.impl.operator.base.GFOperator;
import org.verapdf.model.operator.OpCompatibility;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public abstract class GFOpCompatibility extends GFOperator implements OpCompatibility {

    public GFOpCompatibility(List<COSBase> arguments, final String opType) {
        super(arguments, opType);
    }

}
