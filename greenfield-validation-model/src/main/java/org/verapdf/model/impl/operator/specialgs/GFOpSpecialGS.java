package org.verapdf.model.impl.operator.specialgs;

import org.verapdf.cos.COSBase;
import org.verapdf.model.impl.operator.base.GFOperator;
import org.verapdf.model.operator.OpSpecialGS;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public abstract class GFOpSpecialGS extends GFOperator implements OpSpecialGS {

    public GFOpSpecialGS(List<COSBase> arguments, String opType) {
        super(arguments, opType);
    }

}

