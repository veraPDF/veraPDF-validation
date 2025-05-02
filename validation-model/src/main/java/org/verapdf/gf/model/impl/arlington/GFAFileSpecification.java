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
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getThumb1_7();
				}
				return Collections.emptyList();
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
			case ARLINGTON1_7:
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
	public String getAFRelationshipType() {
		COSObject AFRelationship = getAFRelationshipValue();
		return getObjectType(AFRelationship);
	}

	@Override
	public Boolean getAFRelationshipHasTypeName() {
		COSObject AFRelationship = getAFRelationshipValue();
		return getHasTypeName(AFRelationship);
	}

	@Override
	public String getAFRelationshipNameValue() {
		COSObject AFRelationship = getAFRelationshipValue();
		return getNameValue(AFRelationship);
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
	public Boolean getisCIIndirect() {
		COSObject CI = getCIValue();
		return getisIndirect(CI);
	}

	@Override
	public String getCIType() {
		COSObject CI = getCIValue();
		return getObjectType(CI);
	}

	@Override
	public Boolean getCIHasTypeDictionary() {
		COSObject CI = getCIValue();
		return getHasTypeDictionary(CI);
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
	public String getDOSType() {
		COSObject DOS = getDOSValue();
		return getObjectType(DOS);
	}

	@Override
	public Boolean getDOSHasTypeStringByte() {
		COSObject DOS = getDOSValue();
		return getHasTypeStringByte(DOS);
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
	public String getDescType() {
		COSObject Desc = getDescValue();
		return getObjectType(Desc);
	}

	@Override
	public Boolean getDescHasTypeString() {
		COSObject Desc = getDescValue();
		return getHasTypeString(Desc);
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
	public String getEFType() {
		COSObject EF = getEFValue();
		return getObjectType(EF);
	}

	@Override
	public Boolean getEFHasTypeDictionary() {
		COSObject EF = getEFValue();
		return getHasTypeDictionary(EF);
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
	public String getEPType() {
		COSObject EP = getEPValue();
		return getObjectType(EP);
	}

	@Override
	public Boolean getEPHasTypeDictionary() {
		COSObject EP = getEPValue();
		return getHasTypeDictionary(EP);
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
	public String getFType() {
		COSObject F = getFValue();
		return getObjectType(F);
	}

	@Override
	public Boolean getFHasTypeString() {
		COSObject F = getFValue();
		return getHasTypeString(F);
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
	public String getFSType() {
		COSObject FS = getFSValue();
		return getObjectType(FS);
	}

	@Override
	public Boolean getFSHasTypeName() {
		COSObject FS = getFSValue();
		return getHasTypeName(FS);
	}

	@Override
	public String getFSNameValue() {
		COSObject FS = getFSValue();
		return getNameValue(FS);
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
	public String getentryIDType() {
		COSObject entryID = getentryIDValue();
		return getObjectType(entryID);
	}

	@Override
	public Boolean getentryIDHasTypeArray() {
		COSObject entryID = getentryIDValue();
		return getHasTypeArray(entryID);
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
	public String getMacType() {
		COSObject Mac = getMacValue();
		return getObjectType(Mac);
	}

	@Override
	public Boolean getMacHasTypeStringByte() {
		COSObject Mac = getMacValue();
		return getHasTypeStringByte(Mac);
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
	public String getRFType() {
		COSObject RF = getRFValue();
		return getObjectType(RF);
	}

	@Override
	public Boolean getRFHasTypeDictionary() {
		COSObject RF = getRFValue();
		return getHasTypeDictionary(RF);
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
		COSObject Thumb = getThumbValue();
		return getisIndirect(Thumb);
	}

	@Override
	public String getThumbType() {
		COSObject Thumb = getThumbValue();
		return getObjectType(Thumb);
	}

	@Override
	public Boolean getThumbHasTypeStream() {
		COSObject Thumb = getThumbValue();
		return getHasTypeStream(Thumb);
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
	public Boolean getcontainsUF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UF"));
	}

	public COSObject getUFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UF"));
		return object;
	}

	@Override
	public String getUFType() {
		COSObject UF = getUFValue();
		return getObjectType(UF);
	}

	@Override
	public Boolean getUFHasTypeStringText() {
		COSObject UF = getUFValue();
		return getHasTypeStringText(UF);
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
	public String getUnixType() {
		COSObject Unix = getUnixValue();
		return getObjectType(Unix);
	}

	@Override
	public Boolean getUnixHasTypeStringByte() {
		COSObject Unix = getUnixValue();
		return getHasTypeStringByte(Unix);
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
	public String getVType() {
		COSObject V = getVValue();
		return getObjectType(V);
	}

	@Override
	public Boolean getVHasTypeBoolean() {
		COSObject V = getVValue();
		return getHasTypeBoolean(V);
	}

}
