package org.verapdf.gf.model.impl.external;

import org.verapdf.gf.model.impl.pd.font.GFPDFont;
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
    private String id;

    public GFFontProgram(org.verapdf.pd.font.FontProgram fontProgram,
                         GFPDFont font) {
        super(FONT_PROGRAM_TYPE);
        this.fontProgram = fontProgram;
        this.id = font.getID() + " font program";
    }

    @Override
    public String getID() {
        return this.id;
    }
}
