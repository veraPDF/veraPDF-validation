/**
 * This file is part of validation-model, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * validation-model is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with validation-model as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * validation-model as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.pd.font;

import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSStream;
import org.verapdf.gf.model.impl.external.GFCMapFile;
import org.verapdf.gf.model.impl.pd.GFPDObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.external.CMapFile;
import org.verapdf.model.pdlayer.PDCMap;
import org.verapdf.model.pdlayer.PDReferencedCMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents CMap dictionary or one of the predefined CMap names.
 *
 * @author Sergey Shemyakov
 */
public class GFPDCmap extends GFPDObject implements PDCMap {

    public static final String CMAP_TYPE = "PDCMap";
    public static final String EMBEDDED_FILE = "embeddedFile";
    public static final String USE_C_MAP = "UseCMap";

    public GFPDCmap(org.verapdf.pd.font.cmap.PDCMap pdcMap) {
        super(pdcMap, CMAP_TYPE);
    }

    public GFPDCmap(org.verapdf.pd.font.cmap.PDCMap pdcMap, String type) {
        super(pdcMap, type);
    }

    /**
     * @return name of the CMap (or the value of one of the predefined CMap's).
     */
    @Override
    public String getCMapName() {
        return this.pdcMap.getCMapName();
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case EMBEDDED_FILE:
                return this.getEmbeddedFile();
            case USE_C_MAP:
                return this.getUseCMap();
            default:
                return super.getLinkedObjects(link);
        }
    }

    /**
     * @return link to the embedded CMap file for an non-standard CMap.
     */
    private List<CMapFile> getEmbeddedFile() {
        if (this.pdcMap.getcMap().getType() == COSObjType.COS_STREAM) {
            List<CMapFile> result = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            result.add(new GFCMapFile((COSStream) this.pdcMap.getcMap().getDirectBase()));
            return Collections.unmodifiableList(result);
        }
        return Collections.emptyList();
    }

    /**
     * @return link to the CMap referenced by the key /UseCMap.
     */
    private List<PDReferencedCMap> getUseCMap() {
        COSObject useCMap = this.pdcMap.getUseCMap();
        if (useCMap.empty()) {
            return Collections.emptyList();
        }
        List<PDReferencedCMap> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
        list.add(new GFPDReferencedCMap(new org.verapdf.pd.font.cmap.PDCMap(useCMap)));
        return Collections.unmodifiableList(list);
    }
}
