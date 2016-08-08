package org.verapdf.model.impl.pd.util;

import org.verapdf.as.ASAtom;
import org.verapdf.pdfa.flavours.PDFAFlavour;

import java.util.*;

/**
 * @author Maksim Bezrukov
 */
public class TaggedPDFRoleMapHelper {

	private static Set<String> PDF_1_4_STANDART_ROLE_TYPES;
	private static Set<String> PDF_1_7_STANDART_ROLE_TYPES;

	static {
		Set<String> tempSet = new HashSet<>();
		// Standart structure types for grouping elements PDF 1.4 and PDF 1.7
		tempSet.add("Document");
		tempSet.add("Part");
		tempSet.add("Art");
		tempSet.add("Sect");
		tempSet.add("Div");
		tempSet.add("BlockQuote");
		tempSet.add("Caption");
		tempSet.add("TOC");
		tempSet.add("TOCI");
		tempSet.add("Index");
		tempSet.add("NonStruct");
		tempSet.add("Private");

		// Standart structure types for paragraphlike elements PDF 1.4 and PDF 1.7
		tempSet.add("H");
		tempSet.add("H1");
		tempSet.add("H2");
		tempSet.add("H3");
		tempSet.add("H4");
		tempSet.add("H5");
		tempSet.add("H6");
		tempSet.add("P");

		//Standart structure types for list elements PDF 1.4 and PDF 1.7
		tempSet.add("L");
		tempSet.add("LI");
		tempSet.add("LbI");
		tempSet.add("LBody");

		//Standart structure types for table elements PDF 1.4 and PDF 1.7
		tempSet.add("Table");
		tempSet.add("TR");
		tempSet.add("TH");
		tempSet.add("TD");

		// Standart structure types for inline-level structure elements PDF 1.4 and PDF 1.7
		tempSet.add("Span");
		tempSet.add("Quote");
		tempSet.add("Note");
		tempSet.add("Reference");
		tempSet.add("BibEntry");
		tempSet.add("Code");
		tempSet.add("Link");

		// Standart structure types for illustration elements PDF 1.4 and PDF 1.7
		tempSet.add("Figure");
		tempSet.add("Formula");
		tempSet.add("Form");

		PDF_1_4_STANDART_ROLE_TYPES = new HashSet<>(tempSet);

		//Standart structure types for table elements PDF 1.7
		tempSet.add("THead");
		tempSet.add("TBody");
		tempSet.add("TFoot");

		// Standart structure types for inline-level structure elements PDF 1.7
		tempSet.add("Annot");
		tempSet.add("Ruby");
		tempSet.add("Warichu");

		// Standart structure types for Ruby and Warichu elements PDF 1.7
		// Elements "Ruby" and "Warichu" are removed here, because they are already in set
		tempSet.add("RB");
		tempSet.add("RT");
		tempSet.add("RP");
		tempSet.add("WT");
		tempSet.add("WP");

		PDF_1_7_STANDART_ROLE_TYPES = new HashSet<>(tempSet);
	}

	private Map<ASAtom, ASAtom> roleMap;
	private Set<String> currentStandartTypes;

	/**
	 * Creates new TaggedPDFRoleMapHelper
	 * @param roleMap role map from PDF
	 * @param flavour current pdfa flavour
	 */
	public TaggedPDFRoleMapHelper(Map<ASAtom, ASAtom> roleMap, PDFAFlavour flavour) {
		this.roleMap = roleMap == null ? Collections.<ASAtom, ASAtom>emptyMap() : new HashMap<>(roleMap);
		setFlavour(flavour);
	}

	public void setFlavour(PDFAFlavour flavour) {
		this.currentStandartTypes = flavour.getPart() == PDFAFlavour.Specification.ISO_19005_1 ?
				Collections.unmodifiableSet(PDF_1_4_STANDART_ROLE_TYPES) :
				Collections.unmodifiableSet(PDF_1_7_STANDART_ROLE_TYPES);
	}

	/**
	 * Obtains standart type for the given one
	 * @param type the type for obtaining the standart
	 * @return standart type for the given one or null in cases when there is
	 * no standart for the given or there is a cycle of the custom types
	 */
	public String getStandartType(ASAtom type) {
		if (type == null) {
			return null;
		}
		Set<ASAtom> visitedTypes = new HashSet<>();
		ASAtom res = type;
		while (res != null && !visitedTypes.contains(res)) {
			if (currentStandartTypes.contains(res.getValue())) {
				return res.getValue();
			} else {
				visitedTypes.add(res);
				res = roleMap.get(res);
			}
		}
		return null;
	}
}
