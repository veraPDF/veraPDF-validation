package org.verapdf.model.impl.external;

import org.verapdf.external.ICCProfile;
import org.verapdf.model.external.ICCInputProfile;

/**
 * @author Maksim Bezrukov
 */
public class GFICCInputProfile extends GFICCProfile implements ICCInputProfile {

	/** Type name for {@code GFICCInputProfile} */
	public static final String ICC_INPUT_PROFILE_TYPE = "ICCInputProfile";

	/**
	 * Default constructor.
	 *
	 * @param iccProfile iccprofile object of profile
	 */
	public GFICCInputProfile(ICCProfile iccProfile) {
		super(iccProfile, ICC_INPUT_PROFILE_TYPE);
	}
}
