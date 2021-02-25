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
package org.verapdf.gf.model.impl.sa;

import org.verapdf.model.GenericModelObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.salayer.SADocument;
import org.verapdf.model.salayer.SAStructTreeRoot;
import org.verapdf.wcag.algorithms.semanticalgorithms.AccumulatedNodeSemanticChecker;

import java.util.*;

/**
 * @author Maxim Plushchov
 */
public class GFSADocument extends GenericModelObject implements SADocument {

    public static final String DOCUMENT_TYPE = "SADocument";

    protected org.verapdf.pd.PDDocument document;

    public static final int MAX_NUMBER_OF_ELEMENTS = 1;

    public static final String STRUCTURE_TREE_ROOT = "StructTreeRoot";

    private GFSAStructTreeRoot treeRoot = null;

    public GFSADocument(org.verapdf.pd.PDDocument document) {
        super(DOCUMENT_TYPE);
        this.document = document;
        checkSemantic();
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case STRUCTURE_TREE_ROOT:
                return this.getStructureTreeRoot();
            default:
                return super.getLinkedObjects(link);
        }
    }

	private List<GFSAPage> getPages() {
		List<GFSAPage> result = new ArrayList<>();
		List<org.verapdf.pd.PDPage> rawPages = document.getPages();
		for (org.verapdf.pd.PDPage rawPage : rawPages) {
			result.add(new GFSAPage(rawPage));
		}
		return Collections.unmodifiableList(result);
	}

    private void parseStructureTreeRoot() {
        org.verapdf.pd.structure.PDStructTreeRoot root = document.getStructTreeRoot();
        if (root != null) {
            this.treeRoot = new GFSAStructTreeRoot(root);
        }
    }

    private List<SAStructTreeRoot> getStructureTreeRoot() {
        if (treeRoot == null) {
            parseStructureTreeRoot();
        }
        if (treeRoot != null) {
            List<SAStructTreeRoot> res = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
            res.add(treeRoot);
            return Collections.unmodifiableList(res);
        }
        return Collections.emptyList();
    }

    private void parseChunks() {
        List<GFSAPage> pages = getPages();
        for (GFSAPage page : pages) {
            GFSAContentStream contentStream = page.getContentStream();
            if (contentStream != null) {
                contentStream.parseChunks();
            }
        }
    }

    private void checkSemantic() {
        parseChunks();
        parseStructureTreeRoot();
        if (treeRoot != null) {
            AccumulatedNodeSemanticChecker accumulatedNodeSemanticChecker = new AccumulatedNodeSemanticChecker();
            accumulatedNodeSemanticChecker.checkSemanticTree(treeRoot);
        }
    }

}
