/**
 * This file is part of veraPDF WCAG Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2025, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF WCAG Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF WCAG Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF WCAG Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.sa.structelems;

import org.verapdf.gf.model.impl.sa.GFSAStructElem;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSAFactory {

    public static GFSAStructElem createTypedStructElem(PDStructElem structElemDictionary, String parentsStandardTypes){
        String standardType = PDStructElem.getStructureElementStandardType(structElemDictionary);

        if (standardType == null) {
            return new GFSANonStandard(structElemDictionary, null, parentsStandardTypes);
        }

        switch (standardType) {
            case TaggedPDFConstants.ANNOT:
                return new GFSAAnnot(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.ART:
                return new GFSAArt(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.ARTIFACT:
                return new GFSAArtifact(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.ASIDE:
                return new GFSAAside(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.BIB_ENTRY:
                return new GFSABibEntry(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.BLOCK_QUOTE:
                return new GFSABlockQuote(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.CAPTION:
                return new GFSACaption(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.CODE:
                return new GFSACode(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.DIV:
                return new GFSADiv(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.DOCUMENT:
                return new GFSADocument(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.DOCUMENT_FRAGMENT:
                return new GFSADocumentFragment(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.EM:
                return new GFSAEm(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.FENOTE:
                return new GFSAFENote(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.FIGURE:
                return new GFSAFigure(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.FORM:
                return new GFSAForm(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.FORMULA:
                return new GFSAFormula(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.H:
                return new GFSAH(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.INDEX:
                return new GFSAIndex(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.L:
                return new GFSAL(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.LBL:
                return new GFSALbl(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.LBODY:
                return new GFSALBody(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.LI:
                return new GFSALI(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.LINK:
                return new GFSALink(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.NON_STRUCT:
                return new GFSANonStruct(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.NOTE:
                return new GFSANote(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.P:
                return new GFSAP(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.PART:
                return new GFSAPart(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.PRIVATE:
                return new GFSAPrivate(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.QUOTE:
                return new GFSAQuote(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.RB:
                return new GFSARB(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.REFERENCE:
                return new GFSAReference(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.RP:
                return new GFSARP(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.RT:
                return new GFSART(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.RUBY:
                return new GFSARuby(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.SECT:
                return new GFSASect(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.SPAN:
                return new GFSASpan(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.STRONG:
                return new GFSAStrong(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.SUB:
                return new GFSASub(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.TABLE:
                return new GFSATable(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.TBODY:
                return new GFSATBody(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.TD:
                return new GFSATD(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.TFOOT:
                return new GFSATFoot(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.TH:
                return new GFSATH(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.THEAD:
                return new GFSATHead(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.TITLE:
                return new GFSATitle(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.TOC:
                return new GFSATOC(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.TOCI:
                return new GFSATOCI(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.TR:
                return new GFSATR(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.WARICHU:
                return new GFSAWarichu(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.WP:
                return new GFSAWP(structElemDictionary, parentsStandardTypes);
            case TaggedPDFConstants.WT:
                return new GFSAWT(structElemDictionary, parentsStandardTypes);
            default:
                if (standardType.matches(TaggedPDFConstants.HN_REGEXP)) {
                    return new GFSAHn(structElemDictionary, standardType, parentsStandardTypes);
                } else {
                    return new GFSANonStandard(structElemDictionary, standardType, parentsStandardTypes);
                }
        }
    }
}
