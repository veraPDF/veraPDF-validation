package org.verapdf.model.impl.pd.font;

import org.verapdf.model.baselayer.Object;
import org.verapdf.model.factory.operators.RenderingMode;
import org.verapdf.model.pdlayer.PDCIDFont;
import org.verapdf.model.pdlayer.PDCMap;
import org.verapdf.model.pdlayer.PDType0Font;

import java.util.Collections;
import java.util.List;

/**
 * Represents Type0 font dictionary.
 * //TODO: write doc
 *
 * @author Sergey Shemyakov
 */
public class GFPDType0Font extends GFPDFont implements PDType0Font {

    public static final String TYPE_0_FONT_TYPE = "PDType0Font";

    public static final String DESCENDANT_FONTS = "DescendantFonts";
    public static final String ENCODING = "Encoding";

    public GFPDType0Font(org.verapdf.pd.PDFont font, RenderingMode renderingMode) {
        super(font, renderingMode, TYPE_0_FONT_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case DESCENDANT_FONTS:
                return this.getDescendantFonts();
            case ENCODING:
                return this.getEncoding();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<PDCIDFont> getDescendantFonts() {
        return Collections.emptyList();     // TODO: fix
    }

    private List<PDCMap> getEncoding() {
        return Collections.emptyList();     // TODO: fix
    }

    @Override
    public Boolean getareRegistryOrderingCompatible() {
        return Boolean.valueOf(false);      // TODO: fix
    }

    @Override
    public Boolean getisSupplementCompatible() {
        return Boolean.valueOf(false);      // TODO: fix
    }

    @Override
    public String getcmapName() {
        return "";      // TODO: fix
    }
}
