package org.verapdf.model.impl.containers;

import org.verapdf.pd.PDDocument;
import org.verapdf.pdfa.flavours.PDFAFlavour;

/**
 * @author Timur Kamalov
 */
public class StaticContainers {

	private static PDDocument document;
	private static PDFAFlavour flavour;

	public static void clearAllContainers() {
		if (document != null) {
			document.close();
			document = null;
		}
		flavour = null;
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
