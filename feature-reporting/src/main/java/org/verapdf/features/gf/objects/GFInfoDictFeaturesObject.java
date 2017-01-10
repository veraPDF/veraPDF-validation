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

import org.verapdf.as.ASAtom;
import org.verapdf.core.FeatureParsingException;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.features.FeatureExtractionResult;
import org.verapdf.features.FeatureObjectType;
import org.verapdf.features.FeaturesData;
import org.verapdf.features.IFeaturesObject;
import org.verapdf.features.gf.tools.GFCreateNodeHelper;
import org.verapdf.features.tools.FeatureTreeNode;
import org.verapdf.tools.TypeConverter;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Set;
import java.util.TreeSet;

/**
 * Feature object for information dictionary
 *
 * @author Maksim Bezrukov
 */
public class GFInfoDictFeaturesObject implements IFeaturesObject {

    private static final ASAtom[] predefinedKeys = {
            ASAtom.TITLE,
            ASAtom.AUTHOR,
            ASAtom.SUBJECT,
            ASAtom.KEYWORDS,
            ASAtom.CREATOR,
            ASAtom.PRODUCER,
            ASAtom.CREATION_DATE,
            ASAtom.MOD_DATE,
            ASAtom.TRAPPED
    };

    private static final String ENTRY = "entry";
    private static final String KEY = "key";

    private COSObject info;

    /**
     * Constructs new information dictionary feature object.
     *
     * @param info class represents page object
     */
    public GFInfoDictFeaturesObject(COSObject info) {
        this.info = info;
    }

    /**
     * @return INFORMATION_DICTIONARY instance of the FeatureObjectType enumeration
     */
    @Override
    public FeatureObjectType getType() {
        return FeatureObjectType.INFORMATION_DICTIONARY;
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

        if (info != null && info.getType() == COSObjType.COS_DICT) {
            FeatureTreeNode root = FeatureTreeNode.createRootNode("informationDict");

            addEntry("Title", info.getStringKey(ASAtom.TITLE), root);
            addEntry("Author", info.getStringKey(ASAtom.AUTHOR), root);
            addEntry("Subject", info.getStringKey(ASAtom.SUBJECT), root);
            addEntry("Keywords", info.getStringKey(ASAtom.KEYWORDS), root);
            addEntry("Creator", info.getStringKey(ASAtom.CREATOR), root);
            addEntry("Producer", info.getStringKey(ASAtom.PRODUCER), root);

            String crDate = info.getStringKey(ASAtom.CREATION_DATE);
            if (crDate != null) {
                Calendar crDateCal = TypeConverter.parseDate(crDate);
                FeatureTreeNode creationDate = GFCreateNodeHelper.createDateNode(ENTRY, root, crDateCal, collection);
                if (creationDate != null) {
                    creationDate.setAttribute(KEY, "CreationDate");
                }
            }

            String mdDate = info.getStringKey(ASAtom.MOD_DATE);
            if (mdDate != null) {
                Calendar mdDateCal = TypeConverter.parseDate(mdDate);
                FeatureTreeNode modDate = GFCreateNodeHelper.createDateNode(ENTRY, root, mdDateCal, collection);
                if (modDate != null) {
                    modDate.setAttribute(KEY, "ModDate");
                }
            }

            addEntry("Trapped", info.getNameKey(ASAtom.TRAPPED), root);

            Set<ASAtom> keys = new TreeSet<>(info.getKeySet());
            keys.removeAll(Arrays.asList(predefinedKeys));
            for (ASAtom key : keys) {
                addEntry(key.getValue(), info.getStringKey(key), root);
            }

            collection.addNewFeatureTree(FeatureObjectType.INFORMATION_DICTIONARY, root);

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

    private static void addEntry(String name, ASAtom value, FeatureTreeNode root) throws FeatureParsingException {
        if (value != null) {
            addEntry(name, value.getValue(), root);
        }
    }

    private static void addEntry(String name, String value, FeatureTreeNode root) throws FeatureParsingException {
        if (name != null && value != null) {
            FeatureTreeNode entry = root.addChild(ENTRY);
            entry.setValue(value);
            entry.setAttribute(KEY, name);
        }
    }
}
