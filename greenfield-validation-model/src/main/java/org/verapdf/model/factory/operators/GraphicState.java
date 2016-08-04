package org.verapdf.model.factory.operators;

import org.apache.log4j.Logger;
import org.verapdf.cos.COSName;

/**
 * @author Timur Kamalov
 */
public class GraphicState implements Cloneable {

    private static final Logger LOGGER = Logger.getLogger(GraphicState.class);

	private RenderingMode renderingMode;
	private COSName fontName;

	public GraphicState() {
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

	@Override
	protected GraphicState clone() {
		GraphicState clone = new GraphicState();
		clone.setRenderingMode(this.getRenderingMode());
		clone.setFontName(this.getFontName());
		return clone;
	}

}
