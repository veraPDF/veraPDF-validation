package org.verapdf.features.gf.objects;

import org.verapdf.as.ASAtom;
import org.verapdf.core.FeatureParsingException;
import org.verapdf.cos.*;
import org.verapdf.features.FeatureExtractionResult;
import org.verapdf.features.FeatureObjectType;
import org.verapdf.features.FeaturesData;
import org.verapdf.features.IFeaturesObject;
import org.verapdf.features.tools.ErrorsHelper;
import org.verapdf.features.tools.FeatureTreeNode;

import java.util.*;

/**
 * Feature object for low level info part of the features report
 *
 * @author Sergey Shemyakov
 */
public class GFLowLvlInfoFeaturesObject implements IFeaturesObject {

    private COSDocument document;
    private static final Map<ASAtom, ASAtom> filtersAbbreviations;

    static {
        Map<ASAtom, ASAtom> filtersAbbreviationsTemp = new HashMap<>();

        filtersAbbreviationsTemp.put(ASAtom.ASCII_HEX_DECODE_ABBREVIATION, ASAtom.ASCII_HEX_DECODE);
        filtersAbbreviationsTemp.put(ASAtom.ASCII85_DECODE_ABBREVIATION, ASAtom.ASCII85_DECODE);
        filtersAbbreviationsTemp.put(ASAtom.LZW_DECODE_ABBREVIATION, ASAtom.LZW_DECODE);
        filtersAbbreviationsTemp.put(ASAtom.FLATE_DECODE_ABBREVIATION, ASAtom.FLATE_DECODE);
        filtersAbbreviationsTemp.put(ASAtom.RUN_LENGTH_DECODE_ABBREVIATION, ASAtom.RUN_LENGTH_DECODE);
        filtersAbbreviationsTemp.put(ASAtom.CCITTFAX_DECODE_ABBREVIATION, ASAtom.CCITTFAX_DECODE);
        filtersAbbreviationsTemp.put(ASAtom.DCT_DECODE_ABBREVIATION, ASAtom.DCT_DECODE);
        filtersAbbreviations = Collections.unmodifiableMap(filtersAbbreviationsTemp);
    }

    /**
     * Constructs new low level info feature object.
     *
     * @param document pdfbox class represents document object
     */
    public GFLowLvlInfoFeaturesObject(COSDocument document) {
        this.document = document;
    }

    /**
     * @return LOW_LVL_INFO instance of the FeatureObjectType enumeration
     */
    @Override
    public FeatureObjectType getType() {
        return FeatureObjectType.LOW_LEVEL_INFO;
    }

    /**
     * Reports all features from the object into the collection
     *
     * @param collection collection for feature report
     * @return FeatureTreeNode class which represents a root node of the
     * constructed collection tree
     * @throws FeatureParsingException occurs when wrong features tree node constructs
     */
    @Override
    public FeatureTreeNode reportFeatures(FeatureExtractionResult collection) throws FeatureParsingException {
        if (document != null) {
            FeatureTreeNode root = FeatureTreeNode.createRootNode("lowLevelInfo");

            if (document.getObjects() != null) {
                root.addChild("indirectObjectsNumber")
                        .setValue(String.valueOf(document.getObjects().size()));
            }

            addDocumentId(root, collection);

            Set<ASAtom> filters = getAllFilters();

            if (!filters.isEmpty()) {
                FeatureTreeNode filtersNode = root.addChild("filters");

                for (ASAtom filter : filters) {
                    if (filter != null) {
                        FeatureTreeNode filterNode = filtersNode.addChild("filter");
                        filterNode.setAttribute("name", filter.getValue());
                    }
                }
            }

            collection.addNewFeatureTree(FeatureObjectType.LOW_LEVEL_INFO, root);
            return root;

        }
        return null;
    }

    /**
     * @return null
     */
    @Override
    public FeaturesData getData() {
        return null;
    }

    private Set<ASAtom> getAllFilters() {
        Set<ASAtom> res = new HashSet<>();
        for (COSObject base : document.getObjects()) {
            if (base.getType() == COSObjType.COS_STREAM) {
                COSFilters baseFilters = ((COSStream) base.get()).getFilters();
                if (baseFilters != null) {
                    addFilters(res, baseFilters);
                }
            }
        }
        return res;
    }

    private void addDocumentId(FeatureTreeNode root, FeatureExtractionResult collection) throws FeatureParsingException {
        COSArray ids = document.getID();
        if (ids != null) {
            String creationId = ids.at(0).getString();
            String modificationId = ids.at(1).getString();

            FeatureTreeNode documentId = root.addChild("documentId");

            if (creationId != null || modificationId != null) {
                if (creationId != null) {
                    documentId.setAttribute("creationId", creationId);
                }
                if (modificationId != null) {
                    documentId.setAttribute("modificationId", modificationId);
                }
            }

            if (ids.size() != 2 || creationId == null || modificationId == null) {
                ErrorsHelper.addErrorIntoCollection(collection, documentId,
                        "Document's ID must be an array of two not null elements");
            }
        }
    }

    private static void addFilters(Set<ASAtom> res, COSFilters filters) {
        List<ASAtom> atoms = filters.getFilters();
        if (atoms != null) {
            for (ASAtom atom : atoms) {
                if (filtersAbbreviations.keySet().contains(atom)) {
                    atom = filtersAbbreviations.get(atom);
                }
                res.add(atom);
            }
        }
    }
}
