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
import org.verapdf.cos.COSObject;
import org.verapdf.features.objects.PropertiesDictFeaturesObjectAdapter;

import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPropertiesDictFeaturesObjectAdapter implements PropertiesDictFeaturesObjectAdapter {

    private boolean isPresent;
    private String type;
    private String id;

    /**
     * Constructs new propertiesDict features object
     *
     * @param properties    COSDictionary which represents properties for feature report
     * @param id            id of the object
     */
    public GFPropertiesDictFeaturesObjectAdapter(COSObject properties, String id) {
        this.id = id;
        this.isPresent = properties != null && !properties.empty();
        if (properties != null && !properties.empty()) {
            this.type = properties.getNameKeyStringValue(ASAtom.TYPE);
        }
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public boolean isPDFObjectPresent() {
        return isPresent;
    }

    @Override
    public List<String> getErrors() {
        return Collections.emptyList();
    }
}
