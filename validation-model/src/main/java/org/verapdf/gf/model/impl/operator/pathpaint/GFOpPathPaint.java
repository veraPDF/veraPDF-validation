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

	private List<org.verapdf.model.pdlayer.PDColorSpace> fillCS = null;
	private List<org.verapdf.model.pdlayer.PDColorSpace> strokeCS = null;

    protected GFOpPathPaint(List<COSBase> arguments, final GraphicState state,
							final PDResourcesHandler resourcesHandler, final String operatorType) {
		this(arguments, state.getFillColorSpace(), state.getStrokeColorSpace(),
				state.getOpm(), state.isOverprintingFlagStroke(), state.isOverprintingFlagNonStroke(),
				resourcesHandler, operatorType);
    }

	protected GFOpPathPaint(List<COSBase> arguments,
							final PDColorSpace rawFillColorSpace, final PDColorSpace rawStrokeColorSpace,
							int opm, boolean overprintingFlagStroke, boolean overprintingFlagNonStroke,
							final PDResourcesHandler resourcesHandler, final String operatorType) {
		super(arguments, operatorType);
		this.rawFillColorSpace = rawFillColorSpace;
		this.rawStrokeColorSpace = rawStrokeColorSpace;
		this.opm = opm;
		this.overprintingFlagStroke = overprintingFlagStroke;
		this.overprintingFlagNonStroke = overprintingFlagNonStroke;
		this.resourcesHandler = resourcesHandler;
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
				ColorSpaceFactory.getColorSpace(rawColorSpace, this.resourcesHandler, this.opm, op);
		if (veraColorSpace != null) {
			List<org.verapdf.model.pdlayer.PDColorSpace> list =	new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(veraColorSpace);
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

}
