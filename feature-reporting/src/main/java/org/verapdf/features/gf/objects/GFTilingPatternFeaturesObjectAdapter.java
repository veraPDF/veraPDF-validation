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

import org.verapdf.features.objects.TilingPatternFeaturesObjectAdapter;
import org.verapdf.pd.patterns.PDTilingPattern;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Feature object for tilling pattern
 *
 * @author Maksim Bezrukov
 */
public class GFTilingPatternFeaturesObjectAdapter implements TilingPatternFeaturesObjectAdapter {

	private PDTilingPattern tilingPattern;
	private String id;
	private Set<String> extGStateChild;
	private Set<String> colorSpaceChild;
	private Set<String> patternChild;
	private Set<String> shadingChild;
	private Set<String> xobjectChild;
	private Set<String> fontChild;
	private Set<String> propertiesChild;

	/**
	 * Constructs new tilling pattern features object
	 *
	 * @param tilingPattern   PDTilingPattern which represents tilling pattern for feature report
	 * @param id              id of the object
	 * @param extGStateChild  set of external graphics state id which contains in resource dictionary of this pattern
	 * @param colorSpaceChild set of ColorSpace id which contains in resource dictionary of this pattern
	 * @param patternChild    set of pattern id which contains in resource dictionary of this pattern
	 * @param shadingChild    set of shading id which contains in resource dictionary of this pattern
	 * @param xobjectChild    set of XObject id which contains in resource dictionary of this pattern
	 * @param fontChild       set of font id which contains in resource dictionary of this pattern
	 * @param propertiesChild set of properties id which contains in resource dictionary of this pattern
	 */
	public GFTilingPatternFeaturesObjectAdapter(PDTilingPattern tilingPattern, String id, Set<String> extGStateChild,
												Set<String> colorSpaceChild, Set<String> patternChild, Set<String> shadingChild,
												Set<String> xobjectChild, Set<String> fontChild, Set<String> propertiesChild) {
		this.tilingPattern = tilingPattern;
		this.id = id;
		this.extGStateChild = extGStateChild;
		this.colorSpaceChild = colorSpaceChild;
		this.patternChild = patternChild;
		this.shadingChild = shadingChild;
		this.xobjectChild = xobjectChild;
		this.fontChild = fontChild;
		this.propertiesChild = propertiesChild;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public Set<String> getExtGStateChild() {
		return extGStateChild == null ? Collections.<String>emptySet() : Collections.unmodifiableSet(extGStateChild);
	}

	@Override
	public Set<String> getColorSpaceChild() {
		return colorSpaceChild == null ? Collections.<String>emptySet() : Collections.unmodifiableSet(colorSpaceChild);
	}

	@Override
	public Set<String> getPatternChild() {
		return patternChild == null ? Collections.<String>emptySet() : Collections.unmodifiableSet(patternChild);
	}

	@Override
	public Set<String> getShadingChild() {
		return shadingChild == null ? Collections.<String>emptySet() : Collections.unmodifiableSet(shadingChild);
	}

	@Override
	public Set<String> getXObjectChild() {
		return xobjectChild == null ? Collections.<String>emptySet() : Collections.unmodifiableSet(xobjectChild);
	}

	@Override
	public Set<String> getFontChild() {
		return fontChild == null ? Collections.<String>emptySet() : Collections.unmodifiableSet(fontChild);
	}

	@Override
	public Set<String> getPropertiesChild() {
		return propertiesChild == null ? Collections.<String>emptySet() : Collections.unmodifiableSet(propertiesChild);
	}

	@Override
	public Long getPaintType() {
		if (tilingPattern != null && !tilingPattern.empty()) {
			return tilingPattern.getPaintType();
		}
		return null;
	}

	@Override
	public Long getTilingType() {
		if (tilingPattern != null && !tilingPattern.empty()) {
			return tilingPattern.getTilingType();
		}
		return null;
	}

	@Override
	public double[] getBBox() {
		if (tilingPattern != null && !tilingPattern.empty()) {
			return tilingPattern.getBBox();
		}
		return null;
	}

	@Override
	public Double getXStep() {
		if (tilingPattern != null && !tilingPattern.empty()) {
			return tilingPattern.getXStep();
		}
		return null;
	}

	@Override
	public Double getYStep() {
		if (tilingPattern != null && !tilingPattern.empty()) {
			return tilingPattern.getYStep();
		}
		return null;
	}

	@Override
	public double[] getMatrix() {
		if (tilingPattern != null && !tilingPattern.empty()) {
			return tilingPattern.getMatrix();
		}
		return null;
	}

	@Override
	public List<String> getErrors() {
		return Collections.emptyList();
	}
}
