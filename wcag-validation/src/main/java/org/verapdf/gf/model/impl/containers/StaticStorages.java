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
package org.verapdf.gf.model.impl.containers;

import org.verapdf.as.ASAtom;
import org.verapdf.tools.TaggedPDFRoleMapHelper;
import org.verapdf.wcag.algorithms.entities.content.IChunk;

import java.util.*;

/**
 * @author Maxim Plushchov
 */
public class StaticStorages {

	private static final ThreadLocal<TaggedPDFRoleMapHelper> roleMapHelper = new ThreadLocal<>();

	private static final ThreadLocal<Map<Long, List<IChunk>>> chunks = new ThreadLocal<>();

	public static void clearAllContainers() {
		roleMapHelper.set(null);
		chunks.set(new HashMap<>());
	}

	public static TaggedPDFRoleMapHelper getRoleMapHelper() {
		return roleMapHelper.get();
	}

	public static void setRoleMapHelper(Map<ASAtom, ASAtom> roleMap) {
		roleMapHelper.set(new TaggedPDFRoleMapHelper(roleMap));
	}

	public static void setRoleMapHelper(TaggedPDFRoleMapHelper roleMapHelper) {
		StaticStorages.roleMapHelper.set(roleMapHelper);
	}

	    public static Map<Long, List<IChunk>> getChunks() {
        if (chunks.get() == null) {
            chunks.set(new HashMap<>());
        }
        return chunks.get();
    }

    public static void setChunks(Map<Long, List<IChunk>> chunks) {
	    StaticStorages.chunks.set(chunks);
    }

}
