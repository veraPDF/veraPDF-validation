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
package org.verapdf.gf.model.impl.pd.gfse.contents;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSKey;
import org.verapdf.cos.COSObject;
import org.verapdf.model.operator.Operator;
import org.verapdf.model.selayer.SEGroupedContent;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.StaticResources;
import org.verapdf.tools.TaggedPDFConstants;
import org.verapdf.tools.TaggedPDFRoleMapHelper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class GFSEGroupedContent extends GFSEContentItem implements SEGroupedContent {
    
    private static final Logger LOGGER = Logger.getLogger(GFSEGroupedContent.class.getCanonicalName());

    protected final List<Operator> operators;
    protected final COSObject parentStructElem;
    protected final String parentsTags;
    protected final boolean isSignature;
    protected final String defaultLang;
    protected final Boolean isTaggedContent;
    
    public GFSEGroupedContent(String objectType, List<Operator> operators, COSObject parentStructElem, String parentsTags, String defaultLang,
                              boolean isSignature) {
        super(objectType);
        this.operators = operators;
        this.parentStructElem = parentStructElem;
        this.parentsTags = parentsTags;
        this.defaultLang = defaultLang;
        this.isSignature = isSignature;
        this.isTaggedContent = isTaggedContent();
    }

    @Override
    public String getparentsTags() {
        return parentsTags;
    }

    @Override
    public String getparentStructureTag() {
        return parentStructElem != null ? parentStructElem.getNameKeyStringValue(ASAtom.S) : null;
    }

    @Override
    public String getparentStandardTag() {
        TaggedPDFRoleMapHelper taggedPDFRoleMapHelper = StaticResources.getRoleMapHelper();
        if (parentStructElem != null && taggedPDFRoleMapHelper != null) {
            PDStructElem structElem = new PDStructElem(parentStructElem, taggedPDFRoleMapHelper.getRoleMap());
            return PDStructElem.getStructureElementStandardType(structElem);
        }
        return null;
    }

    @Override
    public Boolean getisSignature() {
        return isSignature;
    }

    public String getLangValue() {
        return defaultLang;
    }

    @Override
    public Boolean getisArtifact() {
        return hasParentWithStandardType(TaggedPDFConstants.ARTIFACT);
    }

    protected Boolean hasParentWithStandardType(String standardType) {
        TaggedPDFRoleMapHelper taggedPDFRoleMapHelper = StaticResources.getRoleMapHelper();
        Set<COSKey> keys = new HashSet<>();
        if (parentStructElem != null && taggedPDFRoleMapHelper != null) {
            PDStructElem structElem = new PDStructElem(parentStructElem, taggedPDFRoleMapHelper.getRoleMap());
            while (structElem != null) {
                if (standardType.equals(PDStructElem.getStructureElementStandardType(structElem))) {
                    return true;
                }
                COSKey key = structElem.getObject().getObjectKey();
                if (keys.contains(key)) {
                    LOGGER.log(Level.WARNING, "Struct tree loop found");
                    break;
                }
                if (key != null) {
                    keys.add(key);
                }
                structElem = structElem.getParent();
            }
        }
        return false;
    }

    public String getInheritedActualText() {
        return null;
    }

    public String getInheritedAlt() {
        return null;
    }
    
    public Long getMCID() {
        return null;
    }

    @Override
    public String getActualText() {
        return null;
    }

    @Override
    public String getAlt() {
        return null;
    }

    @Override
    public Boolean getisTaggedContent() {
        return this.isTaggedContent;
    }
    
    private boolean isTaggedContent() {
        Set<COSKey> keys = new HashSet<>();
        PDStructElem structElem = new PDStructElem(parentStructElem, null);
        while (structElem != null) {
            if (structElem.getType() == ASAtom.STRUCT_TREE_ROOT) {
                return true;
            }
            COSKey key = structElem.getObject().getObjectKey();
            if (keys.contains(key)) {
                LOGGER.log(Level.WARNING, "Struct tree loop found");
                break;
            }
            if (key != null) {
                keys.add(key);
            }
            structElem = structElem.getParent();
        }
        return false;
    }

    @Override
    public String getparentStructureElementObjectKey() {
        return parentStructElem.getObjectKey().toString();
    }
}
