package org.verapdf.model.impl.pd.font;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSName;
import org.verapdf.cos.COSObjType;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosUnicodeName;
import org.verapdf.model.external.FontProgram;
import org.verapdf.model.factory.operators.RenderingMode;
import org.verapdf.model.impl.cos.GFCosUnicodeName;
import org.verapdf.model.impl.external.GFFontProgram;
import org.verapdf.model.impl.external.GFTrueTypeFontProgram;
import org.verapdf.model.impl.pd.GFPDResource;
import org.verapdf.model.pdlayer.PDFont;
import org.verapdf.pd.font.Encoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Instance of this class represent PDF font dictionary.
 *
 * @author Sergey Shemyakov
 */
public class GFPDFont extends GFPDResource implements PDFont {

    public static final String FONT_FILE = "fontFile";
    public static final String BASE_FONT = "BaseFont";

    protected final RenderingMode renderingMode;

    protected GFPDFont(org.verapdf.pd.font.PDFont font,
                       RenderingMode renderingMode, final String type) {
        super(font, type);
        this.renderingMode = renderingMode;
    }

    /**
     * @return font type (Type entry).
     */
    @Override
    public String getType() {
        return this.pdFont.getType();
    }

    /**
     * @return font subtype (Subtype entry).
     */
    @Override
    public String getSubtype() {
        ASAtom result = this.pdFont.getSubtype();
        return result != null ? result.getValue() : null;
    }

    /**
     * @return font name defined by BaseFont entry in the font dictionary and
     * FontName key in the font descriptor.
     */
    @Override
    public String getfontName() {
        ASAtom result = this.pdFont.getFontName();
        return result != null ? result.getValue() : null;
    }

    /**
     * @return true if the font flags in the font descriptor dictionary mark
     * indicate that the font is symbolic (the entry /Flags has bit 3 set to 1
     * and bit 6 set to 0).
     */
    @Override
    public Boolean getisSymbolic() {
        return this.pdFont.isSymbolic();
    }

    /**
     * @return rendering mode value.
     */
    @Override
    public Long getrenderingMode() {
        return Long.valueOf(this.renderingMode.getValue());
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case FONT_FILE:
                return this.getFontProgram();
            case BASE_FONT:
                return this.getBaseFont();
            default:
                return super.getLinkedObjects(link);
        }
    }

    /**
     * @return embedded font program for Type 1, TrueType or CID Font.
     */
    private List<FontProgram> getFontProgram() {
        if(this.pdFont.getFontProgram() != null) {
            ASAtom subType = this.pdFont.getSubtype();
            if (ASAtom.TRUE_TYPE == subType) {
                GFTrueTypeFontProgram font = new GFTrueTypeFontProgram(
                        this.pdFont.getFontProgram());
                return getFontProgramList(font);
            } else {
                GFFontProgram font = new GFFontProgram(this.pdFont.getFontProgram());
                return getFontProgramList(font);
            }
        } else {
            return Collections.emptyList();
        }
    }

    private List<FontProgram> getFontProgramList(FontProgram fontProgram) {
        List<FontProgram> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
        list.add(fontProgram);
        return Collections.unmodifiableList(list);
    }

    /**
     * @return link to the name Object referenced by BaseFont key.
     */
    private List<CosUnicodeName> getBaseFont() {
        String name = this.pdFont.getName();
        if (name != null) {
            ArrayList<CosUnicodeName> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            list.add(new GFCosUnicodeName((COSName)
                    COSName.construct(ASAtom.getASAtom(name)).get()));
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

    public Encoding getEncodingMapping() {
        COSBase encoding = this.pdFont.getEncoding().getDirectBase();
        if(encoding.getType() == COSObjType.COS_NAME) {
            return new Encoding(encoding.getName());
        } else if (encoding.getType() == COSObjType.COS_DICT) {
            return new Encoding(encoding.getNameKey(ASAtom.BASE_ENCODING),
                    this.pdFont.getDifferences());
        } else {
            return null;
        }
    }
}
