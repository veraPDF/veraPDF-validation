package org.verapdf.model.impl.pd;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosNumber;
import org.verapdf.model.impl.cos.GFCosNumber;
import org.verapdf.model.pdlayer.PDAction;
import org.verapdf.model.pdlayer.PDAnnot;
import org.verapdf.model.pdlayer.PDContentStream;
import org.verapdf.pd.PDAnnotation;
import org.verapdf.pd.PDResources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDAnnot extends GFPDObject implements PDAnnot {
	public static final String ANNOTATION_TYPE = "PDAnnot";

	public static final String DICT = "Dict";
	public static final String STREAM = "Stream";

	public static final String APPEARANCE = "appearance";
	public static final String C = "C";
	public static final String IC = "IC";
	public static final String A = "A";
	public static final String ADDITIONAL_ACTION = "AA";

	public static final int MAX_COUNT_OF_ACTIONS = 10;
	public static final int X_AXIS = 0;
	public static final int Y_AXIS = 1;

	private final PDResources pageResources;

	private List<PDContentStream> appearance = null;
	private boolean containsTransparency = false;

	public GFPDAnnot(PDAnnotation annot, PDResources pageResources) {
		super(annot, ANNOTATION_TYPE);
		this.pageResources = pageResources;
	}

	@Override
	public String getSubtype() {
		ASAtom subtype = ((PDAnnotation) simplePDObject).getSubtype();
		return subtype == null ? null : subtype.getValue();
	}

	@Override
	public String getAP() {
		// TODO: implement me
		return null;
	}

	@Override
	public Long getF() {
		return ((PDAnnotation) simplePDObject).getF();
	}

	@Override
	public Double getCA() {
		return ((PDAnnotation) simplePDObject).getCA();
	}

	@Override
	public String getN_type() {
		// TODO: implement me
		return null;
	}

	@Override
	public String getFT() {
		ASAtom ft = ((PDAnnotation) simplePDObject).getFT();
		return ft == null ? null : ft.getValue();
	}

	@Override
	public Double getwidth() {
		return getDifference(((PDAnnotation) simplePDObject).getRect(), X_AXIS);
	}

	@Override
	public Double getheight() {
		return getDifference(((PDAnnotation) simplePDObject).getRect(), Y_AXIS);
	}

	private Double getDifference(double[] array, int shift) {
		if (array != null && array.length > shift + 2) {
			return Double.valueOf(array[shift + 2] - array[shift]);
		}
		return null;
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case ADDITIONAL_ACTION:
				return this.getAdditionalActions();
			case A:
				return this.getA();
			case IC:
				return this.getIC();
			case C:
				return this.getC();
			case APPEARANCE:
				return this.getAppearance();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<PDAction> getAdditionalActions() {
		// TODO: implement me;
		return Collections.emptyList();
	}

	private List<PDAction> getA() {
		// TODO: implement me
		return Collections.emptyList();
	}

	private List<CosNumber> getIC() {
		return this.getNumbersFromArray(((PDAnnotation) simplePDObject).getCOSIC());
	}

	private List<CosNumber> getC() {
		return this.getNumbersFromArray(((PDAnnotation) simplePDObject).getCOSC());
	}

	private List<CosNumber> getNumbersFromArray(COSObject array) {
		if (array.size() > 0) {
			List<CosNumber> color = new ArrayList<>();
			for (COSObject colorValue : (COSArray) array.get()) {
				COSObjType type = colorValue.getType();
				if (type == COSObjType.COS_REAL || type == COSObjType.COS_INTEGER) {
					color.add(GFCosNumber.fromPDFParserNumber(colorValue.get()));
				}
			}
			return Collections.unmodifiableList(color);
		}
		return Collections.emptyList();
	}

	/**
	 * @return normal appearance stream (N key in the appearance dictionary) of
	 * the annotation
	 */
	private List<PDContentStream> getAppearance() {
		if (this.appearance == null) {
			this.appearance = parseAppearance();
		}
		return this.appearance;
	}

	boolean isContainsTransparency() {
		if (this.appearance == null) {
			this.appearance = parseAppearance();
		}
		return this.containsTransparency;
	}

	private List<PDContentStream> parseAppearance() {
		// TODO: implement me
		/*
		PDAppearanceDictionary appearanceDictionary = ((PDAnnotation) this.simplePDObject)
				.getAppearance();
		if (appearanceDictionary != null) {
			COSDictionary dictionary = appearanceDictionary.getCOSObject();
			COSBase normalAppearanceBase = dictionary.getDictionaryObject(COSName.N);
			COSBase downAppearanceBase = dictionary.getDictionaryObject(COSName.D);
			COSBase rolloverAppearanceBase = dictionary.getDictionaryObject(COSName.R);
			if (normalAppearanceBase != null || downAppearanceBase != null || rolloverAppearanceBase != null) {
				List<PDContentStream> appearances = new ArrayList<>();
				addContentStreamsFromAppearanceEntry(normalAppearanceBase, appearances);
				addContentStreamsFromAppearanceEntry(downAppearanceBase, appearances);
				addContentStreamsFromAppearanceEntry(rolloverAppearanceBase, appearances);
				return Collections.unmodifiableList(appearances);
			}
		}
		*/
		return Collections.emptyList();
	}

	/*
	private void addContentStreamsFromAppearanceEntry(COSBase appearanceEntry, List<PDContentStream> appearances) {
		if (appearanceEntry != null) {
			PDAppearanceEntry appearance = new PDAppearanceEntry(appearanceEntry);
			if (appearance.isStream()) {
				addAppearance(appearances, appearance.getAppearanceStream());
			} else {
				Map<COSName, PDAppearanceStream> subDictionary = appearance.getSubDictionary();
				for (PDAppearanceStream stream : subDictionary.values()) {
					addAppearance(appearances, stream);
				}
			}
		}
	}

	private void addAppearance(List<PDContentStream> list, PDAppearanceStream toAdd) {
		if (toAdd != null) {
			PDInheritableResources resources = PDInheritableResources.getInstance(this.pageResources, toAdd.getResources());
			PBoxPDContentStream stream = new PBoxPDContentStream(toAdd, resources, this.document, this.flavour);
			this.containsTransparency |= stream.isContainsTransparency();
			org.apache.pdfbox.pdmodel.graphics.form.PDGroup group = toAdd.getGroup();
			this.containsTransparency |= group != null && COSName.TRANSPARENCY.equals(group.getSubType());
			list.add(stream);
		}
	}
	*/
}
