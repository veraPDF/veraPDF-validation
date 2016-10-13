package org.verapdf.gf.model.impl.external;

import org.verapdf.external.ICCProfile;

/**
 * @author Maksim Bezrukov
 */
public class GFICCProfile extends GFExternal implements org.verapdf.model.external.ICCProfile {

	private final ICCProfile iccProfile;

	protected GFICCProfile(ICCProfile iccProfile, String type) {
		super(type);
		this.iccProfile = iccProfile;
	}

	/**
	 * @return number of colorants for ICC profile, described in profile
	 *         dictionary
	 */
	@Override
	public Long getN() {
		return this.iccProfile.getNumberOfColorants();
	}

	/**
	 * @return string representation of device class or null, if profile length
	 *         is too small
	 */
	@Override
	public String getdeviceClass() {
		return this.iccProfile.getDeviceClass();
	}

	/**
	 * @return string representation of color space or null, if profile length
	 *         is too small
	 */
	@Override
	public String getcolorSpace() {
		return this.iccProfile.getColorSpace();
	}

	/**
	 * @return version of ICC profile or null, if profile length is too small
	 */
	@Override
	public Double getversion() {
		return this.iccProfile.getVersion();
	}

	/**
	 * Indicate validity of icc profile.
	 *
	 * @return true if profile header looks valid
	 */
	@Override
	public Boolean getisValid() {
		return this.iccProfile.isLooksValid();
	}
}
