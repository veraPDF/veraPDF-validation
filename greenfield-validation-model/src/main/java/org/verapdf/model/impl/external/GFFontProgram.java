package org.verapdf.model.impl.external;

import org.verapdf.model.external.FontProgram;

/**
 * Instance of this class represents embedded font program.
 *
 * @author Sergey Shemyakov
 */
public class GFFontProgram extends GFExternal implements FontProgram {

    protected GFFontProgram(String type) {
        super(type);
    }
}
