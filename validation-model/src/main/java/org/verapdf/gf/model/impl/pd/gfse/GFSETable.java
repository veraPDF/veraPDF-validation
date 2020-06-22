/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
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
import org.verapdf.model.selayer.SETable;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

import java.util.List;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;

public class GFSETable extends GFSEGeneral implements SETable {

    public static final String TABLE_STRUCTURE_ELEMENT_TYPE = "SETable";

    public GFSETable(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.TABLE, TABLE_STRUCTURE_ELEMENT_TYPE);
    }

    // This logic checks that all TH have Scope attribute or TD reference to TH ID using Headers
    @Override
    public Boolean getuseHeadersAndIdOrScope() {
        Stack<org.verapdf.model.pdlayer.PDStructElem> stack = new Stack<>();
        Boolean hasScope = true;
        Boolean hasID = true;
        Set<String> idSet = new HashSet<>();
        Set<String> headersSet = new HashSet<>();
        stack.push(this);
        while (!stack.empty()) {
            org.verapdf.model.pdlayer.PDStructElem elem = stack.pop();
            String type = elem.getstandardType();
            if (TaggedPDFConstants.TD.equals(type)) {
                List<String> list = ((GFSETD)elem).getHeaders();
                if (list != null) {
                    headersSet.addAll(list);
                }
            } else if (TaggedPDFConstants.TH.equals(type)) {
                List<String> list = ((GFSETH)elem).getHeaders();
                if (list != null) {
                    headersSet.addAll(list);
                }
                String id = ((GFSETH)elem).getTHID();
                if (id == null) {
                    hasID = false;
                } else {
                    idSet.add(id);
                }
                if (((GFSETH)elem).getScope() == null) {
                    hasScope = false;
                }
            }
            List<org.verapdf.model.pdlayer.PDStructElem> list = ((GFPDStructElem)elem).getChildren();
            for (org.verapdf.model.pdlayer.PDStructElem  el : list) {
                stack.push(el);
            }
        }
        if (hasScope) {
            return true;
        }
        if (!hasID) {
            return false;
        }
        for (String headers : headersSet) {
            if(!idSet.contains(headers)) {
                return false;
            }
        }
        for (String id : idSet) {
            if(!headersSet.contains(id)) {
                return false;
            }
        }
        return true;
    }
}
