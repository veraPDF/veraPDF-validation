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
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSStream;
import org.verapdf.features.*;
import org.verapdf.features.gf.tools.GFCreateNodeHelper;
import org.verapdf.features.tools.FeatureTreeNode;
import org.verapdf.pd.PDMetadata;
import org.verapdf.pd.font.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Feature object for fonts.
 *
 * @author Sergey Shemyakov
 */
public class GFFontFeaturesObject implements IFeaturesObject {

    private static final Logger LOGGER = Logger
            .getLogger(GFFontFeaturesObject.class.getCanonicalName());

    private static final String ID = "id";

    private org.verapdf.pd.font.PDFont font;
    private String id;
    private Set<String> extGStateChild;
    private Set<String> colorSpaceChild;
    private Set<String> patternChild;
    private Set<String> shadingChild;
    private Set<String> xobjectChild;
    private Set<String> fontChild;
    private Set<String> propertiesChild;

    public GFFontFeaturesObject(org.verapdf.pd.font.PDFont font, String id, Set<String>
            extGStateChild, Set<String> colorSpaceChild, Set<String> patternChild,
                                Set<String> shadingChild, Set<String> xobjectChild,
                                Set<String> fontChild, Set<String> propertiesChild) {
        this.font = font;
        this.id = id;
        this.extGStateChild = extGStateChild;
        this.colorSpaceChild = colorSpaceChild;
        this.patternChild = patternChild;
        this.shadingChild = shadingChild;
        this.xobjectChild = xobjectChild;
        this.fontChild = fontChild;
        this.propertiesChild = propertiesChild;
    }

    @Override
    public FeatureObjectType getType() {
        return FeatureObjectType.FONT;
    }

    @Override
    public FeatureTreeNode reportFeatures(FeatureExtractionResult collection) throws FeatureParsingException {
        if (font != null && !font.empty()) {
            FeatureTreeNode root = FeatureTreeNode.createRootNode("font");
            if (id != null) {
                root.setAttribute(ID, id);
            }

            ASAtom fontSubtype = font.getSubtype();
            GFCreateNodeHelper.addNotEmptyNode("type", fontSubtype, root);

            if (!(fontSubtype == ASAtom.TYPE3)) {
                GFCreateNodeHelper.addNotEmptyNode("baseFont", font.getName(), root);
            }

            if (fontSubtype == ASAtom.TYPE0) {
                GFCreateNodeHelper.parseIDSet(fontChild, "descendantFont", null, root.addChild("descendantFonts"));
                parseFontDescriptior(this.font.getFontDescriptor(), root, collection);
            } else if (fontSubtype == ASAtom.TRUE_TYPE ||
                    fontSubtype == ASAtom.TYPE1 ||
                    fontSubtype == ASAtom.MM_TYPE1 ||
                    fontSubtype == ASAtom.TYPE3) {
                PDSimpleFont sFont = (PDSimpleFont) font;

                Long fc = sFont.getFirstChar();
                if (fc != null && fc.longValue() != -1) {
                    root.addChild("firstChar").setValue(String.valueOf(fc.longValue()));
                }
                Long lc = sFont.getLastChar();
                if (lc != null && lc.longValue() != -1) {
                    root.addChild("lastChar").setValue(String.valueOf(lc.longValue()));
                }

                parseWidths(sFont.getWidths(), fc, root.addChild("widths"));

                COSObject enc = sFont.getEncoding();
                if (enc.getType() == COSObjType.COS_NAME) {
                    GFCreateNodeHelper.addNotEmptyNode("encoding", enc, root);
                } else if (enc.getType() == COSObjType.COS_DICT) {
                    ASAtom name = enc.getNameKey(ASAtom.BASE_ENCODING);
                    if (name != null) {
                        GFCreateNodeHelper.addNotEmptyNode("encoding", name, root);
                    }
                }

                if (this.font.getSubtype() != ASAtom.TYPE3) {
                    parseFontDescriptior(this.font.getFontDescriptor(), root, collection);
                }

                if (sFont.getSubtype() == ASAtom.TYPE3) {
                    PDType3Font type3 = (PDType3Font) sFont;

                    GFCreateNodeHelper.addBoxFeature("fontBBox", type3.getFontBoundingBox(), root);
                    GFCreateNodeHelper.parseMatrix(type3.getFontMatrix(), root.addChild("fontMatrix"));

                    parseResources(root);
                }

            } else if (fontSubtype == ASAtom.CID_FONT_TYPE0 ||
                    fontSubtype == ASAtom.CID_FONT_TYPE2) {
                PDCIDFont cid = (PDCIDFont) font;
                Double dw = cid.getDefaultWidth();
                root.addChild("defaultWidth").setValue(String.valueOf(dw));

                PDCIDSystemInfo cidSystemInfo = cid.getCIDSystemInfo();
                if (cidSystemInfo != null) {
                    FeatureTreeNode cidS = root.addChild("cidSystemInfo");
                    GFCreateNodeHelper.addNotEmptyNode("registry", cidSystemInfo.getRegistry(), cidS);
                    GFCreateNodeHelper.addNotEmptyNode("ordering", cidSystemInfo.getOrdering(), cidS);
                    Long supplement = cidSystemInfo.getSupplement();
                    if (supplement != null) {
                        cidS.addChild("supplement").setValue(String.valueOf(supplement));
                    }
                }
                parseFontDescriptior(font.getFontDescriptor(), root, collection);
            }

            collection.addNewFeatureTree(FeatureObjectType.FONT, root);
            return root;
        }

        return null;
    }

