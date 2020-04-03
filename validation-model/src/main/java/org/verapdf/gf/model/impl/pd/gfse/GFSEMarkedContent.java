package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.GenericModelObject;
import org.verapdf.model.operator.Operator;
import org.verapdf.model.selayer.SEContentItem;
import org.verapdf.model.selayer.SEMarkedContent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class GFSEMarkedContent extends GFSEContentItem implements SEMarkedContent {

    public static final String MARKED_CONTENT_TYPE = "SEMarkedContent";

    public GFSEMarkedContent() {
        super(MARKED_CONTENT_TYPE);
    }

    protected GFSEMarkedContent(String objectType) {
        super(objectType);
    }

    public GFSEMarkedContent(List<Operator> operators) {
        super(MARKED_CONTENT_TYPE);
        this.operators = operators.subList(1, operators.size() - 1);
    }

    @Override
    public String gettag() {
        return null;
    }

    @Override
    public String getstructureTag() {
        return null;
    }

}
