package org.verapdf.model.impl.external;

import org.verapdf.model.external.JPEG2000;
import org.verapdf.model.factory.colors.ColorSpaceFactory;
import org.verapdf.model.pdlayer.PDColorSpace;

/**
 * @author Maksim Bezrukov
 */
public class GFJPEG2000 extends GFExternal implements JPEG2000 {

    public static final String JPEG_2000_TYPE = "JPEG2000";

    private final org.verapdf.external.JPEG2000 jpeg2000;

    public GFJPEG2000(org.verapdf.external.JPEG2000 jpeg2000) {
        super(JPEG_2000_TYPE);
        this.jpeg2000 = jpeg2000;
    }

    @Override
    public Long getnrColorChannels() {
        return this.jpeg2000.getNumberOfColorChannels();
    }

    @Override
    public Long getnrColorSpaceSpecs() {
        return this.jpeg2000.getNumberOfColorSpaceSpecs();
    }

    @Override
    public Long getnrColorSpacesWithApproxField() {
        return this.jpeg2000.getNumberOfColorSpacesWithApproxField();
    }

    @Override
    public Long getcolrMethod() {
        return this.jpeg2000.getColrMethod();
    }

    @Override
    public Long getcolrEnumCS() {
        return this.jpeg2000.getColrEnumCS();
    }

    @Override
    public Long getbitDepth() {
        return this.jpeg2000.getBitDepth();
    }

    @Override
    public Boolean getbpccBoxPresent() {
        return this.jpeg2000.getBPCCBoxPresent();
    }

    public PDColorSpace getImageColorSpace() {
        return ColorSpaceFactory.getColorSpace(this.jpeg2000.getImageColorSpace());
    }
}
