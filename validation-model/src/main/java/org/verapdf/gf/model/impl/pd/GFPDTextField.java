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

import org.verapdf.as.ASAtom;
import org.verapdf.gf.model.tools.DictionaryKeysHelper;
import org.verapdf.model.pdlayer.PDTextField;

/**
 * @author Sergey Shemyakov
 */
public class GFPDTextField extends GFPDFormField implements PDTextField {
    
    public static final String TEXT_FIELD_TYPE = "PDTextField";
    
    public GFPDTextField(org.verapdf.pd.form.PDFormField pdFormField) {
        super(pdFormField, TEXT_FIELD_TYPE);
    }

    @Override
    public String getV() {
        return DictionaryKeysHelper.getStringOrStreamEntryStringRepresentation(simpleCOSObject, ASAtom.V);
    }

    @Override
    public String getRV() {
        return DictionaryKeysHelper.getRichTextStringOrStreamEntryStringRepresentation(simpleCOSObject, ASAtom.RV);
    }

    @Override
    public Boolean getcontainsRV() {
        return simpleCOSObject.knownKey(ASAtom.RV);
    }
}
