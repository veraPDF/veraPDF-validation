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

public class GFAViewParams extends GFAObject implements AViewParams {

	public GFAViewParams(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "AViewParams");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "Instance":
				return getInstance();
			case "Data":
				return getData();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<ARichMediaInstance> getInstance() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getInstance1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<ARichMediaInstance> getInstance1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Instance"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ARichMediaInstance> list = new ArrayList<>(1);
			list.add(new GFARichMediaInstance((COSDictionary)object.getDirectBase(), this.baseObject, "Instance"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AStream> getData() {
		switch(StaticContainers.getFlavour()) {
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getData1_7();
			default:
				return Collections.emptyList();
		}
	}

	private List<AStream> getData1_7() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Data"));
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AStream> list = new ArrayList<>(1);
			list.add(new GFAStream((COSStream)object.getDirectBase(), this.baseObject, "Data"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsData() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Data"));
	}

	@Override
	public Boolean getisDataIndirect() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Data"));
		return object != null && object.get() != null && object.get().isIndirect();
	}

	@Override
	public Boolean getDataHasTypeStringText() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Data"));
		return object != null && object.getType() == COSObjType.COS_STRING && ((COSString)object.getDirectBase()).isTextString();
	}

	@Override
	public Boolean getDataHasTypeStream() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Data"));
		return object != null && object.getType() == COSObjType.COS_STREAM;
	}

	@Override
	public Boolean getcontainsInstance() {
		return this.baseObject.knownKey(ASAtom.getASAtom("Instance"));
	}

	@Override
	public Boolean getInstanceHasTypeDictionary() {
		COSObject object = this.baseObject.getKey(ASAtom.getASAtom("Instance"));
		return object != null && object.getType() == COSObjType.COS_DICT;
	}

}
