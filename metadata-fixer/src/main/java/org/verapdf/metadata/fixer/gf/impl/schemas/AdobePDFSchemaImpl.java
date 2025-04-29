/**
 * This file is part of veraPDF Metadata Fixer, a module of the veraPDF project.
 * Copyright (c) 2015-2025, veraPDF Consortium <info@verapdf.org>
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

import org.verapdf.xmp.XMPException;
import org.verapdf.xmp.impl.VeraPDFMeta;
import org.verapdf.metadata.fixer.entity.Metadata;
import org.verapdf.metadata.fixer.schemas.AdobePDF;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Maksim Bezrukov
 */
public class AdobePDFSchemaImpl extends BasicSchemaImpl implements AdobePDF {
	private static final Logger LOGGER = Logger.getLogger(AdobePDFSchemaImpl.class.getCanonicalName());

	public AdobePDFSchemaImpl(VeraPDFMeta meta, Metadata metadata) {
		super(meta, metadata);
	}

	@Override
	public String getProducer() {
		try {
			return this.meta.getProducer();
		} catch (XMPException e) {
			LOGGER.log(Level.FINE, "Can not get producer.", e);
			throw new IllegalStateException(e);
		}
	}

	@Override
	public void setProducer(String producer) {
		try {
			this.meta.setProducer(producer);
		} catch (XMPException e) {
			LOGGER.log(Level.FINE, "Can not set producer.", e);
			throw new IllegalStateException(e);
		}
	}

	@Override
	public String getKeywords() {
		try {
			return this.meta.getKeywords();
		} catch (XMPException e) {
			LOGGER.log(Level.FINE, "Can not get keywords.", e);
			throw new IllegalStateException(e);
		}
	}

	@Override
	public void setKeywords(String keywords) {
		try {
			this.meta.setKeywords(keywords);
		} catch (XMPException e) {
			LOGGER.log(Level.FINE, "Can not set keywords.", e);
			throw new IllegalStateException(e);
		}
	}

}
