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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getAAPLSTValue();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getBGValue();
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
		COSObject object = getBGValue();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getBG2Value();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getBMValue();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getDValue();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getFontValue();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getHTValue();
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
			case 10:
				return new GFAHalftoneType10(base, this.baseObject, keyName);
			case 6:
				return new GFAHalftoneType6(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getHT1_3() {
		COSObject object = getHTValue();
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
			case 10:
				return new GFAHalftoneType10(base, this.baseObject, keyName);
			case 16:
				return new GFAHalftoneType16(base, this.baseObject, keyName);
			case 6:
				return new GFAHalftoneType6(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<AArrayOf_2Numbers> getHTO() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getHTO2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2Numbers> getHTO2_0() {
		COSObject object = getHTOValue();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getHTPValue();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getSMaskValue();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getTRValue();
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
		COSObject object = getTRValue();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getTR2Value();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getUCRValue();
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
		COSObject object = getUCRValue();
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
		switch (StaticContainers.getFlavour()) {
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
		COSObject object = getUCR2Value();
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

	public COSObject getAAPLAAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AAPL:AA"));
		return object;
	}

	@Override
	public String getAAPLAAType() {
		COSObject AAPLAA = getAAPLAAValue();
		return getObjectType(AAPLAA);
	}

	@Override
	public Boolean getAAPLAAHasTypeBoolean() {
		COSObject AAPLAA = getAAPLAAValue();
		return getHasTypeBoolean(AAPLAA);
	}

	@Override
	public Boolean getcontainsAAPLST() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AAPL:ST"));
	}

	public COSObject getAAPLSTDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("None");
		}
		return null;
	}

	public COSObject getAAPLSTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AAPL:ST"));
		if (object == null || object.empty()) {
			object = getAAPLSTDefaultValue();
		}
		return object;
	}

	@Override
	public String getAAPLSTType() {
		COSObject AAPLST = getAAPLSTValue();
		return getObjectType(AAPLST);
	}

	@Override
	public Boolean getAAPLSTHasTypeDictionary() {
		COSObject AAPLST = getAAPLSTValue();
		return getHasTypeDictionary(AAPLST);
	}

	@Override
	public Boolean getAAPLSTHasTypeName() {
		COSObject AAPLST = getAAPLSTValue();
		return getHasTypeName(AAPLST);
	}

	@Override
	public Boolean getcontainsAIS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AIS"));
	}

	public COSObject getAISValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AIS"));
		return object;
	}

	@Override
	public String getAISType() {
		COSObject AIS = getAISValue();
		return getObjectType(AIS);
	}

	@Override
	public Boolean getAISHasTypeBoolean() {
		COSObject AIS = getAISValue();
		return getHasTypeBoolean(AIS);
	}

	@Override
	public Boolean getcontainsBG() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BG"));
	}

	public COSObject getBGValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BG"));
		return object;
	}

	@Override
	public Boolean getisBGIndirect() {
		COSObject BG = getBGValue();
		return getisIndirect(BG);
	}

	@Override
	public String getBGType() {
		COSObject BG = getBGValue();
		return getObjectType(BG);
	}

	@Override
	public Boolean getBGHasTypeDictionary() {
		COSObject BG = getBGValue();
		return getHasTypeDictionary(BG);
	}

	@Override
	public Boolean getBGHasTypeStream() {
		COSObject BG = getBGValue();
		return getHasTypeStream(BG);
	}

	@Override
	public Boolean getcontainsBG2() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BG2"));
	}

	public COSObject getBG2DefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Default");
		}
		return null;
	}

	public COSObject getBG2Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BG2"));
		if (object == null || object.empty()) {
			object = getBG2DefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getisBG2Indirect() {
		COSObject BG2 = getBG2Value();
		return getisIndirect(BG2);
	}

	@Override
	public String getBG2Type() {
		COSObject BG2 = getBG2Value();
		return getObjectType(BG2);
	}

	@Override
	public Boolean getBG2HasTypeDictionary() {
		COSObject BG2 = getBG2Value();
		return getHasTypeDictionary(BG2);
	}

	@Override
	public Boolean getBG2HasTypeName() {
		COSObject BG2 = getBG2Value();
		return getHasTypeName(BG2);
	}

	@Override
	public Boolean getBG2HasTypeStream() {
		COSObject BG2 = getBG2Value();
		return getHasTypeStream(BG2);
	}

	@Override
	public Boolean getcontainsBM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BM"));
	}

	public COSObject getBMValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BM"));
		return object;
	}

	@Override
	public String getBMType() {
		COSObject BM = getBMValue();
		return getObjectType(BM);
	}

	@Override
	public Boolean getBMHasTypeArray() {
		COSObject BM = getBMValue();
		return getHasTypeArray(BM);
	}

	@Override
	public Boolean getBMHasTypeName() {
		COSObject BM = getBMValue();
		return getHasTypeName(BM);
	}

	@Override
	public String getBMNameValue() {
		COSObject BM = getBMValue();
		return getNameValue(BM);
	}

	@Override
	public Boolean getcontainsCA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CA"));
	}

	public COSObject getCAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CA"));
		return object;
	}

	@Override
	public String getCAType() {
		COSObject CA = getCAValue();
		return getObjectType(CA);
	}

	@Override
	public Boolean getCAHasTypeNumber() {
		COSObject CA = getCAValue();
		return getHasTypeNumber(CA);
	}

	@Override
	public Double getCANumberValue() {
		COSObject CA = getCAValue();
		return getNumberValue(CA);
	}

	@Override
	public Boolean getcontainsD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("D"));
	}

	public COSObject getDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("D"));
		return object;
	}

	@Override
	public String getDType() {
		COSObject D = getDValue();
		return getObjectType(D);
	}

	@Override
	public Boolean getDHasTypeArray() {
		COSObject D = getDValue();
		return getHasTypeArray(D);
	}

	@Override
	public Boolean getcontainsFL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("FL"));
	}

	public COSObject getFLValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("FL"));
		return object;
	}

	@Override
	public String getFLType() {
		COSObject FL = getFLValue();
		return getObjectType(FL);
	}

	@Override
	public Boolean getFLHasTypeNumber() {
		COSObject FL = getFLValue();
		return getHasTypeNumber(FL);
	}

	@Override
	public Double getFLNumberValue() {
		COSObject FL = getFLValue();
		return getNumberValue(FL);
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
	public Boolean getFontHasTypeArray() {
		COSObject Font = getFontValue();
		return getHasTypeArray(Font);
	}

	@Override
	public Boolean getcontainsHT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HT"));
	}

	public COSObject getHTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HT"));
		return object;
	}

	@Override
	public Boolean getisHTIndirect() {
		COSObject HT = getHTValue();
		return getisIndirect(HT);
	}

	@Override
	public String getHTType() {
		COSObject HT = getHTValue();
		return getObjectType(HT);
	}

	@Override
	public Boolean getHTHasTypeDictionary() {
		COSObject HT = getHTValue();
		return getHasTypeDictionary(HT);
	}

	@Override
	public Boolean getHTHasTypeName() {
		COSObject HT = getHTValue();
		return getHasTypeName(HT);
	}

	@Override
	public Boolean getHTHasTypeStream() {
		COSObject HT = getHTValue();
		return getHasTypeStream(HT);
	}

	@Override
	public Boolean getcontainsHTO() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HTO"));
	}

	public COSObject getHTOValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HTO"));
		return object;
	}

	@Override
	public String getHTOType() {
		COSObject HTO = getHTOValue();
		return getObjectType(HTO);
	}

	@Override
	public Boolean getHTOHasTypeArray() {
		COSObject HTO = getHTOValue();
		return getHasTypeArray(HTO);
	}

	@Override
	public Boolean getcontainsHTP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HTP"));
	}

	public COSObject getHTPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HTP"));
		return object;
	}

	@Override
	public String getHTPType() {
		COSObject HTP = getHTPValue();
		return getObjectType(HTP);
	}

	@Override
	public Boolean getHTPHasTypeArray() {
		COSObject HTP = getHTPValue();
		return getHasTypeArray(HTP);
	}

	@Override
	public Boolean getcontainsLC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LC"));
	}

	public COSObject getLCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LC"));
		return object;
	}

	@Override
	public String getLCType() {
		COSObject LC = getLCValue();
		return getObjectType(LC);
	}

	@Override
	public Boolean getLCHasTypeInteger() {
		COSObject LC = getLCValue();
		return getHasTypeInteger(LC);
	}

	@Override
	public Long getLCIntegerValue() {
		COSObject LC = getLCValue();
		return getIntegerValue(LC);
	}

	@Override
	public Boolean getcontainsLJ() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LJ"));
	}

	public COSObject getLJValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LJ"));
		return object;
	}

	@Override
	public String getLJType() {
		COSObject LJ = getLJValue();
		return getObjectType(LJ);
	}

	@Override
	public Boolean getLJHasTypeInteger() {
		COSObject LJ = getLJValue();
		return getHasTypeInteger(LJ);
	}

	@Override
	public Long getLJIntegerValue() {
		COSObject LJ = getLJValue();
		return getIntegerValue(LJ);
	}

	@Override
	public Boolean getcontainsLW() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LW"));
	}

	public COSObject getLWValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LW"));
		return object;
	}

	@Override
	public String getLWType() {
		COSObject LW = getLWValue();
		return getObjectType(LW);
	}

	@Override
	public Boolean getLWHasTypeNumber() {
		COSObject LW = getLWValue();
		return getHasTypeNumber(LW);
	}

	@Override
	public Double getLWNumberValue() {
		COSObject LW = getLWValue();
		return getNumberValue(LW);
	}

	@Override
	public Boolean getcontainsML() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ML"));
	}

	public COSObject getMLValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ML"));
		return object;
	}

	@Override
	public String getMLType() {
		COSObject ML = getMLValue();
		return getObjectType(ML);
	}

	@Override
	public Boolean getMLHasTypeNumber() {
		COSObject ML = getMLValue();
		return getHasTypeNumber(ML);
	}

	@Override
	public Double getMLNumberValue() {
		COSObject ML = getMLValue();
		return getNumberValue(ML);
	}

	@Override
	public Boolean getcontainsOP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OP"));
	}

	public COSObject getOPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OP"));
		return object;
	}

	@Override
	public String getOPType() {
		COSObject OP = getOPValue();
		return getObjectType(OP);
	}

	@Override
	public Boolean getOPHasTypeBoolean() {
		COSObject OP = getOPValue();
		return getHasTypeBoolean(OP);
	}

	@Override
	public Boolean getcontainsOPM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OPM"));
	}

	public COSObject getOPMValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OPM"));
		return object;
	}

	@Override
	public String getOPMType() {
		COSObject OPM = getOPMValue();
		return getObjectType(OPM);
	}

	@Override
	public Boolean getOPMHasTypeInteger() {
		COSObject OPM = getOPMValue();
		return getHasTypeInteger(OPM);
	}

	@Override
	public Long getOPMIntegerValue() {
		COSObject OPM = getOPMValue();
		return getIntegerValue(OPM);
	}

	@Override
	public Boolean getcontainsRI() {
		return this.baseObject.knownKey(ASAtom.getASAtom("RI"));
	}

	public COSObject getRIValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("RI"));
		return object;
	}

	@Override
	public String getRIType() {
		COSObject RI = getRIValue();
		return getObjectType(RI);
	}

	@Override
	public Boolean getRIHasTypeName() {
		COSObject RI = getRIValue();
		return getHasTypeName(RI);
	}

	@Override
	public String getRINameValue() {
		COSObject RI = getRIValue();
		return getNameValue(RI);
	}

	@Override
	public Boolean getcontainsSA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SA"));
	}

	public COSObject getSAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SA"));
		return object;
	}

	@Override
	public String getSAType() {
		COSObject SA = getSAValue();
		return getObjectType(SA);
	}

	@Override
	public Boolean getSAHasTypeBoolean() {
		COSObject SA = getSAValue();
		return getHasTypeBoolean(SA);
	}

	@Override
	public Boolean getcontainsSM() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SM"));
	}

	public COSObject getSMValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SM"));
		return object;
	}

	@Override
	public String getSMType() {
		COSObject SM = getSMValue();
		return getObjectType(SM);
	}

	@Override
	public Boolean getSMHasTypeNumber() {
		COSObject SM = getSMValue();
		return getHasTypeNumber(SM);
	}

	@Override
	public Double getSMNumberValue() {
		COSObject SM = getSMValue();
		return getNumberValue(SM);
	}

	@Override
	public Boolean getcontainsSMask() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SMask"));
	}

	public COSObject getSMaskValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SMask"));
		return object;
	}

	@Override
	public String getSMaskType() {
		COSObject SMask = getSMaskValue();
		return getObjectType(SMask);
	}

	@Override
	public Boolean getSMaskHasTypeDictionary() {
		COSObject SMask = getSMaskValue();
		return getHasTypeDictionary(SMask);
	}

	@Override
	public Boolean getSMaskHasTypeName() {
		COSObject SMask = getSMaskValue();
		return getHasTypeName(SMask);
	}

	@Override
	public String getSMaskNameValue() {
		COSObject SMask = getSMaskValue();
		return getNameValue(SMask);
	}

	@Override
	public Boolean getcontainsTK() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TK"));
	}

	public COSObject getTKValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TK"));
		return object;
	}

	@Override
	public String getTKType() {
		COSObject TK = getTKValue();
		return getObjectType(TK);
	}

	@Override
	public Boolean getTKHasTypeBoolean() {
		COSObject TK = getTKValue();
		return getHasTypeBoolean(TK);
	}

	@Override
	public Boolean getcontainsTR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TR"));
	}

	public COSObject getTRValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR"));
		return object;
	}

	@Override
	public Boolean getisTRIndirect() {
		COSObject TR = getTRValue();
		return getisIndirect(TR);
	}

	@Override
	public String getTRType() {
		COSObject TR = getTRValue();
		return getObjectType(TR);
	}

	@Override
	public Boolean getTRHasTypeArray() {
		COSObject TR = getTRValue();
		return getHasTypeArray(TR);
	}

	@Override
	public Boolean getTRHasTypeDictionary() {
		COSObject TR = getTRValue();
		return getHasTypeDictionary(TR);
	}

	@Override
	public Boolean getTRHasTypeName() {
		COSObject TR = getTRValue();
		return getHasTypeName(TR);
	}

	@Override
	public Boolean getTRHasTypeStream() {
		COSObject TR = getTRValue();
		return getHasTypeStream(TR);
	}

	@Override
	public Boolean getcontainsTR2() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TR2"));
	}

	public COSObject getTR2DefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Default");
		}
		return null;
	}

	public COSObject getTR2Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TR2"));
		if (object == null || object.empty()) {
			object = getTR2DefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getisTR2Indirect() {
		COSObject TR2 = getTR2Value();
		return getisIndirect(TR2);
	}

	@Override
	public String getTR2Type() {
		COSObject TR2 = getTR2Value();
		return getObjectType(TR2);
	}

	@Override
	public Boolean getTR2HasTypeArray() {
		COSObject TR2 = getTR2Value();
		return getHasTypeArray(TR2);
	}

	@Override
	public Boolean getTR2HasTypeDictionary() {
		COSObject TR2 = getTR2Value();
		return getHasTypeDictionary(TR2);
	}

	@Override
	public Boolean getTR2HasTypeName() {
		COSObject TR2 = getTR2Value();
		return getHasTypeName(TR2);
	}

	@Override
	public Boolean getTR2HasTypeStream() {
		COSObject TR2 = getTR2Value();
		return getHasTypeStream(TR2);
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
	public Boolean getcontainsUCR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UCR"));
	}

	public COSObject getUCRValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UCR"));
		return object;
	}

	@Override
	public Boolean getisUCRIndirect() {
		COSObject UCR = getUCRValue();
		return getisIndirect(UCR);
	}

	@Override
	public String getUCRType() {
		COSObject UCR = getUCRValue();
		return getObjectType(UCR);
	}

	@Override
	public Boolean getUCRHasTypeDictionary() {
		COSObject UCR = getUCRValue();
		return getHasTypeDictionary(UCR);
	}

	@Override
	public Boolean getUCRHasTypeStream() {
		COSObject UCR = getUCRValue();
		return getHasTypeStream(UCR);
	}

	@Override
	public Boolean getcontainsUCR2() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UCR2"));
	}

	public COSObject getUCR2DefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Default");
		}
		return null;
	}

	public COSObject getUCR2Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UCR2"));
		if (object == null || object.empty()) {
			object = getUCR2DefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getisUCR2Indirect() {
		COSObject UCR2 = getUCR2Value();
		return getisIndirect(UCR2);
	}

	@Override
	public String getUCR2Type() {
		COSObject UCR2 = getUCR2Value();
		return getObjectType(UCR2);
	}

	@Override
	public Boolean getUCR2HasTypeDictionary() {
		COSObject UCR2 = getUCR2Value();
		return getHasTypeDictionary(UCR2);
	}

	@Override
	public Boolean getUCR2HasTypeName() {
		COSObject UCR2 = getUCR2Value();
		return getHasTypeName(UCR2);
	}

	@Override
	public Boolean getUCR2HasTypeStream() {
		COSObject UCR2 = getUCR2Value();
		return getHasTypeStream(UCR2);
	}

	@Override
	public Boolean getcontainsUseBlackPtComp() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UseBlackPtComp"));
	}

	public COSObject getUseBlackPtCompDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return COSName.construct("Default");
		}
		return null;
	}

	public COSObject getUseBlackPtCompValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UseBlackPtComp"));
		if (object == null || object.empty()) {
			object = getUseBlackPtCompDefaultValue();
		}
		return object;
	}

	@Override
	public String getUseBlackPtCompType() {
		COSObject UseBlackPtComp = getUseBlackPtCompValue();
		return getObjectType(UseBlackPtComp);
	}

	@Override
	public Boolean getUseBlackPtCompHasTypeName() {
		COSObject UseBlackPtComp = getUseBlackPtCompValue();
		return getHasTypeName(UseBlackPtComp);
	}

	@Override
	public String getUseBlackPtCompNameValue() {
		COSObject UseBlackPtComp = getUseBlackPtCompValue();
		return getNameValue(UseBlackPtComp);
	}

	@Override
	public Boolean getcontainsca() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ca"));
	}

	public COSObject getcaValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ca"));
		return object;
	}

	@Override
	public String getcaType() {
		COSObject ca = getcaValue();
		return getObjectType(ca);
	}

	@Override
	public Boolean getcaHasTypeNumber() {
		COSObject ca = getcaValue();
		return getHasTypeNumber(ca);
	}

	@Override
	public Double getcaNumberValue() {
		COSObject ca = getcaValue();
		return getNumberValue(ca);
	}

	@Override
	public Boolean getcontainsop() {
		return this.baseObject.knownKey(ASAtom.getASAtom("op"));
	}

	public COSObject getopValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("op"));
		return object;
	}

	@Override
	public String getopType() {
		COSObject op = getopValue();
		return getObjectType(op);
	}

	@Override
	public Boolean getopHasTypeBoolean() {
		COSObject op = getopValue();
		return getHasTypeBoolean(op);
	}

	@Override
	public Boolean gethasExtensionAAPL() {
		return false;
	}

}
