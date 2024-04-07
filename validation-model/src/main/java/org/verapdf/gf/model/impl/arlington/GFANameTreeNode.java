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

public class GFANameTreeNode extends GFAObject implements ANameTreeNode {

	public GFANameTreeNode(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ANameTreeNode");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Kids":
				return getKids();
			case "Limits":
				return getLimits();
			case "Names":
				return getNames();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ANameTreeNodesArray> getKids() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getKids1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameTreeNodesArray> getKids1_2() {
		COSObject object = getKidsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<ANameTreeNodesArray> list = new ArrayList<>(1);
			list.add(new GFANameTreeNodesArray((COSArray)object.getDirectBase(), this.baseObject, "Kids"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameTreeNodeLimitsArray> getLimits() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getLimits1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameTreeNodeLimitsArray> getLimits1_2() {
		COSObject object = getLimitsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<ANameTreeNodeLimitsArray> list = new ArrayList<>(1);
			list.add(new GFANameTreeNodeLimitsArray((COSArray)object.getDirectBase(), this.baseObject, "Limits"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ANameTreeNodeNamesArray> getNames() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getNames1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<ANameTreeNodeNamesArray> getNames1_2() {
		COSObject object = getNamesValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<ANameTreeNodeNamesArray> list = new ArrayList<>(1);
			list.add(new GFANameTreeNodeNamesArray((COSArray)object.getDirectBase(), this.baseObject, "Names"));
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
	public Boolean getcontainsNames() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Names"));
	}

	public COSObject getNamesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Names"));
		return object;
	}

	@Override
	public String getNamesType() {
		COSObject Names = getNamesValue();
		return getObjectType(Names);
	}

	@Override
	public Boolean getNamesHasTypeArray() {
		COSObject Names = getNamesValue();
		return getHasTypeArray(Names);
	}

}
