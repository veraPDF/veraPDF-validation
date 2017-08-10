/**
 * This file is part of feature-reporting, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * feature-reporting is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with feature-reporting as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * feature-reporting as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.features.gf.objects;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSDictionary;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.features.objects.PageFeaturesObjectAdapter;
import org.verapdf.pd.PDMetadata;
import org.verapdf.pd.PDPage;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Feature object adapter for page
 *
 * @author Maksim Bezrukov
 */
public class GFPageFeaturesObjectAdapter implements PageFeaturesObjectAdapter {

	private PDPage page;
	private String label;
	private String thumb;
	private Set<String> annotsId;
	private Set<String> extGStateChild;
	private Set<String> colorSpaceChild;
	private Set<String> patternChild;
	private Set<String> shadingChild;
	private Set<String> xobjectChild;
	private Set<String> fontChild;
	private Set<String> propertiesChild;
	private int index;

	private String transitionStyle;
	private List<String> errors;

	/**
	 * Constructs new Page Feature Object
	 *
	 * @param page            class represents page object
	 * @param thumb           thumbnail image id
	 * @param annotsId        set of annotations id which contains in this page
	 * @param extGStateChild  set of external graphics state id which contains in resource dictionary of this page
	 * @param colorSpaceChild set of ColorSpace id which contains in resource dictionary of this page
	 * @param patternChild    set of pattern id which contains in resource dictionary of this page
	 * @param shadingChild    set of shading id which contains in resource dictionary of this page
	 * @param xobjectChild    set of XObject id which contains in resource dictionary of this page
	 * @param fontChild       set of font id which contains in resource dictionary of this page
	 * @param propertiesChild set of properties id which contains in resource dictionary of this page
	 * @param index           page index
	 */
	public GFPageFeaturesObjectAdapter(PDPage page,
									   String label,
									   String thumb,
									   Set<String> annotsId,
									   Set<String> extGStateChild,
									   Set<String> colorSpaceChild,
									   Set<String> patternChild,
									   Set<String> shadingChild,
									   Set<String> xobjectChild,
									   Set<String> fontChild,
									   Set<String> propertiesChild,
									   int index) {
		this.page = page;
		this.label = label;
		this.thumb = thumb;
		this.annotsId = annotsId;
		this.extGStateChild = extGStateChild;
		this.colorSpaceChild = colorSpaceChild;
		this.patternChild = patternChild;
		this.shadingChild = shadingChild;
		this.xobjectChild = xobjectChild;
		this.fontChild = fontChild;
		this.propertiesChild = propertiesChild;
		this.index = index;
		if (this.page != null && !this.page.empty()) {
			COSObject transition = page.getKey(ASAtom.TRANS);
			if (transition != null && !transition.empty()) {
				if (transition.getType() == COSObjType.COS_DICT) {
					ASAtom style = transition.getNameKey(ASAtom.S);
					this.transitionStyle = style == null ? "R" : style.getValue();
				} else {
					this.errors = new ArrayList<>();
					this.errors.add("Page dictionary contains /Trans key but its value's type is not a dictionary");
				}
			}
		}
	}

	@Override
	public String getThumb() {
		return thumb;
	}

	@Override
	public Set<String> getAnnotsId() {
		return annotsId;
	}

	@Override
	public Set<String> getExtGStateChild() {
		return extGStateChild;
	}

	@Override
	public Set<String> getColorSpaceChild() {
		return colorSpaceChild;
	}

	@Override
	public Set<String> getPatternChild() {
		return patternChild;
	}

	@Override
	public Set<String> getShadingChild() {
		return shadingChild;
	}

	@Override
	public Set<String> getXObjectChild() {
		return xobjectChild;
	}

	@Override
	public Set<String> getFontChild() {
		return fontChild;
	}

	@Override
	public Set<String> getPropertiesChild() {
		return propertiesChild;
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public String getLabel() {
		return this.label;
	}

	@Override
	public String getTransitionStyle() {
		return this.transitionStyle;
	}

	@Override
	public double[] getMediaBox() {
		if (page != null && !page.empty()) {
			return page.getMediaBox();
		}
		return null;
	}

	@Override
	public double[] getCropBox() {
		if (page != null && !page.empty()) {
			return page.getCropBox();
		}
		return null;
	}

	@Override
	public double[] getTrimBox() {
		if (page != null && !page.empty()) {
			return page.getTrimBox();
		}
		return null;
	}

	@Override
	public double[] getBleedBox() {
		if (page != null && !page.empty()) {
			return page.getBleedBox();
		}
		return null;
	}

	@Override
	public double[] getArtBox() {
		if (page != null && !page.empty()) {
			return page.getArtBox();
		}
		return null;
	}

	@Override
	public Long getRotation() {
		if (page != null && !page.empty()) {
			return page.getRotation();
		}
		return null;
	}

	@Override
	public Double getScaling() {
		if (page != null && !page.empty()) {
			return page.getScaling();
		}
		return null;
	}

	@Override
	public InputStream getMetadataStream() {
		if (page != null && !page.empty()) {
			PDMetadata meta = page.getMetadata();
			if (meta != null && !meta.empty()) {
				return meta.getStream();
			}
		}
		return null;
	}

	@Override
	public boolean isPDFObjectPresent() {
		return page != null && !page.empty();
	}

	@Override
	public List<String> getErrors() {
		if (this.errors != null) {
			return Collections.unmodifiableList(this.errors);
		}
		return Collections.emptyList();
	}
}
