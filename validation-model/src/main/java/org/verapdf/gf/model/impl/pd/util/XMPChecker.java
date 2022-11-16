/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.pd.util;

import org.verapdf.xmp.XMPException;
import org.verapdf.xmp.impl.VeraPDFMeta;
import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDocument;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.pd.PDMetadata;
import org.verapdf.tools.TypeConverter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    private static final Logger LOGGER = Logger.getLogger(XMPChecker.class.getCanonicalName());

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

        try (InputStream metadataStream = getMetadataStream(document)) {

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
            LOGGER.log(Level.FINE,
                    "Problems with document parsing or structure. "
                            + e.getMessage(), e);
        } catch (XMPException e) {
            LOGGER.log(Level.FINE, "Problems with XMP parsing. " + e.getMessage(), e);
        }

        return Boolean.FALSE;
    }

    public static InputStream getMetadataStream(COSDocument document) throws IOException {
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
        return isXMPBasicMatch;
    }

    private static boolean checkProperty(COSObject info,
                                         Map<ASAtom, Object> properties, ASAtom checksRule) {
        final COSObject item = info.getKey(checksRule);
        if (item == null || item.empty() || item.getType() == COSObjType.COS_NULL) {
            return true;
        } else if (item.getType() == COSObjType.COS_STRING) {
            return checkCOSStringProperty(item, properties,
                    checksRule);
        }
        return false;
    }

    private static Boolean checkCOSStringProperty(COSObject string,
                                                  Map<ASAtom, Object> properties, ASAtom checksRule) {
        final Object value = properties.get(checksRule);
        if (value != null) {
            if (value instanceof String) {
                return checkStringsIgnoreInfoTrailingZero(value, string.getString());
            } else if (value instanceof List) {
                List<?> list = (List<?>) value;
                return list.size() == 1 && checkStringsIgnoreInfoTrailingZero(list.get(0), string.getString());
            } else if (value instanceof Calendar) {
                final Calendar valueDate = TypeConverter.parseDate(string.getString());
                return valueDate != null && valueDate.compareTo((Calendar) value) == 0;
            }
        }
        return Boolean.FALSE;
    }

    private static boolean checkStringsIgnoreInfoTrailingZero(Object fromXMP, String fromInfo) {
        if (fromInfo != null && fromInfo.endsWith("\0")) {
            fromInfo = fromInfo.substring(0, fromInfo.length() - 1);
        }
        return fromXMP.equals(fromInfo);
    }

    public static String getStringWithoutTrailingZero(String string) {
        if (string != null && string.endsWith("\0")) {
            return string.substring(0, string.length() - 1);
        }
        return string;
    }
}
