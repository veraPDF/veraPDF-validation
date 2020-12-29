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
package org.verapdf.gf.model.impl.pd;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.*;
import org.verapdf.gf.model.factory.functions.FunctionFactory;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.cos.GFCosBM;
import org.verapdf.gf.model.impl.cos.GFCosNumber;
import org.verapdf.gf.model.impl.cos.GFCosRenderingIntent;
import org.verapdf.gf.model.impl.pd.functions.GFPDFunction;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosBM;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.coslayer.CosRenderingIntent;
import org.verapdf.model.pdlayer.PDExtGState;
import org.verapdf.model.pdlayer.PDHalftone;
import org.verapdf.pd.function.PDFunction;
import org.verapdf.pdfa.flavours.PDFAFlavour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Maksim Bezrukov
 */
public class GFPDExtGState extends GFPDResource implements PDExtGState {

    Logger LOGGER = Logger.getLogger(GFPDExtGState.class.getCanonicalName());

    public static final String EXT_G_STATE_TYPE = "PDExtGState";

    public static final String RI = "RI";
    public static final String BM = "BM";
    public static final String LINK_BM = "bm";
    public static final String FONT_SIZE = "fontSize";
    public static final String HALFTONE = "HT";
    public static final String CUSTOM_FUNCTIONS = "customFunctions";

    public GFPDExtGState(org.verapdf.pd.PDExtGState state) {
        super(state, EXT_G_STATE_TYPE);
    }

    @Override
    public String getTR() {
        return getStringProperty(((org.verapdf.pd.PDExtGState) simplePDObject).getCOSTR());
    }

    @Override
    public String getTR2() {
        return getStringProperty(((org.verapdf.pd.PDExtGState) simplePDObject).getCOSTR2());
    }

    @Override
    public String getSMask() {
        return getStringProperty(((org.verapdf.pd.PDExtGState) simplePDObject).getCOSSMask());
    }

    @Override
    public String getBM() {
        return getStringProperty(((org.verapdf.pd.PDExtGState) simplePDObject).getCOSBM());
    }

    private List<CosBM> getlinkBM() {
        COSObject BM = ((org.verapdf.pd.PDExtGState)simplePDObject).getCOSBM();
        if (BM == null || BM.empty() || BM.getType() == COSObjType.COS_NULL) {
            return Collections.emptyList();
        }
        if (StaticContainers.getFlavour().getPart() != PDFAFlavour.PDFA_4.getPart()) {
            if (BM.getType() == COSObjType.COS_ARRAY) {
                COSArray array = (COSArray)BM.getDirectBase();
                for (COSObject obj : array) {
                    if (obj.getType() == COSObjType.COS_NAME) {
                        BM = obj;
                        break;
                    }
                }
            }
        }
        if (BM.getType() == COSObjType.COS_NAME) {
            List<CosBM> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            list.add(new GFCosBM((COSName)BM.getDirectBase()));
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

    @Override
    public Double getca() {
        COSObject ca = ((org.verapdf.pd.PDExtGState) simplePDObject).getCA_NS();
        if (ca.getType().isNumber()) {
            return ca.getReal();
        } else if (ca.empty()) {
            return null;
        } else {
            LOGGER.log(Level.SEVERE, "Value of ca key is not a number. Ignoring ca");
            return 2.0; // check is failed
        }
    }

    @Override
    public Double getCA() {
        COSObject ca = ((org.verapdf.pd.PDExtGState) simplePDObject).getCA();
        if (ca.getType().isNumber()) {
            return ca.getReal();
        } else if (ca.empty()) {
            return null;
        } else {
            LOGGER.log(Level.SEVERE, "Value of CA key is not a number. Ignoring CA");
            return 2.0; // check is failed
        }
    }

    private static String getStringProperty(COSObject property) {
        if (property == null
                || property.empty()
                || property.getType() == COSObjType.COS_NULL) {
            return null;
        }

        if (property.getType() == COSObjType.COS_NAME) {
            return property.getName().getValue();
        }
		return property.toString();
    }

    @Override
    public Boolean getcontainsHTP() {
        return this.simplePDObject.knownKey(ASAtom.HTP);
    }

    @Override
    public Boolean getcontainsHTO() {
        return this.simplePDObject.knownKey(ASAtom.HTO);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case RI:
                return this.getRI();
            case FONT_SIZE:
                return this.getFontSize();
            case HALFTONE:
                return this.getHalftone();
            case CUSTOM_FUNCTIONS:
                return this.getCustomFunctions();
            case LINK_BM:
                return this.getlinkBM();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<CosRenderingIntent> getRI() {
        COSName renderingIntent = ((org.verapdf.pd.PDExtGState) this.simplePDObject)
                .getCOSRenderingIntentName();
        if (renderingIntent != null) {
            List<CosRenderingIntent> renderingIntents = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            renderingIntents.add(new GFCosRenderingIntent(renderingIntent));
            return Collections.unmodifiableList(renderingIntents);
        }
        return Collections.emptyList();
    }

    private List<CosNumber> getFontSize() {
        COSNumber fontSize = ((org.verapdf.pd.PDExtGState) this.simplePDObject)
                .getCOSFontSize();
        if (fontSize != null) {
            List<CosNumber> result = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            result.add(GFCosNumber.fromPDFParserNumber(fontSize));
            return Collections.unmodifiableList(result);
        }

        return Collections.emptyList();
    }

    private List<PDHalftone> getHalftone() {
        org.verapdf.pd.PDHalftone halftone = ((org.verapdf.pd.PDExtGState) simplePDObject).getHalftone();
        if (halftone != null) {
            List<PDHalftone> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            list.add(new GFPDHalftone(halftone));
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

    private List<GFPDFunction> getCustomFunctions() {
        org.verapdf.pd.PDExtGState extGState = (org.verapdf.pd.PDExtGState) this.simplePDObject;
        List<GFPDFunction> result = new ArrayList<>();
        for (PDFunction function : extGState.getTRFunctions()) {
            result.add(FunctionFactory.createFunction(function));
        }
        for (PDFunction function : extGState.getTR2Functions()) {
            result.add(FunctionFactory.createFunction(function));
        }
        return Collections.unmodifiableList(result);
    }
}
