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
package org.verapdf.gf.model.impl.operator.pathpaint;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.factory.colors.ColorSpaceFactory;
import org.verapdf.gf.model.factory.operators.GraphicState;
import org.verapdf.gf.model.impl.operator.base.GFOperator;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.OpPathPaint;
import org.verapdf.pd.colors.PDColorSpace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Timur Kamalov
 */
public abstract class GFOpPathPaint extends GFOperator implements OpPathPaint {

	/** Name of link to the stroke color space */
    public static final String STROKE_CS = "strokeCS";
	/** Name of link to the fill color space */
    public static final String FILL_CS = "fillCS";

	protected org.verapdf.model.pdlayer.PDColorSpace fillCS;
	protected org.verapdf.model.pdlayer.PDColorSpace strokeCS;

	private final boolean isProcessColorOperators;

	protected GFOpPathPaint(List<COSBase> arguments, boolean isProcessColorOperators, final String operatorType) {
		super(arguments, operatorType);
		this.isProcessColorOperators = isProcessColorOperators;
	}

	protected List<org.verapdf.model.pdlayer.PDColorSpace> getFillCS() {
		if (this.fillCS != null && isProcessColorOperators) {
			List<org.verapdf.model.pdlayer.PDColorSpace> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(fillCS);
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	protected List<org.verapdf.model.pdlayer.PDColorSpace> getStrokeCS() {
		if (this.strokeCS != null && isProcessColorOperators) {
			List<org.verapdf.model.pdlayer.PDColorSpace> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(strokeCS);
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	public org.verapdf.model.pdlayer.PDColorSpace getVeraFillCS() {
		return this.fillCS;
	}

	public org.verapdf.model.pdlayer.PDColorSpace getVeraStrokeCS() {
		return this.strokeCS;
	}

	protected org.verapdf.model.pdlayer.PDColorSpace getColorSpace(GraphicState inheritedGraphicState, 
																 PDResourcesHandler resourcesHandler, 
																 PDColorSpace rawColorSpace, boolean op) {
		return ColorSpaceFactory.getColorSpace(rawColorSpace, resourcesHandler, inheritedGraphicState.getOpm(), op, 
				inheritedGraphicState);
	}

}
