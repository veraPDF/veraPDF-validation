package org.verapdf.model.impl.pd.signature;

import org.apache.log4j.Logger;
import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSObject;
import org.verapdf.model.impl.containers.StaticContainers;
import org.verapdf.model.impl.pd.GFPDObject;
import org.verapdf.model.pdlayer.PDSigRef;
import org.verapdf.pd.PDCatalog;

import java.io.IOException;

/**
 * Represents signature references dictionary referred by /Reference key from
 * the signature dictionary.
 *
 * @author Sergey Shemyakov
 */
public class GFPDSigRef extends GFPDObject implements PDSigRef {

    private static final Logger LOGGER = Logger.getLogger(GFPDSigRef.class);

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
        try {
            PDCatalog catalog = StaticContainers.getDocument().getCatalog();
            COSDictionary perms =
                    (COSDictionary) catalog.getKey(ASAtom.PERMS).getDirectBase();
            if(perms != null) {
                return perms.knownKey(GFPDPerms.DOC_MDP);
            }
        } catch (IOException e) {
            LOGGER.warn("Can't get catalog from PDDocument");
        }
        return Boolean.valueOf(false);
    }
}
