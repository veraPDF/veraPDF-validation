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

public class GFAOutline extends GFAObject implements AOutline {

	public GFAOutline(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOutline");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "First":
				return getFirst();
			case "Last":
				return getLast();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AOutlineItem> getFirst() {
		return getFirst1_0();
	}

	private List<AOutlineItem> getFirst1_0() {
		COSObject object = getFirstValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AOutlineItem> list = new ArrayList<>(1);
			list.add(new GFAOutlineItem((COSDictionary)object.getDirectBase(), this.baseObject, "First"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AOutlineItem> getLast() {
		return getLast1_0();
	}

	private List<AOutlineItem> getLast1_0() {
		COSObject object = getLastValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AOutlineItem> list = new ArrayList<>(1);
			list.add(new GFAOutlineItem((COSDictionary)object.getDirectBase(), this.baseObject, "Last"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCount() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Count"));
	}

	public COSObject getCountValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Count"));
		return object;
	}

	@Override
	public Boolean getCountHasTypeInteger() {
		COSObject Count = getCountValue();
		return getHasTypeInteger(Count);
	}

	@Override
	public Long getCountIntegerValue() {
		COSObject Count = getCountValue();
		return getIntegerValue(Count);
	}

	@Override
	public Boolean getcontainsFirst() {
		return this.baseObject.knownKey(ASAtom.getASAtom("First"));
	}

	public COSObject getFirstValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("First"));
		return object;
	}

	@Override
	public Boolean getisFirstIndirect() {
		COSObject First = getFirstValue();
		return getisIndirect(First);
	}

	@Override
	public Boolean getFirstHasTypeDictionary() {
		COSObject First = getFirstValue();
		return getHasTypeDictionary(First);
	}

	@Override
	public Boolean getcontainsLast() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Last"));
	}

	public COSObject getLastValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Last"));
		return object;
	}

	@Override
	public Boolean getisLastIndirect() {
		COSObject Last = getLastValue();
		return getisIndirect(Last);
	}

	@Override
	public Boolean getLastHasTypeDictionary() {
		COSObject Last = getLastValue();
		return getHasTypeDictionary(Last);
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
