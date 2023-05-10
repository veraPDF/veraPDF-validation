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

public class GFAData extends GFAObject implements AData {

	public GFAData(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AData");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Entries":
				return getEntries();
			case "Private":
				return getPrivate();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ADataEntry> getEntries() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntries1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADataEntry> getEntries1_3() {
		List<ADataEntry> list = new LinkedList<>();
		for (ASAtom key : baseObject.getKeySet()) {
			if ("LastModified".equals(key.getValue()) || "Private".equals(key.getValue())) {
				continue;
			}
			COSObject object = this.baseObject.getKey(key);
			list.add(new GFADataEntry(object != null ? object.get() : null, this.baseObject, this.parentObject, keyName, key.getValue()));
		}
		return Collections.unmodifiableList(list);
	}

	private List<org.verapdf.model.baselayer.Object> getPrivate() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPrivate1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getPrivate1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Private"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<A_UniversalArray> list = new ArrayList<>(1);
			list.add(new GFA_UniversalArray((COSArray)object.getDirectBase(), this.baseObject, "Private"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A_UniversalDictionary> list = new ArrayList<>(1);
			list.add(new GFA_UniversalDictionary((COSDictionary)object.getDirectBase(), this.baseObject, "Private"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "Private"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsLastModified() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LastModified"));
	}

	@Override
	public Boolean getLastModifiedHasTypeDate() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LastModified"));
		return object != null && object.getType() == COSObjType.COS_STRING && object.getString().matches(GFAObject.PDF_DATE_FORMAT_REGEX);
	}

	@Override
	public Boolean getcontainsPrivate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Private"));
	}

	@Override
	public Boolean getisPrivateIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Private"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getPrivateHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Private"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getPrivateHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Private"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getPrivateHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Private"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getPrivateHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Private"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getPrivateHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Private"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getPrivateHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Private"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Boolean getPrivateHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Private"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getPrivateHasTypeString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Private"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

}
