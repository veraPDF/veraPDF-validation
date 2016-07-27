package org.verapdf.model.impl.cos;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosFileSpecification;
import org.verapdf.model.external.EmbeddedFile;

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
	private final String afrelationship;

    /**
     * Default constructor
     * @param dictionary greenfield COSDictionary
     */
    public GFCosFileSpecification(COSDictionary dictionary) {
        super(dictionary, COS_FILE_SPECIFICATION_TYPE);
		this.f = this.baseObject.getStringKey(ASAtom.F);
		this.uf = this.baseObject.getStringKey(ASAtom.UF);
		afrelationship = dictionary.getStringKey(new ASAtom("AFRelationship"));
    }

	@Override
	public String getF() {
		return this.f;
	}

	@Override
	public String getUF() {
		return this.uf;
	}

	@Override
	public String getAFRelationship() {
		return afrelationship.equals("") ? null : afrelationship;
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (EF.equals(link)) {
			return this.getEFFile();
		}
		return super.getLinkedObjects(link);
	}

	// TODO : implement me
	private List<EmbeddedFile> getEFFile() {
		return Collections.emptyList();
	}
}
