package org.verapdf.model.impl.operator.inlineimage;

import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSObjType;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosDict;
import org.verapdf.model.impl.cos.GFCosDict;
import org.verapdf.model.operator.Op_ID;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_ID extends GFOpInlineImage implements Op_ID {

	/** Type name for {@code GFOp_ID} operator */
	public static final String OP_ID_TYPE = "Op_ID";

	/** Name of link to the inline image dictionary */
	public static final String INLINE_IMAGE_DICTIONARY =
			"inlineImageDictionary";

	public GFOp_ID(List<COSBase> arguments) {
		super(arguments, OP_ID_TYPE);
	}

	@Override
	public List<? extends Object> getLinkedObjects(
			String link) {
		if (INLINE_IMAGE_DICTIONARY.equals(link)) {
			return this.getInlineImageDictionary();
		}
		return super.getLinkedObjects(link);
	}

	private List<CosDict> getInlineImageDictionary() {
		if (!this.arguments.isEmpty()) {
			COSBase dict = this.arguments
					.get(this.arguments.size() - 1);
			if (dict.getType() == COSObjType.COS_DICT) {
				List<CosDict> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
				list.add(new GFCosDict((COSDictionary) dict));
				return Collections.unmodifiableList(list);
			}
		}
		return Collections.emptyList();
	}
}
