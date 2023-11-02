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

public class GFAWebCaptureCommand extends GFAObject implements AWebCaptureCommand {

	public GFAWebCaptureCommand(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AWebCaptureCommand");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "P":
				return getP();
			case "S":
				return getS();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AStream> getP() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getP1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getP1_3() {
		COSObject object = getPValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "P"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AWebCaptureCommandSettings> getS() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getS1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AWebCaptureCommandSettings> getS1_3() {
		COSObject object = getSValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AWebCaptureCommandSettings> list = new ArrayList<>(1);
			list.add(new GFAWebCaptureCommandSettings((COSDictionary)object.getDirectBase(), this.baseObject, "S"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsCT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("CT"));
	}

	public COSObject getCTDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSString.construct("application/x-www-form-urlencoded".getBytes());
		}
		return null;
	}

	public COSObject getCTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("CT"));
		if (object == null || object.empty()) {
			object = getCTDefaultValue();
		}
		return object;
	}

	@Override
	public String getCTType() {
		COSObject CT = getCTValue();
		return getObjectType(CT);
	}

	@Override
	public Boolean getCTHasTypeStringAscii() {
		COSObject CT = getCTValue();
		return getHasTypeStringAscii(CT);
	}

	@Override
	public Boolean getcontainsF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("F"));
	}

	public COSObject getFDefaultValue() {
		switch (StaticContainers.getFlavour()) {
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

	public COSObject getFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("F"));
		if (object == null || object.empty()) {
			object = getFDefaultValue();
		}
		return object;
	}

	@Override
	public String getFType() {
		COSObject F = getFValue();
		return getObjectType(F);
	}

	@Override
	public Boolean getFHasTypeBitmask() {
		COSObject F = getFValue();
		return getHasTypeBitmask(F);
	}

	@Override
	public Long getFBitmaskValue() {
		COSObject F = getFValue();
		return getBitmaskValue(F);
	}

	@Override
	public Boolean getcontainsH() {
		return this.baseObject.knownKey(ASAtom.getASAtom("H"));
	}

	public COSObject getHValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("H"));
		return object;
	}

	@Override
	public String getHType() {
		COSObject H = getHValue();
		return getObjectType(H);
	}

	@Override
	public Boolean getHHasTypeString() {
		COSObject H = getHValue();
		return getHasTypeString(H);
	}

	@Override
	public Boolean getcontainsL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("L"));
	}

	public COSObject getLDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSInteger.construct(1L);
		}
		return null;
	}

	public COSObject getLValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("L"));
		if (object == null || object.empty()) {
			object = getLDefaultValue();
		}
		return object;
	}

	@Override
	public String getLType() {
		COSObject L = getLValue();
		return getObjectType(L);
	}

	@Override
	public Boolean getLHasTypeInteger() {
		COSObject L = getLValue();
		return getHasTypeInteger(L);
	}

	@Override
	public Long getLIntegerValue() {
		COSObject L = getLValue();
		return getIntegerValue(L);
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
	public Boolean getisPIndirect() {
		COSObject P = getPValue();
		return getisIndirect(P);
	}

	@Override
	public String getPType() {
		COSObject P = getPValue();
		return getObjectType(P);
	}

	@Override
	public Boolean getPHasTypeStream() {
		COSObject P = getPValue();
		return getHasTypeStream(P);
	}

	@Override
	public Boolean getPHasTypeString() {
		COSObject P = getPValue();
		return getHasTypeString(P);
	}

	@Override
	public Boolean getcontainsS() {
		return this.baseObject.knownKey(ASAtom.getASAtom("S"));
	}

	public COSObject getSValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("S"));
		return object;
	}

	@Override
	public String getSType() {
		COSObject S = getSValue();
		return getObjectType(S);
	}

	@Override
	public Boolean getSHasTypeDictionary() {
		COSObject S = getSValue();
		return getHasTypeDictionary(S);
	}

	@Override
	public Boolean getcontainsURL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("URL"));
	}

	public COSObject getURLValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URL"));
		return object;
	}

	@Override
	public String getURLType() {
		COSObject URL = getURLValue();
		return getObjectType(URL);
	}

	@Override
	public Boolean getURLHasTypeStringAscii() {
		COSObject URL = getURLValue();
		return getHasTypeStringAscii(URL);
	}

}
