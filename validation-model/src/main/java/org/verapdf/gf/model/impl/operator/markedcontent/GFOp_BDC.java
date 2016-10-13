package org.verapdf.gf.model.impl.operator.markedcontent;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.operator.Op_BDC;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_BDC extends GFOpMarkedContent implements Op_BDC {

	/** Type name for {@code GFOp_BDC} */
    public static final String OP_BDC_TYPE = "Op_BDC";

    public GFOp_BDC(List<COSBase> arguments) {
        super(arguments, OP_BDC_TYPE);
    }

	@Override
	public List<? extends Object> getLinkedObjects(
			String link) {
		switch (link) {
			case TAG:
				return this.getTag();
			case PROPERTIES:
				return this.getPropertiesDict();
			case LANG:
				return this.getLang();
			default:
				return super.getLinkedObjects(link);
		}
	}

}
