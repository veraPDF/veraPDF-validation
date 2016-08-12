package org.verapdf.model.impl.external;

import org.apache.log4j.Logger;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSStream;
import org.verapdf.font.truetype.TrueTypeFont;
import org.verapdf.model.external.TrueTypeFontProgram;

import java.io.IOException;

/**
 * Instance of this class represents TrueType font program embedded into PDF
 * document.
 *
 * @author Sergey Shemyakov
 */
public class GFTrueTypeFontProgram extends GFFontProgram implements TrueTypeFontProgram {

    private static final Logger LOGGER = Logger.getLogger(GFTrueTypeFontProgram.class);

    private TrueTypeFont trueTypeFont;

    /**
     * Type name for GFTrueTypeFontProgram
     */
    public static final String TRUE_TYPE_PROGRAM_TYPE = "TrueTypeFontProgram";

    public GFTrueTypeFontProgram(COSStream trueTypeStream, boolean isSymbolic,
                                 COSObject encoding) {
        super(TRUE_TYPE_PROGRAM_TYPE);
        try {
            this.trueTypeFont = new TrueTypeFont(trueTypeStream.getData(
                    COSStream.FilterFlags.DECODE), isSymbolic, encoding);
            this.trueTypeFont.parseFont();
        } catch (IOException e) {
            LOGGER.error("Error in parsing embedded True Type font file");
            e.printStackTrace();
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
