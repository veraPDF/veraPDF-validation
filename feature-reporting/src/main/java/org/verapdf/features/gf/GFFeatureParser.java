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
package org.verapdf.features.gf;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.*;
import org.verapdf.external.ICCProfile;
import org.verapdf.factory.colors.ColorSpaceFactory;
import org.verapdf.features.*;
import org.verapdf.features.objects.ActionFeaturesObjectAdapter;
import org.verapdf.features.tools.ErrorsHelper;
import org.verapdf.features.tools.FeatureTreeNode;
import org.verapdf.pd.*;
import org.verapdf.pd.actions.*;
import org.verapdf.pd.colors.PDColorSpace;
import org.verapdf.pd.colors.PDICCBased;
import org.verapdf.pd.encryption.StandardSecurityHandler;
import org.verapdf.pd.font.PDCIDFont;
import org.verapdf.pd.font.PDFont;
import org.verapdf.pd.font.PDType0Font;
import org.verapdf.pd.font.type3.PDType3Font;
import org.verapdf.pd.form.PDAcroForm;
import org.verapdf.pd.form.PDFormField;
import org.verapdf.pd.form.PDSignatureField;
import org.verapdf.pd.images.PDXForm;
import org.verapdf.pd.images.PDXImage;
import org.verapdf.pd.images.PDXObject;
import org.verapdf.pd.patterns.PDPattern;
import org.verapdf.pd.patterns.PDShading;
import org.verapdf.pd.patterns.PDShadingPattern;
import org.verapdf.pd.patterns.PDTilingPattern;
import org.verapdf.tools.PageLabels;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Parses GreenField PDDocument to generate features collection
 *
 * @author Maksim Bezrukov
 */
public final class GFFeatureParser {
	private static final EnumSet<FeatureObjectType> XOBJECTS = EnumSet.of(FeatureObjectType.FORM_XOBJECT,
			FeatureObjectType.IMAGE_XOBJECT, FeatureObjectType.POSTSCRIPT_XOBJECT);
	private static final Logger LOGGER = Logger.getLogger(GFFeatureParser.class.getCanonicalName());
	private static final String ID = "id";
	private static final String DEVICEGRAY_ID = "devgray";
	private static final String DEVICERGB_ID = "devrgb";
	private static final String DEVICECMYK_ID = "devcmyk";

	private FeaturesReporter reporter;
	private FeatureExtractorConfig config;
	private Set<String> processedIDs;

	private GFFeatureParser(FeaturesReporter reporter, FeatureExtractorConfig config) {
		this.reporter = reporter;
		this.config = config;
		this.processedIDs = new HashSet<>();
	}

	/**
	 * Parses the document and returns Feature collection by using given
	 * Features Reporter
	 *
	 * @param document the document for parsing
	 * @return FeaturesCollection class with information about all featurereport
	 */
	public static FeatureExtractionResult getFeaturesCollection(final PDDocument document, final FeatureExtractorConfig config) {

		FeaturesReporter reporter = new FeaturesReporter(config);
		return getFeatures(document, reporter, config);
	}

	/**
	 * Parses the document and returns Feature collection by using given
	 * Features Reporter
	 *
	 * @param document the document for parsing
	 * @return FeaturesCollection class with information about all featurereport
	 */
	public static FeatureExtractionResult getFeaturesCollection(final PDDocument document,
																final List<AbstractFeaturesExtractor> extractors, final FeatureExtractorConfig config) {

		FeaturesReporter reporter = new FeaturesReporter(config, extractors);
		return getFeatures(document, reporter, config);
	}

	private static FeatureExtractionResult getFeatures(PDDocument document, FeaturesReporter reporter,
													   FeatureExtractorConfig config) {
		if (config == null) {
			throw new IllegalArgumentException("Features config can not be null");
		}
		if (document != null) {
			GFFeatureParser parser = new GFFeatureParser(reporter, config);
			parser.parseDocumentFeatures(document);
		}

		return reporter.getCollection();
	}

