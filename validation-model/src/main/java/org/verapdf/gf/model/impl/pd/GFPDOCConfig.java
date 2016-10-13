package org.verapdf.gf.model.impl.pd;

import org.apache.log4j.Logger;
import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.model.pdlayer.PDOCConfig;
import org.verapdf.pd.PDObject;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFPDOCConfig extends GFPDObject implements PDOCConfig {

	public static final Logger LOGGER = Logger.getLogger(GFPDOCConfig.class);

	public static final String OC_CONFIG_TYPE = "PDOCConfig";

	public static final String EVENT_KEY = "Event";

	private final List<String> groupNames;
	private final boolean duplicateName;

	public GFPDOCConfig(PDObject simplePDObject) {
		super(simplePDObject, OC_CONFIG_TYPE);
		this.groupNames = null;
		this.duplicateName = false;
	}

	public GFPDOCConfig(PDObject simplePDObject, List<String> groupNames, boolean duplicateName) {
		super(simplePDObject, OC_CONFIG_TYPE);
		this.groupNames = groupNames;
		this.duplicateName = duplicateName;
	}

	@Override
	public Boolean getdoesOrderContainAllOCGs() {
		COSObject order = this.simplePDObject.getKey(ASAtom.ORDER);
		if (!order.empty()) {
			if (order.getType() == COSObjType.COS_ARRAY) {
				int groupsInOrder = 0;
				for (int i = 0; i < order.size(); i++) {
					COSObject element = order.at(i);
					if (element.getType() == COSObjType.COS_ARRAY) {
						groupsInOrder += element.size();
						if (!checkCOSArrayInOrder(element)) {
							return Boolean.FALSE;
						}
					} else if (element.getType() == COSObjType.COS_STRING) {
						groupsInOrder++;
						if (!checkCOSStringInOrder(element)) {
							return Boolean.FALSE;
						}
					} else if (element.getType() == COSObjType.COS_DICT) {
						groupsInOrder++;
						if (!checkCOSDictionaryInOrder(element)) {
							return Boolean.FALSE;
						}
					} else {
						LOGGER.debug("Invalid object type in order array. Ignoring the object.");
					}
				}
				if (groupsInOrder < groupNames.size()) {
					return Boolean.FALSE;
				}
			} else {
				LOGGER.debug("Invalid object type of Order entry. Ignoring the Order entry.");
			}
		}
		return Boolean.TRUE;
	}

	@Override
	public String getAS() {
		COSObject asArray = this.simplePDObject.getKey(ASAtom.AS);
		if (!asArray.empty()) {
			String result = "";
			if (asArray.getType() == COSObjType.COS_ARRAY) {
				for (int i = 0; i < asArray.size(); i++) {
					COSObject element = asArray.at(i);
					if (element.getType() == COSObjType.COS_DICT) {
						String event = element.getStringKey(ASAtom.EVENT);
						if (event != null && !event.isEmpty()) {
							result = result.concat(event);
						}
					} else {
						LOGGER.debug("Invalid object type in the AS array. Ignoring the object.");
					}
				}
				return result;
			} else {
				LOGGER.debug("Invalid object type of AS entry. Ignoring the entry.");
				return result;
			}
		} else {
			return null;
		}
	}

	@Override
	public Boolean gethasDuplicateName() {
		return this.duplicateName;
	}

	@Override
	public String getName() {
		return this.simplePDObject.getObject().getStringKey(ASAtom.NAME);
	}

	private Boolean checkCOSArrayInOrder(COSObject array) {
		for (int i = 0; i < array.size(); i++) {
			COSObject element = array.at(i);
			if (element.getType() == COSObjType.COS_STRING) {
				if (!checkCOSStringInOrder(element)) {
					return Boolean.FALSE;
				}
			} else if (element.getType() == COSObjType.COS_DICT) {
				if (!checkCOSDictionaryInOrder(element)) {
					return Boolean.FALSE;
				}
			}
		}
		return Boolean.TRUE;
	}

	private Boolean checkCOSStringInOrder(COSObject element) {
		if (!groupNames.contains((element).getString())) {
			return Boolean.FALSE;
		} else {
			return Boolean.TRUE;
		}
	}

	private Boolean checkCOSDictionaryInOrder(COSObject element) {
		if (!groupNames.contains(element.getStringKey(ASAtom.NAME))) {
			return Boolean.FALSE;
		} else {
			return Boolean.TRUE;
		}
	}

}