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
/**
 *
 */
package org.verapdf.gf.model.factory.operators;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.*;
import org.verapdf.gf.model.factory.colors.ColorSpaceFactory;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.operator.color.*;
import org.verapdf.gf.model.impl.operator.generalgs.*;
import org.verapdf.gf.model.impl.operator.inlineimage.GFOp_BI;
import org.verapdf.gf.model.impl.operator.inlineimage.GFOp_EI;
import org.verapdf.gf.model.impl.operator.inlineimage.GFOp_ID;
import org.verapdf.gf.model.impl.operator.markedcontent.*;
import org.verapdf.gf.model.impl.operator.opclip.GFOp_WStar;
import org.verapdf.gf.model.impl.operator.opclip.GFOp_W_clip;
import org.verapdf.gf.model.impl.operator.opcompability.GFOp_BX;
import org.verapdf.gf.model.impl.operator.opcompability.GFOp_EX;
import org.verapdf.gf.model.impl.operator.opcompability.GFOp_Undefined;
import org.verapdf.gf.model.impl.operator.pathconstruction.*;
import org.verapdf.gf.model.impl.operator.pathpaint.*;
import org.verapdf.gf.model.impl.operator.shading.GFOp_sh;
import org.verapdf.gf.model.impl.operator.specialgs.GFOp_Q_grestore;
import org.verapdf.gf.model.impl.operator.specialgs.GFOp_cm;
import org.verapdf.gf.model.impl.operator.specialgs.GFOp_q_gsave;
import org.verapdf.gf.model.impl.operator.textobject.GFOp_BT;
import org.verapdf.gf.model.impl.operator.textobject.GFOp_ET;
import org.verapdf.gf.model.impl.operator.textposition.*;
import org.verapdf.gf.model.impl.operator.textshow.*;
import org.verapdf.gf.model.impl.operator.textstate.*;
import org.verapdf.gf.model.impl.operator.type3font.GFOp_d0;
import org.verapdf.gf.model.impl.operator.type3font.GFOp_d1;
import org.verapdf.gf.model.impl.operator.xobject.GFOp_Do;
import org.verapdf.gf.model.impl.pd.colors.GFPDColorSpace;
import org.verapdf.gf.model.impl.pd.font.GFPDFont;
import org.verapdf.gf.model.impl.pd.images.GFPDXObject;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.gf.model.tools.FileSpecificationKeysHelper;
import org.verapdf.model.tools.constants.Operators;
import org.verapdf.operator.InlineImageOperator;
import org.verapdf.operator.Operator;
import org.verapdf.pd.PDExtGState;
import org.verapdf.pd.PDResource;
import org.verapdf.pd.colors.PDColorSpace;
import org.verapdf.pd.colors.PDDeviceCMYK;
import org.verapdf.pd.colors.PDDeviceGray;
import org.verapdf.pd.colors.PDDeviceRGB;
import org.verapdf.pd.patterns.PDPattern;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.pd.structure.PDStructTreeRoot;
import org.verapdf.pd.structure.StructureElementAccessObject;
import org.verapdf.pdfa.flavours.PDFAFlavour;
import org.verapdf.tools.StaticResources;

import java.util.*;
import java.util.logging.*;

/**
 * Main class that processes operators.
 *
 * @author Timur Kamalov
 */
class OperatorParser {

	private static final Logger LOGGER = Logger.getLogger(OperatorParser.class.getName());

	private final Deque<GraphicState> graphicStateStack = new ArrayDeque<>();
	private final GraphicState graphicState;

	private final Deque<TransparencyGraphicsState> transparencyGraphicStateStack = new ArrayDeque<>();
	private final Stack<GFOpMarkedContent> markedContentStack = new Stack<>();
	private final StructureElementAccessObject structureElementAccessObject;
	private final TransparencyGraphicsState transparencyGraphicState = new TransparencyGraphicsState();
	private final String parentStructureTag;
	private final String parentsTags;

	private boolean insideText = false;

