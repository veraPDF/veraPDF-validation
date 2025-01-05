/**
 * This file is part of veraPDF WCAG Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2025, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF WCAG Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF WCAG Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF WCAG Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.factory.chunks;

import org.verapdf.wcag.algorithms.entities.content.InfoChunk;
import org.verapdf.wcag.algorithms.entities.geometry.Vertex;

/**
 * @author Maxim Plushchov
 */
public class CurveChunk extends InfoChunk {

    private final Vertex v0;
    private final Vertex v1;
    private final Vertex v2;
    private final Vertex v3;
    private final double width;

    public CurveChunk(Integer pageNumber, Vertex v0, Vertex v1, Vertex v2, Vertex v3, double width) {
        super(CurvesHelper.getBoundingBoxForCurveC(pageNumber, v0, v1, v2, v3, width));
        this.v0 = v0;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.width = width;
    }

    public CurveChunk(Integer pageNumber, Vertex v0, Vertex v1, Vertex v2, double width, boolean isVOperator) {
        this.v0 = v0;
        this.v3 = v2;
        if (isVOperator) {
            this.v1 = v0;
            this.v2 = v1;
            setBoundingBox(CurvesHelper.getBoundingBoxForCurveV(pageNumber, v0, v1, v2, width));
        } else {
            this.v1 = v1;
            this.v2 = v2;
            setBoundingBox(CurvesHelper.getBoundingBoxForCurveY(pageNumber, v0, v1, v2, width));
        }
        this.width = width;
    }

    public double getX3() {
        return v3.getX();
    }

    public double getY3() {
        return v3.getY();
    }

    public static CurveChunk transformCurve(CurveChunk curve, Matrix transformationMatrix, double width) {
        return new CurveChunk(curve.getPageNumber(), transformationMatrix.transformVertex(curve.v0),
                transformationMatrix.transformVertex(curve.v1), transformationMatrix.transformVertex(curve.v2),
                transformationMatrix.transformVertex(curve.v3), width);
    }
}
