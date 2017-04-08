/**
 * This file is part of feature-reporting, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 * <p>
 * feature-reporting is free software: you can redistribute it and/or modify
 * it under the terms of either:
 * <p>
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with feature-reporting as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 * <p>
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * feature-reporting as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.features.gf.objects;

import org.verapdf.features.gf.tools.GFAdapterHelper;
import org.verapdf.features.objects.AnnotationFeaturesObjectAdapter;
import org.verapdf.pd.PDAnnotation;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Feature object adapter for annotation
 *
 * @author Maksim Bezrukov
 */
public class GFAnnotationFeaturesObjectAdapter implements AnnotationFeaturesObjectAdapter {

	private String id;
	private String popupId;
	private Set<String> formXObjects;
	private PDAnnotation annot;

	/**
	 * Constructs new Annotation Feature Object Adapter
	 *
	 * @param annot        class represents annotation object
	 * @param id           annotation id
	 * @param popupId      id of the popup annotation
	 * @param formXObjects set of id of the form XObjects which used in appearance stream of this annotation
	 */
	public GFAnnotationFeaturesObjectAdapter(PDAnnotation annot, String id,
											 String popupId, Set<String> formXObjects) {
		this.id = id;
		this.popupId = popupId;
		this.formXObjects = formXObjects;
		this.annot = annot;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getPopupId() {
		return popupId;
	}

	@Override
	public Set<String> getFormXObjectsResources() {
		return formXObjects == null ? Collections.<String>emptySet() : Collections.unmodifiableSet(formXObjects);
	}

	@Override
	public String getSubtype() {
		return annot == null || annot.empty() ? null : GFAdapterHelper.getStringFromASAtom(annot.getSubtype());
	}

	@Override
	public double[] getRectangle() {
		return annot == null || annot.empty() ? null : annot.getRect();
	}

	@Override
	public String getContents() {
		return annot == null || annot.empty() ? null : annot.getContents();
	}

	@Override
	public String getAnnotationName() {
		return annot == null || annot.empty() ? null : annot.getAnnotationName();
	}

	@Override
	public String getModifiedDate() {
		return annot == null || annot.empty() ? null : annot.getModDate();
	}

	@Override
	public double[] getColor() {
		return annot == null || annot.empty() ? null : annot.getColor();
	}

	@Override
	public boolean isInvisible() {
		return annot == null || annot.empty() ? false : annot.isInvisible();
	}

	@Override
	public boolean isHidden() {
		return annot == null || annot.empty() ? false : annot.isHidden();
	}

	@Override
	public boolean isPrinted() {
		return annot == null || annot.empty() ? false : annot.isPrinted();
	}

	@Override
	public boolean isNoZoom() {
		return annot == null || annot.empty() ? false : annot.isNoZoom();
	}

	@Override
	public boolean isNoRotate() {
		return annot == null || annot.empty() ? false : annot.isNoRotate();
	}

	@Override
	public boolean isNoView() {
		return annot == null || annot.empty() ? false : annot.isNoView();
	}

	@Override
	public boolean isReadOnly() {
		return annot == null || annot.empty() ? false : annot.isReadOnly();
	}

	@Override
	public boolean isLocked() {
		return annot == null || annot.empty() ? false : annot.isLocked();
	}

	@Override
	public boolean isToggleNoView() {
		return annot == null || annot.empty() ? false : annot.isToggleNoView();
	}

	@Override
	public boolean isLockedContents() {
		return annot == null || annot.empty() ? false : annot.isLockedContents();
	}

	@Override
	public List<String> getErrors() {
		return Collections.<String>emptyList();
	}
}
