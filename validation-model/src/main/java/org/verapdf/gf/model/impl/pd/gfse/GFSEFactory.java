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

import org.verapdf.gf.model.impl.pd.GFPDStructElem;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.pd.structure.StructureType;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEFactory {

    public static GFPDStructElem createTypedStructElem(PDStructElem structElemDictionary){
        StructureType standardStructureType = PDStructElem.getStructureElementStandardStructureType(structElemDictionary);
        String standardType = standardStructureType != null ? standardStructureType.getType().getValue() : null;
        if (PDStructElem.isMathStandardType(standardStructureType)) {
            return new GFSEMathMLStructElem(structElemDictionary);
        }
        if (standardType == null) {
            return new GFSENonStandard(structElemDictionary, null);
        }

        switch (standardType) {
            case TaggedPDFConstants.ANNOT:
                return new GFSEAnnot(structElemDictionary);
            case TaggedPDFConstants.ART:
                return new GFSEArt(structElemDictionary);
            case TaggedPDFConstants.ARTIFACT:
                return new GFSEArtifact(structElemDictionary);
            case TaggedPDFConstants.ASIDE:
                return new GFSEAside(structElemDictionary);
            case TaggedPDFConstants.BIB_ENTRY:
                return new GFSEBibEntry(structElemDictionary);
            case TaggedPDFConstants.BLOCK_QUOTE:
                return new GFSEBlockQuote(structElemDictionary);
            case TaggedPDFConstants.CAPTION:
                return new GFSECaption(structElemDictionary);
            case TaggedPDFConstants.CODE:
                return new GFSECode(structElemDictionary);
            case TaggedPDFConstants.DIV:
                return new GFSEDiv(structElemDictionary);
            case TaggedPDFConstants.DOCUMENT:
                return new GFSEDocument(structElemDictionary);
            case TaggedPDFConstants.DOCUMENT_FRAGMENT:
                return new GFSEDocumentFragment(structElemDictionary);
            case TaggedPDFConstants.EM:
                return new GFSEEm(structElemDictionary);
            case TaggedPDFConstants.FENOTE:
                return new GFSEFENote(structElemDictionary);
            case TaggedPDFConstants.FIGURE:
                return new GFSEFigure(structElemDictionary);
            case TaggedPDFConstants.FORM:
                return new GFSEForm(structElemDictionary);
            case TaggedPDFConstants.FORMULA:
                return new GFSEFormula(structElemDictionary);
            case TaggedPDFConstants.H:
                return new GFSEH(structElemDictionary);
            case TaggedPDFConstants.INDEX:
                return new GFSEIndex(structElemDictionary);
            case TaggedPDFConstants.L:
                return new GFSEL(structElemDictionary);
            case TaggedPDFConstants.LBL:
                return new GFSELbl(structElemDictionary);
            case TaggedPDFConstants.LBODY:
                return new GFSELBody(structElemDictionary);
            case TaggedPDFConstants.LI:
                return new GFSELI(structElemDictionary);
            case TaggedPDFConstants.LINK:
                return new GFSELink(structElemDictionary);
            case TaggedPDFConstants.NON_STRUCT:
                return new GFSENonStruct(structElemDictionary);
            case TaggedPDFConstants.NOTE:
                return new GFSENote(structElemDictionary);
            case TaggedPDFConstants.P:
                return new GFSEP(structElemDictionary);
            case TaggedPDFConstants.PART:
                return new GFSEPart(structElemDictionary);
            case TaggedPDFConstants.PRIVATE:
                return new GFSEPrivate(structElemDictionary);
            case TaggedPDFConstants.QUOTE:
                return new GFSEQuote(structElemDictionary);
            case TaggedPDFConstants.RB:
                return new GFSERB(structElemDictionary);
            case TaggedPDFConstants.REFERENCE:
                return new GFSEReference(structElemDictionary);
            case TaggedPDFConstants.RP:
                return new GFSERP(structElemDictionary);
            case TaggedPDFConstants.RT:
                return new GFSERT(structElemDictionary);
            case TaggedPDFConstants.RUBY:
                return new GFSERuby(structElemDictionary);
            case TaggedPDFConstants.SECT:
                return new GFSESect(structElemDictionary);
            case TaggedPDFConstants.SPAN:
                return new GFSESpan(structElemDictionary);
            case TaggedPDFConstants.STRONG:
                return new GFSEStrong(structElemDictionary);
            case TaggedPDFConstants.SUB:
                return new GFSESub(structElemDictionary);
            case TaggedPDFConstants.TABLE:
                return new GFSETable(structElemDictionary);
            case TaggedPDFConstants.TBODY:
                return new GFSETBody(structElemDictionary);
            case TaggedPDFConstants.TD:
                return new GFSETD(structElemDictionary);
            case TaggedPDFConstants.TFOOT:
                return new GFSETFoot(structElemDictionary);
            case TaggedPDFConstants.TH:
                return new GFSETH(structElemDictionary);
            case TaggedPDFConstants.THEAD:
                return new GFSETHead(structElemDictionary);
            case TaggedPDFConstants.TITLE:
                return new GFSETitle(structElemDictionary);
            case TaggedPDFConstants.TOC:
                return new GFSETOC(structElemDictionary);
            case TaggedPDFConstants.TOCI:
                return new GFSETOCI(structElemDictionary);
            case TaggedPDFConstants.TR:
                return new GFSETR(structElemDictionary);
            case TaggedPDFConstants.WARICHU:
                return new GFSEWarichu(structElemDictionary);
            case TaggedPDFConstants.WP:
                return new GFSEWP(structElemDictionary);
            case TaggedPDFConstants.WT:
                return new GFSEWT(structElemDictionary);
            default:
                if (standardType.matches(TaggedPDFConstants.HN_REGEXP)) {
                    return new GFSEHn(structElemDictionary, standardType);
                } else {
                    return new GFSENonStandard(structElemDictionary, standardType);
                }
        }
    }
}
