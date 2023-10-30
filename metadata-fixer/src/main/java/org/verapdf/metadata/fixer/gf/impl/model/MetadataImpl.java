/**
 * This file is part of veraPDF Metadata Fixer, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Metadata Fixer is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Metadata Fixer as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Metadata Fixer as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.metadata.fixer.gf.impl.model;

import org.verapdf.xmp.XMPConst;
import org.verapdf.xmp.XMPException;
import org.verapdf.xmp.impl.VeraPDFMeta;
import org.verapdf.as.ASAtom;
import org.verapdf.as.io.ASMemoryInStream;
import org.verapdf.cos.*;
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
import org.verapdf.xmp.impl.VeraPDFXMPNode;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Maksim Bezrukov
 */
public class MetadataImpl implements Metadata {

    private static final Logger LOGGER = Logger.getLogger(MetadataImpl.class.getCanonicalName());

    private static final String YEAR_2020 = "2020";
    private static final String YEAR_202X = "0000";
    private static final String YEAR_REGEX = "^\\d{4}$";
    
    private static String ADD_PROPERTY_MESSAGE = "Added property %s with value %s to Identification schema";
    private static String REMOVE_PROPERTY_MESSAGE = "Removed property %s from Identification schema";
    private static String SET_PROPERTY_MESSAGE = "Set property %s value to %s in Identification schema";


    private final VeraPDFMeta metadata;
    private final COSObject stream;
    private final COSDocument doc;
    private final boolean isStreamCreated;

    /**
     * @param metadata
     * @param stream
     */
    public MetadataImpl(VeraPDFMeta metadata, COSObject stream, COSDocument doc, boolean isStreamCreated) {
        if (metadata == null) {
            throw new IllegalArgumentException("Metadata package can not be null");
        }
        if (stream.empty() || stream.getType() != COSObjType.COS_STREAM) {
            throw new IllegalArgumentException("Metadata stream can not be null");
        }
        this.metadata = metadata;
        this.stream = stream;
        this.doc = doc;
        this.isStreamCreated = isStreamCreated;
    }

    @Override
    public void checkMetadataStream(MetadataFixerResultImpl.Builder resultBuilder, PDFAFlavour flavour) {
        if (flavour.getPart() != PDFAFlavour.Specification.ISO_19005_1) {
            COSFilters filters = ((COSStream) this.stream.getDirectBase()).getFilters();
            if (filters.size() == 1 && filters.getFilters().get(0) == ASAtom.FLATE_DECODE) {
                return;
            }
            this.doc.addChangedObject(stream);
        }
        this.setRequiredDictionaryValue(ASAtom.METADATA, ASAtom.TYPE, resultBuilder);
        this.setRequiredDictionaryValue(ASAtom.XML, ASAtom.SUBTYPE, resultBuilder);
    }

    private void setRequiredDictionaryValue(ASAtom value, ASAtom key, MetadataFixerResultImpl.Builder resultBuilder) {
        if (!value.equals(this.stream.getNameKey(key))) {
            this.stream.setNameKey(key, value);
            this.doc.addChangedObject(stream);
            resultBuilder.addFix(value.getValue() + " value of " + key.getValue() + " key is set to metadata dictionary");
        }
    }

    @Override
    public void removePDFIdentificationSchema(MetadataFixerResultImpl.Builder resultBuilder, PDFAFlavour flavour) {
        if (PDFAFlavour.IsoStandardSeries.ISO_14289.equals(flavour.getPart().getSeries())) {
            removePDFUAIdentificationSchema(resultBuilder, flavour);
        } else {
            removePDFAIdentificationSchema(resultBuilder, flavour);
        }
    }

    public void removePDFAIdentificationSchema(MetadataFixerResultImpl.Builder resultBuilder, PDFAFlavour flavour) {
        if (isValidPDFAIdentification() && isWrongPDFAIdentification(flavour)) {
            return;
        }
        if (this.metadata.deletePDFAIdentificationSchema()) {
            this.setNeedToBeUpdated(true);
            resultBuilder.addFix("Identification schema removed");
            resultBuilder.status(MetadataFixerResult.RepairStatus.ID_REMOVED);
        }
    }

    public void removePDFUAIdentificationSchema(MetadataFixerResultImpl.Builder resultBuilder, PDFAFlavour flavour) {
        try {
            if (!Objects.equals(flavour.getPart().getPartNumber(), this.metadata.getPDFUAIdentificationPart())) {
                return;
            }
            if (this.metadata.deletePDFUAIdentificationSchema()) {
                this.setNeedToBeUpdated(true);
                resultBuilder.addFix("PDF/UA Identification schema removed");
                resultBuilder.status(MetadataFixerResult.RepairStatus.ID_REMOVED);
            }
        } catch (XMPException e) {
            LOGGER.log(Level.FINE, "Can not obtain identification part.", e);
        }
    }

