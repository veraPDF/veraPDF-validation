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

public class GFAAlternateImage extends GFAObject implements AAlternateImage {

	public GFAAlternateImage(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AAlternateImage");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Image":
				return getImage();
			case "OC":
				return getOC();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AXObjectImage> getImage() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getImage1_3();
			default:
				return Collections.emptyList();
		}
	}

	private List<AXObjectImage> getImage1_3() {
		COSObject object = getImageValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AXObjectImage> list = new ArrayList<>(1);
			list.add(new GFAXObjectImage((COSStream)object.getDirectBase(), this.baseObject, "Image"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.baselayer.Object> getOC() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getOC1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.baselayer.Object> getOC1_5() {
		COSObject object = getOCValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			org.verapdf.model.baselayer.Object result = getOCDictionary1_5(object.getDirectBase(), "OC");
			List<org.verapdf.model.baselayer.Object> list = new ArrayList<>(1);
			if (result != null) {
				list.add(result);
			}
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private org.verapdf.model.baselayer.Object getOCDictionary1_5(COSBase base, String keyName) {
		COSObject subtype = base.getKey(ASAtom.getASAtom("Type"));
		if (subtype == null) {
			return null;
		}
		String subtypeValue = subtype.getString();
		if (subtypeValue == null) {
			return null;
		}
		switch (subtypeValue) {
			case "OCG":
				return new GFAOptContentGroup(base, this.baseObject, keyName);
			case "OCMD":
				return new GFAOptContentMembership(base, this.baseObject, keyName);
			default:
				return null;
		}
	}

	@Override
	public Boolean getcontainsDefaultForPrinting() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DefaultForPrinting"));
	}

	public COSObject getDefaultForPrintingDefaultValue() {
		switch (StaticContainers.getFlavour()) {
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

	public COSObject getDefaultForPrintingValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DefaultForPrinting"));
		if (object == null || object.empty()) {
			object = getDefaultForPrintingDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getDefaultForPrintingHasTypeBoolean() {
		COSObject object = getDefaultForPrintingValue();
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsImage() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Image"));
	}

	public COSObject getImageValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Image"));
		return object;
	}

	@Override
	public Boolean getisImageIndirect() {
		COSObject object = getImageValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getImageHasTypeStream() {
		COSObject object = getImageValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsOC() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OC"));
	}

	public COSObject getOCValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OC"));
		return object;
	}

	@Override
	public Boolean getOCHasTypeDictionary() {
		COSObject object = getOCValue();
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

}
