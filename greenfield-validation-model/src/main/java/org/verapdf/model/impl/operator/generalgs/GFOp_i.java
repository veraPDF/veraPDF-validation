package org.verapdf.model.impl.operator.generalgs;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_i;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_i extends GFOpGeneralGS implements Op_i {

	/** Type name for {@code PBOp_i} */
	public static final String OP_I_TYPE = "Op_i";

	/** Name of link to the flatness */
    public static final String FLATNESS = "flatness";

    public GFOp_i(List<COSBase> arguments) {
        super(arguments, OP_I_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(
            String link) {
        if (FLATNESS.equals(link)) {
            return this.getFlatness();
        }
        return super.getLinkedObjects(link);
    }

    private List<CosNumber> getFlatness() {
        return this.getLastNumber();
    }

}
