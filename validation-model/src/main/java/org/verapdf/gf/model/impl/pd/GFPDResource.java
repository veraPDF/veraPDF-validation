/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2024, veraPDF Consortium <info@verapdf.org>
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
package org.verapdf.gf.model.impl.pd;

import org.verapdf.model.pdlayer.PDResource;
import org.verapdf.pd.font.PDFont;

/**
 * @author Maksim Bezrukov
 */
public class GFPDResource extends GFPDObject implements PDResource {

    public static final String RESOURCE_TYPE = "PDResource";

    protected GFPDResource(org.verapdf.pd.PDResource simplePDObject, final String type) {
        super(simplePDObject, type);
    }

    protected GFPDResource(PDFont font, final String type) {
        super(font, type);
    }

    @Override
    public Boolean getisInherited() {
        if (this.simplePDObject != null) {
            return ((org.verapdf.pd.PDResource) simplePDObject).isInherited();
        } else if (this.pdFont != null) {
            return this.pdFont.isInherited();
        }
        return Boolean.TRUE;
    }

}