	OperatorParser(GraphicState inheritedGraphicState,
				   StructureElementAccessObject structureElementAccessObject,
				   PDResourcesHandler resourcesHandler, String parentStructureTag, String parentsTags) {
		if (inheritedGraphicState == null) {
			this.graphicState = new GraphicState(resourcesHandler);
		} else {
			this.graphicState = inheritedGraphicState.clone();
		}
		this.graphicState.setInitialGraphicState(this.graphicState);
		this.structureElementAccessObject = structureElementAccessObject;
		this.parentStructureTag = parentStructureTag;
		this.parentsTags = parentsTags;
	}

	public TransparencyGraphicsState getTransparencyGraphicState() {
		TransparencyGraphicsState tgs = new TransparencyGraphicsState();
		tgs.copyProperties(this.transparencyGraphicState);
		return tgs;
	}

	public RenderingMode getGSRenderingMode() {
		return graphicState.getRenderingMode();
	}

	void parseOperator(List<org.verapdf.model.operator.Operator> processedOperators, Operator rawOperator,
					   PDResourcesHandler resourcesHandler, List<COSBase> arguments) {
		String operatorName = rawOperator.getOperator();
		switch (operatorName) {
			// GENERAL GS
			case Operators.D_SET_DASH:
				processedOperators.add(new GFOp_d(arguments));
				break;
			case Operators.GS:
				processExtGState(processedOperators, arguments, resourcesHandler, this.graphicState, this.transparencyGraphicState);
				break;
			case Operators.I_SETFLAT:
				processedOperators.add(new GFOp_i(arguments));
				break;
			case Operators.J_LINE_CAP:
				processedOperators.add(new GFOp_J_line_cap(arguments));
				break;
			case Operators.J_LINE_JOIN:
				processedOperators.add(new GFOp_j_line_join(arguments));
				break;
			case Operators.M_MITER_LIMIT:
				processedOperators.add(new GFOp_M_miter_limit(arguments));
				break;
			case Operators.RI:
				if (this.graphicState.isProcessColorOperators()) {
					processedOperators.add(new GFOp_ri(arguments));
				}
				break;
			case Operators.W_LINE_WIDTH:
				processedOperators.add(new GFOp_w_line_width(arguments));
				break;

			// MARKED CONTENT
			case Operators.BMC:
				GFOp_BMC bmcOp = new GFOp_BMC(arguments, getCurrentMarkedContent(), parentsTags);
				processedOperators.add(bmcOp);
				this.markedContentStack.push(bmcOp);
				break;
			case Operators.BDC:
				PDFAFlavour.Specification specification = StaticContainers.getFlavour().getPart();
				if (specification == PDFAFlavour.Specification.ISO_19005_3
						|| specification == PDFAFlavour.Specification.ISO_19005_4) {
					checkAFKey(arguments, resourcesHandler);
				}
				GFOp_BDC bdcOp = new GFOp_BDC(arguments, resourcesHandler, getCurrentMarkedContent(), structureElementAccessObject, parentsTags);
				processedOperators.add(bdcOp);
				this.markedContentStack.push(bdcOp);
				break;
			case Operators.EMC:
				processedOperators.add(new GFOp_EMC(arguments));
				if (!this.markedContentStack.empty()) {
					this.markedContentStack.pop();
				} else {
					LOGGER.log(Level.WARNING, "Operator (EMC) not inside marked content");
				}
				break;
			case Operators.MP:
				processedOperators.add(new GFOp_MP(arguments));
				break;
			case Operators.DP:
				processedOperators.add(new GFOp_DP(arguments, resourcesHandler));
				break;

			// CLIP
			case Operators.W_CLIP:
				processedOperators.add(new GFOp_W_clip(arguments));
				break;
			case Operators.W_STAR_EOCLIP:
				processedOperators.add(new GFOp_WStar(arguments));
				break;

			// COLOR
			case Operators.G_STROKE: {
				if (this.graphicState.isProcessColorOperators()) {
					processColorSpace(this.graphicState, resourcesHandler, PDDeviceGray.INSTANCE,
					                  ASAtom.DEVICEGRAY, true);
					org.verapdf.model.pdlayer.PDColorSpace colorSpace = ColorSpaceFactory.getColorSpace(
							graphicState.getStrokeColorSpace(), resourcesHandler, graphicState);
					processedOperators.add(new GFOp_G_stroke(arguments, colorSpace));
				}
				break;
			}
			case Operators.G_FILL: {
				if (this.graphicState.isProcessColorOperators()) {
					processColorSpace(this.graphicState, resourcesHandler, PDDeviceGray.INSTANCE,
					                  ASAtom.DEVICEGRAY, false);
					org.verapdf.model.pdlayer.PDColorSpace colorSpace = ColorSpaceFactory.getColorSpace(
							graphicState.getFillColorSpace(), resourcesHandler, graphicState);
					processedOperators.add(new GFOp_g_fill(arguments, colorSpace));
				}
				break;
			}
			case Operators.RG_STROKE: {
				if (this.graphicState.isProcessColorOperators()) {
					processColorSpace(this.graphicState, resourcesHandler, PDDeviceRGB.INSTANCE,
					                  ASAtom.DEVICERGB, true);
					org.verapdf.model.pdlayer.PDColorSpace colorSpace = ColorSpaceFactory.getColorSpace(
							graphicState.getStrokeColorSpace(), resourcesHandler, graphicState);
					processedOperators.add(new GFOp_RG_stroke(arguments, colorSpace));
				}
				break;
			}
			case Operators.RG_FILL: {
				if (this.graphicState.isProcessColorOperators()) {
					processColorSpace(this.graphicState, resourcesHandler, PDDeviceRGB.INSTANCE,
					                  ASAtom.DEVICERGB, false);
					org.verapdf.model.pdlayer.PDColorSpace colorSpace = ColorSpaceFactory.getColorSpace(
							graphicState.getFillColorSpace(), resourcesHandler, graphicState);
					processedOperators.add(new GFOp_rg_fill(arguments, colorSpace));
				}
				break;
			}
			case Operators.K_STROKE: {
				if (this.graphicState.isProcessColorOperators()) {
					processColorSpace(this.graphicState, resourcesHandler, PDDeviceCMYK.INSTANCE,
					                  ASAtom.DEVICECMYK, true);
					org.verapdf.model.pdlayer.PDColorSpace colorSpace = ColorSpaceFactory.getColorSpace(
							graphicState.getStrokeColorSpace(), resourcesHandler, graphicState);
					processedOperators.add(new GFOp_K_stroke(arguments, colorSpace));
				}
				break;
			}
			case Operators.K_FILL: {
				if (this.graphicState.isProcessColorOperators()) {
					processColorSpace(this.graphicState, resourcesHandler, PDDeviceCMYK.INSTANCE,
					                  ASAtom.DEVICECMYK, false);
					org.verapdf.model.pdlayer.PDColorSpace colorSpace = ColorSpaceFactory.getColorSpace(
							graphicState.getFillColorSpace(), resourcesHandler, graphicState);
					processedOperators.add(new GFOp_k_fill(arguments, colorSpace));
				}
				break;
			}
			case Operators.CS_STROKE:
				if (this.graphicState.isProcessColorOperators()) {
					this.graphicState.setStrokeColorSpace(resourcesHandler.getColorSpace(getLastCOSName(arguments)));
					processedOperators.add(getStrokeColorOperator(arguments, resourcesHandler, graphicState));
				}
				break;
			case Operators.CS_FILL:
				if (this.graphicState.isProcessColorOperators()) {
					this.graphicState.setFillColorSpace(resourcesHandler.getColorSpace(getLastCOSName(arguments)));
					processedOperators.add(getFillColorOperator(arguments, resourcesHandler, graphicState));
				}
				break;
			case Operators.SCN_STROKE:
				if (this.graphicState.isProcessColorOperators()) {
					processPatternColorSpace(arguments, this.graphicState, resourcesHandler, true);
					org.verapdf.model.pdlayer.PDColorSpace colorSpace = ColorSpaceFactory.getColorSpace(
							graphicState.getStrokeColorSpace(), resourcesHandler, graphicState);
					processedOperators.add(new GFOp_SCN_stroke(arguments, colorSpace));
				}
				break;
			case Operators.SCN_FILL:
				if (this.graphicState.isProcessColorOperators()) {
					processPatternColorSpace(arguments, this.graphicState, resourcesHandler,false);
					org.verapdf.model.pdlayer.PDColorSpace colorSpace = ColorSpaceFactory.getColorSpace(
							graphicState.getFillColorSpace(), resourcesHandler, graphicState);
					processedOperators.add(new GFOp_scn_fill(arguments, colorSpace));
				}
				break;
			case Operators.SC_STROKE:
				if (this.graphicState.isProcessColorOperators()) {
					processedOperators.add(new GFOp_SC_stroke(arguments));
				}
				break;
			case Operators.SC_FILL:
				if (this.graphicState.isProcessColorOperators()) {
					processedOperators.add(new GFOp_sc_fill(arguments));
				}
				break;

			// TEXT OBJECT
			case Operators.ET:
				insideText = false;
				processedOperators.add(new GFOp_ET(arguments));
				break;
			case Operators.BT:
				insideText = true;
				processedOperators.add(new GFOp_BT(arguments));
				break;

			// TEXT POSITION
			case Operators.TD_MOVE:
				processedOperators.add(new GFOp_Td(arguments));
				break;
			case Operators.TD_MOVE_SET_LEADING:
				processedOperators.add(new GFOp_TD_Big(arguments));
				break;
			case Operators.TM:
				processedOperators.add(new GFOp_Tm(arguments));
				break;
			case Operators.T_STAR:
				processedOperators.add(new GFOp_T_Star(arguments));
				break;

			// TEXT SHOW
			case Operators.TJ_SHOW:
				GFOp_Tj tj = new GFOp_Tj(arguments, this.graphicState.clone(),
						resourcesHandler, getCurrentMarkedContent(), structureElementAccessObject);
				addFontAndColorSpace(tj, this.transparencyGraphicState);
				processedOperators.add(tj);
				break;
			case Operators.TJ_SHOW_POS:
				GFOp_TJ_Big tjBig = new GFOp_TJ_Big(arguments, this.graphicState.clone(),
						resourcesHandler, getCurrentMarkedContent(), structureElementAccessObject);
				addFontAndColorSpace(tjBig, this.transparencyGraphicState);
				processedOperators.add(tjBig);
				break;
			case Operators.QUOTE:
				GFOp_Quote quote = new GFOp_Quote(arguments, this.graphicState.clone(),
						resourcesHandler, getCurrentMarkedContent(), structureElementAccessObject);
				addFontAndColorSpace(quote, this.transparencyGraphicState);
				processedOperators.add(quote);
				break;
			case Operators.DOUBLE_QUOTE:
				GFOp_DoubleQuote doubleQuote = new GFOp_DoubleQuote(arguments, this.graphicState.clone(),
						resourcesHandler, getCurrentMarkedContent(), structureElementAccessObject);
				addFontAndColorSpace(doubleQuote, this.transparencyGraphicState);
				processedOperators.add(doubleQuote);
				break;

			// TEXT STATE
			case Operators.TZ:
				processedOperators.add(new GFOp_Tz(arguments));
				break;
			case Operators.TR:
				this.graphicState.setRenderingMode(getRenderingMode(arguments));
				processedOperators.add(new GFOp_Tr(arguments));
				break;
			case Operators.TF:
				this.graphicState.setFont(resourcesHandler.getFont(getFirstCOSName(arguments)));
				if (arguments.size() > 1) {
					COSBase scaleFactor = arguments.get(1);
					if (scaleFactor.getType().isNumber()) {
						this.graphicState.setScaleFactor(scaleFactor.getReal());
					}
				}
				processedOperators.add(new GFOp_Tf(arguments));
				break;
			case Operators.TC:
				processedOperators.add(new GFOp_Tc(arguments));
				break;
			case Operators.TW:
				processedOperators.add(new GFOp_Tw(arguments));
				break;
			case Operators.TL:
				processedOperators.add(new GFOp_Tl(arguments));
				break;
			case Operators.TS:
				processedOperators.add(new GFOp_Ts(arguments));
				break;

			// TYPE 3 FONT
			case Operators.D0:
				processedOperators.add(new GFOp_d0(arguments));
				break;
			case Operators.D1:
				processedOperators.add(new GFOp_d1(arguments));
				this.graphicState.disableColorOperators();
				break;

			// INLINE IMAGE
			case Operators.BI:
				processInlineImage(processedOperators,
						(InlineImageOperator) rawOperator,
						resourcesHandler,
						arguments,
						this.graphicState);
				break;

			// COMPABILITY
			case Operators.BX:
				processedOperators.add(new GFOp_BX(arguments));
				break;
			case Operators.EX:
				processedOperators.add(new GFOp_EX(arguments));
				break;

			// PATH CONSTRUCTION
			case Operators.C_CURVE_TO:
				processedOperators.add(new GFOp_c(arguments));
				break;
			case Operators.H_CLOSEPATH:
				processedOperators.add(new GFOp_h(arguments));
				break;
			case Operators.L_LINE_TO:
				processedOperators.add(new GFOp_l(arguments));
				break;
			case Operators.M_MOVE_TO:
				processedOperators.add(new GFOp_m_moveto(arguments));
				break;
			case Operators.RE:
				processedOperators.add(new GFOp_re(arguments));
				break;
			case Operators.V:
				processedOperators.add(new GFOp_v(arguments));
				break;
			case Operators.Y:
				processedOperators.add(new GFOp_y(arguments));
				break;

			// PATH PAINT
			case Operators.B_CLOSEPATH_FILL_STROKE:
				GFOp_b_closepath_fill_stroke b_closepath_fill_stroke = new GFOp_b_closepath_fill_stroke(arguments, this.graphicState, resourcesHandler);
				addColorSpace(b_closepath_fill_stroke, this.transparencyGraphicState);
				processedOperators.add(b_closepath_fill_stroke);
				break;
			case Operators.B_FILL_STROKE:
				GFOp_B_fill_stroke b_fill_stroke = new GFOp_B_fill_stroke(arguments, this.graphicState, resourcesHandler);
				addColorSpace(b_fill_stroke, this.transparencyGraphicState);
				processedOperators.add(b_fill_stroke);
				break;
			case Operators.B_STAR_CLOSEPATH_EOFILL_STROKE:
				GFOp_bstar_closepath_eofill_stroke bstar_closepath_eofill_stroke = new GFOp_bstar_closepath_eofill_stroke(arguments, this.graphicState, resourcesHandler);
				addColorSpace(bstar_closepath_eofill_stroke, this.transparencyGraphicState);
				processedOperators.add(bstar_closepath_eofill_stroke);
				break;
			case Operators.B_STAR_EOFILL_STROKE:
				GFOp_BStar_eofill_stroke bStar_eofill_stroke = new GFOp_BStar_eofill_stroke(arguments, this.graphicState, resourcesHandler);
				addColorSpace(bStar_eofill_stroke, this.transparencyGraphicState);
				processedOperators.add(bStar_eofill_stroke);
				break;
			case Operators.F_FILL:
				GFOp_f_fill f_fill = new GFOp_f_fill(arguments, this.graphicState, resourcesHandler);
				addColorSpace(f_fill, this.transparencyGraphicState);
				processedOperators.add(f_fill);
				break;
			case Operators.F_FILL_OBSOLETE:
				GFOp_F_fill_obsolete f_fill_obsolete = new GFOp_F_fill_obsolete(arguments, this.graphicState, resourcesHandler);
				addColorSpace(f_fill_obsolete, this.transparencyGraphicState);
				processedOperators.add(f_fill_obsolete);
				break;
			case Operators.F_STAR_FILL:
				GFOp_FStar fStar = new GFOp_FStar(arguments, this.graphicState, resourcesHandler);
				addColorSpace(fStar, this.transparencyGraphicState);
				processedOperators.add(fStar);
				break;
			case Operators.N:
				GFOp_n op_n = new GFOp_n(arguments);
				addColorSpace(op_n, this.transparencyGraphicState);
				processedOperators.add(op_n);
				break;
			case Operators.S_CLOSE_STROKE:
				GFOp_s_close_stroke s_close_stroke = new GFOp_s_close_stroke(arguments, this.graphicState, resourcesHandler);
				addColorSpace(s_close_stroke, this.transparencyGraphicState);
				processedOperators.add(s_close_stroke);
				break;
			case Operators.S_STROKE:
				GFOp_S_stroke s_stroke = new GFOp_S_stroke(arguments, this.graphicState, resourcesHandler);
				addColorSpace(s_stroke, this.transparencyGraphicState);
				processedOperators.add(s_stroke);
				break;

			// SHADING
			case Operators.SH:
				if (this.graphicState.isProcessColorOperators()) {
					processedOperators.add(new GFOp_sh(arguments, resourcesHandler.getShading(getLastCOSName(arguments))));
				}
				break;

			// SPECIAL GS
			case Operators.CM_CONCAT:
				if (insideText) {
					LOGGER.log(Level.WARNING, "Special graphics state operator (cm) inside Text object");
				}
				processedOperators.add(new GFOp_cm(arguments));
				break;
			case Operators.Q_GRESTORE:
				if (insideText) {
					LOGGER.log(Level.WARNING, "Special graphics state operator (Q) inside Text object");
				}
				if (!graphicStateStack.isEmpty()) {
					this.graphicState.copyProperties(this.graphicStateStack.pop());
				}
				if (!transparencyGraphicStateStack.isEmpty()) {
					this.transparencyGraphicState.copyProperties(this.transparencyGraphicStateStack.pop());
				}
				processedOperators.add(new GFOp_Q_grestore(arguments));
				break;
			case Operators.Q_GSAVE:
				if (insideText) {
					LOGGER.log(Level.WARNING, "Special graphics state operator (q) inside Text object");
				}
				this.graphicStateStack.push(this.graphicState.clone());
				this.transparencyGraphicStateStack.push(this.transparencyGraphicState.clone());
				processedOperators.add(new GFOp_q_gsave(arguments, this.graphicStateStack.size()));
				break;

			// XOBJECT
			case Operators.DO:
				Long mcid = null;
				String parentsTags = "";
				if (!markedContentStack.empty()) {
					mcid = markedContentStack.peek().getInheritedMCID();
					parentsTags = markedContentStack.peek().getParentsTags();
				}
				String parentStructureTag = getParentStructureTag(structureElementAccessObject, mcid);
				if (parentStructureTag == null) {
					parentStructureTag = this.parentStructureTag;
				}
				GFOp_Do op_do = new GFOp_Do(arguments, resourcesHandler.getXObject(getLastCOSName(arguments)),
						resourcesHandler, this.graphicState.clone(), parentStructureTag, parentsTags);
				List<org.verapdf.model.pdlayer.PDXObject> pdxObjects = op_do.getXObject();
				if (!pdxObjects.isEmpty()) {
					GFPDXObject xobj = (GFPDXObject) pdxObjects.get(0);
					this.transparencyGraphicState.setVeraXObject(xobj);
				}
				processedOperators.add(op_do);
				break;

			default:
				processedOperators.add(new GFOp_Undefined(operatorName, arguments));
				break;
		}
	}

