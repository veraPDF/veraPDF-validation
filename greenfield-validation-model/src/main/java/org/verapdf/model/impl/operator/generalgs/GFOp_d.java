package org.verapdf.model.impl.operator.generalgs;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosArray;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_d;

import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_d extends GFOpGeneralGS implements Op_d {

	/** Type name for {@code GFOp_d} */
    public static final String OP_D_TYPE = "Op_d";

	/** Name of link to the dash array */
    public static final String DASH_ARRAY = "dashArray";
	/** Name of link to the dash phase */
    public static final String DASH_PHASE = "dashPhase";

    public GFOp_d(List<COSBase> arguments) {
        super(arguments, OP_D_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case DASH_ARRAY:
                return this.getDashArray();
            case DASH_PHASE:
                return this.getDashPhase();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<CosArray> getDashArray() {
        return Collections.emptyList();
    }

    private List<CosNumber> getDashPhase() {
        return this.getLastNumber();
    }

}
