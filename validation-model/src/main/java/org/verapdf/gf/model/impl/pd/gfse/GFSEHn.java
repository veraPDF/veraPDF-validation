/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2025, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.pd.GFPDStructElem;
import org.verapdf.model.selayer.SEHn;
import org.verapdf.pd.structure.PDStructElem;

public class GFSEHn extends GFPDStructElem implements SEHn {

    public static final String HN_STRUCTURE_ELEMENT_TYPE = "SEHn";

    public GFSEHn(PDStructElem structElemDictionary, String standardType) {
        super(structElemDictionary, standardType, HN_STRUCTURE_ELEMENT_TYPE);
    }

    @Override
    public Boolean gethasCorrectNestingLevel() {
        int nestingLevel = Integer.parseInt(getstandardType().substring(1));
        if (nestingLevel > StaticContainers.getLastHeadingNestingLevel() + 1) {
            StaticContainers.setLastHeadingNestingLevel(nestingLevel);
            return false;
        }
        StaticContainers.setLastHeadingNestingLevel(nestingLevel);
        return true;
    }

    @Override
    public Long getnestingLevel() {
        return Long.parseLong(getstandardType().substring(1));
    }
}
