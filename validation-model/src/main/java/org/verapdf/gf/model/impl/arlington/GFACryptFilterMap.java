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

public class GFACryptFilterMap extends GFAObject implements ACryptFilterMap {

	public GFACryptFilterMap(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACryptFilterMap");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Entries":
				return getEntries();
			case "Identity":
				return getIdentity();
			case "StdCF":
				return getStdCF();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ACryptFilterMapEntry> getEntries() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntries1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACryptFilterMapEntry> getEntries1_5() {
		List<ACryptFilterMapEntry> list = new LinkedList<>();
		for (ASAtom key : baseObject.getKeySet()) {
			if ("Identity".equals(key.getValue()) || "StdCF".equals(key.getValue())) {
				continue;
			}
			COSObject object = this.baseObject.getKey(key);
			list.add(new GFACryptFilterMapEntry(object != null ? object.get() : null, this.baseObject, this.parentObject, keyName, key.getValue()));
		}
		return Collections.unmodifiableList(list);
	}

	private List<ACryptFilter> getIdentity() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getIdentity1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACryptFilter> getIdentity1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Identity"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACryptFilter> list = new ArrayList<>(1);
			list.add(new GFACryptFilter((COSDictionary)object.getDirectBase(), this.baseObject, "Identity"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACryptFilter> getStdCF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getStdCF1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACryptFilter> getStdCF1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StdCF"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACryptFilter> list = new ArrayList<>(1);
			list.add(new GFACryptFilter((COSDictionary)object.getDirectBase(), this.baseObject, "StdCF"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsIdentity() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Identity"));
	}

	@Override
	public Boolean getIdentityHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Identity"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsStdCF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StdCF"));
	}

	@Override
	public Boolean getStdCFHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("StdCF"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public String getStdCFAuthEventNameValue() {
		if (this.baseObject == null || !this.baseObject.getType().isDictionaryBased()) {
			return null;
		}
		COSObject StdCF = this.baseObject.getKey(ASAtom.getASAtom("StdCF"));
		if (StdCF == null || !StdCF.getType().isDictionaryBased()) {
			return null;
		}
		COSObject AuthEvent = StdCF.getKey(ASAtom.getASAtom("AuthEvent"));
		return new GFACryptFilter(StdCF.getDirectBase(), null, null).getAuthEventNameValue();
	}

}
