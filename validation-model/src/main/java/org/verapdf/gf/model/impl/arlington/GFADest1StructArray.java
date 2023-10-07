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

public class GFADest1StructArray extends GFAObject implements ADest1StructArray {

	public GFADest1StructArray(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ADest1StructArray");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "entry0":
				return getentry0();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AStructElem> getentry0() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON2_0:
				return getentry02_0();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStructElem> getentry02_0() {
		COSObject object = getentry0Value();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AStructElem> list = new ArrayList<>(1);
			list.add(new GFAStructElem((COSDictionary)object.getDirectBase(), this.baseObject, "0"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	public COSObject getentry0Value() {
		if (this.baseObject.size() <= 0) {
			return null;
		}
		COSObject object = this.baseObject.at(0);
		return object;
	}

	@Override
	public Boolean getentry0HasTypeDictionary() {
		COSObject entry0 = getentry0Value();
		return getHasTypeDictionary(entry0);
	}

	@Override
	public Boolean getentry0HasTypeName() {
		COSObject entry0 = getentry0Value();
		return getHasTypeName(entry0);
	}

	@Override
	public Boolean getentry0HasTypeStringByte() {
		COSObject entry0 = getentry0Value();
		return getHasTypeStringByte(entry0);
	}

	@Override
	public String getentry0NameValue() {
		COSObject entry0 = getentry0Value();
		return getNameValue(entry0);
	}

	@Override
	public Boolean getentry0EntryIsIndexInNameTreetrailerCatalogNamesDests() {
		COSObject entry0 = getentry0Value();
		if (entry0 == null || entry0.getType() != COSObjType.COS_STRING) {
			return false;
		}
		COSObject trailerCatalogNamesDests = gettrailerCatalogNamesDestsValue();
		if (trailerCatalogNamesDests == null || trailerCatalogNamesDests.getType() != COSObjType.COS_DICT) {
			return false;
		}
		PDNameTreeNode nameTreeNode = PDNameTreeNode.create(trailerCatalogNamesDests);
		return nameTreeNode.containsKey(entry0.getString());
	}

	public COSObject getentry1Value() {
		if (this.baseObject.size() <= 1) {
			return null;
		}
		COSObject object = this.baseObject.at(1);
		return object;
	}

	@Override
	public Boolean getentry1HasTypeName() {
		COSObject entry1 = getentry1Value();
		return getHasTypeName(entry1);
	}

	@Override
	public String getentry1NameValue() {
		COSObject entry1 = getentry1Value();
		return getNameValue(entry1);
	}

	public COSObject getentry2Value() {
		if (this.baseObject.size() <= 2) {
			return null;
		}
		COSObject object = this.baseObject.at(2);
		return object;
	}

	@Override
	public Boolean getentry2HasTypeNull() {
		COSObject entry2 = getentry2Value();
		return getHasTypeNull(entry2);
	}

	@Override
	public Boolean getentry2HasTypeNumber() {
		COSObject entry2 = getentry2Value();
		return getHasTypeNumber(entry2);
	}

	public COSObject gettrailerCatalogDestsValue() {
		COSObject trailer = StaticResources.getDocument().getDocument().getTrailer().getObject();
		if (trailer == null || !trailer.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Root = trailer.getKey(ASAtom.getASAtom("Root"));
		if (Root == null || !Root.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Dests = Root.getKey(ASAtom.getASAtom("Dests"));
		return Dests;
	}

	public COSObject gettrailerCatalogNamesDestsValue() {
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
		return Dests;
	}

	@Override
	public String getkeysStringtrailerCatalogDests() {
		COSObject trailerCatalogDests = gettrailerCatalogDestsValue();
		return getkeysString(trailerCatalogDests);
	}

}
