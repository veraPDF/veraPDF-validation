package org.verapdf.model.impl.pd.font;

import org.verapdf.as.ASAtom;
import org.verapdf.model.factory.operators.RenderingMode;
import org.verapdf.model.pdlayer.PDType1Font;
import org.verapdf.pd.PDFont;

/**
 * Represents Type1 font dictionary.
 * //TODO: write doc
 *
 * @author Sergey Shemyakov
 */
public class GFPDType1Font extends GFPDSimpleFont implements PDType1Font {

    public static final String TYPE1_FONT_TYPE = "PDType1Font";

    public GFPDType1Font(PDFont pdFont, RenderingMode renderingMode) {
        super(pdFont, renderingMode, TYPE1_FONT_TYPE);
    }

    @Override
    public String getCharSet() {
        String res = this.pdFont.getFontDescriptor().getStringKey(ASAtom.CHAR_SET);
        return res == null ? "" : res;
    }

    @Override
    public Boolean getcharSetListsAllGlyphs() {
        return Boolean.valueOf(false);      // TODO: fix
    }
}
