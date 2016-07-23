package org.verapdf.model.impl.pd.colors;

import org.verapdf.model.impl.pd.GFPDResource;
import org.verapdf.model.pdlayer.PDColorSpace;

/**
 * @author Maksim Bezrukov
 */
public class GFPDColorSpace extends GFPDResource implements PDColorSpace {

    protected GFPDColorSpace(org.verapdf.pd.colors.PDColorSpace simplePDObject, String type) {
        super(simplePDObject, type);
    }

    @Override
    public Long getnrComponents() {
        return Long.valueOf(((org.verapdf.pd.colors.PDColorSpace) simplePDDObject).getNumberOfComponents());
    }
}
