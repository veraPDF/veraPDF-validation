package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.extensions.ExtensionObjectType;
import org.verapdf.model.GenericModelObject;
import org.verapdf.pd.PDDocument;
import org.verapdf.pd.PDCatalog;
import org.verapdf.pd.PDNamesDictionary;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.PDNameTreeNode;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;

public class GFAObject extends GenericModelObject implements AObject {

	private static final List<String> standardFonts = new LinkedList<>();
	private static final ThreadLocal<Set<COSKey>> keysSet = new ThreadLocal<>();
	private static final ThreadLocal<Set<COSKey>> afKeysSet = new ThreadLocal<>();
	protected static final String PDF_DATE_FORMAT_REGEX = "(D:)?(\\d\\d){2,7}(([Z+-]\\d\\d'(\\d\\d'?)?)?|Z)";
	protected final COSBase baseObject;
	protected COSBase parentObject;
	protected String keyName;

	public GFAObject(COSBase baseObject, COSBase parentObject, String objectType) {
		super(objectType);
		this.baseObject = baseObject;
		this.parentObject = parentObject;
		if (baseObject != null && baseObject.getType() == COSObjType.COS_DICT && baseObject.knownKey(ASAtom.AF)) {
			processAF(baseObject);
		}
	}

	public GFAObject(COSBase baseObject, COSBase parentObject, String keyName, String objectType) {
		this(baseObject, parentObject, objectType);
		this.keyName = keyName;
	}

	@Override
	public String getID() {
		COSKey key = baseObject != null ? baseObject.getObjectKey() : null;
		return key != null ? (getObjectType() + " " + key.toString()) : null;
	}

	@Override
	public String getExtraContext() {
		return keyName == null || keyName.isEmpty() ? null : keyName;
	}

	@Override
	public Long getsize() {
		return (long)baseObject.size();
	}

	@Override
	public String getkeyName() {
		return this.keyName;
	}

	@Override
	public String getkeysString() {
		return getkeysString(new COSObject(this.baseObject));
	}

	@Override
	public Long getnumberOfPages() {
		return (long) StaticResources.getDocument().getPages().size();
	}

	@Override
	public Long getfileSize() {
		return StaticResources.getDocument().getDocument().getFileSize();
	}

	@Override
	public Boolean getisPDFTagged() {
		PDDocument document = StaticResources.getDocument();
		PDCatalog catalog = document.getCatalog();
		if (catalog == null) {
			return false;
		}
		COSObject markInfoObject = catalog.getKey(ASAtom.MARK_INFO);
		if (markInfoObject == null || markInfoObject.empty()) {
			return false;
		}
		COSBase markInfo = markInfoObject.getDirectBase();
		if (markInfo.getType() == COSObjType.COS_DICT) {
			return Objects.equals(markInfo.getBooleanKey(ASAtom.MARKED), true);
		}
		return false;
	}

	public String getObjectType(COSObject object) {
		if (object.getType() == COSObjType.COS_ARRAY) {
			return "Array";
		}
		if (object.getType() == COSObjType.COS_BOOLEAN) {
			return "Boolean";
		}
		if (object.getType() == COSObjType.COS_DICT) {
			return "Dictionary";
		}
		if (object.getType() == COSObjType.COS_INTEGER) {
			return "Integer";
		}
		if (object.getType() == COSObjType.COS_NAME) {
			return "Name";
		}
		if (object.getType() == COSObjType.COS_NULL) {
			return "Null";
		}
		if (object.getType() == COSObjType.COS_REAL) {
			return "Number";
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			return "Stream";
		}
		if (object.getType() == COSObjType.COS_STRING) {
			return "String";
		}
		return null;
	}

