package org.verapdf.model.impl.operator.pathpaint;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.factory.operators.GraphicState;
import org.verapdf.model.impl.pd.util.PDResourcesHandler;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public abstract class GFOpFillAndStroke extends GFOpPathPaint {

	protected GFOpFillAndStroke(List<COSBase> arguments, final GraphicState state,
								final PDResourcesHandler resourcesHandler, final String opType) {
		super(arguments, state, resourcesHandler, opType);
	}

	@Override
	public List<? extends Object> getLinkedObjects(
			String link) {
		switch (link) {
			case STROKE_CS:
				return this.getStrokeCS();
			case FILL_CS:
				return this.getFillCS();
			default:
				return super.getLinkedObjects(link);
		}
	}

}
