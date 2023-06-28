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
package org.verapdf.gf.model.impl.operator.textshow;

/**
 * @author Maxim Plushchov
 */
public class PUAHelper {

    private static final int[] UNICODE_PRIVATE_USE_AREA_ARRAY = {0xE000, 0xF8FF, 0xF0000, 0xFFFFD, 0x100000, 0x10FFFD};

    public static Boolean containPUA(String string) {
        if (string == null) {
            return false;
        }
        for (int i = 0; i < string.length(); ++i) {
            int unicode = string.codePointAt(i);
            for (int j = 1; j < UNICODE_PRIVATE_USE_AREA_ARRAY.length; j += 2) {
                if (unicode >= UNICODE_PRIVATE_USE_AREA_ARRAY[j - 1] && unicode <= UNICODE_PRIVATE_USE_AREA_ARRAY[j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
