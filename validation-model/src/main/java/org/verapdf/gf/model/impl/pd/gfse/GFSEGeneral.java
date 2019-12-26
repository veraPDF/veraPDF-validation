package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.gf.model.impl.pd.GFPDStructElem;
import org.verapdf.gf.model.impl.pd.GFPDStructTreeRoot;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public abstract class GFSEGeneral extends GFPDStructElem {

    private final String standardType;

    protected GFSEGeneral(PDStructElem structElemDictionary, String standardType, String type) {
        super(structElemDictionary, type);
        this.standardType = standardType;
    }

    public static GFSEGeneral createTypedStructElem(PDStructElem structElemDictionary){
        String standardType = GFPDStructTreeRoot.getStructureElementStandardType(structElemDictionary);

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

    @Override
    public String getstandardType() {
        return this.standardType;
    }
}
