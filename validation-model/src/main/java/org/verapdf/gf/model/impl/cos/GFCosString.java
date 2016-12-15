package org.verapdf.gf.model.impl.cos;

import org.verapdf.cos.COSString;
import org.verapdf.model.coslayer.CosString;

/**
 * @author Timur Kamalov
 */
public class GFCosString extends GFCosObject implements CosString {

	/** Type name for GFCosString */
	public static final String COS_STRING_TYPE = "CosString";
	private final byte[] value;
	private final boolean isHex;
	private final boolean containsOnlyHex;
	private final long hexCount;

	/**
	 * Default constructor
	 * @param cosString greenfield COSString
	 */
	public GFCosString(COSString cosString) {
		this(cosString, COS_STRING_TYPE);
	}

	/**
	 * Constructor for child classes
	 * @param cosString is greenfield COSString.
	 * @param type child class type.
	 */
	public GFCosString(COSString cosString, final String type) {
		super(cosString, type);
		this.value = cosString.get();
		this.isHex = cosString.isHexadecimal();
		this.containsOnlyHex = cosString.isContainsOnlyHex();
		this.hexCount = cosString.getHexCount();
	}

	/**
	 * Get string value stored in the PDF object
	 */
	@Override
	public String getvalue() {
		return new String(this.value);
	}

	/**
	 * true if the string is stored in Hex format
	 */
	@Override
	public Boolean getisHex() {
		return Boolean.valueOf(this.isHex);
	}

	/**
	 * true if all symbols below range 0-9,a-f,A-F
	 */
	@Override
	public Boolean getcontainsOnlyHex() {
		return Boolean.valueOf(this.containsOnlyHex);
	}

	/**
	 * contains original hexa string length
	 */
	@Override
	public Long gethexCount() {
		return Long.valueOf(this.hexCount);
	}

}
