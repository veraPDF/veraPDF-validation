package org.verapdf.gf.model.impl.pd.images;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSStream;
import org.verapdf.gf.model.impl.cos.GFCosDict;
import org.verapdf.gf.model.impl.cos.GFCosStream;
import org.verapdf.gf.model.impl.pd.GFPDContentStream;
import org.verapdf.gf.model.impl.pd.GFPDGroup;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosDict;
import org.verapdf.model.coslayer.CosStream;
import org.verapdf.model.pdlayer.PDContentStream;
import org.verapdf.model.pdlayer.PDGroup;
import org.verapdf.model.pdlayer.PDXForm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDXForm extends GFPDXObject implements PDXForm {

	public static final String X_FORM_TYPE = "PDXForm";

	public static final String GROUP = "Group";
	public static final String PS = "PS";
	public static final String REF = "Ref";
	public static final String CONTENT_STREAM = "contentStream";

	private List<PDContentStream> contentStreams = null;
	private List<PDGroup> groups = null;
	private boolean groupContainsTransparency = false;
	private boolean contentStreamContainsTransparency = false;

	public GFPDXForm(org.verapdf.pd.images.PDXForm simplePDObject, PDResourcesHandler resourcesHandler) {
		super(simplePDObject, resourcesHandler.getExtendedResources(simplePDObject.getResources()), X_FORM_TYPE);
	}

	@Override
	public String getSubtype2() {
		ASAtom subtype2 = ((org.verapdf.pd.images.PDXForm) this.simplePDObject).getSubtype2();
		return subtype2 == null ? null : subtype2.getValue();
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case GROUP:
				return this.getGroup();
			case PS:
				return this.getPS();
			case REF:
				return this.getREF();
			case CONTENT_STREAM:
				return this.getContentStream();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<PDGroup> getGroup() {
		if (this.groups == null) {
			initializeGroups();
		}
		return this.groups;
	}

	private List<CosStream> getPS() {
		COSStream ps = ((org.verapdf.pd.images.PDXForm) this.simplePDObject).getPS();
		if (ps != null) {
			List<CosStream> postScript = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			postScript.add(new GFCosStream(ps));
			return Collections.unmodifiableList(postScript);
		}
		return Collections.emptyList();
	}

	private List<CosDict> getREF() {
		COSDictionary ref = ((org.verapdf.pd.images.PDXForm) this.simplePDObject).getRef();
		if (ref != null) {
			List<CosDict> postScript = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			postScript.add(new GFCosDict(ref));
			return Collections.unmodifiableList(postScript);
		}
		return Collections.emptyList();
	}

	private List<PDContentStream> getContentStream() {
		if (this.contentStreams == null) {
			parseContentStream();
		}
		return this.contentStreams;
	}

	private void initializeGroups() {
		org.verapdf.pd.PDGroup group = ((org.verapdf.pd.images.PDXForm) this.simplePDObject).getGroup();
		if (group != null) {
			this.groupContainsTransparency = ASAtom.TRANSPARENCY.equals(group.getSubtype());
			List<PDGroup> groups = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			groups.add(new GFPDGroup(group));
			this.groups = Collections.unmodifiableList(groups);
		} else {
			this.groups = Collections.emptyList();
		}
	}

	private void parseContentStream() {
		List<PDContentStream> streams = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
		GFPDContentStream gfContentStream = new GFPDContentStream(
				(org.verapdf.pd.images.PDXForm) this.simplePDObject, resourcesHandler);
		this.contentStreamContainsTransparency = gfContentStream.isContainsTransparency();
		streams.add(gfContentStream);
		this.contentStreams = streams;
	}

	/**
	 * @return true if current form object contains transparency group or transparency in its content stream
	 */
	public boolean containsTransparency() {
		if (groups == null) {
			initializeGroups();
		}
		if (contentStreams == null) {
			parseContentStream();
		}

		return groupContainsTransparency || contentStreamContainsTransparency;
	}
}
