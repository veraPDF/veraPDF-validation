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
package org.verapdf.gf.model.impl.cos;

import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSDocument;
import org.verapdf.cos.COSIndirect;
import org.verapdf.gf.model.visitor.cos.pb.GFCosVisitor;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.coslayer.CosObject;

/**
 * @author Timur Kamalov
 */
public class GFCosObject extends GenericModelObject implements CosObject {

    public static final int MAX_NUMBER_OF_ELEMENTS = 1;

    protected final COSDocument cosDocument;
    protected final COSBase baseObject;

    protected GFCosObject(final String type) {
        super(type);
        this.baseObject = null;
        this.cosDocument = null;
    }

    protected GFCosObject(final COSBase baseObject, final String type) {
        super(type);
        this.baseObject = baseObject;
        this.cosDocument = null;
    }

    protected GFCosObject(final COSDocument cosDocument, final String type) {
        super(type);
        this.baseObject = null;
        this.cosDocument = cosDocument;
    }

    /**
     * Transform object of pdf box to corresponding object of abstract model
     * implementation. For transforming using {@code PBCosVisitor}.
     *
     * @param base
     * @return object of abstract model implementation, transformed from
     *         {@code base}
     */
    public static CosObject getFromValue(COSBase base) {
        if (base != null) {
            GFCosVisitor visitor = GFCosVisitor.getInstance();
            if (base.isIndirect().booleanValue()) {
                return (CosObject) GFCosVisitor.visitFromIndirect((COSIndirect) base);
            }
            return (CosObject) base.accept(visitor);
        }
        return null;
    }

}
