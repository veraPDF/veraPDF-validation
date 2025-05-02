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

public class GFAResource extends GFAObject implements AResource {

	public GFAResource(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AResource");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "ColorSpace":
				return getColorSpace();
			case "Encoding":
				return getEncoding();
			case "ExtGState":
				return getExtGState();
			case "Font":
				return getFont();
			case "Pattern":
				return getPattern();
			case "ProcSet":
				return getProcSet();
			case "entryProperties":
				return getentryProperties();
			case "Shading":
				return getShading();
			case "XObject":
				return getXObject();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AColorSpaceMap> getColorSpace() {
		return getColorSpace1_0();
	}

	private List<AColorSpaceMap> getColorSpace1_0() {
		COSObject object = getColorSpaceValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AColorSpaceMap> list = new ArrayList<>(1);
			list.add(new GFAColorSpaceMap((COSDictionary)object.getDirectBase(), this.baseObject, "ColorSpace"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AEncoding> getEncoding() {
		return getEncoding1_0();
	}

	private List<AEncoding> getEncoding1_0() {
		COSObject object = getEncodingValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AEncoding> list = new ArrayList<>(1);
			list.add(new GFAEncoding((COSDictionary)object.getDirectBase(), this.baseObject, "Encoding"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AGraphicsStateParameterMap> getExtGState() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getExtGState1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AGraphicsStateParameterMap> getExtGState1_2() {
		COSObject object = getExtGStateValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AGraphicsStateParameterMap> list = new ArrayList<>(1);
			list.add(new GFAGraphicsStateParameterMap((COSDictionary)object.getDirectBase(), this.baseObject, "ExtGState"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AFontMap> getFont() {
		return getFont1_0();
	}

	private List<AFontMap> getFont1_0() {
		COSObject object = getFontValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFontMap> list = new ArrayList<>(1);
			list.add(new GFAFontMap((COSDictionary)object.getDirectBase(), this.baseObject, "Font"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<APatternMap> getPattern() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPattern1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<APatternMap> getPattern1_2() {
		COSObject object = getPatternValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<APatternMap> list = new ArrayList<>(1);
			list.add(new GFAPatternMap((COSDictionary)object.getDirectBase(), this.baseObject, "Pattern"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNamesForProcSet> getProcSet() {
		return getProcSet1_0();
	}

	private List<AArrayOfNamesForProcSet> getProcSet1_0() {
		COSObject object = getProcSetValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNamesForProcSet> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNamesForProcSet((COSArray)object.getDirectBase(), this.baseObject, "ProcSet"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ADictionaryOfDictionaries> getentryProperties() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentryProperties1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADictionaryOfDictionaries> getentryProperties1_2() {
		COSObject object = getentryPropertiesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ADictionaryOfDictionaries> list = new ArrayList<>(1);
			list.add(new GFADictionaryOfDictionaries((COSDictionary)object.getDirectBase(), this.baseObject, "Properties"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AShadingMap> getShading() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getShading1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AShadingMap> getShading1_3() {
		COSObject object = getShadingValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AShadingMap> list = new ArrayList<>(1);
			list.add(new GFAShadingMap((COSDictionary)object.getDirectBase(), this.baseObject, "Shading"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AXObjectMap> getXObject() {
		return getXObject1_0();
	}

	private List<AXObjectMap> getXObject1_0() {
		COSObject object = getXObjectValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AXObjectMap> list = new ArrayList<>(1);
			list.add(new GFAXObjectMap((COSDictionary)object.getDirectBase(), this.baseObject, "XObject"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsColorSpace() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ColorSpace"));
	}

	public COSObject getColorSpaceValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColorSpace"));
		return object;
	}

	@Override
	public String getColorSpaceType() {
		COSObject ColorSpace = getColorSpaceValue();
		return getObjectType(ColorSpace);
	}

	@Override
	public Boolean getColorSpaceHasTypeDictionary() {
		COSObject ColorSpace = getColorSpaceValue();
		return getHasTypeDictionary(ColorSpace);
	}

	@Override
	public Boolean getcontainsEncoding() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Encoding"));
	}

	public COSObject getEncodingValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Encoding"));
		return object;
	}

	@Override
	public String getEncodingType() {
		COSObject Encoding = getEncodingValue();
		return getObjectType(Encoding);
	}

	@Override
	public Boolean getEncodingHasTypeDictionary() {
		COSObject Encoding = getEncodingValue();
		return getHasTypeDictionary(Encoding);
	}

	@Override
	public Boolean getcontainsExtGState() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ExtGState"));
	}

	public COSObject getExtGStateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExtGState"));
		return object;
	}

	@Override
	public String getExtGStateType() {
		COSObject ExtGState = getExtGStateValue();
		return getObjectType(ExtGState);
	}

	@Override
	public Boolean getExtGStateHasTypeDictionary() {
		COSObject ExtGState = getExtGStateValue();
		return getHasTypeDictionary(ExtGState);
	}

	@Override
	public Boolean getcontainsFont() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Font"));
	}

	public COSObject getFontValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Font"));
		return object;
	}

	@Override
	public String getFontType() {
		COSObject Font = getFontValue();
		return getObjectType(Font);
	}

	@Override
	public Boolean getFontHasTypeDictionary() {
		COSObject Font = getFontValue();
		return getHasTypeDictionary(Font);
	}

	@Override
	public Boolean getcontainsPattern() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Pattern"));
	}

	public COSObject getPatternValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Pattern"));
		return object;
	}

	@Override
	public String getPatternType() {
		COSObject Pattern = getPatternValue();
		return getObjectType(Pattern);
	}

	@Override
	public Boolean getPatternHasTypeDictionary() {
		COSObject Pattern = getPatternValue();
		return getHasTypeDictionary(Pattern);
	}

	@Override
	public Boolean getcontainsProcSet() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ProcSet"));
	}

	public COSObject getProcSetValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ProcSet"));
		return object;
	}

	@Override
	public String getProcSetType() {
		COSObject ProcSet = getProcSetValue();
		return getObjectType(ProcSet);
	}

	@Override
	public Boolean getProcSetHasTypeArray() {
		COSObject ProcSet = getProcSetValue();
		return getHasTypeArray(ProcSet);
	}

	@Override
	public Boolean getcontainsProperties() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Properties"));
	}

	public COSObject getentryPropertiesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Properties"));
		return object;
	}

	@Override
	public String getentryPropertiesType() {
		COSObject entryProperties = getentryPropertiesValue();
		return getObjectType(entryProperties);
	}

	@Override
	public Boolean getentryPropertiesHasTypeDictionary() {
		COSObject entryProperties = getentryPropertiesValue();
		return getHasTypeDictionary(entryProperties);
	}

	@Override
	public Boolean getcontainsShading() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Shading"));
	}

	public COSObject getShadingValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Shading"));
		return object;
	}

	@Override
	public String getShadingType() {
		COSObject Shading = getShadingValue();
		return getObjectType(Shading);
	}

	@Override
	public Boolean getShadingHasTypeDictionary() {
		COSObject Shading = getShadingValue();
		return getHasTypeDictionary(Shading);
	}

	@Override
	public Boolean getcontainsXObject() {
		return this.baseObject.knownKey(ASAtom.getASAtom("XObject"));
	}

	public COSObject getXObjectValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XObject"));
		return object;
	}

	@Override
	public String getXObjectType() {
		COSObject XObject = getXObjectValue();
		return getObjectType(XObject);
	}

	@Override
	public Boolean getXObjectHasTypeDictionary() {
		COSObject XObject = getXObjectValue();
		return getHasTypeDictionary(XObject);
	}

}
