package org.verapdf.model.impl.pd.util;

import com.adobe.xmp.XMPException;
import com.adobe.xmp.impl.VeraPDFMeta;
import org.apache.log4j.Logger;
import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDocument;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.pd.PDMetadata;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class matches document information dictionary and xmp metadata by
 * comparing eight predefined fields:
 * <ol>
 * <li>Title (-> Title)</li>
 * <li>Author (-> Creators)</li>
 * <li>Producer (-> Producer)</li>
 * <li>Creator (-> CreatorTool)</li>
 * <li>Keywords (-> Keywords)</li>
 * <li>Subject (-> Description)</li>
 * <li>Creation Date (-> Create Date)</li>
 * <li>Mod Date (-> Modify Date)</li>
 * </ol>
 * Property shouldn't be defined in xmp metadata if not present in document
 * information dictionary.
 *
 * @author Maksim Bezrukov
 */
public final class XMPChecker {

    private static final Logger LOGGER = Logger.getLogger(XMPChecker.class);

    private static final int MAX_REQUIRED_RECORDS = 8;

    private XMPChecker() {
        // disable default constructor
    }

    /**
     * Matches properties of document information dictionary and xmp metadata.
     *
     * @param document which will be tested
     * @return true if fields of xmp matches with fields of info dictionary
     */
    public static Boolean doesInfoMatchXMP(COSDocument document) {
        COSObject info = getInformationDictionary(document);
        if (info == null) {
            return Boolean.TRUE;
        }

        try {
            InputStream metadataStream = getMetadataStream(document);
            if (metadataStream != null) {
                VeraPDFMeta metadata = VeraPDFMeta.parse(metadataStream);

                Map<ASAtom, Object> properties = new HashMap<>(
                        MAX_REQUIRED_RECORDS);

                getTitleAuthorSubject(metadata, properties);

                getProducerKeywords(metadata, properties);

                getCreatorAndDates(metadata, properties);

                return checkMatch(info, properties);
            }
        } catch (IOException e) {
            LOGGER.debug(
                    "Problems with document parsing or structure. "
                            + e.getMessage(), e);
        } catch (XMPException e) {
            LOGGER.debug("Problems with XMP parsing. " + e.getMessage(), e);
        }

        return Boolean.FALSE;
    }

    private static InputStream getMetadataStream(COSDocument document) throws IOException {
        PDMetadata meta = document.getPDDocument().getMetadata();
        if (meta != null) {
            return meta.getStream();
        }
        return null;
    }

    private static COSObject getInformationDictionary(COSDocument document) {
        final COSObject info = document.getTrailer().getInfo();
        if (info != null && info.getType() == COSObjType.COS_DICT) {
            return info;
        }
        return null;
    }

    private static void getTitleAuthorSubject(VeraPDFMeta metadata,
                                              Map<ASAtom, Object> properties) throws XMPException {

        putProperty(properties, ASAtom.TITLE, metadata.getTitle());
        putProperty(properties, ASAtom.SUBJECT, metadata.getDescription());
        final List<String> buffer = metadata.getCreator();
        if (buffer != null) {
            putProperty(properties, ASAtom.AUTHOR, buffer);
        }
    }

    private static void getProducerKeywords(VeraPDFMeta metadata,
                                            Map<ASAtom, Object> properties) throws XMPException {
        putProperty(properties, ASAtom.KEYWORDS, metadata.getKeywords());
        putProperty(properties, ASAtom.PRODUCER, metadata.getProducer());
    }

    private static void getCreatorAndDates(VeraPDFMeta metadata,
                                           Map<ASAtom, Object> properties) throws XMPException {
        putProperty(properties, ASAtom.CREATOR, metadata.getCreatorTool());
        putProperty(properties, ASAtom.CREATION_DATE, metadata.getCreateDate());
        putProperty(properties, ASAtom.MOD_DATE, metadata.getModifyDate());
    }

    private static void putProperty(Map<ASAtom, Object> properties, ASAtom key,
                                    Object value) {
        if (value != null) {
            properties.put(key, value);
        }
    }

    private static Boolean checkMatch(COSObject info,
                                      Map<ASAtom, Object> properties) {
        boolean isDublinCoreMatch = checkProperty(info, properties, ASAtom.TITLE)
                && checkProperty(info, properties, ASAtom.SUBJECT)
                && checkProperty(info, properties, ASAtom.AUTHOR);
        if (!isDublinCoreMatch) {
            return Boolean.FALSE;
        }
        boolean isAdobePDFMatch = checkProperty(info, properties, ASAtom.KEYWORDS)
                && checkProperty(info, properties, ASAtom.PRODUCER);
        if (!isAdobePDFMatch) {
            return Boolean.FALSE;
        }
        boolean isXMPBasicMatch = checkProperty(info, properties, ASAtom.CREATOR)
                && checkProperty(info, properties, ASAtom.CREATION_DATE)
                && checkProperty(info, properties, ASAtom.MOD_DATE);
        return Boolean.valueOf(isXMPBasicMatch);
    }

    private static Boolean checkProperty(COSObject info,
                                         Map<ASAtom, Object> properties, ASAtom checksRule) {
        final COSObject item = info.getKey(checksRule);
        if (item == null || item.empty() || item.getType() == COSObjType.COS_NULL) {
            return Boolean.TRUE;
        } else if (item.getType() == COSObjType.COS_STRING) {
            return checkCOSStringProperty(item, properties,
                    checksRule);
        }
        return Boolean.FALSE;
    }

    private static Boolean checkCOSStringProperty(COSObject string,
                                                  Map<ASAtom, Object> properties, ASAtom checksRule) {
        final Object value = properties.get(checksRule);
        if (value != null) {
            if (value instanceof String) {
                return Boolean.valueOf(value.equals(string.getString()));
            } else if (value instanceof List) {
                List list = (List) value;
                return Boolean.valueOf(list.size() == 1 && list.get(0).equals(string.getString()));
            } else if (value instanceof Calendar) {
                final Calendar valueDate = TypeConverter.parseDate(string.getString());
                return Boolean.valueOf(valueDate != null
                        && valueDate.compareTo((Calendar) value) == 0);
            }
        }
        return Boolean.FALSE;
    }
}
