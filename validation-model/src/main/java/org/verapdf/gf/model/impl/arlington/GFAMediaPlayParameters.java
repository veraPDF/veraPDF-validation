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

public class GFAMediaPlayParameters extends GFAObject implements AMediaPlayParameters {

	public GFAMediaPlayParameters(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AMediaPlayParameters");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "BE":
				return getBE();
			case "MH":
				return getMH();
			case "PL":
				return getPL();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AMediaPlayParametersBE> getBE() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBE1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AMediaPlayParametersBE> getBE1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BE"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AMediaPlayParametersBE> list = new ArrayList<>(1);
			list.add(new GFAMediaPlayParametersBE((COSDictionary)object.getDirectBase(), this.baseObject, "BE"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AMediaPlayParametersMH> getMH() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getMH1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AMediaPlayParametersMH> getMH1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MH"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AMediaPlayParametersMH> list = new ArrayList<>(1);
			list.add(new GFAMediaPlayParametersMH((COSDictionary)object.getDirectBase(), this.baseObject, "MH"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AMediaPlayers> getPL() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPL1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AMediaPlayers> getPL1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PL"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AMediaPlayers> list = new ArrayList<>(1);
			list.add(new GFAMediaPlayers((COSDictionary)object.getDirectBase(), this.baseObject, "PL"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsBE() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BE"));
	}

	@Override
	public Boolean getBEHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BE"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsMH() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MH"));
	}

	@Override
	public Boolean getMHHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MH"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsPL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PL"));
	}

	@Override
	public Boolean getPLHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PL"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		if (object == null || object.empty()) {
			return getTypeNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTypeNameDefaultValue() {
		return null;
	}

}
