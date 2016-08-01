package org.verapdf.model.impl.operator.pathpaint;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.impl.operator.factory.GraphicState;
import org.verapdf.model.impl.pd.util.PDResourcesHandler;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public abstract class GFOpStrokePaint extends GFOpPathPaint {

	protected GFOpStrokePaint(List<COSBase> arguments, final GraphicState state,
							  final PDResourcesHandler resources, final String operatorType) {
		super(arguments, state, resources, operatorType);
	}

	@Override
	public List<? extends Object> getLinkedObjects(
			String link) {
		if (STROKE_CS.equals(link)) {
			return this.getStrokeCS();
		}
		return super.getLinkedObjects(link);
	}

}
