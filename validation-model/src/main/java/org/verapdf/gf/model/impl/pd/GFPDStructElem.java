package org.verapdf.gf.model.impl.pd;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSName;
import org.verapdf.cos.COSString;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.cos.GFCosLang;
import org.verapdf.gf.model.impl.cos.GFCosUnicodeName;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosLang;
import org.verapdf.model.coslayer.CosUnicodeName;
import org.verapdf.model.pdlayer.PDStructElem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDStructElem extends GFPDObject implements PDStructElem {
	/**
	 * Type name for {@code GFPDStructElem}
	 */
	public static final String STRUCTURE_ELEMENT_TYPE = "PDStructElem";

	/**
	 * Link name for {@code K} key
	 */
	public static final String CHILDREN = "K";
	/**
	 * Link name for {@code S} key
	 */
	public static final String STRUCTURE_TYPE = "S";
	/**
	 * Link name for {@code Lang} key
	 */
	public static final String LANG = "Lang";

	/**
	 * Default constructor
	 *
	 * @param structElemDictionary dictionary of structure element
	 */
	public GFPDStructElem(org.verapdf.pd.PDStructElem structElemDictionary) {
		super(structElemDictionary, STRUCTURE_ELEMENT_TYPE);
	}

	/**
	 * @return Type entry of current structure element
	 */
	@Override
	public String getType() {
		ASAtom type = ((org.verapdf.pd.PDStructElem) simplePDObject).getType();
		return type == null ? null : type.getValue();
	}

	@Override
	public String getstandardType() {
		ASAtom type = ((org.verapdf.pd.PDStructElem) simplePDObject).getStructureType();
		if (type != null) {
			return StaticContainers.getRoleMapHelper().getStandartType(type);
		}
		return null;
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case CHILDREN:
				return this.getChildren();
			case STRUCTURE_TYPE:
				return this.getStructureType();
			case LANG:
				return this.getLang();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<PDStructElem> getChildren() {
		List<org.verapdf.pd.PDStructElem> elements = ((org.verapdf.pd.PDStructElem) simplePDObject).getChildren();
		if (!elements.isEmpty()) {
			List<PDStructElem> res = new ArrayList<>(elements.size());
			for (org.verapdf.pd.PDStructElem element : elements) {
				res.add(new GFPDStructElem(element));
			}
			return Collections.unmodifiableList(res);
		}
		return Collections.emptyList();
	}

	private List<CosUnicodeName> getStructureType() {
		COSName type = ((org.verapdf.pd.PDStructElem) this.simplePDObject).getCOSStructureType();
		if (type != null) {
			List<CosUnicodeName> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(new GFCosUnicodeName(type));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<CosLang> getLang() {
		COSString baseLang = ((org.verapdf.pd.PDStructElem) this.simplePDObject).getLang();
		if (baseLang != null) {
			List<CosLang> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(new GFCosLang(baseLang));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}
}
