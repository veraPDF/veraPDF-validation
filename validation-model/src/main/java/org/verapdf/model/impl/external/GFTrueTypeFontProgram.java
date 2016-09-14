package org.verapdf.model.impl.external;

import org.apache.log4j.Logger;
import org.verapdf.model.external.TrueTypeFontProgram;
import org.verapdf.pd.font.FontProgram;
import org.verapdf.pd.font.opentype.OpenTypeFontProgram;

import java.io.IOException;

/**
 * Instance of this class represents TrueType font program embedded into PDF
 * document.
 *
 * @author Sergey Shemyakov
 */
public class GFTrueTypeFontProgram extends GFFontProgram implements TrueTypeFontProgram {

    private static final Logger LOGGER = Logger.getLogger(GFTrueTypeFontProgram.class);

    private org.verapdf.pd.font.truetype.TrueTypeFontProgram trueTypeFont;

    /**
     * Type name for GFTrueTypeFontProgram
     */
    public static final String TRUE_TYPE_PROGRAM_TYPE = "TrueTypeFontProgram";

    public GFTrueTypeFontProgram(FontProgram trueTypeFont) {
        super(TRUE_TYPE_PROGRAM_TYPE);
        try {
            if (trueTypeFont instanceof OpenTypeFontProgram) {
                this.trueTypeFont = (org.verapdf.pd.font.truetype.TrueTypeFontProgram)
                        ((OpenTypeFontProgram) trueTypeFont).getFont();
            }
            this.trueTypeFont = (org.verapdf.pd.font.truetype.TrueTypeFontProgram) trueTypeFont;
            this.trueTypeFont.parseFont();
        } catch (IOException e) {
            LOGGER.error("Error in parsing embedded True Type font file", e);
        }
    }

    /**
     * @return true / false if the corresponding PDF Font is marked as
     * symbolic / non-symbolic in its font dictionary.
     */
    @Override
    public Boolean getisSymbolic() {
        return this.trueTypeFont.isSymbolic();
    }

    /**
     * @return number of cmap subtables in the font program.
     */
    @Override
    public Long getnrCmaps() {
        return new Long(this.trueTypeFont.getCmapEncodingPlatform().length);
    }

    /**
     * @return true if the font program contains the Microsoft Symbol
     * (3,0 – Platform ID=3, Encoding ID=0) cmap subtable.
     */
    @Override
    public Boolean getcmap30Present() {
        return this.trueTypeFont.isCmapPresent(3, 0);
    }
}
