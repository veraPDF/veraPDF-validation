/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.operator.markedcontent;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.*;
import org.verapdf.gf.model.impl.cos.GFCosDict;
import org.verapdf.gf.model.impl.cos.GFCosLang;
import org.verapdf.gf.model.impl.cos.GFCosName;
import org.verapdf.gf.model.impl.operator.base.GFOperator;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.coslayer.CosDict;
import org.verapdf.model.coslayer.CosLang;
import org.verapdf.model.coslayer.CosName;
import org.verapdf.model.operator.OpMarkedContent;
import org.verapdf.pd.PDResource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public abstract class GFOpMarkedContent extends GFOperator implements OpMarkedContent {

	/** Name of link to the tag name */
    public static final String TAG = "tag";
	/** Name of link to the properties dictionary */
    public static final String PROPERTIES = "properties";
	/** Name of link to Lang value from the properties dictionary */
	public static final String LANG = "Lang";

	private COSDictionary propertiesDict;
	private final GFOpMarkedContent markedContent;
	private String parentsTags;

	public GFOpMarkedContent(List<COSBase> arguments, final String opType, PDResourcesHandler resources,
							 GFOpMarkedContent markedContent, String parentsTags) {
        super(arguments, opType);
		initializePropertiesDict(resources);
		this.markedContent = markedContent;
		this.parentsTags = parentsTags;
	}

	private void initializePropertiesDict(PDResourcesHandler resources) {
		if (!this.arguments.isEmpty()) {
			COSBase lastArg = this.arguments.get(this.arguments.size() - 1);
			COSObjType lastArgType = lastArg.getType();
			if (lastArgType == COSObjType.COS_DICT) {
				this.propertiesDict = (COSDictionary) lastArg;
			} else if (lastArgType == COSObjType.COS_NAME && resources != null) {
				PDResource properties = resources.getProperties(lastArg.getName());
				if (properties != null) {
					COSBase cosProperties = properties.getObject().getDirectBase();
					if (cosProperties != null && cosProperties.getType() == COSObjType.COS_DICT) {
						this.propertiesDict = (COSDictionary) cosProperties;
					}
				}
			}
		}
	}

    public List<CosName> getTag() {
        if (this.arguments.size() > 1) {
			COSBase name = this.arguments.get(this.arguments.size() - 2);
			if (name.getType() == COSObjType.COS_NAME) {
				List<CosName> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
				list.add(new GFCosName((COSName) name));
				return Collections.unmodifiableList(list);
			}
        }
        return Collections.emptyList();
    }

    protected List<CosDict> getPropertiesDict() {
		if (this.propertiesDict != null) {
			List<CosDict> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(new GFCosDict(this.propertiesDict));
			return Collections.unmodifiableList(list);
		}
        return Collections.emptyList();
    }

	public List<CosLang> getLang() {
    	COSObject lang = getAttribute(ASAtom.LANG, COSObjType.COS_STRING);
    	if (lang != null) {
			List<CosLang> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(new GFCosLang((COSString) lang.getDirectBase()));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	public String getParentsTags() {
		List<CosName> tagList = getTag();
		String tag = "";
		if (tagList.size() != 0) {
			tag = tagList.get(0).getinternalRepresentation();
		}
		String parentsTags = "";
		if (markedContent != null) {
			parentsTags = markedContent.getParentsTags();
		}
		if (parentsTags.isEmpty()) {
			parentsTags = this.parentsTags;
		} else if (!this.parentsTags.isEmpty()) {
			parentsTags = this.parentsTags + "&" + parentsTags;
		}
		if (tag.isEmpty()) {
			return parentsTags;
		}
		if (parentsTags.isEmpty()) {
			return tag;
		}
		return parentsTags + "&" + tag;
	}

	public String getParentLang() {
		if (markedContent == null) {
			return null;
		}
		List<CosLang> lang =  markedContent.getLang();
		if (lang != null && lang.size() != 0) {
			return lang.get(0).getunicodeValue();
		}
		if (markedContent.getObjectType().equals(GFOp_BDC.OP_BDC_TYPE)) {
			String structParentLang = ((GFOp_BDC)markedContent).getstructParentLang();
			if (structParentLang != null) {
				return structParentLang;
			}
		}
		return markedContent.getParentLang();
	}

	public String getParentStructureTag() {
		if (markedContent != null) {
			if (markedContent.getObjectType().equals(GFOp_BDC.OP_BDC_TYPE)) {
				String structTag = ((GFOp_BDC)markedContent).getstructureTag();
				if (structTag != null) {
					return structTag;
				}
			}
			return markedContent.getParentStructureTag();
		}
		return null;
	}

	/**
	 * Checks if attribute dict contains ActualText key and returns it's value.
	 *
	 * @return ActualText value or null if it is not present.
	 */
	public COSString getActualText() {
		COSObject actualText = getAttribute(ASAtom.ACTUAL_TEXT, COSObjType.COS_STRING);
		return actualText == null ? null : (COSString) actualText.get();
	}

	public COSString getE() {
		COSObject actualText = getAttribute(ASAtom.E, COSObjType.COS_STRING);
		return actualText == null ? null : (COSString) actualText.get();
	}

	public COSString getAlt() {
		COSObject actualText = getAttribute(ASAtom.ALT, COSObjType.COS_STRING);
		return actualText == null ? null : (COSString) actualText.get();
	}

	/**
	 * Checks if attribute dict contains MCID key and returns it's value.
	 *
	 * @return MCID value or value if it is not present.
	 */
	public Long getMCID() {
		COSObject mcid = getAttribute(ASAtom.MCID, COSObjType.COS_INTEGER);
		return mcid == null ? null : mcid.getInteger();
	}

	private COSObject getAttribute(ASAtom attributeName, COSObjType expectedType) {
		if (this.propertiesDict != null) {
			COSObject res = this.propertiesDict.getKey(attributeName);
			if (res != null && !res.empty() && res.getType() == expectedType) {
				return res;
			}
		}
		return null;
	}

	@Override
	public int hashCode() {
		return propertiesDict == null ? 0 : propertiesDict.hashCode();
	}
}
