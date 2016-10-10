package org.verapdf.gf.model.impl.operator.pathconstruction;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_re;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_re extends GFOpPathConstruction implements Op_re {

	/** Type name for {@code GFOp_re} */
    public static final String OP_RE_TYPE = "Op_re";

	/** Name of link to the rectangle box */
    public static final String RECT_BOX = "rectBox";

    public GFOp_re(List<COSBase> arguments) {
        super(arguments, OP_RE_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
       if(RECT_BOX.equals(link)) {
           return this.getRectBox();
       }
       return super.getLinkedObjects(link);
    }

    private List<CosNumber> getRectBox() {
        return this.getListOfNumbers();
    }

}