	private void parseDocumentFeatures(PDDocument document) {
		COSDocument cosDocument = document.getDocument();

		COSTrailer trailer = cosDocument.getTrailer();
		if (trailer != null) {
			reporter.report(GFFeaturesObjectCreator.createInfoDictFeaturesObject(trailer.getInfo()));
		}

		StandardSecurityHandler standardSecurityHandler = cosDocument.getStandardSecurityHandler();
		if (standardSecurityHandler != null) {
			reporter.report(GFFeaturesObjectCreator.createDocSecurityFeaturesObject(standardSecurityHandler.getPdEncryption()));
		}

		try {
			PDCatalog catalog = document.getCatalog();
			if (catalog != null) {
				getCatalogFeatures(catalog);
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Problem in parsing document catalog", e);
		}

		reporter.report(GFFeaturesObjectCreator.createLowLvlInfoFeaturesObject(cosDocument));

	}

	private void getCatalogFeatures(PDCatalog catalog) throws IOException {
		reporter.report(GFFeaturesObjectCreator.createMetadataFeaturesObject(catalog.getMetadata()));
		PDOutlineDictionary outlines = catalog.getOutlines();
		reporter.report(GFFeaturesObjectCreator.createOutlinesFeaturesObject(outlines));

		PDNamesDictionary namesDictionary = catalog.getNamesDictionary();

		if (config.isFeatureEnabled(FeatureObjectType.ACTION)) {
			if (outlines != null) {
				reportOutlinesActions(outlines.getFirst());
			}
			reportAction(catalog.getOpenAction(), ActionFeaturesObjectAdapter.Location.DOCUMENT);
			PDCatalogAdditionalActions additionalActions = catalog.getAdditionalActions();
			if (additionalActions != null) {
				reportAction(additionalActions.getDP(), ActionFeaturesObjectAdapter.Location.DOCUMENT);
				reportAction(additionalActions.getDS(), ActionFeaturesObjectAdapter.Location.DOCUMENT);
				reportAction(additionalActions.getWS(), ActionFeaturesObjectAdapter.Location.DOCUMENT);
				reportAction(additionalActions.getWC(), ActionFeaturesObjectAdapter.Location.DOCUMENT);
				reportAction(additionalActions.getWP(), ActionFeaturesObjectAdapter.Location.DOCUMENT);
			}
			if (namesDictionary != null) {
				PDNameTreeNode javaScript = namesDictionary.getJavaScript();
				if (javaScript != null) {
					reportJavaScripts(javaScript);
				}
			}
		}

		if (config.isFeatureEnabled(FeatureObjectType.EMBEDDED_FILE) && namesDictionary != null) {
			PDNameTreeNode node = namesDictionary.getEmbeddedFiles();
			if (node != null) {
				reportEmbeddedFileNode(node, 0);
			}
		}

		PDAcroForm acroForm = catalog.getAcroForm();
		if (acroForm != null) {
			getAcroFormFeatures(acroForm);
		}

		if (catalog.getOutputIntents() != null) {
			for (PDOutputIntent outInt : catalog.getOutputIntents()) {
				String iccProfileID = addICCProfileFromOutputIntent(outInt);
				if (!config.isFeatureEnabled(FeatureObjectType.ICCPROFILE)) {
					iccProfileID = null;
				}
				reporter.report(GFFeaturesObjectCreator.createOutputIntentFeaturesObject(outInt, iccProfileID));
			}
		}

		PDPageTree pageTree = catalog.getPageTree();
		if (pageTree != null) {
			getPageTreeFeatures(pageTree, catalog.getPageLabels());
		}
	}

	private void reportOutlinesActions(PDOutlineItem outline) {
		if (outline != null) {
			reportAction(outline.getAction(), ActionFeaturesObjectAdapter.Location.OUTLINES);
			reportOutlinesActions(outline.getFirst());
			reportOutlinesActions(outline.getNext());
		}
	}

	private void reportAction(PDAction action, ActionFeaturesObjectAdapter.Location location) {
		if (action != null) {
			reporter.report(GFFeaturesObjectCreator.createActionFeaturesObject(action, location));
			for (PDAction next : action.getNext()) {
				reportAction(next, location);
			}
		}
	}

	private void getAcroFormFeatures(PDAcroForm acroForm) {
		List<PDFormField> fields = acroForm.getFields();
		for (PDFormField field : fields) {
			getSignatureFeatures(field);
			getRootFormFieldFeatures(field);
		}
	}

	private void getRootFormFieldFeatures(PDFormField field) {
		if (field == null) {
			return;
		}
		if (config.isFeatureEnabled(FeatureObjectType.INTERACTIVE_FORM_FIELDS)) {
			reporter.report(GFFeaturesObjectCreator.createInteractiveFormFieldFeaturesObject(field));
		}
		if (config.isFeatureEnabled(FeatureObjectType.ACTION)) {
			getFormFieldActions(field);
		}
	}

	private void getFormFieldActions(PDFormField field) {
		PDFormFieldActions actions = field.getActions();
		if (actions != null) {
			reportAction(actions.getK(), ActionFeaturesObjectAdapter.Location.INTERACTIVE_FORM_FIELD);
			reportAction(actions.getC(), ActionFeaturesObjectAdapter.Location.INTERACTIVE_FORM_FIELD);
			reportAction(actions.getF(), ActionFeaturesObjectAdapter.Location.INTERACTIVE_FORM_FIELD);
			reportAction(actions.getV(), ActionFeaturesObjectAdapter.Location.INTERACTIVE_FORM_FIELD);
		}
		for (PDFormField child : field.getChildFormFields()) {
			if (child != null) {
				getFormFieldActions(child);
			}
		}
	}

	private void getSignatureFeatures(PDFormField field) {
		if (config.isFeatureEnabled(FeatureObjectType.SIGNATURE) && field.getFT() == ASAtom.SIG) {
			PDSignature signature = ((PDSignatureField) field).getSignature();
			if (signature != null) {
				reporter.report(GFFeaturesObjectCreator.createSignatureFeaturesObject(signature));
			}
		}
	}

	private void getPageTreeFeatures(PDPageTree pageTree, PageLabels pageLabels) {
		for (int i = 0; i < pageTree.getPageCount(); ++i) {
			PDPage page = pageTree.getPage(i);
			reportPageActions(page);
			Set<String> annotsId = addAnnotsDependencies(page);
			annotsId = config.isFeatureEnabled(FeatureObjectType.ANNOTATION) ? annotsId : null;

			String thumbID = null;
			PDResources resources = page.getResources();
			COSObject thumb = page.getKey(ASAtom.getASAtom("Thumb"));
			if (thumb != null) {
				thumbID = getId(thumb, FeatureObjectType.IMAGE_XOBJECT);
				if (checkIDBeforeProcess(thumbID)) {
					if (thumb.getType() == COSObjType.COS_STREAM) {
						PDXImage img = new PDXImage(thumb, resources);
						parseImageXObject(img, thumbID);
					} else {
						xobjectCreationProblem(thumbID, "Thumb is not a stream");
					}
				}
			}
			thumbID = config.isAnyFeatureEnabled(XOBJECTS) ? thumbID : null;

			Set<String> extGStateChild = config.isFeatureEnabled(FeatureObjectType.EXT_G_STATE)
					? parseExGStateFromResource(resources) : null;
			Set<String> colorSpaceChild = config.isFeatureEnabled(FeatureObjectType.COLORSPACE)
					? parseColorSpaceFromResources(resources) : null;
			Set<String> patternChild = config.isFeatureEnabled(FeatureObjectType.PATTERN)
					? parsePatternFromResource(resources) : null;
			Set<String> shadingChild = config.isFeatureEnabled(FeatureObjectType.SHADING)
					? parseShadingFromResource(resources) : null;
			Set<String> xobjectChild = config.isAnyFeatureEnabled(XOBJECTS) ? parseXObjectFromResources(resources)
					: null;
			Set<String> fontChild = config.isFeatureEnabled(FeatureObjectType.FONT) ? parseFontFromResources(resources)
					: null;
			Set<String> propertiesChild = config.isFeatureEnabled(FeatureObjectType.PROPERTIES)
					? parsePropertiesFromResources(resources) : null;

			int pageNumber = page.getPageNumber();
			String label = pageLabels == null ? null : pageLabels.getLabel(pageNumber);
			reporter.report(GFFeaturesObjectCreator.createPageFeaturesObject(page, label, thumbID, annotsId, extGStateChild,
					colorSpaceChild, patternChild, shadingChild, xobjectChild, fontChild, propertiesChild,
					pageNumber));
		}
	}

	private void reportPageActions(PDPage page) {
		if (config.isFeatureEnabled(FeatureObjectType.ACTION)) {
			PDPageAdditionalActions additionalActions = page.getAdditionalActions();
			if (additionalActions != null) {
				reportAction(additionalActions.getC(), ActionFeaturesObjectAdapter.Location.PAGE);
				reportAction(additionalActions.getO(), ActionFeaturesObjectAdapter.Location.PAGE);
			}
			Set<COSKey> visitedKeys = new HashSet<>();
			processNavigationNodeActions(page.getPresSteps(), visitedKeys);
		}
	}

	private void processNavigationNodeActions(PDNavigationNode navNode, Set<COSKey> visitedKeys) {
		if (navNode != null) {
			COSKey objectKey = navNode.getObject().getObjectKey();
			if (visitedKeys.contains(objectKey)) {
				return;
			}
			visitedKeys.add(objectKey);
			reportAction(navNode.getNA(), ActionFeaturesObjectAdapter.Location.PAGE);
			reportAction(navNode.getPA(), ActionFeaturesObjectAdapter.Location.PAGE);
			processNavigationNodeActions(navNode.getNext(), visitedKeys);
			processNavigationNodeActions(navNode.getPrev(), visitedKeys);
		}
	}

	private Set<String> addAnnotsDependencies(PDPage page) {
		Set<String> annotsId = new HashSet<>();

		for (PDAnnotation annot : page.getAnnotations()) {
			reportAnnotationActions(annot);

			String id = getId(annot.getObject(), FeatureObjectType.ANNOTATION);
			annotsId.add(id);
			if (checkIDBeforeProcess(id)) {
				PDAnnotation popup = annot.getPopup();
				String popupID = null;
				if (popup != null) {
					popupID = addPopup(popup);
				}

				Set<String> formsIDs = getAnnotationResourcesDependencies(annot);
				popupID = config.isFeatureEnabled(FeatureObjectType.ANNOTATION) ? popupID : null;
				formsIDs = config.isAnyFeatureEnabled(XOBJECTS) ? formsIDs : null;
				reporter.report(
						GFFeaturesObjectCreator.createAnnotFeaturesObject(annot, id, popupID, formsIDs));

			}
		}

		return annotsId;
	}

	private void reportAnnotationActions(PDAnnotation annot) {
		if (config.isFeatureEnabled(FeatureObjectType.ACTION) && annot != null) {
			reportAction(annot.getA(), ActionFeaturesObjectAdapter.Location.ANNOTATION);
			PDAnnotationAdditionalActions additionalActions = annot.getAdditionalActions();
			if (additionalActions != null) {
				reportAction(additionalActions.getBl(), ActionFeaturesObjectAdapter.Location.ANNOTATION);
				reportAction(additionalActions.getD(), ActionFeaturesObjectAdapter.Location.ANNOTATION);
				reportAction(additionalActions.getE(), ActionFeaturesObjectAdapter.Location.ANNOTATION);
				reportAction(additionalActions.getFo(), ActionFeaturesObjectAdapter.Location.ANNOTATION);
				reportAction(additionalActions.getPC(), ActionFeaturesObjectAdapter.Location.ANNOTATION);
				reportAction(additionalActions.getPI(), ActionFeaturesObjectAdapter.Location.ANNOTATION);
				reportAction(additionalActions.getPO(), ActionFeaturesObjectAdapter.Location.ANNOTATION);
				reportAction(additionalActions.getPV(), ActionFeaturesObjectAdapter.Location.ANNOTATION);
				reportAction(additionalActions.getU(), ActionFeaturesObjectAdapter.Location.ANNOTATION);
				reportAction(additionalActions.getX(), ActionFeaturesObjectAdapter.Location.ANNOTATION);
			}
		}
	}

	private String addPopup(PDAnnotation popup) {
		reportAnnotationActions(popup);
		String id = getId(popup.getObject(), FeatureObjectType.ANNOTATION);

		if (checkIDBeforeProcess(id)) {
			reporter.report(GFFeaturesObjectCreator.createAnnotFeaturesObject(popup, id, null, null));
		}
		return id;
	}

	private Set<String> getAnnotationResourcesDependencies(PDAnnotation annot) {
		Set<String> appearances = new HashSet<>();

		PDAppearanceEntry normalAppearance = annot.getNormalAppearance();
		if (normalAppearance != null) {
			appearances.addAll(getAppearanceEntryDependencies(normalAppearance));
		}

		PDAppearanceEntry rolloverAppearance = annot.getRolloverAppearance();
		if (rolloverAppearance != null) {
			appearances.addAll(getAppearanceEntryDependencies(rolloverAppearance));
		}

		PDAppearanceEntry downAppearance = annot.getDownAppearance();
		if (downAppearance != null) {
			appearances.addAll(getAppearanceEntryDependencies(downAppearance));
		}

		return appearances;
	}

	private Set<String> getAppearanceEntryDependencies(PDAppearanceEntry entry) {
		Set<String> res = new HashSet<>();
		if (entry.isSubDictionary()) {
			for (Map.Entry<ASAtom, PDAppearanceStream> mapEntry : entry.getSubDictionary().entrySet()) {
				res.add(getAppearanceStreamDependencies(mapEntry.getValue()));
			}
		} else {
			res.add(getAppearanceStreamDependencies(entry.getAppearanceStream()));
		}
		return res;
	}

	private String getAppearanceStreamDependencies(PDAppearanceStream stream) {
		String id = getId(stream.getObject(), FeatureObjectType.FORM_XOBJECT);
		if (checkIDBeforeProcess(id)) {
			parseFormXObject(stream, id);
		}
		return id;
	}

	private void reportJavaScripts(final PDNameTreeNode node) {
		Map<String, COSObject> names = node.getNames();
		for (COSObject value : names.values()) {
			if (value != null && value.getType().isDictionaryBased()) {
				reportAction(new PDAction(value), ActionFeaturesObjectAdapter.Location.DOCUMENT);
			}
		}
		for (PDNameTreeNode kid : node.getKids()) {
			reportJavaScripts(kid);
		}
	}

	private int reportEmbeddedFileNode(final PDNameTreeNode node, final int index) {
		int res = index;
		Map<String, COSObject> names = node.getNames();
		for (COSObject value : names.values()) {
			if (value != null && value.getType().isDictionaryBased()) {
				reporter.report(GFFeaturesObjectCreator.createEmbeddedFileFeaturesObject(value, ++res));
			}
		}
		for (PDNameTreeNode kid : node.getKids()) {
			res = reportEmbeddedFileNode(kid, res);
		}
		return res;
	}

	private String addICCProfileFromOutputIntent(PDOutputIntent outInt) {
		ICCProfile profile = outInt.getDestOutputProfile();
		if (profile != null) {
			String iccProfileID = getId(profile.getObject(), FeatureObjectType.ICCPROFILE);
			if (checkIDBeforeProcess(iccProfileID)) {
				reporter.report(GFFeaturesObjectCreator.createICCProfileFeaturesObject(profile, iccProfileID));
			}
			return iccProfileID;
		}
		return null;
	}

	private void xobjectCreationProblem(final String nodeID, String errorMessage) {
		creationProblem(nodeID, errorMessage, FeatureObjectType.FORM_XOBJECT, false);
	}

	private void creationProblem(final String nodeID, final String errorMessage, final FeatureObjectType type, final boolean isTypeError) {
		if (config.isFeatureEnabled(type)) {
			if (!isTypeError) {
				FeatureTreeNode node = createNodeWithType(type);
				if (nodeID != null) {
					node.setAttribute(ID, nodeID);
				}
				reporter.getCollection().addNewFeatureTree(type, node);
				ErrorsHelper.addErrorIntoCollection(reporter.getCollection(), node, errorMessage);
			} else {
				String id = ErrorsHelper.addErrorIntoCollection(reporter.getCollection(), null, errorMessage);
				reporter.getCollection().addNewError(type, id);
			}
		}
	}

	private FeatureTreeNode createNodeWithType(FeatureObjectType type) {
		if (type == FeatureObjectType.FORM_XOBJECT) {
			FeatureTreeNode res = FeatureTreeNode.createRootNode("xobject");
			res.setAttribute("type", "form");
			return res;
		}

		return FeatureTreeNode.createRootNode(type.getNodeName());
	}

	private Set<String> parseColorSpaceFromResources(PDResources resources) {
		if (resources == null || resources.getXObjectNames() == null) {
			return null;
		}

		Set<String> colorSpaceIDs = new HashSet<>();
		for (ASAtom name : resources.getColorSpaceNames()) {
			PDColorSpace colorSpace = resources.getColorSpace(name);
			if (colorSpace != null) {
				String id = getId(colorSpace.getObject(), FeatureObjectType.COLORSPACE);
				id = checkColorSpaceID(id, colorSpace);
				colorSpaceIDs.add(id);
				if (checkIDBeforeProcess(id)) {
					parseColorSpace(colorSpace, id);
				}
			}
		}
		return colorSpaceIDs;
	}

	private Set<String> parseXObjectFromResources(PDResources resources) {
		if (resources == null || resources.getXObjectNames() == null) {
			return null;
		}

		Set<String> xobjectsIDs = new HashSet<>();
		for (ASAtom name : resources.getXObjectNames()) {
			PDXObject xobj = resources.getXObject(name);
			if (xobj != null) {
				String id = getId(xobj.getObject(), FeatureObjectType.IMAGE_XOBJECT);
				xobjectsIDs.add(id);
				if (checkIDBeforeProcess(id)) {
					if (xobj.getType() == ASAtom.IMAGE) {
						parseImageXObject((PDXImage) xobj, id);
					} else if (xobj.getType() == ASAtom.FORM) {
						parseFormXObject((PDXForm) xobj, id);
					} else if (xobj.getType() == ASAtom.PS) {
						reporter.report(GFFeaturesObjectCreator.createPostScriptXObjectFeaturesObject(id));
					}
				}
			}
		}
		return xobjectsIDs;
	}

	private Set<String> parsePropertiesFromResources(PDResources resources) {
		if (resources == null || resources.getPropertiesNames() == null) {
			return null;
		}

		Set<String> propertiesIDs = new HashSet<>();
		for (ASAtom name : resources.getPropertiesNames()) {
			COSObject propBase = resources.getKey(ASAtom.PROPERTIES);
			if (propBase.getType() == COSObjType.COS_DICT) {
				COSObject base = propBase.getKey(name);
				String id = getId(base, FeatureObjectType.PROPERTIES);
				propertiesIDs.add(id);
				if (checkIDBeforeProcess(id)) {
					reporter.report(
							GFFeaturesObjectCreator.createPropertiesDictFeaturesObject(base, id));
				}
			}
		}
		return propertiesIDs;
	}

	private Set<String> parseFontFromResources(PDResources resources) {
		if (resources == null || resources.getFontNames() == null) {
			return null;
		}

		Set<String> fontIDs = new HashSet<>();
		for (ASAtom name : resources.getFontNames()) {
			PDFont font = resources.getFont(name);
			if (font != null) {
				String id = getId(font.getObject(), FeatureObjectType.FONT);
				fontIDs.add(id);
				if (checkIDBeforeProcess(id)) {
					parseFont(font, id);
				}
			}
		}
		return fontIDs;
	}

	private Set<String> parseExGStateFromResource(PDResources resources) {
		if (resources == null || resources.getExtGStateNames() == null) {
			return null;
		}

		Set<String> gStatesIDs = new HashSet<>();
		for (ASAtom name : resources.getExtGStateNames()) {
			PDExtGState exGState = resources.getExtGState(name);
			if (exGState != null) {
				String id = getId(exGState.getObject(), FeatureObjectType.EXT_G_STATE);
				gStatesIDs.add(id);
				if (checkIDBeforeProcess(id)) {
					parseExGState(exGState, id);
				}
			}
		}
		return gStatesIDs;
	}

	private Set<String> parsePatternFromResource(PDResources resources) {
		if (resources == null || resources.getPatternNames() == null) {
			return null;
		}

		Set<String> patternIDs = new HashSet<>();
		for (ASAtom name : resources.getPatternNames()) {
			PDPattern pattern = resources.getPattern(name);
			if (pattern != null) {
				String id = getId(pattern.getObject(), FeatureObjectType.PATTERN);
				patternIDs.add(id);
				if (checkIDBeforeProcess(id)) {
					parsePattern(pattern, id);
				}
			}
		}
		return patternIDs;
	}

	private Set<String> parseShadingFromResource(PDResources resources) {
		if (resources == null || resources.getShadingNames() == null) {
			return null;
		}

		Set<String> shadingIDs = new HashSet<>();
		for (ASAtom name : resources.getShadingNames()) {
			PDShading shading = resources.getShading(name);
			if (shading != null) {
				String id = getId(shading.getObject(), FeatureObjectType.SHADING);
				shadingIDs.add(id);
				if (checkIDBeforeProcess(id)) {
					parseShading(shading, id);
				}
			}
		}
		return shadingIDs;
	}

	private void parseImageXObject(PDXImage xobj, String id) {
		COSObject baseColorSpace = xobj.getKey(ASAtom.CS);
		if (baseColorSpace.empty()) {
			baseColorSpace = xobj.getKey(ASAtom.COLORSPACE);
		}
		String idColorSpace = getId(baseColorSpace, FeatureObjectType.COLORSPACE);
		PDColorSpace colorSpace = ColorSpaceFactory.getColorSpace(baseColorSpace);
		idColorSpace = checkColorSpaceID(idColorSpace, colorSpace);
		if (checkIDBeforeProcess(idColorSpace)) {
			parseColorSpace(colorSpace, idColorSpace);
		}

		String idMask = null;
		PDXImage xobjMask = xobj.getMask();
		if (xobjMask != null) {
			idMask = getId(xobjMask.getObject(), FeatureObjectType.IMAGE_XOBJECT);
			if (checkIDBeforeProcess(idMask)) {
				parseImageXObject(xobjMask, idMask);
			}
		}

		String idSMask = null;
		PDXImage xobjSMask = xobj.getSMask();
		if (xobjSMask != null) {
			idSMask = getId(xobjSMask.getObject(), FeatureObjectType.IMAGE_XOBJECT);
			if (checkIDBeforeProcess(idSMask)) {
				parseImageXObject(xobjSMask, idSMask);
			}
		}

		Set<String> alternatesIDs = new HashSet<>();
		for (PDXImage entry : xobj.getAlternates()) {
			String idImage = getId(entry.getObject(), FeatureObjectType.IMAGE_XOBJECT);
			alternatesIDs.add(idImage);
			if (checkIDBeforeProcess(idImage)) {
				parseImageXObject(entry, idImage);
			}
		}

		idColorSpace = config.isFeatureEnabled(FeatureObjectType.COLORSPACE) ? idColorSpace : null;
		if (!config.isAnyFeatureEnabled(XOBJECTS)) {
			idMask = null;
			idSMask = null;
			alternatesIDs = null;
		}

		reporter.report(GFFeaturesObjectCreator.createImageXObjectFeaturesObject(xobj, id, idColorSpace, idMask,
				idSMask, alternatesIDs));
	}

	private void parseFormXObject(PDXForm xobj, String id) {

		PDGroup group = xobj.getGroup();
		String idColorSpace = null;
		if (group != null && ASAtom.TRANSPARENCY.equals(group.getSubtype())) {
			PDColorSpace colorSpace = group.getColorSpace();
			if (colorSpace != null) {
				idColorSpace = getId(colorSpace.getObject(), FeatureObjectType.COLORSPACE);
				idColorSpace = checkColorSpaceID(idColorSpace, colorSpace);
				if (checkIDBeforeProcess(idColorSpace)) {
					parseColorSpace(colorSpace, idColorSpace);
				}
			}
		}

		PDResources resources = xobj.getResources();
		Set<String> extGStateChild = parseExGStateFromResource(resources);
		extGStateChild = config.isFeatureEnabled(FeatureObjectType.EXT_G_STATE) ? extGStateChild : null;
		Set<String> colorSpaceChild = parseColorSpaceFromResources(resources);
		if (!config.isFeatureEnabled(FeatureObjectType.COLORSPACE)) {
			idColorSpace = null;
			colorSpaceChild = null;
		}
		Set<String> patternChild = config.isFeatureEnabled(FeatureObjectType.PATTERN)
				? parsePatternFromResource(resources) : null;
		Set<String> shadingChild = config.isFeatureEnabled(FeatureObjectType.SHADING)
				? parseShadingFromResource(resources) : null;
		Set<String> xobjectChild = config.isAnyFeatureEnabled(XOBJECTS) ? parseXObjectFromResources(resources) : null;
		Set<String> fontChild = config.isFeatureEnabled(FeatureObjectType.FONT) ? parseFontFromResources(resources)
				: null;
		Set<String> propertiesChild = config.isFeatureEnabled(FeatureObjectType.PROPERTIES)
				? parsePropertiesFromResources(resources) : null;

		reporter.report(GFFeaturesObjectCreator.createFormXObjectFeaturesObject(xobj, id, idColorSpace, extGStateChild,
				colorSpaceChild, patternChild, shadingChild, xobjectChild, fontChild, propertiesChild));

	}

	private void parseExGState(PDExtGState exGState, String id) {
		String childFontID = null;
		PDFont font = exGState.getFont();
		if (font != null) {
			childFontID = getId(font.getObject(), FeatureObjectType.FONT);
			if (checkIDBeforeProcess(childFontID)) {
				parseFont(font, childFontID);
			}
		}

		childFontID = config.isFeatureEnabled(FeatureObjectType.FONT) ? childFontID : null;
		reporter.report(GFFeaturesObjectCreator.createExtGStateFeaturesObject(exGState, id, childFontID));
	}

	private void parsePattern(PDPattern pattern, String id) {
		if (pattern.getPatternType() == 1) {
			PDTilingPattern tilingPattern = (PDTilingPattern) pattern;
			PDResources resources = tilingPattern.getResources();
			Set<String> extGStateChild = config.isFeatureEnabled(FeatureObjectType.EXT_G_STATE)
					? parseExGStateFromResource(resources) : null;
			Set<String> colorSpaceChild = config.isFeatureEnabled(FeatureObjectType.COLORSPACE)
					? parseColorSpaceFromResources(resources) : null;
			Set<String> patternChild = config.isFeatureEnabled(FeatureObjectType.PATTERN)
					? parsePatternFromResource(resources) : null;
			Set<String> shadingChild = config.isFeatureEnabled(FeatureObjectType.SHADING)
					? parseShadingFromResource(resources) : null;
			Set<String> xobjectChild = config.isAnyFeatureEnabled(XOBJECTS) ? parseXObjectFromResources(resources)
					: null;
			Set<String> fontChild = config.isFeatureEnabled(FeatureObjectType.FONT) ? parseFontFromResources(resources)
					: null;
			Set<String> propertiesChild = config.isFeatureEnabled(FeatureObjectType.PROPERTIES)
					? parsePropertiesFromResources(resources) : null;

			reporter.report(GFFeaturesObjectCreator.createTilingPatternFeaturesObject(tilingPattern, id, extGStateChild,
					colorSpaceChild, patternChild, shadingChild, xobjectChild, fontChild, propertiesChild));
		} else if (pattern.getPatternType() == 2) {
			PDShadingPattern shadingPattern = (PDShadingPattern) pattern;
			String shadingID = null;
			PDShading shading = shadingPattern.getShading();
			if (shading != null) {
				shadingID = getId(shading.getObject(), FeatureObjectType.SHADING);
				if (checkIDBeforeProcess(shadingID)) {
					parseShading(shading, shadingID);
				}
			}

			String exGStateID = null;
			PDExtGState extGState = shadingPattern.getExtGState();
			if (extGState != null) {
				exGStateID = getId(extGState.getObject(), FeatureObjectType.EXT_G_STATE);
				if (checkIDBeforeProcess(exGStateID)) {
					parseExGState(extGState, exGStateID);
				}
			}

			shadingID = config.isFeatureEnabled(FeatureObjectType.SHADING) ? shadingID : null;
			exGStateID = config.isFeatureEnabled(FeatureObjectType.EXT_G_STATE) ? exGStateID : null;
			reporter.report(GFFeaturesObjectCreator.createShadingPatternFeaturesObject(shadingPattern, id, shadingID,
					exGStateID));
		}
	}

	private void parseShading(PDShading shading, String id) {
		COSObject base = shading.getKey(ASAtom.CS);
		if (base.empty()) {
			base = shading.getKey(ASAtom.COLORSPACE);
		}
		String colorspaceID = getId(base, FeatureObjectType.COLORSPACE);
		PDColorSpace colorSpace = ColorSpaceFactory.getColorSpace(base);
		colorspaceID = checkColorSpaceID(colorspaceID, colorSpace);
		if (checkIDBeforeProcess(colorspaceID)) {
			parseColorSpace(colorSpace, colorspaceID);
		}

		colorspaceID = config.isFeatureEnabled(FeatureObjectType.COLORSPACE) ? colorspaceID : null;
		reporter.report(GFFeaturesObjectCreator.createShadingFeaturesObject(shading, id, colorspaceID));
	}

	private void parseFont(PDFont font, String id) {
		if (font.getSubtype() == ASAtom.TYPE3) {
			PDResources resources = ((PDType3Font) font).getResources();
			Set<String> extGStateChild = config.isFeatureEnabled(FeatureObjectType.EXT_G_STATE)
					? parseExGStateFromResource(resources) : null;
			Set<String> colorSpaceChild = config.isFeatureEnabled(FeatureObjectType.COLORSPACE)
					? parseColorSpaceFromResources(resources) : null;
			Set<String> patternChild = config.isFeatureEnabled(FeatureObjectType.PATTERN)
					? parsePatternFromResource(resources) : null;
			Set<String> shadingChild = config.isFeatureEnabled(FeatureObjectType.SHADING)
					? parseShadingFromResource(resources) : null;
			Set<String> xobjectChild = config.isAnyFeatureEnabled(XOBJECTS) ? parseXObjectFromResources(resources)
					: null;
			Set<String> fontChild = config.isFeatureEnabled(FeatureObjectType.FONT) ? parseFontFromResources(resources)
					: null;
			Set<String> propertiesChild = config.isFeatureEnabled(FeatureObjectType.PROPERTIES)
					? parsePropertiesFromResources(resources) : null;

			reporter.report(GFFeaturesObjectCreator.createFontFeaturesObject(font, id, extGStateChild, colorSpaceChild,
					patternChild, shadingChild, xobjectChild, fontChild, propertiesChild));
		} else if (font.getSubtype() == ASAtom.TYPE0) {
			PDType0Font type0 = (PDType0Font) font;

			COSObject descendantFontsBase = type0.getDescendantFontObject();
			if (descendantFontsBase != null) {
				String descendantID = getId(descendantFontsBase, FeatureObjectType.FONT);
				if (checkIDBeforeProcess(descendantID)) {
					parseFont(new PDCIDFont((COSDictionary) descendantFontsBase.getDirectBase(),
							type0.getCMap().getCMapFile()), descendantID);
				}
				Set<String> descendant = null;
				if (config.isFeatureEnabled(FeatureObjectType.FONT)) {
					descendant = new HashSet<>();
					descendant.add(descendantID);
				}
				reporter.report(GFFeaturesObjectCreator.createFontFeaturesObject(font, id, null, null, null, null, null,
						descendant, null));
			}
		} else {
			reporter.report(GFFeaturesObjectCreator.createFontFeaturesObject(font, id, null, null, null, null, null,
					null, null));
		}
	}

	private void parseColorSpace(PDColorSpace colorSpace, String id) {
		String iccProfileID = null;
		String idAlt = null;
		ASAtom colorSpaceType = colorSpace.getType();
		if (colorSpaceType == ASAtom.ICCBASED) {
			PDICCBased iccBased = (PDICCBased) colorSpace;

			ICCProfile iccProfile = iccBased.getICCProfile();
			if (iccProfile != null) {
				iccProfileID = getId(iccProfile.getObject(), FeatureObjectType.ICCPROFILE);

				if (checkIDBeforeProcess(iccProfileID)) {
					reporter.report(GFFeaturesObjectCreator
							.createICCProfileFeaturesObject(iccProfile, iccProfileID));
				}
			}

			PDColorSpace alternate = iccBased.getAlternate();
			if (alternate != null) {
				idAlt = getId(alternate.getObject(), FeatureObjectType.COLORSPACE);
				idAlt = checkColorSpaceID(idAlt, alternate);
				if (checkIDBeforeProcess(idAlt)) {
					parseColorSpace(alternate, idAlt);
				}
			}
		} else if (colorSpaceType == ASAtom.INDEXED
				|| colorSpaceType == ASAtom.SEPARATION
				|| colorSpaceType == ASAtom.DEVICEN) {

			int number = (colorSpaceType == ASAtom.INDEXED) ? 1 : 2;

			COSArray array = (COSArray) colorSpace.getObject().getDirectBase();
			COSObject base = array.at(number);
			idAlt = getId(base, FeatureObjectType.COLORSPACE);
			PDColorSpace alternate = ColorSpaceFactory.getColorSpace(base);
			if (alternate != null) {
				idAlt = checkColorSpaceID(idAlt, alternate);
				if (checkIDBeforeProcess(idAlt)) {
					parseColorSpace(alternate, idAlt);
				}
			}
		}
		iccProfileID = config.isFeatureEnabled(FeatureObjectType.ICCPROFILE) ? iccProfileID : null;
		idAlt = config.isFeatureEnabled(FeatureObjectType.COLORSPACE) ? idAlt : null;
		reporter.report(GFFeaturesObjectCreator.createColorSpaceFeaturesObject(colorSpace, id, iccProfileID, idAlt));
	}

	private static String checkColorSpaceID(String prevID, PDColorSpace colorSpace) {
		if (colorSpace != null) {
			String id = prevID;
			ASAtom colorSpaceType = colorSpace.getType();
			if (colorSpaceType == ASAtom.DEVICEGRAY) {
				id = DEVICEGRAY_ID;
			} else if (colorSpaceType == ASAtom.DEVICERGB) {
				id = DEVICERGB_ID;
			} else if (colorSpaceType == ASAtom.DEVICECMYK) {
				id = DEVICECMYK_ID;
			}
			return id;
		} else {
			return null;
		}
	}

	private String getId(final COSObject base, final FeatureObjectType objType) {
		if (base == null || base.empty()) {
			return null;
		}
		COSKey key = getObjectKey(base);
		long numb = this.processedIDs.size();
		String type = "Dir";
		if (key != null) {
			numb = key.getNumber();
			type = "Indir";
		}
		return objType.getIdPrefix() + type + numb;
	}

	private COSKey getObjectKey(final COSObject base) {
		COSKey res = null;
		if (base.isIndirect()) {
			COSObject item = base;
			while (item.isIndirect()) {
				res = item.getObjectKey();
				item = base.getDirect();
			}
		} else {
			res = base.getObjectKey();
		}
		return res;
	}

	private boolean checkIDBeforeProcess(String id) {
		if (id == null || this.processedIDs.contains(id)) {
			return false;
		}
		this.processedIDs.add(id);
		return true;
	}
}
