package org.verapdf.model.impl.pd;

import org.verapdf.model.pdlayer.PDResource;

/**
 * @author Maksim Bezrukov
 */
public class GFPDResource extends GFPDObject implements PDResource {

    protected GFPDResource(org.verapdf.pd.PDResource simplePDObject, String type) {
        super(simplePDObject, type);
    }

    @Override
    public Boolean getisInherited() {
        return Boolean.valueOf(((org.verapdf.pd.PDResource) simplePDDObject).isInherited());
    }
}
