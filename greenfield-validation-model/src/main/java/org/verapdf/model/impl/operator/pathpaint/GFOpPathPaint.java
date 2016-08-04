package org.verapdf.model.impl.operator.pathpaint;

import org.verapdf.cos.COSBase;
import org.verapdf.model.factory.operators.GraphicState;
import org.verapdf.model.impl.operator.base.GFOperator;
import org.verapdf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.OpPathPaint;

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

	private final PDResourcesHandler resourcesHandler;

    protected GFOpPathPaint(List<COSBase> arguments, final GraphicState state,
							final PDResourcesHandler resourcesHandler, final String operatorType) {
		this(arguments, resourcesHandler, operatorType);
    }

	protected GFOpPathPaint(List<COSBase> arguments, PDResourcesHandler resourcesHandler,
							final String operatorType) {
		super(arguments, operatorType);
		this.resourcesHandler = resourcesHandler;
	}

	//TODO : implement me
	protected List<org.verapdf.model.pdlayer.PDColorSpace> getFillCS() {
		return Collections.emptyList();
	}

	//TODO : implement me
	protected List<org.verapdf.model.pdlayer.PDColorSpace> getStrokeCS() {
		return Collections.emptyList();
	}

	//TODO : implement me
	private List<org.verapdf.model.pdlayer.PDColorSpace> getColorSpace() {
		return Collections.emptyList();
	}

}
