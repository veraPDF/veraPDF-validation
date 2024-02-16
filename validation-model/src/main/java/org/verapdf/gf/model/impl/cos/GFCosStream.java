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
package org.verapdf.gf.model.impl.cos;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.*;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosFilter;
import org.verapdf.model.coslayer.CosStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Timur Kamalov
 */
public class GFCosStream extends GFCosDict implements CosStream {

	private static final Logger LOGGER = Logger.getLogger(GFCosStream.class.getCanonicalName());

	public static final String FILTERS = "filters";

	/** Type name for GFCosStream */
	public static final String COS_STREAM_TYPE = "CosStream";
	public static final String F_DECODE_PARMS = "FDecodeParms";

	private final Long length;
	private final Long realLength;
	private final String fileSpec;
	private final String fFilter;
	private final String fDecodeParams;
	private final boolean streamKeywordCRLFCompliant;
	private final boolean endstreamKeywordEOLCompliant;

	/**
	 * Default constructor
	 * @param stream greenfield COSStream
	 */
	public GFCosStream(COSStream stream) {
		super(stream, COS_STREAM_TYPE);
		this.length = parseLength(stream);
		COSObject fileSpec = stream.getKey(ASAtom.F);
		this.fileSpec = fileSpec.empty() ? null : fileSpec.toString();
		this.fFilter = parseFilters(stream.getKey(ASAtom.F_FILTER).get());
		COSObject fDecodeParams = stream.getKey(ASAtom.F_DECODE_PARMS);
		this.fDecodeParams = fDecodeParams.empty() ? null : fDecodeParams.toString();
		this.streamKeywordCRLFCompliant = stream.isStreamKeywordCRLFCompliant();
		this.endstreamKeywordEOLCompliant = stream.isEndstreamKeywordCRLFCompliant();
		this.realLength = stream.getRealStreamSize();
	}

	/**
	 * length of the stream
	 */
	@Override
	public Long getLength() {
		return this.length;
	}

	@Override
	public Long getrealLength() { return realLength; }

	/**
	 * @return string representation of file specification if its present
	 */
	@Override
	public String getF() {
		return this.fileSpec;
	}

	/**
	 * @return string representation of filters for external file
	 */
	@Override
	public String getFFilter() {
		return this.fFilter;
	}

	/**
	 * @return string representation of decode parameters for filters applied to
	 *         external file
	 */
	@Override
	public String getFDecodeParms() {
		return this.fDecodeParams;
	}

	/**
	 * true if the spacing around stream complies with the PDF/A
	 * requirements
	 */
	@Override
	public Boolean getstreamKeywordCRLFCompliant() {
		return this.streamKeywordCRLFCompliant;
	}

	@Override
	public Boolean getendstreamKeywordEOLCompliant() {
		return this.endstreamKeywordEOLCompliant;
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case FILTERS:
				return this.getFilters();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<CosFilter> getFilters() {
		COSFilters filters = ((COSStream) this.baseObject).getFilters();
		if (filters == null || filters.getFilters().isEmpty()) {
			return Collections.emptyList();
		}
		List<CosFilter> result = new ArrayList<>();

		COSObject decodeParmsObject = this.baseObject.getKey(ASAtom.DECODE_PARMS);
		COSBase decodeParms = null;
		if (decodeParmsObject != null) {
			decodeParms = decodeParmsObject.get();
		}

		if (filters.getFilters().size() == 1) {
			if (decodeParms instanceof COSArray) {
				decodeParms = decodeParms.at(0).get();
			}
			ASAtom filter = filters.getFilters().get(0);
			COSName filterName = (COSName) COSName.fromValue(filter);
			result.add(createFilter(filterName, decodeParms));
		} else if (filters.size() > 1) {
			List<ASAtom> filtersList = filters.getFilters();
			int i = 0;
			for (ASAtom filter : filtersList) {
				if (decodeParms == null) {
					result.add(createFilter((COSName) COSName.fromValue(filter), null));
					//TODO : check this for pdfbox implementation
				} else if (decodeParms.getType() == COSObjType.COS_ARRAY && decodeParms.size() > i) {
					decodeParms = decodeParms.at(i).get();
					result.add(createFilter((COSName) COSName.fromValue(filter), decodeParms));
				} else {
					LOGGER.log(Level.FINE, "Invalid decodeParms type. Ignoring decodeParms.");
				}
				i++;
			}
		}
		return result;
	}

	private static CosFilter createFilter(final COSName filter, final COSBase decodeParms) {
		if (decodeParms == null) {
			return new GFCosFilter(filter, null);
		} else if (decodeParms instanceof COSDictionary) {
			return new GFCosFilter(filter, (COSDictionary) decodeParms);
		} else {
			LOGGER.log(Level.FINE, "Invalid decodeParms type. Ignoring decodeParms.");
			return new GFCosFilter(filter, null);
		}
	}

	private static Long parseLength(final COSStream stream) {
		COSBase number = stream.getKey(ASAtom.LENGTH).getDirectBase();
		return number instanceof COSNumber ? number.getInteger() : null;
	}

	private static String parseFilters(COSBase base) {
		if (base == null) {
			return null;
		}
		if (base.getType() == COSObjType.COS_NAME) {
			return base.getString();
		}
		if (base.getType() == COSObjType.COS_ARRAY) {
			StringBuilder filters = new StringBuilder();
			for (COSObject filter : (COSArray) base) {
				if (filter.getType() == COSObjType.COS_NAME) {
					filters.append(filter.getName()).append(" ");
				} else {
					LOGGER.log(Level.SEVERE, "Incorrect type for stream filter " +
							filter.getClass().getName());
				}
			}
			// need to discard last white space
			return filters.substring(0, filters.length() - 1);
		}
		LOGGER.log(Level.SEVERE, "Incorrect type for stream filter " +
				base.getClass().getName());
		return null;
	}
}
