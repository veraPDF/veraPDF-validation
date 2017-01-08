package org.verapdf.gf.model.impl.cos;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.*;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosFilter;
import org.verapdf.model.coslayer.CosStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
	private final String fileSpec;
	private final String fFilter;
	private final String fDecodeParams;
	private final boolean streamKeywordCRLFCompliant;
	private final boolean endstreamKeywordEOLCompliant;
	private final boolean isLengthCorrect;

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
		String fDecodeParams = stream.getStringKey(ASAtom.F_DECODE_PARMS);
		this.fDecodeParams = fDecodeParams == null || fDecodeParams.isEmpty() ? null : fDecodeParams;
		this.streamKeywordCRLFCompliant = stream.isStreamKeywordCRLFCompliant().booleanValue();
		this.endstreamKeywordEOLCompliant = stream.isEndstreamKeywordCRLFCompliant().booleanValue();
		this.isLengthCorrect = this.length != null && this.length.equals(stream.getRealStreamSize());
	}

	/**
	 * length of the stream
	 */
	@Override
	public Long getLength() {
		return this.length;
	}

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
		return Boolean.valueOf(this.streamKeywordCRLFCompliant);
	}

	@Override
	public Boolean getendstreamKeywordEOLCompliant() {
		return Boolean.valueOf(this.endstreamKeywordEOLCompliant);
	}

	/**
	 * true if the value of Length key matches the actual length of the stream
	 */
	@Override
	public Boolean getisLengthCorrect() {
		return Boolean.valueOf(this.isLengthCorrect);
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
				} else if (decodeParms.getType() == COSObjType.COS_ARRAY && decodeParms.size().intValue() > i) {
					decodeParms = decodeParms.at(i).get();
					result.add(createFilter((COSName) COSName.fromValue(filter), decodeParms));
				} else {
					LOGGER.log(Level.WARNING, "Invalid decodeParms type. Ignoring decodeParms.");
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
			LOGGER.log(Level.WARNING, "Invalid decodeParms type. Ignoring decodeParms.");
			return new GFCosFilter(filter, null);
		}
	}

	private static Long parseLength(final COSStream stream) {
		COSBase number = stream.getKey(ASAtom.LENGTH).getDirectBase();
		return number instanceof COSNumber ? number.getInteger() : null;
	}

	private static String parseFilters(COSBase base) {
		StringBuilder filters = new StringBuilder();

		if (base == null) {
			return null;
		} else if (base instanceof COSName) {
			return base.getString();
		} else if (base instanceof COSArray) {
			Iterator<?> iterator = ((COSArray) base).iterator();
			while (iterator.hasNext()) {
				COSBase filter = (COSBase) iterator.next();
				if (filter instanceof COSName) {
					filters.append(((COSName) filter).getName()).append(" ");
				} else {
					LOGGER.log(Level.SEVERE, "Incorrect type for stream filter " +
							filter.getClass().getName());
				}
			}
		} else {
			LOGGER.log(Level.SEVERE, "Incorrect type for stream filter " +
					base.getClass().getName());
			return null;
		}
		// need to discard last white space
		return filters.substring(0, filters.length() - 1);
	}

}
