/**
 * This file is part of validation-model, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * validation-model is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with validation-model as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * validation-model as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.pd;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDOCConfig;
import org.verapdf.model.pdlayer.PDOCProperties;
import org.verapdf.pd.PDObject;
import org.verapdf.pd.optionalcontent.PDOptionalContentProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Timur Kamalov
 */
public class GFPDOCProperties extends GFPDObject implements PDOCProperties {

	private static final Logger LOGGER = Logger.getLogger(GFPDOCProperties.class.getCanonicalName());

	public static final String OC_PROPERTIES_TYPE = "PDOCProperties";

	public static final String D = "D";
	public static final String CONFIGS = "Configs";

	public GFPDOCProperties(PDOptionalContentProperties simplePDObject) {
		super(simplePDObject, OC_PROPERTIES_TYPE);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case D:
				return this.getD();
			case CONFIGS:
				return this.getConfigs();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<PDOCConfig> getD() {
		List<PDOCConfig> result = new ArrayList<>();

		COSObject contentProperties = this.simplePDObject.getObject();
		if (contentProperties.getType() == COSObjType.COS_DICT) {
			COSObject defaultConfig = contentProperties.getKey(ASAtom.D);
			if (!defaultConfig.empty() && defaultConfig.getType() == COSObjType.COS_DICT) {
				String[] groupNames = ((PDOptionalContentProperties) this.simplePDObject).getGroupNames();
				List<String> groupNamesList = Arrays.asList(groupNames == null ?
						new String[]{} : groupNames);

				PDOCConfig pdConfig = new GFPDOCConfig(new PDObject(defaultConfig), groupNamesList, false);

				result.add(pdConfig);
				return result;
			}
		} else {
			LOGGER.log(Level.FINE, "Invalid object type of the default optional configuration dictionary. Returning empty config.");
			PDOCConfig config = new GFPDOCConfig(new PDObject(COSDictionary.construct()));

			result.add(config);
			return result;
		}

		return result;
	}

	private List<PDOCConfig> getConfigs() {
		COSObject contentProperties = this.simplePDObject.getObject();

		List<String> names = getDName((COSDictionary) contentProperties.getDirectBase());
		String[] groupNames = ((PDOptionalContentProperties) this.simplePDObject).getGroupNames();
		List<String> groupNamesList = Arrays.asList(groupNames == null ?
				new String[]{} : groupNames);

		COSObject configs = contentProperties.getKey(ASAtom.CONFIGS);

		if (!configs.empty() && configs.getType() == COSObjType.COS_ARRAY) {
			List<PDOCConfig> result = new ArrayList<>();
			for (int i = 0; i < configs.size().intValue(); i++) {
				COSObject config = configs.at(i);
				if (!config.empty() && config.getType() == COSObjType.COS_DICT) {
					PDOCConfig pdConfig = new GFPDOCConfig(new PDObject(config), groupNamesList, names.contains(config.getStringKey(ASAtom.NAME)));
					String name = pdConfig.getName();
					if (name != null) {
						names.add(name);
					}
					result.add(pdConfig);
				} else {
					LOGGER.log(Level.FINE, "Invalid object type of the configuration dictionary. Ignoring config.");
				}
			}
			return result;
		}
		return Collections.emptyList();
	}

	private static List<String> getDName(final COSDictionary contentProperties) {
		List<String> result = new ArrayList<>();

		COSObject defaultConfig = contentProperties.getKey(ASAtom.D);
		if (defaultConfig.getType() == COSObjType.COS_DICT) {
			String name = defaultConfig.getStringKey(ASAtom.NAME);
			if (name != null) {
				result.add(name);
			}
		}

		return result;
	}

}
