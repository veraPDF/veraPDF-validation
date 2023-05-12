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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("T"));
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

	@Override
	public Boolean getAHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getAHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Long getAIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A"));
		if (object == null || object.empty()) {
			return getAIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getAIntegerDefaultValue() {
		return null;
	}

	@Override
	public String getAStringTextValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("A"));
		if (object == null || object.empty()) {
			return getAStringTextDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			return object.getString();
		}
		return null;
	}

	public String getAStringTextDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsN() {
		return this.baseObject.knownKey(ASAtom.getASAtom("N"));
	}

	@Override
	public Boolean getNHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("N"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Boolean getnameTreetrailerCatalogNamesEmbeddedFilesContainsNString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("N"));
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

	@Override
	public Boolean getPHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Boolean getPHasTypeStringByte() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	@Override
	public Long getPIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		if (object == null || object.empty()) {
			return getPIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getPIntegerDefaultValue() {
		return null;
	}

	@Override
	public String getPStringByteValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		if (object == null || object.empty()) {
			return getPStringByteDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			return object.getString();
		}
		return null;
	}

	public String getPStringByteDefaultValue() {
		return null;
	}

	@Override
	public Boolean getnameTreetrailerCatalogNamesDestsContainsPString() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
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

	@Override
	public Boolean getRHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getRNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("R"));
		if (object == null || object.empty()) {
			return getRNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getRNameDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("T"));
	}

	@Override
	public Boolean getTHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("T"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	@Override
	public Long getpagePAnnotsArraySize() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		Long pageNumber = null;
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			PDNamesDictionary names = StaticResources.getDocument().getCatalog().getNamesDictionary();
			if (names == null) {
				return null;
			}
			PDNameTreeNode dests = names.getDests();
			if (dests == null) {
				return null;
			}
			object = dests.getObject(object.getString());
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			pageNumber = object.getInteger();
		}
		if (pageNumber == null || pageNumber >= StaticResources.getDocument().getPages().size()) {
			return null;
		}
		COSObject page = StaticResources.getDocument().getPages().get(pageNumber.intValue()).getObject();
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
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("P"));
		Long pageNumber = null;
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			PDNamesDictionary names = StaticResources.getDocument().getCatalog().getNamesDictionary();
			if (names == null) {
				return null;
			}
			PDNameTreeNode dests = names.getDests();
			if (dests == null) {
				return null;
			}
			object = dests.getObject(object.getString());
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			pageNumber = object.getInteger();
		}
		if (pageNumber == null || pageNumber >= StaticResources.getDocument().getPages().size()) {
			return null;
		}
		COSObject page = StaticResources.getDocument().getPages().get(pageNumber.intValue()).getObject();
		if (page == null || !page.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Annots = page.getKey(ASAtom.getASAtom("Annots"));
		return Annots != null && Annots.getType() == COSObjType.COS_ARRAY;
	}

}
