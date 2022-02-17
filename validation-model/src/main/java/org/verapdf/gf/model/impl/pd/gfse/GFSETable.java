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
import java.util.LinkedList;

public class GFSETable extends GFSEGeneral implements SETable {

    public static final String TABLE_STRUCTURE_ELEMENT_TYPE = "SETable";

    public GFSETable(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.TABLE, TABLE_STRUCTURE_ELEMENT_TYPE);
    }

    // This logic checks that all TH have Scope attribute or TD reference to TH ID using Headers
    @Override
    public Boolean getuseHeadersAndIdOrScope() {
        Stack<GFPDStructElem> stack = new Stack<>();
        boolean hasScope = true;
        boolean hasID = true;
        boolean hasHeaders = true;
        Set<String> idSet = new HashSet<>();
        Set<String> headersSet = new HashSet<>();
        stack.push(this);
        while (!stack.empty()) {
            GFPDStructElem elem = stack.pop();
            String type = elem.getstandardType();
            if (TaggedPDFConstants.TD.equals(type)) {
                List<String> list = ((GFSETD)elem).getHeaders();
                if (list != null && !list.isEmpty()) {
                    headersSet.addAll(list);
                } else {
                    hasHeaders = false;
                }
            } else if (TaggedPDFConstants.TH.equals(type)) {
                String id = ((GFSETH)elem).getTHID();
                if (id == null || id.isEmpty()) {
                    hasID = false;
                } else {
                    idSet.add(id);
                }
                if (((GFSETH)elem).getScope() == null) {
                    hasScope = false;
                }
            }
            stack.addAll(elem.getChildren());
        }
        if (hasScope) {
            return true;
        }
        if (!hasID || !hasHeaders) {
            return false;
        }
        for (String headers : headersSet) {
            if (!idSet.contains(headers)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean getisRegular() {
        List<GFPDStructElem> listTR = getTR();
        int rowNum = listTR.size();
        int columnNum = getColumnNum(listTR.get(0));
        boolean[][] cells = new boolean[rowNum][columnNum];
        for (int i = 0; i < rowNum; i++) {
            int j = 0;
            for (org.verapdf.model.pdlayer.PDStructElem elem : listTR.get(i).getChildren()) {
                String type = elem.getstandardType();
                long colSpan;
                long rowSpan;
                if (TaggedPDFConstants.TH.equals(type)) {
                    colSpan = ((GFSETH)elem).getColSpan();
                    rowSpan = ((GFSETH)elem).getRowSpan();
                } else if (TaggedPDFConstants.TD.equals(type)) {
                    colSpan = ((GFSETD)elem).getColSpan();
                    rowSpan = ((GFSETD)elem).getRowSpan();
                } else {
                    continue;
                }

                while (j < columnNum && cells[i][j]) {
                    ++j;
                }
                if (j >= columnNum) {
                    return false;
                }
                if (i + rowSpan > rowNum || j + colSpan > columnNum) {
                    return false;
                }
                if (!checkRegular(cells, rowSpan, colSpan, i, j)) {
                    return false;
                }
                j += colSpan;
            }
        }
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < columnNum; j++) {
                if (!cells[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<GFPDStructElem> getTR() {
        List<GFPDStructElem> listTR = new LinkedList<>();
        for (GFPDStructElem elem : getChildren()) {
            String type = elem.getstandardType();
            if (TaggedPDFConstants.TR.equals(type)) {
                listTR.add(elem);
            } else if (TaggedPDFConstants.THEAD.equals(type) || TaggedPDFConstants.TBODY.equals(type) ||
                    TaggedPDFConstants.TFOOT.equals(type)) {
                for (GFPDStructElem child : elem.getChildren()) {
                    if (TaggedPDFConstants.TR.equals(child.getstandardType())) {
                        listTR.add(child);
                    }
                }
            }
        }
        return listTR;
    }

    private Integer getColumnNum(GFPDStructElem firstTR) {
        int columnNum = 0;
        for (org.verapdf.model.pdlayer.PDStructElem elem : firstTR.getChildren()) {
            String type = elem.getstandardType();
            if (TaggedPDFConstants.TH.equals(type)) {
                columnNum += ((GFSETH)elem).getColSpan();
            } else if (TaggedPDFConstants.TD.equals(type)) {
                columnNum += ((GFSETD)elem).getColSpan();
            }
        }
        return columnNum;
    }

    private Boolean checkRegular(boolean[][] cells, long rowSpan, long colSpan, int i, int j) {
        for (int k = 0; k < rowSpan; k++) {
            for (int l = 0; l < colSpan; l++) {
                if (cells[i + k][j + l]) {
                    return false;
                }
                cells[i + k][j + l] = true;
            }
        }
        return true;
    }
}
