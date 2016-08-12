package org.verapdf.model.impl.pd.font;

import org.verapdf.model.baselayer.Object;
import org.verapdf.model.factory.operators.RenderingMode;
import org.verapdf.model.pdlayer.PDContentStream;
import org.verapdf.model.pdlayer.PDType3Font;
import org.verapdf.pd.PDFont;

import java.util.Collections;
import java.util.List;

/**
 * Represents Type3 font dictionary.
 * //TODO: write doc
 *
 * @author Sergey Shemyakov
 */
public class GFPDType3Font extends GFPDSimpleFont implements PDType3Font {

    public static final String TYPE3_FONT_TYPE = "PDType3Font";

    public static final String CHAR_STRINGS = "charStrings";

    public GFPDType3Font(PDFont font, RenderingMode renderingMode) {
        super(font, renderingMode, TYPE3_FONT_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (CHAR_STRINGS.equals(link)) {
            return this.getCharStrings();
        }
        return super.getLinkedObjects(link);
    }

    private List<PDContentStream> getCharStrings() {
        return Collections.emptyList(); // TODO: fix
    }
}
