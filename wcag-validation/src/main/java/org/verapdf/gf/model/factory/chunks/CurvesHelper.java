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
import org.verapdf.wcag.algorithms.entities.geometry.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxim Plushchov
 */
public class CurvesHelper {

	public static BoundingBox getBoundingBoxForCurveC(int pageNumber, Vertex v0, Vertex v1, Vertex v2, Vertex v3) {//use width
		double[] x = getMinAndMaxCurveValues(v0.getX(), v1.getX(), v2.getX(), v3.getX());
		double[] y = getMinAndMaxCurveValues(v0.getY(), v1.getY(), v2.getY(), v3.getY());
		return new BoundingBox(pageNumber, x[0], y[0], x[1], y[1]);
	}

	public static BoundingBox getBoundingBoxForCurveY(int pageNumber, Vertex v0, Vertex v1, Vertex v3) {
		return getBoundingBoxForCurveV(pageNumber, v3, v1, v0);
	}

	public static BoundingBox getBoundingBoxForCurveV(int pageNumber, Vertex v0, Vertex v2, Vertex v3) {
		double x = getExtremumCurveValue(v0.getX(), v2.getX(), v3.getX());
		double y = getExtremumCurveValue(v0.getY(), v2.getY(), v3.getY());
		return new BoundingBox(pageNumber, Math.min(v0.getX(), x), Math.min(v0.getY(), y),
				Math.max(v0.getX(), x), Math.max(v0.getY(), y));
	}

	private static double[] getMinAndMaxCurveValues(double x0, double x1, double x2, double x3) {//rename
		List<Double> values = new ArrayList<>(4);
		values.add(x0);
		values.add(x3);
		double[] solution = getQuadraticSolution(-x0 + 3 * x1 - 3 * x2 + x3, 2 * x0 - 4 * x1 + 2 * x2, x1 - x0);
		for (double t : solution) {
			if (t > 0.0 && t < 1.0) {
				values.add(getCurveValue(t, x0, x1, x2, x3));
			}
		}
		values.sort(Double::compare);
		return new double[]{values.get(0), values.get(values.size() - 1)};
	}

	private static double[] getQuadraticSolution(double a, double b, double c) {
		double D = b * b - 4 * a * c;
		if (D < 0.0) {
			return new double[]{};
		} else if (D == 0.0) {
			return new double[]{-b / (2 * a)};
		}
		D = Math.sqrt(D);
		return new double[] {-(b + D) / (2 * a), -(b - D) / (2 * a)};
	}

	private static double getExtremumCurveValue(double x0, double x2, double x3) {
		double temp1 = 2 * (x0 - x2);
		double temp2 = 2 * x0 - 3 * x2 + x3;
		if (temp1 * temp2 < 0 || Math.abs(temp1) > Math.abs(temp2)) {
			return x3;
		}
		return getCurveValue(temp1 / temp2, x0, x0, x2, x3);
	}

	private static double getCurveValue(double t, double x0, double x1, double x2, double x3) {
		return (1 - t) * (1 - t) * (1 - t) * x0 + 3 * t * (1 - t) * (1 - t) * x1 +
				3 * t * t * (1 - t) * x2 + t * t * t * x3;
	}

}
