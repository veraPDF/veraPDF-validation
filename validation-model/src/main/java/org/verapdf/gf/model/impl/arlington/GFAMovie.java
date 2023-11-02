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

public class GFAMovie extends GFAObject implements AMovie {

	public GFAMovie(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AMovie");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Aspect":
				return getAspect();
			case "F":
				return getF();
			case "Poster":
				return getPoster();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOf_2Numbers> getAspect() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getAspect1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOf_2Numbers> getAspect1_2() {
		COSObject object = getAspectValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOf_2Numbers> list = new ArrayList<>(1);
			list.add(new GFAArrayOf_2Numbers((COSArray)object.getDirectBase(), this.baseObject, "Aspect"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AFileSpecification> getF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getF1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AFileSpecification> getF1_2() {
		COSObject object = getFValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFileSpecification> list = new ArrayList<>(1);
			list.add(new GFAFileSpecification((COSDictionary)object.getDirectBase(), this.baseObject, "F"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AXObjectImage> getPoster() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getPoster1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AXObjectImage> getPoster1_2() {
		COSObject object = getPosterValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AXObjectImage> list = new ArrayList<>(1);
			list.add(new GFAXObjectImage((COSStream)object.getDirectBase(), this.baseObject, "Poster"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAspect() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Aspect"));
	}

	public COSObject getAspectValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Aspect"));
		return object;
	}

	@Override
	public String getAspectType() {
		COSObject Aspect = getAspectValue();
		return getObjectType(Aspect);
	}

	@Override
	public Boolean getAspectHasTypeArray() {
		COSObject Aspect = getAspectValue();
		return getHasTypeArray(Aspect);
	}

	@Override
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	public COSObject getFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		return object;
	}

	@Override
	public String getFType() {
		COSObject F = getFValue();
		return getObjectType(F);
	}

	@Override
	public Boolean getFHasTypeDictionary() {
		COSObject F = getFValue();
		return getHasTypeDictionary(F);
	}

	@Override
	public Boolean getFHasTypeString() {
		COSObject F = getFValue();
		return getHasTypeString(F);
	}

	@Override
	public Boolean getcontainsPoster() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Poster"));
	}

	public COSObject getPosterDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getPosterValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Poster"));
		if (object == null || object.empty()) {
			object = getPosterDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getisPosterIndirect() {
		COSObject Poster = getPosterValue();
		return getisIndirect(Poster);
	}

	@Override
	public String getPosterType() {
		COSObject Poster = getPosterValue();
		return getObjectType(Poster);
	}

	@Override
	public Boolean getPosterHasTypeBoolean() {
		COSObject Poster = getPosterValue();
		return getHasTypeBoolean(Poster);
	}

	@Override
	public Boolean getPosterHasTypeStream() {
		COSObject Poster = getPosterValue();
		return getHasTypeStream(Poster);
	}

	@Override
	public Boolean getcontainsRotate() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Rotate"));
	}

	public COSObject getRotateDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(0L);
		}
		return null;
	}

	public COSObject getRotateValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Rotate"));
		if (object == null || object.empty()) {
			object = getRotateDefaultValue();
		}
		return object;
	}

	@Override
	public String getRotateType() {
		COSObject Rotate = getRotateValue();
		return getObjectType(Rotate);
	}

	@Override
	public Boolean getRotateHasTypeInteger() {
		COSObject Rotate = getRotateValue();
		return getHasTypeInteger(Rotate);
	}

	@Override
	public Long getRotateIntegerValue() {
		COSObject Rotate = getRotateValue();
		return getIntegerValue(Rotate);
	}

}
