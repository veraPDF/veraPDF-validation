/*
 * This file is part of veraPDF WCAG Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2026, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF WCAG Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF WCAG Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF WCAG Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.factory.chunks;

import org.verapdf.as.ASAtom;
import org.verapdf.gf.model.impl.containers.StaticStorages;
import org.verapdf.gf.model.impl.sa.GFSAXForm;
import org.verapdf.pd.PDResourcesHandler;
import org.verapdf.model.tools.constants.Operators;
import org.verapdf.cos.*;
import org.verapdf.operator.Operator;
import org.verapdf.pd.PDCatalog;
import org.verapdf.pd.PDDocument;
import org.verapdf.pd.PDExtGState;
import org.verapdf.pd.PDResource;
import org.verapdf.pd.colors.PDColorSpace;
import org.verapdf.pd.colors.PDDeviceCMYK;
import org.verapdf.pd.colors.PDDeviceGray;
import org.verapdf.pd.colors.PDDeviceRGB;
import org.verapdf.pd.font.PDCIDFont;
import org.verapdf.pd.font.PDFontDescriptor;
import org.verapdf.pd.font.type3.PDType3Font;
import org.verapdf.pd.images.PDXForm;
import org.verapdf.pd.images.PDXObject;
import org.verapdf.pd.optionalcontent.PDOCMDDictionary;
import org.verapdf.pd.optionalcontent.PDOptionalContentProperties;
import org.verapdf.tools.StaticResources;
import org.verapdf.wcag.algorithms.entities.ObjectKey;
import org.verapdf.wcag.algorithms.entities.content.*;
import org.verapdf.wcag.algorithms.entities.geometry.BoundingBox;
import org.verapdf.wcag.algorithms.entities.geometry.MultiBoundingBox;
import org.verapdf.wcag.algorithms.entities.geometry.Vertex;
import org.verapdf.wcag.algorithms.semanticalgorithms.containers.StaticContainers;
import org.verapdf.wcag.algorithms.semanticalgorithms.utils.NodeUtils;
import org.verapdf.wcag.algorithms.semanticalgorithms.utils.StreamInfo;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Maxim Plushchov
 */
public class ChunkParser {

	private static final Logger LOGGER = Logger.getLogger(ChunkParser.class.getName());
	
	public static final String REPLACEMENT_CHARACTER_STRING = "\uFFFD";
    public static final Map<String, String> fontNameToFontFamilyMap = new HashMap<>();

	/**
	 * A number in a TJ array is expressed in thousandths of a unit of text space
	 * (ISO 32000-1, 9.4.3). Unlike a glyph width, it is not a glyph space value,
	 * so it is never scaled by the FontMatrix of a Type 3 font.
	 */
	public static final double TEXT_SPACE_UNIT = 1.0 / 1000.0;

	/**
	 * How much two boxes may be apart before they count as disjoint, in points.
	 * A chunk is called clipped only when it is separated from the clip by more
	 * than this, so a chunk that merely touches the clip boundary keeps its text.
	 */
	private static final double CLIP_TOLERANCE = 1.0e-3;

	private final Deque<GraphicsState> graphicsStateStack = new ArrayDeque<>();
	private final Stack<Long> markedContentStack = new Stack<>();
    private final Stack<Boolean> visibleContentStack = new Stack<Boolean>();

	private final Set<Long> processedMCIDs = new HashSet<>();

	private final Integer pageNumber;
	private final COSKey objectKey;
	private Matrix textMatrix = null;
	private Matrix textLineMatrix = null;
	private final PDResourcesHandler resourcesHandler;
	private final GraphicsState graphicsState;
	private final Path path = new Path();
	/**
	 * Bounding box, in page space, of the path currently being constructed --
	 * the candidate clip. Null while no path point has been seen.
	 */
	private BoundingBox clipPathBox = null;
	/** Set by W / W*, cleared by the operator that ends the path. */
	private boolean pendingClip = false;
	private final List<IChunk> artifacts = new LinkedList<>();
	private List<Object> nonDrawingArtifacts = new ArrayList<>();
	private final LineArtContainer lineArtContainer;
	private final COSKey parentObjectKey;
	private final Long parentMarkedContent;
	private final String xObjectName;

	public ChunkParser(Integer pageNumber, COSKey objectKey, GraphicsState inheritedGraphicState,
					   PDResourcesHandler resourcesHandler, COSKey parentObjectKey, Long markedContent,
					   String xObjectName) {
		this.pageNumber = pageNumber;
		lineArtContainer = new LineArtContainer(objectKey);
		this.objectKey = objectKey;
		this.graphicsState = inheritedGraphicState.clone();
		this.resourcesHandler = resourcesHandler;
		this.parentObjectKey = parentObjectKey;
		this.parentMarkedContent = markedContent;
		this.xObjectName = xObjectName;
	}

	public List<IChunk> getArtifacts() {
		return artifacts;
	}

