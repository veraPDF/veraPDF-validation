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

public class GFADocument extends GFAObject implements ADocument {

	public GFADocument(COSBase baseObject, COSBase parentObject, String keyName) {
		super(baseObject, parentObject, keyName, "ADocument");
	}

	@Override
	public List<? extends org.verapdf.model.baselayer.Object> getLinkedObjects(String link) {
		switch (link) {
			case "FileTrailer":
				return getFileTrailer();
			case "LinearizationParameterDict":
				return getLinearizationParameterDict();
			case "ObjectStreams":
				return getObjectStreams();
			case "XRefStream":
				return getXRefStream();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<AFileTrailer> getFileTrailer() {
		return getFileTrailer1_0();
	}

	private List<AFileTrailer> getFileTrailer1_0() {
		COSObject object = getFileTrailerValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<AFileTrailer> list = new ArrayList<>(1);
			list.add(new GFAFileTrailer((COSDictionary)object.getDirectBase(), this.baseObject, "FileTrailer"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<ALinearizationParameterDict> getLinearizationParameterDict() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_2:
			case ARLINGTON1_3:
			case ARLINGTON1_4:
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getLinearizationParameterDict1_2();
			default:
				return Collections.emptyList();
		}
	}

	private List<ALinearizationParameterDict> getLinearizationParameterDict1_2() {
		COSObject object = getLinearizationParameterDictValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_DICT) {
			List<ALinearizationParameterDict> list = new ArrayList<>(1);
			list.add(new GFALinearizationParameterDict((COSDictionary)object.getDirectBase(), this.baseObject, "LinearizationParameterDict"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AArrayOfObjectStreams> getObjectStreams() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getObjectStreams1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AArrayOfObjectStreams> getObjectStreams1_5() {
		COSObject object = getObjectStreamsValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_ARRAY) {
			List<AArrayOfObjectStreams> list = new ArrayList<>(1);
			list.add(new GFAArrayOfObjectStreams((COSArray)object.getDirectBase(), this.baseObject, "ObjectStreams"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	private List<AXRefStream> getXRefStream() {
		switch (StaticContainers.getFlavour()) {
			case ARLINGTON1_5:
			case ARLINGTON1_6:
			case ARLINGTON1_7:
			case ARLINGTON2_0:
				return getXRefStream1_5();
			default:
				return Collections.emptyList();
		}
	}

	private List<AXRefStream> getXRefStream1_5() {
		COSObject object = getXRefStreamValue();
		if (object == null) {
			return Collections.emptyList();
		}
		if (object.getType() == COSObjType.COS_STREAM) {
			List<AXRefStream> list = new ArrayList<>(1);
			list.add(new GFAXRefStream((COSStream)object.getDirectBase(), this.baseObject, "XRefStream"));
			return Collections.unmodifiableList(list);
		}
		return Collections.emptyList();
	}

	@Override
	public Boolean getcontainsFileTrailer() {
		return getFileTrailerValue() != null;
	}

	public COSObject getFileTrailerValue() {
		if (StaticResources.getDocument().getDocument().getLastXRefStream() != null) {
			return null;
		}
		COSObject object = StaticResources.getDocument().getDocument().getTrailer().getObject();
		return object;
	}

	@Override
	public String getFileTrailerType() {
		COSObject FileTrailer = getFileTrailerValue();
		return getObjectType(FileTrailer);
	}

	@Override
	public Boolean getFileTrailerHasTypeDictionary() {
		COSObject FileTrailer = getFileTrailerValue();
		return getHasTypeDictionary(FileTrailer);
	}

	@Override
	public Boolean getcontainsLinearizationParameterDict() {
		return getLinearizationParameterDictValue() != null;
	}

	public COSObject getLinearizationParameterDictValue() {
		COSObject object = StaticResources.getDocument().getDocument().getLinearizationDictionary();
		return object;
	}

	@Override
	public Boolean getcontainsObjectStreams() {
		return getObjectStreamsValue() != null;
	}

	public COSObject getObjectStreamsValue() {
		List<COSObject> objectStreamsList = StaticResources.getDocument().getDocument().getObjectStreamsList();
		COSObject object = objectStreamsList.isEmpty() ? null : new COSObject(new COSArray(objectStreamsList));
		return object;
	}

	@Override
	public Boolean getcontainsXRefStream() {
		return getXRefStreamValue() != null;
	}

	public COSObject getXRefStreamValue() {
		COSObject object = StaticResources.getDocument().getDocument().getLastXRefStream();
		return object;
	}

	@Override
	public String getXRefStreamType() {
		COSObject XRefStream = getXRefStreamValue();
		return getObjectType(XRefStream);
	}

	@Override
	public Boolean getXRefStreamHasTypeStream() {
		COSObject XRefStream = getXRefStreamValue();
		return getHasTypeStream(XRefStream);
	}

}
