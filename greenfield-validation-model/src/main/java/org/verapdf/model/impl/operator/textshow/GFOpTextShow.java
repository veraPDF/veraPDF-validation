package org.verapdf.model.impl.operator.textshow;

import org.apache.log4j.Logger;
import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.factory.operators.GraphicState;
import org.verapdf.model.impl.operator.base.GFOperator;
import org.verapdf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.OpTextShow;
import org.verapdf.model.pdlayer.PDColorSpace;
import org.verapdf.model.pdlayer.PDFont;

import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public abstract class GFOpTextShow extends GFOperator implements OpTextShow {

    private static final Logger LOGGER = Logger.getLogger(GFOpTextShow.class);

	private static final String MSG_PROBLEM_OBTAINING_RESOURCE = "Problem encountered while obtaining resources for ";

	/** Name of link to the used font */
    public static final String FONT = "font";
	/** Name of link to the used glyphs */
    public static final String USED_GLYPHS = "usedGlyphs";
    /** Name of link to the fill color space */
    public static final String FILL_COLOR_SPACE = "fillCS";
    /** Name of link to the stroke color space */
    public static final String STROKE_COLOR_SPACE = "strokeCS";

    protected final GraphicState state;
	private final PDResourcesHandler resourcesHandler;

	private List<PDFont> fonts = null;
	private List<PDColorSpace> fillCS = null;
	private List<PDColorSpace> strokeCS = null;

    protected GFOpTextShow(List<COSBase> arguments, GraphicState state,
						   PDResourcesHandler resourcesHandler, final String opType) {
        super(arguments, opType);
        this.state = state;
		this.resourcesHandler = resourcesHandler;
    }

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case FONT:
				return this.getFont();
			case USED_GLYPHS:
				return this.getUsedGlyphs();
            case FILL_COLOR_SPACE:
                return this.getFillColorSpace();
            case STROKE_COLOR_SPACE:
                return this.getStrokeColorSpace();
			default:
				return super.getLinkedObjects(link);
		}
	}

    private List<PDFont> getFont() {
		if (this.fonts == null) {
			this.fonts = parseFont();
		}
		return this.fonts;
    }

	//TODO : implement me
    private List<Object> getUsedGlyphs() {
        return Collections.emptyList();
    }

    private List<PDColorSpace> getFillColorSpace() {
		if (this.fillCS == null) {
			this.fillCS = parseFillColorSpace();
		}
		return this.fillCS;
    }

	private List<PDColorSpace> getStrokeColorSpace() {
		if (this.strokeCS == null) {
			this.strokeCS = parseStrokeColorSpace();
		}
		return this.strokeCS;
    }

	//TODO : implement me
	private List<PDFont> parseFont() {
		return Collections.emptyList();
	}

	private List<PDColorSpace> parseFillColorSpace() {
		return Collections.emptyList();
	}

	private List<PDColorSpace> parseStrokeColorSpace() {
		return Collections.emptyList();
	}

}
