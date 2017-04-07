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
package org.verapdf.features.gf;

import org.verapdf.cos.COSDocument;
import org.verapdf.cos.COSObject;
import org.verapdf.external.ICCProfile;
import org.verapdf.features.gf.objects.*;
import org.verapdf.features.objects.LowLvlInfoFeaturesObject;
import org.verapdf.pd.*;
import org.verapdf.pd.colors.PDColorSpace;
import org.verapdf.pd.encryption.PDEncryption;
import org.verapdf.pd.font.PDFont;
import org.verapdf.pd.images.PDXForm;
import org.verapdf.pd.images.PDXImage;
import org.verapdf.pd.patterns.PDShading;
import org.verapdf.pd.patterns.PDShadingPattern;
import org.verapdf.pd.patterns.PDTilingPattern;

import java.util.Set;

/**
 * Creates Feature Objects and report them to Features Reporter
 *
 * @author Maksim Bezrukov
 */
public final class GFFeaturesObjectCreator {

	private GFFeaturesObjectCreator() {
	}

	/**
	 * Creates new GFInfoDictFeaturesObjectAdapter
	 *
	 * @param info COSObject class from greenfield, which represents a document info dictionary for feature report
	 * @return created GFInfoDictFeaturesObjectAdapter
	 */
	public static GFInfoDictFeaturesObjectAdapter createInfoDictFeaturesObject(COSObject info) {
		return new GFInfoDictFeaturesObjectAdapter(info);
	}

	/**
	 * Creates new GFMetadataFeaturesObjectAdapter
	 *
	 * @param metadata PDMetadata class from greenfield, which represents a metadata for feature report
	 * @return created GFMetadataFeaturesObjectAdapter
	 */
	public static GFMetadataFeaturesObjectAdapter createMetadataFeaturesObject(PDMetadata metadata) {
		return new GFMetadataFeaturesObjectAdapter(metadata);
	}

	/**
	 * Creates new GFDocSecurityFeaturesObjectAdapter
	 *
	 * @param encryption PDEncryption class from greenfield, which represents an encryption for feature report
	 * @return created GFDocSecurityFeaturesObjectAdapter
	 */
	public static GFDocSecurityFeaturesObjectAdapter createDocSecurityFeaturesObject(PDEncryption encryption) {
		return new GFDocSecurityFeaturesObjectAdapter(encryption);
	}

	/**
	 * Creates new LowLvlInfoFeaturesObject
	 *
	 * @param document COSDocument class from greenfield, which represents a document for feature report
	 * @return created LowLvlInfoFeaturesObject
	 */
	public static LowLvlInfoFeaturesObject createLowLvlInfoFeaturesObject(COSDocument document) {
		GFLowLvlInfoFeaturesObjectAdapter adapter = new GFLowLvlInfoFeaturesObjectAdapter(document);
		return new LowLvlInfoFeaturesObject(adapter);
	}

	/**
	 * Creates new GFEmbeddedFileFeaturesObjectAdapter
	 *
	 * @param embFile COSObject class from greenfield, which represents a file specification with embedded
	 *                file for feature report
	 * @return created GFEmbeddedFileFeaturesObjectAdapter
	 */
	public static GFEmbeddedFileFeaturesObjectAdapter createEmbeddedFileFeaturesObject(COSObject embFile,
																					   int index) {
		return new GFEmbeddedFileFeaturesObjectAdapter(embFile, index);
	}

	/**
	 * Creates new GFOutputIntentsFeaturesObjectAdapter
	 *
	 * @param outInt       PDOutputIntent class from greenfield, which represents an outputIntent for feature report
	 * @param iccProfileID id of the icc profile which use in this outputIntent
	 * @return created GFOutputIntentsFeaturesObjectAdapter
	 */
	public static GFOutputIntentsFeaturesObjectAdapter createOutputIntentFeaturesObject(PDOutputIntent outInt,
																						String iccProfileID) {
		return new GFOutputIntentsFeaturesObjectAdapter(outInt, iccProfileID);
	}

