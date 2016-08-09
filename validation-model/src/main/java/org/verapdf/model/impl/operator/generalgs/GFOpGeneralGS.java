package org.verapdf.model.impl.operator.generalgs;

import org.verapdf.cos.COSBase;
import org.verapdf.model.impl.operator.base.GFOperator;
import org.verapdf.model.operator.OpGeneralGS;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public abstract class GFOpGeneralGS extends GFOperator implements OpGeneralGS {

    protected GFOpGeneralGS(List<COSBase> arguments, final String opType) {
        super(arguments, opType);
    }

}
