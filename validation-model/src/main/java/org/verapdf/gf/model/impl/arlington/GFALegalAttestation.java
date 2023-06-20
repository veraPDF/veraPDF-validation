package org.verapdf.gf.model.impl.arlington;

import org.verapdf.cos.*;
import org.verapdf.model.alayer.*;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.tools.StaticResources;
import java.util.*;
import org.verapdf.pd.*;
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
		COSObject object = getAlternateImagesValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getAlternateImagesIntegerValue() {
		COSObject object = getAlternateImagesValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
		COSObject object = getAnnotationsValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getAnnotationsIntegerValue() {
		COSObject object = getAnnotationsValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
		COSObject object = getAttestationValue();
		return getHasTypeStringText(object);
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
		COSObject object = getDevDepGS_BGValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getDevDepGS_BGIntegerValue() {
		COSObject object = getDevDepGS_BGValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
		COSObject object = getDevDepGS_FLValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getDevDepGS_FLIntegerValue() {
		COSObject object = getDevDepGS_FLValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
		COSObject object = getDevDepGS_HTValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getDevDepGS_HTIntegerValue() {
		COSObject object = getDevDepGS_HTValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
		COSObject object = getDevDepGS_OPValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getDevDepGS_OPIntegerValue() {
		COSObject object = getDevDepGS_OPValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
		COSObject object = getDevDepGS_TRValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getDevDepGS_TRIntegerValue() {
		COSObject object = getDevDepGS_TRValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
		COSObject object = getDevDepGS_UCRValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getDevDepGS_UCRIntegerValue() {
		COSObject object = getDevDepGS_UCRValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
		COSObject object = getExternalOPIdictsValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getExternalOPIdictsIntegerValue() {
		COSObject object = getExternalOPIdictsValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
		COSObject object = getExternalRefXobjectsValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getExternalRefXobjectsIntegerValue() {
		COSObject object = getExternalRefXobjectsValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
		COSObject object = getExternalStreamsValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getExternalStreamsIntegerValue() {
		COSObject object = getExternalStreamsValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
		COSObject object = getGoToRemoteActionsValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getGoToRemoteActionsIntegerValue() {
		COSObject object = getGoToRemoteActionsValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
		COSObject object = getHideAnnotationActionsValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getHideAnnotationActionsIntegerValue() {
		COSObject object = getHideAnnotationActionsValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
		COSObject object = getJavaScriptActionsValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getJavaScriptActionsIntegerValue() {
		COSObject object = getJavaScriptActionsValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
		COSObject object = getLaunchActionsValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getLaunchActionsIntegerValue() {
		COSObject object = getLaunchActionsValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
		COSObject object = getMovieActionsValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getMovieActionsIntegerValue() {
		COSObject object = getMovieActionsValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
		COSObject object = getNonEmbeddedFontsValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getNonEmbeddedFontsIntegerValue() {
		COSObject object = getNonEmbeddedFontsValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
		COSObject object = getOptionalContentValue();
		return getHasTypeBoolean(object);
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
		COSObject object = getSoundActionsValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getSoundActionsIntegerValue() {
		COSObject object = getSoundActionsValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
		COSObject object = getTrueTypeFontsValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getTrueTypeFontsIntegerValue() {
		COSObject object = getTrueTypeFontsValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
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
		COSObject object = getURIActionsValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getURIActionsIntegerValue() {
		COSObject object = getURIActionsValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

}
