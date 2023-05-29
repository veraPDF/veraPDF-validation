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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Background"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CardBackground"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CardBorder"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("PrimaryText"));
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SecondaryText"));
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
	public Boolean getBackgroundHasTypeArray() {
		COSObject object = getBackgroundValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
	public Boolean getCardBackgroundHasTypeArray() {
		COSObject object = getCardBackgroundValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
	public Boolean getCardBorderHasTypeArray() {
		COSObject object = getCardBorderValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
	public Boolean getPrimaryTextHasTypeArray() {
		COSObject object = getPrimaryTextValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
	public Boolean getSecondaryTextHasTypeArray() {
		COSObject object = getSecondaryTextValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
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
		COSObject object = getTypeValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

}
