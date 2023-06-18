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

public class GFATarget extends GFAObject implements ATarget {

	public GFATarget(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ATarget");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "T":
				return getT();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ATarget> getT() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getT1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<ATarget> getT1_6() {
		COSObject object = getTValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ATarget> list = new ArrayList<>(1);
			list.add(new GFATarget((COSDictionary)object.getDirectBase(), this.baseObject, "T"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsA() {
		return this.baseObject.knownKey(ASAtom.getASAtom("A"));
	}

	public COSObject getAValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A"));
		return object;
	}

	@Override
	public Boolean getAHasTypeInteger() {
		COSObject object = getAValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getAHasTypeStringText() {
		COSObject object = getAValue();
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Long getAIntegerValue() {
		COSObject object = getAValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public String getAStringTextValue() {
		COSObject object = getAValue();
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsN() {
		return this.baseObject.knownKey(ASAtom.getASAtom("N"));
	}

	public COSObject getNValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("N"));
		return object;
	}

	@Override
	public Boolean getNHasTypeStringByte() {
		COSObject object = getNValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getnameTreetrailerCatalogNamesEmbeddedFilesContainsNString() {
		COSObject object = getNValue();
		if (object == null || object.getType() != COSObjType.COS_STRING) {
			return false;
		}
		COSObject trailer = StaticResources.getDocument().getDocument().getTrailer().getObject();
		if (trailer == null || !trailer.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Root = trailer.getKey(ASAtom.getASAtom("Root"));
		if (Root == null || !Root.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Names = Root.getKey(ASAtom.getASAtom("Names"));
		if (Names == null || !Names.getType().isDictionaryBased()) {
			return null;
		}
		COSObject EmbeddedFiles = Names.getKey(ASAtom.getASAtom("EmbeddedFiles"));
		if (EmbeddedFiles == null || EmbeddedFiles.getType() != COSObjType.COS_DICT) {
			return false;
		}
		PDNameTreeNode nameTreeNode = PDNameTreeNode.create(EmbeddedFiles);
		return nameTreeNode.getObject(object.getString()) != null;
	}

	@Override
	public Boolean getcontainsP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("P"));
	}

	public COSObject getPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		return object;
	}

	@Override
	public Boolean getPHasTypeInteger() {
		COSObject object = getPValue();
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getPHasTypeStringByte() {
		COSObject object = getPValue();
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Long getPIntegerValue() {
		COSObject object = getPValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public String getPStringByteValue() {
		COSObject object = getPValue();
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getnameTreetrailerCatalogNamesDestsContainsPString() {
		COSObject object = getPValue();
		if (object == null || object.getType() != COSObjType.COS_STRING) {
			return false;
		}
		COSObject trailer = StaticResources.getDocument().getDocument().getTrailer().getObject();
		if (trailer == null || !trailer.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Root = trailer.getKey(ASAtom.getASAtom("Root"));
		if (Root == null || !Root.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Names = Root.getKey(ASAtom.getASAtom("Names"));
		if (Names == null || !Names.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Dests = Names.getKey(ASAtom.getASAtom("Dests"));
		if (Dests == null || Dests.getType() != COSObjType.COS_DICT) {
			return false;
		}
		PDNameTreeNode nameTreeNode = PDNameTreeNode.create(Dests);
		return nameTreeNode.getObject(object.getString()) != null;
	}

	@Override
	public Boolean getcontainsR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("R"));
	}

	public COSObject getRValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		return object;
	}

	@Override
	public Boolean getRHasTypeName() {
		COSObject object = getRValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getRNameValue() {
		COSObject object = getRValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("T"));
	}

	public COSObject getTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("T"));
		return object;
	}

	@Override
	public Boolean getTHasTypeDictionary() {
		COSObject object = getTValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Long getpagePAnnotsArraySize() {
		COSObject object = getPValue();
		COSObject page = getPageObject(object);
		if (page == null || !page.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Annots = page.getKey(ASAtom.getASAtom("Annots"));
		if (Annots != null && Annots.getType() == COSObjType.COS_ARRAY) {
			return (long) Annots.size();
		}
		return null;
	}

	@Override
	public Boolean getpagePAnnotsHasTypeArray() {
		COSObject object = getPValue();
		COSObject page = getPageObject(object);
		if (page == null || !page.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Annots = page.getKey(ASAtom.getASAtom("Annots"));
		return Annots != null && Annots.getType() == COSObjType.COS_ARRAY;
	}

}
