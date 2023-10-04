package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.PDNameTreeNode;
import org.verapdf.as.ASAtom;
import java.util.stream.Collectors;
import org.verapdf.pd.structure.PDNumberTreeNode;

public class GFALegalAttestation extends GFAObject implements ALegalAttestation {

	public GFALegalAttestation(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ALegalAttestation");
	}

	@Override
	public Boolean getcontainsAlternateImages() {
		return this.baseObject.knownKey(ASAtom.getASAtom("AlternateImages"));
	}

	public COSObject getAlternateImagesValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("AlternateImages"));
		return object;
	}

	@Override
	public Boolean getAlternateImagesHasTypeInteger() {
		COSObject AlternateImages = getAlternateImagesValue();
		return getHasTypeInteger(AlternateImages);
	}

	@Override
	public Long getAlternateImagesIntegerValue() {
		COSObject AlternateImages = getAlternateImagesValue();
		return getIntegerValue(AlternateImages);
	}

	@Override
	public Boolean getcontainsAnnotations() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Annotations"));
	}

	public COSObject getAnnotationsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Annotations"));
		return object;
	}

	@Override
	public Boolean getAnnotationsHasTypeInteger() {
		COSObject Annotations = getAnnotationsValue();
		return getHasTypeInteger(Annotations);
	}

	@Override
	public Long getAnnotationsIntegerValue() {
		COSObject Annotations = getAnnotationsValue();
		return getIntegerValue(Annotations);
	}

	@Override
	public Boolean getcontainsAttestation() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Attestation"));
	}

	public COSObject getAttestationValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Attestation"));
		return object;
	}

	@Override
	public Boolean getAttestationHasTypeStringText() {
		COSObject Attestation = getAttestationValue();
		return getHasTypeStringText(Attestation);
	}

	@Override
	public Boolean getcontainsDevDepGS_BG() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DevDepGS_BG"));
	}

	public COSObject getDevDepGS_BGValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DevDepGS_BG"));
		return object;
	}

	@Override
	public Boolean getDevDepGS_BGHasTypeInteger() {
		COSObject DevDepGS_BG = getDevDepGS_BGValue();
		return getHasTypeInteger(DevDepGS_BG);
	}

	@Override
	public Long getDevDepGS_BGIntegerValue() {
		COSObject DevDepGS_BG = getDevDepGS_BGValue();
		return getIntegerValue(DevDepGS_BG);
	}

	@Override
	public Boolean getcontainsDevDepGS_FL() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DevDepGS_FL"));
	}

	public COSObject getDevDepGS_FLValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DevDepGS_FL"));
		return object;
	}

	@Override
	public Boolean getDevDepGS_FLHasTypeInteger() {
		COSObject DevDepGS_FL = getDevDepGS_FLValue();
		return getHasTypeInteger(DevDepGS_FL);
	}

	@Override
	public Long getDevDepGS_FLIntegerValue() {
		COSObject DevDepGS_FL = getDevDepGS_FLValue();
		return getIntegerValue(DevDepGS_FL);
	}

	@Override
	public Boolean getcontainsDevDepGS_HT() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DevDepGS_HT"));
	}

	public COSObject getDevDepGS_HTValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DevDepGS_HT"));
		return object;
	}

	@Override
	public Boolean getDevDepGS_HTHasTypeInteger() {
		COSObject DevDepGS_HT = getDevDepGS_HTValue();
		return getHasTypeInteger(DevDepGS_HT);
	}

	@Override
	public Long getDevDepGS_HTIntegerValue() {
		COSObject DevDepGS_HT = getDevDepGS_HTValue();
		return getIntegerValue(DevDepGS_HT);
	}

	@Override
	public Boolean getcontainsDevDepGS_OP() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DevDepGS_OP"));
	}

	public COSObject getDevDepGS_OPValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DevDepGS_OP"));
		return object;
	}

	@Override
	public Boolean getDevDepGS_OPHasTypeInteger() {
		COSObject DevDepGS_OP = getDevDepGS_OPValue();
		return getHasTypeInteger(DevDepGS_OP);
	}

	@Override
	public Long getDevDepGS_OPIntegerValue() {
		COSObject DevDepGS_OP = getDevDepGS_OPValue();
		return getIntegerValue(DevDepGS_OP);
	}

	@Override
	public Boolean getcontainsDevDepGS_TR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DevDepGS_TR"));
	}

	public COSObject getDevDepGS_TRValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DevDepGS_TR"));
		return object;
	}

	@Override
	public Boolean getDevDepGS_TRHasTypeInteger() {
		COSObject DevDepGS_TR = getDevDepGS_TRValue();
		return getHasTypeInteger(DevDepGS_TR);
	}

	@Override
	public Long getDevDepGS_TRIntegerValue() {
		COSObject DevDepGS_TR = getDevDepGS_TRValue();
		return getIntegerValue(DevDepGS_TR);
	}

	@Override
	public Boolean getcontainsDevDepGS_UCR() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DevDepGS_UCR"));
	}

	public COSObject getDevDepGS_UCRValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DevDepGS_UCR"));
		return object;
	}

	@Override
	public Boolean getDevDepGS_UCRHasTypeInteger() {
		COSObject DevDepGS_UCR = getDevDepGS_UCRValue();
		return getHasTypeInteger(DevDepGS_UCR);
	}

	@Override
	public Long getDevDepGS_UCRIntegerValue() {
		COSObject DevDepGS_UCR = getDevDepGS_UCRValue();
		return getIntegerValue(DevDepGS_UCR);
	}

	@Override
	public Boolean getcontainsExternalOPIdicts() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ExternalOPIdicts"));
	}

	public COSObject getExternalOPIdictsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExternalOPIdicts"));
		return object;
	}

	@Override
	public Boolean getExternalOPIdictsHasTypeInteger() {
		COSObject ExternalOPIdicts = getExternalOPIdictsValue();
		return getHasTypeInteger(ExternalOPIdicts);
	}

	@Override
	public Long getExternalOPIdictsIntegerValue() {
		COSObject ExternalOPIdicts = getExternalOPIdictsValue();
		return getIntegerValue(ExternalOPIdicts);
	}

	@Override
	public Boolean getcontainsExternalRefXobjects() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ExternalRefXobjects"));
	}

	public COSObject getExternalRefXobjectsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExternalRefXobjects"));
		return object;
	}

	@Override
	public Boolean getExternalRefXobjectsHasTypeInteger() {
		COSObject ExternalRefXobjects = getExternalRefXobjectsValue();
		return getHasTypeInteger(ExternalRefXobjects);
	}

	@Override
	public Long getExternalRefXobjectsIntegerValue() {
		COSObject ExternalRefXobjects = getExternalRefXobjectsValue();
		return getIntegerValue(ExternalRefXobjects);
	}

	@Override
	public Boolean getcontainsExternalStreams() {
		return this.baseObject.knownKey(ASAtom.getASAtom("ExternalStreams"));
	}

	public COSObject getExternalStreamsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("ExternalStreams"));
		return object;
	}

	@Override
	public Boolean getExternalStreamsHasTypeInteger() {
		COSObject ExternalStreams = getExternalStreamsValue();
		return getHasTypeInteger(ExternalStreams);
	}

	@Override
	public Long getExternalStreamsIntegerValue() {
		COSObject ExternalStreams = getExternalStreamsValue();
		return getIntegerValue(ExternalStreams);
	}

	@Override
	public Boolean getcontainsGoToRemoteActions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("GoToRemoteActions"));
	}

	public COSObject getGoToRemoteActionsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("GoToRemoteActions"));
		return object;
	}

	@Override
	public Boolean getGoToRemoteActionsHasTypeInteger() {
		COSObject GoToRemoteActions = getGoToRemoteActionsValue();
		return getHasTypeInteger(GoToRemoteActions);
	}

	@Override
	public Long getGoToRemoteActionsIntegerValue() {
		COSObject GoToRemoteActions = getGoToRemoteActionsValue();
		return getIntegerValue(GoToRemoteActions);
	}

	@Override
	public Boolean getcontainsHideAnnotationActions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("HideAnnotationActions"));
	}

	public COSObject getHideAnnotationActionsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("HideAnnotationActions"));
		return object;
	}

	@Override
	public Boolean getHideAnnotationActionsHasTypeInteger() {
		COSObject HideAnnotationActions = getHideAnnotationActionsValue();
		return getHasTypeInteger(HideAnnotationActions);
	}

	@Override
	public Long getHideAnnotationActionsIntegerValue() {
		COSObject HideAnnotationActions = getHideAnnotationActionsValue();
		return getIntegerValue(HideAnnotationActions);
	}

	@Override
	public Boolean getcontainsJavaScriptActions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("JavaScriptActions"));
	}

	public COSObject getJavaScriptActionsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("JavaScriptActions"));
		return object;
	}

	@Override
	public Boolean getJavaScriptActionsHasTypeInteger() {
		COSObject JavaScriptActions = getJavaScriptActionsValue();
		return getHasTypeInteger(JavaScriptActions);
	}

	@Override
	public Long getJavaScriptActionsIntegerValue() {
		COSObject JavaScriptActions = getJavaScriptActionsValue();
		return getIntegerValue(JavaScriptActions);
	}

	@Override
	public Boolean getcontainsLaunchActions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("LaunchActions"));
	}

	public COSObject getLaunchActionsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("LaunchActions"));
		return object;
	}

	@Override
	public Boolean getLaunchActionsHasTypeInteger() {
		COSObject LaunchActions = getLaunchActionsValue();
		return getHasTypeInteger(LaunchActions);
	}

	@Override
	public Long getLaunchActionsIntegerValue() {
		COSObject LaunchActions = getLaunchActionsValue();
		return getIntegerValue(LaunchActions);
	}

	@Override
	public Boolean getcontainsMovieActions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("MovieActions"));
	}

	public COSObject getMovieActionsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("MovieActions"));
		return object;
	}

	@Override
	public Boolean getMovieActionsHasTypeInteger() {
		COSObject MovieActions = getMovieActionsValue();
		return getHasTypeInteger(MovieActions);
	}

	@Override
	public Long getMovieActionsIntegerValue() {
		COSObject MovieActions = getMovieActionsValue();
		return getIntegerValue(MovieActions);
	}

	@Override
	public Boolean getcontainsNonEmbeddedFonts() {
		return this.baseObject.knownKey(ASAtom.getASAtom("NonEmbeddedFonts"));
	}

	public COSObject getNonEmbeddedFontsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("NonEmbeddedFonts"));
		return object;
	}

	@Override
	public Boolean getNonEmbeddedFontsHasTypeInteger() {
		COSObject NonEmbeddedFonts = getNonEmbeddedFontsValue();
		return getHasTypeInteger(NonEmbeddedFonts);
	}

	@Override
	public Long getNonEmbeddedFontsIntegerValue() {
		COSObject NonEmbeddedFonts = getNonEmbeddedFontsValue();
		return getIntegerValue(NonEmbeddedFonts);
	}

	@Override
	public Boolean getcontainsOptionalContent() {
		return this.baseObject.knownKey(ASAtom.getASAtom("OptionalContent"));
	}

	public COSObject getOptionalContentValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("OptionalContent"));
		return object;
	}

	@Override
	public Boolean getOptionalContentHasTypeBoolean() {
		COSObject OptionalContent = getOptionalContentValue();
		return getHasTypeBoolean(OptionalContent);
	}

	@Override
	public Boolean getcontainsSoundActions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("SoundActions"));
	}

	public COSObject getSoundActionsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("SoundActions"));
		return object;
	}

	@Override
	public Boolean getSoundActionsHasTypeInteger() {
		COSObject SoundActions = getSoundActionsValue();
		return getHasTypeInteger(SoundActions);
	}

	@Override
	public Long getSoundActionsIntegerValue() {
		COSObject SoundActions = getSoundActionsValue();
		return getIntegerValue(SoundActions);
	}

	@Override
	public Boolean getcontainsTrueTypeFonts() {
		return this.baseObject.knownKey(ASAtom.getASAtom("TrueTypeFonts"));
	}

	public COSObject getTrueTypeFontsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("TrueTypeFonts"));
		return object;
	}

	@Override
	public Boolean getTrueTypeFontsHasTypeInteger() {
		COSObject TrueTypeFonts = getTrueTypeFontsValue();
		return getHasTypeInteger(TrueTypeFonts);
	}

	@Override
	public Long getTrueTypeFontsIntegerValue() {
		COSObject TrueTypeFonts = getTrueTypeFontsValue();
		return getIntegerValue(TrueTypeFonts);
	}

	@Override
	public Boolean getcontainsURIActions() {
		return this.baseObject.knownKey(ASAtom.getASAtom("URIActions"));
	}

	public COSObject getURIActionsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("URIActions"));
		return object;
	}

	@Override
	public Boolean getURIActionsHasTypeInteger() {
		COSObject URIActions = getURIActionsValue();
		return getHasTypeInteger(URIActions);
	}

	@Override
	public Long getURIActionsIntegerValue() {
		COSObject URIActions = getURIActionsValue();
		return getIntegerValue(URIActions);
	}

}
