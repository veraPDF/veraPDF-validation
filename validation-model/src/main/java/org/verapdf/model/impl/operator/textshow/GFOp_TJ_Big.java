package org.verapdf.model.impl.operator.textshow;

import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSObjType;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosArray;
import org.verapdf.model.factory.operators.GraphicState;
import org.verapdf.model.impl.cos.GFCosArray;
import org.verapdf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.Op_TJ_Big;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_TJ_Big extends GFOpTextShow implements Op_TJ_Big {

	/** Type name for {@code GFOp_TJ_Big} */
	public static final String OP_TJ_BIG_TYPE = "Op_TJ_Big";

	/** Name of link to the set of strings and numbers */
    public static final String SPECIAL_STRINGS = "specialStrings";

    public GFOp_TJ_Big(List<COSBase> arguments, GraphicState state,
                       PDResourcesHandler resourcesHandler) {
        super(arguments, state, resourcesHandler, OP_TJ_BIG_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(
            String link) {
        if (SPECIAL_STRINGS.equals(link)) {
            return this.getSpecialStrings();
        }
        return super.getLinkedObjects(link);
    }

    private List<CosArray> getSpecialStrings() {
		if (!this.arguments.isEmpty()) {
			COSBase base = this.arguments.get(
					this.arguments.size() - 1);
			if (base.getType() == COSObjType.COS_ARRAY) {
				List<CosArray> array = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
				array.add(new GFCosArray((COSArray) base));
				return Collections.unmodifiableList(array);
			}
		}
        return Collections.emptyList();
    }

}
