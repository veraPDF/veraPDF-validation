package org.verapdf.metadata.fixer.gf.impl.model;

import com.adobe.xmp.XMPException;
import com.adobe.xmp.impl.VeraPDFMeta;
import org.verapdf.as.ASAtom;
import org.verapdf.cos.*;
import org.verapdf.io.InternalInputStream;
import org.verapdf.metadata.fixer.entity.InfoDictionary;
import org.verapdf.metadata.fixer.entity.Metadata;
import org.verapdf.metadata.fixer.gf.impl.schemas.AdobePDFSchemaImpl;
import org.verapdf.metadata.fixer.gf.impl.schemas.DublinCoreSchemaImpl;
import org.verapdf.metadata.fixer.gf.impl.schemas.XMPBasicSchemaImpl;
import org.verapdf.metadata.fixer.schemas.AdobePDF;
import org.verapdf.metadata.fixer.schemas.DublinCore;
import org.verapdf.metadata.fixer.schemas.XMPBasic;
import org.verapdf.pdfa.flavours.PDFAFlavour;
import org.verapdf.pdfa.results.MetadataFixerResult;
import org.verapdf.pdfa.results.MetadataFixerResultImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Maksim Bezrukov
 */
public class MetadataImpl implements Metadata {

    private static final Logger LOGGER = Logger.getLogger(MetadataImpl.class.getCanonicalName());

    private final VeraPDFMeta metadata;
    private final COSObject stream;
    private final COSDocument doc;
    private boolean isStreamCreated;

    /**
     * @param metadata
     * @param stream
     */
    public MetadataImpl(VeraPDFMeta metadata, COSObject stream, COSDocument doc,
                        boolean isStreamCreated) {
        if (metadata == null) {
            throw new IllegalArgumentException(
                    "Metadata package can not be null");
        }
        if (stream.empty() || stream.getType() != COSObjType.COS_STREAM) {
            throw new IllegalArgumentException(
                    "Metadata stream can not be null");
        }
        this.metadata = metadata;
        this.stream = stream;
        this.doc = doc;
        this.isStreamCreated = isStreamCreated;
    }

    @Override
    public void checkMetadataStream(
            MetadataFixerResultImpl.Builder resultBuilder,
            PDFAFlavour flavour) {
        PDFAFlavour.Specification part = flavour.getPart();
        if (part == PDFAFlavour.Specification.ISO_19005_2 || part == PDFAFlavour.Specification.ISO_19005_3) {
            COSFilters filters = ((COSStream) this.stream.getDirectBase()).getFilters();
            if (filters.size() == 1 && filters.getFilters().get(0) == ASAtom.FLATE_DECODE) {
                return;
            }
            try {
                ((COSStream) this.stream.getDirectBase()).setFilters(new COSFilters(
                        COSName.construct(ASAtom.FLATE_DECODE)));
                this.doc.addChangedObject(stream);
                resultBuilder.addFix("Metadata stream filtered with FlateDecode");
            } catch (IOException e) {
                LOGGER.log(Level.FINE, "Problems with setting filter for stream.", e);
            }
        }
        this.setRequiredDictionaryValue(ASAtom.METADATA, ASAtom.TYPE,
                resultBuilder);
        this.setRequiredDictionaryValue(ASAtom.getASAtom("XML"),
                ASAtom.SUBTYPE, resultBuilder);
    }

    private void setRequiredDictionaryValue(ASAtom value, ASAtom key,
                                            MetadataFixerResultImpl.Builder resultBuilder) {
        if (!value.equals(this.stream.getNameKey(key))) {
            this.stream.setNameKey(key, value);
            this.doc.addChangedObject(stream);
            resultBuilder.addFix(value.getValue() + " value of " + key.getValue()
                    + " key is set to metadata dictionary");
        }
    }

