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
import org.verapdf.cos.COSString;
import org.verapdf.features.objects.DocSecurityFeaturesObjectAdapter;
import org.verapdf.pd.encryption.AccessPermissions;
import org.verapdf.pd.encryption.PDEncryption;

import java.util.Collections;
import java.util.List;

/**
 * Features object adapter for document security.
 *
 * @author Sergey Shemyakov
 */
public class GFDocSecurityFeaturesObjectAdapter implements DocSecurityFeaturesObjectAdapter {

    private PDEncryption encryption;

    public GFDocSecurityFeaturesObjectAdapter(PDEncryption encryption) {
        this.encryption = encryption;
    }

    @Override
    public String getFilter() {
        if (encryption == null || encryption.empty()) {
            return null;
        }
        ASAtom filter = encryption.getFilter();
        return filter == null ? null : filter.getValue();
    }

    @Override
    public String getSubFilter() {
        if (encryption == null || encryption.empty()) {
            return null;
        }
        ASAtom subFilter = encryption.getSubFilter();
        return subFilter == null ? null : subFilter.getValue();
    }

    @Override
    public int getVersion() {
        return encryption == null || encryption.empty() ? 0 : encryption.getV();
    }

    @Override
    public int getLength() {
        return encryption == null || encryption.empty() ? 0 : encryption.getLength();
    }

    @Override
    public String getHexEncodedOwnerKey() {
        if (encryption != null && !encryption.empty()) {
            COSString ownerKey = encryption.getO();
            if (ownerKey != null) {
                return ownerKey.getHexString();
            }
        }
        return null;
    }

    @Override
    public String getHexEncodedUserKey() {
        if (encryption != null && !encryption.empty()) {
            COSString userKey = encryption.getU();
            if (userKey != null) {
                return userKey.getHexString();
            }
        }
        return null;
    }

    @Override
    public boolean isEncryptMetadata() {
        return (encryption == null || encryption.empty()) || encryption.isEncryptMetadata();
    }

    @Override
    public boolean isUserPermissionsPresent() {
        return encryption != null && !encryption.empty() && encryption.getUserPermissions() != null;
    }

    @Override
    public boolean isPrintAllowed() {
        if (encryption != null && !encryption.empty()) {
            AccessPermissions perm = encryption.getUserPermissions();
            return perm == null || perm.canPrint();
        }
        return true;
    }

    @Override
    public boolean isPrintDegradedAllowed() {
        if (encryption != null && !encryption.empty()) {
            AccessPermissions perm = encryption.getUserPermissions();
            return perm == null || perm.canPrintDegraded();
        }
        return true;
    }

    @Override
    public boolean isChangesAllowed() {
        if (encryption != null && !encryption.empty()) {
            AccessPermissions perm = encryption.getUserPermissions();
            return perm == null || perm.canModify();
        }
        return true;
    }

    @Override
    public boolean isModifyAnnotationsAllowed() {
        if (encryption != null && !encryption.empty()) {
            AccessPermissions perm = encryption.getUserPermissions();
            return perm == null || perm.canModifyAnnotations();
        }
        return true;
    }

    @Override
    public boolean isFillingSigningAllowed() {
        if (encryption != null && !encryption.empty()) {
            AccessPermissions perm = encryption.getUserPermissions();
            return perm == null || perm.canFillInForm();
        }
        return true;
    }

    @Override
    public boolean isDocumentAssemblyAllowed() {
        if (encryption != null && !encryption.empty()) {
            AccessPermissions perm = encryption.getUserPermissions();
            return perm == null || perm.canAssembleDocument();
        }
        return true;
    }

    @Override
    public boolean isExtractContentAllowed() {
        if (encryption != null && !encryption.empty()) {
            AccessPermissions perm = encryption.getUserPermissions();
            return perm == null || perm.canExtractContent();
        }
        return true;
    }

    @Override
    public boolean isExtractAccessibilityAllowed() {
        if (encryption != null && !encryption.empty()) {
            AccessPermissions perm = encryption.getUserPermissions();
            return perm == null || perm.canExtractForAccessibility();
        }
        return true;
    }

    @Override
    public boolean isPDFObjectPresent() {
        return encryption != null && !encryption.empty();
    }

    @Override
    public List<String> getErrors() {
        return Collections.emptyList();
    }
}
