/**
 *
 */
package org.verapdf.model.factory.operators;

import org.apache.log4j.Logger;
import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSInteger;
import org.verapdf.cos.COSName;
import org.verapdf.model.impl.operator.color.GFOpColor;
import org.verapdf.model.impl.operator.generalgs.*;
import org.verapdf.model.impl.operator.inlineimage.GFOp_BI;
import org.verapdf.model.impl.operator.inlineimage.GFOp_EI;
import org.verapdf.model.impl.operator.inlineimage.GFOp_ID;
import org.verapdf.model.impl.operator.markedcontent.*;
import org.verapdf.model.impl.operator.opclip.GFOp_WStar;
import org.verapdf.model.impl.operator.opclip.GFOp_W_clip;
import org.verapdf.model.impl.operator.opcompability.GFOp_BX;
import org.verapdf.model.impl.operator.opcompability.GFOp_EX;
import org.verapdf.model.impl.operator.opcompability.GFOp_Undefined;
import org.verapdf.model.impl.operator.pathconstruction.*;
import org.verapdf.model.impl.operator.pathpaint.*;
import org.verapdf.model.impl.operator.shading.GFOp_sh;
import org.verapdf.model.impl.operator.specialgs.GFOp_Q_grestore;
import org.verapdf.model.impl.operator.specialgs.GFOp_cm;
import org.verapdf.model.impl.operator.specialgs.GFOp_q_gsave;
import org.verapdf.model.impl.operator.textobject.GFOpTextObject;
import org.verapdf.model.impl.operator.textposition.GFOpTextPosition;
import org.verapdf.model.impl.operator.textposition.GFOp_TD_Big;
import org.verapdf.model.impl.operator.textposition.GFOp_Td;
import org.verapdf.model.impl.operator.textposition.GFOp_Tm;
import org.verapdf.model.impl.operator.textshow.*;
import org.verapdf.model.impl.operator.textstate.*;
import org.verapdf.model.impl.operator.type3font.GFOp_d0;
import org.verapdf.model.impl.operator.type3font.GFOp_d1;
import org.verapdf.model.impl.operator.xobject.GFOp_Do;
import org.verapdf.model.impl.pd.colors.GFPDColorSpace;
import org.verapdf.model.impl.pd.font.GFPDFont;
import org.verapdf.model.impl.pd.images.GFPDXObject;
import org.verapdf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.tools.constants.Operators;
import org.verapdf.operator.InlineImageOperator;
import org.verapdf.operator.Operator;
import org.verapdf.pd.PDExtGState;
import org.verapdf.pd.colors.PDColorSpace;
import org.verapdf.pd.colors.PDDeviceCMYK;
import org.verapdf.pd.colors.PDDeviceGray;
import org.verapdf.pd.colors.PDDeviceRGB;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Timur Kamalov
 */
class OperatorParser {

	private static final Logger LOGGER = Logger.getLogger(OperatorParser.class);
	private static final String MSG_PROBLEM_OBTAINING_RESOURCE = "Problem encountered while obtaining resources for ";

	private final Deque<GraphicState> graphicStateStack = new ArrayDeque<>();
	private GraphicState graphicState = new GraphicState();

	private final Deque<TransparencyGraphicsState> transparencyGraphicStateStack = new ArrayDeque<>();
	private TransparencyGraphicsState transparencyGraphicState = new TransparencyGraphicsState();

	OperatorParser() {
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
					   PDResourcesHandler resourcesHandler, List<COSBase> arguments) throws IOException {
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
				processedOperators.add(new GFOp_ri(arguments));
				break;
			case Operators.W_LINE_WIDTH:
				processedOperators.add(new GFOp_w_line_width(arguments));
				break;

			// MARKED CONTENT
			case Operators.BMC:
				processedOperators.add(new GFOp_BMC(arguments));
				break;
			case Operators.BDC:
				processedOperators.add(new GFOp_BDC(arguments));
				break;
			case Operators.EMC:
				processedOperators.add(new GFOp_EMC(arguments));
				break;
			case Operators.MP:
				processedOperators.add(new GFOp_MP(arguments));
				break;
			case Operators.DP:
				processedOperators.add(new GFOp_DP(arguments));
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
				processColorSpace(this.graphicState, resourcesHandler, PDDeviceGray.INSTANCE,
						ASAtom.DEVICEGRAY, true);
				processedOperators.add(new GFOpColor(arguments));
				break;
			}
			case Operators.G_FILL: {
				processColorSpace(this.graphicState, resourcesHandler, PDDeviceGray.INSTANCE,
						ASAtom.DEVICEGRAY, false);
				processedOperators.add(new GFOpColor(arguments));
				break;
			}
			case Operators.RG_STROKE: {
				processColorSpace(this.graphicState, resourcesHandler, PDDeviceRGB.INSTANCE,
						ASAtom.DEVICERGB, true);
				processedOperators.add(new GFOpColor(arguments));
				break;
			}
			case Operators.RG_FILL: {
				processColorSpace(this.graphicState, resourcesHandler, PDDeviceRGB.INSTANCE,
						ASAtom.DEVICERGB, false);
				processedOperators.add(new GFOpColor(arguments));
				break;
			}
			case Operators.K_STROKE: {
				processColorSpace(this.graphicState, resourcesHandler, PDDeviceCMYK.INSTANCE,
						ASAtom.DEVICECMYK, true);
				processedOperators.add(new GFOpColor(arguments));
				break;
			}
			case Operators.K_FILL: {
				processColorSpace(this.graphicState, resourcesHandler, PDDeviceCMYK.INSTANCE,
						ASAtom.DEVICECMYK, true);
				processedOperators.add(new GFOpColor(arguments));
				break;
			}
			case Operators.CS_STROKE:
				this.graphicState.setStrokeColorSpace(resourcesHandler.getColorSpace(getLastCOSName(arguments)));
				processedOperators.add(new GFOpColor(arguments));
				break;
			case Operators.CS_FILL:
				this.graphicState.setFillColorSpace(resourcesHandler.getColorSpace(getLastCOSName(arguments)));
				processedOperators.add(new GFOpColor(arguments));
				break;
			case Operators.SCN_STROKE:
				processPatternColorSpace(arguments, this.graphicState, resourcesHandler,
										this.graphicState.getStrokeColorSpace(), true);
				processedOperators.add(new GFOpColor(arguments));
				break;
			case Operators.SCN_FILL:
				processPatternColorSpace(arguments, this.graphicState, resourcesHandler,
						this.graphicState.getFillColorSpace(), false);
				processedOperators.add(new GFOpColor(arguments));
				break;
			case Operators.SC_STROKE:
				processedOperators.add(new GFOpColor(arguments));
				break;
			case Operators.SC_FILL:
				processedOperators.add(new GFOpColor(arguments));
				break;

