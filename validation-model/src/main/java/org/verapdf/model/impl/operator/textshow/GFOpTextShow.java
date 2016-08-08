package org.verapdf.model.impl.operator.textshow;

import org.apache.log4j.Logger;
import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.factory.colors.ColorSpaceFactory;
import org.verapdf.model.factory.operators.GraphicState;
import org.verapdf.model.factory.operators.RenderingMode;
import org.verapdf.model.impl.operator.base.GFOperator;
import org.verapdf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.OpTextShow;
import org.verapdf.model.pdlayer.PDFont;
import org.verapdf.pd.colors.PDColorSpace;

import java.util.ArrayList;
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

	private final PDColorSpace rawFillColorSpace;
	private final PDColorSpace rawStrokeColorSpace;

	private final RenderingMode renderingMode;

	private final int opm;
	private final boolean overprintingFlagStroke;
	private final boolean overprintingFlagNonStroke;

	private final PDResourcesHandler resourcesHandler;

	private List<PDFont> fonts = null;
	private List<org.verapdf.model.pdlayer.PDColorSpace> fillCS = null;
	private List<org.verapdf.model.pdlayer.PDColorSpace> strokeCS = null;

    protected GFOpTextShow(List<COSBase> arguments, GraphicState state,
						   PDResourcesHandler resourcesHandler, final String opType) {
        this(arguments, state.getFillColorSpace(), state.getStrokeColorSpace(), state.getRenderingMode(),
				state.getOpm(), state.isOverprintingFlagStroke(), state.isOverprintingFlagNonStroke(),
				resourcesHandler, opType);
    }

	protected GFOpTextShow(List<COSBase> arguments,
						   final PDColorSpace rawFillColorSpace, final PDColorSpace rawStrokeColorSpace,
						   final RenderingMode renderingMode,
						   int opm, boolean overprintingFlagStroke, boolean overprintingFlagNonStroke,
						   final PDResourcesHandler resourcesHandler, final String operatorType) {
		super(arguments, operatorType);
		this.rawFillColorSpace = rawFillColorSpace;
		this.rawStrokeColorSpace = rawStrokeColorSpace;
		this.renderingMode = renderingMode;
		this.opm = opm;
		this.overprintingFlagStroke = overprintingFlagStroke;
		this.overprintingFlagNonStroke = overprintingFlagNonStroke;
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

    private List<org.verapdf.model.pdlayer.PDColorSpace> getFillColorSpace() {
		if (this.fillCS == null) {
			this.fillCS = parseFillColorSpace();
		}
		return this.fillCS;
    }

	private List<org.verapdf.model.pdlayer.PDColorSpace> getStrokeColorSpace() {
		if (this.strokeCS == null) {
			this.strokeCS = parseStrokeColorSpace();
		}
		return this.strokeCS;
    }

	//TODO : implement me
	private List<PDFont> parseFont() {
		return Collections.emptyList();
	}

	private List<org.verapdf.model.pdlayer.PDColorSpace> parseFillColorSpace() {
		if (this.renderingMode.isFill()) {
			return this.getColorSpace(this.rawFillColorSpace, this.overprintingFlagNonStroke);
		} else {
			return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.pdlayer.PDColorSpace> parseStrokeColorSpace() {
		if (this.renderingMode.isStroke()) {
			return this.getColorSpace(this.rawStrokeColorSpace, this.overprintingFlagStroke);
		} else {
			return Collections.emptyList();
		}
	}

	private List<org.verapdf.model.pdlayer.PDColorSpace> getColorSpace(org.verapdf.pd.colors.PDColorSpace rawColorSpace, boolean op) {
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
