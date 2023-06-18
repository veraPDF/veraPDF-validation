package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;

public class GFAFilterJBIG2Decode extends GFAObject implements AFilterJBIG2Decode {

	public GFAFilterJBIG2Decode(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFilterJBIG2Decode");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "JBIG2Globals":
				return getJBIG2Globals();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AStream> getJBIG2Globals() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getJBIG2Globals1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getJBIG2Globals1_4() {
		COSObject object = getJBIG2GlobalsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "JBIG2Globals"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsJBIG2Globals() {
		return this.baseObject.knownKey(ASAtom.getASAtom("JBIG2Globals"));
	}

	public COSObject getJBIG2GlobalsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("JBIG2Globals"));
		return object;
	}

	@Override
	public Boolean getisJBIG2GlobalsIndirect() {
		COSObject object = getJBIG2GlobalsValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getJBIG2GlobalsHasTypeStream() {
		COSObject object = getJBIG2GlobalsValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

}
