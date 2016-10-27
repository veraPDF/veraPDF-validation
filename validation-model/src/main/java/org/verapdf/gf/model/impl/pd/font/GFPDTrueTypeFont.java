package org.verapdf.gf.model.impl.pd.font;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.factory.operators.RenderingMode;
import org.verapdf.model.pdlayer.PDTrueTypeFont;
import org.verapdf.pd.font.FontProgram;
import org.verapdf.pd.font.opentype.OpenTypeFontProgram;
import org.verapdf.pd.font.truetype.AdobeGlyphList;
import org.verapdf.pd.font.truetype.TrueTypeFontProgram;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents TrueType font dictionary.
 *
 * @author Sergey Shemyakov
 */
public class GFPDTrueTypeFont extends GFPDSimpleFont implements PDTrueTypeFont {

    private static final Logger LOGGER = Logger.getLogger(GFPDTrueTypeFont.class.getCanonicalName());

    public static final String TRUETYPE_FONT_TYPE = "PDTrueTypeFont";

    public GFPDTrueTypeFont(org.verapdf.pd.font.truetype.PDTrueTypeFont font,
                            RenderingMode renderingMode) {
        super(font, renderingMode, TRUETYPE_FONT_TYPE);
        if (font != null) {
            FontProgram program = font.getFontProgram();
            if (program != null) {
                try {
                    program.parseFont();
                    this.fontProgramParsed = true;
                    this.pdFont.setSuccessfullyParsed(true);
                } catch (IOException e) {
                    LOGGER.log(Level.WARNING, "Can't parse font program of font " + font.getName());
                    this.fontProgramParsed = false;
                    this.pdFont.setSuccessfullyParsed(false);
                }
            }
        }
    }

    /**
     * @return true if all glyph names in the differences array of the Encoding
     * dictionary are a part of the Adobe Glyph List and the embedded font
     * program contains the Microsoft Unicode (3,1 - Platform ID=3,
     * Encoding ID=1) cmap subtable.
     */
    @Override
    public Boolean getdifferencesAreUnicodeCompliant() {
        if (!fontProgramParsed) {
            return Boolean.valueOf(false);
        }

        FontProgram font = this.pdFont.getFontProgram();
        if ((font instanceof OpenTypeFontProgram)) {
            font = ((OpenTypeFontProgram) font).getFont();
        }
        if (!((TrueTypeFontProgram) font).isCmapPresent(3, 1)) {
            return Boolean.valueOf(false);
        }
        COSObject encoding = this.pdFont.getEncoding();
        if (!encoding.empty() && encoding.getType() != COSObjType.COS_NAME) {
            COSObject differences = encoding.getKey(ASAtom.DIFFERENCES);
            if (!differences.empty()) {
                for (COSObject diff : (COSArray) differences.getDirectBase()) {
                    if (diff.getType() == COSObjType.COS_NAME &&
                            !AdobeGlyphList.contains(diff.getString())) {
                        return Boolean.valueOf(false);
                    }
                }
            }
        }

        return Boolean.valueOf(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getisStandard() {
        return Boolean.valueOf(false);
    }
}
