/**
 * This file is part of veraPDF Feature Reporting, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Feature Reporting is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Feature Reporting as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Feature Reporting as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.features.gf.objects;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSStream;
import org.verapdf.features.objects.EmbeddedFileFeaturesObjectAdapter;
import org.verapdf.tools.TypeConverter;

import java.io.InputStream;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * Feature object adapter for embedded file
 *
 * @author Maksim Bezrukov
 */
public class GFEmbeddedFileFeaturesObjectAdapter implements EmbeddedFileFeaturesObjectAdapter {

	private COSObject embFile;
	private Params params;
	private COSObject cosEmbFile;
	private int index;

	/**
	 * Constructs new Embedded File Feature Object Adapter
	 *
	 * @param embFile class represents Embedded File object
	 * @param index   page index
	 */
	public GFEmbeddedFileFeaturesObjectAdapter(COSObject embFile, int index) {
		this.embFile = embFile;
		this.index = index;
		this.cosEmbFile = getEmbeddedFile();
		if (this.cosEmbFile != null) {
			COSObject paramsObj = this.cosEmbFile.getKey(ASAtom.PARAMS);
			if (paramsObj != null && !paramsObj.empty()) {
				this.params = new Params(paramsObj);
			}
		}

	}

	private COSObject getEmbeddedFile() {
		if (embFile != null && !embFile.empty()){
			COSObject efDict = embFile.getKey(ASAtom.EF);
			if (efDict != null && efDict.getType() == COSObjType.COS_DICT) {
				COSObject file = efDict.getKey(ASAtom.F);
				if (file != null && file.getType() == COSObjType.COS_STREAM) {
					return file;
				}
			}
		}
		return null;
	}

	@Override
	public int getIndex() {
		return this.index;
	}

	@Override
	public String getFileName() {
		if (embFile != null && embFile.getType().isDictionaryBased()) {
			String filename = embFile.getStringKey(ASAtom.UF);
			if (filename == null) {
				filename = embFile.getStringKey(ASAtom.DOS);
			}
			if (filename == null) {
				filename = embFile.getStringKey(ASAtom.MAC);
			}
			if (filename == null) {
				filename = embFile.getStringKey(ASAtom.UNIX);
			}
			if (filename == null) {
				filename = embFile.getStringKey(ASAtom.F);
			}
			return filename;
		}
		return null;
	}

	@Override
	public String getDescription() {
		if (embFile != null && embFile.getType().isDictionaryBased()) {
			return embFile.getStringKey(ASAtom.DESC);
		}
		return null;
	}

	@Override
	public String getAFRelationship() {
		if (embFile != null && embFile.getType().isDictionaryBased()) {
			return embFile.getStringKey(ASAtom.AF_RELATIONSHIP);
		}
		return null;
	}

	@Override
	public String getSubtype() {
		if (this.cosEmbFile != null && this.cosEmbFile.getType().isDictionaryBased()) {
			return this.cosEmbFile.getStringKey(ASAtom.SUBTYPE);
		}
		return null;
	}

	@Override
	public String getFilter() {
		if (cosEmbFile != null && cosEmbFile.getType().isDictionaryBased()) {
			COSObject filter = cosEmbFile.getKey(ASAtom.FILTER);
			if (filter != null && !filter.empty()) {
				if (filter.getType() == COSObjType.COS_NAME) {
					return filter.getString();
				} else if (filter.getType() == COSObjType.COS_ARRAY) {
					StringBuilder builder = new StringBuilder();
					for (COSObject elem : (COSArray) filter.getDirectBase()) {
						String elemValue = elem.getString();
						if (elemValue != null) {
							builder.append(elemValue).append(" ");
						}
					}
					return builder.toString().trim();
				}
			}
		}
		return null;
	}

	@Override
	public Calendar getCreationDate() {
		return this.params == null ? null : this.params.getCreationDate();
	}

	@Override
	public Calendar getModDate() {
		return this.params == null ? null : this.params.getModDate();
	}

	@Override
	public String getCheckSum() {
		return this.params == null ? null : this.params.getCheckSum();
	}

	@Override
	public Long getSize() {
		return this.params == null ? null : this.params.getSize();
	}

	@Override
	public InputStream getData() {
		return this.cosEmbFile == null || this.cosEmbFile.empty() ? null : this.cosEmbFile.getData(COSStream.FilterFlags.DECODE);
	}

	@Override
	public boolean isPDFObjectPresent() {
		return embFile != null && !embFile.empty();
	}

	@Override
	public List<String> getErrors() {
		return Collections.emptyList();
	}

	private class Params {

		private COSObject obj;

		public Params(COSObject obj) {
			this.obj = obj;
		}

		public Calendar getCreationDate() {
			return getDate(ASAtom.CREATION_DATE);
		}

		public Calendar getModDate() {
			return getDate(ASAtom.MOD_DATE);
		}

		public String getCheckSum() {
			return obj.getStringKey(ASAtom.CHECKSUM);
		}

		public Long getSize() {
			return obj.getIntegerKey(ASAtom.SIZE);
		}

		private Calendar getDate(ASAtom type) {
			String date = obj.getStringKey(type);
			if (date != null) {
				Calendar dateCal = TypeConverter.parseDate(date);
				return dateCal;
			}
			return null;
		}
	}


}
