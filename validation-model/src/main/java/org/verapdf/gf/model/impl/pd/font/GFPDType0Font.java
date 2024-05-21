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
package org.verapdf.gf.model.impl.pd.font;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.gf.model.factory.operators.RenderingMode;
import org.verapdf.gf.model.impl.pd.GFPDObject;
import org.verapdf.gf.model.tools.GFIDGenerator;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDCIDFont;
import org.verapdf.model.pdlayer.PDCMap;
import org.verapdf.model.pdlayer.PDType0Font;
import org.verapdf.pd.font.PDCIDSystemInfo;

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

	private final PDCIDFont descendantFont;
	private org.verapdf.pd.font.PDCIDFont cidFont;

	public GFPDType0Font(org.verapdf.pd.font.PDType0Font font, RenderingMode renderingMode) {
		super(font, renderingMode, TYPE_0_FONT_TYPE);
		this.descendantFont = this.calculateDescendantFont();
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

	public PDCIDFont getDescendantFont() {
		return this.descendantFont;
	}

	private PDCIDFont calculateDescendantFont() {
		COSDictionary cidFontDict = ((org.verapdf.pd.font.PDType0Font) this.pdFont).getDescendantFont();
		if (cidFontDict != null) {
			org.verapdf.pd.font.PDCIDFont cidFont = new org.verapdf.pd.font.PDCIDFont(cidFontDict,
					((org.verapdf.pd.font.PDType0Font) this.pdFont).getCMap().getCMapFile(),
					this.pdFont.getFontProgram(), this.pdFont.isSuccessfullyParsed());
			this.cidFont = cidFont;
			return new GFPDCIDFont(cidFont, renderingMode, GFIDGenerator.generateID(this.pdFont));
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

	@Override
	public String getCIDFontOrdering() {
		PDCIDSystemInfo info = ((org.verapdf.pd.font.PDType0Font) this.pdFont).getCIDSystemInfo();
		if (info == null) {
			LOGGER.log(Level.FINE, "CID font dictionary doesn't contain CIDSystemInfo");
			return null;
		}
		return info.getStringKey(ASAtom.ORDERING);
	}

	@Override
	public String getCMapOrdering() {
		org.verapdf.pd.font.cmap.PDCMap cmap = ((org.verapdf.pd.font.PDType0Font) this.pdFont).getCMap();
		if (cmap == null) {
			LOGGER.log(Level.FINE, "Type 0 font dictionary doesn't contain Encoding");
			return null;
		}
		return cmap.getOrdering();
	}

	@Override
	public String getCIDFontRegistry() {
		PDCIDSystemInfo info = ((org.verapdf.pd.font.PDType0Font) this.pdFont).getCIDSystemInfo();
		if (info == null) {
			LOGGER.log(Level.FINE, "CID font dictionary doesn't contain CIDSystemInfo");
			return null;
		}
		return info.getStringKey(ASAtom.REGISTRY);
	}

	@Override
	public String getCMapRegistry() {
		org.verapdf.pd.font.cmap.PDCMap cmap = ((org.verapdf.pd.font.PDType0Font) this.pdFont).getCMap();
		if (cmap == null) {
			LOGGER.log(Level.FINE, "Type 0 font dictionary doesn't contain Encoding");
			return null;
		}
		return cmap.getRegistry();
	}

	@Override
	public Long getCIDFontSupplement() {
		PDCIDSystemInfo info = ((org.verapdf.pd.font.PDType0Font) this.pdFont).getCIDSystemInfo();
		if (info == null) {
			LOGGER.log(Level.FINE, "CID font dictionary doesn't contain CIDSystemInfo");
			return null;
		}
		Long supplement = info.getIntegerKey(ASAtom.SUPPLEMENT);
		return supplement != null ? supplement : 0L;
	}

	@Override
	public Long getCMapSupplement() {
		org.verapdf.pd.font.cmap.PDCMap cmap = ((org.verapdf.pd.font.PDType0Font) this.pdFont).getCMap();
		if (cmap == null) {
			LOGGER.log(Level.FINE, "Type 0 font dictionary doesn't contain Encoding");
			return null;
		}
		Long supplement = cmap.getSupplement();
		return supplement != null ? supplement : 0L;
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
		return ((org.verapdf.pd.font.PDType0Font) this.pdFont).getType0FontDict().getNameKeyStringValue(ASAtom.SUBTYPE);
	}

	private boolean isRegistryCompatible() {
		String fontRegistry = ((org.verapdf.pd.font.PDType0Font) this.pdFont).getCIDSystemInfo()
				.getStringKey(ASAtom.REGISTRY);
		String cMapRegistry = ((org.verapdf.pd.font.PDType0Font) this.pdFont).getCMap().getRegistry();
		if (fontRegistry == null) {
			LOGGER.log(Level.FINE, "CIDSystemInfo dictionary doesn't contain Registry entry.");
			return false;
		}
		return fontRegistry.equals(cMapRegistry);
	}

	private boolean isOrderingCompatible() {
		String fontOrdering = ((org.verapdf.pd.font.PDType0Font) this.pdFont).getCIDSystemInfo()
				.getStringKey(ASAtom.ORDERING);
		String cMapOrdering = ((org.verapdf.pd.font.PDType0Font) this.pdFont).getCMap().getOrdering();
		if (fontOrdering == null) {
			LOGGER.log(Level.FINE, "CIDSystemInfo dictionary doesn't contain Ordering entry.");
			return false;
		}
		return fontOrdering.equals(cMapOrdering);
	}
}