	private static GFOpColor getStrokeColorOperator(List<COSBase> arguments,
													PDResourcesHandler resourcesHandler,
													GraphicState graphicState) {
		// OP and opm are not passed to color space factory: color space is being specified (not used yet)
		org.verapdf.model.pdlayer.PDColorSpace colorSpace = ColorSpaceFactory.getColorSpace(
				graphicState.getStrokeColorSpace(), resourcesHandler, graphicState);
		return new GFOpColor(arguments, colorSpace);
	}

	private static GFOpColor getFillColorOperator(List<COSBase> arguments,
													PDResourcesHandler resourcesHandler,
													GraphicState graphicState) {
		// op and opm are not passed to color space factory: color space is being specified (not used yet)
		org.verapdf.model.pdlayer.PDColorSpace colorSpace = ColorSpaceFactory.getColorSpace(
				graphicState.getFillColorSpace(), resourcesHandler, graphicState);
		return new GFOpColor(arguments, colorSpace);
	}

	private static void processExtGState(List<org.verapdf.model.operator.Operator> processedOperators, List<COSBase> arguments,
										 PDResourcesHandler resourcesHandler, GraphicState graphicState,
										 TransparencyGraphicsState transparencyGraphicsState) {
		PDExtGState extGState = resourcesHandler.getExtGState(getLastCOSName(arguments));
		graphicState.copyPropertiesFormExtGState(extGState);
		transparencyGraphicsState.copyPropertiesFormExtGState(extGState);
		processedOperators.add(new GFOp_gs(arguments, extGState));
	}

