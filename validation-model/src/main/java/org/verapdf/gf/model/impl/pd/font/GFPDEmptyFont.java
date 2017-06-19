package org.verapdf.gf.model.impl.pd.font;

import org.verapdf.gf.model.factory.operators.RenderingMode;
import org.verapdf.model.baselayer.Object;

import java.util.List;

/**
 * @author Sergey Shemyakov
 */
public class GFPDEmptyFont extends GFPDFont {

    public GFPDEmptyFont() {
        super(null, RenderingMode.NEITHER, RESOURCE_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        return super.getLinkedObjects(link);
    }
}
