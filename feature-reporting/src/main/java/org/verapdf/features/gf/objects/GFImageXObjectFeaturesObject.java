/**
 * This file is part of feature-reporting, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * feature-reporting is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with feature-reporting as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * feature-reporting as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.features.gf.objects;

import org.verapdf.as.ASAtom;
import org.verapdf.core.FeatureParsingException;
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSStream;
import org.verapdf.features.FeatureExtractionResult;
import org.verapdf.features.FeatureObjectType;
import org.verapdf.features.FeaturesData;
import org.verapdf.features.ImageFeaturesData;
import org.verapdf.features.gf.tools.GFAdapterHelper;
import org.verapdf.features.tools.FeatureTreeNode;
import org.verapdf.pd.PDMetadata;
import org.verapdf.pd.images.PDXImage;

import java.io.InputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Features object for image xobject
 *
 * @author Maksim Bezrukov
 */
public class GFImageXObjectFeaturesObject implements IFeaturesObject {

    private static final Logger LOGGER = Logger.getLogger(GFImageXObjectFeaturesObject.class.getCanonicalName());

    private static final String ID = "id";

    private PDXImage imageXObject;
    private String id;
    private String colorSpaceChild;
    private String maskChild;
    private String sMaskChild;
    private Set<String> alternatesChild;

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
    public GFImageXObjectFeaturesObject(PDXImage imageXObject, String id, String colorSpaceChild,
                                        String maskChild, String sMaskChild, Set<String> alternatesChild) {
        this.imageXObject = imageXObject;
        this.id = id;
        this.colorSpaceChild = colorSpaceChild;
        this.maskChild = maskChild;
        this.sMaskChild = sMaskChild;
        this.alternatesChild = alternatesChild;
    }

    /**
     * @return IMAGE_XOBJECT instance of the FeatureObjectType enumeration
     */
    @Override
    public FeatureObjectType getType() {
        return FeatureObjectType.IMAGE_XOBJECT;
    }

    /**
     * Reports featurereport into collection
     *
     * @param collection collection for feature report
     * @return FeatureTreeNode class which represents a root node of the
     * constructed collection tree
     * @throws FeatureParsingException occurs when wrong features tree node constructs
     */
    @Override
    public FeatureTreeNode reportFeatures(FeatureExtractionResult collection) throws FeatureParsingException {
        if (imageXObject != null && !imageXObject.empty()) {
            FeatureTreeNode root = FeatureTreeNode.createRootNode("xobject");
            root.setAttribute("type", "image");
            if (id != null) {
                root.setAttribute(ID, id);
            }
            Long width = imageXObject.getWidth();
            if (width != null) {
                GFAdapterHelper.addNotEmptyNode("width", String.valueOf(width.longValue()), root);
            }
            Long height = imageXObject.getHeight();
            if (height != null) {
                GFAdapterHelper.addNotEmptyNode("height", String.valueOf(height.longValue()), root);
            }

            if (colorSpaceChild != null) {
                FeatureTreeNode shading = root.addChild("colorSpace");
                shading.setAttribute(ID, colorSpaceChild);
            }

            Long bitsPerComponent = imageXObject.getBitsPerComponent();
            if (bitsPerComponent != null) {
                GFAdapterHelper.addNotEmptyNode("bitsPerComponent", String.valueOf(bitsPerComponent.longValue()), root);
            }

            root.addChild("imageMask").setValue(String.valueOf(imageXObject.getImageMask()));

            if (maskChild != null) {
                FeatureTreeNode mask = root.addChild("mask");
                mask.setAttribute(ID, maskChild);
            }

            GFAdapterHelper.addNotEmptyNode("interpolate", String.valueOf(imageXObject.isInterpolate()), root);
            GFAdapterHelper.parseIDSet(alternatesChild, "alternate", "alternates", root);
            if (sMaskChild != null) {
                FeatureTreeNode mask = root.addChild("sMask");
                mask.setAttribute(ID, sMaskChild);
            }

            Long struct = imageXObject.getStructParent();
            if (struct != null) {
                GFAdapterHelper.addNotEmptyNode("structParent", String.valueOf(struct.longValue()), root);
            }

            List<ASAtom> filtersList = imageXObject.getFilters();
            if (!filtersList.isEmpty()) {
                FeatureTreeNode filters = root.addChild("filters");
                for (ASAtom name : filtersList) {
                    GFAdapterHelper.addNotEmptyNode("filter", name.getValue(), filters);
                }
            }

            GFAdapterHelper.parseMetadata(imageXObject.getMetadata(), "metadata", root, collection);

            collection.addNewFeatureTree(FeatureObjectType.IMAGE_XOBJECT, root);
            return root;
        }

        return null;
    }

