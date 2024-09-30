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

public class GFAArrayOfRichMediaCuePoints extends GFAObject implements AArrayOfRichMediaCuePoints {

	public GFAArrayOfRichMediaCuePoints(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfRichMediaCuePoints");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Entries":
				return getEntries();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfRichMediaCuePointsEntry> getEntries() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionADBE_Extn3() == true)) {
					return getEntries1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfRichMediaCuePointsEntry> getEntries1_7() {
		List<AArrayOfRichMediaCuePointsEntry> list = new LinkedList<>();
		for (int i = 0; i < baseObject.size(); i++) {
			COSObject object = baseObject.at(i);
			list.add(new GFAArrayOfRichMediaCuePointsEntry(object != null ? object.get() : null, this.baseObject, this.parentObject, keyName, String.valueOf(i)));
		}
		return Collections.unmodifiableList(list);
	}

}
