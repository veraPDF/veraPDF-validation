package org.verapdf.model.impl.external;

import org.verapdf.model.external.FontProgram;

/**
 * Instance of this class represents embedded font program.
 *
 * @author Sergey Shemyakov
 */
public class GFFontProgram extends GFExternal implements FontProgram {

    public static final String FONT_PROGRAM_TYPE = "FontProgram";

    protected GFFontProgram(String type) {
        super(type);
    }

    /**
     * This constructor is in fact a dummy. Method getFontFile in PDFont must
     * return FontProgram, and something is needed for fonts that are not True
     * Type.
     */
    public GFFontProgram() {
        super(FONT_PROGRAM_TYPE);
    }
}
