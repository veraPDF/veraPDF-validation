/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2025, veraPDF Consortium <info@verapdf.org>
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
package org.verapdf.gf.model.impl.pd.annotations;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSKey;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.gf.model.impl.containers.StaticContainers;
import org.verapdf.gf.model.impl.pd.GFPDAnnot;
import org.verapdf.gf.model.impl.pd.GFPDDestination;
import org.verapdf.gf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDDestination;
import org.verapdf.model.pdlayer.PDLinkAnnot;
import org.verapdf.pd.PDAnnotation;
import org.verapdf.pd.PDNameTreeNode;
import org.verapdf.pd.PDNamesDictionary;
import org.verapdf.pd.PDPage;
import org.verapdf.pd.actions.PDAction;
import org.verapdf.pdfa.flavours.PDFFlavours;
import org.verapdf.tools.StaticResources;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Maxim Plushchov
 */
public class GFPDLinkAnnot extends GFPDAnnot implements PDLinkAnnot {

	public static final Logger LOGGER = Logger.getLogger(GFPDLinkAnnot.class.getCanonicalName());

	public static final String LINK_ANNOTATION_TYPE = "PDLinkAnnot";

	public static final String DEST = "Dest";
	
	private String differentTargetAnnotObjectKey;
	private String sameTargetAnnotObjectKey;

	public GFPDLinkAnnot(PDAnnotation annot, PDResourcesHandler pageResources, PDPage page) {
		super(annot, pageResources, page, LINK_ANNOTATION_TYPE);
		if (PDFFlavours.isPDFUA2RelatedFlavour(StaticContainers.getFlavour())) {
			calculateStructDestinationProperties();
		}
	}

	@Override
	public List<? extends Object> getLinkedObjects(String link) {
		switch (link) {
			case DEST:
				return this.getDestination();
			default:
				return super.getLinkedObjects(link);
		}
	}

	private List<PDDestination> getDestination() {
		COSObject destination = ((PDAnnotation) simplePDObject).getDestination();
		if (!destination.empty() && !simplePDObject.knownKey(ASAtom.A)) {
			List<PDDestination> destinations = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
			destinations.add(new GFPDDestination(new org.verapdf.pd.PDDestination(destination)));
			return Collections.unmodifiableList(destinations);
		}
		return Collections.emptyList();
	}

	private void calculateStructDestinationProperties() {
		COSObject parent = getParentDictionary();
		if (parent == null || parent.getKey() == null) {
			return;
		}
		COSKey structParentKey = parent.getKey();
		COSObject structDestination = getStructureDestinationObject();
		if (structDestination == null || structDestination.getKey() == null) {
			return;
		}
		COSKey structDestinationKey = structDestination.getKey();
		Set<COSKey> structParentsSet = StaticContainers.getDestinationToStructParentsMap().computeIfAbsent(structDestinationKey, 
				k -> new HashSet<>());
		for (COSKey structParentObjectKey : structParentsSet) {
			if (!structParentKey.equals(structParentObjectKey)) {
				sameTargetAnnotObjectKey = structParentObjectKey.toString();
				break;
			}
		}
		for (Map.Entry<COSKey, Set<COSKey>> entry : StaticContainers.getDestinationToStructParentsMap().entrySet()) {
			if (structDestinationKey.equals(entry.getKey())) {
				continue;
			}
			for (COSKey structParentObjectKey : entry.getValue()) {
				if (structParentKey.equals(structParentObjectKey)) {
					differentTargetAnnotObjectKey = structParentObjectKey.toString();
					break;
				}
			}
			if (differentTargetAnnotObjectKey != null) {
				break;
			}
		}
		structParentsSet.add(structParentKey);
	}
	
	private COSObject getStructureDestinationObject() {
		COSObject destination = simpleCOSObject;
		if (simpleCOSObject.knownKey(ASAtom.A)) {
			PDAction action = ((PDAnnotation) simplePDObject).getA();
			if (ASAtom.GO_TO.equals(action.getSubtype())) {
				destination = action.getDestination();
			}
		} else if (simpleCOSObject.knownKey(ASAtom.DEST)) {
			destination = ((PDAnnotation) simplePDObject).getDestination();
		}
		if (destination == null) {
			return null;
		}
		if (destination.getType() == COSObjType.COS_STRING) {
			PDNamesDictionary namesDictionary = StaticResources.getDocument().getCatalog().getNamesDictionary();
			if (namesDictionary == null) {
				return null;
			}
			PDNameTreeNode dests = namesDictionary.getDests();
			if (dests != null) {
				COSObject dest = dests.getObject(destination.getString());
				if (dest == null) {
					LOGGER.log(Level.WARNING, "Named destination " + destination.getString() + 
							" not found in the Dests name tree in the Names dictionary");
					return null;
				}
				destination = dest;
			}
		} else if (destination.getType() == COSObjType.COS_NAME) {
			COSObject dests = StaticResources.getDocument().getCatalog().getDests();
			if (dests != null) {
				COSObject dest = dests.getKey(destination.getName());
				if (dest == null) {
					LOGGER.log(Level.WARNING, "Named destination " + destination.getName() + 
							" not found in the Dests dictionary in the catalog");
					return null;
				}
				destination = dest;
			}
		}
		if (destination.getType() == COSObjType.COS_DICT) {
			return destination.getKey(ASAtom.SD);
		}
		if (destination.getType() == COSObjType.COS_ARRAY && destination.size() > 0) {
			destination = destination.at(0);
			if (destination != null && destination.getType() == COSObjType.COS_DICT && destination.knownKey(ASAtom.S)) {
				return destination;
			}
		}
		return null;
	}

	@Override
	public String getdifferentTargetAnnotObjectKey() {
		return differentTargetAnnotObjectKey;
	}

	@Override
	public String getsameTargetAnnotObjectKey() {
		return sameTargetAnnotObjectKey;
	}
}
