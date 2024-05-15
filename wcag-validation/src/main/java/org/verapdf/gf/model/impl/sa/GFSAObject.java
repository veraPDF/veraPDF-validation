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
import org.verapdf.model.salayer.SAObject;
import org.verapdf.wcag.algorithms.entities.IObject;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Maxim Plushchov
 */
public class GFSAObject extends GenericModelObject implements SAObject {

	private final List<Integer> errorCodes = new LinkedList<>();
	private final List<List<Object>> errorArguments = new LinkedList<>();
	protected IObject object;

	public GFSAObject(String type) {
		super(type);
	}

	public GFSAObject(IObject object, String type) {
		super(type);
		this.object = object;
	}

	@Override
	public List<String> geterrorCodes() {
		return errorCodes.stream().map(Objects::toString).collect(Collectors.toList());
	}

	public List<Integer> getErrorCodes() {
		return errorCodes;
	}

	public List<List<Object>> getErrorArguments() {
		return errorArguments;
	}

	@Override
	public List<List<String>> geterrorArguments() {
		List<List<String>> list = new LinkedList<>();
		for (List<Object> arguments : errorArguments) {
			list.add(arguments.stream().map(Object::toString).collect(Collectors.toList()));
		}
		return list;
	}

	@Override
	public String getContext() {
		return object.getBoundingBox().getLocation();
	}

	@Override
	public String getstructureID() {
		if (object.getRecognizedStructureId() != null) {
			return "id:" + object.getRecognizedStructureId();
		}
		return null;
	}

	protected void setObject(IObject object) {
		this.object = object;
	}

	protected IObject getObject() {
		return object;
	}
}
