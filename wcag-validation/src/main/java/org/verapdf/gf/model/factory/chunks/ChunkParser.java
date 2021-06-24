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
package org.verapdf.gf.model.factory.chunks;

import org.verapdf.as.ASAtom;
import org.verapdf.gf.model.impl.containers.StaticStorages;
import org.verapdf.gf.model.impl.sa.util.ResourceHandler;
import org.verapdf.model.tools.constants.Operators;
import org.verapdf.cos.*;
import org.verapdf.operator.Operator;
import org.verapdf.pd.PDResource;
import org.verapdf.pd.colors.PDColorSpace;
import org.verapdf.pd.colors.PDDeviceCMYK;
import org.verapdf.pd.colors.PDDeviceGray;
import org.verapdf.pd.colors.PDDeviceRGB;
import org.verapdf.pd.images.PDXObject;
import org.verapdf.wcag.algorithms.entities.content.IChunk;
import org.verapdf.wcag.algorithms.entities.content.ImageChunk;
import org.verapdf.wcag.algorithms.entities.content.LineChunk;
import org.verapdf.wcag.algorithms.entities.content.TextChunk;
import org.verapdf.wcag.algorithms.entities.geometry.BoundingBox;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Maxim Plushchov
 */
class ChunkParser {

	private static final Logger LOGGER = Logger.getLogger(ChunkParser.class.getName());

	private final Deque<GraphicsState> graphicsStateStack = new ArrayDeque<>();
	private Stack<Long> markedContentStack = new Stack<>();
	private Integer pageNumber;
	private COSKey pageObjectNumber;
	private Matrix textMatrix = null;
	private Matrix textLineMatrix = null;
	private GraphicsState graphicsState;
	private Path path = new Path();
	private List<IChunk> artifacts = new LinkedList<>();
	private List<IChunk> notStrokeArtifacts = new LinkedList<>();
	private double[] mediabox;

	public ChunkParser(Integer pageNumber, COSKey pageObjectNumber, ResourceHandler resourceHandler, double[] mediabox) {
		this.pageNumber = pageNumber;
		this.pageObjectNumber = pageObjectNumber;
		graphicsState = new GraphicsState(resourceHandler);
		this.mediabox = mediabox;
	}

	public List<IChunk> getArtifacts() {
		return artifacts;
	}

