package org.verapdf.gf.model.impl.pd;

import org.verapdf.as.ASAtom;
import org.verapdf.gf.model.factory.colors.ColorSpaceFactory;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDColorSpace;
import org.verapdf.model.pdlayer.PDGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDGroup extends GFPDObject implements PDGroup {

	public static final String GROUP_TYPE = "PDGroup";

	public static final String COLOR_SPACE = "colorSpace";

	public GFPDGroup(org.verapdf.pd.PDGroup simplePDObject) {
		super(simplePDObject, GROUP_TYPE);
	}

	@Override
	public String getS() {
		ASAtom subtype = ((org.verapdf.pd.PDGroup) this.simplePDObject).getSubtype();
		return subtype == null ? null : subtype.getValue();
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (COLOR_SPACE.equals(link)) {
			return this.getColorSpace();
		}
		return super.getLinkedObjects(link);
	}

	private List<PDColorSpace> getColorSpace() {
		org.verapdf.pd.colors.PDColorSpace pbColorSpace =
				((org.verapdf.pd.PDGroup) this.simplePDObject).getColorSpace();
		PDColorSpace colorSpace = ColorSpaceFactory.getColorSpace(pbColorSpace);
		if (colorSpace != null) {
			List<PDColorSpace> colorSpaces = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			colorSpaces.add(colorSpace);
			return Collections.unmodifiableList(colorSpaces);
		}
		return Collections.emptyList();
	}
}
