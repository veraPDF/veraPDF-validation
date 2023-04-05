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

public class GFAMac extends GFAObject implements AMac {

	public GFAMac(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AMac");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "ResFork":
				return getResFork();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AStream> getResFork() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getResFork1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getResFork1_3() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ResFork"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "ResFork"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsResFork() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ResFork"));
	}

	@Override
	public Boolean getisResForkIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ResFork"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getResForkHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ResFork"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsSubtype() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype"));
	}

	@Override
	public Boolean getSubtypeHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getcontainsCreator() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Creator"));
	}

	@Override
	public Boolean getCreatorHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Creator"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

}