    @Override
    public void removePDFIdentificationSchema(
            MetadataFixerResultImpl.Builder resultBuilder, PDFAFlavour flavour) {
        try {
            if (isValidIdentification()) {
                int part = flavour.getPart().getPartNumber();
                Integer schemaPart = this.metadata.getIdentificationPart();

                if (schemaPart != null &&
                        schemaPart.intValue() != part) {
                    return;
                }
            }

            boolean isDeleted = this.metadata.deleteIdentificationSchema();
            if (isDeleted) {
                this.setNeedToBeUpdated(true);
                resultBuilder.addFix("Identification schema removed");
                resultBuilder.status(MetadataFixerResult.RepairStatus.ID_REMOVED);
            }

        } catch (XMPException e) {
            LOGGER.log(Level.FINE, "Can not obtain identification part.", e);
        }
    }

    @Override
    public void addPDFIdentificationSchema(
            MetadataFixerResultImpl.Builder resultBuilder, PDFAFlavour flavour) {
        int part = flavour.getPart().getPartNumber();
        String conformance = flavour.getLevel().getCode().toUpperCase();

        try {
            if (isValidIdentification()) {
                Integer schemaPart = this.metadata.getIdentificationPart();
                String schemaConformance = this.metadata.getIdentificationConformance();

                if (schemaPart != null &&
                        schemaConformance != null &&
                        (schemaPart.intValue() != part ||
                                compare(conformance, schemaConformance) <= 0)) {
                    return;
                }
            }

            this.metadata.setIdentificationPart(Integer.valueOf(part));
            this.metadata.setIdentificationConformance(conformance);
            this.setNeedToBeUpdated(true);
            resultBuilder.addFix("Identification schema added");

        } catch (XMPException e) {
            LOGGER.log(Level.FINE, "Can not obtain identification fields.", e);
        }
    }

	private static int compare(String conf, String confToCompare) {
        int confInt = confToInt(conf);
        int confToCompareInt = confToInt(confToCompare);

        return confInt - confToCompareInt;
    }

    private static int confToInt(String conf) {
        switch (conf) {
            case "A":
                return 2;
            case "U":
                return 1;
            case "B":
                return 0;
            default:
                throw new IllegalStateException("Method call with invalid conformance.");
        }
    }

    private boolean isValidIdentification() {
        try {
            Integer identificationPart = this.metadata.getIdentificationPart();
            if (identificationPart == null) {
                return false;
			}
                String identificationConformance = this.metadata.getIdentificationConformance();
                if (identificationPart.intValue() == 1) {
                    return "A".equals(identificationConformance) || "B".equals(identificationConformance);
                } else if (identificationPart.intValue() == 2 || identificationPart.intValue() == 3) {
                    return "A".equals(this.metadata.getIdentificationConformance()) ||
                            "U".equals(identificationConformance) ||
                            "B".equals(identificationConformance);
                } else {
                    return false;
                }
        } catch (XMPException e) {
            LOGGER.log(Level.FINE, "Can not obtain identification fields.", e);
            throw new IllegalStateException(e);
        }
    }

    @Override
    public DublinCore getDublinCoreSchema(InfoDictionary info) {
        return new DublinCoreSchemaImpl(this.metadata, this);
    }

    @Override
    public AdobePDF getAdobePDFSchema(InfoDictionary info) {
        return new AdobePDFSchemaImpl(this.metadata, this);
    }

    @Override
    public XMPBasic getXMPBasicSchema(InfoDictionary info) {
        return new XMPBasicSchemaImpl(this.metadata, this);
    }

    @Override
    public boolean isNeedToBeUpdated() {
        return this.doc.isObjectChanged(this.stream);
    }

    @Override
    public void setNeedToBeUpdated(boolean needToBeUpdated) {
        if (!isStreamCreated) {
            if (needToBeUpdated) {
                this.doc.addChangedObject(this.stream);
            } else {
                this.doc.removeChangedObject(this.stream);
            }
        } else {
            if (needToBeUpdated) {
                this.doc.addObject(this.stream);
            } else {
                this.doc.removeAddedObject(this.stream);
            }
        }
    }

    @Override
    public void updateMetadataStream() throws IOException, XMPException {
        if (!this.doc.isObjectChanged(this.stream)) {
            return;
        }
        File temp = File.createTempFile("veraPDFMetadataFixed", ".xml");
        temp.deleteOnExit();
        try (OutputStream out = new FileOutputStream(temp)) {
            VeraPDFMeta.serialize(this.metadata, out);
            this.stream.setData(new InternalInputStream(temp));
        }
    }
}
