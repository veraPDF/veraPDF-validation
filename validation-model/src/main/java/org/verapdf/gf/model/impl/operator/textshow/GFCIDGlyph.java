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
package org.verapdf.gf.model.impl.operator.textshow;

import org.verapdf.gf.model.impl.operator.markedcontent.GFOpMarkedContent;
import org.verapdf.model.operator.CIDGlyph;
import org.verapdf.pd.font.PDFont;
import org.verapdf.pd.font.PDType0Font;
import org.verapdf.pd.structure.StructureElementAccessObject;

/**
 * Represents glyph in the composite font.
 *
 * @author Sergey Shemyakov
 */
public class GFCIDGlyph extends GFGlyph implements CIDGlyph {

    public final static String CID_GLYPH_TYPE = "CIDGlyph";

    private int cid;

    protected GFCIDGlyph(PDFont font, int glyphCode, int renderingMode, String id,
                      GFOpMarkedContent markedContent, StructureElementAccessObject structureElementAccessObject) {
        super(font, glyphCode, CID_GLYPH_TYPE, renderingMode, id, markedContent, structureElementAccessObject);
        this.cid = ((PDType0Font) font).toCID(glyphCode);
    }

    @Override
    public Long getCID() {
        return Long.valueOf(this.cid);
    }
}
