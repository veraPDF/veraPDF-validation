/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.cos;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.pd.GFPDDocument;
import org.verapdf.gf.model.impl.sa.GFSAPDFDocument;
import org.verapdf.gf.model.tools.FileSpecificationKeysHelper;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.*;
import org.verapdf.pd.PDNameTreeNode;
import org.verapdf.pdfa.flavours.PDFAFlavour;
import org.verapdf.pdfa.flavours.PDFFlavours;
import org.verapdf.tools.StaticResources;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Timur Kamalov
 */
public class GFCosDocument extends GFCosObject implements CosDocument {

	private static final Logger LOGGER = Logger.getLogger(GFCosDocument.class.getCanonicalName());

	/** Type name for GFCosDocument */
	public static final String COS_DOCUMENT_TYPE = "CosDocument";

	private static final String TRAILER = "trailer";
	private static final String XREF = "xref";
	private static final String INDIRECT_OBJECTS = "indirectObjects";
	private static final String DOCUMENT = "document";
	private static final String DOC = "doc";
	private static final String EMBEDDED_FILES = "EmbeddedFiles";

	private static final String GFSAPDFDOCUMENT_CLASS_NAME = "org.verapdf.gf.model.impl.sa.GFSAPDFDocument";

	private final COSDictionary catalog;

	private final long indirectObjectCount;
	private final float headerVersion;
	private final long headerOffset;
	private final String header;
	private final int headerCommentByte1;
	private final int headerCommentByte2;
	private final int headerCommentByte3;
	private final int headerCommentByte4;
	private final boolean isOptionalContentPresent;
	private final int postEOFDataSize;
	private final boolean isLinearised;
	private final String firstPageID;
	private final String lastID;

	/**
	 * Constructor using greenfield COSDocument
	 * 
	 * @param cosDocument
	 *            greenfield COSDocument
	 */
	public GFCosDocument(COSDocument cosDocument) {
		super(cosDocument, COS_DOCUMENT_TYPE);
		this.catalog = this.getCatalog();

		COSHeader cosHeader = cosDocument.getHeader();
		this.indirectObjectCount = cosDocument.getObjects().size();
		this.headerVersion = cosHeader.getVersion();
		this.headerOffset = cosHeader.getHeaderOffset();
		this.header = cosHeader.getHeader();
		this.headerCommentByte1 = cosHeader.getHeaderCommentByte1();
		this.headerCommentByte2 = cosHeader.getHeaderCommentByte2();
		this.headerCommentByte3 = cosHeader.getHeaderCommentByte3();
		this.headerCommentByte4 = cosHeader.getHeaderCommentByte4();
		this.isOptionalContentPresent = parseOptionalContentPresent();
		this.postEOFDataSize = cosDocument.getPostEOFDataSize();
		this.isLinearised = cosDocument.getTrailer() != cosDocument.getLastTrailer() && cosDocument.isLinearized();
		this.lastID = getTrailerID(cosDocument.getLastTrailer().getKey(ASAtom.ID));
		this.firstPageID = getTrailerID(cosDocument.getFirstTrailer().getKey(ASAtom.ID));
		if (PDFFlavours.isFlavourPart(StaticContainers.getFlavour(), PDFAFlavour.Specification.ISO_19005_3)) {
			FileSpecificationKeysHelper.registerFileSpecificationKeys(cosDocument);
		}
	}

	private boolean parseOptionalContentPresent() {
		return this.catalog != null && !(this.catalog.getKey(ASAtom.OCPROPERTIES).empty());
	}

	/**
	 * Number of indirect objects in the document
	 */
	@Override
	public Long getnrIndirects() {
		return this.indirectObjectCount;
	}

	/**
	 * @return version of pdf document
	 */
	@Override
	public Double getheaderVersion() {
		return (double) this.headerVersion;
	}

	@Override
	public Long getheaderOffset() {
		return this.headerOffset;
	}

	@Override
	public String getheader() {
		return this.header;
	}

	@Override
	public Long getheaderByte1() {
		return (long) this.headerCommentByte1;
	}

	@Override
	public Long getheaderByte2() {
		return (long) this.headerCommentByte2;
	}

	@Override
	public Long getheaderByte3() {
		return (long) this.headerCommentByte3;
	}

	@Override
	public Long getheaderByte4() {
		return (long) this.headerCommentByte4;
	}

	/**
	 * true if catalog contain OCProperties key
	 */
	@Override
	public Boolean getisOptionalContentPresent() {
		return isOptionalContentPresent;
	}

	/**
	 * EOF must complies PDF/A standard
	 */
	@Override
	public Long getpostEOFDataSize() {
		return (long) this.postEOFDataSize;
	}

	/**
	 * @return ID of first page trailer
	 */
	@Override
	public String getfirstPageID() {
		return this.firstPageID;
	}

	/**
	 * @return ID of last document trailer
	 */
	@Override
	public String getlastID() {
		if (PDFFlavours.isFlavourPart(StaticContainers.getFlavour(), PDFAFlavour.Specification.ISO_19005_1)) {
			return this.lastID;
		} else if (this.isLinearised) {
			return this.firstPageID;
		} else {
			return this.lastID;
		}
	}

