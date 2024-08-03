/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2024, veraPDF Consortium <info@verapdf.org>
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

import org.verapdf.cos.COSName;
import org.verapdf.model.coslayer.CosName;

/**
 * Created by Timur on 4/10/2016.
 */
public class GFCosName extends GFCosObject implements CosName {

    /** Type name for GFCosName */
    public static final String COS_NAME_TYPE = "CosName";

    private final String internalRepresentation;

    /**
     * Default constructor
     * @param cosName greenfield COSName
     */
    public GFCosName(COSName cosName) {
        this(cosName, COS_NAME_TYPE);
    }

    /**
     * Constructor for child classes
     * @param cosName greenfield COSName
     * @param type child class type
     */
    protected GFCosName(COSName cosName, final String type) {
        super(cosName, type);
        this.internalRepresentation = cosName.getString();
    }

    /**
     * Get Unicode string representation of the Name object after applying
     * escape mechanism and converting to Unicode using Utf8 encoding
     */
    @Override
    public String getinternalRepresentation() {
        return this.internalRepresentation;
    }

}
