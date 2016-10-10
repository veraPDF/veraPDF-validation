package org.verapdf.gf.model.impl.external;

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

    private org.verapdf.pd.font.FontProgram fontProgram;

    public GFFontProgram(org.verapdf.pd.font.FontProgram fontProgram) {
        super(FONT_PROGRAM_TYPE);
        this.fontProgram = fontProgram;
    }
}