	public void parseChunk(Operator rawOperator, List<COSBase> arguments, int operatorIndex) {
		String operatorName = rawOperator.getOperator();
		switch (operatorName) {
			case Operators.BMC:
			case Operators.BDC:
				processLineArts();
				Long mcid = Operators.BDC.equals(operatorName) ? getMCID(arguments, resourcesHandler) : null;
                if (StaticStorages.getIsFilterInvisibleLayers()) {
                    visibleContentStack.push(getLayerVisibility(arguments, resourcesHandler));
                }
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
				processLineArts();
                if (!markedContentStack.isEmpty()) {
                    markedContentStack.pop();
                } else {
                    LOGGER.log(Level.WARNING, "EMC operator does not have a balancing BMC/BDC operator");
                }
                if (!visibleContentStack.isEmpty()) {
                    visibleContentStack.pop();
                }
				break;
			case Operators.G_FILL: {
				if (this.graphicsState.isProcessColorOperators()) {
					processColorSpace(this.graphicsState, resourcesHandler, PDDeviceGray.INSTANCE,
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
					processColorSpace(this.graphicsState, resourcesHandler, PDDeviceRGB.INSTANCE,
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
					processColorSpace(this.graphicsState, resourcesHandler, PDDeviceCMYK.INSTANCE,
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
							LOGGER.log(Level.WARNING, "Error setting fill color with scn operator");
						}
					} else {
						this.graphicsState.setFillColor(new double[0]);
					}
				}
				break;
			case Operators.SC_FILL:
				if (this.graphicsState.isProcessColorOperators()) {
					PDColorSpace colorSpace = this.graphicsState.getFillColorSpace();
					ASAtom colorSpaceType = colorSpace != null ? colorSpace.getType() : null;
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
							LOGGER.log(Level.WARNING, "Error setting fill color with sc operator");
						}
					} else {
						this.graphicsState.setFillColor(new double[0]);
					}
				}
				break;
			case Operators.CS_FILL:
				if (this.graphicsState.isProcessColorOperators()) {
					this.graphicsState.setFillColorSpace(resourcesHandler.getColorSpace(getLastCOSName(arguments), false));
				}
				break;
			case Operators.ET:
				processLineArts();
				textMatrix = null;
				textLineMatrix = null;
				break;
			case Operators.BT:
				processLineArts();
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
                if (arguments.size() == 6) {
                    textMatrix = new Matrix(arguments);
                    textLineMatrix = textMatrix.clone();
                } else {
                    LOGGER.log(Level.WARNING, "tm operator does not have 6 arguments");
                }
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
				processLineArts();
                if (!processLayers()) {
                    break;
                }
				TextChunk textChunk = createTextChunk(arguments, Operators.TJ_SHOW, operatorIndex);
				if (textChunk != null) {
					putChunk(getMarkedContent(), textChunk);
				}
				break;
			}
			case Operators.TJ_SHOW_POS: {
				processLineArts();
                if (!processLayers()) {
                    break;
                }
				TextChunk textChunk = createTextChunk(arguments, Operators.TJ_SHOW_POS, operatorIndex);
				if (textChunk != null) {
					putChunk(getMarkedContent(), textChunk);
				}
				break;
			}
			case Operators.QUOTE: {
				processLineArts();
				processT_STAR();
                if (!processLayers()) {
                    break;
                }
				TextChunk textChunk = createTextChunk(arguments, Operators.QUOTE, operatorIndex);
				if (textChunk != null) {
					putChunk(getMarkedContent(), textChunk);
				}
				break;
			}
			case Operators.DOUBLE_QUOTE:
				processLineArts();
				if (arguments.size() > 1 && arguments.get(0).getType().isNumber() &&
						arguments.get(1).getType().isNumber()) {
					processDoubleQuote(arguments.get(0).getReal(), arguments.get(1).getReal());
				}
                if (!processLayers()) {
                    break;
                }
				TextChunk textChunk = createTextChunk(arguments, Operators.DOUBLE_QUOTE, operatorIndex);
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
				this.graphicsState.getTextState().setTextFont(resourcesHandler.getFont(getFirstCOSName(arguments)));
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
			case Operators.BI: {
				processLineArts();
				if (!processLayers()) {
					break;
				}
				ImageChunk imageChunk = new ImageChunk(parseImageBoundingBox());
				if (StaticContainers.isDataLoader()) {
					imageChunk.getStreamInfos().add(new StreamInfo(operatorIndex, xObjectName, null));
				}
				putChunk(getMarkedContent(), imageChunk);
				break;
			}
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
					// A Bezier curve stays inside the hull of its control points,
					// so the control polygon is a safe over-approximation.
					addClipPathPoint(arguments.get(0).getReal(), arguments.get(1).getReal());
					addClipPathPoint(arguments.get(2).getReal(), arguments.get(3).getReal());
					addClipPathPoint(arguments.get(4).getReal(), arguments.get(5).getReal());
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
				processf(operatorIndex);
				applyPendingClip();
				break;
			case Operators.GS:
				PDExtGState extGState = this.resourcesHandler.getExtGState(getLastCOSName(arguments));
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
					addClipPathPoint(x, y);
					path.setCurrentPoint(x, y);
				}
				break;
			case Operators.M_MOVE_TO:
				if (arguments.size() == 2 && arguments.get(0).getType().isNumber() &&
						arguments.get(1).getType().isNumber()) {
					double x = arguments.get(0).getReal();
					double y = arguments.get(1).getReal();
					addClipPathPoint(x, y);
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
					double width = arguments.get(2).getReal();
					double height = arguments.get(3).getReal();
					nonDrawingArtifacts.add(new Rectangle(pageNumber, x, y, width, height));
					// All four corners: under a rotating or shearing CTM the
					// rectangle is not axis aligned in page space.
					addClipPathPoint(x, y);
					addClipPathPoint(x + width, y);
					addClipPathPoint(x + width, y + height);
					addClipPathPoint(x, y + height);
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
					addClipPathPoint(arguments.get(0).getReal(), arguments.get(1).getReal());
					addClipPathPoint(arguments.get(2).getReal(), arguments.get(3).getReal());
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
					addClipPathPoint(arguments.get(0).getReal(), arguments.get(1).getReal());
					addClipPathPoint(arguments.get(2).getReal(), arguments.get(3).getReal());
					path.setCurrentPoint(curve.getX3(), curve.getY3());
					nonDrawingArtifacts.add(curve);
				}
				break;
			case Operators.B_CLOSEPATH_FILL_STROKE:
			case Operators.B_STAR_CLOSEPATH_EOFILL_STROKE:
				processh();
				processB(operatorIndex);
				applyPendingClip();
				break;
			case Operators.B_FILL_STROKE:
			case Operators.B_STAR_EOFILL_STROKE:
				processB(operatorIndex);
				applyPendingClip();
				break;
			case Operators.W_CLIP:
			case Operators.W_STAR_EOCLIP:
				// W and W* do not clip by themselves: they arm the clip, and the
				// operator that ends the path applies it. See the coordinate
				// contract on applyPendingClip.
				pendingClip = true;
				break;
			case Operators.N:
				nonDrawingArtifacts = new ArrayList<>();
				applyPendingClip();
				break;
			case Operators.S_CLOSE_STROKE:
				processh();
				processS(operatorIndex);
				applyPendingClip();
				break;
			case Operators.S_STROKE:
				processS(operatorIndex);
				applyPendingClip();
				break;
			case Operators.CM_CONCAT:
                if (arguments.size() == 6) {
                    graphicsState.getCTM().concatenate(new Matrix(arguments));
                } else {
                    LOGGER.log(Level.WARNING, "cm operator does not have 6 arguments");
                }
				break;
			case Operators.Q_GRESTORE:
				if (!graphicsStateStack.isEmpty()) {
					this.graphicsState.copyProperties(this.graphicsStateStack.pop());
				}
				break;
			case Operators.Q_GSAVE:
				this.graphicsStateStack.push(this.graphicsState.clone());
				break;
			case Operators.DO: {
				processLineArts();
				if (!processLayers()) {
					break;
				}
				COSName xObjectName = getLastCOSName(arguments);
				PDXObject xObject = resourcesHandler.getXObject(xObjectName);
				if (xObject != null) {
					if (ASAtom.IMAGE.equals(xObject.getType())) {
						ImageChunk imageChunk = new ImageChunk(parseImageBoundingBox());
						if (StaticContainers.isDataLoader()) {
							COSKey key = xObject.getObject().getObjectKey();
							imageChunk.getStreamInfos().add(new StreamInfo(operatorIndex, this.xObjectName, 
									key != null ? new ObjectKey(key.getNumber(), key.getGeneration()) : null));
						}
						putChunk(getMarkedContent(), imageChunk);
					} else if (ASAtom.FORM.equals(xObject.getType())) {
						Long markedContent = getMarkedContent();
						COSKey key = objectKey;
						if (markedContent == null) {
							key = parentObjectKey;
							markedContent = parentMarkedContent;
						}
						GraphicsState xFormGraphicsState = graphicsState.clone();
						xFormGraphicsState.getCTM().concatenate(new Matrix(((PDXForm) xObject).getMatrix()));
						// A form's /BBox clips its own content (ISO 32000-1,
						// 8.10.2), and the clone already carries the clip
						// inherited from here, so the two compose.
						intersectFormBBoxClip(xFormGraphicsState, (PDXForm) xObject);
						GFSAXForm xForm = new GFSAXForm((PDXForm) xObject, resourcesHandler, xFormGraphicsState, pageNumber,
								key, markedContent, xObjectName.getName().getValue());
						artifacts.addAll(xForm.getArtifacts());
					}
				}
				break;
			}
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

