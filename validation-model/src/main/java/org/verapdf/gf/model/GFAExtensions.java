package org.verapdf.gf.model;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.extensions.ExtensionObjectType;
import org.verapdf.pd.PDCatalog;
import org.verapdf.pd.PDDocument;

import java.util.EnumSet;

public class GFAExtensions {

    public static EnumSet<ExtensionObjectType> getExtensions(PDDocument document, EnumSet<ExtensionObjectType> enableExtensions) {
        EnumSet<ExtensionObjectType> result = EnumSet.copyOf(enableExtensions);
        PDCatalog catalog = document.getCatalog();
        if (catalog == null) {
            return result;
        }
        COSObject extensions = catalog.getKey(ASAtom.EXTENSIONS);
        if (extensions == null) {
            return result;
        }
        COSObject iso = extensions.getKey(ASAtom.ISO_);
        if (iso != null) {
            if (iso.getType() == COSObjType.COS_DICT) {
                checkISOExtensions(iso, result);
            } else if (iso.getType() == COSObjType.COS_ARRAY) {
                for (COSObject entry : (COSArray)iso.getDirectBase()) {
                    if (entry.getType() == COSObjType.COS_DICT) {
                        checkISOExtensions(entry, result);
                    }
                }
            }
        }
        COSObject adbe = extensions.getKey(ASAtom.ADBE);
        if (adbe != null) {
            if (adbe.getType() == COSObjType.COS_DICT) {
                checkADBEExtensions(adbe, result);
            } else if (adbe.getType() == COSObjType.COS_ARRAY) {
                for (COSObject entry : (COSArray)adbe.getDirectBase()) {
                    if (entry.getType() == COSObjType.COS_DICT) {
                        checkADBEExtensions(entry, result);
                    }
                }
            }
        }
        return result;
    }

    private static void checkISOExtensions(COSObject isoDictionary, EnumSet<ExtensionObjectType> enableExtensions) {
        COSObject extensionLevel = isoDictionary.getKey(ASAtom.EXTENSION_LEVEL);
        if (extensionLevel.getType() == COSObjType.COS_INTEGER && extensionLevel.getInteger() == 24064) {
            enableExtensions.add(ExtensionObjectType.ISO_TS_24064);
        } else if (extensionLevel.getType() == COSObjType.COS_INTEGER && extensionLevel.getInteger() == 32001) {
            enableExtensions.add(ExtensionObjectType.ISO_TS_32001);
        } else if (extensionLevel.getType() == COSObjType.COS_INTEGER && extensionLevel.getInteger() == 32003) {
            enableExtensions.add(ExtensionObjectType.ISO_TS_32003);
        } else if (extensionLevel.getType() == COSObjType.COS_INTEGER && extensionLevel.getInteger() == 32004) {
            enableExtensions.add(ExtensionObjectType.ISO_TS_32004);
        } else if (extensionLevel.getType() == COSObjType.COS_INTEGER && extensionLevel.getInteger() == 32007) {
            enableExtensions.add(ExtensionObjectType.ISO_TS_32007);
        }
    }

    private static void checkADBEExtensions(COSObject isoDictionary, EnumSet<ExtensionObjectType> enableExtensions) {
        COSObject extensionLevel = isoDictionary.getKey(ASAtom.EXTENSION_LEVEL);
        if (extensionLevel.getType() == COSObjType.COS_INTEGER && extensionLevel.getInteger() == 3) {
            enableExtensions.add(ExtensionObjectType.ADBE_Extn3);
        }
    }
}
