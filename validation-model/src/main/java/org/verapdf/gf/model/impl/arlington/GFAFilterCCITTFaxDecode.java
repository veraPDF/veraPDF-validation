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
import java.io.IOException;

public class GFAFilterCCITTFaxDecode extends GFAObject implements AFilterCCITTFaxDecode {

	public GFAFilterCCITTFaxDecode(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AFilterCCITTFaxDecode");
	}

	@Override
	public Boolean getcontainsEncodedByteAlign() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EncodedByteAlign"));
	}

	@Override
	public Boolean getEncodedByteAlignHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EncodedByteAlign"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsBlackIs1() {
		return this.baseObject.knownKey(ASAtom.getASAtom("BlackIs1"));
	}

	@Override
	public Boolean getBlackIs1HasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("BlackIs1"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsK() {
		return this.baseObject.knownKey(ASAtom.getASAtom("K"));
	}

	@Override
	public Boolean getKHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("K"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getKIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("K"));
		if (object == null || object.empty()) {
			return getKIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getKIntegerDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 0L;
		}
		return null;
	}

	@Override
	public Boolean getcontainsEndOfLine() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EndOfLine"));
	}

	@Override
	public Boolean getEndOfLineHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EndOfLine"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getEndOfLineBooleanValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EndOfLine"));
		if (object == null || object.empty()) {
			return getEndOfLineBooleanDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_BOOLEAN) {
			return object.getBoolean();
		}
		return null;
	}

	public Boolean getEndOfLineBooleanDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return false;
		}
		return null;
	}

	@Override
	public Boolean getcontainsRows() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Rows"));
	}

	@Override
	public Boolean getRowsHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Rows"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getRowsIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Rows"));
		if (object == null || object.empty()) {
			return getRowsIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getRowsIntegerDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 0L;
		}
		return null;
	}

	@Override
	public Boolean getcontainsColumns() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Columns"));
	}

	@Override
	public Boolean getColumnsHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Columns"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getColumnsIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Columns"));
		if (object == null || object.empty()) {
			return getColumnsIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getColumnsIntegerDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 1728L;
		}
		return null;
	}

	@Override
	public Boolean getcontainsBlackls1() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Blackls1"));
	}

	@Override
	public Boolean getBlackls1HasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Blackls1"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

	@Override
	public Boolean getcontainsDamagedRowsBeforeError() {
		return this.baseObject.knownKey(ASAtom.getASAtom("DamagedRowsBeforeError"));
	}

	@Override
	public Boolean getDamagedRowsBeforeErrorHasTypeInteger() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DamagedRowsBeforeError"));
		return object != null && object.getType() == COSObjType.COS_INTEGER;
	}

	@Override
	public Long getDamagedRowsBeforeErrorIntegerValue() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("DamagedRowsBeforeError"));
		if (object == null || object.empty()) {
			return getDamagedRowsBeforeErrorIntegerDefaultValue();
		}
		if (object != null && object.getType() == COSObjType.COS_INTEGER) {
			return object.getInteger();
		}
		return null;
	}

	public Long getDamagedRowsBeforeErrorIntegerDefaultValue() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_0:
			case ARLINGTON1_1:
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return 0L;
		}
		return null;
	}

	@Override
	public Boolean getcontainsEndOfBlock() {
		return this.baseObject.knownKey(ASAtom.getASAtom("EndOfBlock"));
	}

	@Override
	public Boolean getEndOfBlockHasTypeBoolean() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("EndOfBlock"));
		return object != null && object.getType() == COSObjType.COS_BOOLEAN;
	}

}
