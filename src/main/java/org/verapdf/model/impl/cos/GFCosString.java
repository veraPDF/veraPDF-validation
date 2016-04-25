package org.verapdf.model.impl.cos;

import org.verapdf.cos.COSString;
import org.verapdf.model.coslayer.CosString;

/**
 * @author Timur Kamalov
 */
public class GFCosString extends GFCosObject implements CosString {

	/** Type name for GFCosString */
	public static final String COS_STRING_TYPE = "CosString";
	private final String value;
	private final boolean isHex;
	private final boolean containsOnlyHex;
	private final long hexCount;

	/**
	 * Default constructor
	 * @param cosString greenfield COSString
	 */
	public GFCosString(COSString cosString) {
		super(cosString, COS_STRING_TYPE);
		this.value = cosString.getLitString();
		this.isHex = cosString.isHexadecimal();
		this.containsOnlyHex = cosString.isContainsOnlyHex();
		this.hexCount = cosString.getHexCount();
	}

	/**
	 * Get Unicode string value stored in the PDF object
	 */
	@Override
	public String getvalue() {
		return this.value;
	}

	/**
	 * true if the string is stored in Hex format
	 */
	@Override
	public Boolean getisHex() {
		return this.isHex;
	}

	/**
	 * true if all symbols below range 0-9,a-f,A-F
	 */
	@Override
	public Boolean getcontainsOnlyHex() {
		return this.containsOnlyHex;
	}

	/**
	 * contains original hexa string length
	 */
	@Override
	public Long gethexCount() {
		return this.hexCount;
	}

}
