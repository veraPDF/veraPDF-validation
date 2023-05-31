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

public class GFAFontType0 extends GFAObject implements AFontType0 {

	public GFAFontType0(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFontType0");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "DescendantFonts":
				return getDescendantFonts();
			case "Encoding":
				return getEncoding();
			case "ToUnicode":
				return getToUnicode();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AArrayOfDescendantFonts> getDescendantFonts() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getDescendantFonts1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfDescendantFonts> getDescendantFonts1_2() {
		COSObject object = getDescendantFontsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfDescendantFonts> list = new ArrayList<>(1);
			list.add(new GFAArrayOfDescendantFonts((COSArray)object.getDirectBase(), this.baseObject, "DescendantFonts"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ACMapStream> getEncoding() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getEncoding1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<ACMapStream> getEncoding1_2() {
		COSObject object = getEncodingValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<ACMapStream> list = new ArrayList<>(1);
			list.add(new GFACMapStream((COSStream)object.getDirectBase(), this.baseObject, "Encoding"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AStream> getToUnicode() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getToUnicode1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getToUnicode1_2() {
		COSObject object = getToUnicodeValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "ToUnicode"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsBaseFont() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BaseFont"));
	}

	public COSObject getBaseFontValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BaseFont"));
		return object;
	}

	@Override
	public Boolean getBaseFontHasTypeName() {
		COSObject object = getBaseFontValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getcontainsDescendantFonts() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DescendantFonts"));
	}

	public COSObject getDescendantFontsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DescendantFonts"));
		return object;
	}

	@Override
	public Boolean getDescendantFontsHasTypeArray() {
		COSObject object = getDescendantFontsValue();
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	@Override
	public Boolean getcontainsEncoding() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Encoding"));
	}

	public COSObject getEncodingValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Encoding"));
		return object;
	}

	@Override
	public Boolean getisEncodingIndirect() {
		COSObject object = getEncodingValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getEncodingHasTypeName() {
		COSObject object = getEncodingValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public Boolean getEncodingHasTypeStream() {
		COSObject object = getEncodingValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public String getEncodingNameValue() {
		COSObject object = getEncodingValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsSubtype() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Subtype"));
	}

	public COSObject getSubtypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Subtype"));
		return object;
	}

	@Override
	public Boolean getSubtypeHasTypeName() {
		COSObject object = getSubtypeValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject object = getSubtypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	@Override
	public Boolean getcontainsToUnicode() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ToUnicode"));
	}

	public COSObject getToUnicodeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ToUnicode"));
		return object;
	}

	@Override
	public Boolean getisToUnicodeIndirect() {
		COSObject object = getToUnicodeValue();
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getToUnicodeHasTypeStream() {
		COSObject object = getToUnicodeValue();
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	public COSObject getTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object;
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject object = getTypeValue();
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	@Override
	public String getTypeNameValue() {
		COSObject object = getTypeValue();
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

}
