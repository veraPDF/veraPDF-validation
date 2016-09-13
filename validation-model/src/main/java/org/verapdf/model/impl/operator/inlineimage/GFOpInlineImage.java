package org.verapdf.model.impl.operator.inlineimage;

import org.verapdf.cos.COSBase;
import org.verapdf.model.impl.operator.base.GFOperator;
import org.verapdf.model.operator.OpInlineImage;

import java.util.List;

/**
 * Base class for operators, such as BI, ID and EI
 *
 * @author Timur Kamalov
 */
public class GFOpInlineImage extends GFOperator implements OpInlineImage {

    protected GFOpInlineImage(List<COSBase> arguments, final String type) {
        super(arguments, type);
    }

}
