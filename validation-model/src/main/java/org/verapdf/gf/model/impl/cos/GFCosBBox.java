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

import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSNumber;
import org.verapdf.model.coslayer.CosBBox;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Timur Kamalov
 */
public class GFCosBBox extends GFCosArray implements CosBBox {

    private static final Logger LOGGER = Logger.getLogger(GFCosBBox.class.getCanonicalName());

    public static final String COS_BBOX_TYPE = "CosBBox";
    private static final int LEFT_CORNER_POSITION = 0;
    private static final int BOTTOM_CORNER_POSITION = 1;
    private static final int RIGHT_CORNER_POSITION = 2;
    private static final int TOP_CORNER_POSITION = 3;

    /**
     * Default constructor
     *
     * @param array greenfield COSArray
     */
    public GFCosBBox(COSArray array) {
        super(array, COS_BBOX_TYPE);
    }

    /**
     * @return top corner of bounding box
     */
    @Override
    public Double gettop() {
        return this.getRequiredValue(TOP_CORNER_POSITION);
    }

    /**
     * @return bottom corner of bounding box
     */
    @Override
    public Double getbottom() {
        return this.getRequiredValue(BOTTOM_CORNER_POSITION);
    }

    /**
     * @return left corner of bounding box
     */
    @Override
    public Double getleft() {
        return this.getRequiredValue(LEFT_CORNER_POSITION);
    }

    /**
     * @return right corner of bounding box
     */
    @Override
    public Double getright() {
        return this.getRequiredValue(RIGHT_CORNER_POSITION);
    }

    private Double getRequiredValue(final int position) {
        COSArray array = (COSArray) this.baseObject;
        if (array.size() > position) {
            COSBase base = array.at(position).get();
            if (base instanceof COSNumber) {
                return base.getReal();
            }
			LOGGER.log(Level.WARNING, "In bbox expected number but got "
			        + base.getClass().getSimpleName());
        } else {
            LOGGER.log(Level.WARNING, "Expected size of bbox array greater than "
                    + position + " but got " + array.size());
        }
        return null;
    }

}