	/**
	 * Creates new GFOutlinesFeaturesObjectAdapter
	 *
	 * @param outlines PDPage class from greenfield, which represents a page for feature report
	 * @return created GFOutlinesFeaturesObjectAdapter
	 */
	public static GFOutlinesFeaturesObjectAdapter createOutlinesFeaturesObject(PDOutlineDictionary outlines) {
		return new GFOutlinesFeaturesObjectAdapter(outlines);
	}

	/**
	 * Creates new GFAnnotationFeaturesObjectAdapter
	 *
	 * @param annot        PDAnnotation class from greenfield, which represents an annotation for feature report
	 * @param id           page id
	 * @param popupId      id of the popup annotation for this annotation
	 * @param formXObjects set of id of the form XObjects which used in appearance stream of this annotation
	 * @return created GFAnnotationFeaturesObjectAdapter
	 */
	public static GFAnnotationFeaturesObjectAdapter createAnnotFeaturesObject(PDAnnotation annot,
																			  String id,
																			  String popupId,
																			  Set<String> formXObjects) {
		return new GFAnnotationFeaturesObjectAdapter(annot, id, popupId, formXObjects);
	}

	/**
	 * Creates new GFPageFeaturesObject
	 *
	 * @param page            greenfield class represents page object
	 * @param thumb           thumbnail image id
	 * @param annotsId        set of annotations id which contains in this page
	 * @param extGStateChild  set of extGState id which contains in resource dictionary of this page
	 * @param colorSpaceChild set of ColorSpace id which contains in resource dictionary of this page
	 * @param patternChild    set of pattern id which contains in resource dictionary of this page
	 * @param shadingChild    set of shading id which contains in resource dictionary of this page
	 * @param xobjectChild    set of XObject id which contains in resource dictionary of this page
	 * @param fontChild       set of font id which contains in resource dictionary of this page
	 * @param propertiesChild set of properties id which contains in resource dictionary of this page
	 * @param index           page index
	 * @return created GFPageFeaturesObject
	 */
	public static GFPageFeaturesObject createPageFeaturesObject(PDPage page,
																String thumb,
																Set<String> annotsId,
																Set<String> extGStateChild,
																Set<String> colorSpaceChild,
																Set<String> patternChild,
																Set<String> shadingChild,
																Set<String> xobjectChild,
																Set<String> fontChild,
																Set<String> propertiesChild,
																int index) {
		return new GFPageFeaturesObject(page, thumb, annotsId, extGStateChild,
				colorSpaceChild, patternChild, shadingChild, xobjectChild,
				fontChild, propertiesChild, index);
	}

	/**
	 * Creates new GFICCProfileFeaturesObjectAdapter
	 *
	 * @param profile   ICCProfile which represents the icc profile for feature report
	 * @param id        id of the profile
	 * @return created GFICCProfileFeaturesObjectAdapter
	 */
	public static GFICCProfileFeaturesObjectAdapter createICCProfileFeaturesObject(ICCProfile profile, String id) {
		return new GFICCProfileFeaturesObjectAdapter(profile, id);
	}

	/**
	 * Creates new GFExtGStateFeaturesObjectAdapter
	 *
	 * @param exGState         PDExtGState which represents extended graphics state for feature report
	 * @param id               id of the object
	 * @param fontChildID      id of the font child
	 * @return created GFExtGStateFeaturesObjectAdapter
	 */
	public static GFExtGStateFeaturesObjectAdapter createExtGStateFeaturesObject(PDExtGState exGState,
																				 String id,
																				 String fontChildID) {
		return new GFExtGStateFeaturesObjectAdapter(exGState, id, fontChildID);
	}

	/**
	 * Constructs new GFColorSpaceFeaturesObjectAdapter
	 *
	 * @param colorSpace        PDColorSpace which represents colorspace for feature report
	 * @param id                id of the object
	 * @param iccProfileChild   id of the iccprofile child
	 * @param colorSpaceChild   id of the colorspace child
	 * @return created GFColorSpaceFeaturesObjectAdapter
	 */
	public static GFColorSpaceFeaturesObjectAdapter createColorSpaceFeaturesObject(PDColorSpace colorSpace,
																				   String id,
																				   String iccProfileChild,
																				   String colorSpaceChild) {
		return new GFColorSpaceFeaturesObjectAdapter(colorSpace, id, iccProfileChild, colorSpaceChild);
	}

