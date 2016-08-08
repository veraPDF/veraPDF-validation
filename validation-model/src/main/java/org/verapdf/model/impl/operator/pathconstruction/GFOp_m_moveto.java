package org.verapdf.model.impl.operator.pathconstruction;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_m_moveto;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_m_moveto extends GFOpPathConstruction implements Op_m_moveto {

	/** Type name for {@code GFOp_m_moveto} */
    public static final String OP_M_MOVETO_TYPE = "Op_m_moveto";

	/** Name of link to the point */
    public static final String POINT = "point";

    public GFOp_m_moveto(List<COSBase> arguments) {
        super(arguments, OP_M_MOVETO_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (POINT.equals(link)) {
            return this.getPoint();
        }
        return super.getLinkedObjects(link);
    }

    private List<CosNumber> getPoint() {
        return this.getListOfNumbers();
    }

}
