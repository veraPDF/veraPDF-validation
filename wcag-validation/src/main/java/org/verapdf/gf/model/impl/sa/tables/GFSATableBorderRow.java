/**
 * This file is part of veraPDF WCAG Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2024, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF WCAG Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF WCAG Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF WCAG Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.sa.tables;

import org.verapdf.gf.model.impl.sa.GFSAObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.salayer.SATableBorderCell;
import org.verapdf.model.salayer.SATableBorderRow;
import org.verapdf.wcag.algorithms.entities.tables.tableBorders.TableBorderCell;
import org.verapdf.wcag.algorithms.entities.tables.tableBorders.TableBorderRow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxim Plushchov
 */
public class GFSATableBorderRow extends GFSAObject implements SATableBorderRow {

	public static final String CELLS = "cells";

	public static final String TABLE_BORDER_ROW_ELEMENT_TYPE = "SATableBorderRow";

	public GFSATableBorderRow(TableBorderRow row) {
		super(row, TABLE_BORDER_ROW_ELEMENT_TYPE);
	}

	private TableBorderRow getTableBorderRow() {
		return (TableBorderRow)object;
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case CELLS:
				return getCells();
			default:
				return super.getLinkedObjects(link);
		}
	}

	public List<SATableBorderCell> getCells() {
		List<SATableBorderCell> cells = new ArrayList<>();
		for (int colNumber = 0; colNumber < getTableBorderRow().getCells().length; colNumber++) {
			TableBorderCell cell = getTableBorderRow().getCell(colNumber);
			if (getTableBorderRow().getRowNumber() == cell.getRowNumber() && colNumber == cell.getColNumber()) {
				cells.add(new GFSATableBorderCell(cell));
			}
		}
		return cells;
	}
}
