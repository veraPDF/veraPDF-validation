package org.verapdf.model.impl.operator.textshow;

import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSString;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosString;
import org.verapdf.model.factory.operators.GraphicState;
import org.verapdf.model.impl.cos.GFCosString;
import org.verapdf.model.impl.pd.util.PDResourcesHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public abstract class GFOpStringTextShow extends GFOpTextShow {

	/** Name of link to the showing strings for operators ", ', Tj */
    public static final String SHOW_STRING = "showString";

    protected GFOpStringTextShow(List<COSBase> arguments, GraphicState state,
                                 PDResourcesHandler resources, final String opType) {
        super(arguments, state, resources, opType);
    }

    @Override
    public List<? extends Object> getLinkedObjects(
            String link) {
        if (SHOW_STRING.equals(link)) {
            return this.getShowString();
        }
        return super.getLinkedObjects(link);
    }

    private List<CosString> getShowString() {
		if (!this.arguments.isEmpty()) {
			COSBase base = this.arguments
					.get(this.arguments.size() - 1);
			if (base instanceof COSString) {
				List<CosString> string =
						new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
				string.add(new GFCosString((COSString) base));
				return Collections.unmodifiableList(string);
			}
		}
        return Collections.emptyList();
    }

}
