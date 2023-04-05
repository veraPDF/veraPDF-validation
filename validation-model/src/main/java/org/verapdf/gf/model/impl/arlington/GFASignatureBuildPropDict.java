package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.model.tools.constants.Operators;
import org.verapdf.operator.Operator;
import org.verapdf.as.io.ASInputStream;
import org.verapdf.parser.PDFStreamParser;
import org.verapdf.pd.structure.NameTreeIterator;
import java.io.IOException;

public class GFASignatureBuildPropDict extends GFAObject implements ASignatureBuildPropDict {

	public GFASignatureBuildPropDict(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ASignatureBuildPropDict");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "App":
				return getApp();
			case "Filter":
				return getFilter();
			case "PubSec":
				return getPubSec();
			case "SigQ":
				return getSigQ();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ASignatureBuildDataAppDict> getApp() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getApp1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ASignatureBuildDataAppDict> getApp1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("App"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ASignatureBuildDataAppDict> list = new ArrayList<>(1);
			list.add(new GFASignatureBuildDataAppDict((COSDictionary)object.getDirectBase(), this.baseObject, "App"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ASignatureBuildDataDict> getFilter() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFilter1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ASignatureBuildDataDict> getFilter1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ASignatureBuildDataDict> list = new ArrayList<>(1);
			list.add(new GFASignatureBuildDataDict((COSDictionary)object.getDirectBase(), this.baseObject, "Filter"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ASignatureBuildDataDict> getPubSec() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPubSec1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ASignatureBuildDataDict> getPubSec1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PubSec"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ASignatureBuildDataDict> list = new ArrayList<>(1);
			list.add(new GFASignatureBuildDataDict((COSDictionary)object.getDirectBase(), this.baseObject, "PubSec"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ASignatureBuildDataSigQDict> getSigQ() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSigQ1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ASignatureBuildDataSigQDict> getSigQ1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SigQ"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ASignatureBuildDataSigQDict> list = new ArrayList<>(1);
			list.add(new GFASignatureBuildDataSigQDict((COSDictionary)object.getDirectBase(), this.baseObject, "SigQ"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsApp() {
		return this.baseObject.knownKey(ASAtom.getASAtom("App"));
	}

	@Override
	public Boolean getisAppIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("App"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getAppHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("App"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsPubSec() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PubSec"));
	}

	@Override
	public Boolean getisPubSecIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PubSec"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getPubSecHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PubSec"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsFilter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Filter"));
	}

	@Override
	public Boolean getisFilterIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getFilterHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Filter"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsSigQ() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SigQ"));
	}

	@Override
	public Boolean getisSigQIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SigQ"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getSigQHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SigQ"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

}
