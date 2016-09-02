package org.verapdf.model.impl.pd.font;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.model.factory.operators.RenderingMode;
import org.verapdf.model.pdlayer.PDSimpleFont;

/**
 * Represents one of the simple font types (Type 1, TrueType, Type 3).
 *
 * @author Sergey Shemyakov
 */
public abstract class GFPDSimpleFont extends GFPDFont implements PDSimpleFont {

    public static final String CUSTOM_ENCODING = "Custom";

    protected GFPDSimpleFont(org.verapdf.pd.PDFont font,
                             RenderingMode renderingMode, final String type) {
        super(font, renderingMode, type);
    }

    /**
     * @return true if the font is one of the 14 standard fonts defined in PDF
     * 1.4 Reference.
     */
    @Override
    public abstract Boolean getisStandard();

    /**
     * @return FirstChar entry; null if LastChar entry is not present or has
     * invalid type.
     */
    @Override
    public Long getFirstChar() {
        COSDictionary dict = this.pdFont.getDictionary();
        return dict.getIntegerKey(ASAtom.FIRST_CHAR);
    }

    /**
     * @return LastChar entry; null if LastChar entry is not present or has
     * invalid type.
     */
    @Override
    public Long getLastChar() {
        COSDictionary dict = this.pdFont.getDictionary();
        return dict.getIntegerKey(ASAtom.LAST_CHAR);
    }

    /**
     * @return The size of the Widths array; null if the Widths array is not
     * present or has invalid type.
     */
    @Override
    public Long getWidths_size() {
        COSDictionary dict = this.pdFont.getDictionary();
        COSObject widths = dict.getKey(ASAtom.WIDTHS);
        if (widths.empty() || widths.getType() != COSObjType.COS_ARRAY) {
            return null;
        }
        return (widths.get()).size().longValue();
    }

    /**
     * @return String representation of the font encoding:
     * null if the /Encoding entry is not present in the font dictionary;
     * if /Encoding entry in the font dictionary if of Name type, then
     * the value of this entry;
     * if /Encoding entry is a dictionary, which does not contain /Differences
     * array, then the value of /BaseEncoding entry in this dictionary
     * (or null, if /BaseEncoding is also not present);
     * the string "Custom", of the /Encoding entry is a dictionary containing
     * /Differences key.
     */
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
