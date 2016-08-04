package org.verapdf.model.impl.operator.textshow;

import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSNumber;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.factory.operators.GraphicState;
import org.verapdf.model.impl.cos.GFCosNumber;
import org.verapdf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.Op_DoubleQuote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_DoubleQuote extends GFOpStringTextShow implements Op_DoubleQuote {

	/** Type name for {@code GFOp_DoubleQuote} */
	public static final String OP_DOUBLIE_QUOTE_TYPE = "Op_DoubleQuote";

	/** Name of link to the word spacing */
	public static final String WORD_SPACING = "wordSpacing";
	/** Name of link to the character spacing */
	public static final String CHARACTER_SPACING = "characterSpacing";

	/** Position of word spacing property in operands */
	public static final int WORD_SPACING_POSITION = 0;
	/** Position of character spacing property in operands */
	public static final int CHARACTER_SPACING_POSITION = 1;
	/** Number of operands */
	public static final int COUNT_OF_OPERATOR_OPERANDS = 3;

	public GFOp_DoubleQuote(List<COSBase> arguments, GraphicState state, PDResourcesHandler resourcesHandler) {
		super(arguments, state, resourcesHandler, OP_DOUBLIE_QUOTE_TYPE);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case WORD_SPACING:
				return this.getWordSpacing();
			case CHARACTER_SPACING:
				return this.getCharacterSpacing();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<CosNumber> getWordSpacing() {
		return getSpecialNumber(WORD_SPACING_POSITION);
	}

	private List<CosNumber> getCharacterSpacing() {
		return getSpecialNumber(CHARACTER_SPACING_POSITION);
	}

	private List<CosNumber> getSpecialNumber(int operandNumber) {
		final int size = this.arguments.size();
		if (size >= COUNT_OF_OPERATOR_OPERANDS) {
			int index = size - COUNT_OF_OPERATOR_OPERANDS + operandNumber;
			COSBase base = this.arguments.get(index);
			if (base instanceof COSNumber) {
				List<CosNumber> number = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
				number.add(GFCosNumber.fromPDFParserNumber(base));
				return Collections.unmodifiableList(number);
			}
		}
		return Collections.emptyList();
	}
}
