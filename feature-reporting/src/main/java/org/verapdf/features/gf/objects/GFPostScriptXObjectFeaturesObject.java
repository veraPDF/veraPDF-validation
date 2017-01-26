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
