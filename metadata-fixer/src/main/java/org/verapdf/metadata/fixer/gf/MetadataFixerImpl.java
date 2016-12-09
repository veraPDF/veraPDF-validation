package org.verapdf.metadata.fixer.gf;

import org.verapdf.component.ComponentDetails;
import org.verapdf.component.Components;
import org.verapdf.metadata.fixer.entity.InfoDictionary;
import org.verapdf.metadata.fixer.entity.Metadata;
import org.verapdf.metadata.fixer.entity.PDFDocument;
import org.verapdf.metadata.fixer.gf.utils.DateConverter;
import org.verapdf.metadata.fixer.schemas.AdobePDF;
import org.verapdf.metadata.fixer.schemas.BasicSchema;
import org.verapdf.metadata.fixer.schemas.DublinCore;
import org.verapdf.metadata.fixer.schemas.XMPBasic;
import org.verapdf.metadata.fixer.utils.ProcessedObjectsInspector;
import org.verapdf.metadata.fixer.utils.ValidationStatus;
import org.verapdf.metadata.fixer.utils.parser.ProcessedObjectsParser;
import org.verapdf.pdfa.MetadataFixer;
import org.verapdf.pdfa.flavours.PDFAFlavour;
import org.verapdf.pdfa.results.MetadataFixerResult;
import org.verapdf.pdfa.results.MetadataFixerResultImpl;
import org.verapdf.pdfa.results.ValidationResult;
import org.verapdf.pdfa.validation.profiles.ProfileDirectory;
import org.verapdf.pdfa.validation.profiles.Profiles;
import org.verapdf.pdfa.validation.profiles.ValidationProfile;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.verapdf.metadata.fixer.utils.MetadataFixerConstants.*;

/**
 * @author Maksim Bezrukov
 */
abstract class MetadataFixerImpl implements MetadataFixer {
	private static final URI componentId = URI.create("http://pdfa.verapdf.org/metadata/fixer#default");
	private static final String componentName = "veraPDF GreenField Metadata Fixer";
	private static final ComponentDetails componentDetails = Components.libraryDetails(componentId, componentName);
	private static final ProfileDirectory PROFILES = Profiles.getVeraProfileDirectory();
	private static final Logger LOGGER = Logger.getLogger(MetadataFixerImpl.class.getCanonicalName());

	private static final Map<String, String> attributes = Collections.unmodifiableMap(mkAttsMap());

	protected MetadataFixerImpl() {
		// enabled only for nested classes
	}

	/**
	 * Fix metadata and info dictionary for
	 * {@link org.verapdf.metadata.fixer.entity.PDFDocument} and save fixed file
	 * a certain path. If fixer no changes apply then no save will be produced.
	 *
	 * @param output
	 *            stream to result file
	 * @return report of made corrections
	 */
	public static MetadataFixerResult fixMetadata(OutputStream output, PDFDocument document, ValidationResult result,
												  boolean fixIdentification, ProcessedObjectsParser parser) {
		return result != null && result.isCompliant() ? new MetadataFixerResultImpl.Builder().build()
				: fixAndSaveDocument(output, document, result, fixIdentification, parser);
	}

	@Override
	public ComponentDetails getDetails() {
		return componentDetails;
	}

	private static MetadataFixerResult fixAndSaveDocument(OutputStream output, PDFDocument document, ValidationResult result,
														  boolean fixIdentification, ProcessedObjectsParser parser) {
		try {
			Metadata metadata = document.getMetadata();
			if (metadata != null) {
				MetadataFixerResultImpl.Builder resultBuilder = new MetadataFixerResultImpl.Builder();
				ValidationStatus status = getValidationStatus(result, parser);

				switch (status) {
					case INVALID_METADATA:
						executeInvalidMetadataCase(document, metadata, resultBuilder, result.getPDFAFlavour(), fixIdentification);
						break;
					case INVALID_DOCUMENT:
					case INVALID_STRUCTURE: {
						resultBuilder.status(MetadataFixerResult.RepairStatus.WONT_FIX);
						if (fixIdentification) {
							metadata.removePDFIdentificationSchema(resultBuilder,
									result.getPDFAFlavour());
						}
						break;
					}
					default:
						break;
				}

				updateModificationDate(document, resultBuilder);

				MetadataFixerResult partialResult = document.saveDocumentIncremental(resultBuilder.getStatus(), output);
				resultBuilder.status(partialResult.getRepairStatus());
				for (String fix : partialResult.getAppliedFixes()) {
					resultBuilder.addFix(fix);
				}
				return resultBuilder.build();
			}

			return getErrorResult("Problems with metadata obtain. No possibility to fix metadata.");
		} catch (Throwable e) {
			LOGGER.log(Level.FINE, "Error while fixing metadata", e);
			return getErrorResult("Error while fixing metadata: " + e.getMessage());
		}
	}

