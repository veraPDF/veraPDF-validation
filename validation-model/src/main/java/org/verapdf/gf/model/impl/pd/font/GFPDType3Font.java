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
package org.verapdf.gf.model.impl.pd.font;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.factory.operators.GraphicState;
import org.verapdf.gf.model.factory.operators.RenderingMode;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.pd.GFPDContentStream;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDContentStream;
import org.verapdf.model.pdlayer.PDType3Font;
import org.verapdf.pd.PDResources;
import org.verapdf.pd.font.type3.PDType3CharProc;
import org.verapdf.pd.structure.StructureElementAccessObject;
import org.verapdf.pdfa.flavours.PDFAFlavour;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents Type3 font dictionary.
 *
 * @author Sergey Shemyakov
 */
public class GFPDType3Font extends GFPDSimpleFont implements PDType3Font {

    private static final Logger LOGGER = Logger.getLogger(GFPDType3Font.class.getCanonicalName());

    public static final String TYPE3_FONT_TYPE = "PDType3Font";

    public static final String CHAR_STRINGS = "charStrings";
    private final PDResourcesHandler resources;
    private Map<String, PDContentStream> charStrings = null;
    private final GraphicState inheritedGraphicState;

    public GFPDType3Font(org.verapdf.pd.font.type3.PDType3Font font,
                         RenderingMode renderingMode, PDResourcesHandler resources,
                         GraphicState inheritedGraphicState) {
        super(font, renderingMode, TYPE3_FONT_TYPE);
        this.resources = resources;
        this.inheritedGraphicState = inheritedGraphicState;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getisStandard() {
        return Boolean.valueOf(false);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (CHAR_STRINGS.equals(link)) {
            return this.getCharStrings();
        }
        return super.getLinkedObjects(link);
    }

    /**
     * @return character strings.
     */
    private List<PDContentStream> getCharStrings() {
        if (this.charStrings == null) {
            parseCharStrings();
        }
        return new ArrayList<>(this.charStrings.values());
    }

    public Map<String, PDContentStream> getCharProcStreams() {
        if (this.charStrings == null) {
            parseCharStrings();
        }
        return Collections.unmodifiableMap(this.charStrings);
    }

    private void parseCharStrings() {
        COSDictionary charProcDict = ((org.verapdf.pd.font.type3.PDType3Font)
                this.pdFont).getCharProcDict();
        if (charProcDict != null) {
            Set<ASAtom> keySet = charProcDict.getKeySet();
            Map<String, PDContentStream> map = new HashMap<>(keySet.size());
            for (ASAtom glyphName : keySet) {
                COSObject charProcStream = charProcDict.getKey(glyphName);
                if (!charProcStream.empty() && charProcDict.getType() == COSObjType.COS_DICT) {
                    PDType3CharProc charProc = new PDType3CharProc(charProcStream);
                    PDResourcesHandler glyphResources = getResourcesFromCharProcs(charProcStream);
                    GFPDContentStream contentStream =
                            new GFPDContentStream(charProc, glyphResources == null ?
                                    this.resources : glyphResources, inheritedGraphicState,
                                    new StructureElementAccessObject(this.simpleCOSObject));
                    map.put(glyphName.getValue(), contentStream);
                } else {
                    LOGGER.log(Level.SEVERE, "Invalid entry in the char proc dictionary, dictionary is expected.");
                }
            }
            this.charStrings = Collections.unmodifiableMap(map);
        } else {
            this.charStrings = Collections.emptyMap();
        }
    }

    /**
     * PDF/A-4 validation should doesn't accept Resource dictionaries specified in the individual CharProc stream dictionaries
     */
    private PDResourcesHandler getResourcesFromCharProcs(COSObject charProcs) {
        if (!charProcs.knownKey(ASAtom.RESOURCES) ||
            StaticContainers.getFlavour().getPart() == PDFAFlavour.Specification.ISO_19005_4) {
            return null;
        }
        PDResources res = new PDResources(charProcs.getKey(ASAtom.RESOURCES));
        return PDResourcesHandler.getInstance(this.resources.getPageResources(), res);
    }
}
