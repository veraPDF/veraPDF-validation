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

public class GFAArrayOfTrapNetVersionObjectsEntry extends GFAObject implements AArrayOfTrapNetVersionObjectsEntry {

	private COSBase parentParentObject;
	private String collectionName;

	public GFAArrayOfTrapNetVersionObjectsEntry(COSBase baseObject, COSBase parentObject, COSBase parentParentObject, String collectionName, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfTrapNetVersionObjectsEntry");
		this.parentParentObject = parentParentObject;
		this.collectionName = collectionName;
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Entry":
				return getEntry();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getEntry() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntry1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getEntry1_3() {
		COSObject object = new COSObject(this.baseObject);
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getEntryArray1_3(object.getDirectBase(), keyName);
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getEntryStream1_3(object.getDirectBase(), keyName);
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getEntryDictionary1_3(object.getDirectBase(), keyName);
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getEntryArray1_3(COSBase base, String keyName) {
		if (base.size() <= 0) {
			return null;
		}
		COSObject subtype = base.at(0);
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "ICCBased":
				return new GFAICCBasedColorSpace(base, this.baseObject, keyName);
			case "Pattern":
				return new GFAPatternColorSpace(base, this.baseObject, keyName);
			case "CalRGB":
				return new GFACalRGBColorSpace(base, this.baseObject, keyName);
			case "Separation":
				return new GFASeparationColorSpace(base, this.baseObject, keyName);
			case "DeviceN":
				return new GFADeviceNColorSpace(base, this.baseObject, keyName);
			case "CalGray":
				return new GFACalGrayColorSpace(base, this.baseObject, keyName);
			case "Lab":
				return new GFALabColorSpace(base, this.baseObject, keyName);
			case "Indexed":
				return new GFAIndexedColorSpace(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryStream1_3(COSBase base, String keyName) {
		if (base.knownKey(ASAtom.getASAtom("Type"))) {
			return new GFAPatternType1(base, this.baseObject, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("ShadingType"))) {
			return getEntryStreamShadingType1_3(base, keyName);
		}
		return new GFAStream(base, this.baseObject, keyName);
	}

	private org.verapdf.model.baselayer.Object getEntryStreamShadingType1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("ShadingType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 4:
				return new GFAShadingType4(base, this.baseObject, keyName);
			case 5:
				return new GFAShadingType5(base, this.baseObject, keyName);
			case 6:
				return new GFAShadingType6(base, this.baseObject, keyName);
			case 7:
				return new GFAShadingType7(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionary1_3(COSBase base, String keyName) {
		if (base.knownKey(ASAtom.getASAtom("Type"))) {
			return getEntryDictionaryType1_3(base, keyName);
		}
		if (base.knownKey(ASAtom.getASAtom("ShadingType"))) {
			return getEntryDictionaryShadingType1_3(base, keyName);
		}
		return null;
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryType1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Type"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Pattern":
				return new GFAPatternType2(base, this.baseObject, keyName);
			case "OPI":
				return getEntryDictionaryOPI1_3(base, keyName);
			case "ExtGState":
				return new GFAGraphicsStateParameter(base, this.baseObject, keyName);
			case "XObject":
				return getEntryDictionaryXObject1_3(base, keyName);
			case "Font":
				return getEntryDictionaryFont1_3(base, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryOPI1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Version"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "2.0":
				return new GFAOPIVersion20Dict(base, this.baseObject, keyName);
			case "1.3":
				return new GFAOPIVersion13Dict(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryXObject1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "PS":
				return getEntryDictionaryPS1_3(base, keyName);
			case "Form":
				return new GFAXObjectFormType1(base, this.baseObject, keyName);
			case "Image":
				return new GFAXObjectImage(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryPS1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype2"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return new GFAXObjectFormPS(base, this.baseObject, keyName);
		}
		switch (subtypeValue) {
			case "PS":
				return new GFAXObjectFormPSpassthrough(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryFont1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Subtype"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Type3":
				return new GFAFontType3(base, this.baseObject, keyName);
			case "CIDFontType0":
				return new GFAFontCIDType0(base, this.baseObject, keyName);
			case "CIDFontType2":
				return new GFAFontCIDType2(base, this.baseObject, keyName);
			case "MMType1":
				return new GFAFontMultipleMaster(base, this.baseObject, keyName);
			case "Type0":
				return new GFAFontType0(base, this.baseObject, keyName);
			case "Type1":
				return new GFAFontType1(base, this.baseObject, keyName);
			case "TrueType":
				return new GFAFontTrueType(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getEntryDictionaryShadingType1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("ShadingType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 1:
				return new GFAShadingType1(base, this.baseObject, keyName);
			case 2:
				return new GFAShadingType2(base, this.baseObject, keyName);
			case 3:
				return new GFAShadingType3(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	@Override
	public Boolean getisIndirect() {
		COSObject object = new COSObject(this.baseObject);
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getHasTypeArray() {
		COSObject object = new COSObject(this.baseObject);
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getHasTypeStream() {
		COSObject object = new COSObject(this.baseObject);
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getHasTypeDictionary() {
		COSObject object = new COSObject(this.baseObject);
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

}
