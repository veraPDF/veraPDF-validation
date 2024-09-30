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

public class GFAOptContentGroup extends GFAObject implements AOptContentGroup {

	public GFAOptContentGroup(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AOptContentGroup");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "GTS_Metadata":
				return getGTS_Metadata();
			case "Intent":
				return getIntent();
			case "Usage":
				return getUsage();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AGTS_ProcStepsGroup> getGTS_Metadata() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				if ((gethasExtensionISO_19593() == true)) {
					return getGTS_Metadata1_7();
				}
				return Collections.emptyList();
			default:
				return Collections.emptyList();
		}
	}

	private List<AGTS_ProcStepsGroup> getGTS_Metadata1_7() {
		COSObject object = getGTS_MetadataValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AGTS_ProcStepsGroup> list = new ArrayList<>(1);
			list.add(new GFAGTS_ProcStepsGroup((COSDictionary)object.getDirectBase(), this.baseObject, "GTS_Metadata"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfNamesGeneral> getIntent() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getIntent1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNamesGeneral> getIntent1_5() {
		COSObject object = getIntentValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNamesGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNamesGeneral((COSArray)object.getDirectBase(), this.baseObject, "Intent"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AOptContentUsage> getUsage() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getUsage1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AOptContentUsage> getUsage1_5() {
		COSObject object = getUsageValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AOptContentUsage> list = new ArrayList<>(1);
			list.add(new GFAOptContentUsage((COSDictionary)object.getDirectBase(), this.baseObject, "Usage"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsGTS_Metadata() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GTS_Metadata"));
	}

	public COSObject getGTS_MetadataValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GTS_Metadata"));
		return object;
	}

	@Override
	public String getGTS_MetadataType() {
		COSObject GTS_Metadata = getGTS_MetadataValue();
		return getObjectType(GTS_Metadata);
	}

	@Override
	public Boolean getGTS_MetadataHasTypeDictionary() {
		COSObject GTS_Metadata = getGTS_MetadataValue();
		return getHasTypeDictionary(GTS_Metadata);
	}

	@Override
	public Boolean getcontainsIntent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Intent"));
	}

	public COSObject getIntentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Intent"));
		return object;
	}

	@Override
	public String getIntentType() {
		COSObject Intent = getIntentValue();
		return getObjectType(Intent);
	}

	@Override
	public Boolean getIntentHasTypeArray() {
		COSObject Intent = getIntentValue();
		return getHasTypeArray(Intent);
	}

	@Override
	public Boolean getIntentHasTypeName() {
		COSObject Intent = getIntentValue();
		return getHasTypeName(Intent);
	}

	@Override
	public Boolean getcontainsName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Name"));
	}

	public COSObject getNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Name"));
		return object;
	}

	@Override
	public String getNameType() {
		COSObject Name = getNameValue();
		return getObjectType(Name);
	}

	@Override
	public Boolean getNameHasTypeStringText() {
		COSObject Name = getNameValue();
		return getHasTypeStringText(Name);
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	public COSObject getTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object;
	}

	@Override
	public String getTypeType() {
		COSObject Type = getTypeValue();
		return getObjectType(Type);
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject Type = getTypeValue();
		return getHasTypeName(Type);
	}

	@Override
	public String getTypeNameValue() {
		COSObject Type = getTypeValue();
		return getNameValue(Type);
	}

	@Override
	public Boolean getcontainsUsage() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Usage"));
	}

	public COSObject getUsageValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Usage"));
		return object;
	}

	@Override
	public String getUsageType() {
		COSObject Usage = getUsageValue();
		return getObjectType(Usage);
	}

	@Override
	public Boolean getUsageHasTypeDictionary() {
		COSObject Usage = getUsageValue();
		return getHasTypeDictionary(Usage);
	}

}