	/*
	 * ------------------------------------------------------------------
	 * Clipping: the coordinate contract
	 * ------------------------------------------------------------------
	 *
	 * Path points are transformed by the CTM current at each path
	 * construction operator (m, l, re, c, v, y), not by whatever CTM the
	 * painting operator happens to see, and are accumulated into
	 * clipPathBox in page space -- the same space createTextChunk's
	 * bounding box is built in, because the text rendering matrix that
	 * produces it ends with the same CTM.
	 *
	 * W and W* do not clip. They set pendingClip, and the pending clip is
	 * applied after the path painting operator that ends the path (n, f, F,
	 * f*, B, B*, b, b*, S, s), using the bounding box of the whole
	 * constructed path; the path is then reset.
	 *
	 * The effective clip is the intersection of the inherited clip and that
	 * box. Null means unclipped; an EMPTY intersection stays an empty box
	 * and must never become "unclipped" again (see GraphicsState).
	 *
	 * q and Q save and restore the clip with the rest of the graphics
	 * state, because GraphicsState carries it through both clone() and
	 * copyProperties.
	 *
	 * On Do of a Form XObject the nested parser inherits the clip through
	 * the cloned graphics state and additionally intersects the form's
	 * /BBox transformed by /Matrix x CTM, so nesting composes.
	 *
	 * Non-rectangular clipping paths are approximated by their bounding
	 * box. That approximation only ever makes the clip LARGER, so
	 * disjointness still proves invisibility -- but overlap proves nothing,
	 * and no visibility is claimed. Text inside the box but outside the
	 * real path is therefore retained.
	 */

