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

import org.verapdf.gf.model.impl.sa.GFSAObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.salayer.SATableBorder;
import org.verapdf.model.salayer.SATableBorderRow;
import org.verapdf.wcag.algorithms.entities.tables.tableBorders.TableBorder;
import org.verapdf.wcag.algorithms.entities.tables.tableBorders.TableBorderRow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxim Plushchov
 */
public class GFSATableBorder extends GFSAObject implements SATableBorder {

	public static final String ROWS = "rows";

	public static final String TABLE_BORDER_ELEMENT_TYPE = "SATableBorder";

	private final TableBorder tableBorder;

	public GFSATableBorder(TableBorder tableBorder) {
		super(TABLE_BORDER_ELEMENT_TYPE);
		this.tableBorder = tableBorder;
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case ROWS:
				return getRows();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<SATableBorderRow> getRows() {
		List<SATableBorderRow> rows = new ArrayList<>();
		for (TableBorderRow row : tableBorder.getRows()) {
			rows.add(new GFSATableBorderRow(row));
		}
		return rows;
	}

	@Override
	public String getContext() {
		return tableBorder.getBoundingBox().getLocation();
	}
}
