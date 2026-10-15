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

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.verapdf.wcag.algorithms.entities.content.TextChunk;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The chunk parser's clipping geometry, asserted on the exact strings that
 * survive and the exact strings that do not.
 *
 * <p>Line counts are not the acceptance criterion here: a filter can improve a
 * count while deleting the wrong text, so every case names both sides.
 *
 * <p>Geometry note for whoever edits these fixtures: a Helvetica chunk's
 * bounding box runs from the pen's x, and from {@code baseline - 0.225em} to
 * {@code baseline + 0.931em}. At 10pt that is 2.25pt below and 9.31pt above
 * the {@code Td} position.
 */
class ClippedTextChunkParserTest {

    @TempDir
    Path tempDir;

    /** The five lines of the tiled figure, as the reproducer draws them. */
    private static String figureLines() {
        return ClipTestPdfBuilder.text(0, 100, "Figure line 1")
                + ClipTestPdfBuilder.text(0, 80, "Figure line 2")
                + ClipTestPdfBuilder.text(0, 60, "Figure line 3")
                + ClipTestPdfBuilder.text(0, 40, "Figure line 4")
                + ClipTestPdfBuilder.text(0, 20, "Figure line 5");
    }

    /**
     * The shape that started this: a Form XObject carrying every line of a
     * figure, placed under a window that shows only the first one. Four fifths
     * of the text is on the page and none of it can be seen.
     */
    @Test
    void formUnderAWindowKeepsOnlyTheLineTheWindowShows() throws Exception {
        Path file = new ClipTestPdfBuilder()
                .form("Fx", new double[]{0, 0, 200, 120}, figureLines())
                .content(ClipTestPdfBuilder.text(72, 700, 12, "Page body.")
                        + "q 1 0 0 1 100 400 cm 0 95 200 30 re W n /Fx Do Q\n")
                .write(tempDir.resolve("reproducer.pdf"));

        List<TextChunk> chunks = ClipTestChunks.parse(file);

        assertEquals(Arrays.asList("Page body.", "Figure line 1"), ClipTestChunks.retained(chunks));
        assertEquals(Arrays.asList("Figure line 2", "Figure line 3", "Figure line 4", "Figure line 5"),
                ClipTestChunks.clipped(chunks));
    }

    /**
     * The clipped-text signal must stay distinct from the hidden-text one, so
     * that the hidden-text consumers do not react to clipped chunks and the
     * clipped-text opt-out can be genuine.
     */
    @Test
    void clippedTextIsNotMarkedAsHiddenText() throws Exception {
        Path file = new ClipTestPdfBuilder()
                .form("Fx", new double[]{0, 0, 200, 120}, figureLines())
                .content("q 1 0 0 1 100 400 cm 0 95 200 30 re W n /Fx Do Q\n")
                .write(tempDir.resolve("distinct.pdf"));

        List<TextChunk> chunks = ClipTestChunks.parse(file);

        assertEquals(4, ClipTestChunks.clipped(chunks).size());
        for (TextChunk chunk : chunks) {
            assertFalse(chunk.isHiddenText(),
                    "clipping must not set the hidden-text flag: " + chunk.getValue());
        }
    }

    /**
     * The discard rule is conservative: only text conclusively outside the clip
     * goes. A chunk the clip cuts in half is still partly readable, and a chunk
     * is not split at the boundary, so it keeps its text.
     */
    @Test
    void partiallyClippedChunkKeepsItsText() throws Exception {
        Path file = new ClipTestPdfBuilder()
                .content("q 72 690 40 30 re W n\n"
                        + ClipTestPdfBuilder.text(72, 700, "Partly visible line")
                        + "Q\n")
                .write(tempDir.resolve("partial.pdf"));

        List<TextChunk> chunks = ClipTestChunks.parse(file);

        assertEquals(Collections.singletonList("Partly visible line"), ClipTestChunks.retained(chunks));
        assertEquals(Collections.emptyList(), ClipTestChunks.clipped(chunks));
    }

    /** Touching the clip boundary is not being outside it. */
    @Test
    void chunkTouchingTheClipBoundaryKeepsItsText() throws Exception {
        Path file = new ClipTestPdfBuilder()
                // The clip's right edge is exactly the pen's x, which is exactly
                // the chunk's left edge.
                .content("q 32 690 40 20 re W n\n"
                        + ClipTestPdfBuilder.text(72, 700, "Edge touching text")
                        + "Q\n")
                .write(tempDir.resolve("touching.pdf"));

        List<TextChunk> chunks = ClipTestChunks.parse(file);

        assertEquals(Collections.singletonList("Edge touching text"), ClipTestChunks.retained(chunks));
    }

    /** One point of clear separation is enough, so the rule is not inert. */
    @Test
    void chunkOnePointBeyondTheClipIsMarked() throws Exception {
        Path file = new ClipTestPdfBuilder()
                .content("q 31 690 40 20 re W n\n"
                        + ClipTestPdfBuilder.text(72, 700, "One point clear")
                        + "Q\n")
                .write(tempDir.resolve("separated.pdf"));

        List<TextChunk> chunks = ClipTestChunks.parse(file);

        assertEquals(Collections.emptyList(), ClipTestChunks.retained(chunks));
        assertEquals(Collections.singletonList("One point clear"), ClipTestChunks.clipped(chunks));
    }

