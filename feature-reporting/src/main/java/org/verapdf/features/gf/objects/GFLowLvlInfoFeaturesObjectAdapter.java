/**
 * This file is part of veraPDF Feature Reporting, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF Feature Reporting is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF Feature Reporting as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF Feature Reporting as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.features.gf.objects;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.*;
import org.verapdf.features.objects.LowLvlInfoFeaturesObjectAdapter;
import org.verapdf.pd.PDCatalog;
import org.verapdf.pd.PDDocument;

import java.util.*;

/**
 * Feature object adapter for low level info part of the features report
 *
 * @author Sergey Shemyakov
 */
public class GFLowLvlInfoFeaturesObjectAdapter implements LowLvlInfoFeaturesObjectAdapter {

    private static final Map<ASAtom, ASAtom> filtersAbbreviations;

    static {
        Map<ASAtom, ASAtom> filtersAbbreviationsTemp = new HashMap<>();

        filtersAbbreviationsTemp.put(ASAtom.ASCII_HEX_DECODE_ABBREVIATION, ASAtom.ASCII_HEX_DECODE);
        filtersAbbreviationsTemp.put(ASAtom.ASCII85_DECODE_ABBREVIATION, ASAtom.ASCII85_DECODE);
        filtersAbbreviationsTemp.put(ASAtom.LZW_DECODE_ABBREVIATION, ASAtom.LZW_DECODE);
        filtersAbbreviationsTemp.put(ASAtom.FLATE_DECODE_ABBREVIATION, ASAtom.FLATE_DECODE);
        filtersAbbreviationsTemp.put(ASAtom.RUN_LENGTH_DECODE_ABBREVIATION, ASAtom.RUN_LENGTH_DECODE);
        filtersAbbreviationsTemp.put(ASAtom.CCITTFAX_DECODE_ABBREVIATION, ASAtom.CCITTFAX_DECODE);
        filtersAbbreviationsTemp.put(ASAtom.DCT_DECODE_ABBREVIATION, ASAtom.DCT_DECODE);
        filtersAbbreviations = Collections.unmodifiableMap(filtersAbbreviationsTemp);
    }

    private boolean isPresent;
    private double headerVersion;
    private String catalogVersion;
    private int indirectObjectsNumber;
    private String creationId;
    private String modificationId;
    private boolean isTagged = false;
    private Set<String> filters;
    private List<String> errors;

    /**
     * Constructs new low level info feature object adapter.
     *
     * @param document class represents document object
     */
    public GFLowLvlInfoFeaturesObjectAdapter(COSDocument document) {
        init(document);
    }

    private void init(COSDocument document) {
        this.isPresent = document != null;
        if (document != null) {
            COSHeader documentHeader = document.getHeader();
            if (documentHeader != null) {
                this.headerVersion = documentHeader.getVersion();
            }
            if (document.getObjects() != null) {
                this.indirectObjectsNumber = document.getObjects().size();
            }
            COSArray ids = document.getID();
            if (ids != null) {
                this.creationId = ids.at(0).getString();
                this.modificationId = ids.at(1).getString();

                if (ids.size() != 2 || this.creationId == null || this.modificationId == null) {
                    this.errors = new ArrayList<>();
                    this.errors.add("Document's ID must be an array of two not null elements");
                }
            }
            PDDocument pdDocument = document.getPDDocument();
            if (pdDocument != null) {
                PDCatalog catalog = pdDocument.getCatalog();
                if (catalog != null) {
                    this.catalogVersion = catalog.getNameKeyStringValue(ASAtom.VERSION);
                    this.isTagged = catalog.getStructTreeRoot() != null;
                }
            }
            this.filters = getAllFilters(document);
        }
    }

    private Set<String> getAllFilters(COSDocument document) {
        Set<String> res = new HashSet<>();
        for (COSObject base : document.getObjects()) {
            if (base.getType() == COSObjType.COS_STREAM) {
                COSFilters baseFilters = ((COSStream) base.getDirectBase()).getFilters();
                addFilters(res, baseFilters);
            }
        }
        return res;
    }

    private static void addFilters(Set<String> res, COSFilters filters) {
        List<ASAtom> atoms = filters.getFilters();
        if (atoms != null) {
            for (ASAtom atom : atoms) {
                if (filtersAbbreviations.containsKey(atom)) {
                    atom = filtersAbbreviations.get(atom);
                }
                res.add(atom.getValue());
            }
        }
    }

    @Override
    public double getHeaderVersion() {
        return this.headerVersion;
    }

    @Override
    public String getCatalogVersion() {
        return this.catalogVersion;
    }

    @Override
    public int getIndirectObjectsNumber() {
        return this.indirectObjectsNumber;
    }

    @Override
    public String getCreationId() {
        return this.creationId;
    }

    @Override
    public String getModificationId() {
        return this.modificationId;
    }

    @Override
    public boolean isTagged() {
        return this.isTagged;
    }

    @Override
    public Set<String> getFilters() {
        return this.filters == null ? Collections.emptySet() : Collections.unmodifiableSet(this.filters);
    }

    @Override
    public boolean isPDFObjectPresent() {
        return this.isPresent;
    }

    @Override
    public List<String> getErrors() {
        return this.errors == null ? Collections.emptyList() : Collections.unmodifiableList(this.errors);
    }
}
