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

public class GFADocInfo extends GFAObject implements ADocInfo {

	public GFADocInfo(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ADocInfo");
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

	private List<ADocInfoEntry> getEntries() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_1:
			case ARLINGTON1_2:
				return getEntries1_1();
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEntries1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<ADocInfoEntry> getEntries1_1() {
		List<ADocInfoEntry> list = new LinkedList<>();
		for (ASAtom key : baseObject.getKeySet()) {
			if ("Author".equals(key.getValue()) || "CreationDate".equals(key.getValue()) || "Creator".equals(key.getValue()) || "Keywords".equals(key.getValue()) || "ModDate".equals(key.getValue()) || "Producer".equals(key.getValue()) || "Subject".equals(key.getValue()) || "Title".equals(key.getValue())) {
				continue;
			}
			COSObject object = this.baseObject.getKey(key);
			list.add(new GFADocInfoEntry(object != null ? object.get() : null, this.baseObject, this.parentObject, keyName, key.getValue()));
		}
		return Collections.unmodifiableList(list);
	}

	private List<ADocInfoEntry> getEntries1_3() {
		List<ADocInfoEntry> list = new LinkedList<>();
		for (ASAtom key : baseObject.getKeySet()) {
			if ("Author".equals(key.getValue()) || "CreationDate".equals(key.getValue()) || "Creator".equals(key.getValue()) || "Keywords".equals(key.getValue()) || "ModDate".equals(key.getValue()) || "Producer".equals(key.getValue()) || "Subject".equals(key.getValue()) || "Title".equals(key.getValue()) || "Trapped".equals(key.getValue())) {
				continue;
			}
			COSObject object = this.baseObject.getKey(key);
			list.add(new GFADocInfoEntry(object != null ? object.get() : null, this.baseObject, this.parentObject, keyName, key.getValue()));
		}
		return Collections.unmodifiableList(list);
	}

	@Override
	public Boolean getcontainsAuthor() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Author"));
	}

	@Override
	public Boolean getAuthorHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Author"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsCreationDate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CreationDate"));
	}

	@Override
	public Boolean getCreationDateHasTypeDate() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CreationDate"));
		return object != null && object.getType() == COSObjType.COS_STRING && object.getString().matches(GFAObject.PDF_DATE_FORMAT_REGEX);
	}

	@Override
	public Boolean getcontainsCreator() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Creator"));
	}

	@Override
	public Boolean getCreatorHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Creator"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsKeywords() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Keywords"));
	}

	@Override
	public Boolean getKeywordsHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Keywords"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsModDate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ModDate"));
	}

	@Override
	public Boolean getModDateHasTypeDate() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ModDate"));
		return object != null && object.getType() == COSObjType.COS_STRING && object.getString().matches(GFAObject.PDF_DATE_FORMAT_REGEX);
	}

	@Override
	public Boolean getcontainsProducer() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Producer"));
	}

	@Override
	public Boolean getProducerHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Producer"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsSubject() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subject"));
	}

	@Override
	public Boolean getSubjectHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subject"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsTitle() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Title"));
	}

	@Override
	public Boolean getTitleHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Title"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsTrapped() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Trapped"));
	}

	@Override
	public Boolean getTrappedHasTypeName() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Trapped"));
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTrappedNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Trapped"));
		if (object == null || object.empty()) {
			return getTrappedNameDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public String getTrappedNameDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return "Unknown";
		}
		return null;
	}

}
