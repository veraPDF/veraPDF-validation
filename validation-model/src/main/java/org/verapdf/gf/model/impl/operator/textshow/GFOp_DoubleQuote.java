/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.operator.textshow;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.factory.operators.GraphicState;
import org.verapdf.gf.model.impl.cos.GFCosNumber;
import org.verapdf.gf.model.impl.operator.base.GFOperator;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOpMarkedContent;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Op_DoubleQuote;
import org.verapdf.pd.structure.StructureElementAccessObject;

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

	public GFOp_DoubleQuote(List<COSBase> arguments, GraphicState state, PDResourcesHandler resourcesHandler,
							GFOpMarkedContent markedContent, StructureElementAccessObject structureElementAccessObject) {
		super(arguments, state, resourcesHandler, markedContent, structureElementAccessObject, OP_DOUBLIE_QUOTE_TYPE);
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
			if (base.getType().isNumber()) {
				List<CosNumber> number = new ArrayList<>(GFOperator.MAX_NUMBER_OF_ELEMENTS);
				number.add(GFCosNumber.fromPDFParserNumber(base));
				return Collections.unmodifiableList(number);
			}
		}
		return Collections.emptyList();
	}

}
