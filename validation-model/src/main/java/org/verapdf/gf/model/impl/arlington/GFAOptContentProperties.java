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

public class GFAOptContentProperties extends GFAObject implements AOptContentProperties {

	public GFAOptContentProperties(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOptContentProperties");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "D":
				return getD();
			case "OCGs":
				return getOCGs();
			case "Configs":
				return getConfigs();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AOptContentConfig> getD() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getD1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AOptContentConfig> getD1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AOptContentConfig> list = new ArrayList<>(1);
			list.add(new GFAOptContentConfig((COSDictionary)object.getDirectBase(), this.baseObject, "D"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfOCGindirect> getOCGs() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOCGs1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfOCGindirect> getOCGs1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OCGs"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfOCGindirect> list = new ArrayList<>(1);
			list.add(new GFAArrayOfOCGindirect((COSArray)object.getDirectBase(), this.baseObject, "OCGs"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfOCConfig> getConfigs() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getConfigs1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfOCConfig> getConfigs1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Configs"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfOCConfig> list = new ArrayList<>(1);
			list.add(new GFAArrayOfOCConfig((COSArray)object.getDirectBase(), this.baseObject, "Configs"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsConfigs() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Configs"));
	}

	@Override
	public Boolean getConfigsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Configs"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("D"));
	}

	@Override
	public Boolean getDHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsOCGs() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OCGs"));
	}

	@Override
	public Boolean getOCGsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OCGs"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

}
