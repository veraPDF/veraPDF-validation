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
import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSName;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.pd.GFPDMetadata;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosDict;
import org.verapdf.model.coslayer.CosName;
import org.verapdf.model.coslayer.CosObject;
import org.verapdf.model.pdlayer.PDMetadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Timur Kamalov
 */
public class GFCosDict extends GFCosObject implements CosDict {

    public static final String COS_DICT_TYPE = "CosDict";

    public static final String KEYS = "keys";
    public static final String VALUES = "values";
    public static final String METADATA = "metadata";

    private final int size;

    /**
     * Default constructor
     *
     * @param dictionary greenfield COSDictionary
     */
    public GFCosDict(COSDictionary dictionary) {
        this(dictionary, COS_DICT_TYPE);
    }

    /**
     * Constructor used by child classes
     *
     * @param dictionary greenfield COSDictionary
     * @param type       type of child class
     */
    protected GFCosDict(COSDictionary dictionary, final String type) {
        super(dictionary, type);
        this.size = dictionary.size();
    }

    /**
     * Get number of key/value pairs in the dictionary
     */
    @Override
    public Long getsize() {
        return (long) this.size;
    }

    @Override
    public String getkeysString() {
        return this.baseObject.getKeySet().stream()
                .map(ASAtom::getValue)
                .collect(Collectors.joining("&"));
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case KEYS:
                return this.getKeys();
            case VALUES:
                return this.getValues();
            case METADATA:
                return this.getMetadata();
            default:
                return super.getLinkedObjects(link);
        }
    }

    /**
     * Get all keys of the dictionary
     */
    private List<CosName> getKeys() {
        List<CosName> list = new ArrayList<>(this.baseObject.size());
        for (ASAtom key : this.baseObject.getKeySet()) {
            if (key != null) {
                COSBase name = COSName.fromValue(key);
                list.add((CosName) getFromValue(name));
            }
        }
        return Collections.unmodifiableList(list);
    }

    /**
     * Get all values of the dictionary
     */
    private List<CosObject> getValues() {
        List<CosObject> list = new ArrayList<>(this.baseObject.size());
        for (COSObject value : this.baseObject.getValues()) {
            if (value != null) {
                list.add(getFromValue(value.get()));
            }
        }
        return Collections.unmodifiableList(list);
    }

    /**
     * Get XMP metadata if it is present
     */
    private List<PDMetadata> getMetadata() {
        COSDictionary dictionary = (COSDictionary) this.baseObject;
        COSObject meta = dictionary.getKey(ASAtom.METADATA);
        ASAtom type = dictionary.getNameKey(ASAtom.TYPE);
        if (org.verapdf.pd.PDMetadata.isMetadataObject(meta) && type != ASAtom.CATALOG) {
            List<PDMetadata> pdMetadatas = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            org.verapdf.pd.PDMetadata md = new org.verapdf.pd.PDMetadata(meta);
            pdMetadatas.add(new GFPDMetadata(md, Boolean.FALSE));
            return Collections.unmodifiableList(pdMetadatas);
        }

        return Collections.emptyList();
    }

}
