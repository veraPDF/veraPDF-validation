/**
 * This file is part of feature-reporting, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 * <p>
 * feature-reporting is free software: you can redistribute it and/or modify
 * it under the terms of either:
 * <p>
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with feature-reporting as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 * <p>
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * feature-reporting as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.features.gf.objects;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSObject;
import org.verapdf.features.gf.tools.GFAdapterHelper;
import org.verapdf.features.objects.ColorSpaceFeaturesObjectAdapter;
import org.verapdf.pd.colors.*;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Features object for ColorSpace
 *
 * @author Maksim Bezrukov
 */
public class GFColorSpaceFeaturesObject implements ColorSpaceFeaturesObjectAdapter {

	private static final Logger LOGGER = Logger.getLogger(GFColorSpaceFeaturesObject.class.getCanonicalName());

	private PDColorSpace colorSpace;
	private String id;
	private String iccProfileChild;
	private String colorSpaceChild;
	private String lookup;
	private List<String> errors;

	/**
	 * Constructs new colorspace features object adapter
	 *
	 * @param colorSpace      PDColorSpace which represents colorspace for feature report
	 * @param id              id of the object
	 * @param iccProfileChild id of the iccprofile child
	 * @param colorSpaceChild id of the colorspace child
	 */
	public GFColorSpaceFeaturesObject(PDColorSpace colorSpace,
									  String id,
									  String iccProfileChild,
									  String colorSpaceChild) {
		this.colorSpace = colorSpace;
		this.id = id;
		this.iccProfileChild = iccProfileChild;
		this.colorSpaceChild = colorSpaceChild;
		init(colorSpace);
	}

	public void init(PDColorSpace colorSpace) {
		ASAtom colorSpaceType = colorSpace.getType();
		if (ASAtom.INDEXED.equals(colorSpaceType)) {
			PDIndexed index = (PDIndexed) colorSpace;
			try (InputStream stream = index.getLookup()) {
				byte[] lookupData = GFAdapterHelper.inputStreamToByteArray(stream);
				if (lookupData != null) {
					this.lookup = DatatypeConverter.printHexBinary(lookupData);
				}
			} catch (IOException e) {
				LOGGER.log(Level.FINE, e.getMessage(), e);
				this.errors = new ArrayList<>();
				this.errors.add("Problem during converting lookup value to hex string");
			}
		}
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getFamily() {
		return GFAdapterHelper.getStringFromASAtom(colorSpace.getType());
	}

	@Override
	public String getColorSpaceChild() {
		return this.colorSpaceChild;
	}

	@Override
	public String getICCProfileChild() {
		return this.iccProfileChild;
	}

	@Override
	public double[] getWhitePoint() {
		ASAtom colorSpaceType = colorSpace.getType();
		if (ASAtom.CALGRAY.equals(colorSpaceType)
				|| ASAtom.CALRGB.equals(colorSpaceType)
				|| ASAtom.LAB.equals(colorSpaceType)) {
			PDCIEDictionaryBased cie = (PDCIEDictionaryBased) colorSpace;
			return cie.getWhitePoint();
		}
		return null;
	}

	@Override
	public double[] getBlackPoint() {
		ASAtom colorSpaceType = colorSpace.getType();
		if (ASAtom.CALGRAY.equals(colorSpaceType)
				|| ASAtom.CALRGB.equals(colorSpaceType)
				|| ASAtom.LAB.equals(colorSpaceType)) {
			PDCIEDictionaryBased cie = (PDCIEDictionaryBased) colorSpace;
			return cie.getBlackPoint();
		}
		return null;
	}

	@Override
	public Double getCalGrayGamma() {
		ASAtom colorSpaceType = colorSpace.getType();
		if (ASAtom.CALGRAY.equals(colorSpaceType)) {
			PDCalGray calGray = (PDCalGray) colorSpace;
			return calGray.getGamma();
		}
		return null;
	}

	@Override
	public double[] getCalRGBGamma() {
		ASAtom colorSpaceType = colorSpace.getType();
		if (ASAtom.CALRGB.equals(colorSpaceType)) {
			PDCalRGB calRGB = (PDCalRGB) colorSpace;
			return calRGB.getGamma();
		}
		return null;
	}

	@Override
	public double[] getMatrix() {
		ASAtom colorSpaceType = colorSpace.getType();
		if (ASAtom.CALRGB.equals(colorSpaceType)) {
			PDCalRGB calRGB = (PDCalRGB) colorSpace;
			return calRGB.getMatrix();
		}
		return null;
	}

	@Override
	public double[] getLabRange() {
		ASAtom colorSpaceType = colorSpace.getType();
		if (ASAtom.LAB.equals(colorSpaceType)) {
			PDLab lab = (PDLab) colorSpace;
			return lab.getRange();
		}
		return null;
	}

	@Override
	public int getNumberOfComponents() {
		ASAtom colorSpaceType = colorSpace.getType();
		if (ASAtom.ICCBASED.equals(colorSpaceType)) {
			PDICCBased iccBased = (PDICCBased) colorSpace;
			return iccBased.getNumberOfComponents();
		}
		return 0;
	}

	@Override
	public Long getHival() {
		ASAtom colorSpaceType = colorSpace.getType();
		if (ASAtom.INDEXED.equals(colorSpaceType)) {
			PDIndexed indexed = (PDIndexed) colorSpace;
			return indexed.getHival();
		}
		return null;
	}

	@Override
	public String getHexEncodedLookup() {
		return this.lookup;
	}

	@Override
	public String getColorantName() {
		ASAtom colorSpaceType = colorSpace.getType();
		if (ASAtom.SEPARATION.equals(colorSpaceType)) {
			PDSeparation separation = (PDSeparation) colorSpace;
			return GFAdapterHelper.getStringFromCOSObject(separation.getColorantName());
		}
		return null;
	}

	@Override
	public List<String> getColorantNames() {
		ASAtom colorSpaceType = colorSpace.getType();
		if (ASAtom.DEVICEN.equals(colorSpaceType)) {
			PDDeviceN deviceN = (PDDeviceN) colorSpace;
			List<COSObject> names = deviceN.getNames();
			List<String> res = new ArrayList<>(names.size());
			for (COSObject name : names) {
				res.add(GFAdapterHelper.getStringFromCOSObject(name));
			}
			return Collections.unmodifiableList(res);
		}
		return Collections.emptyList();
	}

	@Override
	public List<String> getErrors() {
		return this.errors == null ? Collections.<String>emptyList() : Collections.unmodifiableList(this.errors);
	}
}
