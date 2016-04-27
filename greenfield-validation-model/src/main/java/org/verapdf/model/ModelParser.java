package org.verapdf.model;

import org.apache.log4j.Logger;
import org.verapdf.model.impl.cos.GFCosDocument;
import org.verapdf.pd.PDDocument;
import org.verapdf.pdfa.ValidationModelParser;
import org.verapdf.pdfa.flavours.PDFAFlavour;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Timur Kamalov
 */
public class ModelParser implements ValidationModelParser, Closeable {

    private static final Logger LOGGER = Logger.getLogger(ModelParser.class);

    private static final PDFAFlavour DEFAULT_FLAVOUR = PDFAFlavour.PDFA_1_B;

    private PDDocument document;

    private final PDFAFlavour flavour;

    private ModelParser(PDDocument document, PDFAFlavour flavour) throws IOException {
        this.document = document;
        this.flavour = flavour;
    }

    public static ModelParser createModelWithFlavour(InputStream toLoad, PDFAFlavour flavour) throws Exception {
        PDDocument document = new PDDocument(toLoad);

        PDFAFlavour resultFlavour;
        if (flavour == PDFAFlavour.AUTO) {
            resultFlavour = obtainFlavour(document);
        } else if (flavour == PDFAFlavour.NO_FLAVOUR || flavour == null) {
            resultFlavour = DEFAULT_FLAVOUR;
        } else {
            resultFlavour = flavour;
        }
        return new ModelParser(document, resultFlavour);
    }

    private static PDFAFlavour obtainFlavour(PDDocument document) {
        return DEFAULT_FLAVOUR;
    }

    /**
     * Get {@code PDDocument} object for current file.
     *
     * @return {@link org.verapdf.pd.PDDocument} object of greenfield
     *         library.
     * @throws IOException
     *             when target file is not pdf or pdf file is not contain root
     *             object
     */
    public PDDocument getPDDocument() throws IOException {
        return this.document;
    }

    /**
     * Method return root object of model implementation from greenfield model
     * together with the hierarchy.
     *
     * @return root object representing by
     *         {@link org.verapdf.model.coslayer.CosDocument}
     * @throws IOException
     *             when target file is not pdf or pdf file is not contain root
     *             object
     */
    @Override
    public org.verapdf.model.baselayer.Object getRoot() throws IOException {
        return new GFCosDocument(this.document, this.flavour);
    }

    @Override
    public PDFAFlavour getFlavour() {
        return this.flavour;
    }

    @Override
    public void close() {
        if (this.document != null) {
            this.document.close();
        }
    }

}
