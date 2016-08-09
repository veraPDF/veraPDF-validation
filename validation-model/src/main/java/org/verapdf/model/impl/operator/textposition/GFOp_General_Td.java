package org.verapdf.model.impl.operator.textposition;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.impl.cos.GFCosNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Base class for text position operators (Td and TD)
 *
 * @author Timur Kamalov
 */
public abstract class GFOp_General_Td extends GFOpTextPosition {

	/** Name of link to the horizontal offset for Td and TD operators */
    public static final String HORIZONTAL_OFFSET = "horizontalOffset";

	/** Name of link to the vertical offset for Td and TD operators */
	public static final String VERTICAL_OFFSET = "verticalOffset";

    protected GFOp_General_Td(List<COSBase> arguments, final String opType) {
        super(arguments, opType);
    }

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case VERTICAL_OFFSET:
				return this.getVerticalOffset();
			case HORIZONTAL_OFFSET:
				return this.getHorizontalOffset();
			default:
				return super.getLinkedObjects(link);
		}
	}

    private List<CosNumber> getHorizontalOffset() {
		if (this.arguments.size() > 1) {
			COSBase number = this.arguments
					.get(this.arguments.size() - 2);
			if (number.getType().isNumber()) {
				List<CosNumber> offset = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
				offset.add(GFCosNumber.fromPDFParserNumber(number));
				return Collections.unmodifiableList(offset);
			}
		}
        return Collections.emptyList();
    }

    private List<CosNumber> getVerticalOffset() {
        return this.getLastNumber();
    }

}
