package org.verapdf.model.impl.operator.opclip;

import org.verapdf.cos.COSBase;
import org.verapdf.model.impl.operator.base.GFOperator;
import org.verapdf.model.operator.OpClip;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public abstract class GFOpClip extends GFOperator implements OpClip {

    protected GFOpClip(List<COSBase> arguments, final String opType) {
        super(arguments, opType);
    }

}