	@Override
	public String getfirstPageIDValue() {
		COSObject id = cosDocument.getFirstTrailer().getKey(ASAtom.ID);
		return id != null ? id.toString() : null;
	}

	@Override
	public String getlastIDValue() {
		COSObject id = cosDocument.getLastTrailer().getKey(ASAtom.ID);
		return id != null ? id.toString() : null;
	}

	private static String getTrailerID(COSObject ids) {
		if (ids != null && ids.getType() == COSObjType.COS_ARRAY) {
			COSArray idArray = (COSArray) ids.getDirectBase();
			if (idArray.size() != 2) {
				LOGGER.log(Level.WARNING, "Value of ID is not an array of two byte strings");
			}
			StringBuilder builder = new StringBuilder();
			for (COSObject id : idArray) {
				if (id.getType() == COSObjType.COS_STRING) {
					for (byte aByte : ((COSString) id.getDirectBase()).get()) {
						builder.append((char) (aByte & 0xFF));
					}
				} else {
					LOGGER.log(Level.SEVERE, "Value of ID key is not a string. Ignoring ID");
				}
			}
			// need to discard last whitespace
			return builder.toString();
		}
		return null;
	}

	/**
	 * @return true if the current document is linearized
	 */
	@Override
	public Boolean getisLinearized() {
		return this.isLinearised;
	}

	@Override
	public Boolean getMarked() {
		if (this.catalog != null) {
			COSObject markInfoObject = this.catalog.getKey(ASAtom.MARK_INFO);
			if (markInfoObject == null || markInfoObject.empty()) {
				return null;
			}
			COSBase markInfo = markInfoObject.getDirectBase();
			if (markInfo.getType() == COSObjType.COS_DICT) {
				return markInfo.getBooleanKey(ASAtom.MARKED);
			}
			LOGGER.log(Level.WARNING,
					"MarkedInfo must be a 'COSDictionary' but got: " + markInfoObject.getType());
			return null;
		}
		return null;
	}

	@Override
	public Boolean getDisplayDocTitle() {
		if (this.catalog != null) {
			COSObject viewerPrefObject = this.catalog.getKey(ASAtom.VIEWER_PREFERENCES);
			if (viewerPrefObject == null || viewerPrefObject.empty()) {
				return null;
			}
			COSBase viewerPref = viewerPrefObject.getDirectBase();
			if (viewerPref.getType() == COSObjType.COS_DICT) {
				return viewerPref.getBooleanKey(ASAtom.DISPLAY_DOC_TITLE);
			}
			LOGGER.log(Level.WARNING,
					"viewerPref must be a 'COSDictionary' but got: " + viewerPrefObject.getType());
			return null;
		}
		return null;
	}

	@Override
	public Boolean getcontainsPieceInfo() {
		return this.catalog != null && this.catalog.knownKey(ASAtom.PIECE_INFO);
	}

	@Override
	public String getMarkInfo() {
		if (this.catalog != null) {
			COSObject markInfoObject = this.catalog.getKey(ASAtom.MARK_INFO);
			return markInfoObject != null ? markInfoObject.toString() : null;
		}
		return null;
	}

	@Override
	public String getViewerPreferences() {
		if (this.catalog != null) {
			COSObject viewerPrefObject = this.catalog.getKey(ASAtom.VIEWER_PREFERENCES);
			return viewerPrefObject != null ? viewerPrefObject.toString() : null;
		}
		return null;
	}

	@Override
	public Boolean getcontainsInfo() {
		COSObject info = cosDocument.getTrailer().getInfo();
		return info != null && !info.empty();
	}

	@Override
	public Boolean getSuspects() {
		if (this.catalog != null) {
			COSObject markInfoObject = this.catalog.getKey(ASAtom.MARK_INFO);
			if (markInfoObject == null || markInfoObject.empty()) {
				return null;
			}
			COSBase markInfo = markInfoObject.getDirectBase();
			if (markInfo.getType() == COSObjType.COS_DICT) {
				return markInfo.getBooleanKey(ASAtom.SUSPECTS);
			}
			LOGGER.log(Level.WARNING,
					"MarkedInfo must be a 'COSDictionary' but got: " + markInfoObject.getType());
			return null;
		}
		return null;
	}

	@Override
	public String getRequirements() {
		if (this.catalog != null) {
			COSObject reqArrayObject = this.catalog.getKey(ASAtom.REQUIREMENTS);
			if (reqArrayObject != null && !reqArrayObject.empty()) {
				COSBase reqArray = reqArrayObject.getDirectBase();
				if (reqArray.getType() == COSObjType.COS_ARRAY) {
					return GFCosDocument.getRequirementsString((COSArray) reqArray);
				} else if (reqArray.getType() == COSObjType.COS_DICT) {
					return GFCosDocument.getRequirementsString((COSDictionary) reqArray);
				}
			}
		}
		return null;
	}

