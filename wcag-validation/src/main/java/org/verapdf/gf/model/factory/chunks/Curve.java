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
package org.verapdf.gf.model.factory.chunks;

import org.verapdf.wcag.algorithms.entities.geometry.BoundingBox;

/**
 * @author Maxim Plushchov
 */
public class Curve {

    private final BoundingBox boundingBox;
    private final double x0;
    private final double y0;
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;
    private final double x3;
    private final double y3;

    public Curve(Integer pageNumber, double x0, double y0, double x1, double y1,
                 double x2, double y2, double x3, double y3) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        boundingBox = CurvesHelper.getBoundingBoxForCurveC(pageNumber, x0, y0, x1, y1, x2, y2, x3, y3);
    }

    public Curve(Integer pageNumber, double x0, double y0, double x1, double y1,
                 double x2, double y2, boolean isVOperator) {
        this.x0 = x0;
        this.y0 = y0;
        this.x3 = x2;
        this.y3 = y2;
        if (isVOperator) {

            this.x1 = x0;
            this.y1 = y0;
            this.x2 = x1;
            this.y2 = y1;
            boundingBox = CurvesHelper.getBoundingBoxForCurveV(pageNumber, x0, y0, x1, y1, x2, y2);
        } else {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            boundingBox = CurvesHelper.getBoundingBoxForCurveY(pageNumber, x0, y0, x1, y1, x2, y2);
        }
    }

    public double getX3() {
        return x3;
    }

    public double getY3() {
        return y3;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }
}
