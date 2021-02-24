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
import org.verapdf.pd.font.type3.PDType3Font;
import org.verapdf.wcag.algorithms.entities.content.IChunk;
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
	private Matrix textMatrix = null;
	private Matrix textLineMatrix = null;
	private GraphicsState graphicsState;
	private List<IChunk> artifacts = new LinkedList<>();

	public ChunkParser(Integer pageNumber) {
		this.pageNumber = pageNumber;
		graphicsState = new GraphicsState();
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
				Double fillColor = getValueOfLastNumber(arguments);
				if (fillColor != null) {
					this.graphicsState.setFillColor(new double[]{fillColor});
				}
				break;
			}
			case Operators.RG_FILL: {
				if (arguments.size() == 3 && arguments.get(0).getType().isNumber() &&
						arguments.get(1).getType().isNumber() && arguments.get(2).getType().isNumber()) {
					this.graphicsState.setFillColor(new double[]{arguments.get(0).getReal(),
						arguments.get(1).getReal(), arguments.get(2).getReal()});
				}
				break;
			}
			case Operators.K_FILL: {
				if (arguments.size() == 4 && arguments.get(0).getType().isNumber() &&
				    arguments.get(1).getType().isNumber() && arguments.get(2).getType().isNumber() &&
				    arguments.get(3).getType().isNumber()) {
					this.graphicsState.setFillColor(new double[]{arguments.get(0).getReal(), arguments.get(1).getReal(),
						arguments.get(2).getReal(), arguments.get(3).getReal()});
				}
				break;
			}
			case Operators.SCN_FILL:
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
				break;
			case Operators.SC_FILL:
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

	public Double getValueOfLastNumber(List<COSBase> arguments) {
		if (!arguments.isEmpty()) {
			COSBase base = arguments.get(arguments.size() - 1);
			if (base.getType().isNumber()) {
				return base.getReal();
			}
		}
		return null;
	}

	private void putChunk(Long mcid, IChunk chunk) {
		if (chunk == null) {
			return;
		}
		if (mcid != null) {
			if (StaticStorages.getChunks().containsKey(mcid)) {
				StaticStorages.getChunks().get(mcid).add(chunk);
			} else {
				List<IChunk> list = new ArrayList<>();
				list.add(chunk);
				StaticStorages.getChunks().put(mcid, list);
			}
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

	private Matrix calculateTextRenderingMatrix(COSBase argument, StringBuilder unicodeValue) {
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
		Matrix parameters = new Matrix(graphicsState.getTextState().getTextFontSize() *
		    graphicsState.getTextState().getHorizontalScaling(), 0, 0,
		    graphicsState.getTextState().getTextFontSize(), 0, graphicsState.getTextState().getTextRise());
		return parameters.multiply(textMatrix).multiply(graphicsState.getCTM());
	}

	private void parseString(COSString string, StringBuilder unicodeValue) {
		byte[] bytes = string.get();
		try (InputStream inputStream = new ByteArrayInputStream(bytes)) {
			while (inputStream.available() > 0) {
				int code = graphicsState.getTextState().getTextFont().readCode(inputStream);
				unicodeValue.append(graphicsState.getTextState().getTextFont().toUnicode(code));
				Double width = graphicsState.getTextState().getTextFont().getWidth(code);
				if (width == null) {
					LOGGER.log(Level.SEVERE, "Missing width of glyph with code" + code +
							"in font" + graphicsState.getTextState().getTextFont().getName());
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
			Matrix textRenderingMatrix = calculateTextRenderingMatrix(argument, unicodeValue);
			return new TextChunk(new BoundingBox(pageNumber, new double[]{textRenderingMatrix.getTranslateX(),
				textRenderingMatrix.getTranslateY() + font.getBoundingBox()[1] * textRenderingMatrix.getScaleY() / 1000,
				textRenderingMatrix.getTranslateX(), textRenderingMatrix.getTranslateY() + font.getBoundingBox()[3] *
				textRenderingMatrix.getScaleY() / 1000}), unicodeValue.toString(), font.getNameWithoutSubset(),
				textRenderingMatrix.getScaleY() * graphicsState.getTextState().getTextFontSize(), font.getFontWeight(),
				font.getFontDescriptor().getItalicAngle(), textRenderingMatrix.getTranslateY(), graphicsState.getFillColor());
		}
		return null;
	}

	private Long getMarkedContent() {
		if (!markedContentStack.empty()) {
			return markedContentStack.peek();
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

}
