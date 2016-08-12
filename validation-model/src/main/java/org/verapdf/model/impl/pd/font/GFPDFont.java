package org.verapdf.model.impl.pd.font;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSName;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosUnicodeName;
import org.verapdf.model.external.FontProgram;
import org.verapdf.model.factory.operators.RenderingMode;
import org.verapdf.model.impl.cos.GFCosUnicodeName;
import org.verapdf.model.impl.pd.GFPDResource;
import org.verapdf.model.pdlayer.PDFont;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Instance of this class represent PDF font dictionary.
 * //TODO: write doc
 *
 * @author Sergey Shemyakov
 */
public class GFPDFont extends GFPDResource implements PDFont {

    public static final String FONT_FILE = "fontFile";
    public static final String BASE_FONT = "BaseFont";
    public static final String TYPE_3 = "Type3";
    public static final String TRUE_TYPE = "TrueType";
    public static final String TYPE_1 = "Type1";
    public static final String CID_FONT_TYPE_2 = "CIDFontType2";

    protected final RenderingMode renderingMode;

    protected GFPDFont(org.verapdf.pd.PDFont font, RenderingMode renderingMode,
                       final String type) {
        super(font, type);
        this.renderingMode = renderingMode;
    }

    @Override
    public String getType() {
        return this.pdFont.getType();
    }

    @Override
    public String getSubtype() {
        return this.pdFont.getSubtype();
    }

    @Override
    public String getfontName() {
        return this.pdFont.getFontName();
    }

    @Override
    public Boolean getisSymbolic() {
        return this.pdFont.isSymbolic();
    }

    @Override
    public Long getrenderingMode() {
        return Long.valueOf(this.renderingMode.getValue());
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case FONT_FILE:
                return this.getFontFile();
            case BASE_FONT:
                return this.getBaseFont();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<FontProgram> getFontFile() {
        return Collections.emptyList(); // TODO: fix
    }

    private List<FontProgram> getFontProgramList(FontProgram fontProgram) {
        List<FontProgram> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
        list.add(fontProgram);
        return Collections.unmodifiableList(list);
    }

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
}