    /**
     * @return null if it can not get image xobject stream and features data of
     * the image in other case.
     */
    @Override
    public FeaturesData getData() {
        if (imageXObject != null && !imageXObject.empty()) {
            InputStream metadata = null;
            PDMetadata pdMetadata = imageXObject.getMetadata();
            if (pdMetadata != null) {
                metadata = pdMetadata.getStream();
            }

            List<ImageFeaturesData.Filter> filters = new ArrayList<>();
            List<ASAtom> atomFilters = imageXObject.getFilters();
            if (!atomFilters.isEmpty()) {
                List<ASAtom> filtersNames = new ArrayList<>();
                List<COSObject> decodeList = getDecodeList(imageXObject.getKey(ASAtom.DECODE_PARMS));
                for (int i = 0; i < filtersNames.size(); ++i) {
                    ASAtom filterName = filtersNames.get(i);
                    COSObject dic = i < decodeList.size() ? decodeList.get(i) : null;
                    String filterNameValue = filterName.getValue();
                    switch (filterNameValue) {
                        case "LZWDecode":
                            filters.add(ImageFeaturesData.Filter.newInstance(filterNameValue, createLZWFilterMap(dic),
                                    null));
                            break;
                        case "FlateDecode":
                            filters.add(ImageFeaturesData.Filter.newInstance(filterNameValue, createFlatFilterMap(dic),
                                    null));
                            break;
                        case "CCITTFaxDecode":
                            filters.add(ImageFeaturesData.Filter.newInstance(filterNameValue, getCCITTFaxFiltersMap(dic), null));
                            break;
                        case "DCTDecode":
                            filters.add(ImageFeaturesData.Filter.newInstance(filterNameValue, getDCTFiltersMap(dic), null));
                            break;
                        case "JBIG2Decode":
                            InputStream global = null;
                            if (dic != null) {
                                COSObject globals = dic.getKey(ASAtom.JBIG2_GLOBALS);
                                if (globals.getType() == COSObjType.COS_STREAM) {
                                    global = globals.getData(COSStream.FilterFlags.DECODE);
                                }
                            }
                            filters.add(ImageFeaturesData.Filter.newInstance(filterNameValue, new HashMap<String, String>(),
                                    global));
                            break;
                        case "Crypt":
                            if (dic == null || !ASAtom.IDENTITY.equals(dic.getNameKey(ASAtom.NAME))) {
                                LOGGER.log(Level.FINE, "An Image has a Crypt filter");
                                return null;
                            }
                            //$FALL-THROUGH$
                        default:
                            filters.add(
                                    ImageFeaturesData.Filter.newInstance(filterNameValue, new HashMap<String, String>(), null));
                    }
                }
            }

            Integer width = getIntegerWithDefault(imageXObject.getWidth(), null);
            Integer height = getIntegerWithDefault(imageXObject.getHeight(), null);

            return ImageFeaturesData.newInstance(metadata, imageXObject.getObject().getData(), width, height, filters);
        }
        return null;
    }

    private static List<COSObject> getDecodeList(COSObject base) {
        List<COSObject> res = new ArrayList<>();
        if (base != null) {
            if (base.getType() == COSObjType.COS_DICT) {
                res.add(base);
            } else if (base.getType() == COSObjType.COS_ARRAY) {
                for (COSObject baseElem : (COSArray) base.getDirectBase()) {
                    if (baseElem.getType() == COSObjType.COS_DICT) {
                        res.add(baseElem);
                    } else {
                        res.add(null);
                    }
                }
            }
        }

        return res;
    }

