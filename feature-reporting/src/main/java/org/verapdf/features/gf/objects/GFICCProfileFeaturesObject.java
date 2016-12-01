package org.verapdf.features.gf.objects;

import org.verapdf.core.FeatureParsingException;
import org.verapdf.cos.COSStream;
import org.verapdf.external.ICCProfile;
import org.verapdf.features.*;
import org.verapdf.features.gf.tools.GFCreateNodeHelper;
import org.verapdf.features.tools.ErrorsHelper;
import org.verapdf.features.tools.FeatureTreeNode;
import org.verapdf.pd.PDMetadata;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Feature object for icc profile
 *
 * @author Maksim Bezrukov
 */
public class GFICCProfileFeaturesObject implements IFeaturesObject {

    private static final Logger LOGGER = Logger.getLogger(GFICCProfileFeaturesObject.class.getCanonicalName());

    private static final String ID = "id";
    private static final int HEADER_SIZE = 128;
    private static final int FF_FLAG = 0xFF;
    private static final int REQUIRED_LENGTH = 4;
    private static final int VERSION_BYTE = 8;
    private static final int SUBVERSION_BYTE = 9;

    private ICCProfile profile;
    private String id;

    /**
     * Constructs new icc profile feature object
     *
     * @param profile ICCProfile which represents the icc profile for feature report
     * @param id      id of the profile
     */
    public GFICCProfileFeaturesObject(ICCProfile profile, String id) {
        this.profile = profile;
        this.id = id;
    }

    /**
     * @return ICCPROFILE instance of the FeaturesObjectTypesEnum enumeration
     */
    @Override
    public FeatureObjectType getType() {
        return FeatureObjectType.ICCPROFILE;
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
        if (profile != null) {
            FeatureTreeNode root = FeatureTreeNode.createRootNode("iccProfile");

            if (id != null) {
                root.setAttribute(ID, id);
            }

            parseProfileHeader(root, collection);
            PDMetadata meta = profile.getMetadata();
            if (meta != null) {
                GFCreateNodeHelper.parseMetadata(meta, "metadata", root, collection);
            }

            collection.addNewFeatureTree(FeatureObjectType.ICCPROFILE, root);
            return root;
        }
        return null;
    }

    /**
     * @return null if it can not get iccProfile stream and features data of the profile in other case.
     */
    @Override
    public FeaturesData getData() {
        InputStream stream = profile.getObject().getData(COSStream.FilterFlags.DECODE);
        InputStream metadata = null;
        PDMetadata meta = profile.getMetadata();
        if (meta != null) {
            metadata = meta.getStream();
        }

        Integer n = null;
        Long profileN = profile.getNumberOfColorants();
        if (profileN != null) {
            n = profileN.intValue();
        }
        List<Double> range = null;
        double[] profileRange = profile.getRange();
        if (profileRange != null) {
            range = new ArrayList<>(profileRange.length);
            for (double value : profileRange) {
                range.add(value);
            }
        }
        return ICCProfileFeaturesData.newInstance(metadata, stream, n, range);
    }

    private void parseProfileHeader(FeatureTreeNode root, FeatureExtractionResult collection) throws FeatureParsingException {
        try {
            byte[] profileBytes = GFCreateNodeHelper.inputStreamToByteArray(profile.getObject().getData(COSStream.FilterFlags.DECODE));

            if (profileBytes.length < HEADER_SIZE) {
                ErrorsHelper.addErrorIntoCollection(collection,
                        root,
                        "ICCProfile contains less than " + HEADER_SIZE + " bytes");
            } else {
                GFCreateNodeHelper.addNotEmptyNode("version", getVersion(profileBytes), root);
                GFCreateNodeHelper.addNotEmptyNode("cmmType", profile.getCMMType(), root);
                GFCreateNodeHelper.addNotEmptyNode("dataColorSpace", profile.getColorSpace(), root);
                GFCreateNodeHelper.addNotEmptyNode("creator", profile.getCreator(), root);
                GFCreateNodeHelper.createDateNode("creationDate", root, profile.getCreationDate(), collection);
                GFCreateNodeHelper.addNotEmptyNode("defaultRenderingIntent", profile.getRenderingIntent(), root);
                GFCreateNodeHelper.addNotEmptyNode("copyright", profile.getCopyright(), root);
                GFCreateNodeHelper.addNotEmptyNode("description", profile.getDescription(), root);
                GFCreateNodeHelper.addNotEmptyNode("profileId", profile.getProfileID(), root);
                GFCreateNodeHelper.addNotEmptyNode("deviceModel", profile.getDeviceModel(), root);
                GFCreateNodeHelper.addNotEmptyNode("deviceManufacturer", profile.getDeviceManufacturer(), root);
            }

        } catch (IOException e) {
            LOGGER.log(Level.FINE, "Reading byte array from InputStream error", e);
            ErrorsHelper.addErrorIntoCollection(collection,
                    root,
                    e.getMessage());
        }
    }

    private static String getVersion(byte[] header) {

        if (header[VERSION_BYTE] == 0 && header[SUBVERSION_BYTE] == 0) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(header[VERSION_BYTE] & FF_FLAG).append(".");
        builder.append((header[SUBVERSION_BYTE] & FF_FLAG) >>> REQUIRED_LENGTH);
        return builder.toString();
    }
}
