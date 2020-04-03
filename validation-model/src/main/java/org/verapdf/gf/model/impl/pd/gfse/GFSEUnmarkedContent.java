package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.operator.Operator;
import org.verapdf.model.selayer.SEUnmarkedContent;

import java.util.List;

public class GFSEUnmarkedContent extends GFSEContentItem implements SEUnmarkedContent {

    public static final String UNMARKED_CONTENT_TYPE = "SEUnmarkedContent";

    public GFSEUnmarkedContent() {
        super(UNMARKED_CONTENT_TYPE);
    }

    protected GFSEUnmarkedContent(String objectType) {
        super(objectType);
    }

    public GFSEUnmarkedContent(List<Operator> operators) {
        super(UNMARKED_CONTENT_TYPE, operators);
    }

}
