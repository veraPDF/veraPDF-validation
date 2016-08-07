package org.verapdf.model.impl.pd;

import com.adobe.xmp.XMPException;
import com.adobe.xmp.impl.VeraPDFMeta;
import com.adobe.xmp.impl.VeraPDFXMPNode;
import org.apache.log4j.Logger;
import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSStream;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosStream;
import org.verapdf.model.impl.axl.AXLMainXMPPackage;
import org.verapdf.model.impl.axl.AXLXMPPackage;
import org.verapdf.model.impl.containers.StaticContainers;
import org.verapdf.model.impl.cos.GFCosStream;
import org.verapdf.model.pdlayer.PDMetadata;
import org.verapdf.model.xmplayer.XMPPackage;
import org.verapdf.pdfa.flavours.PDFAFlavour;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDMetadata extends GFPDObject implements PDMetadata {

    private static final Logger LOGGER = Logger.getLogger(GFPDMetadata.class);

    public static final String METADATA_TYPE = "PDMetadata";

    public static final String XMP_PACKAGE = "XMPPackage";
    public static final String STREAM = "stream";

    private boolean isMainMetadata;
    private org.verapdf.pd.PDMetadata mainMetadata;

    public GFPDMetadata(org.verapdf.pd.PDMetadata simplePDObject, Boolean isMainMetadata) {
        super(simplePDObject, METADATA_TYPE);
        this.isMainMetadata = isMainMetadata.booleanValue();
        try {
            if (StaticContainers.getDocument()!= null && StaticContainers.getDocument().getCatalog() != null && StaticContainers.getDocument().getCatalog().getMetadata() != null) {
                this.mainMetadata = StaticContainers.getDocument().getCatalog().getMetadata();
            } else {
                this.mainMetadata = null;
            }
        } catch (IOException e) {
            LOGGER.debug("Can not obtain main metadata");
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
        PDFAFlavour flavour = StaticContainers.getFlavour();
        try {
            InputStream stream = ((org.verapdf.pd.PDMetadata) this.simplePDObject).getStream();
            if (stream != null) {
                VeraPDFMeta metadata = VeraPDFMeta.parse(stream);
                if (isMainMetadata) {
                    xmp.add(new AXLMainXMPPackage(metadata, true, flavour));
                } else if (flavour == null || flavour.getPart() == null || flavour.getPart().getPartNumber() != 1) {
                    VeraPDFXMPNode mainExtensionNode = null;
                    InputStream mainStream = mainMetadata.getStream();
                    if (mainStream != null) {
                        VeraPDFMeta mainMeta = VeraPDFMeta.parse(mainStream);
                        mainExtensionNode = mainMeta.getExtensionSchemasNode();
                    }
                    xmp.add(new AXLXMPPackage(metadata, true, mainExtensionNode, flavour));
                }
            }
        } catch (XMPException e) {
            LOGGER.debug("Problems with parsing metadata. " + e.getMessage(), e);
            if (isMainMetadata) {
                xmp.add(new AXLMainXMPPackage(null, false, flavour));
            } else if (flavour == null || flavour.getPart() == null || flavour.getPart().getPartNumber() != 1) {
                xmp.add(new AXLXMPPackage(null, false, null, flavour));
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
