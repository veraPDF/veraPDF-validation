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
import java.io.IOException;

public class GFAArrayOfNavigatorLayoutNames extends GFAObject implements AArrayOfNavigatorLayoutNames {

	public GFAArrayOfNavigatorLayoutNames(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AArrayOfNavigatorLayoutNames");
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

	private List<AArrayOfNavigatorLayoutNamesEntry> getEntries() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getEntries2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNavigatorLayoutNamesEntry> getEntries2_0() {
		List<AArrayOfNavigatorLayoutNamesEntry> list = new LinkedList<>();
		for (int i = 0; i < baseObject.size(); i++) {
			COSObject object = baseObject.at(i);
			list.add(new GFAArrayOfNavigatorLayoutNamesEntry(object != null ? object.get() : null, this.baseObject, keyName, String.valueOf(i)));
		}
		return Collections.unmodifiableList(list);
	}

}
