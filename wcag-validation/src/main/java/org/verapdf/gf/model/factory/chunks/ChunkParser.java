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
package org.verapdf.gf.model.factory.chunks;

import org.verapdf.as.ASAtom;
import org.verapdf.gf.model.impl.containers.StaticStorages;
import org.verapdf.gf.model.impl.sa.GFSAXForm;
import org.verapdf.gf.model.impl.sa.util.ResourceHandler;
import org.verapdf.model.tools.constants.Operators;
import org.verapdf.cos.*;
import org.verapdf.operator.Operator;
import org.verapdf.pd.PDExtGState;
import org.verapdf.pd.PDResource;
import org.verapdf.pd.colors.PDColorSpace;
import org.verapdf.pd.colors.PDDeviceCMYK;
import org.verapdf.pd.colors.PDDeviceGray;
import org.verapdf.pd.colors.PDDeviceRGB;
import org.verapdf.pd.images.PDXForm;
import org.verapdf.pd.images.PDXObject;
import org.verapdf.wcag.algorithms.entities.content.*;
import org.verapdf.wcag.algorithms.entities.geometry.BoundingBox;
import org.verapdf.wcag.algorithms.entities.geometry.MultiBoundingBox;
import org.verapdf.wcag.algorithms.entities.geometry.Vertex;
import org.verapdf.wcag.algorithms.semanticalgorithms.utils.NodeUtils;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author Maxim Plushchov
 */
class ChunkParser {

	private static final Logger LOGGER = Logger.getLogger(ChunkParser.class.getName());

	private final Deque<GraphicsState> graphicsStateStack = new ArrayDeque<>();
	private final Stack<Long> markedContentStack = new Stack<>();

	private final Set<Long> processedMCIDs = new HashSet<>();

	private final Integer pageNumber;
	private final COSKey objectKey;
	private Matrix textMatrix = null;
	private Matrix textLineMatrix = null;
	private final ResourceHandler resourceHandler;
	private final GraphicsState graphicsState;
	private final Path path = new Path();
	private final List<IChunk> artifacts = new LinkedList<>();
	private List<Object> nonDrawingArtifacts = new LinkedList<>();
	private final LineArtContainer lineArtContainer;
	private final COSKey parentObjectKey;
	private final Long parentMarkedContent;

	public ChunkParser(Integer pageNumber, COSKey objectKey, GraphicsState inheritedGraphicState,
					   ResourceHandler resourceHandler, COSKey parentObjectKey, Long markedContent) {
		this.pageNumber = pageNumber;
		lineArtContainer = new LineArtContainer(objectKey);
		this.objectKey = objectKey;
		this.graphicsState = inheritedGraphicState.clone();
		this.resourceHandler = resourceHandler;
		this.parentObjectKey = parentObjectKey;
		this.parentMarkedContent = markedContent;
	}

	public List<IChunk> getArtifacts() {
		return artifacts;
	}

