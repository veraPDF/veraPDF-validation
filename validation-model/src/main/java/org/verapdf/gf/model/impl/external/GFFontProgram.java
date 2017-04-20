/**
 * This file is part of validation-model, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * validation-model is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with validation-model as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * validation-model as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
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

    private String id;
    private org.verapdf.pd.font.FontProgram fontProgram;

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
