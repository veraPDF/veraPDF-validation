package org.verapdf.model.impl.pd.font;

import org.verapdf.cos.COSObjType;
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
 * //TODO: write doc
 *
 * @author Sergey Shemyakov
 */
public class GFPDCmap extends GFPDObject implements PDCMap {

    public static final String CMAP_TYPE = "PDCMap";
    public static final String EMBEDDED_FILE = "embeddedFile";
    public static final String USE_C_MAP = "UseCMap";

    public GFPDCmap(org.verapdf.pd.PDCMap pdcMap) {
        super(pdcMap, CMAP_TYPE);
    }

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

    private List<CMapFile> getEmbeddedFile() {
        if (this.pdcMap.getcMap().getType() == COSObjType.COS_STREAM) {
            List<CMapFile> result = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            result.add(new GFCMapFile((COSStream) this.pdcMap.getcMap().getDirectBase()));
            return Collections.unmodifiableList(result);
        }
        return Collections.emptyList();
    }

    private List<PDCMap> getUseCMap() {
        return Collections.emptyList();     // TODO: fix
    }
}
