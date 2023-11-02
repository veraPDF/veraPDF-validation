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

public class GFAFilterCrypt extends GFAObject implements AFilterCrypt {

	public GFAFilterCrypt(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFilterCrypt");
	}

	@Override
	public Boolean getcontainsName() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Name"));
	}

	public COSObject getNameDefaultValue() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return COSName.construct("Identity");
		}
		return null;
	}

	public COSObject getNameValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Name"));
		if (object == null || object.empty()) {
			object = getNameDefaultValue();
		}
		return object;
	}

	@Override
	public String getNameType() {
		COSObject Name = getNameValue();
		return getObjectType(Name);
	}

	@Override
	public Boolean getNameHasTypeName() {
		COSObject Name = getNameValue();
		return getHasTypeName(Name);
	}

	@Override
	public String getNameNameValue() {
		COSObject Name = getNameValue();
		return getNameValue(Name);
	}

	@Override
	public Boolean getcontainsType() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Type"));
	}

	public COSObject getTypeValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Type"));
		return object;
	}

	@Override
	public String getTypeType() {
		COSObject Type = getTypeValue();
		return getObjectType(Type);
	}

	@Override
	public Boolean getTypeHasTypeName() {
		COSObject Type = getTypeValue();
		return getHasTypeName(Type);
	}

	@Override
	public String getTypeNameValue() {
		COSObject Type = getTypeValue();
		return getNameValue(Type);
	}

	public COSObject gettrailerEncryptCFValue() {
		COSObject trailer = StaticResources.getDocument().getDocument().getTrailer().getObject();
		if (trailer == null || !trailer.getType().isDictionaryBased()) {
			return null;
		}
		COSObject Encrypt = trailer.getKey(ASAtom.getASAtom("Encrypt"));
		if (Encrypt == null || !Encrypt.getType().isDictionaryBased()) {
			return null;
		}
		COSObject CF = Encrypt.getKey(ASAtom.getASAtom("CF"));
		return CF;
	}

	@Override
	public String getkeysStringtrailerEncryptCF() {
		COSObject trailerEncryptCF = gettrailerEncryptCFValue();
		return getkeysString(trailerEncryptCF);
	}

}