	private static MetadataFixerResult getErrorResult(String message) {
		MetadataFixerResultImpl.Builder resultBuilder = new MetadataFixerResultImpl.Builder();
		resultBuilder.status(MetadataFixerResultImpl.RepairStatus.FIX_ERROR).addFix(message);
		return resultBuilder.build();
	}

	private static ValidationStatus getValidationStatus(ValidationResult result, ProcessedObjectsParser parser) {
		ValidationProfile profile = PROFILES.getValidationProfileByFlavour(result.getPDFAFlavour());
		if (profile != null) {
			try {
				return ProcessedObjectsInspector.validationStatus(result.getTestAssertions(), profile, parser);
			} catch (IOException | URISyntaxException | ParserConfigurationException | SAXException e) {
				LOGGER.log(Level.FINE, "Problem with validation status obtain. Validation status set as Invalid Document.", e);
				return ValidationStatus.INVALID_DOCUMENT;
			}
		}
		LOGGER.log(Level.FINE, "Problem with validation status obtain. Validation status set as Invalid Metadata.");
		return ValidationStatus.INVALID_METADATA;
	}

	private static void executeInvalidMetadataCase(PDFDocument document, Metadata metadata,
												   MetadataFixerResultImpl.Builder resultBuilder, PDFAFlavour flavour, boolean fixIdentification) {
		if (flavour.getPart() == PDFAFlavour.Specification.ISO_19005_1) {
			int removedFilters = document.removeFiltersForAllMetadataObjects();
			if (removedFilters > 0) {
				resultBuilder.addFix("Metadata streams unfiltered");
			} else if (removedFilters < 0) {
				throw new IllegalStateException("Problem while removing filters from metadata streams");
			}
		}
		fixMetadata(resultBuilder, document, flavour);
		if (fixIdentification) {
			metadata.addPDFIdentificationSchema(resultBuilder, flavour);
		}

		if (metadata.isNeedToBeUpdated()) {
			metadata.checkMetadataStream(resultBuilder, flavour);
		}
	}

	private static void fixMetadata(MetadataFixerResultImpl.Builder resultBuilder, PDFDocument document,
									PDFAFlavour flavour) {
		if (flavour.getPart() == PDFAFlavour.Specification.ISO_19005_1) {
			fixDublinCoreSchema(resultBuilder, document);
			fixAdobePDFSchema(resultBuilder, document);
			fixBasicXMLSchema(resultBuilder, document);
		}
	}

	private static void fixDublinCoreSchema(MetadataFixerResultImpl.Builder resultBuilder, PDFDocument document) {
		Metadata metadata = document.getMetadata();
		InfoDictionary info = document.getInfoDictionary();
		DublinCore schema = metadata.getDublinCoreSchema(info);
		if (schema != null && info != null) {
			fixProperty(resultBuilder, schema, info, schema.getTitle(), info.getTitle(), METADATA_TITLE);
			fixProperty(resultBuilder, schema, info, schema.getSubject(), info.getSubject(), METADATA_SUBJECT);
			fixProperty(resultBuilder, schema, info, schema.getAuthor(), info.getAuthor(), METADATA_AUTHOR);
		}
	}

	private static void fixAdobePDFSchema(MetadataFixerResultImpl.Builder resultBuilder, PDFDocument document) {
		Metadata metadata = document.getMetadata();
		InfoDictionary info = document.getInfoDictionary();
		AdobePDF schema = metadata.getAdobePDFSchema(info);
		if (schema != null && info != null) {
			fixProperty(resultBuilder, schema, info, schema.getProducer(), info.getProducer(), PRODUCER);
			fixProperty(resultBuilder, schema, info, schema.getKeywords(), info.getKeywords(), KEYWORDS);
		}
	}