    private static Map<String, String> getCCITTFaxFiltersMap(COSObject base) {
        Map<String, String> res = new HashMap<>();
        if (base != null) {
            putIntegerAsStringWithDefault(res, "K", base.getIntegerKey(ASAtom.K), Integer.valueOf(0));
            putBooleanAsStringWithDefault(res, "EndOfLine", base.getBooleanKey(ASAtom.COLORS), Boolean.FALSE);
            putBooleanAsStringWithDefault(res, "EncodedByteAlign", base.getBooleanKey(ASAtom.BITS_PER_COMPONENT),
                    Boolean.FALSE);
            putIntegerAsStringWithDefault(res, "Columns", base.getIntegerKey(ASAtom.COLUMNS),
                    Integer.valueOf(1728));
            putIntegerAsStringWithDefault(res, "Rows", base.getIntegerKey(ASAtom.A.ROWS), Integer.valueOf(0));
            putBooleanAsStringWithDefault(res, "EndOfBlock", base.getBooleanKey(ASAtom.getASAtom("EndOfBlock")),
                    Boolean.TRUE);
            putBooleanAsStringWithDefault(res, "BlackIs1", base.getBooleanKey(ASAtom.BLACK_IS_1), Boolean.FALSE);
            putIntegerAsStringWithDefault(res, "DamagedRowsBeforeError",
                    base.getIntegerKey(ASAtom.getASAtom("DamagedRowsBeforeError")), Integer.valueOf(0));
        } else {
            res.put("K", "0");
            res.put("EndOfLine", "false");
            res.put("EncodedByteAlign", "false");
            res.put("Columns", "1728");
            res.put("Rows", "0");
            res.put("EndOfBlock", "true");
            res.put("BlackIs1", "false");
            res.put("DamagedRowsBeforeError", "0");
        }

        return res;
    }

    private static Map<String, String> getDCTFiltersMap(COSObject base) {
        Map<String, String> res = new HashMap<>();
        if (base != null) {
            Long colorTransform = base.getIntegerKey(ASAtom.getASAtom("ColorTransform"));
            if (colorTransform != null) {
                res.put("ColorTransform", String.valueOf(colorTransform.longValue()));
            }
        }
        return res;
    }

    private static Map<String, String> createLZWFilterMap(COSObject base) {
        if (base == null) {
            Map<String, String> retVal = createDefaultFlatFilterMap();
            retVal.put("EarlyChange", "1");
            return retVal;
        }

        Map<String, String> retVal = createFlatFilterMap(base);
        putIntegerAsStringWithDefault(retVal, "EarlyChange", base.getIntegerKey(ASAtom.EARLY_CHANGE),
                Integer.valueOf(1));
        return retVal;

    }

    private static Map<String, String> createFlatFilterMap(COSObject base) {
        if (base == null)
            return createDefaultFlatFilterMap();

        Map<String, String> res = new HashMap<>();

        putIntegerAsStringWithDefault(res, "Predictor", base.getIntegerKey(ASAtom.PREDICTOR),
                Integer.valueOf(1));
        putIntegerAsStringWithDefault(res, "Colors", base.getIntegerKey(ASAtom.COLORS), Integer.valueOf(1));
        putIntegerAsStringWithDefault(res, "BitsPerComponent", base.getIntegerKey(ASAtom.BITS_PER_COMPONENT),
                Integer.valueOf(8));
        putIntegerAsStringWithDefault(res, "Columns", base.getIntegerKey(ASAtom.COLUMNS), Integer.valueOf(1));
        return res;
    }

    private static Map<String, String> createDefaultFlatFilterMap() {
        Map<String, String> res = new HashMap<>();
        res.put("Predictor", "1");
        res.put("Colors", "1");
        res.put("BitsPerComponent", "8");
        res.put("Columns", "1");
        return res;
    }

    private static Integer getIntegerWithDefault(Long value, Integer defaultValue) {
        if (value != null) {
            return Integer.valueOf(value.intValue());
        }
        return defaultValue;
    }

    private static void putIntegerAsStringWithDefault(Map<String, String> map, String key, Long value,
                                                      Integer defaultValue) {
        if (value != null) {
            map.put(key, String.valueOf(value.longValue()));
        } else {
            if (defaultValue != null) {
                map.put(key, defaultValue.toString());
            }
        }
    }

    private static void putBooleanAsStringWithDefault(Map<String, String> map, String key, Boolean value,
                                                      Boolean defaultValue) {
        if (value != null) {
            map.put(key, String.valueOf(value.booleanValue()));
        } else {
            if (defaultValue != null) {
                map.put(key, defaultValue.toString());
            }
        }
    }
}
