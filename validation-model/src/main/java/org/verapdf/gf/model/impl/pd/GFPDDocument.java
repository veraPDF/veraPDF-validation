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

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSString;
import org.verapdf.gf.model.impl.cos.GFCosLang;
import org.verapdf.gf.model.impl.pd.actions.GFPDAction;
import org.verapdf.gf.model.impl.pd.actions.GFPDAdditionalActions;
import org.verapdf.gf.model.impl.pd.signature.GFPDPerms;
import org.verapdf.gf.model.tools.OutlinesHelper;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosLang;
import org.verapdf.model.pdlayer.*;
import org.verapdf.pd.PDCatalog;
import org.verapdf.pd.actions.PDCatalogAdditionalActions;
import org.verapdf.pd.optionalcontent.PDOptionalContentProperties;
import org.verapdf.tools.StaticResources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.verapdf.gf.model.impl.pd.GFPDPage.SQUARE_ORIENTATION;

/**
 * @author Timur Kamalov
 */
public class GFPDDocument extends GFPDObject implements PDDocument {

    public static final String PD_DOCUMENT_TYPE = "PDDocument";

    /**
     * Link name for pages
     */
    public static final String PAGES = "pages";
    /**
     * Link name for main metadata of document
     */
    public static final String METADATA = "metadata";
    /**
     * Link name for all output intents
     */
    public static final String OUTPUT_INTENTS = "outputIntents";
    /**
     * Link name for acro forms
     */
    public static final String ACRO_FORMS = "AcroForm";
    /**
     * Link name for additional actions of document
     */
    public static final String ACTIONS = "AA";
    /**
     * Link name for open action of document
     */
    public static final String OPEN_ACTION = "OpenAction";
    public static final String OPEN_ACTION_DESTINATION = "OpenActionDestination";
    /**
     * Link name for all outlines of document
     */
    public static final String OUTLINES = "Outlines";
    /**
     * Link name for annotations structure tree root of document
     */
    public static final String STRUCTURE_TREE_ROOT = "StructTreeRoot";
    /**
     * Link name for optional content properties of the document
     */
    public static final String OC_PROPERTIES = "OCProperties";
    /**
     * Name of link to Lang value from the document catalog dictionary
     */
    public static final String LANG = "Lang";
    /**
     * Name of link to Perms value
     */
    public static final String PERMS = "Perms";

    private final PDCatalog catalog;

    private OutputIntents outputIntents = null;

    public GFPDDocument(org.verapdf.pd.PDDocument document) {
        super(document, PD_DOCUMENT_TYPE);
        PDCatalog catalog = document.getCatalog();
        this.catalog = catalog;
    }

