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

public class GFAGraphicsStateParameter extends GFAObject implements AGraphicsStateParameter {

	public GFAGraphicsStateParameter(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AGraphicsStateParameter");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "AAPLST":
				return getAAPLST();
			case "BG":
				return getBG();
			case "BG2":
				return getBG2();
			case "BM":
				return getBM();
			case "D":
				return getD();
			case "Font":
				return getFont();
			case "HT":
				return getHT();
			case "HTO":
				return getHTO();
			case "HTP":
				return getHTP();
			case "SMask":
				return getSMask();
			case "TR":
				return getTR();
			case "TR2":
				return getTR2();
			case "UCR":
				return getUCR();
			case "UCR2":
				return getUCR2();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AAAPL_ST> getAAPLST() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAAPLST1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAAPL_ST> getAAPLST1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AAPL:ST"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AAAPL_ST> list = new ArrayList<>(1);
			list.add(new GFAAAPL_ST((COSDictionary)object.getDirectBase(), this.baseObject, "AAPL:ST"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getBG() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
				return getBG1_2();
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBG1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getBG1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BG"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AFunctionType0> list = new ArrayList<>(1);
			list.add(new GFAFunctionType0((COSStream)object.getDirectBase(), this.baseObject, "BG"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getBG1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BG"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getBGDictionary1_3(object.getDirectBase(), "BG");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getBGStream1_3(object.getDirectBase(), "BG");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getBGDictionary1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FunctionType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 2:
				return new GFAFunctionType2(base, this.baseObject, keyName);
			case 3:
				return new GFAFunctionType3(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getBGStream1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FunctionType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 0:
				return new GFAFunctionType0(base, this.baseObject, keyName);
			case 4:
				return new GFAFunctionType4(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getBG2() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBG21_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getBG21_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BG2"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getBG2Dictionary1_3(object.getDirectBase(), "BG2");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getBG2Stream1_3(object.getDirectBase(), "BG2");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getBG2Dictionary1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FunctionType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 2:
				return new GFAFunctionType2(base, this.baseObject, keyName);
			case 3:
				return new GFAFunctionType3(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getBG2Stream1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FunctionType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 0:
				return new GFAFunctionType0(base, this.baseObject, keyName);
			case 4:
				return new GFAFunctionType4(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AArrayOfBlendModes> getBM() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBM1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfBlendModes> getBM1_4() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BM"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfBlendModes> list = new ArrayList<>(1);
			list.add(new GFAArrayOfBlendModes((COSArray)object.getDirectBase(), this.baseObject, "BM"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfGSPDashPatterns> getD() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getD1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfGSPDashPatterns> getD1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfGSPDashPatterns> list = new ArrayList<>(1);
			list.add(new GFAArrayOfGSPDashPatterns((COSArray)object.getDirectBase(), this.baseObject, "D"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfFontAndSize> getFont() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getFont1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfFontAndSize> getFont1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Font"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfFontAndSize> list = new ArrayList<>(1);
			list.add(new GFAArrayOfFontAndSize((COSArray)object.getDirectBase(), this.baseObject, "Font"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getHT() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
				return getHT1_2();
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getHT1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getHT1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HT"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getHTDictionary1_2(object.getDirectBase(), "HT");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getHTStream1_2(object.getDirectBase(), "HT");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getHTDictionary1_2(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("HalftoneType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 1:
				return new GFAHalftoneType1(base, this.baseObject, keyName);
			case 5:
				return new GFAHalftoneType5(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getHTStream1_2(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("HalftoneType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 6:
				return new GFAHalftoneType6(base, this.baseObject, keyName);
			case 10:
				return new GFAHalftoneType10(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getHT1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HT"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getHTDictionary1_3(object.getDirectBase(), "HT");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getHTStream1_3(object.getDirectBase(), "HT");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getHTDictionary1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("HalftoneType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 1:
				return new GFAHalftoneType1(base, this.baseObject, keyName);
			case 5:
				return new GFAHalftoneType5(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getHTStream1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("HalftoneType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 16:
				return new GFAHalftoneType16(base, this.baseObject, keyName);
			case 6:
				return new GFAHalftoneType6(base, this.baseObject, keyName);
			case 10:
				return new GFAHalftoneType10(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AArrayOf_2Numbers> getHTO() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getHTO2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2Numbers> getHTO2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HTO"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2Numbers((COSArray)object.getDirectBase(), this.baseObject, "HTO"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOf_2Integers> getHTP() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getHTP1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2Integers> getHTP1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HTP"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2Integers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2Integers((COSArray)object.getDirectBase(), this.baseObject, "HTP"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getSMask() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getSMask1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getSMask1_4() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SMask"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getSMaskDictionary1_4(object.getDirectBase(), "SMask");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getSMaskDictionary1_4(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("S"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "Alpha":
				return new GFASoftMaskAlpha(base, this.baseObject, keyName);
			case "Luminosity":
				return new GFASoftMaskLuminosity(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getTR() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
				return getTR1_2();
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTR1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getTR1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf4Functions> list = new ArrayList<>(1);
			list.add(new GFAArrayOf4Functions((COSArray)object.getDirectBase(), this.baseObject, "TR"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AFunctionType0> list = new ArrayList<>(1);
			list.add(new GFAFunctionType0((COSStream)object.getDirectBase(), this.baseObject, "TR"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getTR1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf4Functions> list = new ArrayList<>(1);
			list.add(new GFAArrayOf4Functions((COSArray)object.getDirectBase(), this.baseObject, "TR"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getTRDictionary1_3(object.getDirectBase(), "TR");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getTRStream1_3(object.getDirectBase(), "TR");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getTRDictionary1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FunctionType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 2:
				return new GFAFunctionType2(base, this.baseObject, keyName);
			case 3:
				return new GFAFunctionType3(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getTRStream1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FunctionType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 0:
				return new GFAFunctionType0(base, this.baseObject, keyName);
			case 4:
				return new GFAFunctionType4(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getTR2() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTR21_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getTR21_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR2"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf4Functions> list = new ArrayList<>(1);
			list.add(new GFAArrayOf4Functions((COSArray)object.getDirectBase(), this.baseObject, "TR2"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getTR2Dictionary1_3(object.getDirectBase(), "TR2");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getTR2Stream1_3(object.getDirectBase(), "TR2");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getTR2Dictionary1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FunctionType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 2:
				return new GFAFunctionType2(base, this.baseObject, keyName);
			case 3:
				return new GFAFunctionType3(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getTR2Stream1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FunctionType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 0:
				return new GFAFunctionType0(base, this.baseObject, keyName);
			case 4:
				return new GFAFunctionType4(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getUCR() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
				return getUCR1_2();
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getUCR1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getUCR1_2() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UCR"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AFunctionType0> list = new ArrayList<>(1);
			list.add(new GFAFunctionType0((COSStream)object.getDirectBase(), this.baseObject, "UCR"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getUCR1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UCR"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getUCRDictionary1_3(object.getDirectBase(), "UCR");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getUCRStream1_3(object.getDirectBase(), "UCR");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getUCRDictionary1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FunctionType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 2:
				return new GFAFunctionType2(base, this.baseObject, keyName);
			case 3:
				return new GFAFunctionType3(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getUCRStream1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FunctionType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 0:
				return new GFAFunctionType0(base, this.baseObject, keyName);
			case 4:
				return new GFAFunctionType4(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getUCR2() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getUCR21_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getUCR21_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UCR2"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getUCR2Dictionary1_3(object.getDirectBase(), "UCR2");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			org.verapdf.model.baselayer.Object result = getUCR2Stream1_3(object.getDirectBase(), "UCR2");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getUCR2Dictionary1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FunctionType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 2:
				return new GFAFunctionType2(base, this.baseObject, keyName);
			case 3:
				return new GFAFunctionType3(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private org.verapdf.model.baselayer.Object getUCR2Stream1_3(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("FunctionType"));
		if (subtype == null) {
			return null;
		}
		Long subtypeValue = subtype.getInteger();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue.intValue()) {
			case 0:
				return new GFAFunctionType0(base, this.baseObject, keyName);
			case 4:
				return new GFAFunctionType4(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	@Override
	public Boolean getcontainsAAPLAA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AAPL:AA"));
	}

	@Override
	public Boolean getAAPLAAHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AAPL:AA"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsAAPLST() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AAPL:ST"));
	}

	@Override
	public Boolean getAAPLSTHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AAPL:ST"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getAAPLSTHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AAPL:ST"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getcontainsAIS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AIS"));
	}

	@Override
	public Boolean getAISHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AIS"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsBG() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BG"));
	}

	@Override
	public Boolean getisBGIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BG"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getBGHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BG"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getBGHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BG"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsBG2() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BG2"));
	}

	@Override
	public Boolean getisBG2Indirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BG2"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getBG2HasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BG2"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getBG2HasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BG2"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getBG2HasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BG2"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsBM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BM"));
	}

	@Override
	public Boolean getBMHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BM"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getBMHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BM"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getBMNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BM"));
		if (object == null || object.empty()) {
			return getBMNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getBMNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsCA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CA"));
	}

	@Override
	public Boolean getCAHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CA"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getCANumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CA"));
		if (object == null || object.empty()) {
			return getCANumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getCANumberDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("D"));
	}

	@Override
	public Boolean getDHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsFL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FL"));
	}

	@Override
	public Boolean getFLHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FL"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getFLNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FL"));
		if (object == null || object.empty()) {
			return getFLNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getFLNumberDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsFont() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Font"));
	}

	@Override
	public Boolean getFontHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Font"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsHT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HT"));
	}

	@Override
	public Boolean getisHTIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HT"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getHTHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HT"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getHTHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HT"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getHTHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HT"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsHTO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HTO"));
	}

	@Override
	public Boolean getHTOHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HTO"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsHTP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HTP"));
	}

	@Override
	public Boolean getHTPHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HTP"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsLC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LC"));
	}

	@Override
	public Boolean getLCHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LC"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getLCIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LC"));
		if (object == null || object.empty()) {
			return getLCIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getLCIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsLJ() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LJ"));
	}

	@Override
	public Boolean getLJHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LJ"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getLJIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LJ"));
		if (object == null || object.empty()) {
			return getLJIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getLJIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsLW() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LW"));
	}

	@Override
	public Boolean getLWHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LW"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getLWNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LW"));
		if (object == null || object.empty()) {
			return getLWNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getLWNumberDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsML() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ML"));
	}

	@Override
	public Boolean getMLHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ML"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getMLNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ML"));
		if (object == null || object.empty()) {
			return getMLNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getMLNumberDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsOP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OP"));
	}

	@Override
	public Boolean getOPHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OP"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsOPM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OPM"));
	}

	@Override
	public Boolean getOPMHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OPM"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getOPMIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OPM"));
		if (object == null || object.empty()) {
			return getOPMIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getOPMIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsRI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RI"));
	}

	@Override
	public Boolean getRIHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RI"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getRINameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RI"));
		if (object == null || object.empty()) {
			return getRINameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getRINameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsSA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SA"));
	}

	@Override
	public Boolean getSAHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SA"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsSM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SM"));
	}

	@Override
	public Boolean getSMHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SM"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getSMNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SM"));
		if (object == null || object.empty()) {
			return getSMNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getSMNumberDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsSMask() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SMask"));
	}

	@Override
	public Boolean getSMaskHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SMask"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getSMaskHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SMask"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSMaskNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SMask"));
		if (object == null || object.empty()) {
			return getSMaskNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getSMaskNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsTK() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TK"));
	}

	@Override
	public Boolean getTKHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TK"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsTR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TR"));
	}

	@Override
	public Boolean getisTRIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getTRHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getTRHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getTRHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getTRHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsTR2() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TR2"));
	}

	@Override
	public Boolean getisTR2Indirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR2"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getTR2HasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR2"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getTR2HasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR2"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getTR2HasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR2"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getTR2HasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR2"));
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
	public Boolean getcontainsUCR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UCR"));
	}

	@Override
	public Boolean getisUCRIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UCR"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getUCRHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UCR"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getUCRHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UCR"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsUCR2() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UCR2"));
	}

	@Override
	public Boolean getisUCR2Indirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UCR2"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getUCR2HasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UCR2"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getUCR2HasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UCR2"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getUCR2HasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UCR2"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsUseBlackPtComp() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UseBlackPtComp"));
	}

	@Override
	public Boolean getUseBlackPtCompHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UseBlackPtComp"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getUseBlackPtCompNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UseBlackPtComp"));
		if (object == null || object.empty()) {
			return getUseBlackPtCompNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getUseBlackPtCompNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return "Default";
		}
		return null;
	}

	@Override
	public Boolean getcontainsca() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ca"));
	}

	@Override
	public Boolean getcaHasTypeNumber() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ca"));
		return object != null && object.getType().isNumber();
	}

	@Override
	public Double getcaNumberValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ca"));
		if (object == null || object.empty()) {
			return getcaNumberDefaultValue();
		}
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public Double getcaNumberDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsop() {
		return this.baseObject.knownKey(ASAtom.getASAtom("op"));
	}

	@Override
	public Boolean getopHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("op"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

}
