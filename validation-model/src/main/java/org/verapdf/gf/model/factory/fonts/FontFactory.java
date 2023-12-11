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
package org.verapdf.gf.model.factory.fonts;

import org.verapdf.gf.model.factory.operators.GraphicState;
import org.verapdf.gf.model.factory.operators.RenderingMode;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.pd.font.*;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.gf.model.tools.GFIDGenerator;
import org.verapdf.model.pdlayer.PDFont;
import org.verapdf.pd.PDResources;
import org.verapdf.pd.font.PDType0Font;
import org.verapdf.pd.font.truetype.PDTrueTypeFont;
import org.verapdf.pd.font.type1.PDType1Font;
import org.verapdf.pd.font.type3.PDType3Font;

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

	public static PDFont parseFont(org.verapdf.pd.font.PDFont rawFont, RenderingMode renderingMode,
								   PDResourcesHandler resources, GraphicState inheritedGraphicState) {
		if (rawFont == null) {
			return new GFPDEmptyFont();
		}
		if (TYPE_3.equals(rawFont.getSubtype().getValue())) {
			PDResources fontResources = ((PDType3Font) rawFont).getResources();
			PDResourcesHandler pdResources = resources.getExtendedResources(fontResources);
			return new GFPDType3Font((PDType3Font) rawFont, renderingMode, pdResources, inheritedGraphicState);
		}
		String id = GFIDGenerator.generateID(rawFont, renderingMode);
		PDFont res = StaticContainers.getCachedFonts().get(id);
		if (res == null) {
			switch (rawFont.getSubtype().getValue()) {
				case TYPE_0:
					res = new GFPDType0Font((PDType0Font) rawFont, renderingMode);
					break;
				case TYPE_1:
				case MM_TYPE_1:
					res = new GFPDType1Font((PDType1Font) rawFont, renderingMode);
					break;
				case TRUE_TYPE:
					res = new GFPDTrueTypeFont((PDTrueTypeFont) rawFont, renderingMode);
					break;
			}
			StaticContainers.getCachedFonts().put(id, res);
		}
		return res;
	}

}