	@Override
	public Boolean getnotStandard14Font() {
		COSObject type = baseObject.getKey(ASAtom.TYPE);
		if (type == null || type.getType() != COSObjType.COS_NAME || type.getName() != ASAtom.FONT) {
			return false;
		}
		COSObject subtype = baseObject.getKey(ASAtom.SUBTYPE);
		if (subtype == null || subtype.getType() != COSObjType.COS_NAME || subtype.getName() != ASAtom.TYPE1) {
			return false;
		}
		COSObject baseFont = baseObject.getKey(ASAtom.BASE_FONT);
		if (baseFont == null || baseFont.getType() != COSObjType.COS_NAME) {
			return true;
		}
		return !standardFonts.contains(baseFont.getString());
	}

	public static Double getRectHeight(COSObject object) {
		if (object == null || object.getType() != COSObjType.COS_ARRAY || object.size() != 4) {
			return null;
		}
		COSObject bottom = object.at(1);
		COSObject top = object.at(3);
		if (bottom == null || (bottom.getType() != COSObjType.COS_INTEGER && bottom.getType() != COSObjType.COS_REAL)) {
			return null;
		}
		if (top == null || (top.getType() != COSObjType.COS_INTEGER && top.getType() != COSObjType.COS_REAL)) {
			return null;
		}
		return top.getReal() - bottom.getReal();
	}

	public static Double getRectWidth(COSObject object) {
		if (object == null || object.getType() != COSObjType.COS_ARRAY || object.size() != 4) {
			return null;
		}
		COSObject left = object.at(0);
		COSObject right = object.at(2);
		if (left == null || (left.getType() != COSObjType.COS_INTEGER && left.getType() != COSObjType.COS_REAL)) {
			return null;
		}
		if (right == null || (right.getType() != COSObjType.COS_INTEGER && right.getType() != COSObjType.COS_REAL)) {
			return null;
		}
		return right.getReal() - left.getReal();
	}

	public static Boolean getisIndirect(COSObject object) {
		return object != null && object.get() != null && object.get().isIndirect();
	}

	public static Boolean getimageIsStructContentItem(COSObject object) {
		return object.isIndirect() && GFAObject.getKeysSet().contains(object.getKey());
	}

	public static Long getArraySize(COSObject object) {
		if (object != null && object.getType() == COSObjType.COS_ARRAY) {
			return (long) object.size();
		}
		return null;
	}

	public static Boolean getisArraySortAscending(COSObject object, int number) {
		if (object == null || object.getType() != COSObjType.COS_ARRAY) {
			return false;
		}
		Long previousNumber = null;
		for (int i = 0; i < object.size(); i += number) {
			COSObject elem = object.at(i);
			if (elem == null || elem.getType() != COSObjType.COS_INTEGER) {
				return false;
			}
			if (previousNumber != null && previousNumber > elem.getInteger()) {
				return false;
			}
			previousNumber = elem.getInteger();
		}
		return true;
	}

	public static String getkeysString(COSObject object) {
		Set<ASAtom> set = object.getKeySet();
		return set == null ? "" : set.stream()
				.map(ASAtom::getValue)
				.collect(Collectors.joining("&"));
	}

