package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.PDNameTreeNode;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;

public class GFATransition extends GFAObject implements ATransition {

	public GFATransition(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ATransition");
	}

	@Override
	public Boolean getcontainsB() {
		return this.baseObject.knownKey(ASAtom.getASAtom("B"));
	}

	public COSObject getBDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getBValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("B"));
		if (object == null || object.empty()) {
			object = getBDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getBHasTypeBoolean() {
		COSObject B = getBValue();
		return getHasTypeBoolean(B);
	}

	@Override
	public Boolean getcontainsD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("D"));
	}

	public COSObject getDDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1D);
		}
		return null;
	}

	public COSObject getDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		if (object == null || object.empty()) {
			object = getDDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getDHasTypeNumber() {
		COSObject D = getDValue();
		return getHasTypeNumber(D);
	}

	@Override
	public Double getDNumberValue() {
		COSObject D = getDValue();
		return getNumberValue(D);
	}

	@Override
	public Boolean getcontainsDi() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Di"));
	}

	public COSObject getDiDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(0L);
		}
		return null;
	}

	public COSObject getDiValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Di"));
		if (object == null || object.empty()) {
			object = getDiDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getDiHasTypeInteger() {
		COSObject Di = getDiValue();
		return getHasTypeInteger(Di);
	}

	@Override
	public Boolean getDiHasTypeName() {
		COSObject Di = getDiValue();
		return getHasTypeName(Di);
	}

	@Override
	public Long getDiIntegerValue() {
		COSObject Di = getDiValue();
		return getIntegerValue(Di);
	}

	@Override
	public String getDiNameValue() {
		COSObject Di = getDiValue();
		return getNameValue(Di);
	}

	@Override
	public Boolean getcontainsDm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Dm"));
	}

	public COSObject getDmDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("H");
		}
		return null;
	}

	public COSObject getDmValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Dm"));
		if (object == null || object.empty()) {
			object = getDmDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getDmHasTypeName() {
		COSObject Dm = getDmValue();
		return getHasTypeName(Dm);
	}

	@Override
	public String getDmNameValue() {
		COSObject Dm = getDmValue();
		return getNameValue(Dm);
	}

	@Override
	public Boolean getcontainsM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("M"));
	}

	public COSObject getMDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("I");
		}
		return null;
	}

	public COSObject getMValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("M"));
		if (object == null || object.empty()) {
			object = getMDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getMHasTypeName() {
		COSObject M = getMValue();
		return getHasTypeName(M);
	}

	@Override
	public String getMNameValue() {
		COSObject M = getMValue();
		return getNameValue(M);
	}

	@Override
	public Boolean getcontainsS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("S"));
	}

	public COSObject getSDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("R");
		}
		return null;
	}

	public COSObject getSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		if (object == null || object.empty()) {
			object = getSDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getSHasTypeName() {
		COSObject S = getSValue();
		return getHasTypeName(S);
	}

	@Override
	public String getSNameValue() {
		COSObject S = getSValue();
		return getNameValue(S);
	}

	@Override
	public Boolean getcontainsSS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SS"));
	}

	public COSObject getSSDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSReal.construct(1.0D);
		}
		return null;
	}

	public COSObject getSSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SS"));
		if (object == null || object.empty()) {
			object = getSSDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getSSHasTypeNumber() {
		COSObject SS = getSSValue();
		return getHasTypeNumber(SS);
	}

	@Override
	public Double getSSNumberValue() {
		COSObject SS = getSSValue();
		return getNumberValue(SS);
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	public COSObject getTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object;
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject Type = getTypeValue();
		return getHasTypeName(Type);
	}

	@Override
	public String getTypeNameValue() {
		COSObject Type = getTypeValue();
		return getNameValue(Type);
	}

}
