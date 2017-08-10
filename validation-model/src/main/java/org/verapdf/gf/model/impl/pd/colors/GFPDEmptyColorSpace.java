package org.verapdf.gf.model.impl.pd.colors;

import org.verapdf.model.baselayer.Object;

import java.util.List;

import static org.verapdf.gf.model.impl.pd.colors.GFPDDeviceGray.DEVICE_GRAY_TYPE;

/**
 * @author Sergey Shemyakov
 */
public class GFPDEmptyColorSpace extends GFPDColorSpace {

    public GFPDEmptyColorSpace() {
        super(null, DEVICE_GRAY_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        return super.getLinkedObjects(link);
    }

    @Override
    public Long getnrComponents() {
        return null;
    }
}
