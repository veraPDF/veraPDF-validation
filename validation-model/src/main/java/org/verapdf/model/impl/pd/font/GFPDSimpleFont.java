package org.verapdf.model.impl.pd.font;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.model.factory.operators.RenderingMode;
import org.verapdf.model.pdlayer.PDSimpleFont;

/**
 * Represents one of the simple font types (Type 1, TrueType, Type 3).
 * //TODO: write doc
 *
 * @author Sergey Shemyakov
 */
public class GFPDSimpleFont extends GFPDFont implements PDSimpleFont {

    public static final String CUSTOM_ENCODING = "Custom";

    protected GFPDSimpleFont(org.verapdf.pd.PDFont font,
                             RenderingMode renderingMode, final String type) {
        super(font, renderingMode, type);
    }

    @Override
    public Boolean getisStandard() {
        return Boolean.valueOf(false);  // TODO: fix this
    }

    @Override
    public Long getFirstChar() {
        COSDictionary dict = this.pdFont.getDictionary();
        return dict.getIntegerKey(ASAtom.FIRST_CHAR);   // TODO: case of standard 14 fonts
    }

    @Override
    public Long getLastChar() {
        COSDictionary dict = this.pdFont.getDictionary();
        return dict.getIntegerKey(ASAtom.LAST_CHAR);   // TODO: case of standard 14 fonts
    }

    @Override
    public Long getWidths_size() {
        COSDictionary dict = this.pdFont.getDictionary();
        COSObject widths = dict.getKey(ASAtom.WIDTHS);
        return ((COSArray) widths.get()).size().longValue();
    }

    @Override
    public String getEncoding() {
        COSDictionary dict = this.pdFont.getDictionary();
        COSObject encoding = dict.getKey(ASAtom.ENCODING);
        if (encoding == COSObject.getEmpty()) {
            return null;
        }
        if (encoding.getType() == COSObjType.COS_NAME) {
            return encoding.getString();
        }
        if (encoding.knownKey(ASAtom.DIFFERENCES)) {
            return CUSTOM_ENCODING;
        }
        COSObject baseEncoding = encoding.getKey(ASAtom.BASE_ENCODING);
        if (baseEncoding == COSObject.getEmpty()) {
            return null;
        }
        return baseEncoding.getString();
    }
}
