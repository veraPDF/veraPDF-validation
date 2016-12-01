package org.verapdf.features.gf.objects;

import org.verapdf.core.FeatureParsingException;
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
        if (encryption != null) {
            FeatureTreeNode root = FeatureTreeNode.createRootNode("documentSecurity");
            GFCreateNodeHelper.addNotEmptyNode("filter", encryption.getFilter(), root);
            GFCreateNodeHelper.addNotEmptyNode("subFilter", encryption.getSubFilter(), root);
            GFCreateNodeHelper.addNotEmptyNode("version", String.valueOf(encryption.getV()), root);
            GFCreateNodeHelper.addNotEmptyNode("length", String.valueOf(encryption.getLength()), root);

            String ownerKey = encryption.getO().getHexString();
            GFCreateNodeHelper.addNotEmptyNode("ownerKey", ownerKey, root);

            String userKey = encryption.getU().getHexString();
            GFCreateNodeHelper.addNotEmptyNode("userKey", userKey, root);

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
