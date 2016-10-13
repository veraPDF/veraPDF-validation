package org.verapdf.gf.model.impl.pd.colors;

import org.verapdf.gf.model.factory.colors.ColorSpaceFactory;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDColorSpace;
import org.verapdf.model.pdlayer.PDIndexed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDIndexed extends GFPDColorSpace implements PDIndexed {

    public static final String INDEXED_TYPE = "PDIndexed";

    public static final String BASE = "base";

    public GFPDIndexed(
            org.verapdf.pd.colors.PDIndexed simplePDObject) {
        super(simplePDObject, INDEXED_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (BASE.equals(link)) {
            return this.getBase();
        }
        return super.getLinkedObjects(link);
    }

    private List<PDColorSpace> getBase() {
        org.verapdf.pd.colors.PDColorSpace baseColorSpace =
                ((org.verapdf.pd.colors.PDIndexed) this.simplePDObject).getBase();
        PDColorSpace colorSpace = ColorSpaceFactory.getColorSpace(baseColorSpace);
        if (colorSpace != null) {
            List<PDColorSpace> base = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            base.add(colorSpace);
            return Collections.unmodifiableList(base);
        }
        return Collections.emptyList();
    }
}