	public static String getEntriesString(COSObject object) {
		if (object == null) {
			return null;
		}
		if (object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		if (object.getType() != COSObjType.COS_ARRAY) {
			return null;
		}
		List<String> names = new LinkedList<>();
		for (COSObject elem : (COSArray)object.getDirectBase()) {
			if (elem.getType() == COSObjType.COS_NAME) {
				names.add(elem.getString());
			}
		}
		return String.join("&", names);
	}

	@Override
	public Boolean getisEncryptedWrapper() {
		PDDocument document = StaticResources.getDocument();
		if (document == null) {
			return false;
		}
		PDCatalog catalog = document.getCatalog();
		if (catalog == null) {
			return false;
		}
		PDNamesDictionary names = catalog.getNamesDictionary();
		if (names == null) {
			return false;
		}
		PDNameTreeNode embeddedFiles = names.getEmbeddedFiles();
		if (embeddedFiles == null) {
			return false;
		}
		for (COSObject embeddedFile : embeddedFiles) {
			COSObject relationship = embeddedFile.getKey(ASAtom.AF_RELATIONSHIP);
			if (relationship != null && relationship.getType() == COSObjType.COS_NAME &&
					relationship.getName() == ASAtom.getASAtom("EncryptedPayload")) {
				return true;
			}
		}
		return false;
	}

	public static Boolean hasCycle(COSObject object, ASAtom entryName) {
		if (object == null) {
			return false;
		}
		Set<COSKey> visitedKeys = new HashSet<>();
		while (!object.empty() && object.knownKey(entryName)) {
			if (object.getKey() != null) {
				if (visitedKeys.contains(object.getKey())) {
					return true;
				}
				visitedKeys.add(object.getKey());
			}
			object = object.getKey(entryName);
		}
		return false;
	}

	public COSObject getInheritableValue(ASAtom key) {
		COSObject keyObject = null;
		COSObject currentObject = this.baseObject.getKey(ASAtom.getASAtom("Parent"));
		Set<COSKey> visitedKeys = new HashSet<>();
		while ((keyObject == null || keyObject.empty()) && (currentObject != null && !currentObject.empty())) {
			keyObject = currentObject.getKey(key);
			if (currentObject.getKey() != null) {
				if (visitedKeys.contains(currentObject.getKey())) {
					break;
				}
				visitedKeys.add(currentObject.getKey());
			}
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		return keyObject;
	}

	protected static COSObject getPageObject(COSObject object) {
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			PDNamesDictionary names = StaticResources.getDocument().getCatalog().getNamesDictionary();
			if (names == null) {
				return null;
			}
			PDNameTreeNode dests = names.getDests();
			if (dests == null) {
				return null;
			}
			object = dests.getObject(object.getString());
		}
		Long pageNumber = null;
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			pageNumber = object.getInteger();
		}
		if (pageNumber == null || pageNumber >= StaticResources.getDocument().getPages().size()) {
			return null;
		}
		return StaticResources.getDocument().getPages().get(pageNumber.intValue()).getObject();
	}

	public Boolean isContainsInheritableValue(ASAtom key) {
		COSObject currentObject = new COSObject(this.baseObject);
		Set<COSKey> visitedKeys = new HashSet<>();
		while (currentObject != null && !currentObject.empty() && !currentObject.knownKey(key)) {
			if (currentObject.getKey() != null) {
				if (visitedKeys.contains(currentObject.getKey())) {
					break;
				}
				visitedKeys.add(currentObject.getKey());
			}
			currentObject = currentObject.getKey(ASAtom.getASAtom("Parent"));
		}
		return currentObject != null && !currentObject.empty() && currentObject.knownKey(key);
	}

	public static void processAF(COSBase object) {
		COSObject AF = object.getKey(ASAtom.getASAtom("AF"));
		if (AF == null) {
			return;
		}
		COSObject EF = AF.getKey(ASAtom.getASAtom("EF"));
		if (EF != null) {
			COSObject F = EF.getKey(ASAtom.getASAtom("F"));
			if (F != null) {
				GFAObject.getAFKeysSet().add(F.getObjectKey());
			}
			COSObject UF = EF.getKey(ASAtom.getASAtom("UF"));
			if (UF != null) {
				GFAObject.getAFKeysSet().add(UF.getObjectKey());
			}
		}
		COSObject RF = AF.getKey(ASAtom.getASAtom("RF"));
		if (RF != null) {
			COSObject F = RF.getKey(ASAtom.getASAtom("F"));
			if (F != null && F.getType() == COSObjType.COS_ARRAY) {
				for (int i = 1; i < F.size(); i += 2) {
					COSObject obj = F.at(i);
					if (obj != null) {
						GFAObject.getAFKeysSet().add(obj.getObjectKey());
					}
				}
			}
			COSObject UF = RF.getKey(ASAtom.getASAtom("UF"));
			if (UF != null && UF.getType() == COSObjType.COS_ARRAY) {
				for (int i = 1; i < UF.size(); i += 2) {
					COSObject obj = UF.at(i);
					if (obj != null) {
						GFAObject.getAFKeysSet().add(obj.getObjectKey());
					}
				}
			}
		}
	}

