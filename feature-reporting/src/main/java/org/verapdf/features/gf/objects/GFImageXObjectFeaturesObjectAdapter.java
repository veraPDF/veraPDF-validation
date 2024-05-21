/**
 * This file is part of veraPDF Feature Reporting, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
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

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSStream;
import org.verapdf.features.objects.ImageXObjectFeaturesObjectAdapter;
import org.verapdf.pd.PDMetadata;
import org.verapdf.pd.images.PDXImage;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Features object for image xobject
 *
 * @author Maksim Bezrukov
 */
public class GFImageXObjectFeaturesObjectAdapter implements ImageXObjectFeaturesObjectAdapter {

    private final PDXImage imageXObject;
    private final String id;
    private final String colorSpaceChild;
    private final String maskChild;
    private final String sMaskChild;
    private final Set<String> alternatesChild;

    /**
     * Constructs new shading features object
     *
     * @param imageXObject    PDXImage which represents image xobject for feature
     *                        report
     * @param id              id of the object
     * @param colorSpaceChild colorSpace id which contains in this image xobject
     * @param maskChild       image xobject id which contains in this image xobject as it's
     *                        mask
     * @param sMaskChild      image xobject id which contains in this image xobject as it's
     *                        smask
     * @param alternatesChild set of image xobject ids which contains in this image xobject
     *                        as alternates
     */
    public GFImageXObjectFeaturesObjectAdapter(PDXImage imageXObject, String id, String colorSpaceChild,
                                               String maskChild, String sMaskChild, Set<String> alternatesChild) {
        this.imageXObject = imageXObject;
        this.id = id;
        this.colorSpaceChild = colorSpaceChild;
        this.maskChild = maskChild;
        this.sMaskChild = sMaskChild;
        this.alternatesChild = alternatesChild;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public Long getWidth() {
        return imageXObject == null || imageXObject.empty() ? null : imageXObject.getWidth();
    }

    @Override
    public Long getHeight() {
        return imageXObject == null || imageXObject.empty() ? null : imageXObject.getHeight();
    }

    @Override
    public String getColorSpaceChild() {
        return this.colorSpaceChild;
    }

    @Override
    public Long getBitsPerComponent() {
        return imageXObject == null || imageXObject.empty() ? null : imageXObject.getBitsPerComponent();
    }

    @Override
    public boolean getImageMask() {
        return imageXObject == null || imageXObject.empty() ? false : imageXObject.getImageMask();
    }

    @Override
    public String getMaskChild() {
        return this.maskChild;
    }

    @Override
    public boolean isInterpolate() {
        return imageXObject == null || imageXObject.empty() ? false : imageXObject.isInterpolate();
    }

    @Override
    public Set<String> getAlternatesChild() {
        return this.alternatesChild == null ?
                Collections.emptySet() : Collections.unmodifiableSet(this.alternatesChild);
    }

    @Override
    public String getSMaskChild() {
        return this.sMaskChild;
    }

    @Override
    public Long getStructParent() {
        return imageXObject == null || imageXObject.empty() ? null : imageXObject.getStructParent();
    }

    @Override
    public List<String> getFilters() {
        if (imageXObject != null) {
            List<ASAtom> atomFilters = imageXObject.getFilters();
            List<String> res = new ArrayList<>(atomFilters.size());
            for (ASAtom filter : atomFilters) {
                res.add(filter.getValue());
            }
            return Collections.unmodifiableList(res);
        }
        return Collections.emptyList();
    }

    @Override
    public InputStream getMetadata() {
        if (imageXObject != null && !imageXObject.empty()) {
            PDMetadata metadata = imageXObject.getMetadata();
            return metadata == null ? null : metadata.getStream();
        }
        return null;
    }

    @Override
    public InputStream getRawStreamData() {
        if (imageXObject != null && !imageXObject.empty()) {
            return imageXObject.getObject().getData();
        }
        return null;
    }

    @Override
    public List<StreamFilterAdapter> getFilterAdapters() {
        if (imageXObject != null && !imageXObject.empty()) {
            COSObject base = imageXObject.getKey(ASAtom.DECODE_PARMS);
            List<StreamFilterAdapter> res = new ArrayList<>();
            if (base != null) {
                if (base.getType() == COSObjType.COS_DICT) {
                    res.add(new GFStreamFilterAdapter(base));
                } else if (base.getType() == COSObjType.COS_ARRAY) {
                    for (COSObject baseElem : (COSArray) base.getDirectBase()) {
                        if (baseElem.getType() == COSObjType.COS_DICT) {
                            res.add(new GFStreamFilterAdapter(baseElem));
                        } else {
                            res.add(null);
                        }
                    }
                }
            }
            return Collections.unmodifiableList(res);
        }
        return Collections.emptyList();
    }

    @Override
    public boolean isPDFObjectPresent() {
        return imageXObject != null && !imageXObject.empty();
    }

    @Override
    public List<String> getErrors() {
        return Collections.emptyList();
    }

    private static class GFStreamFilterAdapter implements StreamFilterAdapter{

        private final COSObject base;

        GFStreamFilterAdapter(COSObject base) {
            this.base = base == null ? COSObject.getEmpty() : base;
        }

        @Override
        public Long getCCITTK() {
            return base.getIntegerKey(ASAtom.K);
        }

        @Override
        public boolean getCCITTEndOfLine() {
            return base.getBooleanKey(ASAtom.COLORS);
        }

        @Override
        public boolean getCCITTEncodedByteAlign() {
            return base.getBooleanKey(ASAtom.BITS_PER_COMPONENT);
        }

        @Override
        public Long getCCITTColumns() {
            return base.getIntegerKey(ASAtom.COLUMNS);
        }

        @Override
        public Long getCCITTRows() {
            return base.getIntegerKey(ASAtom.ROWS);
        }

        @Override
        public boolean getCCITTEndOfBlock() {
            return base.getBooleanKey(ASAtom.getASAtom("EndOfBlock"));
        }

        @Override
        public boolean getCCITTBlackIs1() {
            return base.getBooleanKey(ASAtom.BLACK_IS_1);
        }

        @Override
        public Long getCCITTDamagedRowsBeforeError() {
            return base.getIntegerKey(ASAtom.getASAtom("DamagedRowsBeforeError"));
        }

        @Override
        public Long getDCTColorTransform() {
            return base.getIntegerKey(ASAtom.getASAtom("ColorTransform"));
        }

        @Override
        public Long getLZWEarlyChange() {
            return base.getIntegerKey(ASAtom.EARLY_CHANGE);
        }

        @Override
        public Long getFlatePredictor() {
            return base.getIntegerKey(ASAtom.PREDICTOR);
        }

        @Override
        public Long getFlateColors() {
            return base.getIntegerKey(ASAtom.COLORS);
        }

        @Override
        public Long getFlateBitsPerComponent() {
            return base.getIntegerKey(ASAtom.BITS_PER_COMPONENT);
        }

        @Override
        public Long getFlateColumns() {
            return base.getIntegerKey(ASAtom.COLUMNS);
        }

        @Override
        public InputStream getJBIG2Global() {
            COSObject globals = base.getKey(ASAtom.JBIG2_GLOBALS);
            if (globals.getType() == COSObjType.COS_STREAM) {
                return globals.getData(COSStream.FilterFlags.DECODE);
            }
            return null;
        }

        @Override
        public boolean hasCryptFilter() {
            return !ASAtom.IDENTITY.equals(base.getNameKey(ASAtom.NAME));
        }
    }
}
