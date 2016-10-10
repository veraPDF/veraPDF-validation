package org.verapdf.gf.model.impl.cos;

import org.verapdf.cos.COSNull;
import org.verapdf.model.coslayer.CosNull;

/**
 * @author Timur Kamalov
 */
public class GFCosNull extends GFCosObject implements CosNull {

	/** Type name for GFCosNull */
	public static final String COS_NULL_TYPE = "CosNull";

	/**
	 * PDF null object
	 */
	private static CosNull NULL;

	private GFCosNull(COSNull nil) {
		super(nil, COS_NULL_TYPE);
	}

	/**
	 * Method to get instance of PBCosNull object
	 * @return PBCosNull object
	 */
	public static CosNull getInstance() {
		return NULL == null ? NULL = new GFCosNull(COSNull.NULL) : NULL;
	}

}
