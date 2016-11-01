package org.verapdf.gf.model.impl.pd;

import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDStructElem;
import org.verapdf.model.pdlayer.PDStructTreeRoot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maksim Bezrukov
 */
public class GFPDStructTreeRoot extends GFPDObject implements PDStructTreeRoot {

	/** Type name for {@code PBoxPDStructTreeRoot} */
	public static final String STRUCT_TREE_ROOT_TYPE = "PDStructTreeRoot";

	/** Link name for {@code K} key */
	public static final String CHILDREN = "K";

	private List<PDStructElem> children = null;

	/**
	 * Default constructor
	 *
	 * @param treeRoot structure tree root implementation
	 */
	public GFPDStructTreeRoot(org.verapdf.pd.PDStructTreeRoot treeRoot) {
		super(treeRoot, STRUCT_TREE_ROOT_TYPE);
		StaticContainers.setRoleMapHelper(treeRoot.getRoleMap());
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		if (CHILDREN.equals(link)) {
			return this.getChildren();
		}
		return super.getLinkedObjects(link);
	}

	private List<PDStructElem> getChildren() {
		if (this.children == null) {
			this.children = parseChildren();
		}
		return this.children;
	}

	private List<PDStructElem> parseChildren() {
		List<org.verapdf.pd.PDStructElem> elements = ((org.verapdf.pd.PDStructTreeRoot) simplePDObject).getChildren();
		if (!elements.isEmpty()) {
			List<PDStructElem> res = new ArrayList<>(elements.size());
			for (org.verapdf.pd.PDStructElem element : elements) {
				res.add(new GFPDStructElem(element));
			}
			return Collections.unmodifiableList(res);
		}
		return Collections.emptyList();
	}

	@Override
	public String gettopLevelFirstElementStandartType() {
		if (this.children == null) {
			this.children = parseChildren();
		}

		if (!this.children.isEmpty()) {
			return this.children.get(0).getstandardType();
		}
		return null;
	}
}
