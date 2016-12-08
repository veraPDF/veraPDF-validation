package org.verapdf.metadata.fixer.gf.impl.model;

import com.adobe.xmp.XMPException;
import com.adobe.xmp.impl.VeraPDFMeta;
import org.verapdf.as.ASAtom;
import org.verapdf.cos.*;
import org.verapdf.metadata.fixer.entity.InfoDictionary;
import org.verapdf.metadata.fixer.entity.Metadata;
import org.verapdf.metadata.fixer.entity.PDFDocument;
import org.verapdf.pd.PDCatalog;
import org.verapdf.pd.PDDocument;
import org.verapdf.pd.PDMetadata;
import org.verapdf.pdfa.results.MetadataFixerResult;
import org.verapdf.pdfa.results.MetadataFixerResultImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.verapdf.pdfa.results.MetadataFixerResult.RepairStatus.*;

/**
 * @author Maksim Bezrukov
 */
public class PDFDocumentImpl implements PDFDocument {

	private static final Logger LOGGER = Logger.getLogger(PDFDocumentImpl.class.getCanonicalName());

	private final PDDocument document;
	private MetadataImpl metadata;
	private InfoDictionaryImpl info;
	private boolean isUnfiltered = false;

	/**
	 * Create a new PDFDocumentImpl from the passed InputStream
	 *
	 * @param pdfStream an {@link InputStream} to be parsed as a PDF Document.
	 * @throws IOException when there's a problem reading or parsing the file.
	 */
	public PDFDocumentImpl(InputStream pdfStream) throws IOException {
		this(new PDDocument(pdfStream));
	}

	/**
	 * @param document
	 */
	public PDFDocumentImpl(PDDocument document) throws IOException {
		if (document == null) {
			throw new IllegalArgumentException("Document representation can not be null");
		}
		this.document = document;
		this.metadata = parseMetadata();
		this.info = this.getInfo();
	}

	private MetadataImpl parseMetadata() throws IOException {
		PDCatalog catalog = this.document.getCatalog();
		PDMetadata meta = catalog.getMetadata();
		if (meta == null) {
			COSObject stream = COSStream.construct();
			catalog.setKey(ASAtom.METADATA, stream);
			catalog.getObject().setNeedToBeUpdated(true);
			VeraPDFMeta xmp = VeraPDFMeta.create();
			return new MetadataImpl(xmp, (COSStream) stream.getDirectBase());
		}
		return parseMetadata(meta);
	}

	private static MetadataImpl parseMetadata(PDMetadata meta) {
		try {
			VeraPDFMeta xmp = VeraPDFMeta.parse(meta.getStream());
			if (xmp != null) {
				return new MetadataImpl(xmp, meta.getCOSStream());
			}
		} catch (XMPException e) {
			LOGGER.log(Level.FINE, "Problems with XMP parsing. " + e.getMessage(), e);
		}
		return null;
	}

	private InfoDictionaryImpl getInfo() {
		COSTrailer trailer = this.document.getDocument().getTrailer();
		COSObject infoDict = trailer.getInfo();
		return (infoDict != null && infoDict.getType() == COSObjType.COS_DICT) ?
				new InfoDictionaryImpl(infoDict) : null;
	}

	/**
	 * {@inheritDoc} Implemented by GreenField library.
	 */
	@Override
	public Metadata getMetadata() {
		return this.metadata;
	}

	/**
	 * {@inheritDoc} Implemented by GreenField library.
	 */
	@Override
	public InfoDictionary getInfoDictionary() {
		return this.info;
	}

	/**
	 * {@inheritDoc} Implemented by GreenField library.
	 */
	@Override
	public boolean isNeedToBeUpdated() {
		boolean metaUpd = this.metadata != null && this.metadata.isNeedToBeUpdated();
		boolean infoUpd = this.info != null && this.info.isNeedToBeUpdated();
		return metaUpd || infoUpd || this.isUnfiltered;
	}

	/**
	 * {@inheritDoc} Implemented by GreenField library.
	 */
	@Override
	public MetadataFixerResult saveDocumentIncremental(final MetadataFixerResultImpl.RepairStatus status,
													   OutputStream output) {
		MetadataFixerResultImpl.Builder builder = new MetadataFixerResultImpl.Builder();
		try {
			PDMetadata meta = this.document.getCatalog().getMetadata();
			boolean isMetaPresent = meta != null && this.isNeedToBeUpdated();
			boolean isMetaAdd = meta == null && this.metadata != null;
			if (isMetaPresent || isMetaAdd) {
				this.metadata.updateMetadataStream();
				if (isMetaAdd) {
					this.document.getCatalog().getObject().setNeedToBeUpdated(true);
				}
				this.document.saveTo(output);
				output.close();
				builder.status(getStatus(status));
			} else {
				builder.status(status);
			}
		} catch (Exception e) {
			LOGGER.log(Level.INFO, e.getMessage(), e);
			builder.status(FIX_ERROR).addFix("Problems with document save. " + e.getMessage());
		}
		return builder.build();
	}

	@Override
	public int removeFiltersForAllMetadataObjects() {
		int res = 0;
		List<COSObject> objects = this.document.getDocument().getObjectsByType(ASAtom.METADATA);

		List<COSStream> metas = new ArrayList<>();
		for (COSObject obj : objects) {
			if (obj.getType() == COSObjType.COS_STREAM) {
				metas.add((COSStream) obj.get());
			} else {
				LOGGER.log(Level.FINE, "Founded non-stream Metadata dictionary.");
			}
		}
		for (COSStream stream : metas) {
			if (stream.getFilters().size() > 0) {
				try {
					stream.setFilters(new COSFilters());
					res++;
				} catch (IOException e) {
					LOGGER.log(Level.FINE, "Error when removing filter from stream", e);
					return -1;
				}
			}
		}
		isUnfiltered = res > 0;

		return res;
	}

	private static MetadataFixerResultImpl.RepairStatus getStatus(final MetadataFixerResultImpl.RepairStatus status) {
		return status == NO_ACTION ? SUCCESS : status;
	}
}
