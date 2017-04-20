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
package org.verapdf.gf.model.factory.fonts;

import org.verapdf.gf.model.factory.operators.RenderingMode;
import org.verapdf.gf.model.impl.pd.font.GFPDTrueTypeFont;
import org.verapdf.gf.model.impl.pd.font.GFPDType0Font;
import org.verapdf.gf.model.impl.pd.font.GFPDType1Font;
import org.verapdf.gf.model.impl.pd.font.GFPDType3Font;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.pdlayer.PDFont;
import org.verapdf.pd.PDResources;
import org.verapdf.pd.font.PDType0Font;
import org.verapdf.pd.font.PDType3Font;
import org.verapdf.pd.font.truetype.PDTrueTypeFont;
import org.verapdf.pd.font.type1.PDType1Font;

/**
 * @author Timur Kamalov
 */
public class FontFactory {

	/** Type name for {@code Type0} font */
	public static final String TYPE_0 = "Type0";
	/** Type name for {@code Type1} font */
	public static final String TYPE_1 = "Type1";
	/** Type name for {@code MMType1} font */
	public static final String MM_TYPE_1 = "MMType1";
	/** Type name for {@code Type3} font */
	public static final String TYPE_3 = "Type3";
	/** Type name for {@code TrueType} font */
	public static final String TRUE_TYPE = "TrueType";
	/** Type name for {@code CIDFontType2} font */
	public static final String CID_FONT_TYPE_2 = "CIDFontType2";


	private FontFactory() {
		// Disable default constructor
	}

	public static PDFont parseFont(org.verapdf.pd.font.PDFont rawFont,
								   RenderingMode renderingMode, PDResourcesHandler resources) {
		if (rawFont == null) {
			return null;
		}
		switch (rawFont.getSubtype().getValue()) {
			case TYPE_0:
				return new GFPDType0Font((PDType0Font) rawFont, renderingMode);
			case TYPE_1:
			case MM_TYPE_1:
				return new GFPDType1Font((PDType1Font) rawFont, renderingMode);
			case TYPE_3: {
				PDResources fontResources = ((PDType3Font) rawFont).getResources();
				PDResourcesHandler pdResources = resources.getExtendedResources(fontResources);
				return new GFPDType3Font((PDType3Font) rawFont, renderingMode, pdResources);
			}
			case TRUE_TYPE:
				return new GFPDTrueTypeFont((PDTrueTypeFont) rawFont, renderingMode);
			default:
				return null;
		}
	}

}
