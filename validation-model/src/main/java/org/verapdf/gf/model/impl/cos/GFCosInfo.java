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
package org.verapdf.gf.model.impl.cos;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSDocument;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.pd.util.XMPChecker;
import org.verapdf.metadata.fixer.gf.utils.DateConverter;
import org.verapdf.model.coslayer.CosInfo;
import org.verapdf.tools.StaticResources;
import org.verapdf.tools.TypeConverter;
import org.verapdf.xmp.XMPException;
import org.verapdf.xmp.impl.VeraPDFMeta;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;

/**
 * @author Maxim Plushchov
 */
public class GFCosInfo extends GFCosDict implements CosInfo {

    public static final String INFORMATION_TYPE = "CosInfo";

    private VeraPDFMeta meta;

    public GFCosInfo(COSDictionary dictionary) {
        super(dictionary, INFORMATION_TYPE);
        this.meta = parseMetadata();
    }

    private VeraPDFMeta parseMetadata() {
        COSDocument document = StaticResources.getDocument().getDocument();
        try (InputStream metadataStream = XMPChecker.getMetadataStream(document)) {
            if (metadataStream != null) {
                return VeraPDFMeta.parse(metadataStream);
            }
        } catch (IOException | XMPException ignored) {
        }
        return null;
    }

    @Override
    public String getModDate() {
        return this.baseObject.getStringKey(ASAtom.MOD_DATE);
    }

    @Override
    public String getCreationDate() {
        return this.baseObject.getStringKey(ASAtom.CREATION_DATE);
    }

    private String getStringProperty(ASAtom name) {
        COSObject value = baseObject.getKey(name);
        if (value != null && !value.empty() && value.getType() != COSObjType.COS_NULL) {
            if (value.getType() == COSObjType.COS_STRING) {
                return XMPChecker.getStringWithoutTrailingZero(value.getString());
            } else {
                return value.toString();
            }
        }
        return null;
    }

    @Override
    public String getTitle() {
        return getStringProperty(ASAtom.TITLE);
    }

    @Override
    public String getAuthor() {
        return getStringProperty(ASAtom.AUTHOR);
    }

    @Override
    public String getSubject() {
        return getStringProperty(ASAtom.SUBJECT);
    }

    @Override
    public String getProducer() {
        return getStringProperty(ASAtom.PRODUCER);
    }

    @Override
    public String getCreator() {
        return getStringProperty(ASAtom.CREATOR);
    }

    @Override
    public String getKeywords() {
        return getStringProperty(ASAtom.KEYWORDS);
    }

    @Override
    public String getXMPTitle() {
        if (meta != null) {
            try {
                return meta.getTitle();
            } catch (XMPException ignored) {
            }
        }
        return null;
    }

    @Override
    public String getXMPCreator() {
        if (meta != null) {
            try {
                List<String> creator = meta.getCreator();
                if (creator != null) {
                    if (creator.size() == 1) {
                        return creator.get(0);
                    } else {
                        return "[" + String.join(",", creator) + "]";
                    }                }
            } catch (XMPException ignored) {
            }
        }
        return null;
    }

    @Override
    public Long getXMPCreatorSize() {
        if (meta != null) {
            try {
                List<String> creator = meta.getCreator();
                if (creator != null) {
                    return (long) creator.size();
                }
            } catch (XMPException ignored) {
            }
        }
        return null;
    }

    @Override
    public String getXMPProducer() {
        if (meta != null) {
            try {
                return meta.getProducer();
            } catch (XMPException ignored) {
            }
        }
        return null;
    }

    @Override
    public String getXMPCreatorTool() {
        if (meta != null) {
            try {
                return meta.getCreatorTool();
            } catch (XMPException ignored) {
            }
        }
        return null;
    }

    @Override
    public String getXMPKeywords() {
        if (meta != null) {
            try {
                return meta.getKeywords();
            } catch (XMPException ignored) {
            }
        }
        return null;
    }

    @Override
    public String getXMPDescription() {
        if (meta != null) {
            try {
                return meta.getDescription();
            } catch (XMPException ignored) {
            }
        }
        return null;
    }

    @Override
    public Boolean getdoCreationDatesMatch() {
        Calendar xmpCreateDate = null;
        if (meta != null) {
            try {
                xmpCreateDate = meta.getCreateDate();
            } catch (XMPException ignored) {
            }
        }
        String creationDate = getCreationDate();
        if (xmpCreateDate != null && creationDate != null) {
            Calendar creationDateCalendar = TypeConverter.parseDate(creationDate);
            return creationDateCalendar != null && xmpCreateDate.compareTo(creationDateCalendar) == 0;
        }
        return null;
    }

    @Override
    public Boolean getdoModDatesMatch() {
        Calendar xmpModifyDate = null;
        if (meta != null) {
            try {
                xmpModifyDate = meta.getModifyDate();
            } catch (XMPException ignored) {
            }
        }
        String modDate = getModDate();
        if (xmpModifyDate != null && modDate != null) {
            Calendar modDateCalendar = TypeConverter.parseDate(modDate);
            return modDateCalendar != null && xmpModifyDate.compareTo(modDateCalendar) == 0;
        }
        return null;
    }

    @Override
    public String getXMPCreateDate() {
        if (meta != null) {
            try {
                return DateConverter.toXMPDateFormat(meta.getCreateDate());
            } catch (XMPException ignored) {
            }
        }
        return null;
    }

    @Override
    public String getXMPModifyDate() {
        if (meta != null) {
            try {
                return DateConverter.toXMPDateFormat(meta.getModifyDate());
            } catch (XMPException ignored) {
            }
        }
        return null;
    }
}
