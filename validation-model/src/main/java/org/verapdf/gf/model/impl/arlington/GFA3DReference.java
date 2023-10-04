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

public class GFA3DReference extends GFAObject implements A3DReference {

	public GFA3DReference(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "A3DReference");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "entry3DD":
				return getentry3DD();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AStream> getentry3DD() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry3DD1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getentry3DD1_6() {
		COSObject object = getentry3DDValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "3DD"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontains3DD() {
		return this.baseObject.knownKey(ASAtom.getASAtom("3DD"));
	}

	public COSObject getentry3DDValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("3DD"));
		return object;
	}

	@Override
	public Boolean getisentry3DDIndirect() {
		COSObject entry3DD = getentry3DDValue();
		return getisIndirect(entry3DD);
	}

	@Override
	public Boolean getentry3DDHasTypeStream() {
		COSObject entry3DD = getentry3DDValue();
		return getHasTypeStream(entry3DD);
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
		COSObject Type = getTypeValue();
		return getHasTypeName(Type);
	}

	@Override
	public String getTypeNameValue() {
		COSObject Type = getTypeValue();
		return getNameValue(Type);
	}

}
