/**
 * This file is part of veraPDF Feature Reporting, a module of the veraPDF project.
 * Copyright (c) 2015-2024, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Feature Reporting is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Feature Reporting as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Feature Reporting as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.features.gf;

import org.junit.Assert;
import org.junit.Test;
import org.verapdf.features.FeatureExtractionResult;
import org.verapdf.features.FeatureExtractorConfig;
import org.verapdf.features.FeatureFactory;
import org.verapdf.features.FeatureObjectType;
import org.verapdf.features.tools.FeatureTreeNode;
import org.verapdf.pd.PDDocument;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
/**
 * @author Sergey Shemyakov
 */
public class FeatureTester {

    private static final Map<String, FeatureObjectType> FILE_NAME_TYPE_MAP = new HashMap<>();
    private static final String DIR_PATH = "src/test/resources/objects/";

    static {
        FILE_NAME_TYPE_MAP.put("Annotations", FeatureObjectType.ANNOTATION);
        FILE_NAME_TYPE_MAP.put("ColorSpaces", FeatureObjectType.COLORSPACE);
        FILE_NAME_TYPE_MAP.put("Font", FeatureObjectType.FONT);
        FILE_NAME_TYPE_MAP.put("Forms", FeatureObjectType.FORM_XOBJECT);
        FILE_NAME_TYPE_MAP.put("InfoDictionary", FeatureObjectType.INFORMATION_DICTIONARY);
        FILE_NAME_TYPE_MAP.put("Outlines", FeatureObjectType.OUTLINES);
        FILE_NAME_TYPE_MAP.put("Pages", FeatureObjectType.PAGE);
        FILE_NAME_TYPE_MAP.put("ICC_CMYK", FeatureObjectType.ICCPROFILE);
        FILE_NAME_TYPE_MAP.put("ICC_GRAY", FeatureObjectType.ICCPROFILE);
        FILE_NAME_TYPE_MAP.put("ICC_RGB", FeatureObjectType.ICCPROFILE);
    }

    @Test
    public void testFeatures() throws IOException {
        for (String type : FILE_NAME_TYPE_MAP.keySet()) {
            testFeaturesWithType(type);
        }
    }

    private static void testFeaturesWithType(String type) throws IOException {
        FeatureExtractionResult extractionResult = extractFeatures(type);
        Set<String> obtainedNodeSet = getFeatureTreeNodesStringList(extractionResult,
                FILE_NAME_TYPE_MAP.get(type));
        Assert.assertEquals(loadTreeNodeSetForType(type), obtainedNodeSet);
    }

    private static FeatureExtractionResult extractFeatures(String type)
            throws IOException {
        FeatureExtractorConfig config = FeatureFactory.configFromValues(
                EnumSet.of(FILE_NAME_TYPE_MAP.get(type)));
        PDDocument document = new PDDocument(DIR_PATH + "pdf/" + type + ".pdf");
        return GFFeatureParser.getFeaturesCollection(document, config);
    }

    private static Set<String> getFeatureTreeNodesStringList(
            FeatureExtractionResult res, FeatureObjectType type) {
        Set<String> strings = new HashSet<>();
        List<FeatureTreeNode> nodes = res.getFeatureTreesForType(type);
        for (FeatureTreeNode node : nodes) {
            addToStringSet(node, strings);
        }
        return strings;
    }

    private static void addToStringSet(FeatureTreeNode node, Set<String> strings) {
        if (!node.getAttributes().containsKey("id")) {
            strings.add(node.toString());
        } else {
            Map<String, String> attrWithoutID = new HashMap<>(node.getAttributes());
            attrWithoutID.remove("id");
            String nodeVal = "FeatureTreeNode [name=" + node.getName() + ", value="
                    + node.getValue() + ", isMetadataNode=" + node.isMetadataNode()
                    + ", " + ", attributes=" + attrWithoutID + ']';
            strings.add(nodeVal);
        }
        for (FeatureTreeNode child : node.getChildren()) {
            addToStringSet(child, strings);
        }
    }

    private static Set<String> loadTreeNodeSetForType(String type) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(DIR_PATH + "results/" + type + ".txt"));
        Set<String> res = new HashSet<>();
        while (scanner.hasNext()) {
            res.add(scanner.nextLine().replace("\\r", "\r"));
        }
        return res;
    }
}
