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

public class GFAAFFileSpecEF extends GFAObject implements AAFFileSpecEF {

	public GFAAFFileSpecEF(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AAFFileSpecEF");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "F":
				return getF();
			case "UF":
				return getUF();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AAFEmbeddedFileStream> getF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				if ((gethasExtensionISO_19005_3() == true)) {
					return getF1_7();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getF1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAFEmbeddedFileStream> getF1_7() {
		COSObject object = getFValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AAFEmbeddedFileStream> list = new ArrayList<>(1);
			list.add(new GFAAFEmbeddedFileStream((COSStream)object.getDirectBase(), this.baseObject, "F"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AAFEmbeddedFileStream> getUF() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
				if ((gethasExtensionISO_19005_3() == true)) {
					return getUF1_7();
				}
				return Collections.emptyList();
			case ARLINGTON2_0:
				return getUF1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AAFEmbeddedFileStream> getUF1_7() {
		COSObject object = getUFValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AAFEmbeddedFileStream> list = new ArrayList<>(1);
			list.add(new GFAAFEmbeddedFileStream((COSStream)object.getDirectBase(), this.baseObject, "UF"));
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
	public Boolean getisFIndirect() {
		COSObject F = getFValue();
		return getisIndirect(F);
	}

	@Override
	public String getFType() {
		COSObject F = getFValue();
		return getObjectType(F);
	}

	@Override
	public Boolean getFHasTypeStream() {
		COSObject F = getFValue();
		return getHasTypeStream(F);
	}

	@Override
	public Boolean getcontainsUF() {
		return this.baseObject.knownKey(ASAtom.getASAtom("UF"));
	}

	public COSObject getUFValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("UF"));
		return object;
	}

	@Override
	public Boolean getisUFIndirect() {
		COSObject UF = getUFValue();
		return getisIndirect(UF);
	}

	@Override
	public String getUFType() {
		COSObject UF = getUFValue();
		return getObjectType(UF);
	}

	@Override
	public Boolean getUFHasTypeStream() {
		COSObject UF = getUFValue();
		return getHasTypeStream(UF);
	}

}
