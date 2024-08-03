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
package org.verapdf.gf.model.visitor.cos.gf;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.*;
import org.verapdf.cos.visitor.ICOSVisitor;
import org.verapdf.gf.model.impl.cos.*;

/**
 * @author Timur Kamalov
 */
public class GFCosVisitor implements ICOSVisitor {

    private GFCosVisitor() {
    }

    public static GFCosVisitor getInstance() {
        return new GFCosVisitor();
    }

    /** {@inheritDoc} Create a GFCosArray for corresponding COSArray.
     * @return GFCosArray object
     * @see GFCosArray
     */
    @Override
    public Object visitFromArray(COSArray obj) {
        return new GFCosArray(obj);
    }

    /** {@inheritDoc} Create a GFCosBool for corresponding COSBoolean.
     * @return GFCosBool object
     * @see GFCosBool
     */
    @Override
    public Object visitFromBoolean(COSBoolean obj) {
        return GFCosBool.valueOf(obj);
    }

    /** {@inheritDoc} Create a GFCosFileSpecification COSDictionary if
     * value of type key of {@code obj} is file specification. Otherwise
     * create GFCosDict
     * @return GFCosFileSpecification or GFCosDict
     * @see GFCosDict
     * @see GFCosFileSpecification
     */
    @Override
    public Object visitFromDictionary(COSDictionary obj) {
        ASAtom type = obj.getNameKey(ASAtom.TYPE);
        boolean isFileSpec = ASAtom.FILESPEC.equals(type);
        return isFileSpec ? new GFCosFileSpecification(obj, false) : new GFCosDict(obj);
    }

    /** {@inheritDoc} Create a GFCosDocument for corresponding COSDocument.
     * @return GFCosDocument object
     * @see GFCosDocument
     */
    @Override
    public Object visitFromDocument(COSDocument obj) {
        return new GFCosDocument(obj);
    }

    /** {@inheritDoc} Create a GFCosReal for corresponding COSReal.
     * @return GFCosReal object
     * @see GFCosReal
     */
    @Override
    public Object visitFromReal(COSReal obj) {
        return new GFCosReal(obj);
    }

    /** {@inheritDoc} Create a GFCosInteger for corresponding COSInteger.
     * @return GFCosInteger object
     * @see GFCosInteger
     */
    @Override
    public Object visitFromInteger(COSInteger obj) {
        return new GFCosInteger(obj);
    }

    /** {@inheritDoc} Create a GFCosName for corresponding COSName.
     * @return GFCosName object
     * @see GFCosName
     */
    @Override
    public Object visitFromName(COSName obj) {
        return new GFCosName(obj);
    }

    /** {@inheritDoc} Create a GFCosNull for corresponding COSNull.
     * @return GFCosNull object
     * @see GFCosNull
     */
    @Override
    public Object visitFromNull(COSNull obj) {
        return GFCosNull.getInstance();
    }

    /** {@inheritDoc} Create a GFCosStream for corresponding COSStream.
     * @return GFCosStream object
     * @see GFCosStream
     */
    @Override
    public Object visitFromStream(COSStream obj) {
        return new GFCosStream(obj);
    }

    /** {@inheritDoc} Create a GFCosString for corresponding COSString.
     * @return GFCosString object
     * @see GFCosString
     */
    @Override
    public Object visitFromString(COSString obj) {
        return new GFCosString(obj);
    }

    public static Object visitFromIndirect(COSIndirect obj) {
        //for cases when there's an indirect reference to a non-existing object
        if (obj.getDirect() == null) {
            return GFCosNull.getInstance();
        }
        return new GFCosIndirect(obj);
    }

}