package org.verapdf.model.impl.cos;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSIndirect;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosIndirect;
import org.verapdf.model.coslayer.CosTrailer;
import org.verapdf.pd.PDDocument;
import org.verapdf.pdfa.flavours.PDFAFlavour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFCosTrailer extends GFCosDict implements CosTrailer {

	/** Type name for GFCosTrailer */
	public static final String COS_TRAILER_TYPE = "CosTrailer";

	public static final String CATALOG = "Catalog";

	private final boolean isEncrypted;

	/**
	 * Default constructor
	 * @param dictionary greenfield COSDictionary
	 */
	public GFCosTrailer(COSDictionary dictionary, PDDocument document, PDFAFlavour flavour) {
		super(dictionary, COS_TRAILER_TYPE, document, flavour);
		this.isEncrypted = dictionary.getKey(ASAtom.ENCRYPT).get() != null;
	}

	/**
	 * @return true if the current document is encrypted
	 */
	@Override
	public Boolean getisEncrypted() {
		return Boolean.valueOf(this.isEncrypted);
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (CATALOG.equals(link)) {
			return this.getCatalog();
		}
		return super.getLinkedObjects(link);
	}

	private List<CosIndirect> getCatalog() {
		List<CosIndirect> catalog = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
		COSBase base = this.baseObject.getKey(ASAtom.ROOT).get();
		//TODO : check that always indirect
		catalog.add(new GFCosIndirect((COSIndirect) base, this.document, this.flavour));
		return Collections.unmodifiableList(catalog);
	}

}
