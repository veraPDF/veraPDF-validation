/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.cos;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSName;
import org.verapdf.model.coslayer.CosFilter;

/**
 * @author Timur Kamalov
 */
public class GFCosFilter extends GFCosName implements CosFilter {

    public static final String COS_FILTER_TYPE = "CosFilter";

    private static final String IDENTITY = "Identity";
    private static final String CUSTOM = "Custom";
    private static final String DEFAULT = "Default";

    private final String decodeParms;

    public GFCosFilter(final COSName filterName, final COSDictionary decodeParms) {
        super(filterName, COS_FILTER_TYPE);
        if (filterName.getName() == ASAtom.CRYPT) {
            if (decodeParms == null) {
                this.decodeParms = IDENTITY;
            } else {
                this.decodeParms = decodeParms.getStringKey(ASAtom.NAME);
            }
        } else if (decodeParms == null) {
            this.decodeParms = DEFAULT;
        } else {
            this.decodeParms = CUSTOM;
        }
    }

    @Override
    public String getdecodeParms() {
        return this.decodeParms;
    }

}
