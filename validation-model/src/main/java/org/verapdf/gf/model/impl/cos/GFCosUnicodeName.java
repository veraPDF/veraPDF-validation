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

import org.verapdf.cos.COSName;
import org.verapdf.model.coslayer.CosUnicodeName;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Timur Kamalov
 */
public class GFCosUnicodeName extends GFCosName implements CosUnicodeName {

	public static final Logger LOGGER = Logger.getLogger(GFCosUnicodeName.class.getCanonicalName());

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
	// TODO : check implementation
	@Override
	public Boolean getisValidUtf8() {
		CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
		CharsetEncoder encoder = Charset.forName("Windows-1252").newEncoder();
		ByteBuffer tmp;
		try {
			tmp = encoder.encode(CharBuffer.wrap(this.baseObject.getString()));
		} catch (CharacterCodingException e) {
			LOGGER.log(Level.FINE, e.getMessage(), e);
			return Boolean.FALSE;
		}

		try {
			decoder.decode(tmp);
			return Boolean.TRUE;
		} catch (CharacterCodingException e){
			LOGGER.log(Level.FINE, e.getMessage(), e);
			return Boolean.FALSE;
		}
	}

	/**
	 * @return converted to UTF-8 name
	 */
	// TODO : check implementation
	@Override
	public String getunicodeValue() {
		String name = this.baseObject.getString();
		byte[] bytes = name.getBytes();
		try {
			return new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			LOGGER.log(Level.FINE, "Can not transform " + name + " to unicode string.", e);
			return null;
		}
	}

}
