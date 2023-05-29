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

public class GFAThread extends GFAObject implements AThread {

	public GFAThread(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AThread");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "F":
				return getF();
			case "I":
				return getI();
			case "Metadata":
				return getMetadata();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ABeadFirst> getF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getF1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<ABeadFirst> getF1_1() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ABeadFirst> list = new ArrayList<>(1);
			list.add(new GFABeadFirst((COSDictionary)object.getDirectBase(), this.baseObject, "F"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ADocInfo> getI() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getI1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADocInfo> getI1_1() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("I"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ADocInfo> list = new ArrayList<>(1);
			list.add(new GFADocInfo((COSDictionary)object.getDirectBase(), this.baseObject, "I"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AMetadata> getMetadata() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getMetadata2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AMetadata> getMetadata2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Metadata"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AMetadata> list = new ArrayList<>(1);
			list.add(new GFAMetadata((COSStream)object.getDirectBase(), this.baseObject, "Metadata"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
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
	public Boolean getisFIndirect() {
		COSObject object = getFValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getFHasTypeDictionary() {
		COSObject object = getFValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("I"));
	}

	public COSObject getIValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("I"));
		return object;
	}

	@Override
	public Boolean getIHasTypeDictionary() {
		COSObject object = getIValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsMetadata() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Metadata"));
	}

	public COSObject getMetadataValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Metadata"));
		return object;
	}

	@Override
	public Boolean getisMetadataIndirect() {
		COSObject object = getMetadataValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getMetadataHasTypeStream() {
		COSObject object = getMetadataValue();
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

}
