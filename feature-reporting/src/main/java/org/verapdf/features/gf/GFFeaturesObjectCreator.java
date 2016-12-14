package org.verapdf.features.gf;

import org.verapdf.cos.COSDocument;
import org.verapdf.cos.COSObject;
import org.verapdf.external.ICCProfile;
import org.verapdf.features.gf.objects.*;
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
	 * Creates new GFInfoDictFeaturesObject
	 *
	 * @param info COSObject class from greenfield, which represents a document info dictionary for feature report
	 * @return created GFInfoDictFeaturesObject
	 */
	public static GFInfoDictFeaturesObject createInfoDictFeaturesObject(COSObject info) {
		return new GFInfoDictFeaturesObject(info);
	}

	/**
	 * Creates new GFMetadataFeaturesObject
	 *
	 * @param metadata PDMetadata class from greenfield, which represents a metadata for feature report
	 * @return created GFMetadataFeaturesObject
	 */
	public static GFMetadataFeaturesObject createMetadataFeaturesObject(PDMetadata metadata) {
		return new GFMetadataFeaturesObject(metadata);
	}

	/**
	 * Creates new GFDocSecurityFeaturesObject
	 *
	 * @param encryption PDEncryption class from greenfield, which represents an encryption for feature report
	 * @return created GFDocSecurityFeaturesObject
	 */
	public static GFDocSecurityFeaturesObject createDocSecurityFeaturesObject(PDEncryption encryption) {
		return new GFDocSecurityFeaturesObject(encryption);
	}

	/**
	 * Creates new GFLowLvlInfoFeaturesObject
	 *
	 * @param document COSDocument class from greenfield, which represents a document for feature report
	 * @return created GFLowLvlInfoFeaturesObject
	 */
	public static GFLowLvlInfoFeaturesObject createLowLvlInfoFeaturesObject(COSDocument document) {
		return new GFLowLvlInfoFeaturesObject(document);
	}

	/**
	 * Creates new GFEmbeddedFileFeaturesObject
	 *
	 * @param embFile COSObject class from greenfield, which represents a file specification with embedded
	 *                file for feature report
	 * @return created GFEmbeddedFileFeaturesObject
	 */
	public static GFEmbeddedFileFeaturesObject createEmbeddedFileFeaturesObject(COSObject embFile,
																				int index) {
		return new GFEmbeddedFileFeaturesObject(embFile, index);
	}

	/**
	 * Creates new GFOutputIntentsFeaturesObject
	 *
	 * @param outInt       PDOutputIntent class from greenfield, which represents an outputIntent for feature report
	 * @param iccProfileID id of the icc profile which use in this outputIntent
	 * @return created GFOutputIntentsFeaturesObject
	 */
	public static GFOutputIntentsFeaturesObject createOutputIntentFeaturesObject(PDOutputIntent outInt,
																				 String iccProfileID) {
		return new GFOutputIntentsFeaturesObject(outInt, iccProfileID);
	}

	/**
	 * Creates new GFOutlinesFeaturesObject
	 *
	 * @param outlines PDPage class from greenfield, which represents a page for feature report
	 * @return created GFOutlinesFeaturesObject
	 */
	public static GFOutlinesFeaturesObject createOutlinesFeaturesObject(PDOutlineDictionary outlines) {
		return new GFOutlinesFeaturesObject(outlines);
	}

	/**
	 * Creates new GFAnnotationFeaturesObject
	 *
	 * @param annot        PDAnnotation class from greenfield, which represents an annotation for feature report
	 * @param id           page id
	 * @param popupId      id of the popup annotation for this annotation
	 * @param formXObjects set of id of the form XObjects which used in appearance stream of this annotation
	 * @return created GFAnnotationFeaturesObject
	 */
	public static GFAnnotationFeaturesObject createAnnotFeaturesObject(PDAnnotation annot,
																	   String id,
																	   String popupId,
																	   Set<String> formXObjects) {
		return new GFAnnotationFeaturesObject(annot, id, popupId, formXObjects);
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
	 * Creates new GFICCProfileFeaturesObject
	 *
	 * @param profile   ICCProfile which represents the icc profile for feature report
	 * @param id        id of the profile
	 * @return created GFICCProfileFeaturesObject
	 */
	public static GFICCProfileFeaturesObject createICCProfileFeaturesObject(ICCProfile profile, String id) {
		return new GFICCProfileFeaturesObject(profile, id);
	}

	/**
	 * Creates new GFExtGStateFeaturesObject
	 *
	 * @param exGState         PDExtGState which represents extended graphics state for feature report
	 * @param id               id of the object
	 * @param fontChildID      id of the font child
	 * @return created GFExtGStateFeaturesObject
	 */
	public static GFExtGStateFeaturesObject createExtGStateFeaturesObject(PDExtGState exGState,
																		  String id,
																		  String fontChildID) {
		return new GFExtGStateFeaturesObject(exGState, id, fontChildID);
	}

	/**
	 * Constructs new GFColorSpaceFeaturesObject
	 *
	 * @param colorSpace        PDColorSpace which represents colorspace for feature report
	 * @param id                id of the object
	 * @param iccProfileChild   id of the iccprofile child
	 * @param colorSpaceChild   id of the colorspace child
	 * @return created GFColorSpaceFeaturesObject
	 */
	public static GFColorSpaceFeaturesObject createColorSpaceFeaturesObject(PDColorSpace colorSpace,
																			String id,
																			String iccProfileChild,
																			String colorSpaceChild) {
		return new GFColorSpaceFeaturesObject(colorSpace, id, iccProfileChild, colorSpaceChild);
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
	 * Constructs new GFFormXObjectFeaturesObject
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
	 * @return created GFFormXObjectFeaturesObject
	 */
	public static GFFormXObjectFeaturesObject createFormXObjectFeaturesObject(PDXForm formXObject,
																			  String id,
																			  String groupChild,
																			  Set<String> extGStateChild,
																			  Set<String> colorSpaceChild,
																			  Set<String> patternChild,
																			  Set<String> shadingChild,
																			  Set<String> xobjectChild,
																			  Set<String> fontChild,
																			  Set<String> propertiesChild) {
		return new GFFormXObjectFeaturesObject(formXObject, id, groupChild, extGStateChild, colorSpaceChild, patternChild, shadingChild, xobjectChild, fontChild, propertiesChild);
	}

	/**
	 * Constructs new GFFontFeaturesObject
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
	 * @return created GFFontFeaturesObject
	 */
	public static GFFontFeaturesObject createFontFeaturesObject(PDFont fontLike,
																String id,
																Set<String> extGStateChild,
																Set<String> colorSpaceChild,
																Set<String> patternChild,
																Set<String> shadingChild,
																Set<String> xobjectChild,
																Set<String> fontChild,
																Set<String> propertiesChild) {
		return new GFFontFeaturesObject(fontLike, id, extGStateChild, colorSpaceChild, patternChild, shadingChild, xobjectChild, fontChild, propertiesChild);
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
