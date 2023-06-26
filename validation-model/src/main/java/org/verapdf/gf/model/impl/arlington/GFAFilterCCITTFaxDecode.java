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

public class GFAFilterCCITTFaxDecode extends GFAObject implements AFilterCCITTFaxDecode {

	public GFAFilterCCITTFaxDecode(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFilterCCITTFaxDecode");
	}

	@Override
	public Boolean getcontainsBlackIs1() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BlackIs1"));
	}

	public COSObject getBlackIs1DefaultValue() {
		return COSBoolean.construct(false);
	}

	public COSObject getBlackIs1Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BlackIs1"));
		if (object == null || object.empty()) {
			object = getBlackIs1DefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getBlackIs1HasTypeBoolean() {
		COSObject object = getBlackIs1Value();
		return getHasTypeBoolean(object);
	}

	@Override
	public Boolean getcontainsBlackls1() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Blackls1"));
	}

	public COSObject getBlackls1DefaultValue() {
		return COSBoolean.construct(false);
	}

	public COSObject getBlackls1Value() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Blackls1"));
		if (object == null || object.empty()) {
			object = getBlackls1DefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getBlackls1HasTypeBoolean() {
		COSObject object = getBlackls1Value();
		return getHasTypeBoolean(object);
	}

	@Override
	public Boolean getcontainsColumns() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Columns"));
	}

	public COSObject getColumnsDefaultValue() {
		return COSInteger.construct(1728L);
	}

	public COSObject getColumnsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Columns"));
		if (object == null || object.empty()) {
			object = getColumnsDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getColumnsHasTypeInteger() {
		COSObject object = getColumnsValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getColumnsIntegerValue() {
		COSObject object = getColumnsValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsDamagedRowsBeforeError() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DamagedRowsBeforeError"));
	}

	public COSObject getDamagedRowsBeforeErrorDefaultValue() {
		return COSInteger.construct(0L);
	}

	public COSObject getDamagedRowsBeforeErrorValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DamagedRowsBeforeError"));
		if (object == null || object.empty()) {
			object = getDamagedRowsBeforeErrorDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getDamagedRowsBeforeErrorHasTypeInteger() {
		COSObject object = getDamagedRowsBeforeErrorValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getDamagedRowsBeforeErrorIntegerValue() {
		COSObject object = getDamagedRowsBeforeErrorValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsEncodedByteAlign() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EncodedByteAlign"));
	}

	public COSObject getEncodedByteAlignDefaultValue() {
		return COSBoolean.construct(false);
	}

	public COSObject getEncodedByteAlignValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EncodedByteAlign"));
		if (object == null || object.empty()) {
			object = getEncodedByteAlignDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getEncodedByteAlignHasTypeBoolean() {
		COSObject object = getEncodedByteAlignValue();
		return getHasTypeBoolean(object);
	}

	@Override
	public Boolean getcontainsEndOfBlock() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EndOfBlock"));
	}

	public COSObject getEndOfBlockDefaultValue() {
		return COSBoolean.construct(true);
	}

	public COSObject getEndOfBlockValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EndOfBlock"));
		if (object == null || object.empty()) {
			object = getEndOfBlockDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getEndOfBlockHasTypeBoolean() {
		COSObject object = getEndOfBlockValue();
		return getHasTypeBoolean(object);
	}

	@Override
	public Boolean getcontainsEndOfLine() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EndOfLine"));
	}

	public COSObject getEndOfLineDefaultValue() {
		return COSBoolean.construct(false);
	}

	public COSObject getEndOfLineValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EndOfLine"));
		if (object == null || object.empty()) {
			object = getEndOfLineDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getEndOfLineHasTypeBoolean() {
		COSObject object = getEndOfLineValue();
		return getHasTypeBoolean(object);
	}

	@Override
	public Boolean getEndOfLineBooleanValue() {
		COSObject object = getEndOfLineValue();
		if (object != null && object.getType() == COSObjType.COS_BOOLEAN) {
			return object.getBoolean();
		}
		return null;
	}

	@Override
	public Boolean getcontainsK() {
		return this.baseObject.knownKey(ASAtom.getASAtom("K"));
	}

	public COSObject getKDefaultValue() {
		return COSInteger.construct(0L);
	}

	public COSObject getKValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("K"));
		if (object == null || object.empty()) {
			object = getKDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getKHasTypeInteger() {
		COSObject object = getKValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getKIntegerValue() {
		COSObject object = getKValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean getcontainsRows() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Rows"));
	}

	public COSObject getRowsDefaultValue() {
		return COSInteger.construct(0L);
	}

	public COSObject getRowsValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Rows"));
		if (object == null || object.empty()) {
			object = getRowsDefaultValue();
		}
		return object;
	}

	@Override
	public Boolean getRowsHasTypeInteger() {
		COSObject object = getRowsValue();
		return getHasTypeInteger(object);
	}

	@Override
	public Long getRowsIntegerValue() {
		COSObject object = getRowsValue();
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	@Override
	public Boolean gethasExtensionMalforms() {
		return false;
	}

}
