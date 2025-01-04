/**
 * This file is part of veraPDF Feature Reporting, a module of the veraPDF project.
 * Copyright (c) 2015-2025, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Feature Reporting is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Feature Reporting as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Feature Reporting as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.features.gf.tools;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Helps in creating similar nodes in different features objects
 *
 * @author Maksim Bezrukov
 */
public final class GFAdapterHelper {

	private GFAdapterHelper() {
	}

	/**
	 * Generates byte array with contents of a stream
	 *
	 * @param is
	 *            input stream for converting
	 * @return byte array with contents of a stream
	 * @throws IOException
	 *             If the first byte cannot be read for any reason other than
	 *             end of file, or if the input stream has been closed, or if
	 *             some other I/O error occurs.
	 */
	public static byte[] inputStreamToByteArray(InputStream is) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] bytes = new byte[1024];
		int length;
		while ((length = is.read(bytes)) != -1) {
			baos.write(bytes, 0, length);
		}
		return baos.toByteArray();
	}

	public static String getStringFromASAtom(ASAtom asAtom) {
		return asAtom == null ? null : asAtom.getValue();
	}

	public static String getStringFromCOSObject(COSObject object) {
		if (object != null && !object.empty()
				&& (object.getType() == COSObjType.COS_NAME || object.getType() == COSObjType.COS_STRING)) {
			return object.getString();
		}
		return null;
	}
}
