/**
 * This file is part of feature-reporting, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * feature-reporting is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with feature-reporting as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * feature-reporting as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.features.gf.objects;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.features.objects.InfoDictFeaturesObjectAdapter;
import org.verapdf.tools.TypeConverter;

import java.util.*;

/**
 * Feature object for information dictionary
 *
 * @author Maksim Bezrukov
 */
public class GFInfoDictFeaturesObjectAdapter implements InfoDictFeaturesObjectAdapter {

    private static final ASAtom[] predefinedKeys = {
            ASAtom.TITLE,
            ASAtom.AUTHOR,
            ASAtom.SUBJECT,
            ASAtom.KEYWORDS,
            ASAtom.CREATOR,
            ASAtom.PRODUCER,
            ASAtom.CREATION_DATE,
            ASAtom.MOD_DATE,
            ASAtom.TRAPPED
    };

    private COSObject info;

    /**
     * Constructs new information dictionary feature object adapter.
     *
     * @param info class represents page object
     */
    public GFInfoDictFeaturesObjectAdapter(COSObject info) {
        this.info = info;
    }

    @Override
    public String getTitle() {
        return getStringKey(ASAtom.TITLE);
    }

    @Override
    public String getAuthor() {
        return getStringKey(ASAtom.AUTHOR);
    }

    @Override
    public String getSubject() {
        return getStringKey(ASAtom.SUBJECT);
    }

    @Override
    public String getKeywords() {
        return getStringKey(ASAtom.KEYWORDS);
    }

    @Override
    public String getCreator() {
        return getStringKey(ASAtom.CREATOR);
    }

    @Override
    public String getProducer() {
        return getStringKey(ASAtom.PRODUCER);
    }

    @Override
    public Calendar getCreationDate() {
        return getCalendarKey(ASAtom.CREATION_DATE);
    }

    @Override
    public Calendar getModDate() {
        return getCalendarKey(ASAtom.MOD_DATE);
    }

    @Override
    public String getTrapped() {
        return getNameKey(ASAtom.TRAPPED);
    }

    @Override
    public Map<String, String> getCustomValues() {
        if (info != null && info.getType() == COSObjType.COS_DICT) {
            Map<String, String> res = new TreeMap<>();
            Set<ASAtom> keys = new TreeSet<>(info.getKeySet());
            keys.removeAll(Arrays.asList(predefinedKeys));
            for (ASAtom key : keys) {
                res.put(key.getValue(), info.getStringKey(key));
            }
            return Collections.unmodifiableMap(res);
        }
        return Collections.emptyMap();
    }

    @Override
    public boolean isPDFObjectPresent() {
        return info != null && !info.empty();
    }

    @Override
    public List<String> getErrors() {
        return Collections.emptyList();
    }

    private String getStringKey(ASAtom key) {
        if (info != null && info.getType() == COSObjType.COS_DICT) {
            return info.getStringKey(key);
        }
        return null;
    }

    private Calendar getCalendarKey(ASAtom key) {
        if (info != null && info.getType() == COSObjType.COS_DICT) {
            String date = info.getStringKey(key);
            return TypeConverter.parseDate(date);
        }
        return null;
    }

    private String getNameKey(ASAtom key) {
        if (info != null && info.getType() == COSObjType.COS_DICT) {
            ASAtom atom = info.getNameKey(key);
            return atom == null ? null : atom.getValue();
        }
        return null;
    }
}
