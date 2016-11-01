package org.verapdf.gf.model.impl.pd.font;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.gf.model.factory.operators.RenderingMode;
import org.verapdf.gf.model.impl.pd.GFPDObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDCIDFont;
import org.verapdf.model.pdlayer.PDCMap;
import org.verapdf.model.pdlayer.PDType0Font;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents Type0 font dictionary.
 *
 * @author Sergey Shemyakov
 */
public class GFPDType0Font extends GFPDFont implements PDType0Font {

	private static final Logger LOGGER = Logger.getLogger(GFPDType0Font.class.getCanonicalName());

	public static final String TYPE_0_FONT_TYPE = "PDType0Font";

	public static final String DESCENDANT_FONTS = "DescendantFonts";
	public static final String ENCODING = "Encoding";

	private PDCIDFont descendantFont;
	private org.verapdf.pd.font.PDCIDFont cidFont;

	public GFPDType0Font(org.verapdf.pd.font.PDType0Font font, RenderingMode renderingMode) {
		super(font, renderingMode, TYPE_0_FONT_TYPE);
		this.descendantFont = this.getDescendantFont();
		((org.verapdf.pd.font.PDType0Font) this.pdFont).setFontProgramFromDescendant(this.cidFont);
		this.fontProgramParsed = this.descendantFont != null
				&& ((GFPDCIDFont) this.descendantFont).isFontProgramParsed();
		this.pdFont.setSuccessfullyParsed(this.fontProgramParsed);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
		case DESCENDANT_FONTS:
			return this.getDescendantFonts();
		case ENCODING:
			return this.getEncoding();
		default:
			return super.getLinkedObjects(link);
		}
	}

	/**
	 * @return link to the descendant CIDFont.
	 */
	private List<PDCIDFont> getDescendantFonts() {
		if (this.descendantFont != null) {
			List<PDCIDFont> list = new ArrayList<>(GFPDObject.MAX_NUMBER_OF_ELEMENTS);
			list.add(descendantFont);
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private PDCIDFont getDescendantFont() {
		COSDictionary cidFontDict = ((org.verapdf.pd.font.PDType0Font) this.pdFont).getDescendantFont();
		if (cidFontDict != null) {
			org.verapdf.pd.font.PDCIDFont cidFont = new org.verapdf.pd.font.PDCIDFont(cidFontDict,
					((org.verapdf.pd.font.PDType0Font) this.pdFont).getCMap().getCMapFile());
			this.cidFont = cidFont;
			PDCIDFont pdCIDFont = new GFPDCIDFont(cidFont, renderingMode);
			return pdCIDFont;
		}
		return null;
	}

	/**
	 * @return font CMap (Encoding entry).
	 */
	private List<PDCMap> getEncoding() {
		if (((org.verapdf.pd.font.PDType0Font) this.pdFont).getCMap() != null) {
			PDCMap res = new GFPDCmap(((org.verapdf.pd.font.PDType0Font) this.pdFont).getCMap());
			List<PDCMap> list = new ArrayList<>(GFPDObject.MAX_NUMBER_OF_ELEMENTS);
			list.add(res);
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	/**
	 * @return true if Registry and Ordering keys of the corresponding CMap and
	 *         CIDFont are compatible.
	 */
	@Override
	public Boolean getareRegistryOrderingCompatible() {
		if (((org.verapdf.pd.font.PDType0Font) this.pdFont).getCIDSystemInfo() == null) {
			LOGGER.log(Level.SEVERE, "CID font dictionary doesn't contain CIDSystemInfo");
			return Boolean.valueOf(false);
		}
		if (((org.verapdf.pd.font.PDType0Font) this.pdFont).getCMap() == null) {
			LOGGER.log(Level.SEVERE, "Type 0 font dictionary doesn't contain Encoding");
			return Boolean.valueOf(false);
		}
		return Boolean
				.valueOf(this.isOrderingCompatible() && this.isRegistryCompatible());
	}

	/**
	 * @return true if the Supplement key in the CIDFont is greater or equal to
	 *         the Supplement key in the CMap dictionary.
	 */
	@Override
	public Boolean getisSupplementCompatible() {
		if (((org.verapdf.pd.font.PDType0Font) this.pdFont).getCIDSystemInfo() == null) {
			LOGGER.log(Level.SEVERE, "CID font dictionary doesn't contain CIDSystemInfo");
			return Boolean.valueOf(false);
		}
		if (((org.verapdf.pd.font.PDType0Font) this.pdFont).getCMap() == null) {
			LOGGER.log(Level.SEVERE, "Type 0 font dictionary doesn't contain Encoding");
			return Boolean.valueOf(false);
		}
		Long fontSupplement = ((org.verapdf.pd.font.PDType0Font) this.pdFont).getCIDSystemInfo()
				.getIntegerKey(ASAtom.SUPPLEMENT);
		Long cMapSupplement = ((org.verapdf.pd.font.PDType0Font) this.pdFont).getCMap().getSupplement();
		if (fontSupplement == null) {
			LOGGER.log(Level.SEVERE, "CIDSystemInfo dictionary doesn't contain Supplement entry.");
			return Boolean.valueOf(false);
		}
		return Boolean.valueOf(fontSupplement.longValue() >= cMapSupplement.longValue());
	}

	/**
	 * @return the name of the CMap.
	 */
	@Override
	public String getcmapName() {
		org.verapdf.pd.font.cmap.PDCMap pdcMap = ((org.verapdf.pd.font.PDType0Font) this.pdFont).getCMap();
		if (pdcMap == null) {
			return "";
		}
		return pdcMap.getCMapName();
	}

	@Override
	public String getSubtype() {
		ASAtom subtype = ((org.verapdf.pd.font.PDType0Font) this.pdFont).getType0FontDict().getNameKey(ASAtom.SUBTYPE);
		return subtype == null ? null : subtype.getValue();
	}

	private boolean isRegistryCompatible() {
		String fontRegistry = ((org.verapdf.pd.font.PDType0Font) this.pdFont).getCIDSystemInfo()
				.getStringKey(ASAtom.REGISTRY);
		String cMapRegistry = ((org.verapdf.pd.font.PDType0Font) this.pdFont).getCMap().getRegistry();
		if (fontRegistry == null) {
			LOGGER.log(Level.SEVERE, "CIDSystemInfo dictionary doesn't contain Registry entry.");
			return false;
		}
		return fontRegistry.equals(cMapRegistry);
	}

	private boolean isOrderingCompatible() {
		String fontOrdering = ((org.verapdf.pd.font.PDType0Font) this.pdFont).getCIDSystemInfo()
				.getStringKey(ASAtom.ORDERING);
		String cMapOrdering = ((org.verapdf.pd.font.PDType0Font) this.pdFont).getCMap().getOrdering();
		if (fontOrdering == null) {
			LOGGER.log(Level.SEVERE, "CIDSystemInfo dictionary doesn't contain Ordering entry.");
			return false;
		}
		return fontOrdering.equals(cMapOrdering);
	}
}
