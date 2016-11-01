package org.verapdf.gf.model.impl.pd.signature;

import org.verapdf.cos.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.external.GFPKCSDataObject;
import org.verapdf.gf.model.impl.pd.GFPDObject;
import org.verapdf.io.SeekableStream;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.external.PKCSDataObject;
import org.verapdf.model.pdlayer.PDSigRef;
import org.verapdf.model.pdlayer.PDSignature;
import org.verapdf.parser.SignatureParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Sergey Shemyakov
 */
public class GFPDSignature extends GFPDObject implements PDSignature {

    private static final Logger LOGGER = Logger.getLogger(GFPDSignature.class.getCanonicalName());

    /**
     * Type name for {@code PBoxPDSignature}
     */
    public static final String SIGNATURE_TYPE = "PDSignature";

    public static final String CONTENTS = "Contents";
    public static final String REFERENCE = "Reference";

    protected static COSString contents;
    protected long signatureOffset = -1;

    public GFPDSignature(org.verapdf.pd.PDSignature pdSignature, COSObject signatureReference) {
        super(pdSignature, SIGNATURE_TYPE);
        if(signatureReference.isIndirect().booleanValue()) {
            COSKey key = signatureReference.getObjectKey();
            this.signatureOffset = StaticContainers.getDocument().getDocument().getOffset(key).longValue();
        }
        contents = pdSignature.getContents();
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case CONTENTS:
                return getContents();
            case REFERENCE:
                return getSigRefs();
            default:
                return super.getLinkedObjects(link);
        }
    }

    /**
     * @return DER-encoded PKCS#7 data object representing PDF Signature.
     */
    private static List<PKCSDataObject> getContents() {
        if (contents != null) {
            List<PKCSDataObject> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            list.add(new GFPKCSDataObject(contents));
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

    /**
     * @return signature reference dictionaries.
     */
    private List<PDSigRef> getSigRefs() {
        COSArray reference = ((org.verapdf.pd.PDSignature)
                this.simplePDObject).getReference();
        if (reference == null || reference.size().intValue() == 0) {
            return Collections.emptyList();
        }
        List<PDSigRef> list = new ArrayList<>();
        for (COSObject sigRef : reference) {
            list.add(new GFPDSigRef((COSDictionary) sigRef.get()));
        }
        return Collections.unmodifiableList(list);
    }


    /**
     * @return true if byte range covers entire document except for Contents
     * entry in signature dictionary
     */
    @Override
    public Boolean getdoesByteRangeCoverEntireDocument() {
        try {
            SeekableStream pdfSource = StaticContainers.getDocument().getPDFSource();
            long offest = pdfSource.getOffset();
            SignatureParser parser = new SignatureParser(pdfSource,
                    StaticContainers.getDocument().getDocument());
            long[] actualByteRange =
                    parser.getByteRangeBySignatureOffset(signatureOffset);
            int[] byteRange = ((org.verapdf.pd.PDSignature) this.simplePDObject).getByteRange();
            pdfSource.seek(offest);
            for (int i = 0; i < 4; ++i) {
                if (byteRange[i] != actualByteRange[i]) {
                    return Boolean.FALSE;
                }
            }
            return Boolean.TRUE;
        } catch (IOException ex) {
            LOGGER.log(Level.FINE, "Can't create parser to process digital signature", ex);
            return Boolean.FALSE;
        }
    }
}
