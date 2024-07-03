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

import org.verapdf.pdfa.flavours.PDFFlavours;
import org.verapdf.tools.StaticResources;
import org.verapdf.xmp.XMPException;
import org.verapdf.xmp.impl.VeraPDFMeta;
import org.verapdf.xmp.impl.VeraPDFXMPNode;
import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSStream;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.cos.GFCosStream;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosStream;
import org.verapdf.model.impl.axl.AXLMainXMPPackage;
import org.verapdf.model.impl.axl.AXLXMPPackage;
import org.verapdf.model.pdlayer.PDMetadata;
import org.verapdf.model.xmplayer.XMPPackage;
import org.verapdf.pdfa.flavours.PDFAFlavour;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Maksim Bezrukov
 */
public class GFPDMetadata extends GFPDObject implements PDMetadata {

    private static final Logger LOGGER = Logger.getLogger(GFPDMetadata.class.getCanonicalName());

    public static final String METADATA_TYPE = "PDMetadata";

    public static final String XMP_PACKAGE = "XMPPackage";
    public static final String STREAM = "stream";

    private final boolean isMainMetadata;
    private final org.verapdf.pd.PDMetadata mainMetadata;

    public GFPDMetadata(org.verapdf.pd.PDMetadata simplePDObject, Boolean isMainMetadata) {
        super(simplePDObject, METADATA_TYPE);
        this.isMainMetadata = isMainMetadata;
        if (StaticResources.getDocument() != null && StaticResources.getDocument().getCatalog() != null && StaticResources.getDocument().getCatalog().getMetadata() != null) {
            this.mainMetadata = StaticResources.getDocument().getCatalog().getMetadata();
        } else {
            this.mainMetadata = null;
        }
    }

    @Override
    public String getFilter() {
        List<ASAtom> filters = ((org.verapdf.pd.PDMetadata) this.simplePDObject)
                .getFilters();
        if (filters != null && !filters.isEmpty()) {
            StringBuilder result = new StringBuilder();
            for (ASAtom filter : filters) {
                result.append(filter.getValue()).append(' ');
            }
            return result.substring(0, result.length() - 1);
        }
        return null;
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case XMP_PACKAGE:
                return this.getXMPPackage();
            case STREAM:
                return this.getStream();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<XMPPackage> getXMPPackage() {
        List<XMPPackage> xmp = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
        List<PDFAFlavour> flavour = StaticContainers.getFlavour();
        try (InputStream stream = ((org.verapdf.pd.PDMetadata) this.simplePDObject).getStream()) {
            if (stream != null) {
                VeraPDFMeta metadata = VeraPDFMeta.parse(stream);
                if (isMainMetadata) {
                    xmp.add(new AXLMainXMPPackage(metadata, true));
                } else if (!PDFFlavours.isFlavourPart(flavour, PDFAFlavour.Specification.ISO_19005_1)) {
                    try (InputStream mainStream = mainMetadata != null ? mainMetadata.getStream() : null) {
                        VeraPDFXMPNode mainExtensionNode = null;
                        if (mainStream != null) {
                            VeraPDFMeta mainMeta = VeraPDFMeta.parse(mainStream);
                            mainExtensionNode = mainMeta.getExtensionSchemasNode();
                        }
                        xmp.add(new AXLXMPPackage(metadata, true, mainExtensionNode));
                    }
                }
            }
        } catch (XMPException | IOException e) {
            LOGGER.log(Level.WARNING, "Problems with parsing metadata. " + e.getMessage(), e);
            if (isMainMetadata) {
                xmp.add(new AXLMainXMPPackage(null, false));
            } else if (!PDFFlavours.isFlavourPart(flavour, PDFAFlavour.Specification.ISO_19005_1)) {
                xmp.add(new AXLXMPPackage(null, false, null));
            }
        }
        return xmp;
    }

    private List<CosStream> getStream() {
        COSStream stream = ((org.verapdf.pd.PDMetadata) this.simplePDObject).getCOSStream();
        if (stream != null) {
            List<CosStream> streams = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            streams.add(new GFCosStream(stream));
            return Collections.unmodifiableList(streams);
        }
        return Collections.emptyList();
    }
}
