package org.verapdf.model.impl.pd.font;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.*;
import org.verapdf.font.truetype.TrueTypePredefined;
import org.verapdf.model.factory.operators.RenderingMode;
import org.verapdf.model.pdlayer.PDType1Font;
import org.verapdf.pd.PDFont;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents Type1 font dictionary.
 * //TODO: write doc
 *
 * @author Sergey Shemyakov
 */
public class GFPDType1Font extends GFPDSimpleFont implements PDType1Font {

    public static final String TYPE1_FONT_TYPE = "PDType1Font";
    public static final ASAtom[] STANDARD_FONT_NAMES = {
            ASAtom.COURIER_BOLD,
            ASAtom.COURIER_BOLD_OBLIQUE,
            ASAtom.COURIER,
            ASAtom.COURIER_OBLIQUE,
            ASAtom.HELVETICA,
            ASAtom.HELVETICA_BOLD,
            ASAtom.HELVETICA_BOLD_OBLIQUE,
            ASAtom.HELVETICA_OBLIQUE,
            ASAtom.SYMBOL,
            ASAtom.TIMES_BOLD,
            ASAtom.TIMES_BOLD_ITALIC,
            ASAtom.TIMES_ITALIC,
            ASAtom.TIMES_ROMAN,
            ASAtom.ZAPF_DINGBATS};

    private Boolean isStandard = null;

    public GFPDType1Font(PDFont pdFont, RenderingMode renderingMode) {
        super(pdFont, renderingMode, TYPE1_FONT_TYPE);
    }

    /**
     * @return the value of the CharSet entry in the font descriptor dictionary.
     */
    @Override
    public String getCharSet() {
        String res = this.pdFont.getFontDescriptor().getStringKey(ASAtom.CHAR_SET);
        return res == null ? "" : res;
    }

    @Override
    public Boolean getcharSetListsAllGlyphs() {
        return Boolean.valueOf(false);      // TODO: fix
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getisStandard() {
        if(isStandard != null) {
            return isStandard;
        }
        if(!containsDiffs() && !isEmbedded() && isNameStandard()) {
            isStandard = Boolean.valueOf(true);
            return isStandard;
        } else {
            isStandard = Boolean.valueOf(false);
            return isStandard;
        }
    }

    private boolean containsDiffs() {
        if (this.pdFont.getDictionary().getKey(ASAtom.ENCODING).getType() ==
                COSObjType.COS_DICT) {
            Map<Integer, String> differences = getDifferences((COSDictionary)
                    this.pdFont.getDictionary().getKey(ASAtom.ENCODING).get());
            if (differences != null && differences.size() != 0) {
                String[] baseEncoding = getBaseEncoding((COSDictionary)
                        this.pdFont.getDictionary().getKey(ASAtom.ENCODING).get());
                if (baseEncoding.length == 0) {
                    return true;
                }
                for (Map.Entry<Integer, String> entry : differences.entrySet()) {
                    if (!entry.getValue().equals(baseEncoding[entry.getKey()])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private Map<Integer, String> getDifferences(COSDictionary encoding) {
        COSArray differences = (COSArray) encoding.getKey(ASAtom.DIFFERENCES).get();
        if (differences == null) {
            return null;
        }
        Map<Integer, String> res = new HashMap<>();
        int diffIndex = 0;
        for (COSObject obj : differences) {
            if (obj.getType() == COSObjType.COS_INTEGER) {
                diffIndex = obj.getInteger().intValue();
            } else if (obj.getType() == COSObjType.COS_NAME && diffIndex != -1) {
                res.put(diffIndex++, obj.getString());
            }
        }
        return res;
    }

    private String[] getBaseEncoding(COSDictionary encoding) {
        ASAtom baseEncoding = encoding.getNameKey(ASAtom.BASE_ENCODING);
        if (baseEncoding == null) {
            return new String[]{};
        }
        if (baseEncoding == ASAtom.MAC_ROMAN_ENCODING) {
            return Arrays.copyOf(TrueTypePredefined.MAC_ROMAN_ENCODING,
                    TrueTypePredefined.MAC_ROMAN_ENCODING.length);
        } else if (baseEncoding == ASAtom.MAC_EXPERT_ENCODING) {
            return Arrays.copyOf(TrueTypePredefined.MAC_EXPERT_ENCODING,
                    TrueTypePredefined.MAC_EXPERT_ENCODING.length);
        } else if (baseEncoding == ASAtom.WIN_ANSI_ENCODING) {
            return Arrays.copyOf(TrueTypePredefined.WIN_ANSI_ENCODING,
                    TrueTypePredefined.WIN_ANSI_ENCODING.length);
        } else {
            return new String[]{};
        }
    }

    private boolean isEmbedded() {
        return this.pdFont.getFontFile() == null;
    }

    private boolean isNameStandard() {
        COSName fontName = (COSName) COSName.construct(
                this.pdFont.getDictionary().getNameKey(ASAtom.BASE_FONT)).get();
        for (ASAtom standard : STANDARD_FONT_NAMES) {
            if (standard == fontName.get()) {
                return true;
            }
        }
        return false;
    }
}