	private static void processColorSpace(GraphicState graphicState, PDResourcesHandler resourcesHandler,
										  PDColorSpace defaultCS, ASAtom name, boolean stroke) {
		PDColorSpace colorSpace = resourcesHandler.getColorSpace(name);
		if (colorSpace == null) {
			colorSpace = defaultCS;
		}
		if (stroke) {
			graphicState.setStrokeColorSpace(colorSpace);
		} else {
			graphicState.setFillColorSpace(colorSpace);
		}
	}

	private static void processPatternColorSpace(List<COSBase> arguments, GraphicState graphicState,
												 PDResourcesHandler resourcesHandler, boolean stroke) {
		PDColorSpace colorSpace = stroke ? graphicState.getStrokeColorSpace() : graphicState.getFillColorSpace();
		if (colorSpace != null && ASAtom.PATTERN == colorSpace.getType()) {
			PDColorSpace underlyingColorSpace = ((PDPattern) colorSpace).getUnderlyingColorSpace();
			PDPattern pattern = resourcesHandler.getPattern(getLastCOSName(arguments));
			if (stroke) {
				graphicState.setStrokeLastPatternUnderlyingColorSpace(underlyingColorSpace);
				graphicState.setStrokeColorSpace(pattern);
			} else {
				graphicState.setFillLastPatternUnderlyingColorSpace(underlyingColorSpace);
				graphicState.setFillColorSpace(pattern);
			}
		}
	}

