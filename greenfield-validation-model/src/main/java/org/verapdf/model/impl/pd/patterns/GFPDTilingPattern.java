package org.verapdf.model.impl.pd.patterns;

import org.verapdf.model.baselayer.Object;
import org.verapdf.model.impl.pd.GFPDContentStream;
import org.verapdf.model.pdlayer.PDContentStream;
import org.verapdf.model.pdlayer.PDTilingPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDTilingPattern extends GFPDPattern implements PDTilingPattern {

	public static final String TILING_PATTERN_TYPE = "PDTilingPattern";

	public static final String CONTENT_STREAM = "contentStream";

	public GFPDTilingPattern(
			org.verapdf.pd.patterns.PDTilingPattern simplePDObject) {
		super(simplePDObject, TILING_PATTERN_TYPE);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {

		if (CONTENT_STREAM.equals(link)) {
			return this.getContentStream();
		}
		return super.getLinkedObjects(link);
	}

	private List<PDContentStream> getContentStream() {
		List<PDContentStream> contentStreams = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
		GFPDContentStream contentStream = new GFPDContentStream((org.verapdf.pd.PDContentStream) this.simplePDObject);
		contentStreams.add(contentStream);
		return contentStreams;
	}
}
