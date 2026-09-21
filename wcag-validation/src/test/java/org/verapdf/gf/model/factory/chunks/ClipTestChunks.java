/*
 * This file is part of veraPDF WCAG Validation, a module of the veraPDF project.
 * Copyright (c) 2015-2026, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF WCAG Validation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF WCAG Validation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF WCAG Validation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.gf.model.factory.chunks;

import org.verapdf.containers.StaticCoreContainers;
import org.verapdf.gf.model.impl.containers.StaticStorages;
import org.verapdf.gf.model.impl.sa.GFSAPDFDocument;
import org.verapdf.parser.PDFFlavour;
import org.verapdf.pd.PDDocument;
import org.verapdf.tools.StaticResources;
import org.verapdf.wcag.algorithms.entities.content.IChunk;
import org.verapdf.wcag.algorithms.entities.content.TextChunk;
import org.verapdf.wcag.algorithms.semanticalgorithms.containers.StaticContainers;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Runs the chunk parser over a fixture and hands back the page's text chunks,
 * so a test can assert on which strings survived clipping.
 */
final class ClipTestChunks {

    private ClipTestChunks() {
    }

    /** Parses page 0 of the file and returns its text chunks, in stream order. */
    static List<TextChunk> parse(Path file) throws IOException {
        StaticResources.clear();
        StaticContainers.updateContainers(null);
        StaticCoreContainers.clearAllContainers();

        PDDocument pdDocument = new PDDocument(file.toAbsolutePath().toString());
        try {
            StaticResources.setDocument(pdDocument);
            GFSAPDFDocument document = new GFSAPDFDocument(pdDocument);
            StaticResources.setFlavour(Collections.singletonList(PDFFlavour.WCAG_2_2_HUMAN));
            StaticContainers.setDocument(document);
            StaticContainers.setFileName(file.toAbsolutePath().toString());
            StaticContainers.setIsDataLoader(true);
            StaticContainers.setIsIgnoreCharactersWithoutUnicode(false);
            StaticResources.setIsFontProgramsParsing(true);
            StaticStorages.setIsIgnoreMCIDs(true);
            StaticStorages.setIsAddSpacesBetweenTextPieces(true);
            document.parseChunks();

            List<TextChunk> chunks = new ArrayList<>();
            for (IChunk chunk : document.getArtifacts(0)) {
                if (chunk instanceof TextChunk) {
                    chunks.add((TextChunk) chunk);
                }
            }
            return chunks;
        } finally {
            pdDocument.close();
        }
    }

    /** The values of the chunks a clipped-text consumer would keep. */
    static List<String> retained(List<TextChunk> chunks) {
        return values(chunks, false);
    }

    /** The values of the chunks the parser marked as clipped away. */
    static List<String> clipped(List<TextChunk> chunks) {
        return values(chunks, true);
    }

    private static List<String> values(List<TextChunk> chunks, boolean wanted) {
        List<String> values = new ArrayList<>();
        for (TextChunk chunk : chunks) {
            if (chunk.isClippedText() == wanted) {
                values.add(chunk.getValue().trim());
            }
        }
        return values;
    }
}