	/**
	 * Extends the path under construction with one point, transformed by the
	 * CTM in force right now.
	 */
	private void addClipPathPoint(double x, double y) {
		double pageX = graphicsState.getCTM().transformX(x, y);
		double pageY = graphicsState.getCTM().transformY(x, y);
		if (clipPathBox == null) {
			clipPathBox = new BoundingBox(pageNumber, pageX, pageY, pageX, pageY);
			return;
		}
		clipPathBox.setLeftX(Math.min(clipPathBox.getLeftX(), pageX));
		clipPathBox.setRightX(Math.max(clipPathBox.getRightX(), pageX));
		clipPathBox.setBottomY(Math.min(clipPathBox.getBottomY(), pageY));
		clipPathBox.setTopY(Math.max(clipPathBox.getTopY(), pageY));
	}

	/**
	 * Applies the clip armed by W / W*, if any, and resets the path. Called by
	 * every path painting operator, so that a path built without W also ends
	 * here.
	 *
	 * <p>A W with no path point at all is left as a no-op rather than read as
	 * an empty clip: the conservative reading of a degenerate stream is that
	 * nothing was clipped.
	 */
	private void applyPendingClip() {
		if (pendingClip && clipPathBox != null) {
			graphicsState.intersectClip(clipPathBox);
		}
		pendingClip = false;
		clipPathBox = null;
	}

	/**
	 * Intersects a form's own /BBox, transformed by the CTM the form will be
	 * parsed with, into that state's clip.
	 */
	private void intersectFormBBoxClip(GraphicsState state, PDXForm form) {
		double[] bbox = form.getBBox();
		if (bbox == null || bbox.length != 4) {
			return;
		}
		state.intersectClip(state.getCTM().transformBoundingBox(
				new BoundingBox(pageNumber, bbox[0], bbox[1], bbox[2], bbox[3])));
	}

	/**
	 * Marks a chunk whose bounding box is wholly outside the effective clip, so
	 * a consumer can drop text that cannot appear on the page.
	 *
	 * <p>Conservative on purpose: only a box separated from the clip by more
	 * than CLIP_TOLERANCE counts. A chunk that touches the clip boundary or
	 * crosses it keeps its text, because part of it is readable and a chunk is
	 * not split at the boundary. A degenerate (zero area) text box has no
	 * geometry to place outside the clip and is never marked.
	 */
	private void markIfClipped(TextChunk textChunk) {
		BoundingBox clip = graphicsState.getClipBox();
		if (clip == null || clip.getPageNumber() == null) {
			return;
		}
		BoundingBox box = textChunk.getBoundingBox();
		if (box == null || box.getPageNumber() == null) {
			return;
		}
		if (box.getWidth() <= CLIP_TOLERANCE || box.getHeight() <= CLIP_TOLERANCE) {
			return;
		}
		if (clip.notOverlaps(box, CLIP_TOLERANCE)) {
			textChunk.setClippedText(true);
		}
	}

	private void processh() {
		if (!NodeUtils.areCloseNumbers(path.getStartX(), path.getCurrentX()) ||
				!NodeUtils.areCloseNumbers(path.getStartY(), path.getCurrentY())) {
			nonDrawingArtifacts.add(new LineChunk(pageNumber, path.getCurrentX(), path.getCurrentY(),
					path.getStartX(), path.getStartY(), graphicsState.getLineWidth()));
		}
		path.setCurrentPoint(path.getStartX(), path.getStartY());
	}

	/**
	 * @param operatorIndex position of the paint operator in the stream, so a
	 *                      line art chunk can carry it the way text and image
	 *                      chunks already do
	 */
	private void processB(int operatorIndex) {
        if (!processLayers()) {
            nonDrawingArtifacts = new ArrayList<>();
            return;
        }
		Long mcid = getMarkedContent();
		BoundingBox boundingBox = new MultiBoundingBox();
		for (Object chunk : nonDrawingArtifacts) {
			if (chunk instanceof LineChunk) {
				LineChunk lineChunk = transformLineChunk((LineChunk)chunk, graphicsState.getLineWidth(),
						graphicsState.getLineCap());
				processLineChunk(boundingBox, mcid, lineChunk, operatorIndex);
			} else if (chunk instanceof CurveChunk) {
				CurveChunk curveChunk = CurveChunk.transformCurve((CurveChunk)chunk, graphicsState.getCTM(),
						graphicsState.getLineWidth());
				processBoundingBox(boundingBox, mcid, curveChunk.getBoundingBox(), operatorIndex);
			} else if (chunk instanceof Rectangle) {
				LineChunk line = ((Rectangle)chunk).getLine(graphicsState.getLineWidth());
				if (line != null) {
					LineChunk line1 = transformLineChunk(line, line.getWidth(), LineChunk.PROJECTING_SQUARE_CAP_STYLE);
					processLineChunk(boundingBox, mcid, line1, operatorIndex);
				}
			}
		}
		if (StaticStorages.getIsIgnoreMCIDs()) {
			lineArtContainer.add(mcid, boundingBox, operatorIndex, xObjectName);
		}
		nonDrawingArtifacts = new ArrayList<>();
	}

