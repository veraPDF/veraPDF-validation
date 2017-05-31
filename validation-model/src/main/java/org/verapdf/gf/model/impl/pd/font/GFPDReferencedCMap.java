package org.verapdf.gf.model.impl.pd.font;

import org.verapdf.model.pdlayer.PDReferencedCMap;
import org.verapdf.pd.font.cmap.PDCMap;

/**
 * @author Sergey Shemyakov
 */
public class GFPDReferencedCMap extends GFPDCmap implements PDReferencedCMap {

    public static final String REFERENCED_CMAP_TYPE = "PDReferencedCMap";

    public GFPDReferencedCMap(PDCMap pdcMap) {
        super(pdcMap, REFERENCED_CMAP_TYPE);
    }
}
