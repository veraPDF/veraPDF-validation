package org.verapdf.model.impl.pd.font;

import org.apache.log4j.Logger;
import org.verapdf.as.ASAtom;
import org.verapdf.model.factory.operators.RenderingMode;
import org.verapdf.model.pdlayer.PDType1Font;
import org.verapdf.pd.font.FontProgram;
import org.verapdf.pd.font.cff.CFFFontProgram;
import org.verapdf.pd.font.cff.CFFType1FontProgram;
import org.verapdf.pd.font.opentype.OpenTypeFontProgram;
import org.verapdf.pd.font.type1.Type1FontProgram;

import java.io.IOException;
import java.util.Set;

/**
 * Represents Type1 font dictionary.
 *
 * @author Sergey Shemyakov
 */
public class GFPDType1Font extends GFPDSimpleFont implements PDType1Font {

    private static final Logger LOGGER = Logger.getLogger(GFPDType1Font.class);

    public static final String TYPE1_FONT_TYPE = "PDType1Font";

    public static final String NOTDEF_STRING = ".notdef";

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
        return res;
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
                    ((Type1FontProgram) this.pdFont.getFontProgram()).getCharSet();
        } else if (this.pdFont.getFontProgram() instanceof CFFFontProgram) {
            // Type1 program is contained inside CFF program.
            fontProgramCharSet = ((CFFType1FontProgram)
                    ((CFFFontProgram)
                            this.pdFont.getFontProgram()).getFont()).getCharSet();
        } else if (this.pdFont.getFontProgram() instanceof OpenTypeFontProgram) {
            // Type1 program is contained inside CFF program that is contained
            // inside OpenType program.
            CFFFontProgram cff = (CFFFontProgram)
                    ((OpenTypeFontProgram) this.pdFont.getFontProgram()).getFont();
            fontProgramCharSet = ((CFFType1FontProgram)
                    (cff.getFont())).getCharSet();
        } else {
            fontProgramCharSet = new String[] {};
        }
        if (!(descriptorCharSet.size() == fontProgramCharSet.length ||
            descriptorCharSet.size() == fontProgramCharSet.length - 1) ) {
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
        return ((org.verapdf.pd.font.type1.PDType1Font) this.pdFont).isStandard();
    }
}
