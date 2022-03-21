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
package org.verapdf.gf.model.impl.pd.functions;

import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSIndirect;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.visitor.cos.pb.GFCosVisitor;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosObject;
import org.verapdf.model.pdlayer.PDType4Function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GFPDType4Function extends GFPDFunction implements PDType4Function {

    public static final String PD_TYPE4_FUNCTION_TYPE = "PDType4Function";
    public static final String OPERATORS = "operators";


    public GFPDType4Function(org.verapdf.pd.function.PDType4Function function) {
        super(function, PD_TYPE4_FUNCTION_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case OPERATORS:
                return this.getOperators();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<CosObject> getOperators(){
        org.verapdf.pd.function.PDType4Function function = (org.verapdf.pd.function.PDType4Function)this.simplePDObject;
        List<CosObject> result = new ArrayList<>();
        for (COSObject obj : function.getOperators()) {
            result.add(this.getFromValue(obj.get()));
        }
        return Collections.unmodifiableList(result);
    }

    /**
     * Transform object of pdf box to corresponding object of abstract model
     * implementation. For transforming using {@code PBCosVisitor}.
     *
     * @param base
     * @return object of abstract model implementation, transformed from
     *         {@code base}
     */
    private CosObject getFromValue(COSBase base) {
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
