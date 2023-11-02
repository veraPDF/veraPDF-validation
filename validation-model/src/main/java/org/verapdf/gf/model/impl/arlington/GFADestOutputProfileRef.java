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

public class GFADestOutputProfileRef extends GFAObject implements ADestOutputProfileRef {

	public GFADestOutputProfileRef(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ADestOutputProfileRef");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "ColorantTable":
				return getColorantTable();
			case "URLs":
				return getURLs();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfNamesGeneral> getColorantTable() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getColorantTable2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNamesGeneral> getColorantTable2_0() {
		COSObject object = getColorantTableValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfNamesGeneral> list = new ArrayList<>(1);
			list.add(new GFAArrayOfNamesGeneral((COSArray)object.getDirectBase(), this.baseObject, "ColorantTable"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfURLs> getURLs() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getURLs2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfURLs> getURLs2_0() {
		COSObject object = getURLsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfURLs> list = new ArrayList<>(1);
			list.add(new GFAArrayOfURLs((COSArray)object.getDirectBase(), this.baseObject, "URLs"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCheckSum() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CheckSum"));
	}

	public COSObject getCheckSumValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CheckSum"));
		return object;
	}

	@Override
	public String getCheckSumType() {
		COSObject CheckSum = getCheckSumValue();
		return getObjectType(CheckSum);
	}

	@Override
	public Boolean getCheckSumHasTypeString() {
		COSObject CheckSum = getCheckSumValue();
		return getHasTypeString(CheckSum);
	}

	@Override
	public Boolean getcontainsColorantTable() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ColorantTable"));
	}

	public COSObject getColorantTableValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColorantTable"));
		return object;
	}

	@Override
	public String getColorantTableType() {
		COSObject ColorantTable = getColorantTableValue();
		return getObjectType(ColorantTable);
	}

	@Override
	public Boolean getColorantTableHasTypeArray() {
		COSObject ColorantTable = getColorantTableValue();
		return getHasTypeArray(ColorantTable);
	}

	@Override
	public Boolean getcontainsICCVersion() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ICCVersion"));
	}

	public COSObject getICCVersionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ICCVersion"));
		return object;
	}

	@Override
	public String getICCVersionType() {
		COSObject ICCVersion = getICCVersionValue();
		return getObjectType(ICCVersion);
	}

	@Override
	public Boolean getICCVersionHasTypeString() {
		COSObject ICCVersion = getICCVersionValue();
		return getHasTypeString(ICCVersion);
	}

	@Override
	public Boolean getcontainsProfileCS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ProfileCS"));
	}

	public COSObject getProfileCSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ProfileCS"));
		return object;
	}

	@Override
	public String getProfileCSType() {
		COSObject ProfileCS = getProfileCSValue();
		return getObjectType(ProfileCS);
	}

	@Override
	public Boolean getProfileCSHasTypeString() {
		COSObject ProfileCS = getProfileCSValue();
		return getHasTypeString(ProfileCS);
	}

	@Override
	public Boolean getcontainsProfileName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ProfileName"));
	}

	public COSObject getProfileNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ProfileName"));
		return object;
	}

	@Override
	public String getProfileNameType() {
		COSObject ProfileName = getProfileNameValue();
		return getObjectType(ProfileName);
	}

	@Override
	public Boolean getProfileNameHasTypeStringText() {
		COSObject ProfileName = getProfileNameValue();
		return getHasTypeStringText(ProfileName);
	}

	@Override
	public Boolean getcontainsURLs() {
		return this.baseObject.knownKey(ASAtom.getASAtom("URLs"));
	}

	public COSObject getURLsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URLs"));
		return object;
	}

	@Override
	public String getURLsType() {
		COSObject URLs = getURLsValue();
		return getObjectType(URLs);
	}

	@Override
	public Boolean getURLsHasTypeArray() {
		COSObject URLs = getURLsValue();
		return getHasTypeArray(URLs);
	}

	@Override
	public Long getURLsArraySize() {
		COSObject URLs = getURLsValue();
		return getArraySize(URLs);
	}

}
