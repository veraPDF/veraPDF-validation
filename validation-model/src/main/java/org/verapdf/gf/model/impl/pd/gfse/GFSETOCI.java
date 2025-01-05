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

import org.verapdf.gf.model.impl.pd.GFPDStructElem;
import org.verapdf.model.selayer.SETOCI;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

import java.util.List;

public class GFSETOCI extends GFPDStructElem implements SETOCI {

    public static final String TOCI_STRUCTURE_ELEMENT_TYPE = "SETOCI";

    public GFSETOCI(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.TOCI, TOCI_STRUCTURE_ELEMENT_TYPE);
    }
    
    @Override
    public Boolean getcontainsRef() {
        return containsRef((PDStructElem)simplePDObject);
    }
    
    private boolean containsRef(PDStructElem elem) {
        if (elem.containsRef()) {
            return true;
        }
        List<PDStructElem> children = elem.getStructChildren();
        for (PDStructElem child : children) {
            if (containsRef(child)) {
                return true;
            }
        }
        return false;
    }
}
