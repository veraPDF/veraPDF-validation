package org.verapdf.model.impl.cos;

import org.apache.log4j.Logger;
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSNumber;
import org.verapdf.model.coslayer.CosBBox;
import org.verapdf.pd.PDDocument;
import org.verapdf.pdfa.flavours.PDFAFlavour;

/**
 * Created by Timur on 4/8/2016.
 */
public class GFCosBBox extends GFCosArray implements CosBBox {

    private static final Logger LOGGER = Logger.getLogger(GFCosBBox.class);

    public static final String COS_BBOX_TYPE = "CosBBox";
    private static final int LEFT_CORNER_POSITION = 0;
    private static final int BOTTOM_CORNER_POSITION = 1;
    private static final int RIGHT_CORNER_POSITION = 2;
    private static final int TOP_CORNER_POSITION = 3;

    /**
     * Default constructor
     *
     * @param array greenfield COSArray
     */
    public GFCosBBox(COSArray array, PDDocument document, PDFAFlavour flavour) {
        super(array, COS_BBOX_TYPE, document, flavour);
    }

    /**
     * @return top corner of bounding box
     */
    @Override
    public Double gettop() {
        return this.getRequiredValue(TOP_CORNER_POSITION);
    }

    /**
     * @return bottom corner of bounding box
     */
    @Override
    public Double getbottom() {
        return this.getRequiredValue(BOTTOM_CORNER_POSITION);
    }

    /**
     * @return left corner of bounding box
     */
    @Override
    public Double getleft() {
        return this.getRequiredValue(LEFT_CORNER_POSITION);
    }

    /**
     * @return right corner of bounding box
     */
    @Override
    public Double getright() {
        return this.getRequiredValue(RIGHT_CORNER_POSITION);
    }

    private Double getRequiredValue(final int position) {
        COSArray array = (COSArray) this.baseObject;
        if (array.size() > position) {
            COSBase base = array.at(position).get();
            if (base instanceof COSNumber) {
                return base.getReal();
            } else {
                LOGGER.warn("In bbox expected number but got "
                        + base.getClass().getSimpleName());
            }
        } else {
            LOGGER.warn("Expected size of bbox array greater than"
                    + position + "but got " + array.size());
        }
        return null;
    }

}