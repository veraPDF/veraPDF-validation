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

public class GFABoxColorInfo extends GFAObject implements ABoxColorInfo {

	public GFABoxColorInfo(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ABoxColorInfo");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "ArtBox":
				return getArtBox();
			case "BleedBox":
				return getBleedBox();
			case "CropBox":
				return getCropBox();
			case "TrimBox":
				return getTrimBox();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ABoxStyle> getArtBox() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getArtBox1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<ABoxStyle> getArtBox1_4() {
		COSObject object = getArtBoxValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ABoxStyle> list = new ArrayList<>(1);
			list.add(new GFABoxStyle((COSDictionary)object.getDirectBase(), this.baseObject, "ArtBox"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ABoxStyle> getBleedBox() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getBleedBox1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<ABoxStyle> getBleedBox1_4() {
		COSObject object = getBleedBoxValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ABoxStyle> list = new ArrayList<>(1);
			list.add(new GFABoxStyle((COSDictionary)object.getDirectBase(), this.baseObject, "BleedBox"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ABoxStyle> getCropBox() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getCropBox1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<ABoxStyle> getCropBox1_4() {
		COSObject object = getCropBoxValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ABoxStyle> list = new ArrayList<>(1);
			list.add(new GFABoxStyle((COSDictionary)object.getDirectBase(), this.baseObject, "CropBox"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ABoxStyle> getTrimBox() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getTrimBox1_4();
			default:
				return Collections.emptyList();
		}
	}

	private List<ABoxStyle> getTrimBox1_4() {
		COSObject object = getTrimBoxValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ABoxStyle> list = new ArrayList<>(1);
			list.add(new GFABoxStyle((COSDictionary)object.getDirectBase(), this.baseObject, "TrimBox"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsArtBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ArtBox"));
	}

	public COSObject getArtBoxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ArtBox"));
		return object;
	}

	@Override
	public String getArtBoxType() {
		COSObject ArtBox = getArtBoxValue();
		return getObjectType(ArtBox);
	}

	@Override
	public Boolean getArtBoxHasTypeDictionary() {
		COSObject ArtBox = getArtBoxValue();
		return getHasTypeDictionary(ArtBox);
	}

	@Override
	public Boolean getcontainsBleedBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BleedBox"));
	}

	public COSObject getBleedBoxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BleedBox"));
		return object;
	}

	@Override
	public String getBleedBoxType() {
		COSObject BleedBox = getBleedBoxValue();
		return getObjectType(BleedBox);
	}

	@Override
	public Boolean getBleedBoxHasTypeDictionary() {
		COSObject BleedBox = getBleedBoxValue();
		return getHasTypeDictionary(BleedBox);
	}

	@Override
	public Boolean getcontainsCropBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CropBox"));
	}

	public COSObject getCropBoxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CropBox"));
		return object;
	}

	@Override
	public String getCropBoxType() {
		COSObject CropBox = getCropBoxValue();
		return getObjectType(CropBox);
	}

	@Override
	public Boolean getCropBoxHasTypeDictionary() {
		COSObject CropBox = getCropBoxValue();
		return getHasTypeDictionary(CropBox);
	}

	@Override
	public Boolean getcontainsTrimBox() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TrimBox"));
	}

	public COSObject getTrimBoxValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TrimBox"));
		return object;
	}

	@Override
	public String getTrimBoxType() {
		COSObject TrimBox = getTrimBoxValue();
		return getObjectType(TrimBox);
	}

	@Override
	public Boolean getTrimBoxHasTypeDictionary() {
		COSObject TrimBox = getTrimBoxValue();
		return getHasTypeDictionary(TrimBox);
	}

}