    /**
     * @return null if it can not get font file stream and features data of the font file and descriptor in other case.
     */
    @Override
    public FeaturesData getData() {
        if (font != null  && !font.empty()) {
            PDFontDescriptor descriptor = font.getFontDescriptor();
            if (descriptor != null && !descriptor.empty()) {
                COSStream file = descriptor.getFontFile();
                if (file == null) {
                    file = descriptor.getFontFile2();
                }
                if (file == null) {
                    file = descriptor.getFontFile3();
                }
                if (file != null) {
                    FontFeaturesData.Builder builder = new FontFeaturesData.Builder(
                            file.getData(COSStream.FilterFlags.DECODE));

                    InputStream metadata = null;
                    COSObject cosMetadata = file.getKey(ASAtom.METADATA);
                    if (cosMetadata.getType() == COSObjType.COS_STREAM) {
                        metadata = cosMetadata.getData(COSStream.FilterFlags.DECODE);
                    }
                    builder.metadata(metadata);

                    builder.fontName(GFCreateNodeHelper.getStringFromASAtom(descriptor.getFontName()));
                    builder.fontFamily(descriptor.getFontFamily());
                    builder.fontStretch(GFCreateNodeHelper.getStringFromASAtom(descriptor.getFontStretch()));
                    builder.fontWeight(descriptor.getFontWeight());
                    Long flags = descriptor.getFlags();
                    builder.flags(flags == null ? null : flags.intValue());
                    double[] rex = descriptor.getFontBoundingBox();
                    if (rex != null) {
                        List<Double> rect = new ArrayList<>(rex.length);
                        for (int i = 0; i < rex.length; ++i) {
                            rect.add(rex[i]);
                        }
                        builder.fontBBox(rect);
                    }
                    COSObject descriptorDict = descriptor.getObject();

                    builder.italicAngle(descriptor.getItalicAngle());
                    builder.ascent(descriptor.getAscent());
                    builder.descent(descriptor.getDescent());
                    builder.leading(getDoubleFromDict(ASAtom.LEADING, descriptorDict));
                    builder.capHeight(descriptor.getCapHeight());
                    builder.xHeight(getDoubleFromDict(ASAtom.XHEIGHT, descriptorDict));
                    builder.stemV(descriptor.getStemV());
                    builder.stemH(getDoubleFromDict(ASAtom.STEM_H, descriptorDict));
                    builder.avgWidth(getDoubleFromDict(ASAtom.AVG_WIDTH, descriptorDict));
                    builder.maxWidth(getDoubleFromDict(ASAtom.MAX_WIDTH, descriptorDict));
                    builder.missingWidth(getDoubleFromDict(ASAtom.MISSING_WIDTH, descriptorDict));
                    builder.charSet(descriptor.getCharSet());

                    return builder.build();
                }
            }
        }
        return null;
    }


