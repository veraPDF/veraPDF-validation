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

    protected GFSAGeneral(PDStructElem structElemDictionary, String standardType, String type,
                          boolean isTableChild, boolean isListChild) {
        super(structElemDictionary, standardType, type, isTableChild, isListChild);
    }

    public static GFSAGeneral createTypedStructElem(PDStructElem structElemDictionary,
                                                    boolean isTableChild, boolean isListChild){
        String standardType = GFSAStructElem.getStructureElementStandardType(structElemDictionary);

        if (standardType == null) {
            return new GFSANonStandard(structElemDictionary, null, isTableChild, isListChild);
        }

        switch (standardType) {
            case TaggedPDFConstants.ANNOT:
                return new GFSAAnnot(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.ART:
                return new GFSAArt(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.ARTIFACT:
                return new GFSAArtifact(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.ASIDE:
                return new GFSAAside(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.BIB_ENTRY:
                return new GFSABibEntry(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.BLOCK_QUOTE:
                return new GFSABlockQuote(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.CAPTION:
                return new GFSACaption(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.CODE:
                return new GFSACode(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.DIV:
                return new GFSADiv(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.DOCUMENT:
                return new GFSADocument(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.DOCUMENT_FRAGMENT:
                return new GFSADocumentFragment(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.EM:
                return new GFSAEm(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.FENOTE:
                return new GFSAFENote(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.FIGURE:
                return new GFSAFigure(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.FORM:
                return new GFSAForm(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.FORMULA:
                return new GFSAFormula(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.H:
                return new GFSAH(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.INDEX:
                return new GFSAIndex(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.L:
                return new GFSAL(structElemDictionary, isTableChild);
            case TaggedPDFConstants.LBL:
                return new GFSALbl(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.LBODY:
                return new GFSALBody(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.LI:
                return new GFSALI(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.LINK:
                return new GFSALink(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.NON_STRUCT:
                return new GFSANonStruct(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.NOTE:
                return new GFSANote(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.P:
                return new GFSAP(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.PART:
                return new GFSAPart(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.PRIVATE:
                return new GFSAPrivate(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.QUOTE:
                return new GFSAQuote(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.RB:
                return new GFSARB(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.REFERENCE:
                return new GFSAReference(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.RP:
                return new GFSARP(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.RT:
                return new GFSART(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.RUBY:
                return new GFSARuby(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.SECT:
                return new GFSASect(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.SPAN:
                return new GFSASpan(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.STRONG:
                return new GFSAStrong(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.SUB:
                return new GFSASub(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.TABLE:
                return new GFSATable(structElemDictionary, isListChild);
            case TaggedPDFConstants.TBODY:
                return new GFSATBody(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.TD:
                return new GFSATD(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.TFOOT:
                return new GFSATFoot(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.TH:
                return new GFSATH(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.THEAD:
                return new GFSATHead(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.TITLE:
                return new GFSATitle(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.TOC:
                return new GFSATOC(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.TOCI:
                return new GFSATOCI(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.TR:
                return new GFSATR(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.WARICHU:
                return new GFSAWarichu(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.WP:
                return new GFSAWP(structElemDictionary, isTableChild, isListChild);
            case TaggedPDFConstants.WT:
                return new GFSAWT(structElemDictionary, isTableChild, isListChild);
            default:
                if (standardType.matches(TaggedPDFConstants.HN_REGEXP)) {
                    return new GFSAHn(structElemDictionary, standardType, isTableChild, isListChild);
                } else {
                    return new GFSANonStandard(structElemDictionary, standardType, isTableChild, isListChild);
                }
        }
    }

}
