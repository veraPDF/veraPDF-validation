package org.verapdf.features.gf.objects;

import org.verapdf.as.ASAtom;
import org.verapdf.core.FeatureParsingException;
import org.verapdf.cos.COSObject;
import org.verapdf.features.FeatureExtractionResult;
import org.verapdf.features.FeatureObjectType;
import org.verapdf.features.FeaturesData;
import org.verapdf.features.IFeaturesObject;
import org.verapdf.features.gf.tools.GFCreateNodeHelper;
import org.verapdf.features.tools.FeatureTreeNode;

/**
 * @author Maksim Bezrukov
 */
public class GFPropertiesDictFeaturesObject implements IFeaturesObject {

    private COSObject properties;
    private String id;

    /**
     * Constructs new propertiesDict features object
     *
     * @param properties    COSDictionary which represents properties for feature report
     * @param id            id of the object
     */
    public GFPropertiesDictFeaturesObject(COSObject properties, String id) {
        this.properties = properties;
        this.id = id;
    }

    /**
     * @return PROPERTIES instance of the FeatureObjectType enumeration
     */
    @Override
    public FeatureObjectType getType() {
        return FeatureObjectType.PROPERTIES;
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
        if (properties != null) {
            FeatureTreeNode root = FeatureTreeNode.createRootNode("propertiesDict");
            if (id != null) {
                root.setAttribute("id", id);
            }

            ASAtom type = properties.getNameKey(ASAtom.TYPE);
            if (type != null) {
                GFCreateNodeHelper.addNotEmptyNode("type", type.getValue(), root);
            }

            collection.addNewFeatureTree(FeatureObjectType.PROPERTIES, root);
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

}
