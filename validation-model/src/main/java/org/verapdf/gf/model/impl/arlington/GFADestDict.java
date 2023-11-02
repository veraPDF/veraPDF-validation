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

public class GFADestDict extends GFAObject implements ADestDict {

	public GFADestDict(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ADestDict");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "D":
				return getD();
			case "SD":
				return getSD();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getD() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getD1_1();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getD1_1() {
		COSObject object = getDValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getDArray1_1(object.getDirectBase(), "D");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getDArray1_1(COSBase base, String keyName) {
		switch (base.size()) {
			case 2:
				return new GFADest0Array(base, this.baseObject, keyName);
			case 3:
				return new GFADest1Array(base, this.baseObject, keyName);
			case 5:
				return new GFADestXYZArray(base, this.baseObject, keyName);
			case 6:
				return new GFADest4Array(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	private List<org.verapdf.model.baselayer.Object> getSD() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getSD2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getSD2_0() {
		COSObject object = getSDValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			org.verapdf.model.baselayer.Object result = getSDArray2_0(object.getDirectBase(), "SD");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getSDArray2_0(COSBase base, String keyName) {
		switch (base.size()) {
			case 2:
				return new GFADest0StructArray(base, this.baseObject, keyName);
			case 3:
				return new GFADest1StructArray(base, this.baseObject, keyName);
			case 5:
				return new GFADestXYZStructArray(base, this.baseObject, keyName);
			case 6:
				return new GFADest4StructArray(base, this.baseObject, keyName);
			default:
				return null;
		}
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
	public Boolean getcontainsSD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SD"));
	}

	public COSObject getSDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SD"));
		return object;
	}

	@Override
	public String getSDType() {
		COSObject SD = getSDValue();
		return getObjectType(SD);
	}

	@Override
	public Boolean getSDHasTypeArray() {
		COSObject SD = getSDValue();
		return getHasTypeArray(SD);
	}

}
