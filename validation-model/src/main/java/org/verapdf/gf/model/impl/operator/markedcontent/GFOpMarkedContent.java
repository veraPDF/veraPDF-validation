package org.verapdf.gf.model.impl.operator.markedcontent;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.*;
import org.verapdf.gf.model.impl.cos.GFCosDict;
import org.verapdf.gf.model.impl.cos.GFCosLang;
import org.verapdf.gf.model.impl.cos.GFCosName;
import org.verapdf.gf.model.impl.operator.base.GFOperator;
import org.verapdf.model.coslayer.CosDict;
import org.verapdf.model.coslayer.CosLang;
import org.verapdf.model.coslayer.CosName;
import org.verapdf.model.operator.OpMarkedContent;

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

    public GFOpMarkedContent(List<COSBase> arguments, final String opType) {
        super(arguments, opType);
    }

    protected List<CosName> getTag() {
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
        if (!this.arguments.isEmpty()) {
			COSBase dict = this.arguments.get(this.arguments.size() - 1);
			if (dict.getType() == COSObjType.COS_DICT) {
				List<CosDict> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
				list.add(new GFCosDict((COSDictionary) dict));
				return Collections.unmodifiableList(list);
			}
        }
        return Collections.emptyList();
    }

	protected List<CosLang> getLang() {
		if (!this.arguments.isEmpty()) {
			COSBase dict = this.arguments.get(this.arguments.size() - 1);
			if (dict.getType() == COSObjType.COS_DICT) {
				COSObject baseLang = dict.getKey(ASAtom.LANG);
				if (baseLang != null && !baseLang.empty() && baseLang.get().getType() == COSObjType.COS_STRING) {
					List<CosLang> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
					list.add(new GFCosLang((COSString) baseLang.get()));
					return Collections.unmodifiableList(list);
				}
			}
		}
		return Collections.emptyList();
	}

}
