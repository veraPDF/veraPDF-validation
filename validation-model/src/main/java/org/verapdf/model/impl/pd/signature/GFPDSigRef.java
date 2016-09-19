package org.verapdf.model.impl.pd.signature;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSObject;
import org.verapdf.model.impl.pd.GFPDObject;
import org.verapdf.model.pdlayer.PDSigRef;

/**
 * Represents signature references dictionary referred by /Reference key from
 * the signature dictionary.
 *
 * @author Sergey Shemyakov
 */
public class GFPDSigRef extends GFPDObject implements PDSigRef {

    /** Type name for {@code GFPDSigRef} */
    public static final String SIGNATURE_REFERENCE_TYPE = "PDSigRef";

    /**
     * @param dictionary is signature reference dictionary.
     */
    public GFPDSigRef(COSDictionary dictionary) {
        super(new COSObject(dictionary), SIGNATURE_REFERENCE_TYPE);
    }

    /**
     * @return true if any of the entries /DigestLocation, /DigestMethod, or
     * /DigestValue is present.
     */
    @Override
    public Boolean getcontainsDigestEntries() {
        COSDictionary dictionary = (COSDictionary) this.simpleCOSObject.get();
        if(dictionary != null) {
            return dictionary.knownKey(ASAtom.DIGEST_LOCATION) ||
                    dictionary.knownKey(ASAtom.DIGEST_METHOD) ||
                    dictionary.knownKey(ASAtom.DIGEST_VALUE);
        } else {
            return Boolean.valueOf(false);
        }
    }

    /**
     * @return true if the document permissions dictionary contains DocMDP entry.
     */
    @Override
    public Boolean getpermsContainDocMDP() {
        return null;
    }
}
