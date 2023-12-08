/**
 * This file is part of veraPDF Feature Reporting, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Feature Reporting is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Feature Reporting as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Feature Reporting as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.features.gf.objects;

import org.verapdf.as.ASAtom;
import org.verapdf.features.objects.FormXObjectFeaturesObjectAdapter;
import org.verapdf.pd.PDGroup;
import org.verapdf.pd.PDMetadata;
import org.verapdf.pd.images.PDXForm;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Feature object adapter for form xobjects
 *
 * @author Maksim Bezrukov
 */
public class GFFormXObjectFeaturesObjectAdapter implements FormXObjectFeaturesObjectAdapter {

	private final PDXForm formXObject;
	private final String id;
	private final String groupColorSpaceChild;
	private final Set<String> extGStateChild;
	private final Set<String> colorSpaceChild;
	private final Set<String> patternChild;
	private final Set<String> shadingChild;
	private final Set<String> xobjectChild;
	private final Set<String> fontChild;
	private final Set<String> propertiesChild;

	/**
	 * Constructs new form xobject features object
	 *
	 * @param formXObject          PDFormXObject which represents form xobject for feature report
	 * @param id                   id of the object
	 * @param groupColorSpaceChild id of the group xobject which contains in the given form xobject
	 * @param extGStateChild       set of external graphics state id which contains in resource dictionary of this xobject
	 * @param colorSpaceChild      set of ColorSpace id which contains in resource dictionary of this xobject
	 * @param patternChild         set of pattern id which contains in resource dictionary of this xobject
	 * @param shadingChild         set of shading id which contains in resource dictionary of this xobject
	 * @param xobjectChild         set of XObject id which contains in resource dictionary of this xobject
	 * @param fontChild            set of font id which contains in resource dictionary of this pattern
	 * @param propertiesChild      set of properties id which contains in resource dictionary of this xobject
	 */
	public GFFormXObjectFeaturesObjectAdapter(PDXForm formXObject, String id, String groupColorSpaceChild,
											  Set<String> extGStateChild, Set<String> colorSpaceChild, Set<String> patternChild,
											  Set<String> shadingChild, Set<String> xobjectChild, Set<String> fontChild,
											  Set<String> propertiesChild) {
		this.formXObject = formXObject;
		this.id = id;
		this.groupColorSpaceChild = groupColorSpaceChild;
		this.extGStateChild = extGStateChild;
		this.colorSpaceChild = colorSpaceChild;
		this.patternChild = patternChild;
		this.shadingChild = shadingChild;
		this.xobjectChild = xobjectChild;
		this.fontChild = fontChild;
		this.propertiesChild = propertiesChild;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public InputStream getMetadataStream() {
		if (formXObject != null && !formXObject.empty()) {
			PDMetadata metadata = formXObject.getMetadata();
			return metadata == null ? null : metadata.getStream();
		}
		return null;
	}

	@Override
	public String getGroupColorSpaceChild() {
		return this.groupColorSpaceChild;
	}

	@Override
	public Set<String> getExtGStateChild() {
		return this.extGStateChild == null ?
				Collections.emptySet() : Collections.unmodifiableSet(this.extGStateChild);
	}

	@Override
	public Set<String> getColorSpaceChild() {
		return this.colorSpaceChild == null ?
				Collections.emptySet() : Collections.unmodifiableSet(this.colorSpaceChild);
	}

	@Override
	public Set<String> getPatternChild() {
		return this.patternChild == null ?
				Collections.emptySet() : Collections.unmodifiableSet(this.patternChild);
	}

	@Override
	public Set<String> getShadingChild() {
		return this.shadingChild == null ?
				Collections.emptySet() : Collections.unmodifiableSet(this.shadingChild);
	}

	@Override
	public Set<String> getXObjectChild() {
		return this.xobjectChild == null ?
				Collections.emptySet() : Collections.unmodifiableSet(this.xobjectChild);
	}

	@Override
	public Set<String> getFontChild() {
		return this.fontChild == null ?
				Collections.emptySet() : Collections.unmodifiableSet(this.fontChild);
	}

	@Override
	public Set<String> getPropertiesChild() {
		return this.propertiesChild == null ?
				Collections.emptySet() : Collections.unmodifiableSet(this.propertiesChild);
	}

	@Override
	public double[] getBBox() {
		if (formXObject != null && !formXObject.empty()) {
			return formXObject.getBBox();
		}
		return null;
	}

	@Override
	public double[] getMatrix() {
		if (formXObject != null && !formXObject.empty()) {
			return formXObject.getMatrix();
		}
		return null;
	}

	@Override
	public boolean isGroupPresent() {
		return formXObject != null && !formXObject.empty() && formXObject.getGroup() != null;
	}

	@Override
	public String getGroupSubtype() {
		if (formXObject != null && !formXObject.empty()) {
			PDGroup group = formXObject.getGroup();
			if (group != null) {
				ASAtom subtype = group.getSubtype();
				return subtype == null ? null : subtype.getValue();
			}
		}
		return null;
	}

	@Override
	public boolean isTransparencyGroupIsolated() {
		if (formXObject != null && !formXObject.empty()) {
			PDGroup group = formXObject.getGroup();
			if (group != null) {
				return group.isIsolated();
			}
		}
		return false;
	}

	@Override
	public boolean isTransparencyGroupKnockout() {
		if (formXObject != null && !formXObject.empty()) {
			PDGroup group = formXObject.getGroup();
			if (group != null) {
				return group.isKnockout();
			}
		}
		return false;
	}

	@Override
	public Long getStructParents() {
		if (formXObject != null && !formXObject.empty()) {
			return formXObject.getStructParents();
		}
		return null;
	}

	@Override
	public boolean isPDFObjectPresent() {
		return formXObject != null && !formXObject.empty();
	}

	@Override
	public List<String> getErrors() {
		return Collections.emptyList();
	}
}
