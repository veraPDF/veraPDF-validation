package org.verapdf.model.impl.pd.font;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosStream;
import org.verapdf.model.factory.operators.RenderingMode;
import org.verapdf.model.pdlayer.PDCIDFont;
import org.verapdf.pd.PDFont;

import java.util.Collections;
import java.util.List;

/**
 * Represents CID Font dictionary.
 * //TODO: write doc
 *
 * @author Sergey Shemyakov
 */
public class GFPDCIDFont extends GFPDFont implements PDCIDFont {

    public static final String CID_FONT_TYPE = "PDCIDFont";

    public static final String CID_SET = "CIDSet";

    public static final String IDENTITY = "Identity";
    public static final String CUSTOM = "Custom";

    public GFPDCIDFont(PDFont font, RenderingMode renderingMode) {
        super(font, renderingMode, CID_FONT_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (CID_SET.equals(link)) {
            return this.getCIDSet();
        }
        return super.getLinkedObjects(link);
    }

    private List<CosStream> getCIDSet() {

        return Collections.emptyList(); // TODO: fix
    }

    @Override
    public String getCIDToGIDMap() {
        COSObject cidToGidObject = this.pdFont.getDictionary().getKey(
                ASAtom.CID_TO_GID_MAP);
        if(cidToGidObject.getType() == COSObjType.COS_STREAM) {
            return CUSTOM;
        }
        if(cidToGidObject.getType() == COSObjType.COS_NAME &&
                IDENTITY.equals(cidToGidObject.getString())) {
            return IDENTITY;
        }
        return null;
    }

    @Override
    public Boolean getcidSetListsAllGlyphs() {
        return Boolean.valueOf(true);   // TODO: fix
    }
}
