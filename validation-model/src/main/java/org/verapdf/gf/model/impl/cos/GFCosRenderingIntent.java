package org.verapdf.gf.model.impl.cos;

import org.verapdf.cos.COSName;
import org.verapdf.model.coslayer.CosRenderingIntent;

/**
 * PDF Name representing rendering intent.
 * @author Sergey Shemyakov
 */
public class GFCosRenderingIntent extends GFCosName implements CosRenderingIntent {

    /** Type name for GFCosRenderingIntent */
    public static final String COS_RENDERING_INTENT_TYPE = "CosRenderingIntent";

    /**
     * Default constructor
     * @param cosName is rendering intent COSName.
     */
    public GFCosRenderingIntent(COSName cosName) {
        this(cosName, COS_RENDERING_INTENT_TYPE);
    }

    /**
     * Constructor for child classes
     * @param cosName is rendering intent COSName.
     * @param type child class type.
     */
    public GFCosRenderingIntent(COSName cosName, final String type) {
        super(cosName, type);
    }
}
