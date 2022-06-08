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
package org.verapdf.gf.model.impl.pd.signature;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.pd.GFPDObject;
import org.verapdf.model.pdlayer.PDPerms;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Represents permissions dictionary referred by /Perms key from the document
 * catalog.
 *
 * @author Sergey Shemyakov
 */
public class GFPDPerms extends GFPDObject implements PDPerms {

    /**
     * Type name for {@code GFPDPerms}
     */
    public static final String PERMS_TYPE = "PDPerms";

    private static final ASAtom UR3 = ASAtom.getASAtom("UR3");
    public static final ASAtom DOC_MDP = ASAtom.getASAtom("DocMDP");

    /**
     * @param dictionary is permissions dictionary.
     */
    public GFPDPerms(COSObject dictionary) {
        super(dictionary, PERMS_TYPE);
    }

    @Override
    public String getentries() {
        if (!this.simpleCOSObject.empty()) {
            return this.simpleCOSObject.get().getKeySet().stream()
                    .map(ASAtom::getValue)
                    .collect(Collectors.joining("&"));
        }
        return "";
    }

}
