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

	private final PDColorSpace rawFillColorSpace;
	private final PDColorSpace rawStrokeColorSpace;

	private final int opm;
	private final boolean overprintingFlagStroke;
	private final boolean overprintingFlagNonStroke;

	private final PDResourcesHandler resourcesHandler;
	private final GraphicState inheritedGraphicState;

	private List<org.verapdf.model.pdlayer.PDColorSpace> fillCS = null;
	private List<org.verapdf.model.pdlayer.PDColorSpace> strokeCS = null;

    protected GFOpPathPaint(List<COSBase> arguments, final GraphicState state,
							final PDResourcesHandler resourcesHandler, final String operatorType) {
		this(arguments, state.getFillColorSpace(), state.getStrokeColorSpace(),
				state.getOpm(), state.isOverprintingFlagStroke(), state.isOverprintingFlagNonStroke(),
				resourcesHandler, operatorType, state);
    }

	protected GFOpPathPaint(List<COSBase> arguments,
							final PDColorSpace rawFillColorSpace, final PDColorSpace rawStrokeColorSpace,
							int opm, boolean overprintingFlagStroke, boolean overprintingFlagNonStroke,
							final PDResourcesHandler resourcesHandler, final String operatorType,
							GraphicState inheritedGraphicState) {
		super(arguments, operatorType);
		this.rawFillColorSpace = rawFillColorSpace;
		this.rawStrokeColorSpace = rawStrokeColorSpace;
		this.opm = opm;
		this.overprintingFlagStroke = overprintingFlagStroke;
		this.overprintingFlagNonStroke = overprintingFlagNonStroke;
		this.resourcesHandler = resourcesHandler;
		this.inheritedGraphicState = inheritedGraphicState;
	}

	protected List<org.verapdf.model.pdlayer.PDColorSpace> getFillCS() {
		if (this.fillCS == null) {
			this.fillCS = getColorSpace(this.rawFillColorSpace, this.overprintingFlagNonStroke);
		}
		return this.fillCS;
	}

	protected List<org.verapdf.model.pdlayer.PDColorSpace> getStrokeCS() {
		if (this.strokeCS == null) {
			this.strokeCS = getColorSpace(this.rawStrokeColorSpace, this.overprintingFlagStroke);
		}
		return this.strokeCS;
	}

	public org.verapdf.model.pdlayer.PDColorSpace getVeraFillCS() {
		if (this.fillCS == null) {
			this.fillCS = getColorSpace(this.rawFillColorSpace, this.overprintingFlagNonStroke);
		}
		return this.fillCS.isEmpty() ? null : this.fillCS.get(0);
	}

	public org.verapdf.model.pdlayer.PDColorSpace getVeraStrokeCS() {
		if (this.strokeCS == null) {
			this.strokeCS = getColorSpace(this.rawStrokeColorSpace, this.overprintingFlagStroke);
		}
		return this.strokeCS.isEmpty() ? null : this.strokeCS.get(0);
	}

	private List<org.verapdf.model.pdlayer.PDColorSpace> getColorSpace(PDColorSpace rawColorSpace, boolean op) {
		org.verapdf.model.pdlayer.PDColorSpace veraColorSpace =
				ColorSpaceFactory.getColorSpace(rawColorSpace, this.resourcesHandler, this.opm, op, inheritedGraphicState);
		if (veraColorSpace != null) {
			List<org.verapdf.model.pdlayer.PDColorSpace> list =	new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(veraColorSpace);
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

}
