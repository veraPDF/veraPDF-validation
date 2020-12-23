/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.pd.actions;

import org.verapdf.gf.model.impl.pd.GFPDObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDAction;
import org.verapdf.model.pdlayer.PDAdditionalActions;
import org.verapdf.pd.actions.PDAbstractAdditionalActions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxim Plushchov
 */
public class GFPDAdditionalActions extends GFPDObject implements PDAdditionalActions {

    public static final String ADDITIONAL_ACTIONS_TYPE = "PDAdditionalActions";

    public static final String ACTIONS = "Actions";

    public GFPDAdditionalActions(PDAbstractAdditionalActions additionalActions) {
        super(additionalActions, ADDITIONAL_ACTIONS_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case ACTIONS:
                return getActions();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<PDAction> getActions() {
        List<org.verapdf.pd.actions.PDAction> actions = ((PDAbstractAdditionalActions)simplePDObject).getActions();
        List<PDAction> pdActions = new ArrayList<>(actions.size());
        for(org.verapdf.pd.actions.PDAction action : actions) {
            this.addAction(pdActions, action);
        }
        return pdActions;
    }

    private void addAction(List<PDAction> actions, org.verapdf.pd.actions.PDAction raw) {
        PDAction action = GFPDAction.getAction(raw);
        if (action != null) {
            actions.add(action);
        }
    }

    @Override
    public Boolean getcontainsOtherActions() {
        return ((PDAbstractAdditionalActions)simplePDObject).containsOtherKeys();
    }
}