	private static void processInlineImage(List<org.verapdf.model.operator.Operator> processedOperators,
										   InlineImageOperator rawOperator, PDResourcesHandler resourcesHandler,
										   List<COSBase> arguments, GraphicState gs) {
		COSDictionary imageParameters = rawOperator.getImageParameters();
		if (imageParameters != null
		    && (gs.isProcessColorOperators() || Boolean.TRUE.equals(imageParameters.getBooleanKey(ASAtom.IM)))) {

			arguments.add(imageParameters);
			processedOperators.add(new GFOp_BI(new ArrayList<COSBase>()));
			processedOperators.add(new GFOp_ID(arguments));
			processedOperators.add(new GFOp_EI(arguments, resourcesHandler, gs.getFillColorSpace()));
		}
	}

	private static RenderingMode getRenderingMode(List<COSBase> arguments) {
		if (!arguments.isEmpty()) {
			COSBase renderingMode = arguments.get(0);
			if (renderingMode instanceof COSInteger) {
				return RenderingMode.getRenderingMode(renderingMode.getInteger().intValue());
			}
		}
		return RenderingMode.FILL;
	}

	private static COSName getFirstCOSName(List<COSBase> arguments) {
		COSBase lastElement = arguments.isEmpty() ? null : arguments.get(0);
		if (lastElement instanceof COSName) {
			return (COSName) lastElement;
		}
		return null;
	}

