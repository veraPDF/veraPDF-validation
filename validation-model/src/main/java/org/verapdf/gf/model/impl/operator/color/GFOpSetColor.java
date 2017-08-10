package org.verapdf.gf.model.impl.operator.color;

import org.verapdf.cos.COSBase;
import org.verapdf.gf.model.impl.cos.GFCosNumber;
import org.verapdf.gf.model.impl.operator.base.GFOperator;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.operator.OpSetColor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Set color operators without colorspace, Op_SC, Op_sc.
 *
 * @author Sergey Shemyakov
 */
public class GFOpSetColor extends GFOperator implements OpSetColor {

    /** Type name for {@code GFOpColor} */
    public static final String OP_SET_COLOR_TYPE = "OpSetColor";
    public static final String COLOR_VALUES = "colorValues";

    protected GFOpSetColor(List<COSBase> arguments, String type) {
        super(arguments, type);
    }

    public GFOpSetColor(List<COSBase> arguments) {
        this(arguments, OP_SET_COLOR_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case COLOR_VALUES:
                return getColorValues();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<CosNumber> getColorValues() {
        List<CosNumber> list = new ArrayList<>();
        for (COSBase base : this.arguments) {
            if (base != null && base.getType().isNumber()) {
                list.add(GFCosNumber.fromPDFParserNumber(base));
            }
        }
        return Collections.unmodifiableList(list);
    }
}
