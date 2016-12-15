package org.verapdf.gf.model.impl.pd;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.model.pdlayer.PDOCConfig;
import org.verapdf.pd.PDObject;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Timur Kamalov
 */
public class GFPDOCConfig extends GFPDObject implements PDOCConfig {

	public static final Logger LOGGER = Logger.getLogger(GFPDOCConfig.class.getCanonicalName());

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
				for (int i = 0; i < order.size().intValue(); i++) {
					COSObject element = order.at(i);
					if (element.getType() == COSObjType.COS_ARRAY) {
						groupsInOrder += getLenghtOfFlattenArray((COSArray)
								element.getDirectBase());
						if (!checkCOSArrayInOrder(element).booleanValue()) {
							return Boolean.FALSE;
						}
					} else if (element.getType() == COSObjType.COS_STRING) {
						groupsInOrder++;
						if (!checkCOSStringInOrder(element).booleanValue()) {
							return Boolean.FALSE;
						}
					} else if (element.getType() == COSObjType.COS_DICT) {
						groupsInOrder++;
						if (!checkCOSDictionaryInOrder(element).booleanValue()) {
							return Boolean.FALSE;
						}
					} else {
						LOGGER.log(Level.FINE, "Invalid object type in order array. Ignoring the object.");
					}
				}
				if (groupsInOrder < groupNames.size()) {
					return Boolean.FALSE;
				}
			} else {
				LOGGER.log(Level.FINE, "Invalid object type of Order entry. Ignoring the Order entry.");
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
				for (int i = 0; i < asArray.size().intValue(); i++) {
					COSObject element = asArray.at(i);
					if (element.getType() == COSObjType.COS_DICT) {
						String event = element.getStringKey(ASAtom.EVENT);
						if (event != null && !event.isEmpty()) {
							result = result.concat(event);
						}
					} else {
						LOGGER.log(Level.FINE, "Invalid object type in the AS array. Ignoring the object.");
					}
				}
				return result;
			}
			LOGGER.log(Level.FINE, "Invalid object type of AS entry. Ignoring the entry.");
			return result;
		}
		return null;
	}

	@Override
	public Boolean gethasDuplicateName() {
		return Boolean.valueOf(this.duplicateName);
	}

	@Override
	public String getName() {
		return this.simplePDObject.getObject().getStringKey(ASAtom.NAME);
	}

	private Boolean checkCOSArrayInOrder(COSObject array) {
		for (int i = 0; i < array.size().intValue(); i++) {
			COSObject element = array.at(i);
			if (element.getType() == COSObjType.COS_ARRAY) {
				if (!checkCOSArrayInOrder(element).booleanValue()) {
					return Boolean.FALSE;
				}
			} else if (element.getType() == COSObjType.COS_STRING) {
				if (!checkCOSStringInOrder(element).booleanValue()) {
					return Boolean.FALSE;
				}
			} else if (element.getType() == COSObjType.COS_DICT) {
				if (!checkCOSDictionaryInOrder(element).booleanValue()) {
					return Boolean.FALSE;
				}
			}
		}
		return Boolean.TRUE;
	}

	private Boolean checkCOSStringInOrder(COSObject element) {
		return Boolean.valueOf(!groupNames.contains((element).getString()));
	}

	private Boolean checkCOSDictionaryInOrder(COSObject element) {
		return Boolean.valueOf(groupNames.contains(element.getStringKey(ASAtom.NAME)));
	}

	private static int getLenghtOfFlattenArray(COSArray array) {
		int res = 0;
		for (int i = 0; i < array.size(); i++) {
			COSObject element = array.at(i);
			if (element.getType() == COSObjType.COS_ARRAY) {
				res += getLenghtOfFlattenArray((COSArray) element.getDirectBase());
			} else {
				res++;
			}
		}
		return res;
	}
}