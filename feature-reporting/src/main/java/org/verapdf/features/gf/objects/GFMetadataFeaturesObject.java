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
        if (metadata != null && !metadata.empty()) {
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
        if (metadata != null && !metadata.empty()) {
            InputStream meta = metadata.getStream();
            return MetadataFeaturesData.newInstance(meta);
        }
        return null;
    }
}
