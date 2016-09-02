package org.verapdf.model.impl.pd.font;

import org.apache.log4j.Logger;
import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.factory.operators.RenderingMode;
import org.verapdf.model.pdlayer.PDCIDFont;
import org.verapdf.model.pdlayer.PDCMap;
import org.verapdf.model.pdlayer.PDType0Font;
import org.verapdf.pd.PDFont;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents Type0 font dictionary.
 *
 * @author Sergey Shemyakov
 */
public class GFPDType0Font extends GFPDFont implements PDType0Font {

    private static final Logger LOGGER = Logger.getLogger(GFPDType0Font.class);

    public static final String TYPE_0_FONT_TYPE = "PDType0Font";

    public static final String DESCENDANT_FONTS = "DescendantFonts";
    public static final String ENCODING = "Encoding";

    private org.verapdf.pd.PDCMap pdcMap;
    private COSDictionary cidSystemInfo;

    public GFPDType0Font(org.verapdf.pd.PDFont font, RenderingMode renderingMode) {
        super(font, renderingMode, TYPE_0_FONT_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case DESCENDANT_FONTS:
                return this.getDescendantFonts();
            case ENCODING:
                return this.getEncoding();
            default:
                return super.getLinkedObjects(link);
        }
    }

    /**
     * @return link to the descendant CIDFont.
     */
    private List<PDCIDFont> getDescendantFonts() {
        COSDictionary cidFontDict = (COSDictionary)
                this.pdFont.getDictionary().getKey(ASAtom.DESCENDANT_FONTS).get();
        if (cidFontDict != null) {
            PDFont cidFont = new PDFont(cidFontDict);
            PDCIDFont pdCIDFont = new GFPDCIDFont(cidFont, renderingMode);
            List<PDCIDFont> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            list.add(pdCIDFont);
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

    /**
     * @return font CMap (Encoding entry).
     */
    private List<PDCMap> getEncoding() {
        if (this.getCMap() != null) {
            PDCMap res = new GFPDCmap(this.getCMap());
            List<PDCMap> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            list.add(res);
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

    /**
     * @return true if Registry and Ordering keys of the corresponding CMap and
     * CIDFont are compatible.
     */
    @Override
    public Boolean getareRegistryOrderingCompatible() {
        if (this.getCIDSystemInfo() == null) {
            LOGGER.error("CID font dictionary doesn't contain CIDSystemInfo");
            return Boolean.valueOf(false);
        }
        if (this.getCMap() == null) {
            LOGGER.error("Type 0 font dictionary doesn't contain Encoding");
            return Boolean.valueOf(false);
        }
        return this.isOrderingCompatible() && this.isRegistryCompatible();
    }

    /**
     * @return true if the Supplement key in the CIDFont is greater or equal to
     * the Supplement key in the CMap dictionary.
     */
    @Override
    public Boolean getisSupplementCompatible() {
        if (this.getCIDSystemInfo() == null) {
            LOGGER.error("CID font dictionary doesn't contain CIDSystemInfo");
            return Boolean.valueOf(false);
        }
        if (this.getCMap() == null) {
            LOGGER.error("Type 0 font dictionary doesn't contain Encoding");
            return Boolean.valueOf(false);
        }
        Long fontSupplement = this.getCIDSystemInfo().getIntegerKey(ASAtom.SUPPLEMENT);
        Long cMapSupplement = this.getCMap().getSupplement();
        if (fontSupplement == null) {
            LOGGER.error("CIDSystemInfo dictionary doesn't contain Supplement entry.");
            return Boolean.valueOf(false);
        }
        return fontSupplement >= cMapSupplement;
    }

    /**
     * @return the name of the CMap.
     */
    @Override
    public String getcmapName() {
        org.verapdf.pd.PDCMap pdcMap = this.getCMap();
        if (pdcMap == null) {
            return "";
        } else {
            return pdcMap.getCMapName();
        }
    }

    private org.verapdf.pd.PDCMap getCMap() {
        if (this.pdcMap == null) {
            COSObject cMap = this.pdFont.getDictionary().getKey(ASAtom.ENCODING);
            if (!cMap.empty()) {
                org.verapdf.pd.PDCMap pdcMap = new org.verapdf.pd.PDCMap(cMap);
                this.pdcMap = pdcMap;
                return pdcMap;
            } else {
                return null;
            }
        } else {
            return this.pdcMap;
        }
    }

    private COSDictionary getCIDSystemInfo() {
        if (this.cidSystemInfo == null) {
            COSDictionary cidFontDict = (COSDictionary)
                    this.pdFont.getDictionary().getKey(ASAtom.DESCENDANT_FONTS).get();
            if (cidFontDict != null) {
                COSDictionary cidSystemInfo =
                        (COSDictionary) cidFontDict.getKey(ASAtom.CID_SYSTEM_INFO).get();
                this.cidSystemInfo = cidSystemInfo;
                return cidSystemInfo;
            }
            return null;
        } else {
            return this.cidSystemInfo;
        }
    }

    private Boolean isRegistryCompatible() {
        String fontRegistry = this.getCIDSystemInfo().getStringKey(ASAtom.REGISTRY);
        String cMapRegistry = this.getCMap().getRegistry();
        if (fontRegistry == null) {
            LOGGER.error("CIDSystemInfo dictionary doesn't contain Registry entry.");
            return Boolean.valueOf(false);
        }
        return fontRegistry.equals(cMapRegistry);
    }

    private Boolean isOrderingCompatible() {
        String fontOrdering = this.getCIDSystemInfo().getStringKey(ASAtom.ORDERING);
        String cMapOrdering = this.getCMap().getOrdering();
        if (fontOrdering == null) {
            LOGGER.error("CIDSystemInfo dictionary doesn't contain Ordering entry.");
            return Boolean.valueOf(false);
        }
        return fontOrdering.equals(cMapOrdering);
    }
}
