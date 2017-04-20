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
package org.verapdf.gf.model.impl.operator.textshow;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.*;
import org.verapdf.gf.model.factory.colors.ColorSpaceFactory;
import org.verapdf.gf.model.factory.fonts.FontFactory;
import org.verapdf.gf.model.factory.operators.GraphicState;
import org.verapdf.gf.model.factory.operators.RenderingMode;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.operator.base.GFOperator;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.operator.Glyph;
import org.verapdf.model.operator.OpTextShow;
import org.verapdf.model.pdlayer.PDFont;
import org.verapdf.pd.colors.PDColorSpace;
import org.verapdf.pd.font.FontProgram;
import org.verapdf.pd.font.PDType0Font;
import org.verapdf.pd.font.PDType3Font;
import org.verapdf.pd.font.cff.CFFFontProgram;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Timur Kamalov
 */
public abstract class GFOpTextShow extends GFOperator implements OpTextShow {

	private static final Logger LOGGER = Logger.getLogger(GFOpTextShow.class.getCanonicalName());

	/**
	 * Name of link to the used font
	 */
	public static final String FONT = "font";
	/**
	 * Name of link to the used glyphs
	 */
	public static final String USED_GLYPHS = "usedGlyphs";
	/**
	 * Name of link to the fill color space
	 */
	public static final String FILL_COLOR_SPACE = "fillCS";
	/**
	 * Name of link to the stroke color space
	 */
	public static final String STROKE_COLOR_SPACE = "strokeCS";

	private final PDColorSpace rawFillColorSpace;
	private final PDColorSpace rawStrokeColorSpace;

	private final COSName fontName;

	private final RenderingMode renderingMode;

	private final int opm;
	private final boolean overprintingFlagStroke;
	private final boolean overprintingFlagNonStroke;

	private final PDResourcesHandler resourcesHandler;

	private List<PDFont> fonts = null;
	private List<org.verapdf.model.pdlayer.PDColorSpace> fillCS = null;
	private List<org.verapdf.model.pdlayer.PDColorSpace> strokeCS = null;

	protected GFOpTextShow(List<COSBase> arguments, GraphicState state, PDResourcesHandler resourcesHandler,
			final String opType) {
		this(arguments, state.getFillColorSpace(), state.getStrokeColorSpace(), state.getFontName(),
				state.getRenderingMode(), state.getOpm(), state.isOverprintingFlagStroke(),
				state.isOverprintingFlagNonStroke(), resourcesHandler, opType);
	}

