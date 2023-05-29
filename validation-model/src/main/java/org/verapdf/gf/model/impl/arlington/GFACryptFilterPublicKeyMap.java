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

public class GFACryptFilterPublicKeyMap extends GFAObject implements ACryptFilterPublicKeyMap {

	public GFACryptFilterPublicKeyMap(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ACryptFilterPublicKeyMap");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Entries":
				return getEntries();
			case "DefEmbeddedFile":
				return getDefEmbeddedFile();
			case "DefaultCryptFilter":
				return getDefaultCryptFilter();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ACryptFilterPublicKeyMapEntry> getEntries() {
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

	private List<ACryptFilterPublicKeyMapEntry> getEntries1_5() {
		List<ACryptFilterPublicKeyMapEntry> list = new LinkedList<>();
		for (ASAtom key : baseObject.getKeySet()) {
			if ("DefEmbeddedFile".equals(key.getValue()) || "DefaultCryptFilter".equals(key.getValue())) {
				continue;
			}
			COSObject object = this.baseObject.getKey(key);
			list.add(new GFACryptFilterPublicKeyMapEntry(object != null ? object.get() : null, this.baseObject, this.parentObject, keyName, key.getValue()));
		}
		return Collections.unmodifiableList(list);
	}

	private List<ACryptFilterPublicKey> getDefEmbeddedFile() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDefEmbeddedFile1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACryptFilterPublicKey> getDefEmbeddedFile1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DefEmbeddedFile"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACryptFilterPublicKey> list = new ArrayList<>(1);
			list.add(new GFACryptFilterPublicKey((COSDictionary)object.getDirectBase(), this.baseObject, "DefEmbeddedFile"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACryptFilterPublicKey> getDefaultCryptFilter() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDefaultCryptFilter1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACryptFilterPublicKey> getDefaultCryptFilter1_5() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DefaultCryptFilter"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ACryptFilterPublicKey> list = new ArrayList<>(1);
			list.add(new GFACryptFilterPublicKey((COSDictionary)object.getDirectBase(), this.baseObject, "DefaultCryptFilter"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsDefEmbeddedFile() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DefEmbeddedFile"));
	}

	public COSObject getDefEmbeddedFileValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DefEmbeddedFile"));
		return object;
	}

	@Override
	public Boolean getDefEmbeddedFileHasTypeDictionary() {
		COSObject object = getDefEmbeddedFileValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsDefaultCryptFilter() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DefaultCryptFilter"));
	}

	public COSObject getDefaultCryptFilterValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DefaultCryptFilter"));
		return object;
	}

	@Override
	public Boolean getDefaultCryptFilterHasTypeDictionary() {
		COSObject object = getDefaultCryptFilterValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Boolean getcontainsStdCF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("StdCF"));
	}

}
