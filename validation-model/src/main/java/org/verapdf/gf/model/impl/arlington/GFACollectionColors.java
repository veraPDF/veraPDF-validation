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

public class GFACollectionColors extends GFAObject implements ACollectionColors {

	public GFACollectionColors(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACollectionColors");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Background":
				return getBackground();
			case "CardBackground":
				return getCardBackground();
			case "CardBorder":
				return getCardBorder();
			case "PrimaryText":
				return getPrimaryText();
			case "SecondaryText":
				return getSecondaryText();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOf_3RGBNumbers> getBackground() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBackground1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_3RGBNumbers> getBackground1_7() {
		COSObject object = getBackgroundValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_3RGBNumbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_3RGBNumbers((COSArray)object.getDirectBase(), this.baseObject, "Background"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_3RGBNumbers> getCardBackground() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCardBackground1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_3RGBNumbers> getCardBackground1_7() {
		COSObject object = getCardBackgroundValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_3RGBNumbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_3RGBNumbers((COSArray)object.getDirectBase(), this.baseObject, "CardBackground"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_3RGBNumbers> getCardBorder() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCardBorder1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_3RGBNumbers> getCardBorder1_7() {
		COSObject object = getCardBorderValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_3RGBNumbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_3RGBNumbers((COSArray)object.getDirectBase(), this.baseObject, "CardBorder"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_3RGBNumbers> getPrimaryText() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPrimaryText1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_3RGBNumbers> getPrimaryText1_7() {
		COSObject object = getPrimaryTextValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_3RGBNumbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_3RGBNumbers((COSArray)object.getDirectBase(), this.baseObject, "PrimaryText"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_3RGBNumbers> getSecondaryText() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSecondaryText1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_3RGBNumbers> getSecondaryText1_7() {
		COSObject object = getSecondaryTextValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_3RGBNumbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_3RGBNumbers((COSArray)object.getDirectBase(), this.baseObject, "SecondaryText"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsBackground() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Background"));
	}

	public COSObject getBackgroundValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Background"));
		return object;
	}

	@Override
	public String getBackgroundType() {
		COSObject Background = getBackgroundValue();
		return getObjectType(Background);
	}

	@Override
	public Boolean getBackgroundHasTypeArray() {
		COSObject Background = getBackgroundValue();
		return getHasTypeArray(Background);
	}

	@Override
	public Boolean getcontainsCardBackground() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CardBackground"));
	}

	public COSObject getCardBackgroundValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CardBackground"));
		return object;
	}

	@Override
	public String getCardBackgroundType() {
		COSObject CardBackground = getCardBackgroundValue();
		return getObjectType(CardBackground);
	}

	@Override
	public Boolean getCardBackgroundHasTypeArray() {
		COSObject CardBackground = getCardBackgroundValue();
		return getHasTypeArray(CardBackground);
	}

	@Override
	public Boolean getcontainsCardBorder() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CardBorder"));
	}

	public COSObject getCardBorderValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CardBorder"));
		return object;
	}

	@Override
	public String getCardBorderType() {
		COSObject CardBorder = getCardBorderValue();
		return getObjectType(CardBorder);
	}

	@Override
	public Boolean getCardBorderHasTypeArray() {
		COSObject CardBorder = getCardBorderValue();
		return getHasTypeArray(CardBorder);
	}

	@Override
	public Boolean getcontainsPrimaryText() {
		return this.baseObject.knownKey(ASAtom.getASAtom("PrimaryText"));
	}

	public COSObject getPrimaryTextValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PrimaryText"));
		return object;
	}

	@Override
	public String getPrimaryTextType() {
		COSObject PrimaryText = getPrimaryTextValue();
		return getObjectType(PrimaryText);
	}

	@Override
	public Boolean getPrimaryTextHasTypeArray() {
		COSObject PrimaryText = getPrimaryTextValue();
		return getHasTypeArray(PrimaryText);
	}

	@Override
	public Boolean getcontainsSecondaryText() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SecondaryText"));
	}

	public COSObject getSecondaryTextValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SecondaryText"));
		return object;
	}

	@Override
	public String getSecondaryTextType() {
		COSObject SecondaryText = getSecondaryTextValue();
		return getObjectType(SecondaryText);
	}

	@Override
	public Boolean getSecondaryTextHasTypeArray() {
		COSObject SecondaryText = getSecondaryTextValue();
		return getHasTypeArray(SecondaryText);
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

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
