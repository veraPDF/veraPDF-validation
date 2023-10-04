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
		COSObject A = getAValue();
		return getHasTypeInteger(A);
	}

	@Override
	public Boolean getAHasTypeStringText() {
		COSObject A = getAValue();
		return getHasTypeStringText(A);
	}

	@Override
	public Long getAIntegerValue() {
		COSObject A = getAValue();
		return getIntegerValue(A);
	}

	@Override
	public String getAStringTextValue() {
		COSObject A = getAValue();
		return getStringTextValue(A);
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
		COSObject N = getNValue();
		return getHasTypeStringByte(N);
	}

	@Override
	public Boolean getnameTreetrailerCatalogNamesEmbeddedFilesContainsNString() {
		COSObject N = getNValue();
		if (N == null || N.getType() != COSObjType.COS_STRING) {
			return false;
		}
		COSObject trailerCatalogNamesEmbeddedFiles = gettrailerCatalogNamesEmbeddedFilesValue();
		if (trailerCatalogNamesEmbeddedFiles == null || trailerCatalogNamesEmbeddedFiles.getType() != COSObjType.COS_DICT) {
			return false;
		}
		PDNameTreeNode nameTreeNode = PDNameTreeNode.create(trailerCatalogNamesEmbeddedFiles);
		return nameTreeNode.getObject(N.getString()) != null;
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
		COSObject P = getPValue();
		return getHasTypeInteger(P);
	}

	@Override
	public Boolean getPHasTypeStringByte() {
		COSObject P = getPValue();
		return getHasTypeStringByte(P);
	}

	@Override
	public Long getPIntegerValue() {
		COSObject P = getPValue();
		return getIntegerValue(P);
	}

	@Override
	public Boolean getnameTreetrailerCatalogNamesDestsContainsPString() {
		COSObject P = getPValue();
		if (P == null || P.getType() != COSObjType.COS_STRING) {
			return false;
		}
		COSObject trailerCatalogNamesDests = gettrailerCatalogNamesDestsValue();
		if (trailerCatalogNamesDests == null || trailerCatalogNamesDests.getType() != COSObjType.COS_DICT) {
			return false;
		}
		PDNameTreeNode nameTreeNode = PDNameTreeNode.create(trailerCatalogNamesDests);
		return nameTreeNode.getObject(P.getString()) != null;
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
		COSObject R = getRValue();
		return getHasTypeName(R);
	}

	@Override
	public String getRNameValue() {
		COSObject R = getRValue();
		return getNameValue(R);
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
		COSObject T = getTValue();
		return getHasTypeDictionary(T);
	}

	public COSObject getpagePAnnotsValue() {
		COSObject P = getPValue();
		COSObject page = getPageObject(P);
		if (page == null || !page.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Annots = page.getKey(ASAtom.getASAtom("Annots"));
		return Annots;
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

	public COSObject gettrailerCatalogNamesEmbeddedFilesValue() {
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
		return EmbeddedFiles;
	}

	@Override
	public Long getpagePAnnotsArraySize() {
		COSObject pagePAnnots = getpagePAnnotsValue();
		return getArraySize(pagePAnnots);
	}

	@Override
	public Boolean getpagePAnnotsHasTypeArray() {
		COSObject pagePAnnots = getpagePAnnotsValue();
		return getHasTypeArray(pagePAnnots);
	}

}
