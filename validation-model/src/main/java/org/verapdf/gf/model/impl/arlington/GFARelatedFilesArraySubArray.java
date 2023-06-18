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

public class GFARelatedFilesArraySubArray extends GFAObject implements ARelatedFilesArraySubArray {

	public GFARelatedFilesArraySubArray(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ARelatedFilesArraySubArray");
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

	private List<AEmbeddedFileStream> getentry1() {
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

	private List<AEmbeddedFileStream> getentry11_3() {
		COSObject object = getentry1Value();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AEmbeddedFileStream> list = new ArrayList<>(1);
			list.add(new GFAEmbeddedFileStream((COSStream)object.getDirectBase(), this.baseObject, "1"));
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
	public Boolean getentry0HasTypeString() {
		COSObject object = getentry0Value();
		return object != null && object.getType() == COSObjType.COS_STRING;
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
		COSObject object = getentry1Value();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getentry1HasTypeStream() {
		COSObject object = getentry1Value();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

}
