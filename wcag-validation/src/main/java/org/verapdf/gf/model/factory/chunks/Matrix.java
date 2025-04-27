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

import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSBase;
import org.verapdf.wcag.algorithms.entities.geometry.BoundingBox;
import org.verapdf.wcag.algorithms.entities.geometry.Vertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Maxim Plushchov
 */
public class Matrix implements Cloneable {

	private static final int SIZE = 6;
	private double[] matrixArray;

	public Matrix() {
		matrixArray = new double[] {1, 0, 0, 1, 0, 0};
	}

	public Matrix(double[] src) {
		matrixArray = src;
	}

	public Matrix(COSArray array) {
		matrixArray = new double[SIZE];
		matrixArray[0] = array.at(0).getReal();
		matrixArray[1] = array.at(1).getReal();
		matrixArray[2] = array.at(2).getReal();
		matrixArray[3] = array.at(3).getReal();
		matrixArray[4] = array.at(4).getReal();
		matrixArray[5] = array.at(5).getReal();
	}

	public Matrix(List<COSBase> arguments) {
		matrixArray = new double[SIZE];
		matrixArray[0] = arguments.get(0).getReal();
		matrixArray[1] = arguments.get(1).getReal();
		matrixArray[2] = arguments.get(2).getReal();
		matrixArray[3] = arguments.get(3).getReal();
		matrixArray[4] = arguments.get(4).getReal();
		matrixArray[5] = arguments.get(5).getReal();
	}

	public Matrix(double a, double b, double c, double d, double e, double f) {
		matrixArray = new double[SIZE];
		matrixArray[0] = a;
		matrixArray[1] = b;
		matrixArray[2] = c;
		matrixArray[3] = d;
		matrixArray[4] = e;
		matrixArray[5] = f;
	}

	public double getValue(int row, int column) {
		return matrixArray[row * 2 + column];
	}

	public void concatenate(Matrix matrix) {
		matrixArray = checkDoubleValues(multiplyArrays(matrix.matrixArray, matrixArray));
	}

	public void translate(double tx, double ty) {
		matrixArray[4] += tx * matrixArray[0] + ty * matrixArray[2];
		matrixArray[5] += tx * matrixArray[1] + ty * matrixArray[3];
		checkDoubleValues(matrixArray);
	}

	public void scale(double sx, double sy) {
		matrixArray[0] *= sx;
		matrixArray[1] *= sx;
		matrixArray[2] *= sy;
		matrixArray[3] *= sy;
		checkDoubleValues(matrixArray);
	}

	public void rotate(double theta) {
		concatenate(Matrix.getRotateInstance(theta, 0, 0));
	}

	public Matrix multiply(Matrix other) {
		return new Matrix(checkDoubleValues(multiplyArrays(matrixArray, other.matrixArray)));
	}

	private double[] checkDoubleValues(double[] values) {
		if (!Double.isFinite(values[0]) || !Double.isFinite(values[1]) || !Double.isFinite(values[2])
				|| !Double.isFinite(values[3]) || !Double.isFinite(values[4]) || !Double.isFinite(values[5])) {
			throw new IllegalArgumentException("Multiplication of two matrices gives invalid values");
		}
		return values;
	}

	private double[] multiplyArrays(double[] a, double[] b) {
		double[] c = new double[SIZE];
		c[0] = a[0] * b[0] + a[1] * b[2];
		c[1] = a[0] * b[1] + a[1] * b[3];
		c[2] = a[2] * b[0] + a[3] * b[2];
		c[3] = a[2] * b[1] + a[3] * b[3];
		c[4] = a[4] * b[0] + a[5] * b[2] + b[4];
		c[5] = a[4] * b[1] + a[5] * b[3] + b[5];
		return c;
	}

	public static Matrix getScaleInstance(double x, double y) {
		return new Matrix(x, 0, 0, y, 0, 0);
	}

	public static Matrix getTranslateInstance(double x, double y) {
		return new Matrix(1, 0, 0, 1, x, y);
	}

	public static Matrix getRotateInstance(double theta, double tx, double ty) {
		double cosTheta = Math.cos(theta);
		double sinTheta = Math.sin(theta);

		return new Matrix(cosTheta, sinTheta, -sinTheta, cosTheta, tx, ty);
	}

	public static Matrix concatenate(Matrix a, Matrix b) {
		return b.multiply(a);
	}

	@Override
	public Matrix clone() {
		return new Matrix(matrixArray.clone());
	}

	public double getScaleX() {
		return matrixArray[0];
	}

	public double getShearY() {
		return matrixArray[1];
	}

	public double getShearX() {
		return matrixArray[2];
	}

	public double getScaleY() {
		return matrixArray[3];
	}

	public double getTranslateX() {
		return matrixArray[4];
	}

	public double getTranslateY() {
		return matrixArray[5];
	}

	public BoundingBox transformBoundingBox(BoundingBox boundingBox) {
		List<Double> xCoordinates = new ArrayList<>(4);
		xCoordinates.add(transformX(boundingBox.getLeftX(), boundingBox.getBottomY()));
		xCoordinates.add(transformX(boundingBox.getRightX(), boundingBox.getBottomY()));
		xCoordinates.add(transformX(boundingBox.getLeftX(), boundingBox.getTopY()));
		xCoordinates.add(transformX(boundingBox.getRightX(), boundingBox.getTopY()));
		List<Double> yCoordinates = new ArrayList<>(4);
		yCoordinates.add(transformY(boundingBox.getLeftX(), boundingBox.getBottomY()));
		yCoordinates.add(transformY(boundingBox.getRightX(), boundingBox.getBottomY()));
		yCoordinates.add(transformY(boundingBox.getLeftX(), boundingBox.getTopY()));
		yCoordinates.add(transformY(boundingBox.getRightX(), boundingBox.getTopY()));
		xCoordinates.sort(Double::compare);
		yCoordinates.sort(Double::compare);
		return new BoundingBox(boundingBox.getPageNumber(), xCoordinates.get(0), yCoordinates.get(0),
				xCoordinates.get(3), yCoordinates.get(3));
	}

	public double transformX(double x, double y) {
		return x * getScaleX() + y * getShearX() + getTranslateX();
	}

	public double transformY(double x, double y) {
		return x * getShearY() + y * getScaleY() + getTranslateY();
	}

	public Vertex transformVertex(Vertex v) {
		return new Vertex(v.getPageNumber(), transformX(v.getX(), v.getY()), transformY(v.getX(), v.getY()));
	}

	public double getRotationDegree() {
		return Math.toDegrees(Math.atan2(getShearY(), getScaleX()));
	}
	
	public double getScaleValue() {
		return Math.max(Math.sqrt(getScaleY() * getScaleY() + getShearX() * getShearX()),
				Math.sqrt(getScaleX() * getScaleX() + getShearY() * getShearY()));
	}

	@Override
	public String toString() {
		return "[" +
		       matrixArray[0] + ',' +
		       matrixArray[1] + ',' +
		       matrixArray[2] + ',' +
		       matrixArray[3] + ',' +
		       matrixArray[4] + ',' +
		       matrixArray[5] + ']';
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(matrixArray);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		return Arrays.equals(this.matrixArray, ((Matrix) obj).matrixArray);
	}

}