	private static String getRequirementsString(COSArray reqArray) {
		StringBuilder result = new StringBuilder();
		for (COSObject element : reqArray) {
			COSBase base = element.getDirectBase();
			if (base.getType() == COSObjType.COS_DICT) {
				result.append(getRequirementsString((COSDictionary) base));
				result.append(' ');
			}
		}
		return result.toString();
	}

	private static String getRequirementsString(COSDictionary reqDict) {
		return reqDict.getNameKeyStringValue(ASAtom.S);
	}

	/**
	 * @return true if {@code NeedsRendering} entry in catalog contains
	 *         {@code true} value.
	 */
	@Override
	public Boolean getNeedsRendering() {
		if (!catalog.knownKey(ASAtom.NEEDS_RENDERING)) {
			return Boolean.FALSE;
		}
		return catalog.getBooleanKey(ASAtom.NEEDS_RENDERING);
	}

	@Override
	public Boolean getcontainsEmbeddedFiles() {
		if (catalog != null) {
			COSObject names = this.catalog.getKey(ASAtom.NAMES);
			if (names.getType() == COSObjType.COS_DICT) {
				return names.knownKey(ASAtom.EMBEDDED_FILES);
			 }
		}
		return Boolean.FALSE;
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
		case TRAILER:
			return this.getTrailer();
		case INDIRECT_OBJECTS:
			return this.getIndirectObjects();
		case DOCUMENT:
			return GFCosDocument.getDocument();
		case XREF:
			return this.getXRefs();
		case EMBEDDED_FILES:
			return this.getEmbeddedFiles();
		case DOC:
			return this.getdocument();
		default:
			return super.getLinkedObjects(link);
		}
	}

	/**
	 * @return list of embedded files
	 */
	private List<CosFileSpecification> getEmbeddedFiles() {
		if (this.catalog != null) {
			COSObject buffer = this.catalog.getKey(ASAtom.NAMES);
			if (!buffer.empty()) {
				COSObject base = buffer.getKey(ASAtom.EMBEDDED_FILES);
				if (base != null && base.getType() == COSObjType.COS_DICT) {
					List<CosFileSpecification> files = new ArrayList<>();
					this.getNamesEmbeddedFiles(files, PDNameTreeNode.create(base));
					return Collections.unmodifiableList(files);
				}
			}
		}
		return Collections.emptyList();
	}

	private void getNamesEmbeddedFiles(List<CosFileSpecification> files, PDNameTreeNode node) {
		Map<String, COSObject> names = node.getNames();
		for (COSObject value : names.values()) {
			if (value != null && value.getType().isDictionaryBased()) {
				files.add(new GFCosFileSpecification((COSDictionary) value.getDirectBase(), true));
			}
		}
		for (PDNameTreeNode kid : node.getKids()) {
			getNamesEmbeddedFiles(files, kid);
		}
	}

	/**
	 * trailer dictionary
	 */
	private List<CosTrailer> getTrailer() {
		List<CosTrailer> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
		list.add(new GFCosTrailer((COSDictionary) cosDocument.getTrailer().getObject().getDirectBase()));
		return Collections.unmodifiableList(list);
	}

	/**
	 * all indirect objects referred from the xref table
	 */
	private List<CosIndirect> getIndirectObjects() {
		Map<COSKey, COSObject> objects = cosDocument.getObjectsMap();
		List<CosIndirect> list = new ArrayList<>(objects.size());
		for (Map.Entry<COSKey, COSObject> entry : objects.entrySet()) {
			list.add(new GFCosIndirect(entry.getKey(), entry.getValue()));
		}
		return Collections.unmodifiableList(list);
	}

	/**
	 * link to the high-level PDF Document structure
	 */
	private static List<org.verapdf.model.pdlayer.PDDocument> getDocument() {
		if (StaticResources.getDocument() != null) {
			List<org.verapdf.model.pdlayer.PDDocument> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(new GFPDDocument(StaticResources.getDocument()));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<org.verapdf.model.salayer.SAPDFDocument> getdocument() {
		if (PDFFlavours.isWCAGFlavour(StaticContainers.getFlavour()) &&
				StaticResources.getDocument() != null && isPresent(GFSAPDFDOCUMENT_CLASS_NAME)) {
			List<org.verapdf.model.salayer.SAPDFDocument> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			list.add(new GFSAPDFDocument(StaticResources.getDocument()));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private static boolean isPresent(String className) {
		try {
			Class.forName(className);
			return true;
		} catch (Throwable ex) {
			return false;
		}
	}

	/**
	 * link to cross reference table properties
	 */
	private List<CosXRef> getXRefs() {
		List<CosXRef> list = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
		list.add(new GFCosXRef(cosDocument.isSubsectionHeaderSpaceSeparated(),
				cosDocument.isXrefEOLMarkersComplyPDFA()));
		return Collections.unmodifiableList(list);
	}

	private COSDictionary getCatalog() {
		COSBase catalogLocal = cosDocument.getTrailer().getRoot().getDirectBase();
		if (catalogLocal != null && catalogLocal.getType() == COSObjType.COS_DICT) {
			return (COSDictionary) catalogLocal;
		}
		return null;
	}

}
