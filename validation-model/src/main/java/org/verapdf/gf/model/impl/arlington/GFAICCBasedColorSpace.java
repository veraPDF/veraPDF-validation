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

public class GFAICCBasedColorSpace extends GFAObject implements AICCBasedColorSpace {

	public GFAICCBasedColorSpace(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AICCBasedColorSpace");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "entry1":
				return getentry1();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AICCProfileStream> getentry1() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getentry11_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AICCProfileStream> getentry11_3() {
		COSObject object = getentry1Value();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AICCProfileStream> list = new ArrayList<>(1);
			list.add(new GFAICCProfileStream((COSStream)object.getDirectBase(), this.baseObject, "1"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	public COSObject getentry0Value() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object;
	}

	@Override
	public String getentry0Type() {
		COSObject entry0 = getentry0Value();
		return getObjectType(entry0);
	}

	@Override
	public Boolean getentry0HasTypeName() {
		COSObject entry0 = getentry0Value();
		return getHasTypeName(entry0);
	}

	@Override
	public String getentry0NameValue() {
		COSObject entry0 = getentry0Value();
		return getNameValue(entry0);
	}

	public COSObject getentry1Value() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		return object;
	}

	@Override
	public Boolean getisentry1Indirect() {
		COSObject entry1 = getentry1Value();
		return getisIndirect(entry1);
	}

	@Override
	public String getentry1Type() {
		COSObject entry1 = getentry1Value();
		return getObjectType(entry1);
	}

	@Override
	public Boolean getentry1HasTypeStream() {
		COSObject entry1 = getentry1Value();
		return getHasTypeStream(entry1);
	}

}
