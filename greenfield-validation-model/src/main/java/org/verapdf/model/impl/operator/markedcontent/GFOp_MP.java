package org.verapdf.model.impl.operator.markedcontent;

import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSName;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosName;
import org.verapdf.model.impl.cos.GFCosName;
import org.verapdf.model.operator.Op_MP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_MP extends GFOpMarkedContent implements Op_MP {

	/** Type name for {@code GFOp_MP} */
    public static final String OP_MP_TYPE = "Op_MP";

    public GFOp_MP(List<COSBase> arguments) {
        super(arguments, OP_MP_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(
            String link) {
        if (TAG.equals(link)) {
            return this.getTag();
        }
        return super.getLinkedObjects(link);
    }

	@Override
	protected List<CosName> getTag() {
		if (!this.arguments.isEmpty()) {
			COSBase name = this.arguments
					.get(this.arguments.size() - 1);
			if (name instanceof COSName) {
				List<CosName> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
				list.add(new GFCosName((COSName) name));
				return Collections.unmodifiableList(list);
			}
		}
		return Collections.emptyList();
	}

}
