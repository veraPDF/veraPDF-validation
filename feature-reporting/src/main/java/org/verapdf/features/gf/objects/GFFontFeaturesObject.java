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
        if (font != null) {
            FeatureTreeNode root = FeatureTreeNode.createRootNode("font");
            if (id != null) {
                root.setAttribute(ID, id);
            }

            GFCreateNodeHelper.addNotEmptyNode("type", font.getSubtype(), root);

            if (!(font instanceof PDType3Font)) {
                GFCreateNodeHelper.addNotEmptyNode("baseFont", font.getName(), root);
            }

            if (font instanceof PDType0Font) {
                GFCreateNodeHelper.parseIDSet(fontChild, "descendantFont", null, root.addChild("descendantFonts"));
                parseFontDescriptior(this.font.getFontDescriptor(), root, collection);
            } else if (font instanceof PDSimpleFont) {
                PDSimpleFont sFont = (PDSimpleFont) font;

                int fc = sFont.getFirstChar().intValue();
                if (fc != -1) {
                    root.addChild("firstChar").setValue(String.valueOf(fc));
                }
                int lc = sFont.getLastChar().intValue();
                if (lc != -1) {
                    root.addChild("lastChar").setValue(String.valueOf(lc));
                }

                parseWidths(sFont.getWidths(), fc, root.addChild("widths"));

                COSObject enc = sFont.getEncoding();
                if (enc.getType() == COSObjType.COS_NAME) {
                    GFCreateNodeHelper.addNotEmptyNode("encoding", enc.getName(), root);
                } else if (enc.getType() == COSObjType.COS_DICT) {
                    ASAtom name = (enc).getNameKey(ASAtom.BASE_ENCODING);
                    if (name != null) {
                        GFCreateNodeHelper.addNotEmptyNode("encoding", name, root);
                    }
                }

                parseFontDescriptior(this.font.getFontDescriptor(), root, collection);

                if (sFont instanceof PDType3Font) {
                    PDType3Font type3 = (PDType3Font) sFont;

                    GFCreateNodeHelper.addBoxFeature("fontBBox", type3.getFontBoundingBox(), root);
                    GFCreateNodeHelper.parseMatrix(type3.getFontMatrix(), root.addChild("fontMatrix"));

                    parseResources(root);
                }

            } else if (font instanceof PDCIDFont) {
                PDCIDFont cid = (PDCIDFont) font;
                GFCreateNodeHelper.addNotEmptyNode("type", cid.getSubtype(), root);
                GFCreateNodeHelper.addNotEmptyNode("baseFont", cid.getName(), root);
                Double dw = cid.getDefaultWidth();
                root.addChild("defaultWidth").setValue(String.valueOf(dw));

                if (cid.getCIDSystemInfo() != null) {
                    FeatureTreeNode cidS = root.addChild("cidSystemInfo");
                    GFCreateNodeHelper.addNotEmptyNode("registry", cid.getCIDSystemInfo().getRegistry(), cidS);
                    GFCreateNodeHelper.addNotEmptyNode("ordering", cid.getCIDSystemInfo().getOrdering(), cidS);
                    cidS.addChild("supplement").setValue(String.valueOf(cid.getCIDSystemInfo().getSupplement()));

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
        PDFontDescriptor descriptor = font.getFontDescriptor();
        if (descriptor != null) {
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

                builder.fontName(getStringFromASAtom(descriptor.getFontName()));
                builder.fontFamily(descriptor.getFontFamily());
                builder.fontStretch(getStringFromASAtom(descriptor.getFontStretch()));
                builder.fontWeight(descriptor.getFontWeight());
                builder.flags(descriptor.getFlags() == null ? null : descriptor.getFlags().intValue());
                double[] rex = descriptor.getFontBoundingBox();
                if (rex != null) {
                    List<Double> rect = new ArrayList<>(rex.length);
                    for (int i = 0; i < rex.length; ++i) {
                        rect.add(rex[i]);
                    }
                    builder.fontBBox(rect);
                }

                builder.italicAngle(descriptor.getItalicAngle());
                builder.ascent(descriptor.getAscent());
                builder.descent(descriptor.getDescent());
                builder.leading(descriptor.getLeading());
                builder.capHeight(descriptor.getCapHeight());
                builder.xHeight(descriptor.getXHeight());
                builder.stemV(descriptor.getStemV());
                builder.stemH(descriptor.getStemH());
                builder.avgWidth(descriptor.getAvgWidth());
                builder.maxWidth(descriptor.getMaxWidth());
                builder.missingWidth(descriptor.getMissingWidth());
                builder.charSet(descriptor.getCharSet());

                return builder.build();
            }
        }
        return null;
    }


    private static void parseFontDescriptior(PDFontDescriptor descriptor,
                                             FeatureTreeNode root,
                                             FeatureExtractionResult collection) throws FeatureParsingException {
        if (descriptor != null) {
            FeatureTreeNode descriptorNode = root.addChild("fontDescriptor");

            GFCreateNodeHelper.addNotEmptyNode("fontName", descriptor.getFontName(), descriptorNode);
            GFCreateNodeHelper.addNotEmptyNode("fontFamily", descriptor.getFontFamily(), descriptorNode);
            GFCreateNodeHelper.addNotEmptyNode("fontStretch", descriptor.getFontStretch(), descriptorNode);
            descriptorNode.addChild("fontWeight").setValue(String.valueOf(descriptor.getFontWeight()));
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

            descriptorNode.addChild("italicAngle").setValue(String.valueOf(descriptor.getItalicAngle()));
            descriptorNode.addChild("ascent").setValue(String.valueOf(descriptor.getAscent()));
            descriptorNode.addChild("descent").setValue(String.valueOf(descriptor.getDescent()));
            descriptorNode.addChild("leading").setValue(String.valueOf(descriptor.getLeading()));
            descriptorNode.addChild("capHeight").setValue(String.valueOf(descriptor.getCapHeight()));
            descriptorNode.addChild("xHeight").setValue(String.valueOf(descriptor.getXHeight()));
            descriptorNode.addChild("stemV").setValue(String.valueOf(descriptor.getStemV()));
            descriptorNode.addChild("stemH").setValue(String.valueOf(descriptor.getStemH()));
            descriptorNode.addChild("averageWidth").setValue(String.valueOf(descriptor.getAvgWidth()));
            descriptorNode.addChild("maxWidth").setValue(String.valueOf(descriptor.getMaxWidth()));
            descriptorNode.addChild("missingWidth").setValue(String.valueOf(descriptor.getMissingWidth()));
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

    private static void parseWidths(COSObject array, int firstChar,
                                    FeatureTreeNode parent) throws FeatureParsingException {
        if (array.getType() == COSObjType.COS_ARRAY) {
            int fc = firstChar == -1 ? 0 : firstChar;
            for (int i = 0; i < array.size(); ++i) {
                FeatureTreeNode element = parent.addChild("width");
                element.setValue(String.valueOf(array.at(i)));
                element.setAttribute("char", String.valueOf(i + fc));
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

    private String getStringFromASAtom(ASAtom asAtom) {
        return asAtom == null ? null : asAtom.getValue();
    }
}
