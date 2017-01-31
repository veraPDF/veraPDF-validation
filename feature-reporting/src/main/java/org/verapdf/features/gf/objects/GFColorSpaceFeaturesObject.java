/**
 * This file is part of feature-reporting, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * feature-reporting is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with feature-reporting as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * feature-reporting as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.features.gf.objects;

import org.verapdf.as.ASAtom;
import org.verapdf.core.FeatureParsingException;
import org.verapdf.cos.COSObject;
import org.verapdf.features.FeatureExtractionResult;
import org.verapdf.features.FeatureObjectType;
import org.verapdf.features.FeaturesData;
import org.verapdf.features.IFeaturesObject;
import org.verapdf.features.gf.tools.GFCreateNodeHelper;
import org.verapdf.features.tools.ErrorsHelper;
import org.verapdf.features.tools.FeatureTreeNode;
import org.verapdf.pd.colors.*;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Features object for ColorSpace
 *
 * @author Maksim Bezrukov
 */
public class GFColorSpaceFeaturesObject implements IFeaturesObject {

	private static final String ID = "id";

	private static final Logger LOGGER = Logger.getLogger(GFColorSpaceFeaturesObject.class.getCanonicalName());

	private PDColorSpace colorSpace;
	private String id;
	private String iccProfileChild;
	private String colorSpaceChild;

	/**
	 * Constructs new colorspace features object
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
	}

	/**
	 * @return DOCUMENT_SECURITY instance of the FeatureObjectType enumeration
	 */
	@Override
	public FeatureObjectType getType() {
		return FeatureObjectType.COLORSPACE;
	}

	/**
	 * Reports featurereport into collection
	 *
	 * @param collection collection for feature report
	 * @return FeatureTreeNode class which represents a root node of the constructed collection tree
	 * @throws FeatureParsingException occurs when wrong features tree node constructs
	 */
	@Override
	public FeatureTreeNode reportFeatures(FeatureExtractionResult collection) throws FeatureParsingException {
		if (colorSpace != null && !colorSpace.empty()) {
			FeatureTreeNode root = FeatureTreeNode.createRootNode("colorSpace");

			if (id != null) {
				root.setAttribute(ID, id);
			}
			ASAtom colorSpaceType = colorSpace.getType();
			root.setAttribute("family", colorSpaceType.getValue());

			if (ASAtom.CALGRAY.equals(colorSpaceType)
					|| ASAtom.CALRGB.equals(colorSpaceType)
					|| ASAtom.LAB.equals(colorSpaceType)) {
				parseCIEDictionaryBased(root, collection);
			} else if (ASAtom.ICCBASED.equals(colorSpaceType)) {
				PDICCBased icc = (PDICCBased) colorSpace;
				if (colorSpaceChild != null) {
					FeatureTreeNode alt = root.addChild("alternate");
					alt.setAttribute(ID, colorSpaceChild);
				}
				root.addChild("components").setValue(String.valueOf(icc.getNumberOfComponents()));
				if (iccProfileChild != null) {
					FeatureTreeNode prof = root.addChild("iccProfile");
					prof.setAttribute(ID, iccProfileChild);
				}
			} else if (ASAtom.INDEXED.equals(colorSpaceType)) {
				parseIndexed(root, collection);
			} else if (ASAtom.SEPARATION.equals(colorSpaceType)) {
				PDSeparation sep = (PDSeparation) colorSpace;
				if (colorSpaceChild != null) {
					FeatureTreeNode alt = root.addChild("alternate");
					alt.setAttribute(ID, colorSpaceChild);
				}
				GFCreateNodeHelper.addNotEmptyNode("colorantName", sep.getColorantName(), root);
			} else if (ASAtom.DEVICEN.equals(colorSpaceType)) {
				PDDeviceN devN = (PDDeviceN) colorSpace;
				if (colorSpaceChild != null) {
					FeatureTreeNode alt = root.addChild("alternate");
					alt.setAttribute(ID, colorSpaceChild);
				}
				List<COSObject> devNColorantNames = devN.getNames();
				if (devNColorantNames != null) {
					FeatureTreeNode colorantNames = root.addChild("colorantNames");
					for (COSObject name : devNColorantNames) {
						GFCreateNodeHelper.addNotEmptyNode("colorantName", name, colorantNames);
					}
				}
			}

			collection.addNewFeatureTree(FeatureObjectType.COLORSPACE, root);
			return root;
		}

		return null;
	}

