/**
 * This file is part of feature-reporting, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * feature-reporting is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with feature-reporting as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * feature-reporting as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.features.gf.objects;

import org.verapdf.as.ASAtom;
import org.verapdf.core.FeatureParsingException;
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSStream;
import org.verapdf.features.EmbeddedFileFeaturesData;
import org.verapdf.features.FeatureExtractionResult;
import org.verapdf.features.FeatureObjectType;
import org.verapdf.features.FeaturesData;
import org.verapdf.features.gf.tools.GFAdapterHelper;
import org.verapdf.features.tools.FeatureTreeNode;
import org.verapdf.tools.TypeConverter;

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Feature object for embedded file
 *
 * @author Maksim Bezrukov
 */
public class GFEmbeddedFileFeaturesObject implements IFeaturesObject {

	private static final Logger LOGGER = Logger.getLogger(GFEmbeddedFileFeaturesObject.class.getCanonicalName());

	private static final String CREATION_DATE = "creationDate";
	private static final String MOD_DATE = "modDate";

	private COSObject embFile;
	private int index;

	/**
	 * Constructs new Embedded File Feature Object
	 *
	 * @param embFile class represents Embedded File object
	 * @param index   page index
	 */
	public GFEmbeddedFileFeaturesObject(COSObject embFile, int index) {
		this.embFile = embFile;
		this.index = index;
	}

	/**
	 * @return EMBEDDED_FILE instance of the FeaturesObjectTypesEnum enumeration
	 */
	@Override
	public FeatureObjectType getType() {
		return FeatureObjectType.EMBEDDED_FILE;
	}

	/**
	 * Reports all features from the object into the collection
	 *
	 * @param collection collection for feature report
	 * @return FeatureTreeNode class which represents a root node of the constructed collection tree
	 * @throws FeatureParsingException occurs when wrong features tree node constructs
	 */
	@Override
	public FeatureTreeNode reportFeatures(FeatureExtractionResult collection) throws FeatureParsingException {

		if (embFile != null && embFile.getType().isDictionaryBased()) {
			FeatureTreeNode root = FeatureTreeNode.createRootNode("embeddedFile");
			root.setAttribute("id", "file" + index);

			GFAdapterHelper.addNotEmptyNode("fileName", getFilename(), root);
			GFAdapterHelper.addNotEmptyNode("description", embFile.getStringKey(ASAtom.DESC), root);
			GFAdapterHelper.addNotEmptyNode("afRelationship", embFile.getStringKey(ASAtom.AF_RELATIONSHIP), root);

			COSObject ef = getEmbeddedFile();
			if (ef != null && !ef.empty()) {
				GFAdapterHelper.addNotEmptyNode("subtype", ef.getStringKey(ASAtom.SUBTYPE), root);

				GFAdapterHelper.addNotEmptyNode("filter", getFilters(ef), root);

				COSObject paramsObj = ef.getKey(ASAtom.PARAMS);
				if (paramsObj != null && !paramsObj.empty()) {
					Params params = new Params(paramsObj);
					GFAdapterHelper.createDateNode(CREATION_DATE, root, params.getCreationDate(), collection);
					GFAdapterHelper.createDateNode(MOD_DATE, root, params.getModDate(), collection);
					GFAdapterHelper.addNotEmptyNode("checkSum", params.getCheckSum(), root);
					Long size = params.getSize();
					if (size != null) {
						GFAdapterHelper.addNotEmptyNode("size", String.valueOf(size.longValue()), root);
					}
				}
			}

			collection.addNewFeatureTree(FeatureObjectType.EMBEDDED_FILE, root);
			return root;
		}
		return null;
	}

	/**
	 * @return null if it can not get embedded file stream and features data of the embedded file in other case.
	 */
	@Override
	public FeaturesData getData() {
		COSObject ef = getEmbeddedFile();
		if (ef == null && !ef.empty()) {
			LOGGER.log(Level.FINE, "Missed embedded file in PDComplexFileSpecification");
			return null;
		}

		EmbeddedFileFeaturesData.Builder builder = new EmbeddedFileFeaturesData.Builder(ef.getData(COSStream.FilterFlags.DECODE));

		builder.name(getFilename());
		builder.description(embFile.getStringKey(ASAtom.DESC));
		builder.afRelationship(embFile.getStringKey(ASAtom.AF_RELATIONSHIP));

		builder.subtype(ef.getStringKey(ASAtom.SUBTYPE));
		COSObject paramsObj = ef.getKey(ASAtom.PARAMS);
		if (paramsObj != null && !paramsObj.empty()) {
			Params params = new Params(paramsObj);
			builder.creationDate(params.getCreationDate());
			builder.modDate(params.getModDate());
			builder.checkSum(params.getCheckSum());
			Long size = params.getSize();
			if (size != null) {
				builder.size(Integer.valueOf(size.intValue()));
			}
		}
		return builder.build();
	}

	private static String getFilters(COSObject ef) {
		COSObject filter = ef.getKey(ASAtom.FILTER);
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
		return null;
	}

	private String getFilename() {
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