	/**
	 * @param operatorIndex position of the paint operator in the stream, so a
	 *                      line art chunk can carry it the way text and image
	 *                      chunks already do
	 */
	private void processS(int operatorIndex) {
        if (!processLayers()) {
            nonDrawingArtifacts = new ArrayList<>();
            return;
        }
		Long mcid = getMarkedContent();
		BoundingBox boundingBox = new MultiBoundingBox();
		for (Object chunk : nonDrawingArtifacts) {
			if (chunk instanceof LineChunk) {
				LineChunk lineChunk = transformLineChunk((LineChunk)chunk, graphicsState.getLineWidth(),
						graphicsState.getLineCap());
				processLineChunk(boundingBox, mcid, lineChunk, operatorIndex);
			} else if (chunk instanceof CurveChunk) {
				CurveChunk curveChunk = CurveChunk.transformCurve((CurveChunk)chunk, graphicsState.getCTM(),
						graphicsState.getLineWidth());
				processBoundingBox(boundingBox, mcid, curveChunk.getBoundingBox(), operatorIndex);
			} else if (chunk instanceof Rectangle) {
				Rectangle rectangle = (Rectangle) chunk;
				if (rectangle.getHeight() < graphicsState.getLineWidth() ||
						rectangle.getWidth() < graphicsState.getLineWidth()) {
					LineChunk line = rectangle.getLine(graphicsState.getLineWidth());
					if (line != null) {
						LineChunk line1 = transformLineChunk(line, line.getWidth(), LineChunk.PROJECTING_SQUARE_CAP_STYLE);
						processLineChunk(boundingBox, mcid, line1, operatorIndex);
					}
				} else {
					List<LineChunk> lines = rectangle.getLines(graphicsState.getLineWidth());
					for (LineChunk line : lines) {
						LineChunk line1 = transformLineChunk(line, graphicsState.getLineWidth(), LineChunk.PROJECTING_SQUARE_CAP_STYLE);
						processLineChunk(boundingBox, mcid, line1, operatorIndex);
					}
				}
			}
		}
		if (StaticStorages.getIsIgnoreMCIDs()) {
			lineArtContainer.add(mcid, boundingBox, operatorIndex, xObjectName);
		}
		nonDrawingArtifacts = new ArrayList<>();
	}

	/**
	 * @param operatorIndex position of the paint operator in the stream, so a
	 *                      line art chunk can carry it the way text and image
	 *                      chunks already do
	 */
	private void processf(int operatorIndex) {
        if (!processLayers()) {
            nonDrawingArtifacts = new ArrayList<>();
            return;
        }
		Long mcid = getMarkedContent();
		BoundingBox boundingBox = new MultiBoundingBox();
		for (int i = 0; i < nonDrawingArtifacts.size(); i++) {
			Object chunk = nonDrawingArtifacts.get(i);
			if (chunk instanceof Rectangle) {
				LineChunk line = ((Rectangle)chunk).getLine(0);
				if (line != null) {
					LineChunk line1 = transformLineChunk(line, line.getWidth(), LineChunk.PROJECTING_SQUARE_CAP_STYLE);
					processLineChunk(boundingBox, mcid, line1, operatorIndex);
				}
			} else if (chunk instanceof LineChunk) {
				LineChunk line = parsingRectangleFromLines(i);
				if (line != null) {
					processLineChunk(boundingBox, mcid, line, operatorIndex);
					i += 3;
				} else {
					LineChunk line1 = transformLineChunk((LineChunk)chunk, graphicsState.getLineWidth(),
							graphicsState.getLineCap());
					processBoundingBox(boundingBox, mcid, line1.getBoundingBox(), operatorIndex);
				}
			} else if (chunk instanceof CurveChunk) {
				CurveChunk curveChunk = CurveChunk.transformCurve((CurveChunk)chunk, graphicsState.getCTM(),
						graphicsState.getLineWidth());
				processBoundingBox(boundingBox, mcid, curveChunk.getBoundingBox(), operatorIndex);
			}
		}
		if (StaticStorages.getIsIgnoreMCIDs()) {
			lineArtContainer.add(mcid, boundingBox, operatorIndex, xObjectName);
		}
		nonDrawingArtifacts = new ArrayList<>();
	}
	
	private void processLineChunk(BoundingBox boundingBox, Long mcid, LineChunk lineChunk,
	                              int operatorIndex) {
		lineArtContainer.add(mcid, lineChunk, operatorIndex, xObjectName);
		if (StaticStorages.getIsIgnoreMCIDs()) {
			boundingBox.union(lineChunk.getBoundingBox());
		}
	}
	
