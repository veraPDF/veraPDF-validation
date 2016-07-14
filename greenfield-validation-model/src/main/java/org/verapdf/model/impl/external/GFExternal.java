package org.verapdf.model.impl.external;

import org.verapdf.model.GenericModelObject;
import org.verapdf.model.external.External;

/**
 * This is parent type for all external objects embedded into the PDF document.
 * @author Sergey Shemyakov
 */
public class GFExternal extends GenericModelObject implements External  {

    protected GFExternal(String type) {
        super(type);
    }

}
