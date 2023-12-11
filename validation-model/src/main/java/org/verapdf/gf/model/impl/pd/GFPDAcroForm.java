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
package org.verapdf.gf.model.impl.pd;

import org.verapdf.xmp.impl.ByteBuffer;
import org.verapdf.as.ASAtom;
import org.verapdf.as.io.ASInputStream;
import org.verapdf.cos.COSArray;
import org.verapdf.cos.COSObjType;
import org.verapdf.cos.COSObject;
import org.verapdf.cos.COSStream;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.pdlayer.PDAcroForm;
import org.verapdf.model.pdlayer.PDFormField;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Maksim Bezrukov
 */
public class GFPDAcroForm extends GFPDObject implements PDAcroForm {

    private static final Logger LOGGER = Logger.getLogger(GFPDAcroForm.class.getCanonicalName());

    public static final String ACRO_FORM_TYPE = "PDAcroForm";

    public static final String FORM_FIELDS = "formFields";

    public static final String XDP = "xdp:xdp";
    public static final String CONFIG = "config";
    public static final String ACROBAT = "acrobat";
    public static final String ACROBAT7 = "acrobat7";
    public static final String DYNAMIC_RENDER = "dynamicRender";

    public GFPDAcroForm(org.verapdf.pd.form.PDAcroForm acroForm) {
        super(acroForm, ACRO_FORM_TYPE);
    }

    @Override
    public Boolean getNeedAppearances() {
        COSObject cosNeedAppearances = ((org.verapdf.pd.form.PDAcroForm)
                simplePDObject).getNeedAppearances();
        if (cosNeedAppearances.getType() == COSObjType.COS_BOOLEAN) {
            return cosNeedAppearances.getBoolean();
        } else if (cosNeedAppearances.empty()) {
            return null;
        } else {
            LOGGER.log(Level.SEVERE, "Value of NeedAppearances key is not a boolean. Ignoring NeedAppearances");
            // value that fails the check
            return true;
        }
    }

    @Override
    public Boolean getcontainsXFA() {
        return this.simplePDObject.knownKey(ASAtom.XFA);
    }

    @Override
    public String getdynamicRender() {
        COSObject object = this.simplePDObject.getKey(ASAtom.XFA);
        if (object == null) {
            return null;
        }
        if (object.getType() == COSObjType.COS_ARRAY) {
            COSArray array = (COSArray)object.getDirectBase();
            COSObject afterConfig = null;
            for (int i = 0; i < array.size() - 1; i++) {
                COSObject element = array.at(i);
                if (element.getType() == COSObjType.COS_STRING && CONFIG.equals(element.getDirectBase().getString())) {
                    afterConfig = array.at(i + 1);
                    break;
                }
            }
            object = afterConfig;
        }
        if (object != null && object.getType() == COSObjType.COS_STREAM) {
            try (ASInputStream asInputStream = object.getDirectBase().getData(COSStream.FilterFlags.DECODE)) {
                DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                builder.setErrorHandler(null);
                Document doc = builder.parse(new InputSource(new ByteBuffer(asInputStream).getByteStream()));
                Node configParent = getProperty(doc, XDP);
                if (configParent == null) {
                    configParent = doc;
                }
                Node config = getProperty(configParent,CONFIG);
                Node acrobat = getProperty(config, ACROBAT);
                Node acrobat7 = getProperty(acrobat, ACROBAT7);
                Node dynamicRender = getProperty(acrobat7, DYNAMIC_RENDER);
                if (dynamicRender != null) {
                    return dynamicRender.getChildNodes().item(0).getNodeValue();
                }
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Problems with parsing XFA");
                return null;
            }
        }
        return null;
    }

    private Node getProperty(Node parent, String propertyName) {
        if (parent == null) {
            return null;
        }
        NodeList childNodes = parent.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (propertyName.equals(item.getNodeName())){
                return item;
            }
        }
        return null;
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case FORM_FIELDS:
                return this.getFormFields();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<PDFormField> getFormFields() {
        List<org.verapdf.pd.form.PDFormField> fields = ((org.verapdf.pd.form.PDAcroForm) this.simplePDObject)
                .getFields();
        List<PDFormField> formFields =
                new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
        for (org.verapdf.pd.form.PDFormField field : fields) {
            formFields.add(GFPDFormField.createTypedFormField(field));
        }
        return Collections.unmodifiableList(formFields);
    }

}