	private static COSName getLastCOSName(List<COSBase> arguments) {
		COSBase lastElement = arguments.isEmpty() ? null : arguments.get(arguments.size() - 1);
		if (lastElement instanceof COSName) {
			return (COSName) lastElement;
		}
		return null;
	}

	private static void addFontAndColorSpace(GFOpTextShow op, TransparencyGraphicsState transparencyGraphicsState) {
		GFPDFont font = (GFPDFont) op.getVeraModelFont();
		transparencyGraphicsState.setVeraFont(font);
		byte[] charCodes = op.getCharCodes();
		transparencyGraphicsState.setCharCodes(charCodes);
		GFPDColorSpace fillCS = (GFPDColorSpace) op.getVeraModelFillColorSpace();
		transparencyGraphicsState.setVeraFillColorSpace(fillCS);
		GFPDColorSpace strokeCS = (GFPDColorSpace) op.getVeraModelStrokeColorSpace();
		transparencyGraphicsState.setVeraStrokeColorSpace(strokeCS);
	}

	private static void addColorSpace(GFOpPathPaint op, TransparencyGraphicsState transparencyGraphicsState) {
		GFPDColorSpace fillCS = (GFPDColorSpace) op.getVeraFillCS();
		transparencyGraphicsState.setVeraFillColorSpace(fillCS);
		GFPDColorSpace strokeCS = (GFPDColorSpace) op.getVeraStrokeCS();
		transparencyGraphicsState.setVeraStrokeColorSpace(strokeCS);
	}

