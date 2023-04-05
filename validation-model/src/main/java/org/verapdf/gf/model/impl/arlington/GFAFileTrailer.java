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

public class GFAFileTrailer extends GFAObject implements AFileTrailer {

	public GFAFileTrailer(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFileTrailer");
		GFAObject.clearAllContainers();
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Root":
				return getRoot();
			case "AuthCode":
				return getAuthCode();
			case "entryID":
				return getentryID();
			case "Info":
				return getInfo();
			case "Encrypt":
				return getEncrypt();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ACatalog> getRoot() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getRoot1_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACatalog> getRoot1_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Root"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACatalog> list = new ArrayList<>(1);
			list.add(new GFACatalog((COSDictionary)object.getDirectBase(), this.baseObject, "Root"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AAuthCode> getAuthCode() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getAuthCode2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAuthCode> getAuthCode2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AuthCode"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AAuthCode> list = new ArrayList<>(1);
			list.add(new GFAAuthCode((COSDictionary)object.getDirectBase(), this.baseObject, "AuthCode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_2UnencryptedStringsByte> getentryID() {
		switch(StaticContainers.getFlavour()) {
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

	private List<AArrayOf_2UnencryptedStringsByte> getentryID1_1() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ID"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2UnencryptedStringsByte> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2UnencryptedStringsByte((COSArray)object.getDirectBase(), this.baseObject, "ID"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ADocInfo> getInfo() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getInfo1_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADocInfo> getInfo1_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Info"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ADocInfo> list = new ArrayList<>(1);
			list.add(new GFADocInfo((COSDictionary)object.getDirectBase(), this.baseObject, "Info"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getEncrypt() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEncrypt1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getEncrypt1_1() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Encrypt"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getEncryptDictionary1_1(object.getDirectBase(), "Encrypt");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getEncryptDictionary1_1(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Filter"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return new GFAEncryptionPublicKey(base, this.baseObject, keyName);
		}
		switch (subtypeValue) {
			case "Adobe.PubSec":
				return new GFAEncryptionPublicKey(base, this.baseObject, keyName);
			case "AdobePPKLite":
				return new GFAEncryptionPublicKey(base, this.baseObject, keyName);
			case "Standard":
				return new GFAEncryptionStandard(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	@Override
	public Boolean getcontainsPrev() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Prev"));
	}

	@Override
	public Boolean getisPrevIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Prev"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getPrevHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Prev"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getPrevIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Prev"));
		if (object == null || object.empty()) {
			return getPrevIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getPrevIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsXRefStm() {
		return this.baseObject.knownKey(ASAtom.getASAtom("XRefStm"));
	}

	@Override
	public Boolean getXRefStmHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XRefStm"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getXRefStmIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XRefStm"));
		if (object == null || object.empty()) {
			return getXRefStmIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getXRefStmIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsID() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ID"));
	}

	@Override
	public Boolean getisentryIDIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ID"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getentryIDHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ID"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsRoot() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Root"));
	}

	@Override
	public Boolean getisRootIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Root"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getRootHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Root"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsSize() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Size"));
	}

	@Override
	public Boolean getisSizeIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Size"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getSizeHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Size"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getSizeIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Size"));
		if (object == null || object.empty()) {
			return getSizeIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getSizeIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsInfo() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Info"));
	}

	@Override
	public Boolean getisInfoIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Info"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getInfoHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Info"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsEncrypt() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Encrypt"));
	}

	@Override
	public Boolean getEncryptHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Encrypt"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsAuthCode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AuthCode"));
	}

	@Override
	public Boolean getisAuthCodeIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AuthCode"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getAuthCodeHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AuthCode"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Long getEncryptVIntegerValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Encrypt = this.baseObject.getKey(ASAtom.getASAtom("Encrypt"));
		if (Encrypt == null || !Encrypt.getType().isDictionaryBased()) {
			return null;
		}
		COSObject V = Encrypt.getKey(ASAtom.getASAtom("V"));
		if (V != null && V.getType() == COSObjType.COS_INTEGER) {
			return V.getInteger();
		}
		return null;
	}

}
