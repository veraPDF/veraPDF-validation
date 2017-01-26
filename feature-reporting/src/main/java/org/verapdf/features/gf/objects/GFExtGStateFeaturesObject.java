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
import org.verapdf.features.FeatureExtractionResult;
import org.verapdf.features.FeatureObjectType;
import org.verapdf.features.FeaturesData;
import org.verapdf.features.IFeaturesObject;
import org.verapdf.features.tools.FeatureTreeNode;
import org.verapdf.pd.PDExtGState;

/**
 * Feature object for extended graphics state
 *
 * @author Maksim Bezrukov
 */
public class GFExtGStateFeaturesObject implements IFeaturesObject {

    private static final String ID = "id";

    private PDExtGState exGState;
    private String id;
    private String fontChildID;

    /**
     * Constructs new extended graphics state feature object
     *
     * @param exGState         PDExtendedGraphicsState which represents extended graphics state for feature report
     * @param id               id of the object
     * @param fontChildID      id of the font child
     */
    public GFExtGStateFeaturesObject(PDExtGState exGState,
                                     String id,
                                     String fontChildID) {
        this.exGState = exGState;
        this.id = id;
        this.fontChildID = fontChildID;
    }

    /**
     * @return EXT_G_STATE instance of the FeaturesObjectTypesEnum enumeration
     */
    @Override
    public FeatureObjectType getType() {
        return FeatureObjectType.EXT_G_STATE;
    }

    /**
     * Reports all features from the object into the collection
     *
     * @param collection collection for feature report
     * @return FeatureTreeNode class which represents a root node of the constructed collection tree
     * @throws FeatureParsingException occurs when wrong features tree node constructs
     */
    @Override
    public FeatureTreeNode reportFeatures(FeatureExtractionResult collection) throws FeatureParsingException {
        if (exGState != null && !exGState.empty()) {
            FeatureTreeNode root = FeatureTreeNode.createRootNode("graphicsState");

            if (id != null) {
                root.setAttribute(ID, this.id);
            }

            Boolean alphaSourceFlag = exGState.getAlphaSourceFlag();
            if (alphaSourceFlag != null) {
                root.addChild("transparency").setValue(String.valueOf(!alphaSourceFlag.booleanValue()));
            }
            Boolean automaticStrokeAdjustment = exGState.getAutomaticStrokeAdjustment();
            if (automaticStrokeAdjustment != null) {
                root.addChild("strokeAdjustment").setValue(String.valueOf(automaticStrokeAdjustment.booleanValue()));
            }
            Boolean strokingOverprintControl = exGState.getStrokingOverprintControl();
            if (strokingOverprintControl != null) {
                root.addChild("overprintForStroke").setValue(String.valueOf(strokingOverprintControl.booleanValue()));
            }
            Boolean nonStrokingOverprintControl = exGState.getNonStrokingOverprintControl();
            if (nonStrokingOverprintControl != null) {
                root.addChild("overprintForFill").setValue(String.valueOf(nonStrokingOverprintControl.booleanValue()));
            }

            if (fontChildID != null) {
                FeatureTreeNode resources = root.addChild("resources");
                FeatureTreeNode fonts = resources.addChild("fonts");
                FeatureTreeNode font = fonts.addChild("font");
                font.setAttribute(ID, fontChildID);
            }

            collection.addNewFeatureTree(FeatureObjectType.EXT_G_STATE, root);
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
