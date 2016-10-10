package org.verapdf.gf.model.impl.pd;

import org.apache.log4j.Logger;
import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSString;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.cos.GFCosLang;
import org.verapdf.gf.model.impl.pd.actions.GFPDAction;
import org.verapdf.gf.model.impl.pd.signature.GFPDPerms;
import org.verapdf.gf.model.tools.OutlinesHelper;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosLang;
import org.verapdf.model.pdlayer.*;
import org.verapdf.pd.PDCatalog;
import org.verapdf.pd.actions.PDCatalogAdditionalActions;
import org.verapdf.pd.optionalcontent.PDOptionalContentProperties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFPDDocument extends GFPDObject implements PDDocument {

    private static final Logger LOGGER = Logger.getLogger(GFPDDocument.class);

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
    /**
     * Link name for all outlines of document
     */
    public static final String OUTLINES = "Outlines";
    /**
     * Link name for annotations structure tree root of document
     */
    public static final String STRUCTURE_TREE_ROOT = "StructTreeRoot";
    /**
     * Link name for alternate presentation of names tree of document
     */
    public static final String ALTERNATE_PRESENTATIONS = "AlternatePresentations";
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

    public static final int MAX_NUMBER_OF_ACTIONS = 5;

    private final PDCatalog catalog;

    public GFPDDocument(org.verapdf.pd.PDDocument document) {
        super(document, PD_DOCUMENT_TYPE);
        PDCatalog catalog = null;
        try {
            catalog = document.getCatalog();
        } catch (IOException e) {
            LOGGER.debug("Can't obtain document catalog");
        }
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
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case OUTLINES:
                return this.getOutlines();
            case OPEN_ACTION:
                return this.getOpenAction();
            case ACTIONS:
                return this.getActions();
            case PAGES:
                return this.getPages();
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

    private List<PDAction> getActions() {
        if (this.catalog != null) {
            PDCatalogAdditionalActions additionalActions = this.catalog.getAdditionalActions();
            if (additionalActions != null) {
                List<PDAction> actions = new ArrayList<>(MAX_NUMBER_OF_ACTIONS);

                org.verapdf.pd.actions.PDAction raw;

                raw = additionalActions.getDP();
                this.addAction(actions, raw);

                raw = additionalActions.getDS();
                this.addAction(actions, raw);

                raw = additionalActions.getWP();
                this.addAction(actions, raw);

                raw = additionalActions.getWS();
                this.addAction(actions, raw);

                raw = additionalActions.getWC();
                this.addAction(actions, raw);

                return Collections.unmodifiableList(actions);
            }
        }
        return Collections.emptyList();
    }

    private List<PDPage> getPages() {
        try {
            List<PDPage> result = new ArrayList<>();
            List<org.verapdf.pd.PDPage> rawPages = StaticContainers.getDocument().getPages();
            for (org.verapdf.pd.PDPage rawPage : rawPages) {
                result.add(new GFPDPage(rawPage));
            }
            return result;
        } catch (Exception e) {
            LOGGER.debug("Error while processing pages.");
        }
        return Collections.emptyList();
    }

    private List<PDMetadata> getMetadata() {
        if (this.catalog != null) {
            org.verapdf.pd.PDMetadata meta = this.catalog.getMetadata();
            if (meta != null) {
                List<PDMetadata> metadata = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
                metadata.add(new GFPDMetadata(meta, Boolean.TRUE));
                return Collections.unmodifiableList(metadata);
            }
        }
        return Collections.emptyList();
    }

    private List<PDOutputIntent> getOutputIntents() {
        try {
            List<org.verapdf.pd.PDOutputIntent> outInts = document.getOutputIntents();
            if (outInts.size() > 0) {
                List<PDOutputIntent> res = new ArrayList<>(outInts.size());
                for (org.verapdf.pd.PDOutputIntent outInt : outInts) {
                    res.add(new GFPDOutputIntent(outInt));
                }
                return Collections.unmodifiableList(res);
            }
        } catch (IOException e) {
            LOGGER.debug("Exception during obtaining OutputIntents", e);
        }
        return Collections.emptyList();
    }

    private List<PDAcroForm> getAcroForms() {
        try {
            org.verapdf.pd.form.PDAcroForm acroForm = document.getAcroForm();
            if (acroForm != null) {
                List<PDAcroForm> forms = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
                forms.add(new GFPDAcroForm(acroForm));
                return Collections.unmodifiableList(forms);
            }
        } catch (IOException e) {
            LOGGER.debug("Exception during obtaining AcroForm", e);
        }
        return Collections.emptyList();
    }

    private List<PDStructTreeRoot> getStructureTreeRoot() {
        try {
            org.verapdf.pd.PDStructTreeRoot root = document.getStructTreeRoot();
            if (root != null) {
                List<PDStructTreeRoot> res = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
                res.add(new GFPDStructTreeRoot(root));
                return Collections.unmodifiableList(res);
            }
        } catch (IOException e) {
            LOGGER.debug("Exception during obtaining Structure tree root", e);
        }
        return Collections.emptyList();
    }

    private List<PDPerms> getPerms() {
        if(this.catalog != null) {
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

}
