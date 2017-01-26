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
import org.verapdf.cos.COSString;
import org.verapdf.features.FeatureExtractionResult;
import org.verapdf.features.FeatureObjectType;
import org.verapdf.features.FeaturesData;
import org.verapdf.features.IFeaturesObject;
import org.verapdf.features.gf.tools.GFCreateNodeHelper;
import org.verapdf.features.tools.FeatureTreeNode;
import org.verapdf.pd.encryption.AccessPermissions;
import org.verapdf.pd.encryption.PDEncryption;

/**
 * Features object for document security.
 *
 * @author Sergey Shemyakov
 */
public class GFDocSecurityFeaturesObject implements IFeaturesObject {

    private PDEncryption encryption;

    public GFDocSecurityFeaturesObject(PDEncryption encryption) {
        this.encryption = encryption;
    }

    @Override
    public FeatureObjectType getType() {
        return FeatureObjectType.DOCUMENT_SECURITY;
    }

    @Override
    public FeatureTreeNode reportFeatures(FeatureExtractionResult collection) throws FeatureParsingException {
        if (encryption != null && !encryption.empty()) {
            FeatureTreeNode root = FeatureTreeNode.createRootNode("documentSecurity");
            GFCreateNodeHelper.addNotEmptyNode("filter", encryption.getFilter(), root);
            GFCreateNodeHelper.addNotEmptyNode("subFilter", encryption.getSubFilter(), root);
            GFCreateNodeHelper.addNotEmptyNode("version", String.valueOf(encryption.getV()), root);
            GFCreateNodeHelper.addNotEmptyNode("length", String.valueOf(encryption.getLength()), root);

            COSString ownerKey = encryption.getO();
            if (ownerKey != null) {
                GFCreateNodeHelper.addNotEmptyNode("ownerKey", ownerKey.getHexString(), root);
            }

            COSString userKey = encryption.getU();
            if (userKey != null) {
                GFCreateNodeHelper.addNotEmptyNode("userKey", userKey.getHexString(), root);
            }

            GFCreateNodeHelper.addNotEmptyNode("encryptMetadata", String.valueOf(encryption.isEncryptMetadata()), root);

            AccessPermissions accessPermissions = encryption.getUserPermissions();
            if (accessPermissions != null) {
                GFCreateNodeHelper.addNotEmptyNode("printAllowed", String.valueOf(accessPermissions.canPrint()), root);
                GFCreateNodeHelper.addNotEmptyNode("printDegradedAllowed", String.valueOf(accessPermissions.canPrintDegraded()), root);
                GFCreateNodeHelper.addNotEmptyNode("changesAllowed", String.valueOf(accessPermissions.canModify()), root);
                GFCreateNodeHelper.addNotEmptyNode("modifyAnnotationsAllowed", String.valueOf(accessPermissions.canModifyAnnotations()), root);
                GFCreateNodeHelper.addNotEmptyNode("fillingSigningAllowed", String.valueOf(accessPermissions.canFillInForm()), root);
                GFCreateNodeHelper.addNotEmptyNode("documentAssemblyAllowed", String.valueOf(accessPermissions.canAssembleDocument()), root);
                GFCreateNodeHelper.addNotEmptyNode("extractContentAllowed", String.valueOf(accessPermissions.canExtractContent()), root);
                GFCreateNodeHelper.addNotEmptyNode("extractAccessibilityAllowed", String.valueOf(accessPermissions.canExtractForAccessibility()), root);
            }

            collection.addNewFeatureTree(FeatureObjectType.DOCUMENT_SECURITY, root);
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
