package org.verapdf.model.impl.pd.font;

import org.apache.log4j.Logger;
import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSObjType;
import org.verapdf.model.factory.operators.RenderingMode;
import org.verapdf.model.pdlayer.PDType1Font;
import org.verapdf.pd.font.FontProgram;
import org.verapdf.pd.font.cff.CFFFontProgram;
import org.verapdf.pd.font.cff.CFFType1FontProgram;
import org.verapdf.pd.font.opentype.OpenTypeFontProgram;
import org.verapdf.pd.font.truetype.TrueTypePredefined;
import org.verapdf.pd.font.type1.Type1FontProgram;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * Represents Type1 font dictionary.
 *
 * @author Sergey Shemyakov
 */
public class GFPDType1Font extends GFPDSimpleFont implements PDType1Font {

    private static final Logger LOGGER = Logger.getLogger(GFPDType1Font.class);

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
    public static final String NOTDEF_STRING = ".notdef";
    private boolean fontProgramParsed;

    public GFPDType1Font(org.verapdf.pd.font.type1.PDType1Font pdFont,
                         RenderingMode renderingMode) {
        super(pdFont, renderingMode, TYPE1_FONT_TYPE);
        if (pdFont != null) {
            FontProgram program = pdFont.getFontProgram();
            if (program != null) {
                try {
                    program.parseFont();
                    this.fontProgramParsed = true;
                } catch (IOException e) {
                    LOGGER.warn("Can't parse font program of font " + pdFont.getName());
                    this.fontProgramParsed = false;
                }
            }
        }
    }

    /**
     * @return the value of the CharSet entry in the font descriptor dictionary.
     */
    @Override
    public String getCharSet() {
        String res = this.pdFont.getFontDescriptor().getStringKey(ASAtom.CHAR_SET);
        return res == null ? "" : res;
    }

    /**
     * @return true if the CharSet is present and correctly lists all glyphs
     * present in the embedded font program.
     */
    @Override
    public Boolean getcharSetListsAllGlyphs() {
        if (!fontProgramParsed) {
            return Boolean.valueOf(false);
        }

        Set<String> descriptorCharSet = ((org.verapdf.pd.font.type1.PDType1Font)
                this.pdFont).getDescriptorCharSet();
        String[] fontProgramCharSet;
        if (this.pdFont.getFontProgram() instanceof Type1FontProgram) {
            fontProgramCharSet =
                    ((Type1FontProgram) this.pdFont.getFontProgram()).getEncoding();
        } else if (this.pdFont.getFontProgram() instanceof CFFFontProgram) {
            // Type1 program is contained inside CFF program.
            fontProgramCharSet = ((CFFType1FontProgram)
                    ((CFFFontProgram)
                            this.pdFont.getFontProgram()).getFont()).getEncoding();
        } else if (this.pdFont.getFontProgram() instanceof OpenTypeFontProgram) {
            // Type1 program is contained inside CFF program that is contained
            // inside OpenType program.
            CFFFontProgram cff = (CFFFontProgram)
                    ((OpenTypeFontProgram) this.pdFont.getFontProgram()).getFont();
            fontProgramCharSet = ((CFFType1FontProgram)
                    (cff.getFont())).getEncoding();
        } else {
            fontProgramCharSet = new String[] {};
        }
        if (!(descriptorCharSet.size() == fontProgramCharSet.length)) {
            return Boolean.valueOf(false);
        }
        for (String glyphName : fontProgramCharSet) {
            if (!glyphName.equals(NOTDEF_STRING) &&
                    !descriptorCharSet.contains(glyphName)) {
                return Boolean.valueOf(false);
            }
        }
        return Boolean.valueOf(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getisStandard() {
        if (isStandard != null) {
            return isStandard;
        }
        if (!containsDiffs() && !isEmbedded() && isNameStandard()) {
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
            Map<Integer, String> differences = this.pdFont.getDifferences();
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
        return this.pdFont.getFontProgram() == null;
    }

    private boolean isNameStandard() {
        ASAtom fontName = this.pdFont.getDictionary().getNameKey(ASAtom.BASE_FONT);
        for (ASAtom standard : STANDARD_FONT_NAMES) {
            if (standard == fontName) {
                return true;
            }
        }
        return false;
    }
}
