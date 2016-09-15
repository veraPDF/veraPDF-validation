package org.verapdf.model.impl.pd.font;

import org.apache.log4j.Logger;
import org.verapdf.as.io.ASInputStream;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSStream;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosStream;
import org.verapdf.model.factory.operators.RenderingMode;
import org.verapdf.model.impl.containers.StaticContainers;
import org.verapdf.model.impl.cos.GFCosStream;
import org.verapdf.model.pdlayer.PDCIDFont;
import org.verapdf.pd.font.FontProgram;
import org.verapdf.pd.font.PDFont;
import org.verapdf.pd.font.cff.CFFCIDFontProgram;
import org.verapdf.pd.font.cff.CFFFontProgram;
import org.verapdf.pd.font.truetype.TrueTypeFontProgram;
import org.verapdf.pdfa.flavours.PDFAFlavour;

import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

/**
 * Represents CID Font dictionary.
 *
 * @author Sergey Shemyakov
 */
public class GFPDCIDFont extends GFPDFont implements PDCIDFont {

    private static final Logger LOGGER = Logger.getLogger(GFPDCIDFont.class);

    public static final String CID_FONT_TYPE = "PDCIDFont";

    public static final String CID_SET = "CIDSet";

    public static final String IDENTITY = "Identity";
    public static final String CUSTOM = "Custom";

    private boolean fontProgramParsed;

    public GFPDCIDFont(PDFont font, RenderingMode renderingMode) {
        super(font, renderingMode, CID_FONT_TYPE);
        if(font != null) {
            FontProgram program = font.getFontProgram();
            if(program != null) {
                try {
                    program.parseFont();
                    this.fontProgramParsed = true;
                } catch (IOException e) {
                    LOGGER.warn("Can't parse font program of font " + font.getName());
                    this.fontProgramParsed = false;
                }
            }
        }
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (CID_SET.equals(link)) {
            return this.getCIDSet();
        }
        return super.getLinkedObjects(link);
    }

    /**
     * @return link to the stream containing the value of the CIDSet entry in
     * the CID font descriptor dictionary.
     */
    private List<CosStream> getCIDSet() {
        COSStream cidSet = ((org.verapdf.pd.font.PDCIDFont) this.pdFont).getCIDSet();
        if (cidSet != null) {
            List<CosStream> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            list.add(new GFCosStream(cidSet));
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

    /**
     * @return string representation of the CIDtoGIDMap entry ("Identity", or
     * "Custom" in case of stream value).
     */
    @Override
    public String getCIDToGIDMap() {
        COSObject cidToGidObject =
                ((org.verapdf.pd.font.PDCIDFont) this.pdFont).getCIDToGIDMap();
        if (cidToGidObject.getType() == COSObjType.COS_STREAM) {
            return CUSTOM;
        }
        if (cidToGidObject.getType() == COSObjType.COS_NAME &&
                IDENTITY.equals(cidToGidObject.getString())) {
            return IDENTITY;
        }
        return null;
    }

    /**
     * @return true if the CIDSet is present and correctly lists all glyphs
     * present in the embedded font program.
     */
    @Override
    public Boolean getcidSetListsAllGlyphs() {
        if(!fontProgramParsed) {
            return Boolean.valueOf(false);
        }

        try {
            COSStream cidSet = getCIDSetStream();
            if (cidSet != null) {
                ASInputStream stream = cidSet.getData(COSStream.FilterFlags.DECODE);
                long length = cidSet.getLength();
                byte[] cidSetBytes = getCIDsFromCIDSet(stream, length);

                //reverse bit order in bit set (convert to big endian)
                BitSet bitSet = toBitSetBigEndian(cidSetBytes);

                FontProgram cidFont = this.pdFont.getFontProgram();

                for (int i = 1; i < bitSet.size(); i++) {
                    if (bitSet.get(i) && !cidFont.containsCode(i)) {
                        return Boolean.FALSE;
                    }
                }

                PDFAFlavour flavour = StaticContainers.getFlavour();
                if (!flavour.equals(PDFAFlavour.PDFA_1_A) || !flavour.equals(PDFAFlavour.PDFA_1_B)) {
                    //on this levels we need to ensure that all glyphs present in font program are described in cid set
                    if (cidFont instanceof CFFFontProgram && ((CFFFontProgram) cidFont).isCIDFont()) {
                        CFFCIDFontProgram cffCidFont = (CFFCIDFontProgram) ((CFFFontProgram) cidFont).getFont();
                        if (bitSet.cardinality() < cffCidFont.getNGlyphs()) {
                            return Boolean.FALSE;
                        }
                    } else if (cidFont instanceof TrueTypeFontProgram) {
                        if (bitSet.cardinality() < ((TrueTypeFontProgram) cidFont).getNGlyphs()) {
                            return Boolean.FALSE;
                        }
                    }
                }

            }
        } catch (IOException e) {
            LOGGER.debug("Error while parsing embedded font program. " + e.getMessage(), e);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private COSStream getCIDSetStream() {
        COSDictionary fontDescriptor = this.pdFont.getFontDescriptor();
        COSStream cidSet;
        if (fontDescriptor != null) {
            cidSet = ((org.verapdf.pd.font.PDCIDFont) this.pdFont).getCIDSet();
            return cidSet;
        }
        return null;
    }

    private byte[] getCIDsFromCIDSet(ASInputStream cidSet, long length) throws IOException {
        byte[] cidSetBytes = new byte[(int) length];
        if (cidSet.read(cidSetBytes) != length) {
            LOGGER.debug("Did not read necessary number of cid set bytes");
        }
        return cidSetBytes;
    }

    private BitSet toBitSetBigEndian(byte[] source) {
        BitSet bitSet = new BitSet(source.length * 8);
        int i = 0;
        for (int j = 0; j < source.length; j++) {
            int b = source[j] >= 0 ? source[j] : 256 + source[j];
            for (int k = 0; k < 8; k++) {
                bitSet.set(i++, (b & 0x80) != 0);
                b = b << 1;
            }
        }
        return bitSet;
    }
}
