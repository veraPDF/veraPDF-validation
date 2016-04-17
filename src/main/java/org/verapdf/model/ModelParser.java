package org.verapdf.model;

import org.apache.log4j.Logger;
import org.verapdf.model.impl.cos.GFCosDocument;
import org.verapdf.pd.PDDocument;
import org.verapdf.pdfa.ValidationModelParser;
import org.verapdf.pdfa.flavours.PDFAFlavour;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author Timur Kamalov
 */
public class ModelParser implements ValidationModelParser, Closeable {

    private static final Logger LOGGER = Logger.getLogger(ModelParser.class);

    private PDDocument document;

    private final PDFAFlavour flavour;

    /**
     * @param fileName
     * @throws IOException
     */
    public ModelParser(String fileName, PDFAFlavour flavour) throws Exception {
        this.document = new PDDocument(fileName);
        this.flavour = flavour;
    }

    public PDDocument getPDDocument() throws IOException {
        return this.document;
    }

    @Override
    public org.verapdf.model.baselayer.Object getRoot() throws IOException {
        return new GFCosDocument(this.document, this.flavour);
    }

    @Override
    public void close() {
        if (this.document != null) {
            this.document.close();
        }
    }

}
