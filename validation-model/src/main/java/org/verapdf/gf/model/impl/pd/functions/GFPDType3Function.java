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
package org.verapdf.gf.model.impl.pd.functions;

import org.verapdf.gf.model.factory.functions.FunctionFactory;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDType3Function;
import org.verapdf.pd.function.PDFunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GFPDType3Function extends GFPDFunction implements PDType3Function {

    public static final String PD_TYPE3_FUNCTION_TYPE = "PDType3Function";

    public static final String FUNCTIONS = "Functions";


    public GFPDType3Function(org.verapdf.pd.function.PDType3Function function) {
        super(function, PD_TYPE3_FUNCTION_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case FUNCTIONS:
                return this.getFunctions();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<GFPDFunction> getFunctions() {
        List<GFPDFunction> functionList = new ArrayList<>();
        for (PDFunction pdFunction : ((org.verapdf.pd.function.PDType3Function)this.simplePDObject).getFunctions()) {
            GFPDFunction function = FunctionFactory.createFunction(pdFunction);
            functionList.add(function);
        }
        return Collections.unmodifiableList(functionList);
    }
}
