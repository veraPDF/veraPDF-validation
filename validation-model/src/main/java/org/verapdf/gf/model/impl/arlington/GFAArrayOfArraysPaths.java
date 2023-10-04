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

public class GFAArrayOfArraysPaths extends GFAObject implements AArrayOfArraysPaths {

	public GFAArrayOfArraysPaths(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfArraysPaths");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Entries":
				return getEntries();
			case "entry0":
				return getentry0();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfArraysPathsEntry> getEntries() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getEntries2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfArraysPathsEntry> getEntries2_0() {
		List<AArrayOfArraysPathsEntry> list = new LinkedList<>();
		for (int i = 1; i < baseObject.size(); i++) {
			COSObject object = baseObject.at(i);
			list.add(new GFAArrayOfArraysPathsEntry(object != null ? object.get() : null, this.baseObject, this.parentObject, keyName, String.valueOf(i)));
		}
		return Collections.unmodifiableList(list);
	}

	private List<AArrayOfPaths> getentry0() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getentry02_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfPaths> getentry02_0() {
		COSObject object = getentry0Value();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfPaths> list = new ArrayList<>(1);
			list.add(new GFAArrayOfPaths((COSArray)object.getDirectBase(), this.baseObject, "0"));
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
	public Boolean getentry0HasTypeArray() {
		COSObject entry0 = getentry0Value();
		return getHasTypeArray(entry0);
	}

	@Override
	public Long getentry0ArraySize() {
		COSObject entry0 = getentry0Value();
		return getArraySize(entry0);
	}

}
