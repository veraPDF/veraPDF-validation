/**
 * This file is part of validation-model, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * validation-model is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with validation-model as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * validation-model as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.external;

import org.verapdf.gf.model.factory.colors.ColorSpaceFactory;
import org.verapdf.model.external.JPEG2000;
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
