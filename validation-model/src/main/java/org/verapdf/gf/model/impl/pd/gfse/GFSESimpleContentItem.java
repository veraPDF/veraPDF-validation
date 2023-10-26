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
package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOpMarkedContent;
import org.verapdf.model.selayer.SESimpleContentItem;

/**
 * @author Maxim Plushchov
 */
public abstract class GFSESimpleContentItem extends GFSEContentItem implements SESimpleContentItem {

    public GFSESimpleContentItem(String objectType, COSObject parentStructElem, String parentsTags) {
        super(objectType, parentStructElem, parentsTags);
    }

    public GFSESimpleContentItem(String objectType, GFOpMarkedContent parentMarkedContentOperator,
                                 COSObject parentStructElem, String parentsTags) {
        super(objectType, parentMarkedContentOperator, parentStructElem, parentsTags);
    }
}
