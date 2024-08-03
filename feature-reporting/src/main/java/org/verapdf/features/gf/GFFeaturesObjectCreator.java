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
package org.verapdf.features.gf;

import org.verapdf.cos.COSDocument;
import org.verapdf.cos.COSObject;
import org.verapdf.external.ICCProfile;
import org.verapdf.features.gf.objects.*;
import org.verapdf.features.objects.*;
import org.verapdf.pd.*;
import org.verapdf.pd.actions.PDAction;
import org.verapdf.pd.colors.PDColorSpace;
import org.verapdf.pd.encryption.PDEncryption;
import org.verapdf.pd.font.PDFont;
import org.verapdf.pd.form.PDFormField;
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
	public static InfoDictFeaturesObject createInfoDictFeaturesObject(COSObject info) {
		GFInfoDictFeaturesObjectAdapter adapter = new GFInfoDictFeaturesObjectAdapter(info);
		return new InfoDictFeaturesObject(adapter);
	}

	/**
	 * Creates new GFMetadataFeaturesObjectAdapter
	 *
	 * @param metadata PDMetadata class from greenfield, which represents a metadata for feature report
	 * @return created GFMetadataFeaturesObjectAdapter
	 */
	public static MetadataFeaturesObject createMetadataFeaturesObject(PDMetadata metadata) {
		GFMetadataFeaturesObjectAdapter adapter = new GFMetadataFeaturesObjectAdapter(metadata);
		return new MetadataFeaturesObject(adapter);
	}

	/**
	 * Creates new GFDocSecurityFeaturesObjectAdapter
	 *
	 * @param encryption PDEncryption class from greenfield, which represents an encryption for feature report
	 * @return created GFDocSecurityFeaturesObjectAdapter
	 */
	public static DocSecurityFeaturesObject createDocSecurityFeaturesObject(PDEncryption encryption) {
		GFDocSecurityFeaturesObjectAdapter adapter = new GFDocSecurityFeaturesObjectAdapter(encryption);
		return new DocSecurityFeaturesObject(adapter);
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
	public static EmbeddedFileFeaturesObject createEmbeddedFileFeaturesObject(COSObject embFile,
																			  int index) {
		GFEmbeddedFileFeaturesObjectAdapter adapter = new GFEmbeddedFileFeaturesObjectAdapter(embFile, index);
		return new EmbeddedFileFeaturesObject(adapter);
	}

	/**
	 * Creates new GFOutputIntentsFeaturesObjectAdapter
	 *
	 * @param outInt       PDOutputIntent class from greenfield, which represents an outputIntent for feature report
	 * @param iccProfileID id of the icc profile which use in this outputIntent
	 * @return created GFOutputIntentsFeaturesObjectAdapter
	 */
	public static OutputIntentFeaturesObject createOutputIntentFeaturesObject(PDOutputIntent outInt,
																			  String iccProfileID) {
		GFOutputIntentsFeaturesObjectAdapter adapter = new GFOutputIntentsFeaturesObjectAdapter(outInt, iccProfileID);
		return new OutputIntentFeaturesObject(adapter);
	}

	/**
	 * Creates new GFOutlinesFeaturesObjectAdapter
	 *
	 * @param outlines PDPage class from greenfield, which represents a page for feature report
	 * @return created GFOutlinesFeaturesObjectAdapter
	 */
	public static OutlinesFeaturesObject createOutlinesFeaturesObject(PDOutlineDictionary outlines) {
		GFOutlinesFeaturesObjectAdapter adapter = new GFOutlinesFeaturesObjectAdapter(outlines);
		return new OutlinesFeaturesObject(adapter);
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
	public static AnnotationFeaturesObject createAnnotFeaturesObject(PDAnnotation annot,
																	 String id,
																	 String popupId,
																	 Set<String> formXObjects) {
		GFAnnotationFeaturesObjectAdapter adapter = new GFAnnotationFeaturesObjectAdapter(annot, id, popupId, formXObjects);
		return new AnnotationFeaturesObject(adapter);
	}

	/**
	 * Creates new GFPageFeaturesObjectAdapter
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
	 * @return created GFPageFeaturesObjectAdapter
	 */
	public static PageFeaturesObject createPageFeaturesObject(PDPage page,
															  String label,
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
		GFPageFeaturesObjectAdapter adapter = new GFPageFeaturesObjectAdapter(page, label, thumb, annotsId, extGStateChild,
				colorSpaceChild, patternChild, shadingChild, xobjectChild,
				fontChild, propertiesChild, index);
		return new PageFeaturesObject(adapter);
	}

	/**
	 * Creates new GFICCProfileFeaturesObjectAdapter
	 *
	 * @param profile   ICCProfile which represents the icc profile for feature report
	 * @param id        id of the profile
	 * @return created GFICCProfileFeaturesObjectAdapter
	 */
	public static ICCProfileFeaturesObject createICCProfileFeaturesObject(ICCProfile profile, String id) {
		GFICCProfileFeaturesObjectAdapter adapter = new GFICCProfileFeaturesObjectAdapter(profile, id);
		return new ICCProfileFeaturesObject(adapter);
	}

	/**
	 * Creates new GFExtGStateFeaturesObjectAdapter
	 *
	 * @param exGState         PDExtGState which represents extended graphics state for feature report
	 * @param id               id of the object
	 * @param fontChildID      id of the font child
	 * @return created GFExtGStateFeaturesObjectAdapter
	 */
	public static ExtGStateFeaturesObject createExtGStateFeaturesObject(PDExtGState exGState,
																		String id,
																		String fontChildID) {
		GFExtGStateFeaturesObjectAdapter adapter = new GFExtGStateFeaturesObjectAdapter(exGState, id, fontChildID);
		return new ExtGStateFeaturesObject(adapter);
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
	public static ColorSpaceFeaturesObject createColorSpaceFeaturesObject(PDColorSpace colorSpace,
																		  String id,
																		  String iccProfileChild,
																		  String colorSpaceChild) {
		GFColorSpaceFeaturesObjectAdapter adapter = new GFColorSpaceFeaturesObjectAdapter(colorSpace, id, iccProfileChild, colorSpaceChild);
		return new ColorSpaceFeaturesObject(adapter);
	}

	/**
	 * Constructs new GFTilingPatternFeaturesObjectAdapter
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
	 * @return created GFTilingPatternFeaturesObjectAdapter
	 */
	public static TilingPatternFeaturesObject createTilingPatternFeaturesObject(PDTilingPattern tilingPattern,
																				String id,
																				Set<String> extGStateChild,
																				Set<String> colorSpaceChild,
																				Set<String> patternChild,
																				Set<String> shadingChild,
																				Set<String> xobjectChild,
																				Set<String> fontChild,
																				Set<String> propertiesChild) {
		GFTilingPatternFeaturesObjectAdapter adapter = new GFTilingPatternFeaturesObjectAdapter(tilingPattern, id,
				extGStateChild, colorSpaceChild, patternChild,
				shadingChild, xobjectChild, fontChild, propertiesChild);
		return new TilingPatternFeaturesObject(adapter);
	}

	/**
	 * Constructs new GFShadingPatternFeaturesObjectAdapter
	 *
	 * @param shadingPattern PDShadingPattern which represents shading pattern for feature report
	 * @param id             id of the object
	 * @param extGStateChild external graphics state id which contains in this shading pattern
	 * @param shadingChild   shading id which contains in this shading pattern
	 * @return created GFShadingPatternFeaturesObjectAdapter
	 */
	public static ShadingPatternFeaturesObject createShadingPatternFeaturesObject(PDShadingPattern shadingPattern,
																				  String id,
																				  String shadingChild,
																				  String extGStateChild) {
		GFShadingPatternFeaturesObjectAdapter adapter = new GFShadingPatternFeaturesObjectAdapter(shadingPattern, id, shadingChild, extGStateChild);
		return new ShadingPatternFeaturesObject(adapter);
	}

	/**
	 * Constructs new GFShadingFeaturesObjectAdapter
	 *
	 * @param shading         PDShading which represents shading for feature report
	 * @param id              id of the object
	 * @param colorSpaceChild colorSpace id which contains in this shading pattern
	 * @return created GFShadingFeaturesObjectAdapter
	 */
	public static ShadingFeaturesObject createShadingFeaturesObject(PDShading shading,
																	String id,
																	String colorSpaceChild) {
		GFShadingFeaturesObjectAdapter adapter = new GFShadingFeaturesObjectAdapter(shading, id, colorSpaceChild);
		return new ShadingFeaturesObject(adapter);
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
	public static ImageXObjectFeaturesObject createImageXObjectFeaturesObject(PDXImage imageXObject,
																			  String id,
																			  String colorSpaceChild,
																			  String maskChild,
																			  String sMaskChild,
																			  Set<String> alternatesChild) {
		GFImageXObjectFeaturesObjectAdapter adapter = new GFImageXObjectFeaturesObjectAdapter(imageXObject, id, colorSpaceChild, maskChild, sMaskChild, alternatesChild);
		return new ImageXObjectFeaturesObject(adapter);
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
	public static FormXObjectFeaturesObject createFormXObjectFeaturesObject(PDXForm formXObject,
																			String id,
																			String groupChild,
																			Set<String> extGStateChild,
																			Set<String> colorSpaceChild,
																			Set<String> patternChild,
																			Set<String> shadingChild,
																			Set<String> xobjectChild,
																			Set<String> fontChild,
																			Set<String> propertiesChild) {
		GFFormXObjectFeaturesObjectAdapter adapter = new GFFormXObjectFeaturesObjectAdapter(formXObject, id,
				groupChild, extGStateChild, colorSpaceChild,
				patternChild, shadingChild, xobjectChild,
				fontChild, propertiesChild);
		return new FormXObjectFeaturesObject(adapter);
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
	public static FontFeaturesObject createFontFeaturesObject(PDFont fontLike,
															  String id,
															  Set<String> extGStateChild,
															  Set<String> colorSpaceChild,
															  Set<String> patternChild,
															  Set<String> shadingChild,
															  Set<String> xobjectChild,
															  Set<String> fontChild,
															  Set<String> propertiesChild) {
		GFFontFeaturesObjectAdapter adapter = new GFFontFeaturesObjectAdapter(fontLike, id,
				extGStateChild, colorSpaceChild, patternChild,
				shadingChild, xobjectChild, fontChild, propertiesChild);
		return new FontFeaturesObject(adapter);
	}

	/**
	 * Constructs new GFPropertiesDictFeaturesObjectAdapter
	 *
	 * @param properties    COSObject which represents properties for feature report
	 * @param id            id of the object
	 * @return created GFPropertiesDictFeaturesObjectAdapter
	 */
	public static PropertiesDictFeaturesObject createPropertiesDictFeaturesObject(COSObject properties,
																				  String id) {
		GFPropertiesDictFeaturesObjectAdapter adapter = new GFPropertiesDictFeaturesObjectAdapter(properties, id);
		return new PropertiesDictFeaturesObject(adapter);
	}

	/**
	 * Constructs new GFPostScriptXObjectFeaturesObjectAdapter
	 *
	 * @param id            id of the object
	 * @return created GFPostScriptXObjectFeaturesObjectAdapter
	 */
	public static PostScriptFeaturesObject createPostScriptXObjectFeaturesObject(String id) {
		GFPostScriptXObjectFeaturesObjectAdapter adapter = new GFPostScriptXObjectFeaturesObjectAdapter(id);
		return new PostScriptFeaturesObject(adapter);
	}

	/**
	 * Constructs new GFSignatureFeaturesObjectAdapter
	 *
	 * @param signature greenfield signature object
	 * @return created GFSignatureFeaturesObjectAdapter
	 */
	public static SignatureFeaturesObject createSignatureFeaturesObject(PDSignature signature) {
		GFSignatureFeaturesObjectAdapter adapter = new GFSignatureFeaturesObjectAdapter(signature);
		return new SignatureFeaturesObject(adapter);
	}

	public static ActionFeaturesObject createActionFeaturesObject(PDAction action,
																  ActionFeaturesObjectAdapter.Location location) {
		GFActionFeaturesObjectAdapter adapter = new GFActionFeaturesObjectAdapter(action, location);
		return new ActionFeaturesObject(adapter);
	}

	public static InteractiveFormFieldFeaturesObject createInteractiveFormFieldFeaturesObject(PDFormField formField) {
		GFInteractiveFormFieldFeaturesObjectAdapter adapter = new GFInteractiveFormFieldFeaturesObjectAdapter(formField);
		return new InteractiveFormFieldFeaturesObject(adapter);
	}
}
