package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.model.tools.constants.Operators;
import org.verapdf.operator.Operator;
import org.verapdf.as.io.ASInputStream;
import org.verapdf.parser.PDFStreamParser;
import org.verapdf.pd.structure.NameTreeIterator;
import java.io.IOException;

public class GFALegalAttestation extends GFAObject implements ALegalAttestation {

	public GFALegalAttestation(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ALegalAttestation");
	}

	@Override
	public Boolean getcontainsAlternateImages() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AlternateImages"));
	}

	@Override
	public Boolean getAlternateImagesHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AlternateImages"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getAlternateImagesIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AlternateImages"));
		if (object == null || object.empty()) {
			return getAlternateImagesIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getAlternateImagesIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsAnnotations() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Annotations"));
	}

	@Override
	public Boolean getAnnotationsHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Annotations"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getAnnotationsIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Annotations"));
		if (object == null || object.empty()) {
			return getAnnotationsIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getAnnotationsIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsAttestation() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Attestation"));
	}

	@Override
	public Boolean getAttestationHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Attestation"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getcontainsDevDepGS_BG() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DevDepGS_BG"));
	}

	@Override
	public Boolean getDevDepGS_BGHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DevDepGS_BG"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getDevDepGS_BGIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DevDepGS_BG"));
		if (object == null || object.empty()) {
			return getDevDepGS_BGIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getDevDepGS_BGIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsDevDepGS_FL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DevDepGS_FL"));
	}

	@Override
	public Boolean getDevDepGS_FLHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DevDepGS_FL"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getDevDepGS_FLIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DevDepGS_FL"));
		if (object == null || object.empty()) {
			return getDevDepGS_FLIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getDevDepGS_FLIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsDevDepGS_HT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DevDepGS_HT"));
	}

	@Override
	public Boolean getDevDepGS_HTHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DevDepGS_HT"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getDevDepGS_HTIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DevDepGS_HT"));
		if (object == null || object.empty()) {
			return getDevDepGS_HTIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getDevDepGS_HTIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsDevDepGS_OP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DevDepGS_OP"));
	}

	@Override
	public Boolean getDevDepGS_OPHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DevDepGS_OP"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getDevDepGS_OPIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DevDepGS_OP"));
		if (object == null || object.empty()) {
			return getDevDepGS_OPIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getDevDepGS_OPIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsDevDepGS_TR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DevDepGS_TR"));
	}

	@Override
	public Boolean getDevDepGS_TRHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DevDepGS_TR"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getDevDepGS_TRIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DevDepGS_TR"));
		if (object == null || object.empty()) {
			return getDevDepGS_TRIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getDevDepGS_TRIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsDevDepGS_UCR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DevDepGS_UCR"));
	}

	@Override
	public Boolean getDevDepGS_UCRHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DevDepGS_UCR"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getDevDepGS_UCRIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DevDepGS_UCR"));
		if (object == null || object.empty()) {
			return getDevDepGS_UCRIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getDevDepGS_UCRIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsExternalOPIdicts() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ExternalOPIdicts"));
	}

	@Override
	public Boolean getExternalOPIdictsHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExternalOPIdicts"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getExternalOPIdictsIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExternalOPIdicts"));
		if (object == null || object.empty()) {
			return getExternalOPIdictsIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getExternalOPIdictsIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsExternalRefXobjects() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ExternalRefXobjects"));
	}

	@Override
	public Boolean getExternalRefXobjectsHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExternalRefXobjects"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getExternalRefXobjectsIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExternalRefXobjects"));
		if (object == null || object.empty()) {
			return getExternalRefXobjectsIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getExternalRefXobjectsIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsExternalStreams() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ExternalStreams"));
	}

	@Override
	public Boolean getExternalStreamsHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExternalStreams"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getExternalStreamsIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExternalStreams"));
		if (object == null || object.empty()) {
			return getExternalStreamsIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getExternalStreamsIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsGoToRemoteActions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GoToRemoteActions"));
	}

	@Override
	public Boolean getGoToRemoteActionsHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GoToRemoteActions"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getGoToRemoteActionsIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GoToRemoteActions"));
		if (object == null || object.empty()) {
			return getGoToRemoteActionsIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getGoToRemoteActionsIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsHideAnnotationActions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HideAnnotationActions"));
	}

	@Override
	public Boolean getHideAnnotationActionsHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HideAnnotationActions"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getHideAnnotationActionsIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HideAnnotationActions"));
		if (object == null || object.empty()) {
			return getHideAnnotationActionsIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getHideAnnotationActionsIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsJavaScriptActions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("JavaScriptActions"));
	}

	@Override
	public Boolean getJavaScriptActionsHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("JavaScriptActions"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getJavaScriptActionsIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("JavaScriptActions"));
		if (object == null || object.empty()) {
			return getJavaScriptActionsIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getJavaScriptActionsIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsLaunchActions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LaunchActions"));
	}

	@Override
	public Boolean getLaunchActionsHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LaunchActions"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getLaunchActionsIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LaunchActions"));
		if (object == null || object.empty()) {
			return getLaunchActionsIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getLaunchActionsIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsMovieActions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MovieActions"));
	}

	@Override
	public Boolean getMovieActionsHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MovieActions"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getMovieActionsIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MovieActions"));
		if (object == null || object.empty()) {
			return getMovieActionsIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getMovieActionsIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsNonEmbeddedFonts() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NonEmbeddedFonts"));
	}

	@Override
	public Boolean getNonEmbeddedFontsHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NonEmbeddedFonts"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getNonEmbeddedFontsIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NonEmbeddedFonts"));
		if (object == null || object.empty()) {
			return getNonEmbeddedFontsIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getNonEmbeddedFontsIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsOptionalContent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OptionalContent"));
	}

	@Override
	public Boolean getOptionalContentHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OptionalContent"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsSoundActions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SoundActions"));
	}

	@Override
	public Boolean getSoundActionsHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SoundActions"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getSoundActionsIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SoundActions"));
		if (object == null || object.empty()) {
			return getSoundActionsIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getSoundActionsIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsTrueTypeFonts() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TrueTypeFonts"));
	}

	@Override
	public Boolean getTrueTypeFontsHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TrueTypeFonts"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getTrueTypeFontsIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TrueTypeFonts"));
		if (object == null || object.empty()) {
			return getTrueTypeFontsIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getTrueTypeFontsIntegerDefaultValue() {
		return null;
	}

	@Override
	public Boolean getcontainsURIActions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("URIActions"));
	}

	@Override
	public Boolean getURIActionsHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URIActions"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getURIActionsIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URIActions"));
		if (object == null || object.empty()) {
			return getURIActionsIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getURIActionsIntegerDefaultValue() {
		return null;
	}

}
