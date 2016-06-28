package org.verapdf.model.impl.cos;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.*;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosDict;
import org.verapdf.model.coslayer.CosName;
import org.verapdf.model.coslayer.CosObject;
import org.verapdf.model.pdlayer.PDMetadata;
import org.verapdf.pd.PDDocument;
import org.verapdf.pdfa.flavours.PDFAFlavour;

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

    protected final PDDocument document;
    protected final PDFAFlavour flavour;

    /**
     * Default constructor
     *
     * @param dictionary greenfield COSDictionary
     */
    public GFCosDict(COSDictionary dictionary, PDDocument document, PDFAFlavour flavour) {
        this(dictionary, COS_DICT_TYPE, document, flavour);
    }

    /**
     * Constructor used by child classes
     *
     * @param dictionary greenfield COSDictionary
     * @param type       type of child class
     */
    protected GFCosDict(COSDictionary dictionary, final String type, final PDDocument document, final PDFAFlavour flavour) {
        super(dictionary, type);
        this.size = dictionary.size();
        this.document = document;
        this.flavour = flavour;
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
        List<CosName> list = new ArrayList<>(this.baseObject.size());
        for (ASAtom key : this.baseObject.getKeySet()) {
            if (key != null) {
                COSBase name = COSName.fromValue(key);
                list.add((CosName) getFromValue(name, this.document, this.flavour));
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
                list.add(getFromValue(value.get(), this.document, this.flavour));
            }
        }
        return Collections.unmodifiableList(list);
    }

    /**
     * Get XMP metadata if it is present
     */
    private List<PDMetadata> getMetadata() {
        COSDictionary dictionary = (COSDictionary) this.baseObject;
        COSBase meta = dictionary.getKey(ASAtom.METADATA).get();
        ASAtom type = dictionary.getNameKey(ASAtom.TYPE);
        if (meta != null && meta instanceof COSStream
                && type != ASAtom.CATALOG) {
            ArrayList<PDMetadata> pdMetadatas = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);

            //TODO : metadata

            return pdMetadatas;
        }

        return Collections.emptyList();
    }

}
