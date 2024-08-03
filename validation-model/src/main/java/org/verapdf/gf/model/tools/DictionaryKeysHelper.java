/**
 * This file is part of veraPDF Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2024, veraPDF Consortium <info@verapdf.org>
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
package org.verapdf.gf.model.tools;

import org.xml.sax.InputSource;
import org.verapdf.as.ASAtom;
import org.verapdf.cos.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.verapdf.xmp.impl.ByteBuffer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DictionaryKeysHelper {

    private static final Logger LOGGER = Logger.getLogger(DictionaryKeysHelper.class.getCanonicalName());

    public static String getStringOrStreamEntryStringRepresentation(COSObject dictionary, ASAtom key) {
        COSObject object = dictionary.getKey(key);
        if (object == null || object.empty()) {
            return null;
        }
        COSBase base = object.getDirectBase();
        if (base.getType() == COSObjType.COS_STREAM) {
            base = ((COSStream)base).getStringFromTextStream();
        }
        if (base.getType() == COSObjType.COS_STRING) {
            return base.getString();
        }
        return null;
    }

    public static String getRichTextStringOrStreamEntryStringRepresentation(COSObject dictionary, ASAtom key) {
        try {
            COSObject object = dictionary.getKey(key);
            if (object == null || object.empty()) {
                return null;
            }
            COSBase base = object.getDirectBase();
            InputStream inputStream;
            if (object.getType() == COSObjType.COS_STREAM) {
                inputStream = base.getData();
            } else if (object.getType() == COSObjType.COS_STRING) {
                inputStream = new ByteBuffer(object.getDirectBase().getString().getBytes()).getByteStream();
            } else {
                return null;
            }
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            builder.setErrorHandler(null);
            Document doc = builder.parse(new InputSource(inputStream));
            return getAllNodeText(doc);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error while parsing rich text entry " + key + " in the object " + dictionary.getKey());
        }
        return null;
    }

    private static String getAllNodeText(Node node) {
        StringBuilder stringBuilder = new StringBuilder();
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node child = childNodes.item(i);
            if (child.getNodeValue() != null) {
                stringBuilder.append(child.getNodeValue());
            } else {
                stringBuilder.append(getAllNodeText(child));
            }
        }
        return stringBuilder.toString();
    }
}
