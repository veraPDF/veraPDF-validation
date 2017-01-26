/**
 * This file is part of metadata-fixer, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * metadata-fixer is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with metadata-fixer as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * metadata-fixer as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.metadata.fixer.gf.impl.schemas;

import com.adobe.xmp.XMPException;
import com.adobe.xmp.impl.VeraPDFMeta;
import org.verapdf.metadata.fixer.entity.Metadata;
import org.verapdf.metadata.fixer.schemas.DublinCore;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Maksim Bezrukov
 */
public class DublinCoreSchemaImpl extends BasicSchemaImpl implements DublinCore {

	private static final Logger LOGGER = Logger.getLogger(DublinCoreSchemaImpl.class.getCanonicalName());

	public DublinCoreSchemaImpl(VeraPDFMeta meta, Metadata metadata) {
		super(meta, metadata);
	}

	@Override
	public String getTitle() {
		try {
			return this.meta.getTitle();
		} catch (XMPException e) {
			LOGGER.log(Level.FINE, "Can not get title.", e);
			throw new IllegalStateException(e);
		}
	}

	@Override
	public void setTitle(String title) {
		try {
			this.meta.setTitle(title);
		} catch (XMPException e) {
			LOGGER.log(Level.FINE, "Can not set title.", e);
			throw new IllegalStateException(e);
		}
	}

	@Override
	public String getSubject() {
		try {
			return this.meta.getDescription();
		} catch (XMPException e) {
			LOGGER.log(Level.FINE, "Can not get subject.", e);
			throw new IllegalStateException(e);
		}
	}

	@Override
	public void setSubject(String description) {
		try {
			this.meta.setDescription(description);
		} catch (XMPException e) {
			LOGGER.log(Level.FINE, "Can not set description.", e);
			throw new IllegalStateException(e);
		}
	}

	@Override
	public String getAuthor() {
		try {
			List<String> creators = this.meta.getCreator();
			if (creators == null) {
				return null;
			}
			if (creators.size() > 1) {
				StringBuilder builder = new StringBuilder();
				for (String str : creators) {
					builder.append(str).append(", ");
				}
				List<String> res = new ArrayList<>(1);
				String s = builder.toString();
				res.add(s.substring(0, s.length() - 2));
				this.meta.setCreator(res);
				return res.get(0);
			}
			return creators.size() == 0 ? null : creators.get(0);
		} catch (XMPException e) {
			LOGGER.log(Level.FINE, "Can not get creator.", e);
			throw new IllegalStateException(e);
		}
	}

	@Override
	public void setAuthor(String creator) {
		try {
			List<String> res = new ArrayList<>(1);
			res.add(creator);
			this.meta.setCreator(res);
		} catch (XMPException e) {
			LOGGER.log(Level.FINE, "Can not set creator.", e);
			throw new IllegalStateException(e);
		}
	}

}
