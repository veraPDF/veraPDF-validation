package org.verapdf.model.impl.cos;

import org.apache.log4j.Logger;
import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSDocument;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.coslayer.CosObject;
import org.verapdf.model.visitor.cos.pb.GFCosVisitor;

/**
 * @author Timur Kamalov
 */
public class GFCosObject extends GenericModelObject implements CosObject {

    /** Type name for GFCosObject */
    private static final Logger LOGGER = Logger.getLogger(GFCosObject.class);

    public static final int MAX_NUMBER_OF_ELEMENTS = 1;

    protected final COSDocument cosDocument;
    protected final COSBase baseObject;

    protected GFCosObject(final String type) {
        super(type);
        this.baseObject = null;
        this.cosDocument = null;
    }

    protected GFCosObject(final COSBase baseObject, final String type) {
        super(type);
        this.baseObject = baseObject;
        this.cosDocument = null;
    }

    protected GFCosObject(final COSDocument cosDocument, final String type) {
        super(type);
        this.baseObject = null;
        this.cosDocument = cosDocument;
    }

    /**
     * Transform object of pdf box to corresponding object of abstract model
     * implementation. For transforming using {@code PBCosVisitor}.
     *
     * @param base
     * @return object of abstract model implementation, transformed from
     *         {@code base}
     */
    public static CosObject getFromValue(COSBase base) {
        if (base != null) {
            GFCosVisitor visitor = GFCosVisitor.getInstance();
            if (base.isIndirect()) {
                return (CosObject) base.getDirectBase().accept(visitor);
            }
            return (CosObject) base.accept(visitor);
        }
        return null;
    }

}