	/**
	 * @return null
	 */
	@Override
	public FeaturesData getData() {
		return null;
	}

	private void parseIndexed(FeatureTreeNode root, FeatureExtractionResult collection) throws FeatureParsingException {
		PDIndexed index = (PDIndexed) colorSpace;

		if (colorSpaceChild != null) {
			FeatureTreeNode alt = root.addChild("base");
			alt.setAttribute(ID, colorSpaceChild);
		}

		Long hival = index.getHival();
		if (hival != null) {
			GFCreateNodeHelper.addNotEmptyNode("hival", String.valueOf(hival.longValue()), root);
		}

		FeatureTreeNode lookup = root.addChild("lookup");
		try (InputStream stream = index.getLookup()) {
			byte[] lookupData = GFCreateNodeHelper.inputStreamToByteArray(stream);
			if (lookupData != null) {
				lookup.setValue(DatatypeConverter.printHexBinary(lookupData));
			}
		} catch (IOException e) {
			LOGGER.log(Level.FINE, e.getMessage(), e);
			ErrorsHelper.addErrorIntoCollection(collection,
					lookup,
					"Problem during converting lookup value to hex string");
		}
	}


	private void parseCIEDictionaryBased(FeatureTreeNode root, FeatureExtractionResult collection) throws FeatureParsingException {
		PDCIEDictionaryBased cie = (PDCIEDictionaryBased) colorSpace;

		parseTristimulus(cie.getWhitePoint(), root.addChild("whitePoint"), collection);
		parseTristimulus(cie.getBlackPoint(), root.addChild("blackPoint"), collection);

		ASAtom cieType = cie.getType();
		if (ASAtom.CALGRAY.equals(cieType)) {
			PDCalGray calGray = (PDCalGray) cie;
			Double gamma = calGray.getGamma();
			if (gamma != null) {
				GFCreateNodeHelper.addNotEmptyNode("gamma", String.valueOf(gamma), root);
			}
		} else if (ASAtom.CALRGB.equals(cieType)) {
			PDCalRGB calRGB = (PDCalRGB) cie;
			FeatureTreeNode gamma = root.addChild("gamma");
			double[] gammaValue = calRGB.getGamma();
			if (gammaValue == null) {
				ErrorsHelper.addErrorIntoCollection(collection, gamma,
						"Gamma value is not present");
			} else if (gammaValue.length < 3) {
				ErrorsHelper.addErrorIntoCollection(collection, gamma,
						"Gamma value contains less than three elements");
			} else {
				gamma.setAttribute("red", String.valueOf(gammaValue[0]));
				gamma.setAttribute("green", String.valueOf(gammaValue[1]));
				gamma.setAttribute("blue", String.valueOf(gammaValue[2]));
			}
			parseFloatArray(calRGB.getMatrix(), root.addChild("matrix"));
		} else if (cie instanceof PDLab) {
			PDLab lab = (PDLab) cie;
			FeatureTreeNode range = root.addChild("range");
			double[] rangeValue = lab.getRange();
			if (rangeValue.length < 4) {
				ErrorsHelper.addErrorIntoCollection(collection, range,
						"Gamma value contains less than three elements");
			} else {
				range.setAttribute("aMin", String.valueOf(rangeValue[0]));
				range.setAttribute("aMax", String.valueOf(rangeValue[1]));
				range.setAttribute("bMin", String.valueOf(rangeValue[2]));
				range.setAttribute("bMax", String.valueOf(rangeValue[3]));
			}
		}

	}

	private static void parseFloatArray(double[] array, FeatureTreeNode parent) throws FeatureParsingException {
		for (int i = 0; i < array.length; ++i) {
			FeatureTreeNode element = parent.addChild("element");
			element.setAttribute("number", String.valueOf(i));
			element.setAttribute("value", String.valueOf(array[i]));
		}
	}

	private static void parseTristimulus(double[] tris, FeatureTreeNode curNode, FeatureExtractionResult collection) {
		if (tris == null) {
			return;
		} else if (tris.length < 3) {
			ErrorsHelper.addErrorIntoCollection(collection, curNode,
					"Tristimulus value contains less than three elements");
		} else {
			curNode.setAttribute("x", String.valueOf(tris[0]));
			curNode.setAttribute("y", String.valueOf(tris[1]));
			curNode.setAttribute("z", String.valueOf(tris[2]));
		}
	}
}
