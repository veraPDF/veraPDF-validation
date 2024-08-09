/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2024, veraPDF Consortium <info@verapdf.org>
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
package org.verapdf.gf.model.impl.cos;

import org.verapdf.cos.COSName;
import org.verapdf.model.coslayer.CosUnicodeName;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.StandardCharsets;

/**
 * @author Timur Kamalov
 */
public class GFCosUnicodeName extends GFCosName implements CosUnicodeName {

	public static final String COS_UNICODE_NAME_TYPE = "CosUnicodeName";

	/**
	 * Default constructor.
	 *
	 * @param cosName
	 */
	public GFCosUnicodeName(COSName cosName) {
		super(cosName, COS_UNICODE_NAME_TYPE);
	}

	/**
	 * @return true if name is valid UTF-8 string
	 */
	@Override
	public Boolean getisValidUtf8() {
		ByteBuffer tmp = ByteBuffer.wrap(this.baseObject.getString().getBytes(StandardCharsets.ISO_8859_1));
		try {
			StandardCharsets.UTF_8.newDecoder().decode(tmp);
			return Boolean.TRUE;
		} catch (CharacterCodingException e){
			return Boolean.FALSE;
		}
	}

	/**
	 * @return converted to UTF-8 name
	 */
	// TODO : check implementation
	@Override
	public String getunicodeValue() {
		return ((COSName)this.baseObject).getUnicodeValue();
	}

}
