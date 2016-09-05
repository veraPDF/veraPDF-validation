package org.verapdf.model.impl.pd.font;

import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSStream;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.external.CMapFile;
import org.verapdf.model.impl.external.GFCMapFile;
import org.verapdf.model.impl.pd.GFPDObject;
import org.verapdf.model.pdlayer.PDCMap;

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
    private List<PDCMap> getUseCMap() {
        COSObject useCMap = this.pdcMap.getUseCMap();
        if (useCMap.empty()) {
            return Collections.emptyList();
        }
        List<PDCMap> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
        list.add(new GFPDCmap(new org.verapdf.pd.font.cmap.PDCMap(useCMap)));
        return Collections.unmodifiableList(list);
    }
}