    @Override
    public void addPDFIdentificationSchema(MetadataFixerResultImpl.Builder resultBuilder, PDFAFlavour flavour) {
        if (PDFAFlavour.IsoStandardSeries.ISO_14289.equals(flavour.getPart().getSeries())) {
            addPDFUAIdentificationSchema(resultBuilder, flavour);
        } else {
            addPDFAIdentificationSchema(resultBuilder, flavour);
            checkAndFixPrefixes(resultBuilder, flavour);
        }
        fixRevProperty(resultBuilder, flavour);
    }

    public void checkAndFixPrefixes(MetadataFixerResultImpl.Builder resultBuilder, PDFAFlavour flavour) {
        if (flavour.getPart() == PDFAFlavour.Specification.ISO_19005_1 ||
                flavour.getPart() == PDFAFlavour.Specification.ISO_19005_2 ||
                flavour.getPart() == PDFAFlavour.Specification.ISO_19005_3) {
            fixPropertyPrefix(resultBuilder, VeraPDFMeta.PART, VeraPDFMeta.PDFAID_PREFIX);
            fixPropertyPrefix(resultBuilder, VeraPDFMeta.CONFORMANCE, VeraPDFMeta.PDFAID_PREFIX);
            fixPropertyPrefix(resultBuilder, VeraPDFMeta.AMD, VeraPDFMeta.PDFAID_PREFIX);
            if (flavour.getPart() != PDFAFlavour.Specification.ISO_19005_1) {
                fixPropertyPrefix(resultBuilder,  VeraPDFMeta.CORR, VeraPDFMeta.PDFAID_PREFIX);
            }
        } else if (flavour.getPart() == PDFAFlavour.Specification.ISO_19005_4) {
            fixPropertyPrefix(resultBuilder, VeraPDFMeta.PART, VeraPDFMeta.PDFAID_PREFIX);
            fixPropertyPrefix(resultBuilder, VeraPDFMeta.REVISION_YEAR, VeraPDFMeta.PDFAID_PREFIX);
        }
    }

    private void fixPropertyPrefix(MetadataFixerResultImpl.Builder resultBuilder, String propertyName, String propertyPrefix) {
        VeraPDFXMPNode property = this.metadata.getProperty(XMPConst.NS_PDFA_ID, propertyName);
        if (property != null && !propertyPrefix.equals(property.getPrefix())) {
            property.setPrefix(propertyPrefix);
            this.setNeedToBeUpdated(true);
            resultBuilder.addFix("Set prefix of " + propertyName + " property to " + propertyPrefix);
        }
    }

    public void addPDFUAIdentificationSchema(MetadataFixerResultImpl.Builder resultBuilder, PDFAFlavour flavour) {
        try {
            int part = flavour.getPart().getPartNumber();
            if (!Objects.equals(this.metadata.getPDFUAIdentificationPart(), part)) {
                resultBuilder.addFix(String.format(this.metadata.getPDFUAIdentificationPart() == null ?
                        ADD_PROPERTY_MESSAGE : SET_PROPERTY_MESSAGE, VeraPDFMeta.PART, part));
                        this.metadata.setPDFUAIdentificationPart(part);
                this.setNeedToBeUpdated(true);
            }
        } catch (XMPException e) {
            LOGGER.log(Level.FINE, "Can not obtain identification fields.", e);
        }
    }

    public void addPDFAIdentificationSchema(MetadataFixerResultImpl.Builder resultBuilder, PDFAFlavour flavour) {
        if (isValidPDFAIdentification() && !isWrongPDFAIdentification(flavour)) {
            return;
        }
        int part = flavour.getPart().getPartNumber();
        String conformance = flavour != PDFAFlavour.PDFA_4 ? flavour.getLevel().getCode().toUpperCase() : null;
        try {
            resultBuilder.addFix(String.format(this.metadata.getPDFAIdentificationPart() == null ? 
                    ADD_PROPERTY_MESSAGE : SET_PROPERTY_MESSAGE, VeraPDFMeta.PART, part));
            this.metadata.setPDFAIdentificationPart(part);

            resultBuilder.addFix(String.format(this.metadata.getPDFAIdentificationConformance() == null ?
                    ADD_PROPERTY_MESSAGE : (conformance == null ? REMOVE_PROPERTY_MESSAGE : SET_PROPERTY_MESSAGE), 
                    VeraPDFMeta.CONFORMANCE, conformance));
            this.metadata.setPDFAIdentificationConformance(conformance);
            this.setNeedToBeUpdated(true);
        } catch (XMPException e) {
            LOGGER.log(Level.FINE, "Can not obtain identification fields.", e);
        }
    }