	/**
	 * Constructs new GFTilingPatternFeaturesObject
	 *
	 * @param tilingPattern   PDTilingPattern which represents tilling pattern for feature report
	 * @param id              id of the object
	 * @param extGStateChild  set of external graphics state id which contains in resource dictionary of this pattern
	 * @param colorSpaceChild set of ColorSpace id which contains in resource dictionary of this pattern
	 * @param patternChild    set of pattern id which contains in resource dictionary of this pattern
	 * @param shadingChild    set of shading id which contains in resource dictionary of this pattern
	 * @param xobjectChild    set of XObject id which contains in resource dictionary of this pattern
	 * @param fontChild       set of font id which contains in resource dictionary of this pattern
	 * @param propertiesChild set of properties id which contains in resource dictionary of this pattern
	 * @return created GFTilingPatternFeaturesObject
	 */
	public static GFTilingPatternFeaturesObject createTilingPatternFeaturesObject(PDTilingPattern tilingPattern,
																				  String id,
																				  Set<String> extGStateChild,
																				  Set<String> colorSpaceChild,
																				  Set<String> patternChild,
																				  Set<String> shadingChild,
																				  Set<String> xobjectChild,
																				  Set<String> fontChild,
																				  Set<String> propertiesChild) {
		return new GFTilingPatternFeaturesObject(tilingPattern, id, extGStateChild, colorSpaceChild, patternChild, shadingChild, xobjectChild, fontChild, propertiesChild);
	}

	/**
	 * Constructs new GFShadingPatternFeaturesObject
	 *
	 * @param shadingPattern PDShadingPattern which represents shading pattern for feature report
	 * @param id             id of the object
	 * @param extGStateChild external graphics state id which contains in this shading pattern
	 * @param shadingChild   shading id which contains in this shading pattern
	 * @return created GFShadingPatternFeaturesObject
	 */
	public static GFShadingPatternFeaturesObject createShadingPatternFeaturesObject(PDShadingPattern shadingPattern,
																					String id,
																					String shadingChild,
																					String extGStateChild) {
		return new GFShadingPatternFeaturesObject(shadingPattern, id, shadingChild, extGStateChild);
	}

	/**
	 * Constructs new GFShadingFeaturesObject
	 *
	 * @param shading         PDShading which represents shading for feature report
	 * @param id              id of the object
	 * @param colorSpaceChild colorSpace id which contains in this shading pattern
	 * @return created GFShadingFeaturesObject
	 */
	public static GFShadingFeaturesObject createShadingFeaturesObject(PDShading shading,
																	  String id,
																	  String colorSpaceChild) {
		return new GFShadingFeaturesObject(shading, id, colorSpaceChild);
	}

	/**
	 * Constructs new GFImageXObjectFeaturesObject
	 *
	 * @param imageXObject    PDXImage which represents image xobject for feature report
	 * @param id              id of the object
	 * @param colorSpaceChild colorSpace id which contains in this image xobject
	 * @param maskChild       image xobject id which contains in this image xobject as it's mask
	 * @param sMaskChild      image xobject id which contains in this image xobject as it's smask
	 * @param alternatesChild set of image xobject ids which contains in this image xobject as alternates
	 * @return created GFImageXObjectFeaturesObject
	 */
	public static GFImageXObjectFeaturesObject createImageXObjectFeaturesObject(PDXImage imageXObject,
																				String id,
																				String colorSpaceChild,
																				String maskChild,
																				String sMaskChild,
																				Set<String> alternatesChild) {
		return new GFImageXObjectFeaturesObject(imageXObject, id, colorSpaceChild, maskChild, sMaskChild, alternatesChild);
	}

