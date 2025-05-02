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
package org.verapdf.metadata.fixer.gf.impl.model;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDocument;
import org.verapdf.cos.COSObject;
import org.verapdf.metadata.fixer.entity.InfoDictionary;
import org.verapdf.metadata.fixer.gf.utils.DateConverter;

/**
 * @author Maksim Bezrukov
 */
public class InfoDictionaryImpl implements InfoDictionary {

	private final COSObject info;
	private final COSDocument doc;

	public InfoDictionaryImpl(COSObject info, COSDocument doc) {
		if (info == null || info.empty() || doc == null) {
			throw new IllegalArgumentException("Info dictionary representation can not be null");
		}
		this.info = info;
		this.doc = doc;
	}

	@Override
	public String getTitle() {
		return this.info.getStringKey(ASAtom.TITLE);
	}

	@Override
	public void setTitle(String title) {
		this.info.setStringKey(ASAtom.TITLE, title);
	}

	@Override
	public String getSubject() {
		return this.info.getStringKey(ASAtom.SUBJECT);
	}

	@Override
	public void setSubject(String subject) {
		this.info.setStringKey(ASAtom.SUBJECT, subject);
	}

	@Override
	public String getAuthor() {
		return this.info.getStringKey(ASAtom.AUTHOR);
	}

	@Override
	public int getAuthorSize() {
		return this.info.knownKey(ASAtom.AUTHOR) ? 1 : 0;
	}

	@Override
	public void setAuthor(String author) {
		this.info.setStringKey(ASAtom.AUTHOR, author);
	}

	@Override
	public String getProducer() {
		return this.info.getStringKey(ASAtom.PRODUCER);
	}

	@Override
	public void setProducer(String producer) {
		this.info.setStringKey(ASAtom.PRODUCER, producer);
	}

	@Override
	public String getKeywords() {
		return this.info.getStringKey(ASAtom.KEYWORDS);
	}

	@Override
	public void setKeywords(String keywords) {
		this.info.setStringKey(ASAtom.KEYWORDS, keywords);
	}

	@Override
	public String getCreator() {
		return this.info.getStringKey(ASAtom.CREATOR);
	}

	@Override
	public void setCreator(String creator) {
		this.info.setStringKey(ASAtom.CREATOR, creator);
	}

	@Override
	public String getCreationDate() {
		return this.info.getStringKey(ASAtom.CREATION_DATE);
	}

	@Override
	public void setCreationDate(String creationDate) {
		this.info.setStringKey(ASAtom.CREATION_DATE, DateConverter.toPDFDateFormat(creationDate));
	}

	@Override
	public String getModificationDate() {
		return this.info.getStringKey(ASAtom.MOD_DATE);
	}

	@Override
	public void setModificationDate(String modificationDate) {
		this.info.setStringKey(ASAtom.MOD_DATE, DateConverter.toPDFDateFormat(modificationDate));
	}

	@Override
	public boolean isNeedToBeUpdated() {
		return this.doc.isObjectChanged(this.info);
	}

	@Override
	public void setNeedToBeUpdated(boolean needToBeUpdated) {
		if (needToBeUpdated) {
			this.doc.addChangedObject(info);
		} else {
			this.doc.removeChangedObject(info);
		}
	}

}
