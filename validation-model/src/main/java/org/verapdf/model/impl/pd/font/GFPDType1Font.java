package org.verapdf.model.impl.pd.font;

import org.apache.log4j.Logger;
import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.font.type1.Type1Font;
import org.verapdf.io.ASMemoryInStream;
import org.verapdf.model.factory.operators.RenderingMode;
import org.verapdf.model.pdlayer.PDType1Font;
import org.verapdf.parser.COSParser;
import org.verapdf.pd.PDFont;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * Represents Type1 font dictionary.
 *
 * @author Sergey Shemyakov
 */
public class GFPDType1Font extends GFPDSimpleFont implements PDType1Font {

    private static final Logger LOGGER = Logger.getLogger(GFPDType1Font.class);

    public static final String TYPE1_FONT_TYPE = "PDType1Font";
    public static final String NOTDEF_STRING = ".notdef";

    public GFPDType1Font(PDFont pdFont, RenderingMode renderingMode) {
        super(pdFont, renderingMode, TYPE1_FONT_TYPE);
    }


    /**
     * @return the value of the CharSet entry in the font descriptor dictionary.
     */
    @Override
    public String getCharSet() {
        String res = this.pdFont.getFontDescriptor().getStringKey(ASAtom.CHAR_SET);
        return res == null ? "" : res;
    }

    /**
     * @return true if the CharSet is present and correctly lists all glyphs
     * present in the embedded font program.
     */
    @Override
    public Boolean getcharSetListsAllGlyphs() {
        Set<String> descriptorCharSet = getDescriptorCharSet();
        String[] fontProgramCharSet =
                ((Type1Font) this.pdFont.getFontFile()).getEncoding();
        if (!(descriptorCharSet.size() == fontProgramCharSet.length)) {
            return Boolean.valueOf(false);
        }
        for(String glyphName : fontProgramCharSet) {
            if(!glyphName.equals(NOTDEF_STRING) &&
                    !descriptorCharSet.contains(glyphName)) {
                return Boolean.valueOf(false);
            }
        }
        return Boolean.valueOf(true);
    }

    private Set<String> getDescriptorCharSet() {
        String descriptorCharSetString =
                this.pdFont.getFontDescriptor().getStringKey(ASAtom.CHAR_SET);
        if (descriptorCharSetString != null) {
            try {
                ASMemoryInStream stream =
                        new ASMemoryInStream(descriptorCharSetString.getBytes());
                Set<String> descriptorCharSet = new TreeSet<>();
                COSParser parser = new COSParser(stream);
                COSObject glyphName = parser.nextObject();
                while (!glyphName.empty()) {
                    if (glyphName.getType() == COSObjType.COS_NAME) {
                        descriptorCharSet.add(glyphName.getString());
                    }
                    glyphName = parser.nextObject();
                }
                return descriptorCharSet;
            } catch (IOException ex) {
                LOGGER.error("Can't parse /CharSet entry in font descriptor");
                return Collections.emptySet();
            }
        }
        return Collections.emptySet();
    }
}