	public void parseChunk(Operator rawOperator, List<COSBase> arguments) {
		String operatorName = rawOperator.getOperator();
		switch (operatorName) {
			case Operators.BMC:
			case Operators.BDC:
				Long mcid = getMCID(arguments, resourceHandler);
				if (mcid != null) {
					if (processedMCIDs.contains(mcid)) {
						mcid = null;
					} else {
						processedMCIDs.add(mcid);
					}
				}
				markedContentStack.push(mcid);
				break;
			case Operators.EMC:
				markedContentStack.pop();
				break;
			case Operators.G_FILL: {
				if (this.graphicsState.isProcessColorOperators()) {
					processColorSpace(this.graphicsState, resourceHandler, PDDeviceGray.INSTANCE,
					                  ASAtom.DEVICEGRAY, false);
					if (isProcessColorSpace(this.graphicsState.getFillColorSpace())) {
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
					if (isProcessColorSpace(this.graphicsState.getFillColorSpace())) {
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
					if (isProcessColorSpace(this.graphicsState.getFillColorSpace())) {
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
					PDColorSpace colorSpace = this.graphicsState.getFillColorSpace();
					if (isProcessColorSpace(colorSpace)) {
						try {
							int size = arguments.size();
							if (!arguments.get(size - 1).getType().isNumber()) {
								size--;
							}
							double[] colorArguments = new double[size];
							boolean areNumbers = true;
							for (int i = 0; i < size; ++i) {
								if (!arguments.get(i).getType().isNumber()) {
									areNumbers = false;
									break;
								}
								colorArguments[i] = arguments.get(i).getReal();
							}
							if (areNumbers) {
								this.graphicsState.setFillColor(colorSpace.toRGB(colorArguments));
							}
						} catch (Exception e) {
							LOGGER.log(Level.WARNING, "Error setting fill color with scn operator", e);
						}
					} else {
						this.graphicsState.setFillColor(new double[0]);
					}
				}
				break;
			case Operators.SC_FILL:
				if (this.graphicsState.isProcessColorOperators()) {
					PDColorSpace colorSpace = this.graphicsState.getFillColorSpace();
					ASAtom colorSpaceType = colorSpace.getType();
					if (ASAtom.DEVICERGB.equals(colorSpaceType) || ASAtom.DEVICEGRAY.equals(colorSpaceType) ||
							ASAtom.DEVICECMYK.equals(colorSpaceType) || ASAtom.CALRGB.equals(colorSpaceType) ||
							ASAtom.CALGRAY.equals(colorSpaceType) || ASAtom.INDEXED.equals(colorSpaceType) ||
							ASAtom.LAB.equals(colorSpaceType) || ASAtom.ICCBASED.equals(colorSpaceType)) {
						try {
							double[] colorArguments = new double[arguments.size()];
							boolean areNumbers = true;
							for (int i = 0; i < arguments.size(); ++i) {
								if (!arguments.get(i).getType().isNumber()) {
									areNumbers = false;
									break;
								}
								colorArguments[i] = arguments.get(i).getReal();
							}
							if (areNumbers) {
								this.graphicsState.setFillColor(colorSpace.toRGB(colorArguments));
							}
						} catch (Exception e) {
							LOGGER.log(Level.WARNING, "Error setting fill color with sc operator", e);
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
            case Operators.TR:
                if (arguments.size() == 1 && arguments.get(0).getType().isNumber()) {
                    int renderingMode = arguments.get(0).getInteger().intValue();
                    if (renderingMode >= 0 && renderingMode <= 7) {
                        graphicsState.getTextState().setRenderingMode(renderingMode);
                    }
                }
                break;
			case Operators.T_STAR:
				processT_STAR();
				break;
			case Operators.TJ_SHOW: {
				TextChunk textChunk = createTextChunk(arguments, Operators.TJ_SHOW);
				if (textChunk != null) {
					putChunk(getMarkedContent(), textChunk);
				}
				break;
			}
			case Operators.TJ_SHOW_POS: {
				TextChunk textChunk = createTextChunk(arguments, Operators.TJ_SHOW_POS);
				if (textChunk != null) {
					putChunk(getMarkedContent(), textChunk);
				}
				break;
			}
			case Operators.QUOTE: {
				processT_STAR();
				TextChunk textChunk = createTextChunk(arguments, Operators.QUOTE);
				if (textChunk != null) {
					putChunk(getMarkedContent(), textChunk);
				}
				break;
			}
			case Operators.DOUBLE_QUOTE:
				if (arguments.size() > 1 && arguments.get(0).getType().isNumber() &&
						arguments.get(1).getType().isNumber()) {
					processDoubleQuote(arguments.get(0).getReal(), arguments.get(1).getReal());
				}
				TextChunk textChunk = createTextChunk(arguments, Operators.DOUBLE_QUOTE);
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
				putChunk(getMarkedContent(), new ImageChunk(parseImageBoundingBox()));
				break;
			case Operators.C_CURVE_TO:
				if (arguments.size() == 6 && arguments.get(0).getType().isNumber() &&
						arguments.get(1).getType().isNumber() && arguments.get(2).getType().isNumber() &&
						arguments.get(3).getType().isNumber() && arguments.get(4).getType().isNumber() &&
						arguments.get(5).getType().isNumber()) {
					CurveChunk curve = new CurveChunk(pageNumber, new Vertex(path.getCurrentX(), path.getCurrentY()),
							new Vertex(arguments.get(0).getReal(), arguments.get(1).getReal()),
							new Vertex(arguments.get(2).getReal(), arguments.get(3).getReal()),
							new Vertex(arguments.get(4).getReal(), arguments.get(5).getReal()),
							graphicsState.getLineWidth());
					path.setCurrentPoint(curve.getX3(), curve.getY3());
					nonDrawingArtifacts.add(curve);
				}
				break;
			case Operators.H_CLOSEPATH:
				processh();
				break;
			case Operators.F_FILL:
			case Operators.F_FILL_OBSOLETE:
			case Operators.F_STAR_FILL:
				processh();
				processf();
				break;
			case Operators.GS:
				PDExtGState extGState = this.resourceHandler.getExtGState(getLastCOSName(arguments));
				this.graphicsState.copyPropertiesFromExtGState(extGState);
				break;
			case Operators.L_LINE_TO:
				if (arguments.size() == 2 && arguments.get(0).getType().isNumber() &&
						arguments.get(1).getType().isNumber()) {
					double x = arguments.get(0).getReal();
					double y = arguments.get(1).getReal();
					if (!NodeUtils.areCloseNumbers(path.getCurrentX(), x) || !NodeUtils.areCloseNumbers(path.getCurrentY(), y)) {
						nonDrawingArtifacts.add(new LineChunk(pageNumber, path.getCurrentX(), path.getCurrentY(),
								x, y, graphicsState.getLineWidth()));
					}
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
			case Operators.W_LINE_WIDTH:
				if (arguments.size() == 1 && arguments.get(0).getType().isNumber()) {
					double width = arguments.get(0).getReal();
					if (width > 0.0) {
						graphicsState.setLineWidth(width);
					}
				}
				break;
			case Operators.J_LINE_CAP:
				if (arguments.size() == 1 && arguments.get(0).getType() == COSObjType.COS_INTEGER) {
					graphicsState.setLineCap(arguments.get(0).getInteger().intValue());
				}
				break;
			case Operators.RE:
				if (arguments.size() == 4 && arguments.get(0).getType().isNumber() &&
						arguments.get(1).getType().isNumber() && arguments.get(2).getType().isNumber() &&
						arguments.get(3).getType().isNumber()) {
					double x = arguments.get(0).getReal();
					double y = arguments.get(1).getReal();
					nonDrawingArtifacts.add(new Rectangle(pageNumber, x, y, arguments.get(2).getReal(), arguments.get(3).getReal()));
					path.setCurrentPoint(x, y);
					path.setStartPoint(x, y);
				}
				break;
			case Operators.V:
				if (arguments.size() == 4 && arguments.get(0).getType().isNumber() &&
						arguments.get(1).getType().isNumber() && arguments.get(2).getType().isNumber() &&
						arguments.get(3).getType().isNumber()) {
					CurveChunk curve = new CurveChunk(pageNumber, new Vertex(path.getCurrentX(), path.getCurrentY()),
							new Vertex(arguments.get(0).getReal(), arguments.get(1).getReal()),
							new Vertex(arguments.get(2).getReal(), arguments.get(3).getReal()),
							graphicsState.getLineWidth(), true);
					path.setCurrentPoint(curve.getX3(), curve.getY3());
					nonDrawingArtifacts.add(curve);
				}
				break;
			case Operators.Y:
				if (arguments.size() == 4 && arguments.get(0).getType().isNumber() &&
						arguments.get(1).getType().isNumber() && arguments.get(2).getType().isNumber() &&
						arguments.get(3).getType().isNumber()) {
					CurveChunk curve = new CurveChunk(pageNumber, new Vertex(path.getCurrentX(), path.getCurrentY()),
							new Vertex(arguments.get(0).getReal(), arguments.get(1).getReal()),
							new Vertex(arguments.get(2).getReal(), arguments.get(3).getReal()),
							graphicsState.getLineWidth(), false);
					path.setCurrentPoint(curve.getX3(), curve.getY3());
					nonDrawingArtifacts.add(curve);
				}
				break;
			case Operators.B_CLOSEPATH_FILL_STROKE:
			case Operators.B_STAR_CLOSEPATH_EOFILL_STROKE:
				processh();
				processB();
				break;
			case Operators.B_FILL_STROKE:
			case Operators.B_STAR_EOFILL_STROKE:
				processB();
				break;
			case Operators.N:
				nonDrawingArtifacts = new LinkedList<>();
				break;
			case Operators.S_CLOSE_STROKE:
				processh();
				processS();
				break;
			case Operators.S_STROKE:
				processS();
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
						putChunk(getMarkedContent(), new ImageChunk(parseImageBoundingBox()));
					} else if (ASAtom.FORM.equals(xObject.getType())) {
						Long markedContent = getMarkedContent();
						COSKey key = objectKey;
						if (markedContent == null) {
							key = parentObjectKey;
							markedContent = parentMarkedContent;
						}
						GraphicsState xFormGraphicsState = graphicsState.clone();
						xFormGraphicsState.getCTM().concatenate(new Matrix(((PDXForm)xObject).getMatrix()));
						GFSAXForm xForm = new GFSAXForm((PDXForm)xObject, resourceHandler, xFormGraphicsState, pageNumber,
								key, markedContent);
						artifacts.addAll(xForm.getArtifacts());
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
		if (textLineMatrix != null) {
			textLineMatrix.concatenate(Matrix.getTranslateInstance(op1, op2));
			textMatrix = textLineMatrix.clone();
		} else {
			LOGGER.log(Level.WARNING, "Text operator not inside text content");
		}
	}

	private void processDoubleQuote(double op1, double op2) {
		this.graphicsState.getTextState().setWordSpacing(op1);
		this.graphicsState.getTextState().setCharacterSpacing(op2);
	}

	private void processh() {
		if (!NodeUtils.areCloseNumbers(path.getStartX(), path.getCurrentX()) ||
				!NodeUtils.areCloseNumbers(path.getStartY(), path.getCurrentY())) {
			nonDrawingArtifacts.add(new LineChunk(pageNumber, path.getCurrentX(), path.getCurrentY(),
					path.getStartX(), path.getStartY(), graphicsState.getLineWidth()));
		}
		path.setCurrentPoint(path.getStartX(), path.getStartY());
	}

	private void processB() {
		Long mcid = getMarkedContent();
		for (Object chunk : nonDrawingArtifacts) {
			if (chunk instanceof LineChunk) {
				lineArtContainer.add(mcid, transformLineChunk((LineChunk)chunk, graphicsState.getLineWidth(),
						graphicsState.getLineCap()));
			} else if (chunk instanceof CurveChunk) {
				lineArtContainer.add(mcid, CurveChunk.transformCurve((CurveChunk)chunk, graphicsState.getCTM(),
						graphicsState.getLineWidth()).getBoundingBox());
			} else if (chunk instanceof Rectangle) {
				LineChunk line = ((Rectangle)chunk).getLine(graphicsState.getLineWidth());
				if (line != null) {
					lineArtContainer.add(mcid, transformLineChunk(line, line.getWidth(), LineChunk.PROJECTING_SQUARE_CAP_STYLE));
				}
			}
		}
		nonDrawingArtifacts = new LinkedList<>();
	}

	private void processS() {
		Long mcid = getMarkedContent();
		for (Object chunk : nonDrawingArtifacts) {
			if (chunk instanceof LineChunk) {
				lineArtContainer.add(mcid, transformLineChunk((LineChunk)chunk, graphicsState.getLineWidth(),
						graphicsState.getLineCap()));
			} else if (chunk instanceof CurveChunk) {
				lineArtContainer.add(mcid, CurveChunk.transformCurve((CurveChunk)chunk, graphicsState.getCTM(),
						graphicsState.getLineWidth()).getBoundingBox());
			} else if (chunk instanceof Rectangle) {
				Rectangle rectangle = (Rectangle) chunk;
				if (rectangle.getHeight() < graphicsState.getLineWidth() ||
						rectangle.getWidth() < graphicsState.getLineWidth()) {
					LineChunk line = rectangle.getLine(graphicsState.getLineWidth());
					if (line != null) {
						lineArtContainer.add(mcid, transformLineChunk(line, line.getWidth(), LineChunk.PROJECTING_SQUARE_CAP_STYLE));
					}
				} else {
					List<LineChunk> lines = rectangle.getLines(graphicsState.getLineWidth());
					for (LineChunk line : lines) {
						lineArtContainer.add(mcid, transformLineChunk(line, graphicsState.getLineWidth(),
								LineChunk.PROJECTING_SQUARE_CAP_STYLE));
					}
				}
			}
		}
		nonDrawingArtifacts = new LinkedList<>();
	}

	private void processf() {
		Long mcid = getMarkedContent();
		for (int i = 0; i < nonDrawingArtifacts.size(); i++) {
			Object chunk = nonDrawingArtifacts.get(i);
			if (chunk instanceof Rectangle) {
				LineChunk line = ((Rectangle)chunk).getLine(0);
				if (line != null) {
					lineArtContainer.add(mcid, transformLineChunk(line, line.getWidth(), LineChunk.PROJECTING_SQUARE_CAP_STYLE));
				}
			} else if (chunk instanceof LineChunk) {
				LineChunk line = parsingRectangleFromLines(i);
				if (line != null) {
					lineArtContainer.add(mcid, line);
					i += 3;
				} else {
					lineArtContainer.add(mcid, transformLineChunk((LineChunk)chunk, graphicsState.getLineWidth(),
							graphicsState.getLineCap()).getBoundingBox());
				}
			} else if (chunk instanceof CurveChunk) {
				lineArtContainer.add(mcid, CurveChunk.transformCurve((CurveChunk)chunk, graphicsState.getCTM(),
						graphicsState.getLineWidth()).getBoundingBox());
			}
		}
		nonDrawingArtifacts = new LinkedList<>();
	}

	private LineChunk parsingRectangleFromLines(int i) {
		LineChunk line1 = (LineChunk) nonDrawingArtifacts.get(i);
		if ((i < nonDrawingArtifacts.size() - 3) && (nonDrawingArtifacts.get(i + 1) instanceof LineChunk) &&
				(nonDrawingArtifacts.get(i + 2) instanceof LineChunk) &&
				(nonDrawingArtifacts.get(i + 3) instanceof LineChunk)) {
			LineChunk line2 = (LineChunk) nonDrawingArtifacts.get(i + 1);
			LineChunk line3 = (LineChunk) nonDrawingArtifacts.get(i + 2);
			LineChunk line4 = (LineChunk) nonDrawingArtifacts.get(i + 3);
			if (Vertex.areCloseVertexes(line1.getEnd(), line2.getStart()) &&
					Vertex.areCloseVertexes(line2.getEnd(), line3.getStart()) &&
					Vertex.areCloseVertexes(line3.getEnd(), line4.getStart()) &&
					Vertex.areCloseVertexes(line4.getEnd(), line1.getStart())) {
				if (line1.isHorizontalLine() && line2.isVerticalLine() &&
						line3.isHorizontalLine() && line4.isVerticalLine()) {
					LineChunk line = new LineChunk(pageNumber, line2.getCenterX(), line2.getCenterY(),
							line4.getCenterX(), line4.getCenterY(), Math.abs(line1.getCenterY() - line3.getCenterY()));
					return transformLineChunk(line, line.getWidth(), LineChunk.BUTT_CAP_STYLE);
				} else if (line1.isVerticalLine() && line2.isHorizontalLine() &&
						line3.isVerticalLine() && line4.isHorizontalLine()) {
					LineChunk line = new LineChunk(pageNumber, line1.getCenterX(), line1.getCenterY(),
							line3.getCenterX(), line3.getCenterY(), Math.abs(line2.getCenterY() - line4.getCenterY()));
					return transformLineChunk(line, line.getWidth(), LineChunk.BUTT_CAP_STYLE);
				}
			}
		}
		return null;
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

	private BoundingBox parseImageBoundingBox() {
		double x1 = graphicsState.getCTM().getTranslateX();
		double x2 = x1;
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
		double y1 = graphicsState.getCTM().getTranslateY();
		double y2 = y1;
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
		return new BoundingBox(pageNumber, x1, y1, x2, y2);
	}

	private void putChunk(Long mcid, IChunk chunk) {
		if (chunk == null) {
			return;
		}
		if (mcid != null) {
			StaticStorages.getChunks().add(objectKey, mcid, chunk);
		} else if (parentMarkedContent != null) {
			StaticStorages.getChunks().add(parentObjectKey, parentMarkedContent, chunk);
		} else {
			artifacts.add(chunk);
		}
	}

	private List<Double> parseTextShowArgument(COSBase argument, StringBuilder unicodeValue, Matrix textRenderingMatrix) {
		List<Double> symbolEnds = new ArrayList<>();
		if (argument.getType() == COSObjType.COS_STRING) {
			textRenderingMatrix.concatenate(calculateTextRenderingMatrix());
			parseString((COSString) argument.getDirectBase(), unicodeValue, null, symbolEnds);
			if (!symbolEnds.isEmpty()) {
				textMatrix.concatenate(Matrix.getTranslateInstance(symbolEnds.get(symbolEnds.size() - 1), 0));
			}
		} else if (argument.getType() == COSObjType.COS_ARRAY) {
			COSArray array = (COSArray) argument;
			TextPieces textPieces = new TextPieces();
			for (COSObject obj : array) {
				if (obj != null) {
					if (obj.getType() == COSObjType.COS_STRING) {
						parseString((COSString) obj.getDirectBase(), unicodeValue, textPieces, null);
					} else if (obj.getType().isNumber()) {
						textPieces.shiftCurrentX(- obj.getReal() / 1000 *
						    graphicsState.getTextState().getTextFontSize() *
						    graphicsState.getTextState().getHorizontalScaling());
					}
				}
			}
			unicodeValue.append(textPieces.getValue());
			if (!textPieces.isEmpty()) {
				textMatrix.concatenate(Matrix.getTranslateInstance(textPieces.getStartX(), 0));
			}
			textRenderingMatrix.concatenate(calculateTextRenderingMatrix());
			if (!textPieces.isEmpty()) {
				textMatrix.concatenate(Matrix.getTranslateInstance(textPieces.getEndX() - textPieces.getStartX(), 0));
			} else {
				textMatrix.concatenate(Matrix.getTranslateInstance(textPieces.getCurrentX(), 0));
			}
			symbolEnds = textPieces.getSymbolEnds();
		}
		symbolEnds.add(0, 0.0);
		double multiplier = Math.sqrt(textMatrix.getScaleX() * textMatrix.getScaleX() +
		                              textMatrix.getShearY() * textMatrix.getShearY());
		return symbolEnds.stream().map(e -> e * multiplier).collect(Collectors.toList());
	}

	private void parseString(COSString string, StringBuilder unicodeValue, TextPieces textPieces, List<Double> symbolEnds) {
		byte[] bytes = string.get();
		try (InputStream inputStream = new ByteArrayInputStream(bytes)) {
			while (inputStream.available() > 0) {
				int code = graphicsState.getTextState().getTextFont().readCode(inputStream);
				Double width = graphicsState.getTextState().getTextFont().getWidth(code);
				if (width == null) {
					LOGGER.log(Level.SEVERE, "Missing width of glyph with code " + code +
							" in font" + graphicsState.getTextState().getTextFont().getName());
					width = 0.0;
				}
				double shift = (width *
								graphicsState.getTextState().getTextFontSize() / 1000 +
								graphicsState.getTextState().getCharacterSpacing() + (code == 32 ?
								graphicsState.getTextState().getWordSpacing() : 0)) *
								graphicsState.getTextState().getHorizontalScaling();
				String value = graphicsState.getTextState().getTextFont().toUnicode(code);
				if (symbolEnds != null) {
					if (symbolEnds.isEmpty()) {
						TextChunksHelper.updateSymbolEnds(symbolEnds, shift, 0, value != null ? value.length() : 0);
					} else {
						TextChunksHelper.updateSymbolEnds(symbolEnds, shift, symbolEnds.get(symbolEnds.size() - 1),
						                                  value != null ? value.length() : 0);
					}
				}
				if (textPieces == null) {
					unicodeValue.append(value != null ? value : "");
				} else {
					textPieces.add(new TextPieces.TextPiece(value != null ? value : "", textPieces.getCurrentX(),
					                                        textPieces.getCurrentX() + shift));
				}
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Error processing text show operator's string argument : " + new String(bytes), e);
		}
	}

	private TextChunk createTextChunk(List<COSBase> arguments, String operatorType) {
		org.verapdf.pd.font.PDFont font = graphicsState.getTextState().getTextFont();
		COSBase argument = TextChunksHelper.getArgument(arguments, operatorType);
		if (font != null && argument != null && (argument.getType() == COSObjType.COS_STRING ||
		        argument.getType() == COSObjType.COS_ARRAY) && this.textMatrix != null) {
			StringBuilder unicodeValue = new StringBuilder();
			Matrix textRenderingMatrixBefore = new Matrix();
			List<Double> symbolEnds = parseTextShowArgument(argument, unicodeValue, textRenderingMatrixBefore);
			Matrix textRenderingMatrixAfter = calculateTextRenderingMatrix();
			TextChunk textChunk = new TextChunk(TextChunksHelper.calculateTextBoundingBox(textRenderingMatrixBefore,
				textRenderingMatrixAfter, font, pageNumber), unicodeValue.toString(),
				font.getNameWithoutSubset(), TextChunksHelper.calculateTextSize(textRenderingMatrixAfter),
				TextChunksHelper.calculateFontWeight(graphicsState.getTextState().getRenderingMode(), font),
				font.getFontDescriptor().getItalicAngle(), TextChunksHelper.calculateTextBaseLine(textRenderingMatrixAfter),
				graphicsState.getFillColor(), textRenderingMatrixAfter.getRotationDegree());
			textChunk.adjustSymbolEndsToBoundingBox(symbolEnds);
			return textChunk;
		}
		return null;
	}

	private Matrix calculateTextRenderingMatrix() {
		Matrix parameters = new Matrix(graphicsState.getTextState().getTextFontSize() *
		                               graphicsState.getTextState().getHorizontalScaling(), 0, 0,
		                               graphicsState.getTextState().getTextFontSize(), 0,
		                               graphicsState.getTextState().getTextRise());
		return parameters.multiply(textMatrix).multiply(graphicsState.getCTM());
	}

	private Long getMarkedContent() {
		if (!markedContentStack.empty()) {
			for (Long mcid : markedContentStack) {
				if (mcid != null) {
					return mcid;
				}
			}
		}
		return null;
	}

	private static Long getMCID(List<COSBase> arguments, ResourceHandler resources) {
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

	private LineChunk transformLineChunk(LineChunk lineChunk, double lineWidth, int lineCap) {
		return LineChunk.createLineChunk(pageNumber,
				graphicsState.getCTM().transformX(lineChunk.getStartX(), lineChunk.getStartY()),
				graphicsState.getCTM().transformY(lineChunk.getStartX(), lineChunk.getStartY()),
				graphicsState.getCTM().transformX(lineChunk.getEndX(), lineChunk.getEndY()),
				graphicsState.getCTM().transformY(lineChunk.getEndX(), lineChunk.getEndY()),
				lineWidth, lineCap);
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

	private boolean isProcessColorSpace(PDColorSpace colorSpace) {
		if (colorSpace == null) {
			return false;
		}
		ASAtom colorSpaceType = colorSpace.getType();
		return ASAtom.DEVICERGB.equals(colorSpaceType) || ASAtom.DEVICEGRAY.equals(colorSpaceType) ||
		       ASAtom.DEVICECMYK.equals(colorSpaceType) || ASAtom.ICCBASED.equals(colorSpaceType) ||
		       ASAtom.CALRGB.equals(colorSpaceType) || ASAtom.CALGRAY.equals(colorSpaceType) ||
		       ASAtom.DEVICEN.equals(colorSpaceType) || ASAtom.SEPARATION.equals(colorSpaceType) ||
		       ASAtom.INDEXED.equals(colorSpaceType) || ASAtom.LAB.equals(colorSpaceType);
	}

	public void parseLineArts() {
		lineArtContainer.unionBoundingBoxes();
		for (Map.Entry<Long, List<BoundingBox>> boundingBoxes : lineArtContainer.entrySet()) {
			Long mcid = boundingBoxes.getKey();
			List<LineChunk> lineChunks = lineArtContainer.getLineChunks(mcid);
			if (lineChunks == null) {
				lineChunks = new LinkedList<>();
			}
			if (mcid == null && parentMarkedContent == null) {
				for (BoundingBox box : boundingBoxes.getValue()) {
					artifacts.add(new LineArtChunk(box));
				}
				artifacts.addAll(lineChunks);
			}
			BoundingBox boundingBox = new MultiBoundingBox();
			for (BoundingBox box : boundingBoxes.getValue()) {
				boundingBox.union(box);
			}
			if (mcid != null) {
				lineArtContainer.getLineArt(mcid).setBoundingBox(boundingBox);
				lineArtContainer.getLineArt(mcid).setLineChunks(lineChunks);
			} else {
				StaticStorages.getChunks().add(parentObjectKey, parentMarkedContent, new LineArtChunk(boundingBox, lineChunks));
			}
		}
	}
}
