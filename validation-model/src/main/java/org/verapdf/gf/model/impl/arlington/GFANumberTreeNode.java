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

public class GFANumberTreeNode extends GFAObject implements ANumberTreeNode {

	public GFANumberTreeNode(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ANumberTreeNode");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Kids":
				return getKids();
			case "Limits":
				return getLimits();
			case "Nums":
				return getNums();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ANumberTreeNodesArray> getKids() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getKids1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANumberTreeNodesArray> getKids1_3() {
		COSObject object = getKidsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<ANumberTreeNodesArray> list = new ArrayList<>(1);
			list.add(new GFANumberTreeNodesArray((COSArray)object.getDirectBase(), this.baseObject, "Kids"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANumberTreeNodeLimitsArray> getLimits() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getLimits1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANumberTreeNodeLimitsArray> getLimits1_3() {
		COSObject object = getLimitsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<ANumberTreeNodeLimitsArray> list = new ArrayList<>(1);
			list.add(new GFANumberTreeNodeLimitsArray((COSArray)object.getDirectBase(), this.baseObject, "Limits"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANumberTreeNodeNumsArray> getNums() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getNums1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANumberTreeNodeNumsArray> getNums1_3() {
		COSObject object = getNumsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<ANumberTreeNodeNumsArray> list = new ArrayList<>(1);
			list.add(new GFANumberTreeNodeNumsArray((COSArray)object.getDirectBase(), this.baseObject, "Nums"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsKids() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Kids"));
	}

	public COSObject getKidsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Kids"));
		return object;
	}

	@Override
	public String getKidsType() {
		COSObject Kids = getKidsValue();
		return getObjectType(Kids);
	}

	@Override
	public Boolean getKidsHasTypeArray() {
		COSObject Kids = getKidsValue();
		return getHasTypeArray(Kids);
	}

	@Override
	public Boolean getcontainsLimits() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Limits"));
	}

	public COSObject getLimitsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Limits"));
		return object;
	}

	@Override
	public String getLimitsType() {
		COSObject Limits = getLimitsValue();
		return getObjectType(Limits);
	}

	@Override
	public Boolean getLimitsHasTypeArray() {
		COSObject Limits = getLimitsValue();
		return getHasTypeArray(Limits);
	}

	@Override
	public Boolean getcontainsNums() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Nums"));
	}

	public COSObject getNumsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Nums"));
		return object;
	}

	@Override
	public String getNumsType() {
		COSObject Nums = getNumsValue();
		return getObjectType(Nums);
	}

	@Override
	public Boolean getNumsHasTypeArray() {
		COSObject Nums = getNumsValue();
		return getHasTypeArray(Nums);
	}

}
