package org.verapdf.model.impl.containers;

import org.verapdf.model.impl.pd.colors.GFPDSeparation;
import org.verapdf.model.pdlayer.PDColorSpace;
import org.verapdf.pd.PDDocument;
import org.verapdf.pdfa.flavours.PDFAFlavour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Timur Kamalov
 */
public class StaticContainers {

	private static PDDocument document;
	private static PDFAFlavour flavour;

	//PBoxPDSeparation
	public static Map<String, List<GFPDSeparation>> separations = new HashMap<>();
	public static List<String> inconsistentSeparations = new ArrayList<>();

	//ColorSpaceFactory
	//TODO : change key from object reference to something else
	public final static Map<org.verapdf.pd.colors.PDColorSpace, PDColorSpace> cachedColorSpaces = new HashMap<>();

	public static void clearAllContainers() {
		if (document != null) {
			document.close();
			document = null;
		}
		flavour = null;
		separations.clear();
		inconsistentSeparations.clear();
		cachedColorSpaces.clear();
	}

	public static PDDocument getDocument() {
		return document;
	}

	public static void setDocument(PDDocument document) {
		StaticContainers.document = document;
	}

	public static PDFAFlavour getFlavour() {
		return flavour;
	}

	public static void setFlavour(PDFAFlavour flavour) {
		StaticContainers.flavour = flavour;
	}

}
