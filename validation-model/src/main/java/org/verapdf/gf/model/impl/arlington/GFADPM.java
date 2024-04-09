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

public class GFADPM extends GFAObject implements ADPM {

	public GFADPM(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ADPM");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Entries":
				return getEntries();
			case "GTS_Managed":
				return getGTS_Managed();
			case "GTS_Suspect":
				return getGTS_Suspect();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ADPMEntry> getEntries() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntries1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADPMEntry> getEntries1_6() {
		List<ADPMEntry> list = new LinkedList<>();
		for (ASAtom key : baseObject.getKeySet()) {
			if ("GTS_Managed".equals(key.getValue()) || "GTS_Suspect".equals(key.getValue())) {
				continue;
			}
			COSObject object = this.baseObject.getKey(key);
			list.add(new GFADPMEntry(object != null ? object.get() : null, this.baseObject, this.parentObject, keyName, key.getValue()));
		}
		return Collections.unmodifiableList(list);
	}

	private List<A_UniversalDictionary> getGTS_Managed() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getGTS_Managed1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<A_UniversalDictionary> getGTS_Managed1_6() {
		COSObject object = getGTS_ManagedValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A_UniversalDictionary> list = new ArrayList<>(1);
			list.add(new GFA_UniversalDictionary((COSDictionary)object.getDirectBase(), this.baseObject, "GTS_Managed"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<A_UniversalDictionary> getGTS_Suspect() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getGTS_Suspect1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<A_UniversalDictionary> getGTS_Suspect1_6() {
		COSObject object = getGTS_SuspectValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A_UniversalDictionary> list = new ArrayList<>(1);
			list.add(new GFA_UniversalDictionary((COSDictionary)object.getDirectBase(), this.baseObject, "GTS_Suspect"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsGTS_Managed() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GTS_Managed"));
	}

	public COSObject getGTS_ManagedValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GTS_Managed"));
		return object;
	}

	@Override
	public String getGTS_ManagedType() {
		COSObject GTS_Managed = getGTS_ManagedValue();
		return getObjectType(GTS_Managed);
	}

	@Override
	public Boolean getGTS_ManagedHasTypeDictionary() {
		COSObject GTS_Managed = getGTS_ManagedValue();
		return getHasTypeDictionary(GTS_Managed);
	}

	@Override
	public Boolean getcontainsGTS_Suspect() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GTS_Suspect"));
	}

	public COSObject getGTS_SuspectValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GTS_Suspect"));
		return object;
	}

	@Override
	public String getGTS_SuspectType() {
		COSObject GTS_Suspect = getGTS_SuspectValue();
		return getObjectType(GTS_Suspect);
	}

	@Override
	public Boolean getGTS_SuspectHasTypeDictionary() {
		COSObject GTS_Suspect = getGTS_SuspectValue();
		return getHasTypeDictionary(GTS_Suspect);
	}

}