    private void fixRevProperty(MetadataFixerResultImpl.Builder resultBuilder, PDFAFlavour flavour) {
        if (flavour.getPart() != PDFAFlavour.Specification.ISO_19005_4 && flavour != PDFAFlavour.PDFUA_2) {
            return;
        }
        String namespaceURI = flavour == PDFAFlavour.PDFUA_2 ? XMPConst.NS_PDFUA_ID : XMPConst.NS_PDFA_ID;
        try {
            VeraPDFXMPNode rev = this.metadata.getProperty(namespaceURI, VeraPDFMeta.REVISION_YEAR);
            if (rev == null) {
                this.metadata.setIdentificationRevisionYear(namespaceURI, YEAR_202X);
                this.setNeedToBeUpdated(true);
                resultBuilder.addFix(String.format(ADD_PROPERTY_MESSAGE, VeraPDFMeta.REVISION_YEAR, YEAR_2020));
            } else if (!rev.getValue().matches(YEAR_REGEX)) {
                this.metadata.setIdentificationRevisionYear(namespaceURI, YEAR_202X);
                this.setNeedToBeUpdated(true);
                resultBuilder.addFix(String.format(SET_PROPERTY_MESSAGE, VeraPDFMeta.REVISION_YEAR, YEAR_2020));
            }
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

    private boolean isWrongPDFAIdentification(PDFAFlavour flavour) {
        try {
            int part = flavour.getPart().getPartNumber();
            String conformance = flavour != PDFAFlavour.PDFA_4 ? flavour.getLevel().getCode().toUpperCase() : null;
            Integer schemaPart = this.metadata.getPDFAIdentificationPart();
            String schemaConformance = this.metadata.getPDFAIdentificationConformance();
            return schemaPart != part ||
                    (part == 4 && !Objects.equals(conformance, schemaConformance)) ||
                    ((part == 1 || part == 2 || part == 3) && compare(conformance, schemaConformance) > 0);
        } catch (XMPException e) {
            LOGGER.log(Level.FINE, "Can not obtain identification fields.", e);
            throw new IllegalStateException(e);
        }
    }

    private boolean isValidPDFAIdentification() {
        try {
            Integer identificationPart = this.metadata.getPDFAIdentificationPart();
            if (identificationPart == null) {
                return false;
            }
            String identificationConformance = this.metadata.getPDFAIdentificationConformance();
            if (identificationPart == 1) {
                return "A".equals(identificationConformance) || "B".equals(identificationConformance);
            } else if (identificationPart == 2 || identificationPart == 3) {
                return "A".equals(identificationConformance) ||
                        "U".equals(identificationConformance) ||
                        "B".equals(identificationConformance);
            } else if (identificationPart == 4) {
                return identificationConformance == null ||
                        "E".equals(identificationConformance) ||
                        "F".equals(identificationConformance);
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
        if (isStreamCreated) {
            if (needToBeUpdated) {
                this.doc.addObject(this.stream);
            } else {
                this.doc.removeAddedObject(this.stream);
            }
        } else {
            if (needToBeUpdated) {
                this.doc.addChangedObject(this.stream);
            } else {
                this.doc.removeChangedObject(this.stream);
            }
        }
    }

    @Override
    public void updateMetadataStream(MetadataFixerResultImpl.Builder builder, PDFAFlavour flavour) throws IOException, XMPException {
        if (!this.doc.isObjectChanged(this.stream)) {
            return;
        }
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            VeraPDFMeta.serialize(this.metadata, out);
            byte[] buf = out.toByteArray();
            try (InputStream inStream = new ByteArrayInputStream(buf)) {
                this.stream.setData(new ASMemoryInStream(inStream));
            }
        }
        if (flavour.getPart() != PDFAFlavour.Specification.ISO_19005_1) {
            COSStream cosStream = (COSStream) stream.getDirectBase();
            COSFilters filters = cosStream.getFilters();
            boolean isFixFilter = filters.size() != 1 || filters.getFilters().get(0) != ASAtom.FLATE_DECODE;
            cosStream.setKey(ASAtom.FILTER, new COSObject());
            try {
                cosStream.setFilters(new COSFilters(COSName.construct(ASAtom.FLATE_DECODE)));
                if (isFixFilter) {
                    builder.addFix("Metadata stream filtered with FlateDecode");
                }
            } catch (IOException e) {
                LOGGER.log(Level.FINE, "Problems with setting filter for stream.", e);
            }
        }
    }
}