	private static void fixBasicXMLSchema(MetadataFixerResultImpl.Builder resultBuilder, PDFDocument document) {
		Metadata metadata = document.getMetadata();
		InfoDictionary info = document.getInfoDictionary();
		XMPBasic schema = metadata.getXMPBasicSchema(info);
		if (schema != null && info != null) {
			fixProperty(resultBuilder, schema, info, schema.getCreator(), info.getCreator(), METADATA_CREATOR);
			fixCalendarProperty(resultBuilder, schema, info, schema.getCreationDate(), info.getCreationDate(),
					METADATA_CREATION_DATE);
			fixCalendarProperty(resultBuilder, schema, info, schema.getModificationDate(), info.getModificationDate(),
					METADATA_MODIFICATION_DATE);
		}
	}

	private static void fixProperty(MetadataFixerResultImpl.Builder resultBuilder, BasicSchema schema,
									InfoDictionary info, String metaValue, String infoValue, String attribute) {
		if (infoValue != null) {
			String key = attributes.get(attribute);
			if (metaValue == null) {
				doSaveAction(schema, attribute, infoValue);
				resultBuilder.addFix("Added '" + key + "' to metadata from info dictionary");
			} else if (!metaValue.equals(infoValue)) {
				doSaveAction(info, attribute, metaValue);
				resultBuilder.addFix("Added '" + attribute + "' to info dictionary from metadata");
			}
		}
	}

	private static void fixCalendarProperty(MetadataFixerResultImpl.Builder resultBuilder, BasicSchema schema,
											InfoDictionary info, String metaValue, String infoValue, String attribute) {
		if (infoValue != null) {
			String key = attributes.get(attribute);
			String utcInfoValue = DateConverter.toUTCString(infoValue);
			if (metaValue == null) {
				doSaveAction(schema, attribute, infoValue);
				resultBuilder.addFix("Added '" + key + "' to metadata from info dictionary");
			} else if (!metaValue.equals(utcInfoValue) || !infoValue.matches(PDF_DATE_FORMAT_REGEX)) {
				doSaveAction(info, attribute, metaValue);
				resultBuilder.addFix("Added '" + attribute + "' to info dictionary from metadata");
			}
		}
	}

	private static void doSaveAction(BasicSchema schema, String attribute, String value) {
		switch (attribute) {
			case METADATA_TITLE:
				((DublinCore) schema).setTitle(value);
				break;
			case METADATA_SUBJECT:
				((DublinCore) schema).setSubject(value);
				break;
			case METADATA_AUTHOR:
				((DublinCore) schema).setAuthor(value);
				break;
			case PRODUCER:
				((AdobePDF) schema).setProducer(value);
				break;
			case KEYWORDS:
				((AdobePDF) schema).setKeywords(value);
				break;
			case METADATA_CREATOR:
				((XMPBasic) schema).setCreator(value);
				break;
			case METADATA_CREATION_DATE:
				((XMPBasic) schema).setCreationDate(value);
				break;
			case METADATA_MODIFICATION_DATE:
				((XMPBasic) schema).setModificationDate(value);
				break;
			default:
				return;
		}
		schema.setNeedToBeUpdated(true);
	}

	private static void updateModificationDate(PDFDocument document, MetadataFixerResultImpl.Builder resultBuilder) {
		InfoDictionary info = document.getInfoDictionary();
		XMPBasic schema = document.getMetadata().getXMPBasicSchema(info);

		if (document.isNeedToBeUpdated() && schema != null) {
			Calendar time = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			if (schema.getModificationDate() != null) {
				doSaveAction(schema, METADATA_MODIFICATION_DATE, DateConverter.toPDFFormat(time));
				resultBuilder.addFix("Set new modification date to metadata");
			}
			if (info != null && info.getModificationDate() != null) {
				doSaveAction(info, METADATA_MODIFICATION_DATE, DateConverter.toUTCString(time));
				resultBuilder.addFix("Set new modification date to info dictionary");
			}
		}
	}

	private static final Map<String, String> mkAttsMap() {
		Map<String, String>  atts = new HashMap<>();
		atts.put(METADATA_TITLE, INFO_TITLE);
		atts.put(METADATA_SUBJECT, INFO_SUBJECT);
		atts.put(METADATA_AUTHOR, INFO_AUTHOR);
		atts.put(PRODUCER, PRODUCER);
		atts.put(KEYWORDS, KEYWORDS);
		atts.put(METADATA_CREATOR, INFO_CREATOR);
		atts.put(METADATA_CREATION_DATE, INFO_CREATION_DATE);
		atts.put(METADATA_MODIFICATION_DATE, INFO_MODIFICATION_DATE);
		return atts;
	}
}
