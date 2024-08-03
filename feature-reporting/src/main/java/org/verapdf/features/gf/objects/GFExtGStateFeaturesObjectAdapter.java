/**
 * This file is part of veraPDF Feature Reporting, a module of the veraPDF project.
 * Copyright (c) 2015-2024, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Feature Reporting is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Feature Reporting as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Feature Reporting as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.features.gf.objects;

import org.verapdf.features.objects.ExtGStateFeaturesObjectAdapter;
import org.verapdf.pd.PDExtGState;

import java.util.Collections;
import java.util.List;

/**
 * Feature object for extended graphics state adapter
 *
 * @author Maksim Bezrukov
 */
public class GFExtGStateFeaturesObjectAdapter implements ExtGStateFeaturesObjectAdapter {

    private final PDExtGState exGState;
    private final String id;
    private final String fontChildID;

    /**
     * Constructs new extended graphics state feature object adapter
     *
     * @param exGState         PDExtendedGraphicsState which represents extended graphics state for feature report
     * @param id               id of the object
     * @param fontChildID      id of the font child
     */
    public GFExtGStateFeaturesObjectAdapter(PDExtGState exGState,
                                            String id,
                                            String fontChildID) {
        this.exGState = exGState;
        this.id = id;
        this.fontChildID = fontChildID;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getFontChildId() {
        return this.fontChildID;
    }

    @Override
    public Boolean getTransparency() {
        if (exGState != null && !exGState.empty()) {
            Boolean res = exGState.getAlphaSourceFlag();
            return res == null ? null : !res;
        }
        return null;
    }

    @Override
    public Boolean getStrokeAdjustment() {
        if (exGState != null && !exGState.empty()) {
            return exGState.getAutomaticStrokeAdjustment();
        }
        return null;
    }

    @Override
    public Boolean getOverprintForStroke() {
        if (exGState != null && !exGState.empty()) {
            return exGState.getStrokingOverprintControl();
        }
        return null;
    }

    @Override
    public Boolean getOverprintForFill() {
        if (exGState != null && !exGState.empty()) {
            return exGState.getNonStrokingOverprintControl();
        }
        return null;
    }

    @Override
    public boolean isPDFObjectPresent() {
        return exGState != null && !exGState.empty();
    }

    @Override
    public List<String> getErrors() {
        return Collections.emptyList();
    }
}
