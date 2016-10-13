package org.verapdf.gf.model.impl.external;

import org.apache.log4j.Logger;
import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSStream;
import org.verapdf.gf.model.GFModelParser;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.pd.colors.GFPDSeparation;
import org.verapdf.model.external.EmbeddedFile;
import org.verapdf.model.pdlayer.PDColorSpace;
import org.verapdf.pd.PDDocument;
import org.verapdf.pdfa.PDFAValidator;
import org.verapdf.pdfa.flavours.PDFAFlavour;
import org.verapdf.pdfa.results.ValidationResult;
import org.verapdf.pdfa.validators.Validators;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author Maksim Bezrukov
 */
public class GFEmbeddedFile extends GFExternal implements EmbeddedFile {

	private static final Logger LOGGER = Logger.getLogger(GFEmbeddedFile.class);

	/** Type name for {@code PBoxEmbeddedFile} */
	public static final String EMBEDDED_FILE_TYPE = "EmbeddedFile";

	private final COSStream stream;

	public GFEmbeddedFile(COSDictionary dictionary) {
		super(EMBEDDED_FILE_TYPE);
		COSObject baseStream = dictionary.getKey(ASAtom.F);
		if (baseStream != null && baseStream.getType() == COSObjType.COS_STREAM) {
			this.stream = (COSStream) baseStream.getDirectBase();
		} else {
			this.stream = null;
		}
	}

	@Override
	public String getSubtype() {
		if (this.stream != null) {
			ASAtom s = this.stream.getNameKey(ASAtom.SUBTYPE);
			return s == null ? null : s.getValue();
		}
		return null;
	}

	@Override
	public Boolean getisValidPDFA12() {
		if (this.stream != null) {
			try {
				saveStaticContainersState();
				InputStream unfilteredStream = stream.getData(COSStream.FilterFlags.DECODE);
				GFModelParser parser1b = GFModelParser.createModelWithFlavour(unfilteredStream, PDFAFlavour.PDFA_1_B);
				PDFAValidator validator1b = Validators.createValidator(PDFAFlavour.PDFA_1_B, false, 1);
				ValidationResult result1b = validator1b.validate(parser1b);
				parser1b.close();
				if (result1b.isCompliant()) {
					restoreSavedSCState();
					return Boolean.TRUE;
				}
				unfilteredStream.reset();
				GFModelParser parser2b = GFModelParser.createModelWithFlavour(unfilteredStream, PDFAFlavour.PDFA_2_B);
				PDFAValidator validator2b = Validators.createValidator(PDFAFlavour.PDFA_2_B, false, 1);
				ValidationResult result2b = validator2b.validate(parser2b);
				parser2b.close();
				restoreSavedSCState();
				return Boolean.valueOf(result2b.isCompliant());
			} catch (Throwable e) {
				LOGGER.debug("Exception during validation of embedded file", e);
				restoreSavedSCState();
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}

	// We need to save data from StaticContainers before validating embedded documents
	private PDDocument document;
	private PDFAFlavour flavour;
	public Map<String, List<GFPDSeparation>> separations;
	public List<String> inconsistentSeparations;
	public Map<String, PDColorSpace> cachedColorSpaces;

	private void saveStaticContainersState() {
		this.document = StaticContainers.getDocument();
		this.flavour = StaticContainers.getFlavour();
		this.separations = StaticContainers.separations;
		this.inconsistentSeparations = StaticContainers.inconsistentSeparations;
		this.cachedColorSpaces = StaticContainers.cachedColorSpaces;
	}

	private void restoreSavedSCState() {
		StaticContainers.setDocument(this.document);
		StaticContainers.setFlavour(this.flavour);
		StaticContainers.separations = this.separations;
		StaticContainers.inconsistentSeparations = this.inconsistentSeparations;
		StaticContainers.cachedColorSpaces = this.cachedColorSpaces;
	}

}
