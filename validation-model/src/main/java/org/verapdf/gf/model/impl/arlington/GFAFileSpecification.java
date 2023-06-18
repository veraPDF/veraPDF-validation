package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;

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
		COSObject object = getCIValue();
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
		COSObject object = getEFValue();
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
		COSObject object = getEPValue();
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
		COSObject object = getentryIDValue();
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
		COSObject object = getRFValue();
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
		COSObject object = getThumbValue();
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

	public COSObject getAFRelationshipDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return COSName.construct("Unspecified");
		}
		return null;
	}

	public COSObject getAFRelationshipValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AFRelationship"));
		if (object == null || object.empty()) {
			object = getAFRelationshipDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getAFRelationshipHasTypeName() {
		COSObject object = getAFRelationshipValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getAFRelationshipNameValue() {
		COSObject object = getAFRelationshipValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsCI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CI"));
	}

	public COSObject getCIValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CI"));
		return object;
	}

	@Override
	public Boolean getCIHasTypeDictionary() {
		COSObject object = getCIValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsDOS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DOS"));
	}

	public COSObject getDOSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DOS"));
		return object;
	}

	@Override
	public Boolean getDOSHasTypeStringByte() {
		COSObject object = getDOSValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsDesc() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Desc"));
	}

	public COSObject getDescValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Desc"));
		return object;
	}

	@Override
	public Boolean getDescHasTypeString() {
		COSObject object = getDescValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsEF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EF"));
	}

	public COSObject getEFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EF"));
		return object;
	}

	@Override
	public Boolean getEFHasTypeDictionary() {
		COSObject object = getEFValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsEP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EP"));
	}

	public COSObject getEPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EP"));
		return object;
	}

	@Override
	public Boolean getEPHasTypeDictionary() {
		COSObject object = getEPValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	public COSObject getFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		return object;
	}

	@Override
	public Boolean getFHasTypeString() {
		COSObject object = getFValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsFS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FS"));
	}

	public COSObject getFSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FS"));
		return object;
	}

	@Override
	public Boolean getFSHasTypeName() {
		COSObject object = getFSValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getFSNameValue() {
		COSObject object = getFSValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ID"));
	}

	public COSObject getentryIDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ID"));
		return object;
	}

	@Override
	public Boolean getentryIDHasTypeArray() {
		COSObject object = getentryIDValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsMac() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Mac"));
	}

	public COSObject getMacValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Mac"));
		return object;
	}

	@Override
	public Boolean getMacHasTypeStringByte() {
		COSObject object = getMacValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsRF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RF"));
	}

	public COSObject getRFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RF"));
		return object;
	}

	@Override
	public Boolean getRFHasTypeDictionary() {
		COSObject object = getRFValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsThumb() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Thumb"));
	}

	public COSObject getThumbValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Thumb"));
		return object;
	}

	@Override
	public Boolean getisThumbIndirect() {
		COSObject object = getThumbValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getThumbHasTypeStream() {
		COSObject object = getThumbValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
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

	@Override
	public Boolean getcontainsUF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UF"));
	}

	public COSObject getUFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UF"));
		return object;
	}

	@Override
	public Boolean getUFHasTypeStringText() {
		COSObject object = getUFValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsUnix() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Unix"));
	}

	public COSObject getUnixValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Unix"));
		return object;
	}

	@Override
	public Boolean getUnixHasTypeStringByte() {
		COSObject object = getUnixValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("V"));
	}

	public COSObject getVDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		if (object == null || object.empty()) {
			object = getVDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getVHasTypeBoolean() {
		COSObject object = getVValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return false;
	}

}
