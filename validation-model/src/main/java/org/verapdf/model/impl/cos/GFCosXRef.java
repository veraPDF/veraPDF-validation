package org.verapdf.model.impl.cos;

import org.verapdf.model.coslayer.CosXRef;

/**
 * @author Timur Kamalov
 */
public class GFCosXRef extends GFCosObject implements CosXRef {

	/** Type name for PBCosXRef */
	public static final String COS_XREF_TYPE = "CosXRef";

	private Boolean subsectionHeaderSpaceSeparated;
	private Boolean xrefEOLMarkersComplyPDFA;

	/**
	 * Default constructor
	 * @param subsectionHeaderSpaceSeparated is xref header spacings comply pdfa specification
	 * @param xrefEOLMarkersComplyPDFA is xref eol spacings comply pdfa
	 */
	public GFCosXRef(Boolean subsectionHeaderSpaceSeparated,
					 Boolean xrefEOLMarkersComplyPDFA) {
		super(COS_XREF_TYPE);
		this.subsectionHeaderSpaceSeparated = subsectionHeaderSpaceSeparated;
		this.xrefEOLMarkersComplyPDFA = xrefEOLMarkersComplyPDFA;
	}

	/**
	 * true if header of cross reference table complies PDF/A standard
	 */
	@Override
	public Boolean getsubsectionHeaderSpaceSeparated() {
		return this.subsectionHeaderSpaceSeparated;
	}

	/**
	 * true if EOL
	 */
	@Override
	public Boolean getxrefEOLMarkersComplyPDFA() {
		return this.xrefEOLMarkersComplyPDFA;
	}

}
