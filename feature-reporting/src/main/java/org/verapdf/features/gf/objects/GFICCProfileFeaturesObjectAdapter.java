/**
 * This file is part of veraPDF Feature Reporting, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
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
package org.verapdf.features.gf.objects;

import org.verapdf.as.io.ASInputStream;
import org.verapdf.cos.COSStream;
import org.verapdf.external.ICCProfile;
import org.verapdf.features.gf.tools.GFAdapterHelper;
import org.verapdf.features.objects.ICCProfileFeaturesObjectAdapter;
import org.verapdf.pd.PDMetadata;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Feature object for icc profile
 *
 * @author Maksim Bezrukov
 */
public class GFICCProfileFeaturesObjectAdapter implements ICCProfileFeaturesObjectAdapter {

    private static final Logger LOGGER = Logger.getLogger(GFICCProfileFeaturesObjectAdapter.class.getCanonicalName());

    private static final int HEADER_SIZE = 128;
    private static final int FF_FLAG = 0xFF;
    private static final int REQUIRED_LENGTH = 4;
    private static final int VERSION_BYTE = 8;
    private static final int SUBVERSION_BYTE = 9;

    private ICCProfile profile;
    private String id;
    private String version;
    private String cmmType;
    private String dataColorSpace;
    private String creator;
    private Calendar creationDate;
    private String defaultRenderingIntent;
    private String copyright;
    private String description;
    private String profileID;
    private String deviceModel;
    private String deviceManufacturer;
    private List<String> errors;

    /**
     * Constructs new icc profile feature object
     *
     * @param profile ICCProfile which represents the icc profile for feature report
     * @param id      id of the profile
     */
    public GFICCProfileFeaturesObjectAdapter(ICCProfile profile, String id) {
        this.profile = profile;
        this.id = id;
        init();
    }

    private void init() {
        if (profile != null && !profile.empty()) {
            try (ASInputStream iccData = profile.getObject().getData(COSStream.FilterFlags.DECODE)) {
                errors = new ArrayList<>();
                byte[] profileBytes = GFAdapterHelper.inputStreamToByteArray(iccData);

                if (profileBytes.length < HEADER_SIZE) {
                    errors.add("ICCProfile contains less than " + HEADER_SIZE + " bytes");
                } else {
                    this.version = getVersion(profileBytes);
                    this.cmmType = profile.getCMMType();
                    this.dataColorSpace = profile.getColorSpace();
                    this.creator = profile.getCreator();
                    this.creationDate = profile.getCreationDate();
                    this.defaultRenderingIntent = profile.getRenderingIntent();
                    this.copyright = profile.getCopyright();
                    this.description = profile.getDescription();
                    this.profileID = profile.getProfileID();
                    this.deviceModel = profile.getDeviceModel();
                    this.deviceManufacturer = profile.getDeviceManufacturer();
                }

            } catch (IOException e) {
                LOGGER.log(Level.FINE, "Reading byte array from InputStream error", e);
                errors.add(e.getMessage());
            }
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

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public String getCMMType() {
        return cmmType;
    }

    @Override
    public String getDataColorSpace() {
        return dataColorSpace;
    }

    @Override
    public String getCreator() {
        return creator;
    }

    @Override
    public Calendar getCreationDate() {
        return creationDate;
    }

    @Override
    public String getDefaultRenderingIntent() {
        return defaultRenderingIntent;
    }

    @Override
    public String getCopyright() {
        return copyright;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getProfileID() {
        return profileID;
    }

    @Override
    public String getDeviceModel() {
        return deviceModel;
    }

    @Override
    public String getDeviceManufacturer() {
        return deviceManufacturer;
    }

    @Override
    public boolean isPDFObjectPresent() {
        return profile != null && !profile.empty();
    }

    @Override
    public List<String> getErrors() {
        return errors == null ? Collections.<String>emptyList() : Collections.unmodifiableList(errors);
    }

    @Override
    public InputStream getMetadataStream() {
        if (profile != null && !profile.empty()) {
            PDMetadata meta = profile.getMetadata();
            if (meta != null) {
                return meta.getStream();
            }
        }
        return null;
    }

    @Override
    public InputStream getData() {
        if (profile != null && !profile.empty()) {
            return profile.getObject().getData(COSStream.FilterFlags.DECODE);
        }
        return null;
    }

    @Override
    public Integer getN() {
        if (profile != null && !profile.empty()) {
            Long n = profile.getNumberOfColorants();
            return n == null ? null : n.intValue();
        }
        return null;
    }

    @Override
    public List<Double> getRange() {
        if (profile != null && !profile.empty()) {
            List<Double> range = new ArrayList<>();
            double[] profileRange = profile.getRange();
            if (profileRange != null) {
                for (double value : profileRange) {
                    range.add(value);
                }
            } else {
                Integer n = getN();
                if (n != null) {
                    for (int i = 0; i < n.intValue(); ++i) {
                        range.add(Double.valueOf(0.));
                        range.add(Double.valueOf(1.));
                    }
                }
            }
            return Collections.unmodifiableList(range);
        }
        return Collections.emptyList();
    }
}
