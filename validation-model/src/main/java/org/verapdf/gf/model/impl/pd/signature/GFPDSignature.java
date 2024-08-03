/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2024, veraPDF Consortium <info@verapdf.org>
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
package org.verapdf.gf.model.impl.pd.signature;

import org.verapdf.cos.*;
import org.verapdf.gf.model.impl.external.GFPKCSDataObject;
import org.verapdf.gf.model.impl.pd.GFPDObject;
import org.verapdf.io.SeekableInputStream;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.external.PKCSDataObject;
import org.verapdf.model.pdlayer.PDSigRef;
import org.verapdf.model.pdlayer.PDSignature;
import org.verapdf.parser.SignatureParser;
import org.verapdf.tools.StaticResources;

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
     * Type name for {@code GFPDSignature}
     */
    public static final String SIGNATURE_TYPE = "PDSignature";

    public static final String CONTENTS = "Contents";
    public static final String REFERENCE = "Reference";

    protected final COSString contents;
    protected long signatureOffset = -1;

    public GFPDSignature(org.verapdf.pd.PDSignature pdSignature, COSObject signatureReference) {
        super(pdSignature, SIGNATURE_TYPE);
        if (signatureReference.isIndirect()) {
            COSKey key = signatureReference.getObjectKey();
            this.signatureOffset = StaticResources.getDocument().getDocument().getOffset(key);
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
    private List<PKCSDataObject> getContents() {
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
        if (reference == null || reference.size() == 0) {
            return Collections.emptyList();
        }
        List<PDSigRef> list = new ArrayList<>();
        for (COSObject sigRef : reference) {
            list.add(new GFPDSigRef((COSDictionary) sigRef.getDirectBase()));
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
            SeekableInputStream pdfSource = StaticResources.getDocument().getPDFSource();
            long offset = pdfSource.getOffset();
            SignatureParser parser = new SignatureParser(pdfSource,
                    StaticResources.getDocument().getDocument());
            long[] actualByteRange =
                    parser.getByteRangeBySignatureOffset(signatureOffset);
            int[] byteRange = ((org.verapdf.pd.PDSignature) this.simplePDObject).getByteRange();
            pdfSource.seek(offset);
            for (int i = 0; i < 3; ++i) {
                if (byteRange[i] != actualByteRange[i]) {
                    return Boolean.FALSE;
                }
            }
            int floating = parser.getFloatingBytesNumberForLastByteRangeObtained();
            if (parser.isStreamEnd()) {
                return byteRange[3] == actualByteRange[3];
            } else {
                return byteRange[3] >= actualByteRange[3] - floating && byteRange[3] <= actualByteRange[3];
            }
        } catch (IOException ex) {
            LOGGER.log(Level.FINE, "Can't create parser to process digital signature", ex);
            return Boolean.FALSE;
        }
    }
}
