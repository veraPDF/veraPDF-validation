package org.verapdf.gf.model.factory.operators;

import org.apache.log4j.Logger;
import org.verapdf.cos.COSName;
import org.verapdf.pd.PDExtGState;
import org.verapdf.pd.colors.PDColorSpace;
import org.verapdf.pd.colors.PDDeviceGray;

/**
 * @author Timur Kamalov
 */
public class GraphicState implements Cloneable {

    private static final Logger LOGGER = Logger.getLogger(GraphicState.class);

	private PDColorSpace fillColorSpace = PDDeviceGray.INSTANCE;
	private PDColorSpace strokeColorSpace = PDDeviceGray.INSTANCE;
	private RenderingMode renderingMode = RenderingMode.FILL;
	private COSName fontName;
	private boolean overprintingFlagStroke = false;
	private boolean overprintingFlagNonStroke = false;
	private int opm = 0;

	public GraphicState() {
	}

	public PDColorSpace getFillColorSpace() {
		return fillColorSpace;
	}

	public void setFillColorSpace(PDColorSpace fillColorSpace) {
		this.fillColorSpace = fillColorSpace;
	}

	public PDColorSpace getStrokeColorSpace() {
		return strokeColorSpace;
	}

	public void setStrokeColorSpace(PDColorSpace strokeColorSpace) {
		this.strokeColorSpace = strokeColorSpace;
	}

	public RenderingMode getRenderingMode() {
		return renderingMode;
	}

	public void setRenderingMode(RenderingMode renderingMode) {
		this.renderingMode = renderingMode;
	}

	public COSName getFontName() {
		return fontName;
	}

	public void setFontName(COSName fontName) {
		this.fontName = fontName;
	}

	public boolean isOverprintingFlagStroke() {
		return overprintingFlagStroke;
	}

	public void setOverprintingFlagStroke(boolean overprintingFlagStroke) {
		this.overprintingFlagStroke = overprintingFlagStroke;
	}

	public boolean isOverprintingFlagNonStroke() {
		return overprintingFlagNonStroke;
	}

	public void setOverprintingFlagNonStroke(boolean overprintingFlagNonStroke) {
		this.overprintingFlagNonStroke = overprintingFlagNonStroke;
	}

	public int getOpm() {
		return opm;
	}

	public void setOpm(int opm) {
		this.opm = opm;
	}

	public void copyProperties(GraphicState graphicState) {
		this.fillColorSpace = graphicState.getFillColorSpace();
		this.strokeColorSpace = graphicState.getStrokeColorSpace();
		this.renderingMode = graphicState.getRenderingMode();
		this.fontName = graphicState.getFontName();
		this.overprintingFlagStroke = graphicState.isOverprintingFlagStroke();
		this.overprintingFlagNonStroke = graphicState.isOverprintingFlagNonStroke();
		this.opm = graphicState.getOpm();
	}

	public void copyPropertiesFormExtGState(PDExtGState extGState) {
		if (extGState != null) {
			//TODO : copy font settings
			Boolean oFS = extGState.getStrokingOverprintControl();
			if (oFS != null) {
				this.overprintingFlagStroke = oFS;
			}
			Boolean oFNS = extGState.getNonStrokingOverprintControl();
			if (oFNS != null) {
				this.overprintingFlagNonStroke = oFNS;
			}
			Long opm = extGState.getOverprintMode();
			if (opm != null) {
				this.opm = opm.intValue();
			}
		}
	}

	@Override
	protected GraphicState clone() {
		GraphicState clone = new GraphicState();
		clone.fillColorSpace = this.fillColorSpace;
		clone.strokeColorSpace = this.strokeColorSpace;
		clone.renderingMode = this.renderingMode;
		clone.fontName = this.fontName;
		clone.overprintingFlagStroke = this.overprintingFlagStroke;
		clone.overprintingFlagNonStroke = this.overprintingFlagNonStroke;
		clone.opm = this.opm;
		return clone;
	}

}
