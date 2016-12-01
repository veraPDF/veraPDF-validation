package org.verapdf.features.gf.objects;

import org.verapdf.features.FeatureExtractionResult;
import org.verapdf.features.FeatureObjectType;
import org.verapdf.features.FeaturesData;
import org.verapdf.features.IFeaturesObject;
import org.verapdf.features.tools.FeatureTreeNode;

/**
 * Features object for postscript xobject
 *
 * @author Maksim Bezrukov
 */
public class GFPostScriptXObjectFeaturesObject implements IFeaturesObject {

    private String id;

    /**
     * Constructs new tilling pattern features object
     *
     * @param id            id of the object
     */
    public GFPostScriptXObjectFeaturesObject(String id) {
        this.id = id;
    }

    /**
     * @return POSTSCRIPT_XOBJECT instance of the FeatureObjectType enumeration
     */
    @Override
    public FeatureObjectType getType() {
        return FeatureObjectType.POSTSCRIPT_XOBJECT;
    }

    /**
     * Reports featurereport into collection
     *
     * @param collection collection for feature report
     * @return FeatureTreeNode class which represents a root node of the constructed collection tree
     */
    @Override
    public FeatureTreeNode reportFeatures(FeatureExtractionResult collection) {
        FeatureTreeNode root = FeatureTreeNode.createRootNode("xobject");
        root.setAttribute("type", "postscript");
        if (id != null) {
            root.setAttribute("id", id);
        }

        collection.addNewFeatureTree(FeatureObjectType.POSTSCRIPT_XOBJECT, root);
        return root;
    }

    /**
     * @return null
     */
    @Override
    public FeaturesData getData() {
        return null;
    }

}
