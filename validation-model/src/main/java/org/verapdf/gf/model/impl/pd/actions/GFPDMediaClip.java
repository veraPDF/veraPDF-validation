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
package org.verapdf.gf.model.impl.pd.actions;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.pd.GFPDObject;
import org.verapdf.model.pdlayer.PDMediaClip;

/**
 * @author Maxim Plushchov
 */
public class GFPDMediaClip extends GFPDObject implements PDMediaClip {

    public static final String MEDIA_CLIP_TYPE = "PDMediaClip";

    public GFPDMediaClip(org.verapdf.pd.actions.PDMediaClip simplePDObject) {
        super(simplePDObject, MEDIA_CLIP_TYPE);
    }

    @Override
    public String getCT() {
        return ((org.verapdf.pd.actions.PDMediaClip)simplePDObject).getContentType();
    }

    @Override
    public String getAlt() {
        COSObject object = simplePDObject.getKey(ASAtom.ALT);
        return object != null ? object.toString() : null;
    }

    @Override
    public Boolean gethasCorrectAlt() {
        COSObject object = simplePDObject.getKey(ASAtom.ALT);
        if (object == null || object.getType() != COSObjType.COS_ARRAY) {
            return false;
        }
        COSArray array = (COSArray)object.getDirectBase();
        if (array.size() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < array.size(); i++) {
            COSObject elem = array.at(i);
            if (elem.getType() != COSObjType.COS_STRING || (i % 2 == 1 && elem.getString().isEmpty())) {
                return false;
            }
        }
        return true;
    }
}
