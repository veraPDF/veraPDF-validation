/**
 * This file is part of validation-model, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * validation-model is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with validation-model as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * validation-model as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.operator.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSInteger;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.cos.GFCosInteger;
import org.verapdf.gf.model.impl.cos.GFCosNumber;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.coslayer.CosInteger;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.Operator;

/**
 * @author Timur Kamalov
 */
public class GFOperator extends GenericModelObject implements Operator {

	public static final int MAX_NUMBER_OF_ELEMENTS = 1;

	protected final List<COSBase> arguments;

	protected GFOperator(List<COSBase> arguments, final String opType) {
		super(opType);
		this.arguments = arguments;
	}

	protected List<CosNumber> getLastNumber() {
		if (!this.arguments.isEmpty()) {
			COSBase base = this.arguments.get(this.arguments.size() - 1);
			if (base.getType().isNumber()) {
				List<CosNumber> cosNumbers = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
				cosNumbers.add(GFCosNumber.fromPDFParserNumber(base));
				return Collections.unmodifiableList(cosNumbers);
			}
		}
		return Collections.emptyList();
	}

	protected List<CosInteger> getLastInteger() {
		if (!this.arguments.isEmpty()) {
			COSBase number = this.arguments.get(this.arguments.size() - 1);
			if (number.getType() == COSObjType.COS_INTEGER) {
				List<CosInteger> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
				list.add(new GFCosInteger((COSInteger) number));
				return Collections.unmodifiableList(list);
			}
		}
		return Collections.emptyList();
	}

	protected List<CosNumber> getListOfNumbers() {
		List<CosNumber> list = new ArrayList<>();
		for (COSBase base : this.arguments) {
			if (base.getType() == COSObjType.COS_ARRAY) {
				addArrayElementsAsNumbers(list, (COSArray) base);
			} else if (base.getType().isNumber()) {
				list.add(GFCosNumber.fromPDFParserNumber(base));
			}
		}
		return Collections.unmodifiableList(list);
	}

	private static void addArrayElementsAsNumbers(List<CosNumber> list, COSArray base) {
		for (COSObject arg : base) {
			list.add(GFCosNumber.fromPDFParserNumber(arg.get()));
		}
	}

}
