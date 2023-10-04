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
		COSObject BaseFont = getBaseFontValue();
		return getHasTypeName(BaseFont);
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
		COSObject DescendantFonts = getDescendantFontsValue();
		return getHasTypeArray(DescendantFonts);
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
		COSObject Encoding = getEncodingValue();
		return getisIndirect(Encoding);
	}

	@Override
	public Boolean getEncodingHasTypeName() {
		COSObject Encoding = getEncodingValue();
		return getHasTypeName(Encoding);
	}

	@Override
	public Boolean getEncodingHasTypeStream() {
		COSObject Encoding = getEncodingValue();
		return getHasTypeStream(Encoding);
	}

	@Override
	public String getEncodingNameValue() {
		COSObject Encoding = getEncodingValue();
		return getNameValue(Encoding);
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
		COSObject Subtype = getSubtypeValue();
		return getHasTypeName(Subtype);
	}

	@Override
	public String getSubtypeNameValue() {
		COSObject Subtype = getSubtypeValue();
		return getNameValue(Subtype);
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
		COSObject ToUnicode = getToUnicodeValue();
		return getisIndirect(ToUnicode);
	}

	@Override
	public Boolean getToUnicodeHasTypeStream() {
		COSObject ToUnicode = getToUnicodeValue();
		return getHasTypeStream(ToUnicode);
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
		COSObject Type = getTypeValue();
		return getHasTypeName(Type);
	}

	@Override
	public String getTypeNameValue() {
		COSObject Type = getTypeValue();
		return getNameValue(Type);
	}

}
