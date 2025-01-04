/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2025, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.pd.colors;

import org.verapdf.model.pdlayer.PDDeviceRGB;

/**
 * @author Maksim Bezrukov
 */
public class GFPDDeviceRGB extends GFPDColorSpace implements PDDeviceRGB {
    private static final PDDeviceRGB INSTANCE = new GFPDDeviceRGB(
            org.verapdf.pd.colors.PDDeviceRGB.INSTANCE);
    private static final PDDeviceRGB INHERITED_INSTANCE = new GFPDDeviceRGB(
            org.verapdf.pd.colors.PDDeviceRGB.INHERITED_INSTANCE);

    public static final String DEVICE_RGB_TYPE = "PDDeviceRGB";

    private GFPDDeviceRGB(
            org.verapdf.pd.colors.PDDeviceRGB simplePDObject) {
        super(simplePDObject, DEVICE_RGB_TYPE);
    }

    public static PDDeviceRGB getInstance() {
        return INSTANCE;
    }

    public static PDDeviceRGB getInheritedInstance() {
        return INHERITED_INSTANCE;
    }
}
