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
package org.verapdf.gf.model.impl.sa.tables;

import org.verapdf.model.GenericModelObject;
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
public class GFSATableBorderRow extends GenericModelObject implements SATableBorderRow {

	public static final String CELLS = "cells";

	public static final String TABLE_BORDER_ROW_ELEMENT_TYPE = "SATableBorderRow";

	private final TableBorderRow row;

	public GFSATableBorderRow(TableBorderRow row) {
		super(TABLE_BORDER_ROW_ELEMENT_TYPE);
		this.row = row;
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
		for (TableBorderCell cell : row.getCells()) {
			cells.add(new GFSATableBorderCell(cell));
		}
		return cells;
	}

	@Override
	public String getContext() {
		return row.getBoundingBox().getLocation();
	}
}
