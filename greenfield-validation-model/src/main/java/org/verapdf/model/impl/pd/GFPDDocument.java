package org.verapdf.model.impl.pd;

import org.apache.log4j.Logger;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDDocument;
import org.verapdf.model.pdlayer.PDPage;
import org.verapdf.pdfa.flavours.PDFAFlavour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Timur Kamalov
 */
public class GFPDDocument extends GFPDObject implements PDDocument {

	private static final Logger LOGGER = Logger.getLogger(GFPDDocument.class);

	public static final String PD_DOCUMENT_TYPE = "PDDocument";

	/** Link name for pages */
	public static final String PAGES = "pages";

	private final PDFAFlavour flavour;

	public GFPDDocument(org.verapdf.pd.PDDocument document, PDFAFlavour flavour) {
		super(document, PD_DOCUMENT_TYPE);
		this.flavour = flavour;
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case PAGES:
				return this.getPages();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<PDPage> getPages() {
		try {
			List<PDPage> result = new ArrayList<>();
			List<org.verapdf.pd.PDPage> rawPages = document.getPages();
			for (org.verapdf.pd.PDPage rawPage : rawPages) {
				result.add(new GFPDPage(rawPage, flavour));
			}
			return result;
		} catch (Exception e) {
			LOGGER.debug("Error while processing pages.");
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsAlternatePresentations() {
		return Boolean.FALSE;
	}

}
