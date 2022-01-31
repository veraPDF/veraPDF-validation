/**
 * This file is part of veraPDF Metadata Fixer, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Metadata Fixer is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Metadata Fixer as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Metadata Fixer as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.metadata.fixer.gf.impl.schemas;

import org.verapdf.xmp.impl.VeraPDFMeta;
import org.verapdf.metadata.fixer.entity.Metadata;
import org.verapdf.metadata.fixer.schemas.BasicSchema;

/**
 * @author Maksim Bezrukov
 */
public abstract class BasicSchemaImpl implements BasicSchema {

	protected final VeraPDFMeta meta;
	protected final Metadata metadata;

	protected BasicSchemaImpl(VeraPDFMeta meta, Metadata metadata) {
		if (meta == null) {
			throw new IllegalArgumentException("Schema representation can not be null");
		}
		if (metadata == null) {
			throw new IllegalArgumentException("Metadata representation can not be null");
		}
		this.meta = meta;
		this.metadata = metadata;
	}

	@Override
	public void setNeedToBeUpdated(boolean needToBeUpdated) {
		this.metadata.setNeedToBeUpdated(needToBeUpdated);
	}

}