	public void parseChunk(Operator rawOperator, ResourceHandler resourceHandler, List<COSBase> arguments) {
		String operatorName = rawOperator.getOperator();
		switch (operatorName) {
			case Operators.BMC:
				markedContentStack.push(getMCID(arguments, resourceHandler));
				break;
			case Operators.BDC:
				markedContentStack.push(getMCID(arguments, resourceHandler));
				break;
			case Operators.EMC:
				markedContentStack.pop();
				break;
			case Operators.G_FILL: {
				if (this.graphicsState.isProcessColorOperators()) {
					processColorSpace(this.graphicsState, resourceHandler, PDDeviceGray.INSTANCE,
					                  ASAtom.DEVICEGRAY, false);
					if (isProcessColorSpace(this.graphicsState.getFillColorSpace().getType())) {
						Double fillColor = getValueOfLastNumber(arguments);
						if (fillColor != null) {
							this.graphicsState.setFillColor(new double[]{fillColor});
						}
					} else {
						this.graphicsState.setFillColor(new double[0]);
					}
				}
				break;
			}
			case Operators.RG_FILL: {
				if (this.graphicsState.isProcessColorOperators()) {
					processColorSpace(this.graphicsState, resourceHandler, PDDeviceRGB.INSTANCE,
					                  ASAtom.DEVICERGB, false);
					if (isProcessColorSpace(this.graphicsState.getFillColorSpace().getType())) {
						if (arguments.size() == 3 && arguments.get(0).getType().isNumber() &&
						    arguments.get(1).getType().isNumber() && arguments.get(2).getType().isNumber()) {
							this.graphicsState.setFillColor(new double[]{arguments.get(0).getReal(),
							                                             arguments.get(1).getReal(), arguments.get(2).getReal()});
						}
					} else {
						this.graphicsState.setFillColor(new double[0]);
					}
				}
				break;
			}
			case Operators.K_FILL: {
				if (this.graphicsState.isProcessColorOperators()) {
					processColorSpace(this.graphicsState, resourceHandler, PDDeviceCMYK.INSTANCE,
					                  ASAtom.DEVICECMYK, false);
					if (isProcessColorSpace(this.graphicsState.getFillColorSpace().getType())) {
						if (arguments.size() == 4 && arguments.get(0).getType().isNumber() &&
						    arguments.get(1).getType().isNumber() && arguments.get(2).getType().isNumber() &&
						    arguments.get(3).getType().isNumber()) {
							this.graphicsState.setFillColor(new double[]{arguments.get(0).getReal(), arguments.get(1).getReal(),
							                                             arguments.get(2).getReal(), arguments.get(3).getReal()});
						}
					} else {
						this.graphicsState.setFillColor(new double[0]);
					}
				}
				break;
			}
			case Operators.SCN_FILL:
				if (this.graphicsState.isProcessColorOperators()) {
					if (isProcessColorSpace(this.graphicsState.getFillColorSpace().getType())) {
						if (arguments.size() == 1 || arguments.size() == 2) {
							if (arguments.get(0).getType().isNumber()) {
								this.graphicsState.setFillColor(new double[]{arguments.get(0).getReal()});
							}
						} else if (arguments.size() == 3 || (arguments.size() == 4 && !arguments.get(3).getType().isNumber())) {
							if (arguments.get(0).getType().isNumber() && arguments.get(1).getType().isNumber() &&
							    arguments.get(2).getType().isNumber()) {
								this.graphicsState.setFillColor(new double[]{arguments.get(0).getReal(),
								                                             arguments.get(1).getReal(), arguments.get(2).getReal()});
							}
						} else if (arguments.size() == 4 || arguments.size() == 5) {
							if (arguments.get(0).getType().isNumber() && arguments.get(1).getType().isNumber() &&
							    arguments.get(2).getType().isNumber() && arguments.get(3).getType().isNumber()) {
								this.graphicsState.setFillColor(new double[]{arguments.get(0).getReal(),
								                                             arguments.get(1).getReal(), arguments.get(2).getReal(), arguments.get(3).getReal()});
							}
						}
					} else {
						this.graphicsState.setFillColor(new double[0]);
					}
				}
				break;
			case Operators.SC_FILL:
				if (this.graphicsState.isProcessColorOperators()) {
					if (isProcessColorSpace(this.graphicsState.getFillColorSpace().getType())) {
						if (arguments.size() == 1) {
							if (arguments.get(0).getType().isNumber()) {
								this.graphicsState.setFillColor(new double[]{arguments.get(0).getReal()});
							}
						} else if (arguments.size() == 3) {
							if (arguments.get(0).getType().isNumber() && arguments.get(1).getType().isNumber() &&
							    arguments.get(2).getType().isNumber()) {
								this.graphicsState.setFillColor(new double[]{arguments.get(0).getReal(),
								                                             arguments.get(1).getReal(), arguments.get(2).getReal()});
							}
						} else if (arguments.size() == 4) {
							if (arguments.get(0).getType().isNumber() && arguments.get(1).getType().isNumber() &&
							    arguments.get(2).getType().isNumber() && arguments.get(3).getType().isNumber()) {
								this.graphicsState.setFillColor(new double[]{arguments.get(0).getReal(),
								                                             arguments.get(1).getReal(), arguments.get(2).getReal(), arguments.get(3).getReal()});
							}
						}
					} else {
						this.graphicsState.setFillColor(new double[0]);
					}
				}
				break;
			case Operators.CS_FILL:
				if (this.graphicsState.isProcessColorOperators()) {
					this.graphicsState.setFillColorSpace(resourceHandler.getColorSpace(getLastCOSName(arguments)));
				}
				break;
			case Operators.ET:
				textMatrix = null;
				textLineMatrix = null;
				break;
			case Operators.BT:
				textMatrix = new Matrix();
				textLineMatrix = new Matrix();
				break;
			case Operators.TD_MOVE:
				if (arguments.size() > 1 && arguments.get(0).getType().isNumber() &&
						arguments.get(1).getType().isNumber()) {
					processTd(arguments.get(0).getReal(), arguments.get(1).getReal());
				}
				break;
			case Operators.TD_MOVE_SET_LEADING:
				if (arguments.size() > 1 && arguments.get(0).getType().isNumber() &&
						arguments.get(1).getType().isNumber()) {
					processTD(arguments.get(0).getReal(), arguments.get(1).getReal());
				}
				break;
			case Operators.TM:
				textMatrix = new Matrix(arguments);
				textLineMatrix = textMatrix.clone();
				break;
			case Operators.T_STAR:
				processT_STAR();
				break;
			case Operators.TJ_SHOW:
				TextChunk textChunk = createTextChunk(arguments, Operators.TJ_SHOW);
				if (textChunk != null) {
					putChunk(getMarkedContent(), textChunk);
				}
				break;
			case Operators.TJ_SHOW_POS:
				textChunk = createTextChunk(arguments, Operators.TJ_SHOW_POS);
				if (textChunk != null) {
					putChunk(getMarkedContent(), textChunk);
				}
				break;
			case Operators.QUOTE:
				processT_STAR();
				textChunk = createTextChunk(arguments, Operators.QUOTE);
				if (textChunk != null) {
					putChunk(getMarkedContent(), textChunk);
				}
				break;
			case Operators.DOUBLE_QUOTE:
				if (arguments.size() > 1 && arguments.get(0).getType().isNumber() &&
						arguments.get(1).getType().isNumber()) {
					processDoubleQuote(arguments.get(0).getReal(), arguments.get(1).getReal());
				}
				textChunk = createTextChunk(arguments, Operators.DOUBLE_QUOTE);
				if (textChunk != null) {
					putChunk(getMarkedContent(), textChunk);
				}
				break;
			case Operators.TZ:
				Double horizontalScaling = getValueOfLastNumber(arguments);
				if (horizontalScaling != null) {
					this.graphicsState.getTextState().setHorizontalScaling(horizontalScaling / 100);
				}
				break;
			case Operators.TF:
				this.graphicsState.getTextState().setTextFont(resourceHandler.getFont(getFirstCOSName(arguments)));
				if (arguments.size() > 1) {
					COSBase textFontSize = arguments.get(1);
					if (textFontSize.getType().isNumber()) {
						this.graphicsState.getTextState().setTextFontSize(textFontSize.getReal());
					}
				}
				break;
			case Operators.TC:
				Double characterSpacing = getValueOfLastNumber(arguments);
				if (characterSpacing != null) {
					this.graphicsState.getTextState().setCharacterSpacing(characterSpacing);
				}
				break;
			case Operators.TW:
				Double wordSpacing = getValueOfLastNumber(arguments);
				if (wordSpacing != null) {
					this.graphicsState.getTextState().setWordSpacing(wordSpacing);
				}
				break;
			case Operators.TL:
				Double textLeading = getValueOfLastNumber(arguments);
				if (textLeading != null) {
					this.graphicsState.getTextState().setTextLeading(textLeading);
				}
				break;
			case Operators.TS:
				Double textRise = getValueOfLastNumber(arguments);
				if (textRise != null) {
					this.graphicsState.getTextState().setTextRise(textRise);
				}
				break;
			case Operators.BI:
				putChunk(getMarkedContent(), new ImageChunk(new BoundingBox(pageNumber, parseImageBoundingBox())));
				break;
			case Operators.C_CURVE_TO:
				if (arguments.size() == 6 && arguments.get(0).getType().isNumber() &&
						arguments.get(1).getType().isNumber() && arguments.get(2).getType().isNumber() &&
						arguments.get(3).getType().isNumber() && arguments.get(4).getType().isNumber() &&
						arguments.get(5).getType().isNumber()) {
					double x3 = arguments.get(4).getReal();
					double y3 = arguments.get(5).getReal();
					path.setCurrentPoint(x3, y3);
				}
				break;
			case Operators.H_CLOSEPATH:
				processOp_h();
				break;
			case Operators.L_LINE_TO:
				if (arguments.size() == 2 && arguments.get(0).getType().isNumber() &&
						arguments.get(1).getType().isNumber()) {
					double x = arguments.get(0).getReal();
					double y = arguments.get(1).getReal();
					notStrokeArtifacts.add(new LineChunk(pageNumber, path.getCurrentX(), path.getCurrentY(), x, y));
					path.setCurrentPoint(x, y);
				}
				break;
			case Operators.M_MOVE_TO:
				if (arguments.size() == 2 && arguments.get(0).getType().isNumber() &&
						arguments.get(1).getType().isNumber()) {
					double x = arguments.get(0).getReal();
					double y = arguments.get(1).getReal();
					path.setStartPoint(x, y);
					path.setCurrentPoint(x, y);
				}
				break;
			case Operators.RE:
				if (arguments.size() == 4 && arguments.get(0).getType().isNumber() &&
						arguments.get(1).getType().isNumber() && arguments.get(2).getType().isNumber() &&
						arguments.get(3).getType().isNumber()) {
					double x = arguments.get(0).getReal();
					double y = arguments.get(1).getReal();
					path.setCurrentPoint(x, y);
					path.setStartPoint(x, y);
				}
				break;
			case Operators.V:
				if (arguments.size() == 4 && arguments.get(0).getType().isNumber() &&
						arguments.get(1).getType().isNumber() && arguments.get(2).getType().isNumber() &&
						arguments.get(3).getType().isNumber()) {
					path.setCurrentPoint(arguments.get(2).getReal(), arguments.get(3).getReal());
				}
				break;
			case Operators.Y:
				if (arguments.size() == 4 && arguments.get(0).getType().isNumber() &&
						arguments.get(1).getType().isNumber() && arguments.get(2).getType().isNumber() &&
						arguments.get(3).getType().isNumber()) {
					path.setCurrentPoint(arguments.get(2).getReal(), arguments.get(3).getReal());
				}
				break;
			case Operators.B_CLOSEPATH_FILL_STROKE:
				processOp_h();
				processOp_S();
				break;
			case Operators.B_FILL_STROKE:
				processOp_S();
				break;
			case Operators.B_STAR_CLOSEPATH_EOFILL_STROKE:
				processOp_h();
				processOp_S();
				break;
			case Operators.B_STAR_EOFILL_STROKE:
				processOp_S();
				break;
			case Operators.N:
				notStrokeArtifacts = new LinkedList<>();
				break;
			case Operators.S_CLOSE_STROKE:
				processOp_h();
				processOp_S();
				break;
			case Operators.S_STROKE:
				processOp_S();
				break;
			case Operators.CM_CONCAT:
				graphicsState.getCTM().concatenate(new Matrix(arguments));
				break;
			case Operators.Q_GRESTORE:
				if (!graphicsStateStack.isEmpty()) {
					this.graphicsState.copyProperties(this.graphicsStateStack.pop());
				}
				break;
			case Operators.Q_GSAVE:
				this.graphicsStateStack.push(this.graphicsState.clone());
				break;
			case Operators.DO:
				PDXObject xObject = resourceHandler.getXObject(getLastCOSName(arguments));
				if (xObject != null) {
					if (ASAtom.IMAGE.equals(xObject.getType())) {
						putChunk(getMarkedContent(), new ImageChunk(new BoundingBox(pageNumber, parseImageBoundingBox())));
					}
				}
				break;
			case Operators.D1:
				this.graphicsState.disableColorOperators();
				break;

			default:
				break;
		}
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

	private void processT_STAR() {
		processTD(0, -this.graphicsState.getTextState().getTextLeading());
	}

	private void processTD(double op1, double op2) {
		this.graphicsState.getTextState().setTextLeading(-op2);
		processTd(op1, op2);
	}

	private void processTd(double op1, double op2) {
		textLineMatrix.concatenate(Matrix.getTranslateInstance(op1, op2));
		textMatrix = textLineMatrix.clone();
	}

	private void processDoubleQuote(double op1, double op2) {
		this.graphicsState.getTextState().setWordSpacing(op1);
		this.graphicsState.getTextState().setCharacterSpacing(op2);
	}

	private void processOp_h() {
		artifacts.add(new LineChunk(pageNumber, path.getStartX(), path.getStartY(), path.getCurrentX(), path.getCurrentY()));
		path.setCurrentPoint(path.getStartX(), path.getStartY());
	}

	private void processOp_S() {
		for (IChunk chunk : notStrokeArtifacts) {
			if (chunk instanceof LineChunk) {
				artifacts.add(transformLineChunk((LineChunk)chunk, graphicsState.getCTM()));
			}
		}
		notStrokeArtifacts = new LinkedList<>();
	}

	private Double getValueOfLastNumber(List<COSBase> arguments) {
		if (!arguments.isEmpty()) {
			COSBase base = arguments.get(arguments.size() - 1);
			if (base.getType().isNumber()) {
				return base.getReal();
			}
		}
		return null;
	}

	private double[] parseImageBoundingBox() {
		double x1 = graphicsState.getCTM().getTranslateX() - mediabox[0];
		double y1 = graphicsState.getCTM().getTranslateY() - mediabox[1];
		double x2 = x1;
		double y2 = y1;
		if (graphicsState.getCTM().getScaleX() >= 0 && graphicsState.getCTM().getShearX() >= 0) {
			x2 += graphicsState.getCTM().getScaleX() + graphicsState.getCTM().getShearX();
		} else if (graphicsState.getCTM().getScaleX() < 0 && graphicsState.getCTM().getShearX() < 0) {
			x1 += graphicsState.getCTM().getScaleX() + graphicsState.getCTM().getShearX();
		} else if (graphicsState.getCTM().getScaleX() >= 0) {
			x1 += graphicsState.getCTM().getShearX();
			x2 += graphicsState.getCTM().getScaleX();
		} else {
			x1 += graphicsState.getCTM().getScaleX();
			x2 += graphicsState.getCTM().getShearX();
		}
		if (graphicsState.getCTM().getScaleY() >= 0 && graphicsState.getCTM().getShearY() >= 0) {
			y2 += graphicsState.getCTM().getScaleY() + graphicsState.getCTM().getShearY();
		} else if (graphicsState.getCTM().getScaleY() < 0 && graphicsState.getCTM().getShearY() < 0) {
			y1 += graphicsState.getCTM().getScaleY() + graphicsState.getCTM().getShearY();
		} else if (graphicsState.getCTM().getScaleY() >= 0) {
			y1 += graphicsState.getCTM().getShearY();
			y2 += graphicsState.getCTM().getScaleY();
		} else {
			y1 += graphicsState.getCTM().getScaleY();
			y2 += graphicsState.getCTM().getShearY();
		}
		return new double[]{x1, y1, x2, y2};
	}

	private void putChunk(Long mcid, IChunk chunk) {
		if (chunk == null) {
			return;
		}
		if (mcid != null) {
			StaticStorages.getChunks().add(pageObjectNumber, mcid, chunk);
		} else {
			artifacts.add(chunk);
		}
	}

	private COSBase getArgument(List<COSBase> arguments, String operatorType) {
		if (Operators.DOUBLE_QUOTE.equals(operatorType)) {
			if (arguments.size() > 2) {
				return arguments.get(2);
			}
		} else if (!arguments.isEmpty()) {
			return arguments.get(0);
		}
		return null;
	}

	private void parseTextShowArgument(COSBase argument, StringBuilder unicodeValue) {
		if (argument.getType() == COSObjType.COS_STRING) {
			parseString((COSString) argument.getDirectBase(), unicodeValue);
		} else if (argument.getType() == COSObjType.COS_ARRAY) {
			COSArray array = (COSArray) argument;
			for (COSObject obj : array) {
				if (obj != null) {
					if (obj.getType() == COSObjType.COS_STRING) {
						parseString((COSString) obj.getDirectBase(), unicodeValue);
					} else if (obj.getType().isNumber()) {
						textMatrix.concatenate(Matrix.getTranslateInstance(- obj.getReal() / 1000 *
						    graphicsState.getTextState().getTextFontSize() *
						    graphicsState.getTextState().getHorizontalScaling(), 0));
					}
				}
			}
		}
	}

	private void parseString(COSString string, StringBuilder unicodeValue) {
		byte[] bytes = string.get();
		try (InputStream inputStream = new ByteArrayInputStream(bytes)) {
			while (inputStream.available() > 0) {
				int code = graphicsState.getTextState().getTextFont().readCode(inputStream);
				unicodeValue.append(graphicsState.getTextState().getTextFont().toUnicode(code));
				Double width = graphicsState.getTextState().getTextFont().getWidth(code);
				if (width == null) {
					LOGGER.log(Level.SEVERE, "Missing width of glyph with code " + code +
							" in font" + graphicsState.getTextState().getTextFont().getName());
					width = 0.0;
				}
				textMatrix.concatenate(Matrix.getTranslateInstance((width *
					graphicsState.getTextState().getTextFontSize() / 1000 +
					graphicsState.getTextState().getCharacterSpacing() + (code == 32 ?
					graphicsState.getTextState().getWordSpacing() : 0)) *
					graphicsState.getTextState().getHorizontalScaling(), 0));
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Error processing text show operator's string argument : " + new String(bytes), e);
		}
	}

	private TextChunk createTextChunk(List<COSBase> arguments, String operatorType) {
		org.verapdf.pd.font.PDFont font = graphicsState.getTextState().getTextFont();
		COSBase argument = getArgument(arguments, operatorType);
		if (font != null && argument != null && (argument.getType() == COSObjType.COS_STRING ||
		        argument.getType() == COSObjType.COS_ARRAY)) {
			StringBuilder unicodeValue = new StringBuilder();
			Matrix parameters = new Matrix(graphicsState.getTextState().getTextFontSize() *
			                               graphicsState.getTextState().getHorizontalScaling(), 0, 0,
			                               graphicsState.getTextState().getTextFontSize(), 0,
			                               graphicsState.getTextState().getTextRise());
			Matrix textRenderingMatrixBefore = parameters.multiply(textMatrix).multiply(graphicsState.getCTM());
			parseTextShowArgument(argument, unicodeValue);
			Matrix textRenderingMatrixAfter = parameters.multiply(textMatrix).multiply(graphicsState.getCTM());
			return new TextChunk(new BoundingBox(pageNumber, calculateTextBoundingBox(textRenderingMatrixBefore,
			    textRenderingMatrixAfter, font.getBoundingBox())), unicodeValue.toString(), font.getNameWithoutSubset(),
			    textRenderingMatrixAfter.getScaleY(), font.getFontWeight(), font.getFontDescriptor().getItalicAngle(),
			    textRenderingMatrixAfter.getTranslateY() - mediabox[1], graphicsState.getFillColor());
		}
		return null;
	}

	private double[] calculateTextBoundingBox(Matrix textRenderingMatrixBefore, Matrix textRenderingMatrixAfter, double[] fontBoundingBox) {
		double x1, y1, x2, y2;
		if (textRenderingMatrixBefore.getScaleX() >= 0 && textRenderingMatrixBefore.getShearX() >= 0) {
			x1 = textRenderingMatrixBefore.getTranslateX() + fontBoundingBox[1] * textRenderingMatrixBefore.getShearX() / 1000;
			x2 = textRenderingMatrixAfter.getTranslateX() + fontBoundingBox[3] * textRenderingMatrixAfter.getShearX() / 1000;
		} else if (textRenderingMatrixBefore.getScaleX() < 0 && textRenderingMatrixBefore.getShearX() < 0) {
			x1 = textRenderingMatrixAfter.getTranslateX() + fontBoundingBox[3] * textRenderingMatrixAfter.getShearX() / 1000;
			x2 = textRenderingMatrixBefore.getTranslateX() + fontBoundingBox[1] * textRenderingMatrixBefore.getShearX() / 1000;
		} else if (textRenderingMatrixBefore.getScaleX() >= 0) {
			x1 = textRenderingMatrixBefore.getTranslateX() + fontBoundingBox[3] * textRenderingMatrixBefore.getShearX() / 1000;
			x2 = textRenderingMatrixAfter.getTranslateX() + fontBoundingBox[1] * textRenderingMatrixAfter.getShearX() / 1000;
		} else {
			x1 = textRenderingMatrixAfter.getTranslateX() + fontBoundingBox[1] * textRenderingMatrixAfter.getShearX() / 1000;
			x2 = textRenderingMatrixBefore.getTranslateX() + fontBoundingBox[3] * textRenderingMatrixBefore.getShearX() / 1000;
		}
		if (textRenderingMatrixBefore.getScaleY() >= 0 && textRenderingMatrixBefore.getShearY() >= 0) {
			y1 = textRenderingMatrixBefore.getTranslateY() + fontBoundingBox[1] * textRenderingMatrixBefore.getScaleY() / 1000;
			y2 = textRenderingMatrixAfter.getTranslateY() + fontBoundingBox[3] * textRenderingMatrixAfter.getScaleY() / 1000;
		} else if (textRenderingMatrixBefore.getScaleY() < 0 && textRenderingMatrixBefore.getShearY() < 0) {
			y1 = textRenderingMatrixAfter.getTranslateY() + fontBoundingBox[3] * textRenderingMatrixAfter.getScaleY() / 1000;
			y2 = textRenderingMatrixBefore.getTranslateY() + fontBoundingBox[1] * textRenderingMatrixBefore.getScaleY() / 1000;
		} else if (textRenderingMatrixBefore.getScaleY() >= 0) {
			y1 = textRenderingMatrixAfter.getTranslateY() + fontBoundingBox[1] * textRenderingMatrixAfter.getScaleY() / 1000;
			y2 = textRenderingMatrixBefore.getTranslateY() + fontBoundingBox[3] * textRenderingMatrixBefore.getScaleY() / 1000;
		} else {
			y1 = textRenderingMatrixBefore.getTranslateY() + fontBoundingBox[3] * textRenderingMatrixBefore.getScaleY() / 1000;
			y2 = textRenderingMatrixAfter.getTranslateY() + fontBoundingBox[1] * textRenderingMatrixAfter.getScaleY() / 1000;
		}
		return new double[]{x1 - mediabox[0], y1 - mediabox[1], x2 - mediabox[0], y2 - mediabox[1]};
	}

	private Long getMarkedContent() {
		if (!markedContentStack.empty()) {
			for (int i = markedContentStack.size() - 1; i >= 0; i--) {
				Long mcid = markedContentStack.get(i);
				if (mcid != null) {
					return mcid;
				}
			}
		}
		return null;
	}

	private Long getMCID(List<COSBase> arguments, ResourceHandler resources) {
		if (!arguments.isEmpty()) {
			COSBase lastArg = arguments.get(arguments.size() - 1);
			if (lastArg.getType() == COSObjType.COS_DICT) {
				return lastArg.getIntegerKey(ASAtom.MCID);
			} else if (lastArg.getType() == COSObjType.COS_NAME && resources != null) {
				PDResource properties = resources.getProperties(lastArg.getName());
				if (properties != null) {
					COSBase cosProperties = properties.getObject().getDirectBase();
					if (cosProperties != null && cosProperties.getType() == COSObjType.COS_DICT) {
						return cosProperties.getIntegerKey(ASAtom.MCID);
					}
				}
			}
		}
		return null;
	}

	private LineChunk transformLineChunk(LineChunk lineChunk, Matrix currentTransformationMatrix) {
		return new LineChunk(pageNumber, lineChunk.getStartX() * currentTransformationMatrix.getScaleX() + lineChunk.getStartY() * currentTransformationMatrix.getShearY() + currentTransformationMatrix.getTranslateX(),
				lineChunk.getStartX() * currentTransformationMatrix.getShearX() + lineChunk.getStartY() * currentTransformationMatrix.getScaleY() + currentTransformationMatrix.getTranslateY(),
				lineChunk.getEndX() * currentTransformationMatrix.getScaleX() + lineChunk.getEndY() * currentTransformationMatrix.getShearY() + currentTransformationMatrix.getTranslateX(),
				lineChunk.getEndX() * currentTransformationMatrix.getShearX() + lineChunk.getEndY() * currentTransformationMatrix.getScaleY() + currentTransformationMatrix.getTranslateY());
	}

	private static void processColorSpace(GraphicsState graphicState, ResourceHandler resourcesHandler,
	                                      PDColorSpace defaultCS, ASAtom name, boolean stroke) {
		PDColorSpace colorSpace = resourcesHandler.getColorSpace(name);
		if (colorSpace == null) {
			colorSpace = defaultCS;
		}
		if (!stroke) {
			graphicState.setFillColorSpace(colorSpace);
		}
	}

	private boolean isProcessColorSpace(ASAtom colorSpaceType) {
		return ASAtom.DEVICERGB.equals(colorSpaceType) || ASAtom.DEVICEGRAY.equals(colorSpaceType) ||
		       ASAtom.DEVICECMYK.equals(colorSpaceType) || ASAtom.ICCBASED.equals(colorSpaceType) ||
		       ASAtom.CALRGB.equals(colorSpaceType) || ASAtom.CALGRAY.equals(colorSpaceType);
	}

}
