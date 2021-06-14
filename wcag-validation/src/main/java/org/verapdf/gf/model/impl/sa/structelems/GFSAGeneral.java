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
package org.verapdf.gf.model.impl.sa.structelems;

import org.verapdf.gf.model.impl.sa.GFSAStructElem;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public abstract class GFSAGeneral extends GFSAStructElem {

    protected GFSAGeneral(PDStructElem structElemDictionary, String standardType, String type) {
        super(structElemDictionary, standardType, type);
    }

    public static GFSAGeneral createTypedStructElem(PDStructElem structElemDictionary){
        String standardType = GFSAStructElem.getStructureElementStandardType(structElemDictionary);

        if (standardType == null) {
            return new GFSANonStandard(structElemDictionary, null);
        }

        switch (standardType) {
            case TaggedPDFConstants.ANNOT:
                return new GFSAAnnot(structElemDictionary);
            case TaggedPDFConstants.ART:
                return new GFSAArt(structElemDictionary);
            case TaggedPDFConstants.ARTIFACT:
                return new GFSAArtifact(structElemDictionary);
            case TaggedPDFConstants.ASIDE:
                return new GFSAAside(structElemDictionary);
            case TaggedPDFConstants.BIB_ENTRY:
                return new GFSABibEntry(structElemDictionary);
            case TaggedPDFConstants.BLOCK_QUOTE:
                return new GFSABlockQuote(structElemDictionary);
            case TaggedPDFConstants.CAPTION:
                return new GFSACaption(structElemDictionary);
            case TaggedPDFConstants.CODE:
                return new GFSACode(structElemDictionary);
            case TaggedPDFConstants.DIV:
                return new GFSADiv(structElemDictionary);
            case TaggedPDFConstants.DOCUMENT:
                return new GFSADocument(structElemDictionary);
            case TaggedPDFConstants.DOCUMENT_FRAGMENT:
                return new GFSADocumentFragment(structElemDictionary);
            case TaggedPDFConstants.EM:
                return new GFSAEm(structElemDictionary);
            case TaggedPDFConstants.FENOTE:
                return new GFSAFENote(structElemDictionary);
            case TaggedPDFConstants.FIGURE:
                return new GFSAFigure(structElemDictionary);
            case TaggedPDFConstants.FORM:
                return new GFSAForm(structElemDictionary);
            case TaggedPDFConstants.FORMULA:
                return new GFSAFormula(structElemDictionary);
            case TaggedPDFConstants.H:
                return new GFSAH(structElemDictionary);
            case TaggedPDFConstants.INDEX:
                return new GFSAIndex(structElemDictionary);
            case TaggedPDFConstants.L:
                return new GFSAL(structElemDictionary);
            case TaggedPDFConstants.LBL:
                return new GFSALbl(structElemDictionary);
            case TaggedPDFConstants.LBODY:
                return new GFSALBody(structElemDictionary);
            case TaggedPDFConstants.LI:
                return new GFSALI(structElemDictionary);
            case TaggedPDFConstants.LINK:
                return new GFSALink(structElemDictionary);
            case TaggedPDFConstants.NON_STRUCT:
                return new GFSANonStruct(structElemDictionary);
            case TaggedPDFConstants.NOTE:
                return new GFSANote(structElemDictionary);
            case TaggedPDFConstants.P:
                return new GFSAP(structElemDictionary);
            case TaggedPDFConstants.PART:
                return new GFSAPart(structElemDictionary);
            case TaggedPDFConstants.PRIVATE:
                return new GFSAPrivate(structElemDictionary);
            case TaggedPDFConstants.QUOTE:
                return new GFSAQuote(structElemDictionary);
            case TaggedPDFConstants.RB:
                return new GFSARB(structElemDictionary);
            case TaggedPDFConstants.REFERENCE:
                return new GFSAReference(structElemDictionary);
            case TaggedPDFConstants.RP:
                return new GFSARP(structElemDictionary);
            case TaggedPDFConstants.RT:
                return new GFSART(structElemDictionary);
            case TaggedPDFConstants.RUBY:
                return new GFSARuby(structElemDictionary);
            case TaggedPDFConstants.SECT:
                return new GFSASect(structElemDictionary);
            case TaggedPDFConstants.SPAN:
                return new GFSASpan(structElemDictionary);
            case TaggedPDFConstants.STRONG:
                return new GFSAStrong(structElemDictionary);
            case TaggedPDFConstants.SUB:
                return new GFSASub(structElemDictionary);
            case TaggedPDFConstants.TABLE:
                return new GFSATable(structElemDictionary);
            case TaggedPDFConstants.TBODY:
                return new GFSATBody(structElemDictionary);
            case TaggedPDFConstants.TD:
                return new GFSATD(structElemDictionary);
            case TaggedPDFConstants.TFOOT:
                return new GFSATFoot(structElemDictionary);
            case TaggedPDFConstants.TH:
                return new GFSATH(structElemDictionary);
            case TaggedPDFConstants.THEAD:
                return new GFSATHead(structElemDictionary);
            case TaggedPDFConstants.TITLE:
                return new GFSATitle(structElemDictionary);
            case TaggedPDFConstants.TOC:
                return new GFSATOC(structElemDictionary);
            case TaggedPDFConstants.TOCI:
                return new GFSATOCI(structElemDictionary);
            case TaggedPDFConstants.TR:
                return new GFSATR(structElemDictionary);
            case TaggedPDFConstants.WARICHU:
                return new GFSAWarichu(structElemDictionary);
            case TaggedPDFConstants.WP:
                return new GFSAWP(structElemDictionary);
            case TaggedPDFConstants.WT:
                return new GFSAWT(structElemDictionary);
            default:
                if (standardType.matches(TaggedPDFConstants.HN_REGEXP)) {
                    return new GFSAHn(structElemDictionary, standardType);
                } else {
                    return new GFSANonStandard(structElemDictionary, standardType);
                }
        }
    }

}
