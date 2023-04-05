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

public class GFADestOutputProfileRef extends GFAObject implements ADestOutputProfileRef {

	public GFADestOutputProfileRef(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ADestOutputProfileRef");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "URLs":
				return getURLs();
			case "ColorantTable":
				return getColorantTable();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfURLs> getURLs() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getURLs2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfURLs> getURLs2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URLs"));
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

	private List<AArrayOfNamesGeneral> getColorantTable() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getColorantTable2_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfNamesGeneral> getColorantTable2_0() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColorantTable"));
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

	@Override
	public Boolean getcontainsProfileName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ProfileName"));
	}

	@Override
	public Boolean getProfileNameHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ProfileName"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsProfileCS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ProfileCS"));
	}

	@Override
	public Boolean getProfileCSHasTypeString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ProfileCS"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsCheckSum() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CheckSum"));
	}

	@Override
	public Boolean getCheckSumHasTypeString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CheckSum"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getcontainsColorantTable() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ColorantTable"));
	}

	@Override
	public Boolean getColorantTableHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ColorantTable"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsURLs() {
		return this.baseObject.knownKey(ASAtom.getASAtom("URLs"));
	}

	@Override
	public Boolean getURLsHasTypeArray() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URLs"));
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Long getURLsArraySize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URLs"));
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

	@Override
	public Boolean getcontainsICCVersion() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ICCVersion"));
	}

	@Override
	public Boolean getICCVersionHasTypeString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ICCVersion"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

}
