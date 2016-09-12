package org.verapdf.model.impl.operator.textshow;

import org.verapdf.model.operator.CIDGlyph;
import org.verapdf.pd.font.PDFont;

/**
 * Represents glyph in the composite font.
 *
 * @author Sergey Shemyakov
 */
public class GFCIDGlyph extends GFGlyph implements CIDGlyph {

    public final static String CID_GLYPH_TYPE = "CIDGlyph";

    private int cid;

    public GFCIDGlyph(Boolean glyphPresent, Boolean widthsConsistent, PDFont font,
                      int glyphCode, int cid, int renderingMode) {
        super(glyphPresent, widthsConsistent, font, glyphCode, CID_GLYPH_TYPE,
                renderingMode);
        this.cid = cid;
    }

    @Override
    public Long getCID() {
        return Long.valueOf(this.cid);
    }
}
