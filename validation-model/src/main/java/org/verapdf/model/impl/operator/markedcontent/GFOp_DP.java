package org.verapdf.model.impl.operator.markedcontent;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.operator.Op_DP;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_DP extends GFOpMarkedContent implements Op_DP {

	/** Type name for {@code GFOp_DP} */
    public static final String OP_DP_TYPE = "Op_DP";

    public GFOp_DP(List<COSBase> arguments) {
        super(arguments, OP_DP_TYPE);
    }

	@Override
	public List<? extends Object> getLinkedObjects(
			String link) {
		switch (link) {
			case TAG:
				return this.getTag();
			case PROPERTIES:
				return this.getPropertiesDict();
			default:
				return super.getLinkedObjects(link);
		}
	}

}