			// TEXT OBJECT
			case Operators.ET:
			case Operators.BT:
				processedOperators.add(new GFOpTextObject(arguments));
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
				processedOperators.add(new GFOpTextPosition(arguments));
				break;

			// TEXT SHOW
			case Operators.TJ_SHOW:
				GFOp_Tj tj = new GFOp_Tj(arguments, this.graphicState.clone(), resourcesHandler);
				addFontAndColorSpace(tj, this.transparencyGraphicState);
				processedOperators.add(tj);
				break;
			case Operators.TJ_SHOW_POS:
				GFOp_TJ_Big tjBig = new GFOp_TJ_Big(arguments, this.graphicState.clone(), resourcesHandler);
				addFontAndColorSpace(tjBig, this.transparencyGraphicState);
				processedOperators.add(tjBig);
				break;
			case Operators.QUOTE:
				GFOp_Quote quote = new GFOp_Quote(arguments, this.graphicState.clone(), resourcesHandler);
				addFontAndColorSpace(quote, this.transparencyGraphicState);
				processedOperators.add(quote);
				break;
			case Operators.DOUBLE_QUOTE:
				GFOp_DoubleQuote doubleQuote = new GFOp_DoubleQuote(arguments, this.graphicState.clone(), resourcesHandler);
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
				this.graphicState.setFontName(getFirstCOSName(arguments));
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
				break;

			// INLINE IMAGE
			case Operators.BI:
				processInlineImage(processedOperators, (InlineImageOperator) rawOperator, arguments);
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

			// SHADING
			case Operators.SH:
				processedOperators.add(new GFOp_sh(arguments, resourcesHandler.getShading(getLastCOSName(arguments))));
				break;

			// SPECIAL GS
			case Operators.CM_CONCAT:
				processedOperators.add(new GFOp_cm(arguments));
				break;
			case Operators.Q_GRESTORE:
				if (!graphicStateStack.isEmpty()) {
					this.graphicState.copyProperties(this.graphicStateStack.pop());
				}
				if (!transparencyGraphicStateStack.isEmpty()) {
					this.transparencyGraphicState.copyProperties(this.transparencyGraphicStateStack.pop());
				}
				processedOperators.add(new GFOp_Q_grestore(arguments));
				break;
			case Operators.Q_GSAVE:
				this.graphicStateStack.push(this.graphicState.clone());
				this.transparencyGraphicStateStack.push(this.transparencyGraphicState.clone());
				processedOperators.add(new GFOp_q_gsave(arguments, this.graphicStateStack.size()));
				break;

			// XOBJECT
			case Operators.DO:
				GFOp_Do op_do = new GFOp_Do(arguments, resourcesHandler.getXObject(getLastCOSName(arguments)),
						resourcesHandler);
				List<org.verapdf.model.pdlayer.PDXObject> pdxObjects = op_do.getXObject();
				if (!pdxObjects.isEmpty()) {
					GFPDXObject xobj = (GFPDXObject) pdxObjects.get(0);
					this.transparencyGraphicState.setVeraXObject(xobj);
				}
				processedOperators.add(op_do);
				break;

			default:
				processedOperators.add(new GFOp_Undefined(arguments));
				break;
		}
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
		PDColorSpace colorSpace = resourcesHandler == null ?  defaultCS : resourcesHandler.getColorSpace(name);
		if (stroke) {
			graphicState.setStrokeColorSpace(colorSpace);
		} else {
			graphicState.setFillColorSpace(colorSpace);
		}
	}

	private static void processPatternColorSpace(List<COSBase> arguments, GraphicState graphicState,
												 PDResourcesHandler resourcesHandler, PDColorSpace colorSpace, boolean stroke) {
		if (colorSpace != null && ASAtom.PATTERN == colorSpace.getType()) {
			if (stroke) {
				graphicState.setStrokeColorSpace(resourcesHandler.getPattern(getLastCOSName(arguments)));
			} else {
				graphicState.setFillColorSpace(resourcesHandler.getPattern(getLastCOSName(arguments)));
			}
		}
	}

	private static void processInlineImage(List<org.verapdf.model.operator.Operator> processedOperators,
										   InlineImageOperator rawOperator, List<COSBase> arguments) {
		if (rawOperator.getImageParameters() != null) {
			arguments.add(rawOperator.getImageParameters());
			processedOperators.add(new GFOp_BI(new ArrayList<COSBase>()));
			processedOperators.add(new GFOp_ID(arguments));
			processedOperators.add(new GFOp_EI(arguments));
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
}
