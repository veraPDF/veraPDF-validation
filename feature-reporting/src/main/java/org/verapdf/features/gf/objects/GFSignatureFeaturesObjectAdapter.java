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

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSString;
import org.verapdf.features.objects.SignatureFeaturesObjectAdapter;
import org.verapdf.pd.PDSignature;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * Features object adapter for digital signature.
 *
 * @author Sergey Shemyakov
 */
public class GFSignatureFeaturesObjectAdapter implements SignatureFeaturesObjectAdapter {

    private final PDSignature signature;

    public GFSignatureFeaturesObjectAdapter(PDSignature signature) {
        this.signature = signature;
    }

    @Override
    public InputStream getData() {
        if (signature != null && !signature.empty()) {
            COSString contents = signature.getContents();
            return contents == null ? null :
                    new ByteArrayInputStream(contents.get());
        }
        return null;
    }

    @Override
    public String getFilter() {
        if (signature != null && !signature.empty()) {
            ASAtom filter = signature.getFilter();
            return filter == null ? null : filter.getValue();
        }
        return null;
    }

    @Override
    public String getSubFilter() {
        if (signature != null && !signature.empty()) {
            ASAtom subfilter = signature.getSubfilter();
            return subfilter == null ? null : subfilter.getValue();
        }
        return null;
    }

    @Override
    public String getHexContents() {
        if (signature != null && !signature.empty()) {
            COSString contents = signature.getContents();
            if (contents != null) {
                return contents.getHexString();
            }
        }
        return null;
    }

    @Override
    public String getName() {
        if (signature != null && !signature.empty()) {
            return signature.getName();
        }
        return null;
    }

    @Override
    public Calendar getSignDate() {
        if (signature != null && !signature.empty()) {
            return signature.getSignDate();
        }
        return null;
    }

    @Override
    public String getLocation() {
        if (signature != null && !signature.empty()) {
            return signature.getLocation();
        }
        return null;
    }

    @Override
    public String getReason() {
        if (signature != null && !signature.empty()) {
            return signature.getReason();
        }
        return null;
    }

    @Override
    public String getContactInfo() {
        if (signature != null && !signature.empty()) {
            ASAtom filter = signature.getFilter();
            return filter == null ? null : filter.getValue();
        }
        return null;
    }

    @Override
    public boolean isPDFObjectPresent() {
        return signature != null && !signature.empty();
    }

    @Override
    public List<String> getErrors() {
        return Collections.emptyList();
    }
}
