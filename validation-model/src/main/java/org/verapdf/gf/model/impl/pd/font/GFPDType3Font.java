package org.verapdf.gf.model.impl.pd.font;

import org.apache.log4j.Logger;
import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.factory.operators.RenderingMode;
import org.verapdf.gf.model.impl.pd.GFPDContentStream;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDContentStream;
import org.verapdf.model.pdlayer.PDType3Font;
import org.verapdf.pd.PDType3CharProc;

import java.util.*;

/**
 * Represents Type3 font dictionary.
 *
 * @author Sergey Shemyakov
 */
public class GFPDType3Font extends GFPDSimpleFont implements PDType3Font {

    private static final Logger LOGGER = Logger.getLogger(GFPDType3Font.class);

    public static final String TYPE3_FONT_TYPE = "PDType3Font";

    public static final String CHAR_STRINGS = "charStrings";
    private PDResourcesHandler resources;
    private Map<ASAtom, PDContentStream> charStrings = null;

    public GFPDType3Font(org.verapdf.pd.font.PDType3Font font,
                         RenderingMode renderingMode, PDResourcesHandler resources) {
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
        COSDictionary charProcDict = ((org.verapdf.pd.font.PDType3Font)
                this.pdFont).getCharProcDict();
        if (charProcDict != null) {
            Set<ASAtom> keySet = charProcDict.getKeySet();
            Map<ASAtom, PDContentStream> map = new HashMap<>(keySet.size());
            for (ASAtom glyphName : keySet) {
                COSObject charProcStream = charProcDict.getKey(glyphName);
                if (!charProcStream.empty() && charProcDict.getType() == COSObjType.COS_DICT) {
                    PDType3CharProc charProc = new PDType3CharProc(charProcStream);
                    GFPDContentStream contentStream =
                            new GFPDContentStream(charProc, this.resources);
                    map.put(glyphName, contentStream);
                } else {
                    LOGGER.debug("Invalid entry in the char proc dictionary.");
                }
            }
            this.charStrings = Collections.unmodifiableMap(map);
        } else {
            this.charStrings = Collections.emptyMap();
        }
    }
}
