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

public class GFAAppearanceTrapNet extends GFAObject implements AAppearanceTrapNet {

	public GFAAppearanceTrapNet(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AAppearanceTrapNet");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "D":
				return getD();
			case "N":
				return getN();
			case "R":
				return getR();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getD() {
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

	private List<org.verapdf.model.baselayer.Object> getD1_3() {
		COSObject object = getDValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AAppearanceTrapNetSubDict> list = new ArrayList<>(1);
			list.add(new GFAAppearanceTrapNetSubDict((COSDictionary)object.getDirectBase(), this.baseObject, "D"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AXObjectFormTrapNet> list = new ArrayList<>(1);
			list.add(new GFAXObjectFormTrapNet((COSStream)object.getDirectBase(), this.baseObject, "D"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getN() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getN1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getN1_3() {
		COSObject object = getNValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AAppearanceTrapNetSubDict> list = new ArrayList<>(1);
			list.add(new GFAAppearanceTrapNetSubDict((COSDictionary)object.getDirectBase(), this.baseObject, "N"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AXObjectFormTrapNet> list = new ArrayList<>(1);
			list.add(new GFAXObjectFormTrapNet((COSStream)object.getDirectBase(), this.baseObject, "N"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getR() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getR1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getR1_3() {
		COSObject object = getRValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AAppearanceTrapNetSubDict> list = new ArrayList<>(1);
			list.add(new GFAAppearanceTrapNetSubDict((COSDictionary)object.getDirectBase(), this.baseObject, "R"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AXObjectFormTrapNet> list = new ArrayList<>(1);
			list.add(new GFAXObjectFormTrapNet((COSStream)object.getDirectBase(), this.baseObject, "R"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
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
	public Boolean getisDIndirect() {
		COSObject D = getDValue();
		return getisIndirect(D);
	}

	@Override
	public Boolean getDHasTypeDictionary() {
		COSObject D = getDValue();
		return getHasTypeDictionary(D);
	}

	@Override
	public Boolean getDHasTypeStream() {
		COSObject D = getDValue();
		return getHasTypeStream(D);
	}

	@Override
	public Boolean getcontainsN() {
		return this.baseObject.knownKey(ASAtom.getASAtom("N"));
	}

	public COSObject getNValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("N"));
		return object;
	}

	@Override
	public Boolean getisNIndirect() {
		COSObject N = getNValue();
		return getisIndirect(N);
	}

	@Override
	public Boolean getNHasTypeDictionary() {
		COSObject N = getNValue();
		return getHasTypeDictionary(N);
	}

	@Override
	public Boolean getNHasTypeStream() {
		COSObject N = getNValue();
		return getHasTypeStream(N);
	}

	@Override
	public Boolean getcontainsR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("R"));
	}

	public COSObject getRValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		return object;
	}

	@Override
	public Boolean getisRIndirect() {
		COSObject R = getRValue();
		return getisIndirect(R);
	}

	@Override
	public Boolean getRHasTypeDictionary() {
		COSObject R = getRValue();
		return getHasTypeDictionary(R);
	}

	@Override
	public Boolean getRHasTypeStream() {
		COSObject R = getRValue();
		return getHasTypeStream(R);
	}

}
