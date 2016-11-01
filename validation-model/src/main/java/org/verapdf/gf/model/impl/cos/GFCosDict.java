package org.verapdf.gf.model.impl.cos;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.*;
import org.verapdf.gf.model.impl.pd.GFPDMetadata;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosDict;
import org.verapdf.model.coslayer.CosName;
import org.verapdf.model.coslayer.CosObject;
import org.verapdf.model.pdlayer.PDMetadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        this.size = dictionary.size().intValue();
    }

    /**
     * Get number of key/value pairs in the dictionary
     */
    @Override
    public Long getsize() {
        return Long.valueOf(this.size);
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
        List<CosName> list = new ArrayList<>(this.baseObject.size().intValue());
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
        List<CosObject> list = new ArrayList<>(this.baseObject.size().intValue());
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
        if (meta != null && meta.getType() == COSObjType.COS_STREAM
                && type != ASAtom.CATALOG) {
            ArrayList<PDMetadata> pdMetadatas = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            org.verapdf.pd.PDMetadata md = new org.verapdf.pd.PDMetadata(meta);
            pdMetadatas.add(new GFPDMetadata(md, Boolean.FALSE));
            return Collections.unmodifiableList(pdMetadatas);
        }

        return Collections.emptyList();
    }

}
