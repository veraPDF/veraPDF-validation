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

public class GFACIP4_IntentSummary extends GFAObject implements ACIP4_IntentSummary {

	public GFACIP4_IntentSummary(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACIP4_IntentSummary");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CIP4_AssemblingIntent":
				return getCIP4_AssemblingIntent();
			case "CIP4_BindingIntent":
				return getCIP4_BindingIntent();
			case "CIP4_ColorIntent":
				return getCIP4_ColorIntent();
			case "CIP4_FoldingIntent":
				return getCIP4_FoldingIntent();
			case "CIP4_HoleMakingIntent":
				return getCIP4_HoleMakingIntent();
			case "CIP4_LayoutIntent":
				return getCIP4_LayoutIntent();
			case "CIP4_MediaIntent":
				return getCIP4_MediaIntent();
			case "CIP4_ProductionIntent":
				return getCIP4_ProductionIntent();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfCIP4_AssemblingIntent> getCIP4_AssemblingIntent() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_AssemblingIntent1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_AssemblingIntent> getCIP4_AssemblingIntent1_7() {
		COSObject object = getCIP4_AssemblingIntentValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIP4_AssemblingIntent> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIP4_AssemblingIntent((COSArray)object.getDirectBase(), this.baseObject, "CIP4_AssemblingIntent"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfCIP4_BindingIntent> getCIP4_BindingIntent() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_BindingIntent1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_BindingIntent> getCIP4_BindingIntent1_7() {
		COSObject object = getCIP4_BindingIntentValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIP4_BindingIntent> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIP4_BindingIntent((COSArray)object.getDirectBase(), this.baseObject, "CIP4_BindingIntent"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfCIP4_ColorIntent> getCIP4_ColorIntent() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_ColorIntent1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_ColorIntent> getCIP4_ColorIntent1_7() {
		COSObject object = getCIP4_ColorIntentValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIP4_ColorIntent> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIP4_ColorIntent((COSArray)object.getDirectBase(), this.baseObject, "CIP4_ColorIntent"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfCIP4_FoldingIntent> getCIP4_FoldingIntent() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_FoldingIntent1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_FoldingIntent> getCIP4_FoldingIntent1_7() {
		COSObject object = getCIP4_FoldingIntentValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIP4_FoldingIntent> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIP4_FoldingIntent((COSArray)object.getDirectBase(), this.baseObject, "CIP4_FoldingIntent"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfCIP4_HoleMakingIntent> getCIP4_HoleMakingIntent() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_HoleMakingIntent1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_HoleMakingIntent> getCIP4_HoleMakingIntent1_7() {
		COSObject object = getCIP4_HoleMakingIntentValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIP4_HoleMakingIntent> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIP4_HoleMakingIntent((COSArray)object.getDirectBase(), this.baseObject, "CIP4_HoleMakingIntent"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfCIP4_LayoutIntent> getCIP4_LayoutIntent() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_LayoutIntent1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_LayoutIntent> getCIP4_LayoutIntent1_7() {
		COSObject object = getCIP4_LayoutIntentValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIP4_LayoutIntent> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIP4_LayoutIntent((COSArray)object.getDirectBase(), this.baseObject, "CIP4_LayoutIntent"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfCIP4_MediaIntent> getCIP4_MediaIntent() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_MediaIntent1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_MediaIntent> getCIP4_MediaIntent1_7() {
		COSObject object = getCIP4_MediaIntentValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIP4_MediaIntent> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIP4_MediaIntent((COSArray)object.getDirectBase(), this.baseObject, "CIP4_MediaIntent"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfCIP4_ProductionIntent> getCIP4_ProductionIntent() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_21812() == true)) {
					return getCIP4_ProductionIntent1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfCIP4_ProductionIntent> getCIP4_ProductionIntent1_7() {
		COSObject object = getCIP4_ProductionIntentValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfCIP4_ProductionIntent> list = new ArrayList<>(1);
			list.add(new GFAArrayOfCIP4_ProductionIntent((COSArray)object.getDirectBase(), this.baseObject, "CIP4_ProductionIntent"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCIP4_AssemblingIntent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_AssemblingIntent"));
	}

	public COSObject getCIP4_AssemblingIntentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_AssemblingIntent"));
		return object;
	}

	@Override
	public String getCIP4_AssemblingIntentType() {
		COSObject CIP4_AssemblingIntent = getCIP4_AssemblingIntentValue();
		return getObjectType(CIP4_AssemblingIntent);
	}

	@Override
	public Boolean getCIP4_AssemblingIntentHasTypeArray() {
		COSObject CIP4_AssemblingIntent = getCIP4_AssemblingIntentValue();
		return getHasTypeArray(CIP4_AssemblingIntent);
	}

	@Override
	public Boolean getcontainsCIP4_BindingIntent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_BindingIntent"));
	}

	public COSObject getCIP4_BindingIntentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_BindingIntent"));
		return object;
	}

	@Override
	public String getCIP4_BindingIntentType() {
		COSObject CIP4_BindingIntent = getCIP4_BindingIntentValue();
		return getObjectType(CIP4_BindingIntent);
	}

	@Override
	public Boolean getCIP4_BindingIntentHasTypeArray() {
		COSObject CIP4_BindingIntent = getCIP4_BindingIntentValue();
		return getHasTypeArray(CIP4_BindingIntent);
	}

	@Override
	public Boolean getcontainsCIP4_ColorIntent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_ColorIntent"));
	}

	public COSObject getCIP4_ColorIntentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_ColorIntent"));
		return object;
	}

	@Override
	public String getCIP4_ColorIntentType() {
		COSObject CIP4_ColorIntent = getCIP4_ColorIntentValue();
		return getObjectType(CIP4_ColorIntent);
	}

	@Override
	public Boolean getCIP4_ColorIntentHasTypeArray() {
		COSObject CIP4_ColorIntent = getCIP4_ColorIntentValue();
		return getHasTypeArray(CIP4_ColorIntent);
	}

	@Override
	public Boolean getcontainsCIP4_FoldingIntent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_FoldingIntent"));
	}

	public COSObject getCIP4_FoldingIntentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_FoldingIntent"));
		return object;
	}

	@Override
	public String getCIP4_FoldingIntentType() {
		COSObject CIP4_FoldingIntent = getCIP4_FoldingIntentValue();
		return getObjectType(CIP4_FoldingIntent);
	}

	@Override
	public Boolean getCIP4_FoldingIntentHasTypeArray() {
		COSObject CIP4_FoldingIntent = getCIP4_FoldingIntentValue();
		return getHasTypeArray(CIP4_FoldingIntent);
	}

	@Override
	public Boolean getcontainsCIP4_HoleMakingIntent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_HoleMakingIntent"));
	}

	public COSObject getCIP4_HoleMakingIntentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_HoleMakingIntent"));
		return object;
	}

	@Override
	public String getCIP4_HoleMakingIntentType() {
		COSObject CIP4_HoleMakingIntent = getCIP4_HoleMakingIntentValue();
		return getObjectType(CIP4_HoleMakingIntent);
	}

	@Override
	public Boolean getCIP4_HoleMakingIntentHasTypeArray() {
		COSObject CIP4_HoleMakingIntent = getCIP4_HoleMakingIntentValue();
		return getHasTypeArray(CIP4_HoleMakingIntent);
	}

	@Override
	public Boolean getcontainsCIP4_LayoutIntent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_LayoutIntent"));
	}

	public COSObject getCIP4_LayoutIntentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_LayoutIntent"));
		return object;
	}

	@Override
	public String getCIP4_LayoutIntentType() {
		COSObject CIP4_LayoutIntent = getCIP4_LayoutIntentValue();
		return getObjectType(CIP4_LayoutIntent);
	}

	@Override
	public Boolean getCIP4_LayoutIntentHasTypeArray() {
		COSObject CIP4_LayoutIntent = getCIP4_LayoutIntentValue();
		return getHasTypeArray(CIP4_LayoutIntent);
	}

	@Override
	public Boolean getcontainsCIP4_MediaIntent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_MediaIntent"));
	}

	public COSObject getCIP4_MediaIntentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_MediaIntent"));
		return object;
	}

	@Override
	public String getCIP4_MediaIntentType() {
		COSObject CIP4_MediaIntent = getCIP4_MediaIntentValue();
		return getObjectType(CIP4_MediaIntent);
	}

	@Override
	public Boolean getCIP4_MediaIntentHasTypeArray() {
		COSObject CIP4_MediaIntent = getCIP4_MediaIntentValue();
		return getHasTypeArray(CIP4_MediaIntent);
	}

	@Override
	public Boolean getcontainsCIP4_ProductionIntent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CIP4_ProductionIntent"));
	}

	public COSObject getCIP4_ProductionIntentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CIP4_ProductionIntent"));
		return object;
	}

	@Override
	public String getCIP4_ProductionIntentType() {
		COSObject CIP4_ProductionIntent = getCIP4_ProductionIntentValue();
		return getObjectType(CIP4_ProductionIntent);
	}

	@Override
	public Boolean getCIP4_ProductionIntentHasTypeArray() {
		COSObject CIP4_ProductionIntent = getCIP4_ProductionIntentValue();
		return getHasTypeArray(CIP4_ProductionIntent);
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
