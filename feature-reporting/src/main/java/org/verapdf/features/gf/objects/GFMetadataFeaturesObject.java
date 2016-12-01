package org.verapdf.features.gf.objects;

import org.verapdf.core.FeatureParsingException;
import org.verapdf.features.*;
import org.verapdf.features.gf.tools.GFCreateNodeHelper;
import org.verapdf.features.tools.FeatureTreeNode;
import org.verapdf.pd.PDMetadata;

import java.io.InputStream;

/**
 * Feature object for metadata
 *
 * @author Maksim Bezrukov
 */
public class GFMetadataFeaturesObject implements IFeaturesObject {

    private PDMetadata metadata;

    /**
     * Constructs new Metadata Feature Object
     *
     * @param metadata class represents metadata object
     */
    public GFMetadataFeaturesObject(PDMetadata metadata) {
        this.metadata = metadata;
    }

    /**
     * @return METADATA instance of the FeatureObjectType enumeration
     */
    @Override
    public FeatureObjectType getType() {
        return FeatureObjectType.METADATA;
    }

    /**
     * Reports featurereport into collection
     *
     * @param collection collection for feature report
     * @return FeatureTreeNode class which represents a root node of the constructed collection tree
     * @throws FeatureParsingException occurs when wrong features tree node constructs
     */
    @Override
    public FeatureTreeNode reportFeatures(FeatureExtractionResult collection) throws FeatureParsingException {
        if (metadata != null) {
            FeatureTreeNode root = FeatureTreeNode.createRootNode("metadata");
            GFCreateNodeHelper.parseMetadata(metadata, "xmpPackage", root, collection);

            collection.addNewFeatureTree(FeatureObjectType.METADATA, root);
            return root;
        }
        return null;
    }

    /**
     * @return null if it can not get metadata stream and features data of the metadata in other case.
     */
    @Override
    public FeaturesData getData() {
        if (metadata != null) {
            InputStream meta = metadata.getStream();
            return MetadataFeaturesData.newInstance(meta);
        }
        return null;
    }
}
