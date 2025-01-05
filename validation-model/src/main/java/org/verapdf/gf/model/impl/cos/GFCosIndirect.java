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
package org.verapdf.gf.model.impl.cos;

import org.verapdf.cos.COSIndirect;
import org.verapdf.cos.COSKey;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.tools.GFIDGenerator;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosIndirect;
import org.verapdf.model.coslayer.CosObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFCosIndirect extends GFCosObject implements CosIndirect {


    public static final String DIRECT_OBJECT = "directObject";
    /** Type name for GFCosBool */
    public static final String COS_INDIRECT_TYPE = "CosIndirect";

    private final boolean isSpacingPDFACompliant;

    private final String id;

    public GFCosIndirect(final COSKey key, final COSObject object) {
        super(object.get(), COS_INDIRECT_TYPE);
        this.isSpacingPDFACompliant = getSpacingCompliesPDFA(object);
        this.id = GFIDGenerator.generateID(key);
    }

    /**
     * Default constructor
     */
    public GFCosIndirect(final COSIndirect object) {
        super(object.get(), COS_INDIRECT_TYPE);
        this.isSpacingPDFACompliant = getSpacingCompliesPDFA(object.getDirect());
        this.id = GFIDGenerator.generateID(object.getKey());
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public List<? extends Object> getLinkedObjects(
            String link) {
        if (DIRECT_OBJECT.equals(link)) {
            return parseDirectObject();
        }
        return super.getLinkedObjects(link);
    }

    /**
     * Get the direct contents of the indirect object
     */
    private List<CosObject> parseDirectObject() {
        List<CosObject> list = new ArrayList<>();
        list.add(baseObject != null ? getFromValue(baseObject) : GFCosNull.getInstance());
        return Collections.unmodifiableList(list);
    }

    /**
     * true if the words 'obj' and 'endobj' are surrounded by the correct
     * spacings according to PDF/A standard
     */
    @Override
    public Boolean getspacingCompliesPDFA() {
        return this.isSpacingPDFACompliant;
    }

    /**
     * Get the direct contents of the indirect object
     */
    private static boolean getSpacingCompliesPDFA(COSObject object) {
        return object.isEndOfObjectComplyPDFA()
                && object.isHeaderFormatComplyPDFA()
                && object.isHeaderOfObjectComplyPDFA();
    }

}
