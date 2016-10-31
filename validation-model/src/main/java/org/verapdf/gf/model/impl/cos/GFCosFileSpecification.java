package org.verapdf.gf.model.impl.cos;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.external.GFEmbeddedFile;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosFileSpecification;
import org.verapdf.model.external.EmbeddedFile;

import java.util.ArrayList;
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
		this.afrelationship = dictionary.getStringKey(ASAtom.AF_RELATIONSHIP);
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
		return this.afrelationship;
	}

	@Override
	public Boolean getisAssociatedFile() {
		return this.baseObject != null
				&& StaticContainers.fileSpecificationKeys != null
				&& StaticContainers.fileSpecificationKeys.contains(this.baseObject.getKey());
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (EF.equals(link)) {
			return this.getEFFile();
		}
		return super.getLinkedObjects(link);
	}

	private List<EmbeddedFile> getEFFile() {
		COSObject efDictionary = this.baseObject.getKey(ASAtom.EF);
		if (efDictionary != null && efDictionary.getType().isDictionaryBased()) {
			ArrayList<EmbeddedFile> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(new GFEmbeddedFile((COSDictionary) efDictionary.getDirectBase()));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}
}
