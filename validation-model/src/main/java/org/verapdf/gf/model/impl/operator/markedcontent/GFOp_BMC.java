/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
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
package org.verapdf.gf.model.impl.operator.markedcontent;


import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSName;
import org.verapdf.cos.COSObjType;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.operator.Op_BMC;

import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_BMC extends GFOpMarkedContent implements Op_BMC {

	/** Type name for {@code GFOp_BMC} */
    public static final String OP_BMC_TYPE = "Op_BMC";

    public GFOp_BMC(List<COSBase> arguments, GFOpMarkedContent markedContent, String parentsTags) {
        super(arguments, OP_BMC_TYPE, markedContent, parentsTags);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case TAG:
                return this.getLinkTag();
            case PROPERTIES:
                return this.getPropertiesDict();
            default:
                return super.getLinkedObjects(link);
        }
    }

	@Override
    public COSName getTag() {
        if (!this.arguments.isEmpty()) {
            COSBase name = this.arguments.get(this.arguments.size() - 1);
            if (name.getType() == COSObjType.COS_NAME) {
                return (COSName) name;
            }
        }
        return null;
    }

}