    @Override
    public Boolean getcontainsAlternatePresentations() {
        if (this.catalog != null) {
            COSObject rawCatalog = this.catalog.getObject();
            if (rawCatalog != null && rawCatalog.getType().isDictionaryBased()) {
                COSObject namesDictionary = rawCatalog.getKey(ASAtom.NAMES);
                if (namesDictionary != null && namesDictionary.getType().isDictionaryBased()) {
                    COSObject alternatePresentations = namesDictionary.getKey(ASAtom.getASAtom("AlternatePresentations"));
                    if (alternatePresentations != null && !alternatePresentations.empty() && alternatePresentations.getType() != COSObjType.COS_NULL) {
                        return Boolean.TRUE;
                    }
                }
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean getcontainsAA() {
        return this.catalog != null && this.catalog.getObject().getType().isDictionaryBased() && this.catalog.knownKey(ASAtom.AA);
    }

    @Override
    public String getoutputColorSpace() {
        if (this.outputIntents == null) {
            this.outputIntents = parseOutputIntents();
        }
        if (this.outputIntents != null) {
            return ((GFOutputIntents)outputIntents).getColorSpace();
        }
        return null;
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case OUTLINES:
                return this.getOutlines();
            case OPEN_ACTION:
                return this.getOpenAction();
            case OPEN_ACTION_DESTINATION:
                return this.getOpenActionDestination();
            case ACTIONS:
                return this.getActions();
            case PAGES:
                return GFPDDocument.getPages();
            case METADATA:
                return this.getMetadata();
            case OUTPUT_INTENTS:
                return this.getOutputIntents();
            case ACRO_FORMS:
                return this.getAcroForms();
            case STRUCTURE_TREE_ROOT:
                return this.getStructureTreeRoot();
            case OC_PROPERTIES:
                return this.getOCProperties();
            case LANG:
                return this.getLang();
            case PERMS:
                return this.getPerms();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<PDOutline> getOutlines() {
        return OutlinesHelper.getOutlines(this.catalog);
    }

    private List<PDAction> getOpenAction() {
        List<PDAction> actions = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
        org.verapdf.pd.actions.PDAction action = this.catalog.getOpenAction();
        if (action != null) {
            actions.add(GFPDAction.getAction(action));
        }
        return Collections.unmodifiableList(actions);
    }

    private List<PDDestination> getOpenActionDestination() {
        List<PDDestination> destinations = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
        COSObject openAction = this.catalog.getKey(ASAtom.OPEN_ACTION);
        if (openAction != null && openAction.getType() == COSObjType.COS_ARRAY) {
            destinations.add(new GFPDDestination(openAction));
        }
        return Collections.unmodifiableList(destinations);
    }

    private List<PDAdditionalActions> getActions() {
        if (this.catalog != null) {
            PDCatalogAdditionalActions additionalActions = this.catalog.getAdditionalActions();
            if (additionalActions != null) {
                List<PDAdditionalActions> actions = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
                actions.add(new GFPDAdditionalActions(additionalActions));
                return Collections.unmodifiableList(actions);
            }
        }
        return Collections.emptyList();
    }

	private static List<PDPage> getPages() {
		List<PDPage> result = new ArrayList<>();
		List<org.verapdf.pd.PDPage> rawPages = StaticResources.getDocument().getPages();
		for (org.verapdf.pd.PDPage rawPage : rawPages) {
			result.add(new GFPDPage(rawPage));
		}
		return Collections.unmodifiableList(result);
	}

    private List<PDMetadata> getMetadata() {
        if (this.catalog != null) {
            org.verapdf.pd.PDMetadata meta = this.catalog.getMetadata();
            if (meta != null && org.verapdf.pd.PDMetadata.isMetadataObject(meta.getObject())) {
                List<PDMetadata> metadata = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
                metadata.add(new GFPDMetadata(meta, Boolean.TRUE));
                return Collections.unmodifiableList(metadata);
            }
        }
        return Collections.emptyList();
    }

    private List<OutputIntents> getOutputIntents() {
        if (this.outputIntents == null) {
            this.outputIntents = parseOutputIntents();
        }
        if (this.outputIntents != null) {
            List<OutputIntents> array = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            array.add(this.outputIntents);
            return array;
        }
        return Collections.emptyList();
    }

    private OutputIntents parseOutputIntents() {
        List<org.verapdf.pd.PDOutputIntent> outInts = document.getOutputIntents();
        if (!outInts.isEmpty()) {
            return new GFOutputIntents(outInts);
        }
        return null;
    }

    private List<PDAcroForm> getAcroForms() {
        org.verapdf.pd.form.PDAcroForm acroForm = document.getAcroForm();
        if (acroForm != null) {
            List<PDAcroForm> forms = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            forms.add(new GFPDAcroForm(acroForm));
            return Collections.unmodifiableList(forms);
        }
        return Collections.emptyList();
    }

    private List<PDStructTreeRoot> getStructureTreeRoot() {
        org.verapdf.pd.structure.PDStructTreeRoot root = document.getStructTreeRoot();
        if (root != null) {
            List<PDStructTreeRoot> res = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            res.add(new GFPDStructTreeRoot(root));
            return Collections.unmodifiableList(res);
        }
        return Collections.emptyList();
    }

    private List<PDPerms> getPerms() {
        if (this.catalog != null) {
            COSObject perms = this.catalog.getKey(ASAtom.PERMS);
            if (perms != null && perms.getType().isDictionaryBased()) {
                List<PDPerms> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
                list.add(new GFPDPerms(perms));
                return Collections.unmodifiableList(list);
            }
        }
        return Collections.emptyList();
    }

    private List<PDOCProperties> getOCProperties() {
        if (this.catalog != null) {
            PDOptionalContentProperties ocProperties = this.catalog.getOCProperties();
            if (ocProperties != null) {
                List<PDOCProperties> result = new ArrayList<>();

                PDOCProperties pdOCProperties = new GFPDOCProperties(ocProperties);
                result.add(pdOCProperties);

                return result;
            }
        }
        return Collections.emptyList();
    }

    private List<CosLang> getLang() {
        if (this.catalog != null) {
            COSObject baseLang = catalog.getKey(ASAtom.LANG);
            if (baseLang != null && baseLang.getType() == COSObjType.COS_STRING) {
                List<CosLang> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
                list.add(new GFCosLang((COSString) baseLang.getDirectBase()));
                return Collections.unmodifiableList(list);
            }
        }
        return Collections.emptyList();
    }

    @Override
    public String getVersion() {
        return catalog != null ? catalog.getVersion() : null;
    }

    @Override
    public String getmostCommonOrientation() {
        List<String> twoTheMostFrequent = getPages()
                .stream()
                .map(PDPage::getorientation)
                .collect(Collectors.groupingBy(a -> a, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return SQUARE_ORIENTATION.equals(twoTheMostFrequent.get(0)) && twoTheMostFrequent.size() == 2 ? twoTheMostFrequent.get(1) : twoTheMostFrequent.get(0);
    }

    @Override
    public Boolean getcontainsXRefStream() {
        return document.getDocument().isContainsXRefStream();
    }
}