	private void processBoundingBox(BoundingBox boundingBox, Long mcid, BoundingBox newBoundingBox,
	                                int operatorIndex) {
		if (StaticStorages.getIsIgnoreMCIDs()) {
			boundingBox.union(newBoundingBox);
		} else {
			// Curves reach the container here rather than through
			// processLineChunk, so the operator index has to be carried on this
			// path too: a region drawn only with curve operators is otherwise
			// left without one.
			lineArtContainer.add(mcid, newBoundingBox, operatorIndex, xObjectName);
		}
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
				if (isHorizontalLine(line1, line2, line3, line4)) {
					LineChunk line = new LineChunk(pageNumber, line2.getCenterX(), line2.getCenterY(),
							line4.getCenterX(), line4.getCenterY(), Math.abs(line1.getCenterY() - line3.getCenterY()));
					return transformLineChunk(line, line.getWidth(), LineChunk.BUTT_CAP_STYLE);
				}
				if (isVerticalLine(line1, line2, line3, line4)) {
					LineChunk line = new LineChunk(pageNumber, line2.getCenterX(), line2.getCenterY(),
							line4.getCenterX(), line4.getCenterY(), Math.abs(line1.getCenterX() - line3.getCenterX()));
					return transformLineChunk(line, line.getWidth(), LineChunk.BUTT_CAP_STYLE);
				}
				if (isHorizontalLine(line2, line1, line4, line3)) {
					LineChunk line = new LineChunk(pageNumber, line1.getCenterX(), line1.getCenterY(),
							line3.getCenterX(), line3.getCenterY(), Math.abs(line2.getCenterY() - line4.getCenterY()));
					return transformLineChunk(line, line.getWidth(), LineChunk.BUTT_CAP_STYLE);
				}
				if (isVerticalLine(line2, line1, line4, line3)) {
					LineChunk line = new LineChunk(pageNumber, line1.getCenterX(), line1.getCenterY(),
							line3.getCenterX(), line3.getCenterY(), Math.abs(line2.getCenterX() - line4.getCenterX()));
					return transformLineChunk(line, line.getWidth(), LineChunk.BUTT_CAP_STYLE);
				}
			}
		}
		return null;
	}
	
	private static boolean isHorizontalLine(LineChunk line1, LineChunk line2, LineChunk line3, LineChunk line4) {
		return line1.isHorizontalLine() && (line2.isVerticalLine() ||
				Vertex.areCloseVertexes(line2.getEnd(), line2.getStart())) &&
				line3.isHorizontalLine() && (line4.isVerticalLine() ||
				Vertex.areCloseVertexes(line4.getEnd(), line4.getStart()));
	}
	
	private static boolean isVerticalLine(LineChunk line1, LineChunk line2, LineChunk line3, LineChunk line4) {
		return line1.isVerticalLine() && (line2.isHorizontalLine() ||
				Vertex.areCloseVertexes(line2.getEnd(), line2.getStart())) &&
				line3.isVerticalLine() && (line4.isHorizontalLine() ||
				Vertex.areCloseVertexes(line4.getEnd(), line4.getStart()));
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

	private TextPieces parseTextShowArgument(boolean isVertical, COSBase argument, double scalingFactor) {
		TextPieces textPieces = new TextPieces(isVertical);
		if (argument.getType() == COSObjType.COS_STRING) {
			parseString(isVertical, (COSString) argument.getDirectBase(), textPieces, scalingFactor);
		} else if (argument.getType() == COSObjType.COS_ARRAY) {
			COSArray array = (COSArray) argument;
			for (COSObject obj : array) {
				if (obj != null) {
					if (obj.getType() == COSObjType.COS_STRING) {
						parseString(isVertical, (COSString) obj.getDirectBase(), textPieces, scalingFactor);
					} else if (obj.getType().isNumber()) {
						TextState textState = graphicsState.getTextState();
						textPieces.shiftCurrent(-obj.getReal() * TEXT_SPACE_UNIT * textState.getTextFontSize() *
								(isVertical ? 1 : textState.getHorizontalScaling()));
					}
				}
			}
		}
		if (StaticStorages.getIsAddSpacesBetweenTextPieces()) {
			double threshold = graphicsState.getTextState().getTextFontSize() * StaticContainers.getTextLineSpaceRatio();
			textPieces.addSpaces(threshold);
		}
		return textPieces;
	}

	private void parseString(boolean isVertical, COSString string, TextPieces textPieces, double scalingFactor) {
		byte[] bytes = string.get();
		try (InputStream inputStream = new ByteArrayInputStream(bytes)) {
			while (inputStream.available() > 0) {
				double current = textPieces.getCurrent();
				TextState textState = graphicsState.getTextState();
				org.verapdf.pd.font.PDFont font = textState.getTextFont();
				int code = font.readCode(inputStream);
				String value = font.toUnicode(code, false);
				double scaling = isVertical ? 1 : textState.getHorizontalScaling();
				double shift = (textState.getCharacterSpacing() + (code == 32 ? textState.getWordSpacing() : 0)) * scaling;
				Double width = isVertical ? ((PDCIDFont) font).getVerticalWidth(code) : font.getWidth(code);
				if (width != null) {
					width = width * textState.getTextFontSize() * scalingFactor * scaling;
				} else {
					LOGGER.log(Level.SEVERE, "Missing width of glyph with code " + code + " in font " + font.getName());
					width = 0.0;
				}
				if (value == null) {
					value = StaticContainers.getIsIgnoreCharactersWithoutUnicode() ? "" : REPLACEMENT_CHARACTER_STRING;
					if (StaticContainers.isDataLoader()) {
						LOGGER.log(Level.WARNING, "The glyph can not be mapped to Unicode");
					}
				}
                if (font instanceof PDType3Font) {
                    Double glyphAscent = ((PDType3Font) font).getAscentFromProgram(code);
                    if (glyphAscent != null && (textPieces.getAscent() == null ||
                            glyphAscent > textPieces.getAscent())) {
                        textPieces.setAscent(glyphAscent);
                    }
                    Double glyphDescent = ((PDType3Font) font).getDescentFromProgram(code);
                    if (glyphDescent != null && (textPieces.getDescent() == null ||
                            glyphDescent < textPieces.getDescent())) {
                        textPieces.setDescent(glyphDescent);
                    }
                }

				textPieces.add(new TextPieces.TextPiece(value, current, current + width));
				textPieces.shiftCurrent(shift);
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Error processing text show operator's string argument : " + new String(bytes));
		}
	}

	private TextChunk createTextChunk(List<COSBase> arguments, String operatorType, int operatorIndex) {
		org.verapdf.pd.font.PDFont font = graphicsState.getTextState().getTextFont();
		boolean isVertical = font instanceof PDCIDFont && ((PDCIDFont) font).isVertical();
		COSBase argument = TextChunksHelper.getArgument(arguments, operatorType);
		if (font != null && argument != null && (argument.getType() == COSObjType.COS_STRING ||
		        argument.getType() == COSObjType.COS_ARRAY) && this.textMatrix != null) {
			double scalingFactor = isVertical ? TextChunksHelper.getVerticalScalingFactor(font) : 
					TextChunksHelper.getHorizontalScalingFactor(font);
			TextPieces textPieces = parseTextShowArgument(isVertical, argument, scalingFactor);
			if (textPieces.isEmpty()) {
				textMatrix.concatenate(
					textPieces.isVertical
						? Matrix.getTranslateInstance(0, textPieces.getCurrent())
						: Matrix.getTranslateInstance(textPieces.getCurrent(), 0)
				);
				return null;
			}
			double startX = 0;
			double startY = 0;
			double currentX = 0;
			double currentY = 0;
			double endX = 0;
			double endY = 0;
			if (isVertical) {
				currentY = textPieces.getCurrent();
				startY = textPieces.getStart();
				endY = textPieces.getEnd();
			} else {
				currentX = textPieces.getCurrent();
				startX = textPieces.getStart();
				endX = textPieces.getEnd();
			}
			textMatrix.concatenate(Matrix.getTranslateInstance(startX, startY));
			Matrix textRenderingMatrixBefore = calculateTextRenderingMatrix();
			textMatrix.concatenate(Matrix.getTranslateInstance(endX - startX, endY - startY));
			Matrix textRenderingMatrixAfter = calculateTextRenderingMatrix();
			textMatrix.concatenate(Matrix.getTranslateInstance(currentX - endX, currentY - endY));
			PDFontDescriptor descriptor = font.getFontDescriptor();
			String fontNameWithoutSubset = font.getNameWithoutSubset();
			TextChunk textChunk = new TextChunk(
				TextChunksHelper.calculateTextBoundingBox(isVertical, textRenderingMatrixBefore, textRenderingMatrixAfter, font, pageNumber, textPieces),
				textPieces.getValue(), fontNameWithoutSubset, TextChunksHelper.calculateTextSize(textRenderingMatrixAfter),
				TextChunksHelper.calculateFontWeight(graphicsState.getTextState().getRenderingMode(), font), 
					descriptor.getItalicAngle(), TextChunksHelper.calculateTextBaseLine(textRenderingMatrixAfter),
				graphicsState.getFillColor(), textRenderingMatrixAfter.getRotationDegree());
			textChunk.adjustSymbolEndsToBoundingBox(textPieces.getSymbolEnds());
			if (StaticContainers.isDataLoader()) {
				textChunk.getStreamInfos().addAll(textPieces.getStreamInfos(operatorIndex, xObjectName));
			}
			markIfClipped(textChunk);
			if (StaticContainers.isDataLoader() && !fontNameToFontFamilyMap.containsKey(fontNameWithoutSubset)) {
				String fontFamily = descriptor.getFontFamily();
				if (fontFamily == null || fontFamily.isEmpty()) {
					fontFamily = PDFontDescriptor.extractFontFamilyFromFontName(fontNameWithoutSubset);
				}
				fontNameToFontFamilyMap.put(fontNameWithoutSubset, fontFamily);
			}
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

	private static Long getMCID(List<COSBase> arguments, PDResourcesHandler resources) {
		if (StaticStorages.getIsIgnoreMCIDs()) {
			return null;
		}
		if (!arguments.isEmpty()) {
			COSBase lastArg = arguments.get(arguments.size() - 1);
			if (lastArg.getType() == COSObjType.COS_DICT) {
				return lastArg.getIntegerKey(ASAtom.MCID);
			} else if (lastArg.getType() == COSObjType.COS_NAME && resources != null) {
                COSBase property = getPropertyByName(lastArg.getName(), resources);
                if (property != null && property.getType() == COSObjType.COS_DICT) {
                    return property.getIntegerKey(ASAtom.MCID);
                }
			}
		}
		return null;
	}

    private static boolean getLayerVisibility(List<COSBase> arguments, PDResourcesHandler resources) {
        if (arguments != null && !arguments.isEmpty() && resources != null) {
            COSBase firstArg = arguments.get(0);
            if (firstArg.getType() == COSObjType.COS_NAME && firstArg.getName().equals(ASAtom.OC)) {
                COSBase lastArg = arguments.get(arguments.size() - 1);
                if (lastArg != null && lastArg.getType() == COSObjType.COS_NAME) {
                    COSBase property = getPropertyByName(lastArg.getName(), resources);
                    if (property != null && property.getType() == COSObjType.COS_DICT) {
                        String name = property.getStringKey(ASAtom.NAME);
                        PDDocument doc = StaticResources.getDocument();
                        if (doc != null) {
                            PDCatalog catalog = doc.getCatalog();
                            PDOptionalContentProperties optProperties = catalog.getOCProperties();
                            if (optProperties != null) {
                                if (name != null) {
                                    if (optProperties.isContainsName(name)) {
                                        return optProperties.isVisibleLayer(name);
                                    }
                                } else {
                                    if (ASAtom.OCMD.equals(property.getNameKey(ASAtom.TYPE))) {
                                        return PDOCMDDictionary.isVisibleOCMD(property, optProperties);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private static COSBase getPropertyByName(ASAtom name, PDResourcesHandler resources) {
        PDResource properties = resources.getProperties(name);
        if (properties != null) {
            return properties.getObject().getDirectBase();
        }
        return null;
    }

	private LineChunk transformLineChunk(LineChunk lineChunk, double lineWidth, int lineCap) {
		return LineChunk.createLineChunk(pageNumber,
				graphicsState.getCTM().transformX(lineChunk.getStartX(), lineChunk.getStartY()),
				graphicsState.getCTM().transformY(lineChunk.getStartX(), lineChunk.getStartY()),
				graphicsState.getCTM().transformX(lineChunk.getEndX(), lineChunk.getEndY()),
				graphicsState.getCTM().transformY(lineChunk.getEndX(), lineChunk.getEndY()),
				lineWidth * graphicsState.getCTM().getScaleValue(), lineCap);
	}

	private static void processColorSpace(GraphicsState graphicState, PDResourcesHandler resourcesHandler,
	                                      PDColorSpace defaultCS, ASAtom name, boolean stroke) {
		PDColorSpace colorSpace = resourcesHandler.getColorSpace(name, false);
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
			// Stream position recorded for this mcid while the operators were read.
			// The chunks below are built after the stream, so this is the only way
			// they can carry one — and without one a vector region can never be
			// given a marked content id, which is what makes it untaggable.
			List<StreamInfo> lineArtStreamInfos = lineArtContainer.getStreamInfos(mcid);
			if (mcid == null && parentMarkedContent == null) {
				for (BoundingBox box : boundingBoxes.getValue()) {
					LineArtChunk artifact = new LineArtChunk(box);
					for (StreamInfo info : lineArtStreamInfos) {
						artifact.getStreamInfos().add(new StreamInfo(info));
					}
					artifacts.add(artifact);
				}
				artifacts.addAll(lineChunks);
			}
			BoundingBox boundingBox = new MultiBoundingBox();
			for (BoundingBox box : boundingBoxes.getValue()) {
				boundingBox.union(box);
			}
			if (mcid != null) {
				LineArtChunk existing = lineArtContainer.getLineArt(mcid);
				existing.setBoundingBox(boundingBox);
				existing.setLineChunks(lineChunks);
				// Set here rather than where the chunk was created. The chunk is
				// created on the region's first bounding box, when only the first
				// operator has been seen, and the operators that follow never
				// reach it — so a region inside marked content exposed just one of
				// them. This runs once the stream has been read, so the list is
				// complete.
				existing.getStreamInfos().clear();
				for (StreamInfo info : lineArtStreamInfos) {
					existing.getStreamInfos().add(new StreamInfo(info));
				}
			} else {
				LineArtChunk lineArtChunk = new LineArtChunk(boundingBox, lineChunks);
				for (StreamInfo info : lineArtStreamInfos) {
					lineArtChunk.getStreamInfos().add(new StreamInfo(info));
				}
				StaticStorages.getChunks().add(parentObjectKey, parentMarkedContent, lineArtChunk);
			}
		}
	}

	public void processLineArts() {
		if (!StaticStorages.getIsIgnoreMCIDs()) {
			return;
		}
		// Read before the container's record is cleared below. This is the path a
		// region outside any marked content takes, and the chunks it produces are
		// the ones a consumer sees, so a position missing here is a region that
		// cannot be tagged however well the rest is wired.
		List<StreamInfo> pending = lineArtContainer.getStreamInfos(null);
		List<LineChunk> lineChunks = lineArtContainer.getLineChunks(null);
		if (lineChunks != null && !lineChunks.isEmpty()) {
			for (LineChunk lineChunk : lineChunks) {
				for (StreamInfo info : pending) {
					lineChunk.getStreamInfos().add(new StreamInfo(info));
				}
			}
			artifacts.addAll(lineChunks);
			lineChunks.clear();
		}
		List<BoundingBox> boundingBoxes = lineArtContainer.getBoundingBoxes(null);
		if (boundingBoxes != null && !boundingBoxes.isEmpty()) {
			for (BoundingBox box : boundingBoxes) {
				LineArtChunk artifact = new LineArtChunk(box);
				for (StreamInfo info : pending) {
					artifact.getStreamInfos().add(new StreamInfo(info));
				}
				artifacts.add(artifact);
			}
			boundingBoxes.clear();
		}
		lineArtContainer.clearStreamInfos(null);
	}

    public boolean processLayers() {
        if (!StaticContainers.isDataLoader()) {
            return true;
        }
        if (StaticStorages.getIsFilterInvisibleLayers()) {
            return visibleContentStack.isEmpty() || visibleContentStack.peek();
        }
        return true;
    }
}
