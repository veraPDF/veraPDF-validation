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

public class GFACIP4_BindingIntent extends GFAObject implements ACIP4_BindingIntent {

	public GFACIP4_BindingIntent(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIP4_BindingIntent");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CIP4_SaddleStitching":
				return getCIP4_SaddleStitching();
			case "CIP4_SideStitching":
				return getCIP4_SideStitching();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ACIP4_SaddleStitching> getCIP4_SaddleStitching() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_SaddleStitching1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACIP4_SaddleStitching> getCIP4_SaddleStitching1_7() {
		COSObject object = getCIP4_SaddleStitchingValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACIP4_SaddleStitching> list = new ArrayList<>(1);
			list.add(new GFACIP4_SaddleStitching((COSDictionary)object.getDirectBase(), this.baseObject, "CIP4_SaddleStitching"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACIP4_SideStitching> getCIP4_SideStitching() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_SideStitching1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACIP4_SideStitching> getCIP4_SideStitching1_7() {
		COSObject object = getCIP4_SideStitchingValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACIP4_SideStitching> list = new ArrayList<>(1);
			list.add(new GFACIP4_SideStitching((COSDictionary)object.getDirectBase(), this.baseObject, "CIP4_SideStitching"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCIP4_BindingSide() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_BindingSide"));
	}

	public COSObject getCIP4_BindingSideValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_BindingSide"));
		return object;
	}

	@Override
	public String getCIP4_BindingSideType() {
		COSObject CIP4_BindingSide = getCIP4_BindingSideValue();
		return getObjectType(CIP4_BindingSide);
	}

	@Override
	public Boolean getCIP4_BindingSideHasTypeName() {
		COSObject CIP4_BindingSide = getCIP4_BindingSideValue();
		return getHasTypeName(CIP4_BindingSide);
	}

	@Override
	public String getCIP4_BindingSideNameValue() {
		COSObject CIP4_BindingSide = getCIP4_BindingSideValue();
		return getNameValue(CIP4_BindingSide);
	}

	@Override
	public Boolean getcontainsCIP4_BindingType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_BindingType"));
	}

	public COSObject getCIP4_BindingTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_BindingType"));
		return object;
	}

	@Override
	public String getCIP4_BindingTypeType() {
		COSObject CIP4_BindingType = getCIP4_BindingTypeValue();
		return getObjectType(CIP4_BindingType);
	}

	@Override
	public Boolean getCIP4_BindingTypeHasTypeName() {
		COSObject CIP4_BindingType = getCIP4_BindingTypeValue();
		return getHasTypeName(CIP4_BindingType);
	}

	@Override
	public String getCIP4_BindingTypeNameValue() {
		COSObject CIP4_BindingType = getCIP4_BindingTypeValue();
		return getNameValue(CIP4_BindingType);
	}

	@Override
	public Boolean getcontainsCIP4_SaddleStitching() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_SaddleStitching"));
	}

	public COSObject getCIP4_SaddleStitchingValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_SaddleStitching"));
		return object;
	}

	@Override
	public String getCIP4_SaddleStitchingType() {
		COSObject CIP4_SaddleStitching = getCIP4_SaddleStitchingValue();
		return getObjectType(CIP4_SaddleStitching);
	}

	@Override
	public Boolean getCIP4_SaddleStitchingHasTypeDictionary() {
		COSObject CIP4_SaddleStitching = getCIP4_SaddleStitchingValue();
		return getHasTypeDictionary(CIP4_SaddleStitching);
	}

	@Override
	public Boolean getcontainsCIP4_SideStitching() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_SideStitching"));
	}

	public COSObject getCIP4_SideStitchingValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_SideStitching"));
		return object;
	}

	@Override
	public String getCIP4_SideStitchingType() {
		COSObject CIP4_SideStitching = getCIP4_SideStitchingValue();
		return getObjectType(CIP4_SideStitching);
	}

	@Override
	public Boolean getCIP4_SideStitchingHasTypeDictionary() {
		COSObject CIP4_SideStitching = getCIP4_SideStitchingValue();
		return getHasTypeDictionary(CIP4_SideStitching);
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
	public String getTypeType() {
		COSObject Type = getTypeValue();
		return getObjectType(Type);
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
