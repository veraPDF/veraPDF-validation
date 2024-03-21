/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.impl.operator.markedcontent;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSBase;
import org.verapdf.cos.COSKey;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.operator.Op_BDC;
import org.verapdf.pd.structure.PDNumberTreeNode;
import org.verapdf.pd.structure.PDStructTreeRoot;
import org.verapdf.pd.structure.StructureElementAccessObject;
import org.verapdf.tools.StaticResources;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Timur Kamalov
 */
public class GFOp_BDC extends GFOpMarkedContent implements Op_BDC {

	private static final Logger LOGGER = Logger.getLogger(GFOp_BDC.class.getCanonicalName());

	/** Type name for {@code GFOp_BDC} */
    public static final String OP_BDC_TYPE = "Op_BDC";
	public final StructureElementAccessObject structureElementAccessObject;


    public GFOp_BDC(List<COSBase> arguments, PDResourcesHandler resources, GFOpMarkedContent markedContent,
					StructureElementAccessObject structureElementAccessObject, String parentsTags, boolean isRealContent) {
		super(arguments, OP_BDC_TYPE, markedContent, parentsTags, isRealContent);
		initializePropertiesDict(resources);
		this.structureElementAccessObject = structureElementAccessObject;
    }

	@Override
	public List<? extends Object> getLinkedObjects(
			String link) {
		switch (link) {
			case TAG:
				return this.getLinkTag();
			case PROPERTIES:
				return this.getPropertiesDict();
			case LANG:
				return this.getLinkLang();
			default:
				return super.getLinkedObjects(link);
		}
	}

	@Override
	public COSObject getParentStructElem() {
		COSObject structElem = getStructElem();
		return structElem != null ? structElem : super.getParentStructElem();
	}

	private COSObject getStructElem() {
		Long mcid = getMCID();
		PDStructTreeRoot structTreeRoot = StaticResources.getDocument().getStructTreeRoot();
		if (structTreeRoot != null && mcid != null) {
			PDNumberTreeNode parentTreeRoot = structTreeRoot.getParentTree();
			COSObject structureElement = parentTreeRoot == null ? null : structureElementAccessObject.getStructureElement(parentTreeRoot, mcid);
			if (structureElement != null && !structureElement.empty() && structureElement.getType() != COSObjType.COS_NULL) {
				return structureElement;
			}
		}
		return null;
	}

	@Override
	public String getStructParentLang() {
		COSObject structureElement = getStructElem();
		if (structureElement == null) {
			return null;
		}
		String baseLang = structureElement.getStringKey(ASAtom.LANG);
		COSObject parent = structureElement.getKey(ASAtom.P);
		Set<COSKey> keys = new HashSet<>();
		while (baseLang == null && parent != null) {
			COSKey key = parent.getObjectKey();
			if (keys.contains(key)) {
				LOGGER.log(Level.WARNING, "Struct tree loop found");
				break;
			}
			if (key != null) {
				keys.add(key);
			}
			baseLang = parent.getStringKey(ASAtom.LANG);
			parent = parent.getKey(ASAtom.P);
		}
		return baseLang;
	}

}
