package org.verapdf.model.impl.operator.textstate;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_Tz;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_Tz extends GFOpTextState implements Op_Tz {

	/** Type name for {@code GFOp_Tz} */
    public static final String OP_TZ_TYPE = "Op_Tz";

	/** Name of link to the scale */
    public static final String SCALE = "scale";

    public GFOp_Tz(List<COSBase> arguments) {
        super(arguments, OP_TZ_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (SCALE.equals(link)) {
            return this.getScale();
        }
        return super.getLinkedObjects(link);
    }

    private List<CosNumber> getScale() {
        return this.getLastNumber();
    }

}
