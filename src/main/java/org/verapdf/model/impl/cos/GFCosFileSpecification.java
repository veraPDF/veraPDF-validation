package org.verapdf.model.impl.cos;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosFileSpecification;
import org.verapdf.model.external.EmbeddedFile;
import org.verapdf.pd.PDDocument;
import org.verapdf.pdfa.flavours.PDFAFlavour;

import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFCosFileSpecification extends GFCosDict implements CosFileSpecification {

    /** Type name for GFCosFileSpecification */
    public static final String COS_FILE_SPECIFICATION_TYPE = "CosFileSpecification";

	public static final String EF = "EF";

	private final String f;
	private final String uf;

    /**
     * Default constructor
     * @param dictionary greenfield COSDictionary
     */
    public GFCosFileSpecification(COSDictionary dictionary, PDDocument document, PDFAFlavour flavour) {
        super(dictionary, COS_FILE_SPECIFICATION_TYPE, document, flavour);
		this.f = this.baseObject.getStringKey(ASAtom.F);
		this.uf = this.baseObject.getStringKey(ASAtom.UF);
    }

	@Override
	public String getF() {
		return this.f;
	}

	@Override
	public String getUF() {
		return this.uf;
	}

	// TODO : implement me
	@Override
	public String getAFRelationship() {
		return null;
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (EF.equals(link)) {
			return this.getEFFile();
		}
		return super.getLinkedObjects(link);
	}

	private List<EmbeddedFile> getEFFile() {
		return Collections.emptyList();
	}

}
