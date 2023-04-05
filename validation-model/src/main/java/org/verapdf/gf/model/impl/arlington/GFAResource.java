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
import java.io.IOException;

public class GFAResource extends GFAObject implements AResource {

	public GFAResource(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AResource");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Pattern":
				return getPattern();
			case "ColorSpace":
				return getColorSpace();
			case "ProcSet":
				return getProcSet();
			case "Shading":
				return getShading();
			case "ExtGState":
				return getExtGState();
			case "entryProperties":
				return getentryProperties();
			case "Font":
				return getFont();
			case "XObject":
				return getXObject();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<APatternMap> getPattern() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Pattern"));
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

	private List<AColorSpaceMap> getColorSpace() {
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
				return getColorSpace1_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AColorSpaceMap> getColorSpace1_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColorSpace"));
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

	private List<AArrayOfNamesForProcSet> getProcSet() {
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
				return getProcSet1_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNamesForProcSet> getProcSet1_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ProcSet"));
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

	private List<AShadingMap> getShading() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Shading"));
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

	private List<AGraphicsStateParameterMap> getExtGState() {
		switch(StaticContainers.getFlavour()) {
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExtGState"));
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

	private List<A_UniversalDictionary> getentryProperties() {
		switch(StaticContainers.getFlavour()) {
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

	private List<A_UniversalDictionary> getentryProperties1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Properties"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A_UniversalDictionary> list = new ArrayList<>(1);
			list.add(new GFA_UniversalDictionary((COSDictionary)object.getDirectBase(), this.baseObject, "Properties"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AFontMap> getFont() {
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
				return getFont1_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFontMap> getFont1_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Font"));
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

	private List<AXObjectMap> getXObject() {
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
				return getXObject1_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AXObjectMap> getXObject1_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XObject"));
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
	public Boolean getcontainsFont() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Font"));
	}

	@Override
	public Boolean getFontHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Font"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsShading() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Shading"));
	}

	@Override
	public Boolean getShadingHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Shading"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsProcSet() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ProcSet"));
	}

	@Override
	public Boolean getProcSetHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ProcSet"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsXObject() {
		return this.baseObject.knownKey(ASAtom.getASAtom("XObject"));
	}

	@Override
	public Boolean getXObjectHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("XObject"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsPattern() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Pattern"));
	}

	@Override
	public Boolean getPatternHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Pattern"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsExtGState() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ExtGState"));
	}

	@Override
	public Boolean getExtGStateHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExtGState"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsColorSpace() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ColorSpace"));
	}

	@Override
	public Boolean getColorSpaceHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColorSpace"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsProperties() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Properties"));
	}

	@Override
	public Boolean getentryPropertiesHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Properties"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

}
