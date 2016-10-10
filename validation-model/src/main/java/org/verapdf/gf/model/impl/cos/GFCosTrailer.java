package org.verapdf.gf.model.impl.cos;

import org.apache.log4j.Logger;
import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSIndirect;
import org.verapdf.cos.COSObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosIndirect;
import org.verapdf.model.coslayer.CosTrailer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFCosTrailer extends GFCosDict implements CosTrailer {

	private static final Logger LOGGER = Logger.getLogger(GFCosTrailer.class);

	/** Type name for GFCosTrailer */
	public static final String COS_TRAILER_TYPE = "CosTrailer";

	public static final String CATALOG = "Catalog";

	private final boolean isEncrypted;

	/**
	 * Default constructor
	 * @param dictionary greenfield COSDictionary
	 */
	public GFCosTrailer(COSDictionary dictionary) {
		super(dictionary, COS_TRAILER_TYPE);
		this.isEncrypted = dictionary.getKey(ASAtom.ENCRYPT).get() != null;
	}

	/**
	 * @return true if the current document is encrypted
	 */
	@Override
	public Boolean getisEncrypted() {
		return Boolean.valueOf(this.isEncrypted);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (CATALOG.equals(link)) {
			return this.getCatalog();
		}
		return super.getLinkedObjects(link);
	}

	private List<CosIndirect> getCatalog() {
		List<CosIndirect> result = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
		COSObject catalog = this.baseObject.getKey(ASAtom.ROOT);
		if (catalog.isIndirect()) {
			result.add(new GFCosIndirect((COSIndirect) catalog.get()));
		} else {
			LOGGER.warn("Catalog shall be an indirect reference");
		}
		return Collections.unmodifiableList(result);
	}

}