	private static void checkAFKey(List<COSBase> arguments, PDResourcesHandler resourcesHandler) {
		int argumentsSize = arguments.size();
		if (argumentsSize > 1) {
			COSBase tag = arguments.get(argumentsSize - 2);
			COSBase propKey = arguments.get(argumentsSize - 1);
			if (isMarkedContentAFKeyAndValueTypeCorrect(tag, propKey)) {
				PDResource properties = resourcesHandler.getProperties(propKey.getName());
				if (properties != null) {
					COSObject cosProperties = properties.getObject();
					if (cosProperties != null && cosProperties.getType() == COSObjType.COS_ARRAY) {
						FileSpecificationKeysHelper.registerFileSpecificationKeys((COSArray) cosProperties.getDirectBase());
					}
				}
			}
		}
	}

	private static boolean isMarkedContentAFKeyAndValueTypeCorrect(COSBase tag, COSBase propKey) {
		if (tag == null || propKey == null) {
			return false;
		} else if (tag.getType() != COSObjType.COS_NAME || propKey.getType() != COSObjType.COS_NAME) {
			return false;
		} else if (ASAtom.AF != tag.getName()) {
			return false;
		}
		return true;
	}

	private GFOpMarkedContent getCurrentMarkedContent() {
		if (this.markedContentStack.empty()) {
			return null;
		}
		return this.markedContentStack.peek();
	}

	private String getParentStructureTag(StructureElementAccessObject structureElementAccessObject, Long mcid) {
		PDStructTreeRoot structTreeRoot = StaticResources.getDocument().getStructTreeRoot();
		if (structTreeRoot != null) {
			PDNumberTreeNode parentTreeRoot = structTreeRoot.getParentTree();
			COSObject structureElement = parentTreeRoot == null ? null : structureElementAccessObject.getStructureElement(parentTreeRoot, mcid);
			if (structureElement != null && !structureElement.empty()) {
				return structureElement.getStringKey(ASAtom.S);
			}
		}
		return null;
	}
}
