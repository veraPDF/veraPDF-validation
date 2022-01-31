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
package org.verapdf.gf.model.factory.functions;

import org.verapdf.gf.model.impl.pd.functions.*;
import org.verapdf.pd.function.PDFunction;
import org.verapdf.pd.function.PDType3Function;
import org.verapdf.pd.function.PDType4Function;

import java.util.logging.Logger;

public class FunctionFactory {

    private static final Logger LOGGER = Logger.getLogger(FunctionFactory.class.getCanonicalName());

    private FunctionFactory() {
        //Disable default constructor
    }

    public static GFPDFunction createFunction(PDFunction function) {
        Long functionType = function.getFunctionType();

        if (functionType == null) {
            return new GFPDFunction(function);
        }

        switch (functionType.intValue()) {
            case 0:
                return new GFPDType0Function(function);
            case 2:
                return new GFPDType2Function(function);
            case 3:
                return new GFPDType3Function((PDType3Function) function);
            case 4:
                return new GFPDType4Function((PDType4Function) function);
            default:
                LOGGER.warning("Function type key must be {0, 2, 3, 4}");
                return new GFPDFunction(function);
        }
    }
}
