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
package org.verapdf.gf.model.impl.pd;

import org.verapdf.model.GenericModelObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.OutputIntents;
import org.verapdf.model.pdlayer.PDOutputIntent;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Maxim Plushchov
 */
public class GFOutputIntents extends GenericModelObject implements OutputIntents {

    public static final String OUTPUT_INTENTS_TYPE = "OutputIntents";

    public static final String OUTPUT_INTENTS = "outputIntents";

    List<org.verapdf.pd.PDOutputIntent> outInts = null;

    public GFOutputIntents(List<org.verapdf.pd.PDOutputIntent> outInts) {
        super(OUTPUT_INTENTS_TYPE);
        this.outInts = outInts;
    }

    @Override
    public Boolean getsameOutputProfileIndirect() {
        String destOutputProfileIndirect = null;
        for (org.verapdf.pd.PDOutputIntent outputIntent : outInts) {
            String currentOutputProfile = outputIntent.getDestOutputProfileIndirect();
            if (destOutputProfileIndirect != null && currentOutputProfile != null &&
                    !destOutputProfileIndirect.equals(currentOutputProfile)) {
                return false;
            }
            destOutputProfileIndirect = destOutputProfileIndirect == null ? currentOutputProfile : destOutputProfileIndirect;
        }
        return true;
    }

    @Override
    public String getoutputProfileIndirects() {
        return outInts.stream()
                .map(org.verapdf.pd.PDOutputIntent::getDestOutputProfileIndirect)
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.joining(","));
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case OUTPUT_INTENTS:
                return this.getOutputIntents();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<PDOutputIntent> getOutputIntents() {
        List<PDOutputIntent> res = new ArrayList<>(outInts.size());
            for (org.verapdf.pd.PDOutputIntent outInt : outInts) {
                res.add(new GFPDOutputIntent(outInt));
            }
        return res;
    }

    public String getColorSpace() {
        for (org.verapdf.pd.PDOutputIntent outputIntent : outInts) {
            String colorSpace = outputIntent.getColorSpace();
            if (colorSpace != null) {
                return colorSpace;
            }
        }
        return null;
    }
}