    private static void parseFontDescriptior(PDFontDescriptor descriptor,
                                             FeatureTreeNode root,
                                             FeatureExtractionResult collection) throws FeatureParsingException {
        if (descriptor != null && !descriptor.empty()) {
            FeatureTreeNode descriptorNode = root.addChild("fontDescriptor");

            GFCreateNodeHelper.addNotEmptyNode("fontName", descriptor.getFontName(), descriptorNode);
            GFCreateNodeHelper.addNotEmptyNode("fontFamily", descriptor.getFontFamily(), descriptorNode);
            GFCreateNodeHelper.addNotEmptyNode("fontStretch", descriptor.getFontStretch(), descriptorNode);
            GFCreateNodeHelper.addNotEmptyNode("fontWeight", getStringFromDouble(descriptor.getFontWeight()), descriptorNode);
            descriptorNode.addChild("fixedPitch").setValue(String.valueOf(descriptor.isFixedPitch()));
            descriptorNode.addChild("serif").setValue(String.valueOf(descriptor.isSerif()));
            descriptorNode.addChild("symbolic").setValue(String.valueOf(descriptor.isSymbolic()));
            descriptorNode.addChild("script").setValue(String.valueOf(descriptor.isScript()));
            descriptorNode.addChild("nonsymbolic").setValue(String.valueOf(descriptor.isNonsymbolic()));
            descriptorNode.addChild("italic").setValue(String.valueOf(descriptor.isItalic()));
            descriptorNode.addChild("allCap").setValue(String.valueOf(descriptor.isAllCap()));
            descriptorNode.addChild("smallCap").setValue(String.valueOf(descriptor.isScript()));
            descriptorNode.addChild("forceBold").setValue(String.valueOf(descriptor.isForceBold()));
            GFCreateNodeHelper.addBoxFeature("fontBBox", descriptor.getFontBoundingBox(), descriptorNode);

            GFCreateNodeHelper.addNotEmptyNode("italicAngle", getStringFromDouble(descriptor.getItalicAngle()), descriptorNode);
            GFCreateNodeHelper.addNotEmptyNode("ascent", getStringFromDouble(descriptor.getAscent()), descriptorNode);
            GFCreateNodeHelper.addNotEmptyNode("descent", getStringFromDouble(descriptor.getDescent()), descriptorNode);
            GFCreateNodeHelper.addNotEmptyNode("leading", getStringFromDouble(descriptor.getLeading()), descriptorNode);
            GFCreateNodeHelper.addNotEmptyNode("capHeight", getStringFromDouble(descriptor.getCapHeight()), descriptorNode);
            GFCreateNodeHelper.addNotEmptyNode("xHeight", getStringFromDouble(descriptor.getXHeight()), descriptorNode);
            GFCreateNodeHelper.addNotEmptyNode("stemV", getStringFromDouble(descriptor.getStemV()), descriptorNode);
            GFCreateNodeHelper.addNotEmptyNode("stemH", getStringFromDouble(descriptor.getStemH()), descriptorNode);
            GFCreateNodeHelper.addNotEmptyNode("averageWidth", getStringFromDouble(descriptor.getAvgWidth()), descriptorNode);
            GFCreateNodeHelper.addNotEmptyNode("maxWidth", getStringFromDouble(descriptor.getMaxWidth()), descriptorNode);
            GFCreateNodeHelper.addNotEmptyNode("missingWidth", getStringFromDouble(descriptor.getMissingWidth()), descriptorNode);
            GFCreateNodeHelper.addNotEmptyNode("charSet", descriptor.getCharSet(), descriptorNode);

            COSStream file = descriptor.getFontFile();
            if (file == null) {
                file = descriptor.getFontFile2();
            }
            if (file == null) {
                file = descriptor.getFontFile3();
            }

            descriptorNode.addChild("embedded").setValue(String.valueOf(file != null));
            if (file != null) {
                PDMetadata fontProgramMetadata = new PDMetadata(file.getKey(ASAtom.METADATA));
                GFCreateNodeHelper.parseMetadata(fontProgramMetadata, "embeddedFileMetadata", descriptorNode, collection);
            }
        }
    }

    private static void parseWidths(COSObject array, Long firstChar,
                                    FeatureTreeNode parent) throws FeatureParsingException {
        if (firstChar != null) {
            if (array.getType() == COSObjType.COS_ARRAY) {
                int fc = firstChar.intValue() == -1 ? 0 : firstChar.intValue();
                for (int i = 0; i < array.size(); ++i) {
                    FeatureTreeNode element = parent.addChild("width");
                    COSObject arElement = array.at(i);
                    if (arElement.getType().isNumber()) {
                        element.setValue(String.valueOf(arElement.getInteger()));
                    }
                    element.setAttribute("char", String.valueOf(i + fc));
                }
            }
        }
    }

    private void parseResources(FeatureTreeNode root) throws FeatureParsingException {

        if ((extGStateChild != null && !extGStateChild.isEmpty()) ||
                (colorSpaceChild != null && !colorSpaceChild.isEmpty()) ||
                (patternChild != null && !patternChild.isEmpty()) ||
                (shadingChild != null && !shadingChild.isEmpty()) ||
                (xobjectChild != null && !xobjectChild.isEmpty()) ||
                (fontChild != null && !fontChild.isEmpty()) ||
                (propertiesChild != null && !propertiesChild.isEmpty())) {
            FeatureTreeNode resources = root.addChild("resources");

            GFCreateNodeHelper.parseIDSet(extGStateChild, "graphicsState", "graphicsStates", resources);
            GFCreateNodeHelper.parseIDSet(colorSpaceChild, "colorSpace", "colorSpaces", resources);
            GFCreateNodeHelper.parseIDSet(patternChild, "pattern", "patterns", resources);
            GFCreateNodeHelper.parseIDSet(shadingChild, "shading", "shadings", resources);
            GFCreateNodeHelper.parseIDSet(xobjectChild, "xobject", "xobjects", resources);
            GFCreateNodeHelper.parseIDSet(fontChild, "font", "fonts", resources);
            GFCreateNodeHelper.parseIDSet(propertiesChild, "propertiesDict", "propertiesDicts", resources);
        }
    }

    private Double getDoubleFromDict(ASAtom key, COSObject dict) {
        COSObject res = dict.getKey(key);
        if (!res.getType().isNumber()) {
            return null;
        } else {
            return res.getReal();
        }
    }

    private static String getStringFromDouble(Double d) {
        return d == null ? null : Double.toString(d);
    }
}