	@Override
	public Boolean getisAssociatedFile() {
		if (baseObject.getObjectKey() != null) {
			return GFAObject.getAFKeysSet().contains(baseObject.getObjectKey());
		}
		return false;
	}

	@Override
	public Boolean gethasExtensionAAPL() {
		return StaticContainers.getEnabledExtensions().contains(ExtensionObjectType.AAPL);
	}

	@Override
	public Boolean gethasExtensionADBE_Extn3() {
		return StaticContainers.getEnabledExtensions().contains(ExtensionObjectType.ADBE_Extn3);
	}

	@Override
	public Boolean gethasExtensionETSI_PAdES() {
		return StaticContainers.getEnabledExtensions().contains(ExtensionObjectType.ETSI_PAdES);
	}

	@Override
	public Boolean gethasExtensionISO_19005_3() {
		return StaticContainers.getEnabledExtensions().contains(ExtensionObjectType.ISO_19005_3);
	}

	@Override
	public Boolean gethasExtensionISO_19593() {
		return StaticContainers.getEnabledExtensions().contains(ExtensionObjectType.ISO_19593);
	}

	@Override
	public Boolean gethasExtensionISO_21812() {
		return StaticContainers.getEnabledExtensions().contains(ExtensionObjectType.ISO_21812);
	}

	@Override
	public Boolean gethasExtensionISO_TS_24064() {
		return StaticContainers.getEnabledExtensions().contains(ExtensionObjectType.ISO_TS_24064);
	}

	@Override
	public Boolean gethasExtensionISO_TS_24654() {
		return StaticContainers.getEnabledExtensions().contains(ExtensionObjectType.ISO_TS_24654);
	}

	@Override
	public Boolean gethasExtensionISO_TS_32001() {
		return StaticContainers.getEnabledExtensions().contains(ExtensionObjectType.ISO_TS_32001);
	}

	@Override
	public Boolean gethasExtensionISO_TS_32004() {
		return StaticContainers.getEnabledExtensions().contains(ExtensionObjectType.ISO_TS_32004);
	}

	@Override
	public Boolean gethasExtensionISO_TS_32007() {
		return StaticContainers.getEnabledExtensions().contains(ExtensionObjectType.ISO_TS_32007);
	}

	@Override
	public Boolean gethasExtensionMalforms() {
		return StaticContainers.getEnabledExtensions().contains(ExtensionObjectType.Malforms);
	}

	@Override
	public Boolean gethasExtensionOpenOffice() {
		return StaticContainers.getEnabledExtensions().contains(ExtensionObjectType.OpenOffice);
	}

	@Override
	public Boolean gethasExtensionPDF_VT2() {
		return StaticContainers.getEnabledExtensions().contains(ExtensionObjectType.PDF_VT2);
	}

	@Override
	public Boolean gethasExtensionWTPDF() {
		return StaticContainers.getEnabledExtensions().contains(ExtensionObjectType.WTPDF);
	}

	public static Boolean getHasTypeArray(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_ARRAY;
	}

