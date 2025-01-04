/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2025, veraPDF Consortium <info@verapdf.org>
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

import org.verapdf.cos.COSInteger;
import org.verapdf.model.coslayer.CosInteger;

/**
 * @author Timur Kamalov
 */
public class GFCosInteger extends GFCosNumber implements CosInteger {

    /** Type name for GFCosInteger */
    public static final String COS_INTEGER_TYPE = "CosInteger";

    /**
     * Default constructor
     * @param value greenfield COSInteger
     */
    public GFCosInteger(COSInteger value) {
        super(value, COS_INTEGER_TYPE);
    }

}
