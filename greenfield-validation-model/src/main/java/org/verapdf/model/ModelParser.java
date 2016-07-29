package org.verapdf.model;

import com.adobe.xmp.XMPException;
import com.adobe.xmp.impl.VeraPDFMeta;
import org.apache.log4j.Logger;
import org.verapdf.core.ModelParsingException;
import org.verapdf.features.FeaturesExtractor;
import org.verapdf.features.config.FeaturesConfig;
import org.verapdf.features.tools.FeaturesCollection;
import org.verapdf.model.impl.containers.StaticContainers;
import org.verapdf.model.impl.cos.GFCosDocument;
import org.verapdf.pd.PDCatalog;
import org.verapdf.pd.PDDocument;
import org.verapdf.pd.PDMetadata;
import org.verapdf.pdfa.PDFParser;
import org.verapdf.pdfa.flavours.PDFAFlavour;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class ModelParser implements PDFParser, Closeable {

    private static final Logger LOGGER = Logger.getLogger(ModelParser.class);

    private static final PDFAFlavour DEFAULT_FLAVOUR = PDFAFlavour.PDFA_1_B;

    private PDDocument document;

    private final PDFAFlavour flavour;

    private ModelParser(final InputStream docStream, PDFAFlavour flavour) throws IOException {
        this.document = new PDDocument(docStream);
        this.flavour = (flavour == PDFAFlavour.AUTO) ? obtainFlavour(this.document) : flavour;
        initializeStaticContainers(this.document, this.flavour);
    }


    public static ModelParser createModelWithFlavour(InputStream toLoad, PDFAFlavour flavour) throws ModelParsingException {
        try {
            return new ModelParser(toLoad, (flavour == PDFAFlavour.NO_FLAVOUR || flavour == null) ? DEFAULT_FLAVOUR : flavour);
        } catch (IOException e) {
            throw new ModelParsingException("Couldn't parse stream", e);
        }
    }

    private static PDFAFlavour obtainFlavour(PDDocument document) {
        try {
            PDCatalog documentCatalog = document.getCatalog();
            if (documentCatalog == null) {
                return DEFAULT_FLAVOUR;
            }
            PDMetadata metadata = documentCatalog.getMetadata();
            if (metadata == null) {
                return DEFAULT_FLAVOUR;
            }
            VeraPDFMeta veraPDFMeta = VeraPDFMeta.parse(metadata.getStream());
            Integer identificationPart = veraPDFMeta.getIdentificationPart();
            String identificationConformance = veraPDFMeta.getIdentificationConformance();
            PDFAFlavour pdfaFlavour = PDFAFlavour.byFlavourId(identificationPart + identificationConformance);
            return pdfaFlavour == PDFAFlavour.NO_FLAVOUR ? DEFAULT_FLAVOUR : pdfaFlavour;
        } catch (IOException | XMPException e) {
            LOGGER.debug(e);
            return DEFAULT_FLAVOUR;
        }
    }

    private static void initializeStaticContainers(final PDDocument document, final PDFAFlavour flavour) {
        StaticContainers.clearAllContainers();
        StaticContainers.setDocument(document);
        StaticContainers.setFlavour(flavour);
    }

    /**
     * Get {@code PDDocument} object for current file.
     *
     * @return {@link org.verapdf.pd.PDDocument} object of greenfield
     * library.
     * @throws IOException when target file is not pdf or pdf file is not contain root
     *                     object
     */
    public PDDocument getPDDocument() throws IOException {
        return this.document;
    }

    /**
     * Method return root object of model implementation from greenfield model
     * together with the hierarchy.
     *
     * @return root object representing by
     * {@link org.verapdf.model.coslayer.CosDocument}
     * @throws IOException when target file is not pdf or pdf file is not contain root
     *                     object
     */
    @Override
    public org.verapdf.model.baselayer.Object getRoot() {
        return new GFCosDocument(this.document.getDocument());
    }

    @Override
    public PDFAFlavour getFlavour() {
        return this.flavour;
    }

    @Override
    public FeaturesCollection getFeatures(FeaturesConfig config) {
        return null;
    }

    @Override
    public FeaturesCollection getFeatures(FeaturesConfig config, List<FeaturesExtractor> extractors) {
        return null;
    }

    @Override
    public void close() {
        if (this.document != null) {
            this.document.close();
        }
    }

}
