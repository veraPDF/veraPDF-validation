package org.verapdf.model.factory.fonts;

import org.verapdf.model.factory.operators.RenderingMode;
import org.verapdf.model.impl.pd.font.GFPDTrueTypeFont;
import org.verapdf.model.impl.pd.font.GFPDType0Font;
import org.verapdf.model.impl.pd.font.GFPDType1Font;
import org.verapdf.model.impl.pd.font.GFPDType3Font;
import org.verapdf.model.impl.pd.util.PDResourcesHandler;
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
	public static final String TYPE_0 = "CIDFontType0";
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
