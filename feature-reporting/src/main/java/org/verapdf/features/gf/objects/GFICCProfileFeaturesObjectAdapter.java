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
        if (this.profile != null && !this.profile.empty()) {
            try (ASInputStream iccData = this.profile.getObject().getData(COSStream.FilterFlags.DECODE)) {
                this.errors = new ArrayList<>();
                byte[] profileBytes = GFAdapterHelper.inputStreamToByteArray(iccData);

                if (profileBytes.length < HEADER_SIZE) {
                    this.errors.add("ICCProfile contains less than " + HEADER_SIZE + " bytes");
                } else {
                    this.version = getVersion(profileBytes);
                    this.cmmType = this.profile.getCMMType();
                    this.dataColorSpace = this.profile.getColorSpace();
                    this.creator = this.profile.getCreator();
                    this.creationDate = this.profile.getCreationDate();
                    this.defaultRenderingIntent = this.profile.getRenderingIntent();
                    this.copyright = this.profile.getCopyright();
                    this.description = this.profile.getDescription();
                    this.profileID = this.profile.getProfileID();
                    this.deviceModel = this.profile.getDeviceModel();
                    this.deviceManufacturer = this.profile.getDeviceManufacturer();
                }

            } catch (IOException e) {
                LOGGER.log(Level.FINE, "Reading byte array from InputStream error", e);
                this.errors.add(e.getMessage());
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
        return this.id;
    }

    @Override
    public String getVersion() {
        return this.version;
    }

    @Override
    public String getCMMType() {
        return this.cmmType;
    }

    @Override
    public String getDataColorSpace() {
        return this.dataColorSpace;
    }

    @Override
    public String getCreator() {
        return this.creator;
    }

    @Override
    public Calendar getCreationDate() {
        return this.creationDate;
    }

    @Override
    public String getDefaultRenderingIntent() {
        return this.defaultRenderingIntent;
    }

    @Override
    public String getCopyright() {
        return this.copyright;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getProfileID() {
        return this.profileID;
    }

    @Override
    public String getDeviceModel() {
        return this.deviceModel;
    }

    @Override
    public String getDeviceManufacturer() {
        return this.deviceManufacturer;
    }

    @Override
    public boolean isPDFObjectPresent() {
        return this.profile != null && !this.profile.empty();
    }

    @Override
    public List<String> getErrors() {
        return this.errors == null ? Collections.<String>emptyList() : Collections.unmodifiableList(this.errors);
    }

    @Override
    public InputStream getMetadataStream() {
        if (this.profile != null && !this.profile.empty()) {
            PDMetadata meta = this.profile.getMetadata();
            if (meta != null) {
                return meta.getStream();
            }
        }
        return null;
    }

    @Override
    public InputStream getData() {
        if (this.profile != null && !this.profile.empty()) {
            return this.profile.getObject().getData(COSStream.FilterFlags.DECODE);
        }
        return null;
    }

    @Override
    public Integer getN() {
        if (this.profile != null && !this.profile.empty()) {
            Long n = this.profile.getNumberOfColorants();
            return n == null ? null : Integer.valueOf(n.intValue());
        }
        return null;
    }

    @Override
    public List<Double> getRange() {
        if (this.profile != null && !this.profile.empty()) {
            List<Double> range = new ArrayList<>();
            double[] profileRange = this.profile.getRange();
            if (profileRange != null) {
                for (double value : profileRange) {
                    range.add(Double.valueOf(value));
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
