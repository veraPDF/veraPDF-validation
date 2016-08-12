package org.verapdf.model.impl.pd;

import org.verapdf.model.pdlayer.PDResource;
import org.verapdf.pd.PDFont;

/**
 * @author Maksim Bezrukov
 */
public class GFPDResource extends GFPDObject implements PDResource {

    protected GFPDResource(org.verapdf.pd.PDResource simplePDObject, final String type) {
        super(simplePDObject, type);
    }

    protected GFPDResource(PDFont font, final String type) {
        super(font, type);
    }

    @Override
    public Boolean getisInherited() {
        return Boolean.valueOf(((org.verapdf.pd.PDResource) simplePDObject).isInherited());
    }
}
