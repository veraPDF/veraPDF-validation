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

public class GFAFileSpecification extends GFAObject implements AFileSpecification {

	public GFAFileSpecification(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFileSpecification");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "CI":
				return getCI();
			case "EF":
				return getEF();
			case "EP":
				return getEP();
			case "entryID":
				return getentryID();
			case "RF":
				return getRF();
			case "Thumb":
				return getThumb();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ACollectionItem> getCI() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCI1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACollectionItem> getCI1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CI"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACollectionItem> list = new ArrayList<>(1);
			list.add(new GFACollectionItem((COSDictionary)object.getDirectBase(), this.baseObject, "CI"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AFileSpecEF> getEF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEF1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFileSpecEF> getEF1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EF"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFileSpecEF> list = new ArrayList<>(1);
			list.add(new GFAFileSpecEF((COSDictionary)object.getDirectBase(), this.baseObject, "EF"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AEncryptedPayload> getEP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getEP2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AEncryptedPayload> getEP2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EP"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AEncryptedPayload> list = new ArrayList<>(1);
			list.add(new GFAEncryptedPayload((COSDictionary)object.getDirectBase(), this.baseObject, "EP"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_2StringsByte> getentryID() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentryID1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2StringsByte> getentryID1_1() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ID"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2StringsByte> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2StringsByte((COSArray)object.getDirectBase(), this.baseObject, "ID"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AFileSpecRF> getRF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRF1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFileSpecRF> getRF1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RF"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFileSpecRF> list = new ArrayList<>(1);
			list.add(new GFAFileSpecRF((COSDictionary)object.getDirectBase(), this.baseObject, "RF"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AThumbnail> getThumb() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getThumb1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AThumbnail> getThumb1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Thumb"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AThumbnail> list = new ArrayList<>(1);
			list.add(new GFAThumbnail((COSStream)object.getDirectBase(), this.baseObject, "Thumb"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAFRelationship() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AFRelationship"));
	}

	@Override
	public Boolean getAFRelationshipHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AFRelationship"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getAFRelationshipNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AFRelationship"));
		if (object == null || object.empty()) {
			return getAFRelationshipNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getAFRelationshipNameDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return "Unspecified";
		}
		return null;
	}

	@Override
	public Boolean getcontainsCI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CI"));
	}

	@Override
	public Boolean getCIHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CI"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsDOS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DOS"));
	}

	@Override
	public Boolean getDOSHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DOS"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsDesc() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Desc"));
	}

	@Override
	public Boolean getDescHasTypeString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Desc"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsEF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EF"));
	}

	@Override
	public Boolean getEFHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EF"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsEP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EP"));
	}

	@Override
	public Boolean getEPHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EP"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	@Override
	public Boolean getFHasTypeString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsFS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FS"));
	}

	@Override
	public Boolean getFSHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FS"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getFSNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FS"));
		if (object == null || object.empty()) {
			return getFSNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getFSNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ID"));
	}

	@Override
	public Boolean getentryIDHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ID"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsMac() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Mac"));
	}

	@Override
	public Boolean getMacHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Mac"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsRF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RF"));
	}

	@Override
	public Boolean getRFHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RF"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsThumb() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Thumb"));
	}

	@Override
	public Boolean getisThumbIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Thumb"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getThumbHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Thumb"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
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

	@Override
	public Boolean getcontainsUF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UF"));
	}

	@Override
	public Boolean getUFHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UF"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsUnix() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Unix"));
	}

	@Override
	public Boolean getUnixHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Unix"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("V"));
	}

	@Override
	public Boolean getVHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

}