	/**
	 * Constructs new GFFormXObjectFeaturesObjectAdapter
	 *
	 * @param formXObject      PDXForm which represents form xobject for feature report
	 * @param id               id of the object
	 * @param groupChild       id of the group xobject which contains in the given form xobject
	 * @param extGStateChild   set of external graphics state id which contains in resource dictionary of this xobject
	 * @param colorSpaceChild  set of ColorSpace id which contains in resource dictionary of this xobject
	 * @param patternChild     set of pattern id which contains in resource dictionary of this xobject
	 * @param shadingChild     set of shading id which contains in resource dictionary of this xobject
	 * @param xobjectChild     set of XObject id which contains in resource dictionary of this xobject
	 * @param fontChild        set of font id which contains in resource dictionary of this pattern
	 * @param propertiesChild  set of properties id which contains in resource dictionary of this xobject
	 * @return created GFFormXObjectFeaturesObjectAdapter
	 */
	public static GFFormXObjectFeaturesObjectAdapter createFormXObjectFeaturesObject(PDXForm formXObject,
																					 String id,
																					 String groupChild,
																					 Set<String> extGStateChild,
																					 Set<String> colorSpaceChild,
																					 Set<String> patternChild,
																					 Set<String> shadingChild,
																					 Set<String> xobjectChild,
																					 Set<String> fontChild,
																					 Set<String> propertiesChild) {
		return new GFFormXObjectFeaturesObjectAdapter(formXObject, id, groupChild, extGStateChild, colorSpaceChild, patternChild, shadingChild, xobjectChild, fontChild, propertiesChild);
	}

	/**
	 * Constructs new GFFontFeaturesObjectAdapter
	 *
	 * @param fontLike        PDFont which represents font for feature report
	 * @param id              id of the object
	 * @param extGStateChild  set of external graphics state id which contains in resource dictionary of this font
	 * @param colorSpaceChild set of ColorSpace id which contains in resource dictionary of this font
	 * @param patternChild    set of pattern id which contains in resource dictionary of this font
	 * @param shadingChild    set of shading id which contains in resource dictionary of this font
	 * @param xobjectChild    set of XObject id which contains in resource dictionary of this font
	 * @param fontChild       set of font id which contains in resource dictionary of this font
	 * @param propertiesChild set of properties id which contains in resource dictionary of this font
	 * @return created GFFontFeaturesObjectAdapter
	 */
	public static GFFontFeaturesObjectAdapter createFontFeaturesObject(PDFont fontLike,
																	   String id,
																	   Set<String> extGStateChild,
																	   Set<String> colorSpaceChild,
																	   Set<String> patternChild,
																	   Set<String> shadingChild,
																	   Set<String> xobjectChild,
																	   Set<String> fontChild,
																	   Set<String> propertiesChild) {
		return new GFFontFeaturesObjectAdapter(fontLike, id, extGStateChild, colorSpaceChild, patternChild, shadingChild, xobjectChild, fontChild, propertiesChild);
	}

	/**
	 * Constructs new GFPropertiesDictFeaturesObject
	 *
	 * @param properties    COSObject which represents properties for feature report
	 * @param id            id of the object
	 * @return created GFPropertiesDictFeaturesObject
	 */
	public static GFPropertiesDictFeaturesObject createPropertiesDictFeaturesObject(COSObject properties,
																					String id) {
		return new GFPropertiesDictFeaturesObject(properties, id);
	}

	/**
	 * Constructs new GFPostScriptXObjectFeaturesObject
	 *
	 * @param id            id of the object
	 * @return created GFPostScriptXObjectFeaturesObject
	 */
	public static GFPostScriptXObjectFeaturesObject createPostScriptXObjectFeaturesObject(String id) {
		return new GFPostScriptXObjectFeaturesObject(id);
	}

	/**
	 * Constructs new GFSignatureFeaturesObject
	 *
	 * @param signature greenfield signature object
	 * @return created GFSignatureFeaturesObject
	 */
	public static GFSignatureFeaturesObject createSignatureFeaturesObject(PDSignature signature) {
		return new GFSignatureFeaturesObject(signature);
	}
}
