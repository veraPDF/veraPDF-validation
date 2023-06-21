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

public class GFAUserProperty extends GFAObject implements AUserProperty {

	public GFAUserProperty(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AUserProperty");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "V":
				return getV();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<org.verapdf.model.baselayer.Object> getV() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getV1_6();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getV1_6() {
		COSObject object = getVValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<A_UniversalArray> list = new ArrayList<>(1);
			list.add(new GFA_UniversalArray((COSArray)object.getDirectBase(), this.baseObject, "V"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<A_UniversalDictionary> list = new ArrayList<>(1);
			list.add(new GFA_UniversalDictionary((COSDictionary)object.getDirectBase(), this.baseObject, "V"));
			return Collections.unmodifiableList(list);
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "V"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
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
	public Boolean getFHasTypeStringText() {
		COSObject object = getFValue();
		return getHasTypeStringText(object);
	}

	@Override
	public Boolean getcontainsH() {
		return this.baseObject.knownKey(ASAtom.getASAtom("H"));
	}

	public COSObject getHDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSBoolean.construct(false);
		}
		return null;
	}

	public COSObject getHValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("H"));
		if (object == null || object.empty()) {
			object = getHDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getHHasTypeBoolean() {
		COSObject object = getHValue();
		return getHasTypeBoolean(object);
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
	public Boolean getNHasTypeStringText() {
		COSObject object = getNValue();
		return getHasTypeStringText(object);
	}

	@Override
	public Boolean getcontainsV() {
		return this.baseObject.knownKey(ASAtom.getASAtom("V"));
	}

	public COSObject getVValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("V"));
		return object;
	}

	@Override
	public Boolean getisVIndirect() {
		COSObject object = getVValue();
		return getisIndirect(object);
	}

	@Override
	public Boolean getVHasTypeArray() {
		COSObject object = getVValue();
		return getHasTypeArray(object);
	}

	@Override
	public Boolean getVHasTypeBoolean() {
		COSObject object = getVValue();
		return getHasTypeBoolean(object);
	}

	@Override
	public Boolean getVHasTypeDictionary() {
		COSObject object = getVValue();
		return getHasTypeDictionary(object);
	}

	@Override
	public Boolean getVHasTypeName() {
		COSObject object = getVValue();
		return getHasTypeName(object);
	}

	@Override
	public Boolean getVHasTypeNull() {
		COSObject object = getVValue();
		return getHasTypeNull(object);
	}

	@Override
	public Boolean getVHasTypeNumber() {
		COSObject object = getVValue();
		return getHasTypeNumber(object);
	}

	@Override
	public Boolean getVHasTypeStream() {
		COSObject object = getVValue();
		return getHasTypeStream(object);
	}

	@Override
	public Boolean getVHasTypeString() {
		COSObject object = getVValue();
		return getHasTypeString(object);
	}

	@Override
	public Boolean gettrailerCatalogMarkInfoUserPropertiesBooleanValue() {
		COSObject trailer = StaticResources.getDocument().getDocument().getTrailer().getObject();
		if (trailer == null || !trailer.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Root = trailer.getKey(ASAtom.getASAtom("Root"));
		if (Root == null || !Root.getType().isDictionaryBased()) {
			return null;
		}
		COSObject MarkInfo = Root.getKey(ASAtom.getASAtom("MarkInfo"));
		if (MarkInfo == null || !MarkInfo.getType().isDictionaryBased()) {
			return null;
		}
		COSObject UserProperties = MarkInfo.getKey(ASAtom.getASAtom("UserProperties"));
		return new GFAMarkInfo(MarkInfo.getDirectBase(), null, null).getUserPropertiesBooleanValue();
	}

}