	protected GFOpTextShow(List<COSBase> arguments, final PDColorSpace rawFillColorSpace,
			final PDColorSpace rawStrokeColorSpace, final COSName fontName, final RenderingMode renderingMode, int opm,
			boolean overprintingFlagStroke, boolean overprintingFlagNonStroke,
			final PDResourcesHandler resourcesHandler, final String operatorType) {
		super(arguments, operatorType);
		this.rawFillColorSpace = rawFillColorSpace;
		this.rawStrokeColorSpace = rawStrokeColorSpace;
		this.fontName = fontName;
		this.renderingMode = renderingMode;
		this.opm = opm;
		this.overprintingFlagStroke = overprintingFlagStroke;
		this.overprintingFlagNonStroke = overprintingFlagNonStroke;
		this.resourcesHandler = resourcesHandler;
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
		case FONT:
			return this.getFont();
		case USED_GLYPHS:
			return this.getUsedGlyphs();
		case FILL_COLOR_SPACE:
			return this.getFillColorSpace();
		case STROKE_COLOR_SPACE:
			return this.getStrokeColorSpace();
		default:
			return super.getLinkedObjects(link);
		}
	}

	private List<PDFont> getFont() {
		if (this.fonts == null) {
			this.fonts = parseFont();
		}
		return this.fonts;
	}

	public PDFont getVeraModelFont() {
		if (this.fonts == null) {
			this.fonts = parseFont();
		}
		return this.fonts.isEmpty() ? null : this.fonts.get(0);
	}

	private List<Glyph> getUsedGlyphs() {
		org.verapdf.pd.font.PDFont font = getFontFromResources();
		if (font == null) {
			return Collections.emptyList();
		}
		FontProgram fontProgram = font.getFontProgram();
		if (fontProgram instanceof CFFFontProgram) {
			StaticContainers.getDocument().getDocument().getResourceHandler().addResource(
					fontProgram.getFontProgramResource());
		}
		boolean fontProgramIsInvalid = (fontProgram == null || !font.isSuccessfullyParsed())
				&& font.getSubtype() != ASAtom.TYPE3;

		List<Glyph> res = new ArrayList<>();
		List<byte[]> strings = GFOpTextShow.getStrings(this.arguments);
		for (byte[] string : strings) {
			try (InputStream inputStream = new ByteArrayInputStream(string)) {
				while (inputStream.available() > 0) {
					int code = font.readCode(inputStream);
					if (font.getSubtype() != ASAtom.TYPE3) {
						Boolean glyphPresent = null;
						Boolean widthsConsistent = null;
						if (!fontProgramIsInvalid) {
							fontProgram.parseFont();
							// every font contains notdef glyph. But if we call method
							// of font program we can't distinguish case of code 0
							// and glyph that is not present indeed.
							glyphPresent = code == 0 ? true :
									Boolean.valueOf(fontProgram.containsCode(code));
							widthsConsistent = GFOpTextShow.checkWidths(code, font, fontProgram);
						}
						GFGlyph glyph;
						if (font.getSubtype() == ASAtom.CID_FONT_TYPE0 || font.getSubtype() == ASAtom.CID_FONT_TYPE2) {
							int CID = ((PDType0Font) font).toCID(code);
							glyph = new GFCIDGlyph(glyphPresent, widthsConsistent, font, code, CID,
									this.renderingMode.getValue());
						} else {
							glyph = new GFGlyph(glyphPresent, widthsConsistent, font, code,
									this.renderingMode.getValue());
						}
						res.add(glyph);
					} else { // Type3 font
						boolean glyphPresent = ((PDType3Font) font).containsCharString(code);
						boolean widthConsistent = font.getWidth(code) != null && font.getWidth(code).doubleValue() > 0;
						res.add(new GFGlyph(Boolean.valueOf(glyphPresent), Boolean.valueOf(widthConsistent), font, code,
								this.renderingMode.getValue()));
					}
				}
			} catch (IOException e) {
				LOGGER.log(Level.FINE, "Error processing text show operator's string argument : " + new String(string), e);
			}
		}
		return res;

	}

	private List<org.verapdf.model.pdlayer.PDColorSpace> getFillColorSpace() {
		if (this.fillCS == null) {
			this.fillCS = parseFillColorSpace();
		}
		return this.fillCS;
	}

	private List<org.verapdf.model.pdlayer.PDColorSpace> getStrokeColorSpace() {
		if (this.strokeCS == null) {
			this.strokeCS = parseStrokeColorSpace();
		}
		return this.strokeCS;
	}

	public org.verapdf.model.pdlayer.PDColorSpace getVeraModelFillColorSpace() {
		if (this.fillCS == null) {
			this.fillCS = parseFillColorSpace();
		}
		return this.fillCS.isEmpty() ? null : this.fillCS.get(0);
	}

	public org.verapdf.model.pdlayer.PDColorSpace getVeraModelStrokeColorSpace() {
		if (this.strokeCS == null) {
			this.strokeCS = parseStrokeColorSpace();
		}
		return this.strokeCS.isEmpty() ? null : this.strokeCS.get(0);
	}

	private List<PDFont> parseFont() {
		PDFont font = FontFactory.parseFont(getFontFromResources(), renderingMode, this.resourcesHandler);
		if (font != null) {
			List<PDFont> result = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			result.add(font);
			return Collections.unmodifiableList(result);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.pdlayer.PDColorSpace> parseFillColorSpace() {
		if (this.renderingMode.isFill()) {
			return this.getColorSpace(this.rawFillColorSpace, this.overprintingFlagNonStroke);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.pdlayer.PDColorSpace> parseStrokeColorSpace() {
		if (this.renderingMode.isStroke()) {
			return this.getColorSpace(this.rawStrokeColorSpace, this.overprintingFlagStroke);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.pdlayer.PDColorSpace> getColorSpace(org.verapdf.pd.colors.PDColorSpace rawColorSpace,
			boolean op) {
		org.verapdf.model.pdlayer.PDColorSpace veraColorSpace = ColorSpaceFactory.getColorSpace(rawColorSpace,
				this.resourcesHandler, this.opm, op);
		if (veraColorSpace != null) {
			List<org.verapdf.model.pdlayer.PDColorSpace> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(veraColorSpace);
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.pd.font.PDFont getFontFromResources() {
		if (resourcesHandler == null) {
			return null;
		}
		return resourcesHandler.getFont(this.fontName);
	}

	private static Boolean checkWidths(int glyphCode, org.verapdf.pd.font.PDFont font, FontProgram fontProgram) {
		Double fontWidth = font.getWidth(glyphCode);
		double expectedWidth = fontWidth == null ? 0 : fontWidth.doubleValue();
		double foundWidth = fontProgram.getWidth(glyphCode);
		if (foundWidth == -1) {
			foundWidth = font.getDefaultWidth() == null ? 0 : font.getDefaultWidth().doubleValue();
		}
		// consistent is defined to be a difference of no more than 1/1000 unit.
		return Math.abs(foundWidth - expectedWidth) > 1 ? Boolean.FALSE : Boolean.TRUE;
	}

	/**
	 * @return char codes that has been used by this operator
	 */
	public byte[] getCharCodes() {
		List<byte[]> strings = GFOpTextShow.getStrings(this.arguments);
		Set<Byte> resSet = new HashSet<>();
		for (byte[] string : strings) {
			for (byte b : string) {
				resSet.add(Byte.valueOf(b));
			}
		}
		byte[] res = new byte[resSet.size()];
		int i = 0;
		for (Byte b : resSet) {
			res[i++] = b.byteValue();
		}
		return res;
	}

	private static List<byte[]> getStrings(List<COSBase> stringArgs) {
		if (!stringArgs.isEmpty()) {
			List<byte[]> res = new ArrayList<>();
			COSBase arg = stringArgs.get(0);
			if (arg != null) {
				if (arg.getType() == COSObjType.COS_ARRAY) {
					GFOpTextShow.addArrayElements(res, (COSArray) arg.getDirectBase());
				} else {
					if (arg.getType() == COSObjType.COS_STRING) {
						res.add(((COSString) (arg.getDirectBase())).get());
					}
				}
			}
			return res;
		}
		return Collections.emptyList();
	}

	private static void addArrayElements(List<byte[]> res, COSArray arg) {
		for (COSObject element : arg) {
			if (element != null && element.getType() == COSObjType.COS_STRING) {
				res.add(((COSString) element.getDirectBase()).get());
			}
		}
	}

}
