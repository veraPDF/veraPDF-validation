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
import java.io.IOException;

public class GFAObject extends GenericModelObject implements AObject {

	private final static List<String> standardFonts = new LinkedList<>();
	private static final ThreadLocal<Set<COSKey>> keysSet = new ThreadLocal<>();
	protected static final String PDF_DATE_FORMAT_REGEX = "(D:)?(\\d\\d){2,7}((([+-](\\d\\d[']))(\\d\\d['])?)?|[Z])";
	protected final COSBase baseObject;
	protected COSBase parentObject;
	protected String keyName;

	public GFAObject(COSBase baseObject, COSBase parentObject, String objectType) {
		super(objectType);
		this.baseObject = baseObject;
		this.parentObject = parentObject;
	}

	public GFAObject(COSBase baseObject, COSBase parentObject, String keyName, String objectType) {
		this(baseObject, parentObject, objectType);
		this.keyName = keyName;
	}

	@Override
	public String getID() {
		COSKey key = baseObject.getObjectKey();
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
		return this.baseObject.getKeySet().stream()
				.map(ASAtom::getValue)
				.collect(Collectors.joining("&"));
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

	public static boolean hasCycle(COSObject object, ASAtom entryName) {
		if (object == null) {
			return false;
		}
		Set<COSKey> visitedKeys = new HashSet<>();
		while (object.knownKey(entryName)) {
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

	public static Set<COSKey> getKeysSet() {
		if (keysSet.get() == null) {
			keysSet.set(new HashSet<>());
		}
		return keysSet.get();
	}

	public static void setKeysSet(Set<COSKey> keysSet) {
		GFAObject.keysSet.set(keysSet);
	}

	public static void clearAllContainers() {
		keysSet.set(new HashSet<>());
	}

	static {
		standardFonts.add("TimesRoman");
		standardFonts.add("Helvetica");
		standardFonts.add("Courier");
		standardFonts.add("Symbol");
		standardFonts.add("TimesBold");
		standardFonts.add("HelveticaBold");
		standardFonts.add("CourierBold");
		standardFonts.add("ZapfDingbats");
		standardFonts.add("TimesItalic");
		standardFonts.add("HelveticaOblique");
		standardFonts.add("CourierOblique");
		standardFonts.add("TimesBoldItalic");
		standardFonts.add("HelveticaBoldOblique");
		standardFonts.add("CourierBoldOblique");
	}

}

