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
package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.as.ASAtom;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.model.selayer.SETH;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.pdfa.flavours.PDFAFlavour;
import org.verapdf.pdfa.flavours.PDFFlavours;
import org.verapdf.tools.AttributeHelper;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSETH extends GFSETableCell implements SETH {

    public static final String TH_STRUCTURE_ELEMENT_TYPE = "SETH";

    public static final String BOTH = "Both";
    public static final String COLUMN = "Column";
    public static final String ROW = "Row";

    public GFSETH(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.TH, TH_STRUCTURE_ELEMENT_TYPE);
    }

    protected String getTHID() {
        return simplePDObject.getStringKey(ASAtom.ID);
    }

    protected String getScope() {
        return AttributeHelper.getScope(simpleCOSObject);
    }

    public static String getDefaultScope(int rowNumber, int columnNumber) {
        if (PDFFlavours.isFlavour(StaticContainers.getFlavour(), PDFAFlavour.PDFUA_1)) {
            return null;
        }
        if (rowNumber == 0 && columnNumber == 0) {
            return BOTH;
        }
        if (rowNumber == 0) {
            return COLUMN;
        }
        if (columnNumber == 0) {
            return ROW;
        }
        return BOTH;
    }
}
