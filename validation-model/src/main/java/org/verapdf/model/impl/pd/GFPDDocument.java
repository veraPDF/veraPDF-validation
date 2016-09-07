package org.verapdf.model.impl.pd;

import org.apache.log4j.Logger;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosLang;
import org.verapdf.model.impl.containers.StaticContainers;
import org.verapdf.model.pdlayer.*;
import org.verapdf.pd.PDCatalog;

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

    //TODO : implement me
    private List<PDOutline> getOutlines() {
        return Collections.emptyList();
    }

    //TODO : implement me
    private List<PDAction> getOpenAction() {
        return Collections.emptyList();
    }

    //TODO : implement me
    private List<PDAction> getActions() {
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

    //TODO : implement me
    private List<PDAcroForm> getAcroForms() {
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

    //TODO : implement me
    private List<PDPerms> getPerms() {
        return Collections.emptyList();
    }

    //TODO : implement me
    private List<PDOCProperties> getOCProperties() {
        return Collections.emptyList();
    }

    //TODO : implement me
    private List<CosLang> getLang() {
        return Collections.emptyList();
    }

}
