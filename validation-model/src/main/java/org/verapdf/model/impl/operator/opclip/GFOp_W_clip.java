package org.verapdf.model.impl.operator.opclip;

import org.verapdf.cos.COSBase;
import org.verapdf.model.operator.Op_W_clip;

import java.util.List;


/**
 * @author Timur Kamalov
 */
public class GFOp_W_clip extends GFOpClip implements Op_W_clip {

	/** Type name for {@code GFOp_W_clip} */
    public static final String OP_W_CLIP_TYPE = "Op_W_clip";

    public GFOp_W_clip(List<COSBase> arguments) {
        super(arguments, OP_W_CLIP_TYPE);
    }

}
