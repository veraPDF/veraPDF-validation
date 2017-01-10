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
package org.verapdf.gf.model.impl.cos;

import org.verapdf.cos.COSString;
import org.verapdf.model.coslayer.CosString;

/**
 * @author Timur Kamalov
 */
public class GFCosString extends GFCosObject implements CosString {

	/** Type name for GFCosString */
	public static final String COS_STRING_TYPE = "CosString";
	private final byte[] value;
	private final boolean isHex;
	private final boolean containsOnlyHex;
	private final long hexCount;

	/**
	 * Default constructor
	 * @param cosString greenfield COSString
	 */
	public GFCosString(COSString cosString) {
		this(cosString, COS_STRING_TYPE);
	}

	/**
	 * Constructor for child classes
	 * @param cosString is greenfield COSString.
	 * @param type child class type.
	 */
	public GFCosString(COSString cosString, final String type) {
		super(cosString, type);
		this.value = cosString.get();
		this.isHex = cosString.isHexadecimal();
		this.containsOnlyHex = cosString.isContainsOnlyHex();
		this.hexCount = cosString.getHexCount();
	}

	/**
	 * Get string value stored in the PDF object
	 */
	@Override
	public String getvalue() {
		return new String(this.value);
	}

	/**
	 * true if the string is stored in Hex format
	 */
	@Override
	public Boolean getisHex() {
		return Boolean.valueOf(this.isHex);
	}

	/**
	 * true if all symbols below range 0-9,a-f,A-F
	 */
	@Override
	public Boolean getcontainsOnlyHex() {
		return Boolean.valueOf(this.containsOnlyHex);
	}

	/**
	 * contains original hexa string length
	 */
	@Override
	public Long gethexCount() {
		return Long.valueOf(this.hexCount);
	}

}
