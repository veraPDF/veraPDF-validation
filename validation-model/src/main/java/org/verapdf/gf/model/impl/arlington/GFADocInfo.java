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

public class GFADocInfo extends GFAObject implements ADocInfo {

	public GFADocInfo(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ADocInfo");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Entries":
				return getEntries();
			case "AAPLKeywords":
				return getAAPLKeywords();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ADocInfoEntry> getEntries() {
		switch (StaticContainers.getFlavour()) {
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
			if ("AAPL:Keywords".equals(key.getValue()) || "Author".equals(key.getValue()) || "CreationDate".equals(key.getValue()) || "Creator".equals(key.getValue()) || "GTS_PDFXVersion".equals(key.getValue()) || "Keywords".equals(key.getValue()) || "ModDate".equals(key.getValue()) || "Producer".equals(key.getValue()) || "Subject".equals(key.getValue()) || "Title".equals(key.getValue())) {
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
			if ("AAPL:Keywords".equals(key.getValue()) || "Author".equals(key.getValue()) || "CreationDate".equals(key.getValue()) || "Creator".equals(key.getValue()) || "GTS_PDFXVersion".equals(key.getValue()) || "Keywords".equals(key.getValue()) || "ModDate".equals(key.getValue()) || "Producer".equals(key.getValue()) || "Subject".equals(key.getValue()) || "Title".equals(key.getValue()) || "Trapped".equals(key.getValue())) {
				continue;
			}
			COSObject object = this.baseObject.getKey(key);
			list.add(new GFADocInfoEntry(object != null ? object.get() : null, this.baseObject, this.parentObject, keyName, key.getValue()));
		}
		return Collections.unmodifiableList(list);
	}

	private List<AArrayOfStringsText> getAAPLKeywords() {
		return getAAPLKeywords1_0();
	}

	private List<AArrayOfStringsText> getAAPLKeywords1_0() {
		COSObject object = getAAPLKeywordsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfStringsText> list = new ArrayList<>(1);
			list.add(new GFAArrayOfStringsText((COSArray)object.getDirectBase(), this.baseObject, "AAPL:Keywords"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAAPLKeywords() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AAPL:Keywords"));
	}

	public COSObject getAAPLKeywordsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AAPL:Keywords"));
		return object;
	}

	@Override
	public String getAAPLKeywordsType() {
		COSObject AAPLKeywords = getAAPLKeywordsValue();
		return getObjectType(AAPLKeywords);
	}

	@Override
	public Boolean getAAPLKeywordsHasTypeArray() {
		COSObject AAPLKeywords = getAAPLKeywordsValue();
		return getHasTypeArray(AAPLKeywords);
	}

	@Override
	public Boolean getcontainsAuthor() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Author"));
	}

	public COSObject getAuthorValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Author"));
		return object;
	}

	@Override
	public String getAuthorType() {
		COSObject Author = getAuthorValue();
		return getObjectType(Author);
	}

	@Override
	public Boolean getAuthorHasTypeStringText() {
		COSObject Author = getAuthorValue();
		return getHasTypeStringText(Author);
	}

	@Override
	public Boolean getcontainsCreationDate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CreationDate"));
	}

	public COSObject getCreationDateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CreationDate"));
		return object;
	}

	@Override
	public String getCreationDateType() {
		COSObject CreationDate = getCreationDateValue();
		return getObjectType(CreationDate);
	}

	@Override
	public Boolean getCreationDateHasTypeDate() {
		COSObject CreationDate = getCreationDateValue();
		return getHasTypeDate(CreationDate);
	}

	@Override
	public Boolean getcontainsCreator() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Creator"));
	}

	public COSObject getCreatorValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Creator"));
		return object;
	}

	@Override
	public String getCreatorType() {
		COSObject Creator = getCreatorValue();
		return getObjectType(Creator);
	}

	@Override
	public Boolean getCreatorHasTypeStringText() {
		COSObject Creator = getCreatorValue();
		return getHasTypeStringText(Creator);
	}

	@Override
	public Boolean getcontainsGTS_PDFXVersion() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GTS_PDFXVersion"));
	}

	public COSObject getGTS_PDFXVersionValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GTS_PDFXVersion"));
		return object;
	}

	@Override
	public String getGTS_PDFXVersionType() {
		COSObject GTS_PDFXVersion = getGTS_PDFXVersionValue();
		return getObjectType(GTS_PDFXVersion);
	}

	@Override
	public Boolean getGTS_PDFXVersionHasTypeStringText() {
		COSObject GTS_PDFXVersion = getGTS_PDFXVersionValue();
		return getHasTypeStringText(GTS_PDFXVersion);
	}

	@Override
	public Boolean getcontainsKeywords() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Keywords"));
	}

	public COSObject getKeywordsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Keywords"));
		return object;
	}

	@Override
	public String getKeywordsType() {
		COSObject Keywords = getKeywordsValue();
		return getObjectType(Keywords);
	}

	@Override
	public Boolean getKeywordsHasTypeStringText() {
		COSObject Keywords = getKeywordsValue();
		return getHasTypeStringText(Keywords);
	}

	@Override
	public Boolean getcontainsModDate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ModDate"));
	}

	public COSObject getModDateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ModDate"));
		return object;
	}

	@Override
	public String getModDateType() {
		COSObject ModDate = getModDateValue();
		return getObjectType(ModDate);
	}

	@Override
	public Boolean getModDateHasTypeDate() {
		COSObject ModDate = getModDateValue();
		return getHasTypeDate(ModDate);
	}

	@Override
	public Boolean getcontainsProducer() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Producer"));
	}

	public COSObject getProducerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Producer"));
		return object;
	}

	@Override
	public String getProducerType() {
		COSObject Producer = getProducerValue();
		return getObjectType(Producer);
	}

	@Override
	public Boolean getProducerHasTypeStringText() {
		COSObject Producer = getProducerValue();
		return getHasTypeStringText(Producer);
	}

	@Override
	public Boolean getcontainsSubject() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subject"));
	}

	public COSObject getSubjectValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subject"));
		return object;
	}

	@Override
	public String getSubjectType() {
		COSObject Subject = getSubjectValue();
		return getObjectType(Subject);
	}

	@Override
	public Boolean getSubjectHasTypeStringText() {
		COSObject Subject = getSubjectValue();
		return getHasTypeStringText(Subject);
	}

	@Override
	public Boolean getcontainsTitle() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Title"));
	}

	public COSObject getTitleValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Title"));
		return object;
	}

	@Override
	public String getTitleType() {
		COSObject Title = getTitleValue();
		return getObjectType(Title);
	}

	@Override
	public Boolean getTitleHasTypeStringText() {
		COSObject Title = getTitleValue();
		return getHasTypeStringText(Title);
	}

	@Override
	public Boolean getcontainsTrapped() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Trapped"));
	}

	public COSObject getTrappedDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Unknown");
		}
		return null;
	}

	public COSObject getTrappedValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Trapped"));
		if (object == null || object.empty()) {
			object = getTrappedDefaultValue();
		}
		return object;
	}

	@Override
	public String getTrappedType() {
		COSObject Trapped = getTrappedValue();
		return getObjectType(Trapped);
	}

	@Override
	public Boolean getTrappedHasTypeName() {
		COSObject Trapped = getTrappedValue();
		return getHasTypeName(Trapped);
	}

	@Override
	public String getTrappedNameValue() {
		COSObject Trapped = getTrappedValue();
		return getNameValue(Trapped);
	}

}
