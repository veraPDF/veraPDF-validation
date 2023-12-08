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
package org.verapdf.gf.model.impl.operator.textshow;

import org.verapdf.cos.*;
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
import org.verapdf.pd.font.FontProgram;
import org.verapdf.pd.font.cff.CFFFontProgram;
import org.verapdf.pd.structure.StructureElementAccessObject;
import org.verapdf.tools.StaticResources;

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

	private final org.verapdf.pd.font.PDFont font;
	private final Double scaleFactor;

	private final RenderingMode renderingMode;

	private final GraphicState inheritedGraphicState;

	private final PDResourcesHandler resourcesHandler;
	private final GFOpMarkedContent markedContent;
	private final StructureElementAccessObject structureElementAccessObject;

	private List<PDFont> fonts = null;
	private final org.verapdf.model.pdlayer.PDColorSpace fillCS;
	private final org.verapdf.model.pdlayer.PDColorSpace strokeCS;

	protected GFOpTextShow(List<COSBase> arguments, GraphicState state, PDResourcesHandler resourcesHandler,
						   GFOpMarkedContent markedContent, StructureElementAccessObject structureElementAccessObject,
						   final String opType) {
		super(arguments, opType);
		this.font = state.getFont();
		this.scaleFactor = state.getScaleFactor();
		this.renderingMode = state.getRenderingMode();
		this.resourcesHandler = resourcesHandler;
		this.markedContent = markedContent;
		this.inheritedGraphicState = state;
		this.structureElementAccessObject = structureElementAccessObject;
		this.fillCS = parseFillColorSpace();
		this.strokeCS = parseStrokeColorSpace();
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

	public Double getScaleFactor() {
		return scaleFactor;
	}

	public PDFont getVeraModelFont() {
		if (this.fonts == null) {
			this.fonts = parseFont();
		}
		return this.fonts.isEmpty() ? null : this.fonts.get(0);
	}

	private List<Glyph> getUsedGlyphs() {
		if (font == null) {
			return Collections.emptyList();
		}
		FontProgram fontProgram = font.getFontProgram();
		if (fontProgram instanceof CFFFontProgram) {
			StaticResources.getDocument().getDocument().getResourceHandler().addResource(
					fontProgram.getFontProgramResource());
		}

		List<Glyph> res = new ArrayList<>();
		List<byte[]> strings = GFOpTextShow.getStrings(this.arguments);
		for (byte[] string : strings) {
			try (InputStream inputStream = new ByteArrayInputStream(string)) {
				while (inputStream.available() > 0) {
					int code = font.readCode(inputStream);
					Glyph glyph = GFGlyph.getGlyph(font, code, this.renderingMode.getValue(),
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
		if (inheritedGraphicState.isProcessColorOperators() && this.fillCS != null) {
			List<org.verapdf.model.pdlayer.PDColorSpace> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(fillCS);
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.pdlayer.PDColorSpace> getStrokeColorSpace() {
		if (inheritedGraphicState.isProcessColorOperators() && this.strokeCS != null) {
			List<org.verapdf.model.pdlayer.PDColorSpace> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(strokeCS);
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	public org.verapdf.model.pdlayer.PDColorSpace getVeraModelFillColorSpace() {
		return this.fillCS;
	}

	public org.verapdf.model.pdlayer.PDColorSpace getVeraModelStrokeColorSpace() {
		return this.strokeCS;
	}

	private List<PDFont> parseFont() {
		PDFont font = FontFactory.parseFont(this.font, renderingMode, this.resourcesHandler, this.inheritedGraphicState);
		if (font != null) {
			List<PDFont> result = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			result.add(font);
			return Collections.unmodifiableList(result);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.pdlayer.PDColorSpace parseFillColorSpace() {
		if (inheritedGraphicState.getRenderingMode().isFill()) {
			return this.getColorSpace(inheritedGraphicState.getFillColorSpace(), 
					inheritedGraphicState.isOverprintingFlagNonStroke());
		}
		return null;
	}

	private org.verapdf.model.pdlayer.PDColorSpace parseStrokeColorSpace() {
		if (inheritedGraphicState.getRenderingMode().isStroke()) {
			return this.getColorSpace(inheritedGraphicState.getStrokeColorSpace(), 
					inheritedGraphicState.isOverprintingFlagStroke());
		}
		return null;
	}

	private org.verapdf.model.pdlayer.PDColorSpace getColorSpace(org.verapdf.pd.colors.PDColorSpace rawColorSpace,
			boolean op) {
		return ColorSpaceFactory.getColorSpace(rawColorSpace, this.resourcesHandler, inheritedGraphicState.getOpm(), op, 
				inheritedGraphicState);
	}

	/**
	 * @return char codes that has been used by this operator
	 */
	public byte[] getCharCodes() {
		List<byte[]> strings = GFOpTextShow.getStrings(this.arguments);
		Set<Byte> resSet = new HashSet<>();
		for (byte[] string : strings) {
			for (byte b : string) {
				resSet.add(b);
			}
		}
		byte[] res = new byte[resSet.size()];
		int i = 0;
		for (Byte b : resSet) {
			res[i++] = b;
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
