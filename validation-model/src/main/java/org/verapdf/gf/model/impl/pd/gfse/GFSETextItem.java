package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SETextItem;

public class GFSETextItem extends GFSEContentItem implements SETextItem {

    public static final String TEXT_ITEM_TYPE = "SETextItem";

    public GFSETextItem() {
        super(TEXT_ITEM_TYPE);
    }

    protected GFSETextItem(String objectType) {
        super(objectType);
    }

}
