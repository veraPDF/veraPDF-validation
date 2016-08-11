package org.verapdf.model.impl.operator.xobject;

import org.verapdf.cos.COSBase;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.impl.operator.base.GFOperator;
import org.verapdf.model.impl.pd.images.GFPDXObject;
import org.verapdf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.operator.Op_Do;
import org.verapdf.model.pdlayer.PDXObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFOp_Do extends GFOperator implements Op_Do {

	/** Type name for {@code GFOp_Do} */
    public static final String OP_DO_TYPE = "Op_Do";

	/** Name of link to the XObject */
    public static final String X_OBJECT = "xObject";

	private List<PDXObject> xObjects = null;

    private final org.verapdf.pd.images.PDXObject pbXObject;
	private final PDResourcesHandler resourcesHandler;

    public GFOp_Do(List<COSBase> arguments, org.verapdf.pd.images.PDXObject pbXObject,
				   PDResourcesHandler resourcesHandler) {
        super(arguments, OP_DO_TYPE);
        this.pbXObject = pbXObject;
		this.resourcesHandler = resourcesHandler;
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        if (X_OBJECT.equals(link)) {
            return this.getXObject();
        }
        return super.getLinkedObjects(link);
    }

	/**
	 * @return XObject object from veraPDF model used in current operator
	 */
	protected List<org.verapdf.model.pdlayer.PDXObject> getXObject() {
		if (this.xObjects == null) {
			PDXObject typedPDXObject = GFPDXObject.getTypedPDXObject(this.pbXObject, this.resourcesHandler);
			if (typedPDXObject != null) {
				List<PDXObject> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
				list.add(typedPDXObject);
				this.xObjects = Collections.unmodifiableList(list);
			} else {
				this.xObjects = Collections.emptyList();
			}
		}
		return this.xObjects;
	}

}
