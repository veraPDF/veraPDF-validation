/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2024, veraPDF Consortium <info@verapdf.org>
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
import org.verapdf.model.selayer.SETable;
import org.verapdf.model.pdlayer.PDStructElem;
import org.verapdf.pdfa.flavours.PDFFlavours;
import org.verapdf.tools.TaggedPDFConstants;

import java.util.*;

public class GFSETable extends GFPDStructElem implements SETable {

    public static final String TABLE_STRUCTURE_ELEMENT_TYPE = "SETable";

    private Boolean useHeadersAndIdOrScope;
    private Long columnSpan;
    private Long rowSpan;
    private Long numberOfRowWithWrongColumnSpan = null;
    private Long numberOfColumnWithWrongRowSpan = null;
    private Long wrongColumnSpan;

    public GFSETable(org.verapdf.pd.structure.PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.TABLE, TABLE_STRUCTURE_ELEMENT_TYPE);
    }

    // This logic checks that all TH have Scope attribute or TD reference to TH ID using Headers
    @Override
    public Boolean getuseHeadersAndIdOrScope() {
        if (useHeadersAndIdOrScope == null) {
            checkTable();
        }
        return useHeadersAndIdOrScope;
    }

    private void checkTable() {
        List<Integer> rowGroupingsIndexes = new LinkedList<>();
        List<GFPDStructElem> listTR = getTR(rowGroupingsIndexes);
        int numberOfRows = getNumberOfRows(listTR);
        this.rowSpan = (long)numberOfRows;
        if (numberOfRows == 0) {
            useHeadersAndIdOrScope = true;
            return;
        }
        int numberOfColumns = getNumberOfColumns(listTR.get(0));
        this.columnSpan = (long)numberOfColumns;
        GFSETableCell[][] cells = new GFSETableCell[numberOfRows][numberOfColumns];
        if (!checkRegular(listTR, cells, numberOfRows, numberOfColumns, rowGroupingsIndexes)) {
            useHeadersAndIdOrScope = true;
            return;
        }
        Set<String> idSet = new HashSet<>();
        if (hasScope(cells, numberOfRows, numberOfColumns, idSet)) {
            useHeadersAndIdOrScope = true;
            return;
        }
        useHeadersAndIdOrScope = hasHeaders(cells, idSet, numberOfRows, numberOfColumns);
    }

    private boolean hasScope(GFSETableCell[][] cells, int numberOfRows, int numberOfColumns, Set<String> idSet) {
        boolean hasScope = true;
        for (int rowNumber = 0; rowNumber < numberOfRows; rowNumber++) {
            for (int columnNumber = 0; columnNumber < numberOfColumns; columnNumber++) {
                GFSETableCell cell = cells[rowNumber][columnNumber];
                if (TaggedPDFConstants.TH.equals(cell.getstandardType())) {
                    GFSETH tableHeader = (GFSETH)cell;
                    String id = tableHeader.getTHID();
                    if (id != null && !id.isEmpty()) {
                        idSet.add(id);
                    }
                    if (tableHeader.getScope() == null) {
                        hasScope = false;
                    }
                }
            }
        }
        return hasScope;
    }

    private boolean checkRegular(List<GFPDStructElem> listTR, GFSETableCell[][] cells,
                                 int numberOfRows, int numberOfColumns, List<Integer> rowGroupingsIndexes) {
        for (int rowNumber = 0; rowNumber < listTR.size(); rowNumber++) {
            int columnNumber = 0;
            for (PDStructElem elem : listTR.get(rowNumber).getStructuralSignificanceChildren()) {
                String type = elem.getstandardType();
                if (!TaggedPDFConstants.TD.equals(type) && !TaggedPDFConstants.TH.equals(type)) {
                    continue;
                }
                GFSETableCell cell = (GFSETableCell) elem;
                long colSpan = cell.getColSpan();
                long rowSpan = cell.getRowSpan();
                while (columnNumber < numberOfColumns && cells[rowNumber][columnNumber] != null) {
                    ++columnNumber;
                }
                if (columnNumber + colSpan > numberOfColumns) {
                    this.numberOfRowWithWrongColumnSpan = (long)rowNumber;
                    return false;
                }
                if (rowNumber + rowSpan > numberOfRows) {
                    this.numberOfColumnWithWrongRowSpan = (long)columnNumber;
                    return false;
                }
                if (PDFFlavours.isPDFUA2RelatedFlavour(StaticContainers.getFlavour())) {
                    for (Integer rowGroupsIndex : rowGroupingsIndexes) {
                        if (rowNumber + rowSpan > rowGroupsIndex && rowNumber < rowGroupsIndex) {
                            this.numberOfColumnWithWrongRowSpan = (long)columnNumber;
                            return false;
                        }
                    }
                }
                if (!checkRegular(cells, cell, rowSpan, colSpan, rowNumber, columnNumber)) {
                    return false;
                }
                columnNumber += colSpan;
            }
        }
        for (int rowNumber = 0; rowNumber < numberOfRows; rowNumber++) {
            int numberOfEmptyCells = 0;
            for (int columnNumber = 0; columnNumber < numberOfColumns; columnNumber++) {
                if (cells[rowNumber][columnNumber] == null) {
                    numberOfEmptyCells++;
                }
            }
            if (numberOfEmptyCells != 0) {
                numberOfRowWithWrongColumnSpan = (long)rowNumber;
                wrongColumnSpan = (long)(numberOfColumns - numberOfEmptyCells);
                return false;
            }
        }
        return true;
    }

    private boolean hasHeaders(GFSETableCell[][] cells, Set<String> idSet, int numberOfRows, int numberOfColumns) {
        for (int rowNumber = 0; rowNumber < numberOfRows; rowNumber++) {
            for (int columnNumber = 0; columnNumber < numberOfColumns; columnNumber++) {
                GFSETableCell cell = cells[rowNumber][columnNumber];
                String type = cell.getstandardType();
                if (!TaggedPDFConstants.TD.equals(type) || rowNumber != cell.getRowNumber() ||
                        columnNumber != cell.getColumnNumber()) {
                    continue;
                }
                GFSETD tableCell = (GFSETD)cell;
                boolean hasHeaders = false;
                List<String> list = tableCell.getHeaders();
                if (list != null && !list.isEmpty()) {
                    hasHeaders = true;
                    for (String header : list) {
                        if (!idSet.contains(header)) {
                            hasHeaders = false;
                            break;
                        }
                    }
                }
                if (hasHeaders || hasHeaders(cells, rowNumber, columnNumber,
                        rowNumber + tableCell.getRowSpan().intValue(), columnNumber + tableCell.getColSpan().intValue())) {
                    tableCell.setHasConnectedHeader(true);
                    continue;
                }
                tableCell.setHasConnectedHeader(false);
                if (list != null) {
                    for (String header : list) {
                        if (!idSet.contains(header)) {
                            tableCell.addUnknownHeader(header);
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean hasHeaders(GFSETableCell[][] cells, int cellRowNumber, int cellColumnNumber,
                               int cellEndRowNumber, int cellEndColumnNumber) {
        if (cellRowNumber > 0) {
            for (int columnNumber = cellColumnNumber; columnNumber < cellEndColumnNumber; columnNumber++) {
                boolean headerFound = false;
                for (int rowNumber = cellRowNumber - 1; rowNumber >= 0; rowNumber--) {
                    if (hasScope(cells[rowNumber][columnNumber], rowNumber, columnNumber, GFSETH.COLUMN)) {
                        return true;
                    }
                    if (TaggedPDFConstants.TH.equals(cells[rowNumber][columnNumber].getstandardType())) {
                        headerFound = true;
                    } else if (headerFound) {
                        break;
                    }
                }
            }
        }
        if (cellColumnNumber > 0) {
            for (int rowNumber = cellRowNumber; rowNumber < cellEndRowNumber; rowNumber++) {
                boolean headerFound = false;
                for (int columnNumber = cellColumnNumber - 1; columnNumber >= 0; columnNumber--) {
                    if (hasScope(cells[rowNumber][columnNumber], rowNumber, columnNumber, GFSETH.ROW)) {
                        return true;
                    }
                    if (TaggedPDFConstants.TH.equals(cells[rowNumber][columnNumber].getstandardType())) {
                        headerFound = true;
                    } else if (headerFound) {
                        break;
                    }
                }
            }
        }
        return false;
    }

    private boolean hasScope(GFSETableCell cell, int rowNumber, int columnNumber, String value) {
        if (TaggedPDFConstants.TH.equals(cell.getstandardType())) {
            String scope = ((GFSETH)cell).getScope();
            if (scope == null) {
                scope = GFSETH.getDefaultScope(rowNumber, columnNumber);
            }
            if (GFSETH.BOTH.equals(scope) || value.equals(scope)) {
                return true;
            }
        }
        return false;
    }

    private List<GFPDStructElem> getTR(List<Integer> rowGroupingsIndexes) {
        List<GFPDStructElem> listTR = new LinkedList<>();
        for (GFPDStructElem elem : getStructuralSignificanceChildren()) {
            String type = elem.getstandardType();
            if (TaggedPDFConstants.TR.equals(type)) {
                listTR.add(elem);
            } else if (TaggedPDFConstants.THEAD.equals(type) || TaggedPDFConstants.TBODY.equals(type) ||
                    TaggedPDFConstants.TFOOT.equals(type)) {
                rowGroupingsIndexes.add(listTR.size());
                for (GFPDStructElem child : elem.getStructuralSignificanceChildren()) {
                    if (TaggedPDFConstants.TR.equals(child.getstandardType())) {
                        listTR.add(child);
                    }
                }
                rowGroupingsIndexes.add(listTR.size());
            }
        }
        return listTR;
    }

    private Integer getNumberOfColumns(GFPDStructElem firstTR) {
        int numberOfColumns = 0;
        for (PDStructElem elem : firstTR.getStructuralSignificanceChildren()) {
            String type = elem.getstandardType();
            if (TaggedPDFConstants.TH.equals(type) || TaggedPDFConstants.TD.equals(type)) {
                numberOfColumns += ((GFSETableCell)elem).getColSpan();
            }
        }
        return numberOfColumns;
    }

    private Integer getNumberOfRows(List<GFPDStructElem> listTR) {
        int numberOfRows = 0;
        for (int rowNumber = 0; rowNumber < listTR.size(); rowNumber++) {
            List<GFPDStructElem> children = listTR.get(rowNumber).getStructuralSignificanceChildren();
            if (!children.isEmpty()) {
                PDStructElem elem = children.get(0);
                String type = elem.getstandardType();
                if (TaggedPDFConstants.TH.equals(type) || TaggedPDFConstants.TD.equals(type)) {
                    Long rowSpan = ((GFSETableCell)elem).getRowSpan();
                    numberOfRows += rowSpan;
                    if (rowSpan > 1) {
                        rowNumber += rowSpan - 1;
                    }
                }
            }
        }
        return numberOfRows;
    }

    private Boolean checkRegular(GFSETableCell[][] cells, GFSETableCell cell, long rowSpan, long colSpan,
                                 int rowNumber, int columnNumber) {
        cell.setRowNumber(rowNumber);
        cell.setColumnNumber(columnNumber);
        for (int i = 0; i < rowSpan; i++) {
            for (int j = 0; j < colSpan; j++) {
                if (cells[rowNumber + i][columnNumber + j] != null) {
                    cell.setHasIntersection(true);
                    cells[rowNumber + i][columnNumber + j].setHasIntersection(true);
                    return false;
                }
                cells[rowNumber + i][columnNumber + j] = cell;
            }
        }
        return true;
    }

    @Override
    public Long getcolumnSpan() {
        if (rowSpan == null) {
            checkTable();
        }
        return columnSpan;
    }

    @Override
    public Long getrowSpan() {
        if (rowSpan == null) {
            checkTable();
        }
        return rowSpan;
    }

    @Override
    public Long getnumberOfRowWithWrongColumnSpan() {
        if (rowSpan == null) {
            checkTable();
        }
        return numberOfRowWithWrongColumnSpan;
    }

    @Override
    public Long getnumberOfColumnWithWrongRowSpan() {
        if (rowSpan == null) {
            checkTable();
        }
        return numberOfColumnWithWrongRowSpan;
    }

    @Override
    public Long getwrongColumnSpan() {
        if (rowSpan == null) {
            checkTable();
        }
        return wrongColumnSpan;
    }
}
