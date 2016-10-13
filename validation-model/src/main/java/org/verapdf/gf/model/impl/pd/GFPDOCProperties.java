package org.verapdf.gf.model.impl.pd;

import org.apache.log4j.Logger;
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

/**
 * @author Timur Kamalov
 */
public class GFPDOCProperties extends GFPDObject implements PDOCProperties {

	private static final Logger LOGGER = Logger.getLogger(GFPDOCProperties.class);

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
				List<String> groupNamesList = Arrays.asList(groupNames);

				PDOCConfig pdConfig = new GFPDOCConfig(new PDObject(defaultConfig), groupNamesList, false);

				result.add(pdConfig);
				return result;
			}
		} else {
			LOGGER.debug("Invalid object type of the default optional configuration dictionary. Returning empty config.");
			PDOCConfig config = new GFPDOCConfig(new PDObject(COSDictionary.construct()));

			result.add(config);
			return result;
		}

		return result;
	}

	private List<PDOCConfig> getConfigs() {
		COSObject contentProperties = this.simplePDObject.getObject();

		List<String> names = getAllNames((COSDictionary) contentProperties.getDirectBase());
		String[] groupNames = ((PDOptionalContentProperties) this.simplePDObject).getGroupNames();
		List<String> groupNamesList = Arrays.asList(groupNames);

		COSObject configs = contentProperties.getKey(ASAtom.CONFIGS);

		if (!configs.empty() && configs.getType() == COSObjType.COS_ARRAY) {
			List<PDOCConfig> result = new ArrayList<>();
			for (int i = 0; i < configs.size(); i++) {
				COSObject config = configs.at(i);
				if (!config.empty() && config.getType() == COSObjType.COS_DICT) {
					PDOCConfig pdConfig = new GFPDOCConfig(new PDObject(config), groupNamesList, names.contains(config.getStringKey(ASAtom.NAME)));
					result.add(pdConfig);
				} else {
					LOGGER.debug("Invalid object type of the configuration dictionary. Ignoring config.");
				}
			}
			return result;
		} else {
			return Collections.emptyList();
		}
	}

	private List<String> getAllNames(final COSDictionary contentProperties) {
		List<String> result = new ArrayList<>();

		COSObject defaultConfig = contentProperties.getKey(ASAtom.D);
		if (defaultConfig.getType() == COSObjType.COS_DICT) {
			String name = defaultConfig.getStringKey(ASAtom.NAME);
			if (name != null) {
				result.add(name);
			}
		}

		COSObject configs = contentProperties.getKey(ASAtom.CONFIGS);
		if (!configs.empty() && configs.getType() == COSObjType.COS_ARRAY) {
			for (int i = 0; i < configs.size(); i++) {
				COSObject config = configs.at(i);
				if (!config.empty() && config.getType() == COSObjType.COS_DICT) {
					String name = config.getStringKey(ASAtom.NAME);
					if (name != null) {
						result.add(name);
					}
				}
			}
		}

		return result;
	}

}
