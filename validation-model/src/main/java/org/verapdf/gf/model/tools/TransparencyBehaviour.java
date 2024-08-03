/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2024, veraPDF Consortium <info@verapdf.org>
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
package org.verapdf.gf.model.tools;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.factory.operators.TransparencyGraphicsState;
import org.verapdf.gf.model.impl.pd.GFPDContentStream;
import org.verapdf.gf.model.impl.pd.colors.GFPDColorSpace;
import org.verapdf.gf.model.impl.pd.font.GFPDFont;
import org.verapdf.gf.model.impl.pd.font.GFPDType3Font;
import org.verapdf.gf.model.impl.pd.images.GFPDXForm;
import org.verapdf.gf.model.impl.pd.images.GFPDXImage;
import org.verapdf.gf.model.impl.pd.images.GFPDXObject;
import org.verapdf.gf.model.impl.pd.patterns.GFPDTilingPattern;
import org.verapdf.model.pdlayer.PDContentStream;
import org.verapdf.pd.font.Encoding;

import java.util.Map;

/**
 * Transparency checker class
 *
 * @author Maksim Bezrukov
 */
public class TransparencyBehaviour {

    private boolean isFillCheck = false;
    private boolean isStrokeCheck = false;
    private boolean isXObjectCheck = false;
    private boolean isColorSpaceCheck = false;
    private boolean isFontCheck = false;

    private TransparencyBehaviour() {
    }

    /**
     * @return an instance of TransparencyBehaviour class with fill checks
     */
    public static TransparencyBehaviour createFillInstance() {
        TransparencyBehaviour tb = new TransparencyBehaviour();
        tb.isFillCheck = true;
        return tb;
    }

    /**
     * @return an instance of TransparencyBehaviour class with fill and XObjects checks
     */
    public static TransparencyBehaviour createFillXObjectInstance() {
        TransparencyBehaviour tb = createFillInstance();
        tb.isXObjectCheck = true;
        return tb;
    }

    /**
     * @return an instance of TransparencyBehaviour class with fill and patterns checks
     */
    public static TransparencyBehaviour createFillColorSpaceInstance() {
        TransparencyBehaviour tb = createFillInstance();
        tb.isColorSpaceCheck = true;
        return tb;
    }

    /**
     * @return an instance of TransparencyBehaviour class with fill, patterns and font checks
     */
    public static TransparencyBehaviour createFillColorSpaceFontInstance() {
        TransparencyBehaviour tb = createFillColorSpaceInstance();
        tb.isFontCheck = true;
        return tb;
    }

    /**
     * @return an instance of TransparencyBehaviour class with stroke and patterns checks
     */
    public static TransparencyBehaviour createStrokeColorSpaceInstance() {
        TransparencyBehaviour tb = new TransparencyBehaviour();
        tb.isStrokeCheck = true;
        tb.isColorSpaceCheck = true;
        return tb;
    }

    /**
     * @return an instance of TransparencyBehaviour class with stroke, patterns and font checks
     */
    public static TransparencyBehaviour createStrokeColorSpaceFontInstance() {
        TransparencyBehaviour tb = createStrokeColorSpaceInstance();
        tb.isFontCheck = true;
        return tb;
    }

    /**
     * @return an instance of TransparencyBehaviour class with fill, stroke and patterns checks
     */
    public static TransparencyBehaviour createFillStrokeColorSpaceInstance() {
        TransparencyBehaviour tb = new TransparencyBehaviour();
        tb.isFillCheck = true;
        tb.isStrokeCheck = true;
        tb.isColorSpaceCheck = true;
        return tb;
    }

    /**
     * @return an instance of TransparencyBehaviour class with fill, stroke, patterns and font checks
     */
    public static TransparencyBehaviour createFillStrokeColorSpaceFontInstance() {
        TransparencyBehaviour tb = createFillStrokeColorSpaceInstance();
        tb.isFontCheck = true;
        return tb;
    }

    /**
     * Checks the given graphic state for the transparency depends on created object type
     * @param transparencyGraphicsState graphicState object for check
     * @return true if the given argument object contains transparency depends on created object type
     */
    public boolean containsTransparency(TransparencyGraphicsState transparencyGraphicsState) {
        if (baseCheck(transparencyGraphicsState)) {
            return true;
        }

        if (isFillCheck && transparencyGraphicsState.getCa_ns() < 1.0f) {
            return true;
        }

        if (isStrokeCheck && transparencyGraphicsState.getCa() < 1.0f) {
            return true;
        }

        if (isXObjectCheck && xObjectContainsTransparency(transparencyGraphicsState.getVeraXObject())) {
            return true;
        }

        if (isColorSpaceCheck && colorSpaceCheck(transparencyGraphicsState)) {
            return true;
        }

        if (isFontCheck && fontCheck(transparencyGraphicsState)) {
            return true;
        }

        return false;
    }

    private static boolean fontCheck(TransparencyGraphicsState graphicState) {
        GFPDFont font = graphicState.getVeraFont();
        if (font instanceof GFPDType3Font) {
            GFPDType3Font type3Font = (GFPDType3Font) font;
            Encoding encoding = type3Font.getEncodingMapping();
            if (encoding != null) {
                boolean result = false;
                Map<String, PDContentStream> charProcStreams = type3Font.getCharProcStreams();
                for (byte glyphCode : graphicState.getCharCodes()) {
                    String glyphName = encoding.getName(glyphCode);
                    GFPDContentStream glyphStream = (GFPDContentStream) charProcStreams.get(glyphName);
                    if (glyphStream != null) {
                        result |= glyphStream.isContainsTransparency();
                    }
                }
                return result;
            }
        }
        return false;
    }

    private boolean colorSpaceCheck(TransparencyGraphicsState graphicState) {
        if (isFillCheck) {
            GFPDColorSpace fillCS = graphicState.getVeraFillColorSpace();
            if (fillCS instanceof GFPDTilingPattern && ((GFPDTilingPattern) fillCS).isContainsTransparency()) {
                return true;
            }
        }
        if (isStrokeCheck) {
            GFPDColorSpace strokeCS = graphicState.getVeraStrokeColorSpace();
            if (strokeCS instanceof GFPDTilingPattern && ((GFPDTilingPattern) strokeCS).isContainsTransparency()) {
                return true;
            }
        }
        return false;
    }

    private static boolean baseCheck(TransparencyGraphicsState graphicState) {
        COSObject sMask = graphicState.getSMask();
        if (sMask != null && sMask.getType().isDictionaryBased()) {
            return true;
        }

        COSObject bm = graphicState.getBm();
        if (bm != null) {
            if (bm.getType() == COSObjType.COS_NAME) {
                if (!ASAtom.NORMAL.equals(bm.getName())) {
                    return true;
                }
            } else if (bm.getType() == COSObjType.COS_ARRAY) {
                COSArray bmArray = (COSArray) bm.getDirectBase();
                if (bmArray.size() != 1) {
                    return true;
                }
				COSObject bmValue = bmArray.at(0);
				if (bmValue != null && bmValue.getType() == COSObjType.COS_NAME &&
                    !ASAtom.NORMAL.equals(bmValue.getName())) {
				    return true;
				}
            } else {
                return !bm.empty() && bm.getType() != COSObjType.COS_NULL;
            }
        }
        return false;
    }

    private static boolean xObjectContainsTransparency(GFPDXObject xobj) {
        if (xobj instanceof GFPDXForm) {
            return ((GFPDXForm) xobj).containsTransparency();
        } else if (xobj instanceof GFPDXImage) {
            return ((GFPDXImage) xobj).containsTransparency();
        }
        return false;
    }
}
