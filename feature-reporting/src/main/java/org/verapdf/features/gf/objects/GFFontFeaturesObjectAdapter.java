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

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSStream;
import org.verapdf.features.objects.FontFeaturesObjectAdapter;
import org.verapdf.pd.PDMetadata;
import org.verapdf.pd.font.PDCIDFont;
import org.verapdf.pd.font.PDCIDSystemInfo;
import org.verapdf.pd.font.PDFontDescriptor;
import org.verapdf.pd.font.PDType3Font;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Feature object adapter for fonts.
 *
 * @author Sergey Shemyakov
 */
public class GFFontFeaturesObjectAdapter implements FontFeaturesObjectAdapter {

	private org.verapdf.pd.font.PDFont font;
	private String id;
	private Set<String> extGStateChild;
	private Set<String> colorSpaceChild;
	private Set<String> patternChild;
	private Set<String> shadingChild;
	private Set<String> xobjectChild;
	private Set<String> fontChild;
	private Set<String> propertiesChild;
	private FontDescriptorAdapter fontDescriptorAdapter;

	public GFFontFeaturesObjectAdapter(org.verapdf.pd.font.PDFont font, String id, Set<String>
			extGStateChild, Set<String> colorSpaceChild, Set<String> patternChild,
									   Set<String> shadingChild, Set<String> xobjectChild,
									   Set<String> fontChild, Set<String> propertiesChild) {
		this.font = font;
		this.id = id;
		this.extGStateChild = extGStateChild;
		this.colorSpaceChild = colorSpaceChild;
		this.patternChild = patternChild;
		this.shadingChild = shadingChild;
		this.xobjectChild = xobjectChild;
		this.fontChild = fontChild;
		this.propertiesChild = propertiesChild;
		if (font != null && !font.empty()) {
			PDFontDescriptor descriptor = this.font.getFontDescriptor();
			this.fontDescriptorAdapter = descriptor != null && !descriptor.empty() ?
					new GFFontDescriptorAdapter(descriptor) : null;
		}
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public Set<String> getExtGStateChild() {
		return this.extGStateChild == null ?
				Collections.<String>emptySet() : Collections.unmodifiableSet(this.extGStateChild);
	}

	@Override
	public Set<String> getColorSpaceChild() {
		return this.colorSpaceChild == null ?
				Collections.<String>emptySet() : Collections.unmodifiableSet(this.colorSpaceChild);
	}

	@Override
	public Set<String> getPatternChild() {
		return this.patternChild == null ?
				Collections.<String>emptySet() : Collections.unmodifiableSet(this.patternChild);
	}

	@Override
	public Set<String> getShadingChild() {
		return this.shadingChild == null ?
				Collections.<String>emptySet() : Collections.unmodifiableSet(this.shadingChild);
	}

	@Override
	public Set<String> getXObjectChild() {
		return this.xobjectChild == null ?
				Collections.<String>emptySet() : Collections.unmodifiableSet(this.xobjectChild);
	}

	@Override
	public Set<String> getFontChild() {
		return this.fontChild == null ?
				Collections.<String>emptySet() : Collections.unmodifiableSet(this.fontChild);
	}

	@Override
	public Set<String> getPropertiesChild() {
		return this.propertiesChild == null ?
				Collections.<String>emptySet() : Collections.unmodifiableSet(this.propertiesChild);
	}

	@Override
	public String getType() {
		if (font != null && !font.empty()) {
			ASAtom subtype = font.getSubtype();
			return subtype == null ? null : subtype.getValue();
		}
		return null;
	}

	@Override
	public String getBaseFont() {
		if (font != null && !font.empty()) {
			return font.getName();
		}
		return null;
	}

	@Override
	public Long getFirstChar() {
		if (font != null && !font.empty()) {
			return font.getFirstChar();
		}
		return null;
	}

	@Override
	public Long getLastChar() {
		if (font != null && !font.empty()) {
			return font.getLastChar();
		}
		return null;
	}

	@Override
	public List<Long> getWidth() {
		if (font != null && !font.empty()) {
			COSObject widths = font.getWidths();
			if (widths != null && widths.getType() == COSObjType.COS_ARRAY) {
				List<Long> res = new ArrayList<>(widths.size());
				for (int i = 0; i < widths.size(); ++i) {
					COSObject arElement = widths.at(i);
					if (arElement.getType().isNumber()) {
						res.add(arElement.getInteger());
					}
				}
				return Collections.unmodifiableList(res);
			}
		}
		return Collections.emptyList();
	}

	@Override
	public String getEncoding() {
		if (font != null && !font.empty()) {
			COSObject enc = font.getEncoding();
			if (enc.getType() == COSObjType.COS_NAME) {
				return enc.getString();
			} else if (enc.getType() == COSObjType.COS_DICT) {
				ASAtom name = enc.getNameKey(ASAtom.BASE_ENCODING);
				return name == null ? null : name.getValue();
			}
		}
		return null;
	}

	@Override
	public double[] getBoundingBox() {
		if (font != null && !font.empty() && font.getSubtype() == ASAtom.TYPE3) {
			PDType3Font type3 = (PDType3Font) font;
			return type3.getFontBoundingBox();
		}
		return null;
	}

	@Override
	public double[] getMatrix() {
		if (font != null && !font.empty() && font.getSubtype() == ASAtom.TYPE3) {
			PDType3Font type3 = (PDType3Font) font;
			return type3.getFontMatrix();
		}
		return null;
	}

	@Override
	public boolean isCIDSystemInfoPresent() {
		if (font != null && !font.empty()) {
			ASAtom subtype = font.getSubtype();
			if (subtype == ASAtom.CID_FONT_TYPE0 ||
					subtype == ASAtom.CID_FONT_TYPE2) {
				PDCIDFont cid = (PDCIDFont) font;
				PDCIDSystemInfo cidSystemInfo = cid.getCIDSystemInfo();
				return cidSystemInfo != null;
			}
		}
		return false;
	}

	@Override
	public Double getDefaultWidth() {
		if (font != null && !font.empty()) {
			return font.getDefaultWidth();
		}
		return null;
	}

	@Override
	public String getCIDSysInfoRegistry() {
		if (font != null && !font.empty()) {
			ASAtom subtype = font.getSubtype();
			if (subtype == ASAtom.CID_FONT_TYPE0 ||
					subtype == ASAtom.CID_FONT_TYPE2) {
				PDCIDFont cid = (PDCIDFont) font;
				PDCIDSystemInfo cidSystemInfo = cid.getCIDSystemInfo();
				if (cidSystemInfo != null) {
					return cidSystemInfo.getRegistry();
				}
			}
		}
		return null;
	}

	@Override
	public String getCIDSysInfoOrdering() {
		if (font != null && !font.empty()) {
			ASAtom subtype = font.getSubtype();
			if (subtype == ASAtom.CID_FONT_TYPE0 ||
					subtype == ASAtom.CID_FONT_TYPE2) {
				PDCIDFont cid = (PDCIDFont) font;
				PDCIDSystemInfo cidSystemInfo = cid.getCIDSystemInfo();
				if (cidSystemInfo != null) {
					return cidSystemInfo.getOrdering();
				}
			}
		}
		return null;
	}

	@Override
	public Long getCIDSysInfoSupplement() {
		if (font != null && !font.empty()) {
			ASAtom subtype = font.getSubtype();
			if (subtype == ASAtom.CID_FONT_TYPE0 ||
					subtype == ASAtom.CID_FONT_TYPE2) {
				PDCIDFont cid = (PDCIDFont) font;
				PDCIDSystemInfo cidSystemInfo = cid.getCIDSystemInfo();
				if (cidSystemInfo != null) {
					return cidSystemInfo.getSupplement();
				}
			}
		}
		return null;
	}

	@Override
	public FontDescriptorAdapter getFontDescriptor() {
		return this.fontDescriptorAdapter;
	}

	@Override
	public boolean isPDFObjectPresent() {
		return font != null && !font.empty();
	}

	@Override
	public List<String> getErrors() {
		return Collections.emptyList();
	}

	private static class GFFontDescriptorAdapter implements FontDescriptorAdapter {

		private PDFontDescriptor descriptor;
		private COSStream file;
		private PDMetadata metadata;

		GFFontDescriptorAdapter(PDFontDescriptor descriptor) {
			this.descriptor = descriptor;
			this.file = descriptor.getFontFile();
			if (this.file == null) {
				this.file = descriptor.getFontFile2();
			}
			if (this.file == null) {
				this.file = descriptor.getFontFile3();
			}
			if (file != null) {
				this.metadata = new PDMetadata(file.getKey(ASAtom.METADATA));
			}
		}

		@Override
		public String getFontName() {
			ASAtom fontName = descriptor.getFontName();
			return fontName == null ? null : fontName.getValue();
		}

		@Override
		public String getFontFamily() {
			return descriptor.getFontFamily();
		}

		@Override
		public String getFontStretch() {
			ASAtom fontStretch = descriptor.getFontStretch();
			return fontStretch == null ? null : fontStretch.getValue();
		}

		@Override
		public Double getFontWeight() {
			return descriptor.getFontWeight();
		}

		@Override
		public boolean isFixedPitch() {
			return descriptor.isFixedPitch();
		}

		@Override
		public boolean isSerif() {
			return descriptor.isSerif();
		}

		@Override
		public boolean isSymbolic() {
			return descriptor.isSymbolic();
		}

		@Override
		public boolean isScript() {
			return descriptor.isScript();
		}

		@Override
		public boolean isNonSymbolic() {
			return descriptor.isNonsymbolic();
		}

		@Override
		public boolean isItalic() {
			return descriptor.isItalic();
		}

		@Override
		public boolean isAllcap() {
			return descriptor.isAllCap();
		}

		@Override
		public boolean isSmallCap() {
			return descriptor.isSmallCap();
		}

		@Override
		public boolean isForceBold() {
			return descriptor.isForceBold();
		}

		@Override
		public double[] getFontBoundingBox() {
			return descriptor.getFontBoundingBox();
		}

		@Override
		public Double getItalicAngle() {
			return descriptor.getItalicAngle();
		}

		@Override
		public Double getAscent() {
			return descriptor.getAscent();
		}

		@Override
		public Double getDescent() {
			return descriptor.getDescent();
		}

		@Override
		public Double getLeading() {
			return descriptor.getLeading();
		}

		@Override
		public Double getCapHeight() {
			return descriptor.getCapHeight();
		}

		@Override
		public Double getXHeight() {
			return descriptor.getXHeight();
		}

		@Override
		public Double getStemV() {
			return descriptor.getStemV();
		}

		@Override
		public Double getStemH() {
			return descriptor.getStemH();
		}

		@Override
		public Double getAverageWidth() {
			return descriptor.getAvgWidth();
		}

		@Override
		public Double getMaxWidth() {
			return descriptor.getMaxWidth();
		}

		@Override
		public Double getMissingWidth() {
			return descriptor.getMissingWidth();
		}

		@Override
		public String getCharSet() {
			return descriptor.getCharSet();
		}

		@Override
		public boolean isEmbedded() {
			return this.file != null;
		}

		@Override
		public Long getFlags() {
			return descriptor.getFlags();
		}

		@Override
		public InputStream getMetadataStream() {
			return metadata == null || metadata.empty() ? null : metadata.getStream();
		}

		@Override
		public InputStream getData() {
			return file == null || metadata.empty() ? null : file.getData(COSStream.FilterFlags.DECODE);
		}
	}
}
