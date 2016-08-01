package org.verapdf.model.impl.operator.textobject;

import org.verapdf.cos.COSBase;
import org.verapdf.model.impl.operator.base.GFOperator;
import org.verapdf.model.operator.OpTextObject;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOpTextObject extends GFOperator implements OpTextObject {

	/** Type name for {@code GFOpTextObject} */
    public static final String OP_TEXT_OBJECT_TYPE = "OpTextObject";

    public GFOpTextObject(List<COSBase> arguments) {
        super(arguments, OP_TEXT_OBJECT_TYPE);
    }

}