    /** Q restores the clip that was in force before q, so a later caption survives. */
    @Test
    void restoringGraphicsStateRestoresTheEarlierClip() throws Exception {
        Path file = new ClipTestPdfBuilder()
                .content("q 0 0 10 10 re W n\n"
                        + ClipTestPdfBuilder.text(72, 700, "Inside the window")
                        + "Q\n"
                        + ClipTestPdfBuilder.text(72, 660, "Caption after Q"))
                .write(tempDir.resolve("restore.pdf"));

        List<TextChunk> chunks = ClipTestChunks.parse(file);

        assertEquals(Collections.singletonList("Caption after Q"), ClipTestChunks.retained(chunks));
        assertEquals(Collections.singletonList("Inside the window"), ClipTestChunks.clipped(chunks));
    }

    /**
     * Two placements of one form are two graphics states: each gets its own
     * transform and its own window, and neither leaks into the other.
     */
    @Test
    void twoPlacementsOfTheSameFormEachGetTheirOwnResult() throws Exception {
        Path file = new ClipTestPdfBuilder()
                .form("Fx", new double[]{0, 0, 200, 120}, figureLines())
                .content("q 1 0 0 1 100 400 cm 0 95 200 30 re W n /Fx Do Q\n"
                        + "q 1 0 0 1 100 200 cm 0 55 200 20 re W n /Fx Do Q\n")
                .write(tempDir.resolve("placements.pdf"));

        List<TextChunk> chunks = ClipTestChunks.parse(file);

        // The first window shows line 1, the second shows line 3.
        assertEquals(Arrays.asList("Figure line 1", "Figure line 3"), ClipTestChunks.retained(chunks));
        assertEquals(Arrays.asList(
                "Figure line 2", "Figure line 3", "Figure line 4", "Figure line 5",
                "Figure line 1", "Figure line 2", "Figure line 4", "Figure line 5"),
                ClipTestChunks.clipped(chunks));
    }

    /**
     * A form's own /BBox clips its content, and composes with the clip it
     * inherits. When the two do not meet, the effective clip is EMPTY and every
     * chunk inside is clipped away -- an empty intersection must never be read
     * back as "unclipped".
     */
    @Test
    void formBBoxAndInheritedClipCompose() throws Exception {
        String formContent = ClipTestPdfBuilder.text(5, 10, "Low line")
                + ClipTestPdfBuilder.text(5, 250, "High line");
        Path file = new ClipTestPdfBuilder()
                .form("Fb", new double[]{0, 0, 100, 40}, formContent)
                .content(ClipTestPdfBuilder.text(72, 700, 12, "Page body.")
                        // No inherited clip: the /BBox alone decides. "Low line"
                        // lands inside it, "High line" far above it.
                        + "q 1 0 0 1 100 100 cm /Fb Do Q\n"
                        // Inherited clip y 500..600 against a /BBox at y 300..340:
                        // the intersection is empty, so both lines go, although
                        // "Low line" is inside the /BBox and "High line" is
                        // inside the inherited clip.
                        + "q 0 500 612 100 re W n 1 0 0 1 100 300 cm /Fb Do Q\n")
                .write(tempDir.resolve("bbox.pdf"));

        List<TextChunk> chunks = ClipTestChunks.parse(file);

        assertEquals(Arrays.asList("Page body.", "Low line"), ClipTestChunks.retained(chunks));
        assertEquals(Arrays.asList("High line", "Low line", "High line"), ClipTestChunks.clipped(chunks));
    }

    /**
     * A non-rectangular clipping path is approximated by its bounding box. The
     * approximation only makes the clip larger, so text it lets through may
     * still be invisible -- disjointness proves invisibility, overlap proves
     * nothing. This pins the documented limitation rather than a wish.
     */
    @Test
    void nonRectangularClipIsApproximatedByItsBoundingBox() throws Exception {
        Path file = new ClipTestPdfBuilder()
                // A triangle with vertices (100,100), (300,100), (200,300);
                // its bounding box is x 100..300, y 100..300.
                .content("q 100 100 m 300 100 l 200 300 l h W n\n"
                        + ClipTestPdfBuilder.text(170, 150, "Inside the triangle")
                        + ClipTestPdfBuilder.text(105, 280, "Corner outside the triangle")
                        + ClipTestPdfBuilder.text(400, 500, "Outside the bounding box")
                        + "Q\n")
                .write(tempDir.resolve("triangle.pdf"));

        List<TextChunk> chunks = ClipTestChunks.parse(file);

        // The corner text is invisible on the page but inside the box, so it is
        // retained: that is the approximation, stated.
        assertEquals(Arrays.asList("Inside the triangle", "Corner outside the triangle"),
                ClipTestChunks.retained(chunks));
        assertEquals(Collections.singletonList("Outside the bounding box"), ClipTestChunks.clipped(chunks));
    }

    /** Without W the path is only painted; it must not clip anything. */
    @Test
    void aPaintedPathWithoutWDoesNotClip() throws Exception {
        Path file = new ClipTestPdfBuilder()
                .content("q 0 0 10 10 re f\n"
                        + ClipTestPdfBuilder.text(72, 700, "Not clipped by a filled box")
                        + "Q\n")
                .write(tempDir.resolve("nowclip.pdf"));

        List<TextChunk> chunks = ClipTestChunks.parse(file);

        assertTrue(ClipTestChunks.clipped(chunks).isEmpty(), "a plain fill must not clip");
        assertEquals(Collections.singletonList("Not clipped by a filled box"), ClipTestChunks.retained(chunks));
    }
}
