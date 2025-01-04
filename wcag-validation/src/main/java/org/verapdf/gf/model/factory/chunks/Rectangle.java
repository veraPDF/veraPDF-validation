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

import org.verapdf.wcag.algorithms.entities.content.LineChunk;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Maxim Plushchov
 */
public class Rectangle {

    private final Integer pageNumber;
    private final double x;
    private final double y;
    private final double width;
    private final double height;

    public Rectangle(Integer pageNumber, double x, double y, double width, double height) {
        this.pageNumber = pageNumber;
        this.x = width < 0 ? x + width : x;
        this.y = height < 0 ? y + height : y;
        this.width = Math.abs(width);
        this.height = Math.abs(height);
    }

    public List<LineChunk> getLines(double lineWidth) {
        List<LineChunk> lines = new LinkedList<>();
        lines.add(new LineChunk(pageNumber, x, y, x + width, y, lineWidth));
        lines.add(new LineChunk(pageNumber, x, y, x, y + height, lineWidth));
        lines.add(new LineChunk(pageNumber, x + width, y, x + width, y + height, lineWidth));
        lines.add(new LineChunk(pageNumber, x, y + height, x + width, y + height, lineWidth));
        return lines;
    }

    public LineChunk getLine(double lineWidth) {
        if (width < height) {
            double lineX = x + 0.5 * width;
            return new LineChunk(pageNumber, lineX, y + 0.5 * width, lineX, y + height - 0.5 * width,
                    width + lineWidth);
        }
        double lineY = y + 0.5 * height;
        return new LineChunk(pageNumber, x + 0.5 * height, lineY, x + width - 0.5 * height, lineY,
                height + lineWidth);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return (x + " " + y + " " + width + " " + height).replace(".", ",");
    }

}
