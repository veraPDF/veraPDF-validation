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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSName;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSString;
import org.verapdf.gf.model.factory.colors.ColorSpaceFactory;
import org.verapdf.gf.model.factory.fonts.FontFactory;
import org.verapdf.gf.model.factory.operators.GraphicState;
import org.verapdf.gf.model.factory.operators.RenderingMode;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.operator.base.GFOperator;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOpMarkedContent;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.operator.Glyph;
import org.verapdf.model.operator.OpTextShow;
import org.verapdf.model.pdlayer.PDFont;
import org.verapdf.pd.colors.PDColorSpace;
import org.verapdf.pd.font.FontProgram;
import org.verapdf.pd.font.cff.CFFFontProgram;
import org.verapdf.pd.structure.StructureElementAccessObject;

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
	private final GraphicState inheritedGraphicState;

	private final PDResourcesHandler resourcesHandler;
	private final GFOpMarkedContent markedContent;
	private final StructureElementAccessObject structureElementAccessObject;

	private List<PDFont> fonts = null;
	private List<org.verapdf.model.pdlayer.PDColorSpace> fillCS = null;
	private List<org.verapdf.model.pdlayer.PDColorSpace> strokeCS = null;

	protected GFOpTextShow(List<COSBase> arguments, GraphicState state, PDResourcesHandler resourcesHandler,
						   final String opType, GFOpMarkedContent markedContent,
						   StructureElementAccessObject structureElementAccessObject) {
		super(arguments, opType);
		this.rawFillColorSpace = state.getFillColorSpace();
		this.rawStrokeColorSpace = state.getStrokeColorSpace();
		this.fontName = state.getFontName();
		this.renderingMode = state.getRenderingMode();
		this.opm = state.getOpm();
		this.overprintingFlagStroke = state.isOverprintingFlagStroke();
		this.overprintingFlagNonStroke = state.isOverprintingFlagNonStroke();
		this.resourcesHandler = resourcesHandler;
		this.markedContent = markedContent;
		this.inheritedGraphicState = state;
		this.structureElementAccessObject = structureElementAccessObject;
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

		List<Glyph> res = new ArrayList<>();
		List<byte[]> strings = GFOpTextShow.getStrings(this.arguments);
		for (byte[] string : strings) {
			try (InputStream inputStream = new ByteArrayInputStream(string)) {
				while (inputStream.available() > 0) {
					int code = font.readCode(inputStream);
					Glyph glyph;
					glyph = GFGlyph.getGlyph(font, code, this.renderingMode.getValue(),
							markedContent, structureElementAccessObject);
						res.add(glyph);
				}
			} catch (IOException e) {
				LOGGER.log(Level.FINE, "Error processing text show operator's string argument : " + new String(string), e);
				StaticContainers.setValidPDF(false);
			}
		}
		return Collections.unmodifiableList(res);

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
		PDFont font = FontFactory.parseFont(getFontFromResources(), renderingMode,
				this.resourcesHandler, this.inheritedGraphicState);
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
				this.resourcesHandler, this.opm, op, inheritedGraphicState);
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