	public static Long getBitmaskValue(COSObject object) {
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public static Boolean getHasTypeBitmask(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	public static Boolean getBooleanValue(COSObject object) {
		if (object != null && object.getType() == COSObjType.COS_BOOLEAN) {
			return object.getBoolean();
		}
		return null;
	}

	public static Boolean getHasTypeBoolean(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	public static String getDateValue(COSObject object) {
		if (object != null && object.getType() == COSObjType.COS_STRING && object.getString().matches(GFAObject.PDF_DATE_FORMAT_REGEX)) {
			return object.getString();
		}
		return null;
	}

	public static Boolean getHasTypeDate(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_STRING && object.getString().matches(PDF_DATE_FORMAT_REGEX);
	}

	public static Boolean getHasTypeDictionary(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	public static Long getIntegerValue(COSObject object) {
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public static Boolean getHasTypeInteger(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	public static Boolean getHasTypeMatrix(COSObject object) {
		if (object == null || object.getType() != COSObjType.COS_ARRAY || object.size() != 6) {
			return false;
		}
		for (COSObject elem : (COSArray)object.getDirectBase()) {
			if (elem == null || (elem.getType() != COSObjType.COS_REAL && elem.getType() != COSObjType.COS_INTEGER)) {
				return false;
			}
		}
		return true;
	}

	public static String getNameValue(COSObject object) {
		if (object != null && object.getType() == COSObjType.COS_NAME) {
			return object.getString();
		}
		return null;
	}

	public static Boolean getHasTypeName(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_NAME;
	}

	public static Boolean getHasTypeNameTree(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	public static Boolean getHasTypeNull(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_NULL;
	}

	public static Double getNumberValue(COSObject object) {
		if (object != null && object.getType().isNumber()) {
			return object.getReal();
		}
		return null;
	}

	public static Boolean getHasTypeNumber(COSObject object) {
		return object != null && object.getType().isNumber();
	}

	public static Boolean getHasTypeNumberTree(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

	public static Boolean getHasTypeRectangle(COSObject object) {
		if (object == null || object.getType() != COSObjType.COS_ARRAY || object.size() != 4) {
			return false;
		}
		for (COSObject elem : (COSArray)object.getDirectBase()) {
			if (elem == null || (elem.getType() != COSObjType.COS_REAL && elem.getType() != COSObjType.COS_INTEGER)) {
				return false;
			}
		}
		return true;
	}

	public static Boolean getHasTypeStream(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	public static String getStringValue(COSObject object) {
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			return object.getString();
		}
		return null;
	}

	public static Boolean getHasTypeString(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	public static String getStringAsciiValue(COSObject object) {
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			return ((COSString)object.getDirectBase()).getASCIIString();
		}
		return null;
	}

	public static Boolean getHasTypeStringAscii(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isASCIIString();
	}

	public static String getStringByteValue(COSObject object) {
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			return object.getString();
		}
		return null;
	}

	public static Boolean getHasTypeStringByte(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_STRING;
	}

	public static String getStringTextValue(COSObject object) {
		if (object != null && object.getType() == COSObjType.COS_STRING) {
			return object.getString();
		}
		return null;
	}

	public static Boolean getHasTypeStringText(COSObject object) {
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	public static Set<COSKey> getKeysSet() {
		if (keysSet.get() == null) {
			keysSet.set(new HashSet<>());
		}
		return keysSet.get();
	}

	public static void setKeysSet(Set<COSKey> keysSet) {
		GFAObject.keysSet.set(keysSet);
	}

	public static Set<COSKey> getAFKeysSet() {
		if (afKeysSet.get() == null) {
			afKeysSet.set(new HashSet<>());
		}
		return afKeysSet.get();
	}

	public static void setAFKeysSet(Set<COSKey> afKeysSet) {
		GFAObject.afKeysSet.set(afKeysSet);
	}

	public static void clearAllContainers() {
		keysSet.set(new HashSet<>());
		afKeysSet.set(new HashSet<>());
	}

	static {
		standardFonts.add("Times-Roman");
		standardFonts.add("Helvetica");
		standardFonts.add("Courier");
		standardFonts.add("Symbol");
		standardFonts.add("Times-Bold");
		standardFonts.add("Helvetica-Bold");
		standardFonts.add("Courier-Bold");
		standardFonts.add("ZapfDingbats");
		standardFonts.add("Times-Italic");
		standardFonts.add("Helvetica-Oblique");
		standardFonts.add("Courier-Oblique");
		standardFonts.add("Times-BoldItalic");
		standardFonts.add("Helvetica-BoldOblique");
		standardFonts.add("Courier-BoldOblique");
	}

}

