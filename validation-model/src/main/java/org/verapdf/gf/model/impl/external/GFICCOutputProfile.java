package org.verapdf.gf.model.impl.external;

import org.verapdf.external.ICCProfile;
import org.verapdf.model.external.ICCOutputProfile;

/**
 * @author Maksim Bezrukov
 */
public class GFICCOutputProfile extends GFICCProfile implements ICCOutputProfile {

	/**	Type name for {@code GFICCOutputProfile} */
	public static final String ICC_OUTPUT_PROFILE_TYPE = "ICCOutputProfile";

	private String subtype;

	/**
	 * Default constructor
	 *
	 * @param profile icc profile object
	 * @param subtype subtype value for current profile
	 */
	public GFICCOutputProfile(ICCProfile profile, String subtype) {
		super(profile, ICC_OUTPUT_PROFILE_TYPE);
		this.subtype = subtype;
	}

	/**
	 * @return subtype of output intent, which use current ICC profile
	 */
	@Override
	public String getS() {
		return this.subtype;
	}
}
