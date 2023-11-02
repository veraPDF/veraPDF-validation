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
	public String getBlackIs1Type() {
		COSObject BlackIs1 = getBlackIs1Value();
		return getObjectType(BlackIs1);
	}

	@Override
	public Boolean getBlackIs1HasTypeBoolean() {
		COSObject BlackIs1 = getBlackIs1Value();
		return getHasTypeBoolean(BlackIs1);
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
	public String getBlackls1Type() {
		COSObject Blackls1 = getBlackls1Value();
		return getObjectType(Blackls1);
	}

	@Override
	public Boolean getBlackls1HasTypeBoolean() {
		COSObject Blackls1 = getBlackls1Value();
		return getHasTypeBoolean(Blackls1);
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
	public String getColumnsType() {
		COSObject Columns = getColumnsValue();
		return getObjectType(Columns);
	}

	@Override
	public Boolean getColumnsHasTypeInteger() {
		COSObject Columns = getColumnsValue();
		return getHasTypeInteger(Columns);
	}

	@Override
	public Long getColumnsIntegerValue() {
		COSObject Columns = getColumnsValue();
		return getIntegerValue(Columns);
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
	public String getDamagedRowsBeforeErrorType() {
		COSObject DamagedRowsBeforeError = getDamagedRowsBeforeErrorValue();
		return getObjectType(DamagedRowsBeforeError);
	}

	@Override
	public Boolean getDamagedRowsBeforeErrorHasTypeInteger() {
		COSObject DamagedRowsBeforeError = getDamagedRowsBeforeErrorValue();
		return getHasTypeInteger(DamagedRowsBeforeError);
	}

	@Override
	public Long getDamagedRowsBeforeErrorIntegerValue() {
		COSObject DamagedRowsBeforeError = getDamagedRowsBeforeErrorValue();
		return getIntegerValue(DamagedRowsBeforeError);
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
	public String getEncodedByteAlignType() {
		COSObject EncodedByteAlign = getEncodedByteAlignValue();
		return getObjectType(EncodedByteAlign);
	}

	@Override
	public Boolean getEncodedByteAlignHasTypeBoolean() {
		COSObject EncodedByteAlign = getEncodedByteAlignValue();
		return getHasTypeBoolean(EncodedByteAlign);
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
	public String getEndOfBlockType() {
		COSObject EndOfBlock = getEndOfBlockValue();
		return getObjectType(EndOfBlock);
	}

	@Override
	public Boolean getEndOfBlockHasTypeBoolean() {
		COSObject EndOfBlock = getEndOfBlockValue();
		return getHasTypeBoolean(EndOfBlock);
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
	public String getEndOfLineType() {
		COSObject EndOfLine = getEndOfLineValue();
		return getObjectType(EndOfLine);
	}

	@Override
	public Boolean getEndOfLineHasTypeBoolean() {
		COSObject EndOfLine = getEndOfLineValue();
		return getHasTypeBoolean(EndOfLine);
	}

	@Override
	public Boolean getEndOfLineBooleanValue() {
		COSObject EndOfLine = getEndOfLineValue();
		return getBooleanValue(EndOfLine);
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
	public String getKType() {
		COSObject K = getKValue();
		return getObjectType(K);
	}

	@Override
	public Boolean getKHasTypeInteger() {
		COSObject K = getKValue();
		return getHasTypeInteger(K);
	}

	@Override
	public Long getKIntegerValue() {
		COSObject K = getKValue();
		return getIntegerValue(K);
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
	public String getRowsType() {
		COSObject Rows = getRowsValue();
		return getObjectType(Rows);
	}

	@Override
	public Boolean getRowsHasTypeInteger() {
		COSObject Rows = getRowsValue();
		return getHasTypeInteger(Rows);
	}

	@Override
	public Long getRowsIntegerValue() {
		COSObject Rows = getRowsValue();
		return getIntegerValue(Rows);
	}

	@Override
	public Boolean gethasExtensionMalforms() {
		return false;
	}

}
