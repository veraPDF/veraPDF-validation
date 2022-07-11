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
package org.verapdf.gf.model.impl.pd.font;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSName;
import org.verapdf.gf.model.factory.operators.RenderingMode;
import org.verapdf.gf.model.impl.cos.GFCosUnicodeName;
import org.verapdf.gf.model.impl.external.GFFontProgram;
import org.verapdf.gf.model.impl.external.GFTrueTypeFontProgram;
import org.verapdf.gf.model.impl.pd.GFPDResource;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosUnicodeName;
import org.verapdf.model.external.FontProgram;
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
    private static final String TYPE0_STRING = "Type0";

    protected boolean fontProgramParsed;
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
        return this.pdFont.getName();
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
    public String getfontFileSubtype() {
        if (this.pdFont != null) {
            ASAtom subtype = this.pdFont.getProgramSubtype();
            if (subtype != null) {
                return subtype.getValue();
            }
        }
        return null;
    }

    @Override
    public Boolean getisItalic() {
        org.verapdf.pd.font.PDFontDescriptor fontDescriptor = this.pdFont.getFontDescriptor();
        if (fontDescriptor != null) {
            return fontDescriptor.isItalic();
        }
        return null;
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

    public boolean isFontProgramParsed() {
        return this.fontProgramParsed;
    }

    /**
     * @return embedded font program for Type 1, TrueType or CID Font.
     */
    private List<FontProgram> getFontProgram() {
        org.verapdf.pd.font.FontProgram fontProgram = this.pdFont.getFontProgram();
        if (fontProgram != null && this.fontProgramParsed) {
            ASAtom subType = this.pdFont.getSubtype();
            if (ASAtom.TRUE_TYPE == subType) {
                GFTrueTypeFontProgram font = new GFTrueTypeFontProgram(
                        fontProgram);
                return getFontProgramList(font);
            }
			if (TYPE0_STRING.equals(this.getSubtype())) {
			    GFFontProgram font = new GFFontProgram(fontProgram,
			            (GFPDFont) ((GFPDType0Font) this).getLinkedObjects(GFPDType0Font.DESCENDANT_FONTS).get(0));
			    return getFontProgramList(font);
			}
			GFFontProgram font = new GFFontProgram(fontProgram,
			        this);
			return getFontProgramList(font);
        }
		return Collections.emptyList();
    }

    private static List<FontProgram> getFontProgramList(FontProgram fontProgram) {
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
        return this.pdFont.getEncodingMapping();
    }
}
