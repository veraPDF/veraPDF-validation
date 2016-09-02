package org.verapdf.model.impl.pd.font;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSStream;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.factory.operators.RenderingMode;
import org.verapdf.model.impl.pd.GFPDContentStream;
import org.verapdf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.pdlayer.PDContentStream;
import org.verapdf.model.pdlayer.PDType3Font;
import org.verapdf.pd.PDFont;
import org.verapdf.pd.PDResources;
import org.verapdf.pd.PDType3CharProc;

import java.util.*;

/**
 * Represents Type3 font dictionary.
 *
 * @author Sergey Shemyakov
 */
public class GFPDType3Font extends GFPDSimpleFont implements PDType3Font {

    public static final String TYPE3_FONT_TYPE = "PDType3Font";

    public static final String CHAR_STRINGS = "charStrings";
    private PDResources resources;
    private Map<ASAtom, PDContentStream> charStrings = null;

    public GFPDType3Font(PDFont font, RenderingMode renderingMode, PDResources resources) {
        super(font, renderingMode, TYPE3_FONT_TYPE);
        this.resources = resources;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getisStandard() {
        return Boolean.valueOf(false);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (CHAR_STRINGS.equals(link)) {
            return this.getCharStrings();
        }
        return super.getLinkedObjects(link);
    }

    /**
     * @return character strings.
     */
    private List<PDContentStream> getCharStrings() {
        if (this.charStrings == null) {
            parseCharStrings();
        }
        return new ArrayList<>(this.charStrings.values());
    }

    public Map<ASAtom, PDContentStream> getCharProcStreams() {
        if (this.charStrings == null) {
            parseCharStrings();
        }
        return Collections.unmodifiableMap(this.charStrings);
    }

    private void parseCharStrings() {
        COSDictionary charProcDict = (COSDictionary)
                this.pdFont.getDictionary().getKey(ASAtom.CHAR_PROCS).get();
        if (charProcDict != null) {
            Set<ASAtom> keySet = charProcDict.getKeySet();
            Map<ASAtom, PDContentStream> map = new HashMap<>(keySet.size());
            for (ASAtom glyphName : keySet) {
                PDType3CharProc charProc = new PDType3CharProc((COSStream)
                        charProcDict.getKey(glyphName).get());
                GFPDContentStream contentStream =
                        new GFPDContentStream(charProc,
                                PDResourcesHandler.getInstance(this.resources, true));  //TODO: is true in creating ResourceHandler correct?
                map.put(glyphName, contentStream);
            }
            this.charStrings = Collections.unmodifiableMap(map);
        } else {
            this.charStrings = Collections.emptyMap();
        }
    }
}
