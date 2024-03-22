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

public class GFAExtensions extends GFAObject implements AExtensions {

	public GFAExtensions(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AExtensions");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Entries":
				return getEntries();
			case "ISO_":
				return getISO_();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AExtensionsEntry> getEntries() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntries1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AExtensionsEntry> getEntries1_7() {
		List<AExtensionsEntry> list = new LinkedList<>();
		for (ASAtom key : baseObject.getKeySet()) {
			if ("ISO_".equals(key.getValue()) || "Type".equals(key.getValue())) {
				continue;
			}
			COSObject object = this.baseObject.getKey(key);
			list.add(new GFAExtensionsEntry(object != null ? object.get() : null, this.baseObject, this.parentObject, keyName, key.getValue()));
		}
		return Collections.unmodifiableList(list);
	}

	private List<org.verapdf.model.baselayer.Object> getISO_() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				return getISO_1_7();
			case ARLINGTON2_0:
				return getISO_2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getISO_1_7() {
		COSObject object = getISO_Value();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AISO_DevExtensions> list = new ArrayList<>(1);
			list.add(new GFAISO_DevExtensions((COSDictionary)object.getDirectBase(), this.baseObject, "ISO_"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getISO_2_0() {
		COSObject object = getISO_Value();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDevExtensions> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDevExtensions((COSArray)object.getDirectBase(), this.baseObject, "ISO_"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AISO_DevExtensions> list = new ArrayList<>(1);
			list.add(new GFAISO_DevExtensions((COSDictionary)object.getDirectBase(), this.baseObject, "ISO_"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsISO_() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ISO_"));
	}

	public COSObject getISO_Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ISO_"));
		return object;
	}

	@Override
	public Boolean getisISO_Indirect() {
		COSObject ISO_ = getISO_Value();
		return getisIndirect(ISO_);
	}

	@Override
	public String getISO_Type() {
		COSObject ISO_ = getISO_Value();
		return getObjectType(ISO_);
	}

	@Override
	public Boolean getISO_HasTypeArray() {
		COSObject ISO_ = getISO_Value();
		return getHasTypeArray(ISO_);
	}

	@Override
	public Boolean getISO_HasTypeDictionary() {
		COSObject ISO_ = getISO_Value();
		return getHasTypeDictionary(ISO_);
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
	public Boolean getisTypeIndirect() {
		COSObject Type = getTypeValue();
		return getisIndirect(Type);
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
