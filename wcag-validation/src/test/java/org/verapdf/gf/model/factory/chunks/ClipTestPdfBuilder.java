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

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Writes a one page PDF byte by byte, so a clipping fixture is the content
 * stream the test author wrote and nothing else.
 *
 * <p>A PDF writing library would put its own graphics state operators around
 * the stream, which is exactly what these tests are measuring. The file is
 * small enough to build by hand: a catalog, a page tree, one Helvetica font,
 * the page's content stream and one stream per Form XObject.
 */
final class ClipTestPdfBuilder {

    static final double PAGE_WIDTH = 612;
    static final double PAGE_HEIGHT = 792;

    private final Map<String, Form> forms = new LinkedHashMap<>();
    private String content = "";

    /** A Form XObject: its own /BBox, its /Matrix and its content stream. */
    static final class Form {
        private final double[] bbox;
        private final double[] matrix;
        private final String content;

        Form(double[] bbox, double[] matrix, String content) {
            this.bbox = bbox;
            this.matrix = matrix;
            this.content = content;
        }
    }

    ClipTestPdfBuilder content(String pageContent) {
        this.content = pageContent;
        return this;
    }

    ClipTestPdfBuilder form(String name, double[] bbox, String formContent) {
        return form(name, bbox, new double[]{1, 0, 0, 1, 0, 0}, formContent);
    }

    ClipTestPdfBuilder form(String name, double[] bbox, double[] matrix, String formContent) {
        forms.put(name, new Form(bbox, matrix, formContent));
        return this;
    }

    /** One {@code Tj} on its own line, at the given point, in 10pt Helvetica. */
    static String text(double x, double y, String value) {
        return text(x, y, 10, value);
    }

    static String text(double x, double y, double size, String value) {
        return String.format("BT /F1 %s Tf %s %s Td (%s) Tj ET%n",
                number(size), number(x), number(y), value.replace("\\", "\\\\")
                        .replace("(", "\\(").replace(")", "\\)"));
    }

    static String number(double value) {
        if (value == Math.rint(value)) {
            return Long.toString((long) value);
        }
        return String.format("%.4f", value);
    }

    Path write(Path file) throws IOException {
        List<byte[]> objects = new ArrayList<>();
        // 1 catalog, 2 page tree, 3 font, 4 page, 5 page contents, then one
        // stream object per form. Numbers are fixed so the references below
        // can be written straight out.
        int firstForm = 6;
        StringBuilder xObjects = new StringBuilder();
        int number = firstForm;
        for (String name : forms.keySet()) {
            xObjects.append('/').append(name).append(' ').append(number++).append(" 0 R ");
        }
        String resources = "/Font << /F1 3 0 R >>"
                + (xObjects.length() == 0 ? "" : " /XObject << " + xObjects + ">>");

        objects.add(ascii("<< /Type /Catalog /Pages 2 0 R >>"));
        objects.add(ascii("<< /Type /Pages /Kids [4 0 R] /Count 1 >>"));
        objects.add(ascii("<< /Type /Font /Subtype /Type1 /BaseFont /Helvetica "
                + "/Encoding /WinAnsiEncoding >>"));
        objects.add(ascii(String.format("<< /Type /Page /Parent 2 0 R /MediaBox [0 0 %s %s] "
                        + "/Resources << %s >> /Contents 5 0 R >>",
                number(PAGE_WIDTH), number(PAGE_HEIGHT), resources)));
        objects.add(stream("", content));
        for (Form form : forms.values()) {
            objects.add(stream(String.format(
                    "/Type /XObject /Subtype /Form /BBox [%s %s %s %s] /Matrix [%s %s %s %s %s %s] "
                            + "/Resources << /Font << /F1 3 0 R >> >> ",
                    number(form.bbox[0]), number(form.bbox[1]), number(form.bbox[2]), number(form.bbox[3]),
                    number(form.matrix[0]), number(form.matrix[1]), number(form.matrix[2]),
                    number(form.matrix[3]), number(form.matrix[4]), number(form.matrix[5])),
                    form.content));
        }

        ByteBuffer out = new ByteBuffer();
        out.append(ascii("%PDF-1.7\n"));
        out.append(new byte[]{'%', (byte) 0xe2, (byte) 0xe3, (byte) 0xcf, (byte) 0xd3, '\n'});
        List<Integer> offsets = new ArrayList<>();
        for (int index = 0; index < objects.size(); index++) {
            offsets.add(out.size());
            out.append(ascii((index + 1) + " 0 obj\n"));
            out.append(objects.get(index));
            out.append(ascii("\nendobj\n"));
        }
        int startxref = out.size();
        StringBuilder xref = new StringBuilder();
        xref.append("xref\n0 ").append(objects.size() + 1).append('\n');
        xref.append("0000000000 65535 f \n");
        for (int offset : offsets) {
            xref.append(String.format("%010d 00000 n %n", offset));
        }
        xref.append("trailer\n<< /Size ").append(objects.size() + 1).append(" /Root 1 0 R >>\n");
        xref.append("startxref\n").append(startxref).append("\n%%EOF\n");
        out.append(ascii(xref.toString()));

        Files.createDirectories(file.getParent());
        Files.write(file, out.toByteArray());
        return file;
    }

    private static byte[] stream(String extraDictionaryEntries, String body) {
        byte[] bytes = ascii(body);
        ByteBuffer buffer = new ByteBuffer();
        buffer.append(ascii("<< " + extraDictionaryEntries + "/Length " + bytes.length + " >>\nstream\n"));
        buffer.append(bytes);
        buffer.append(ascii("\nendstream"));
        return buffer.toByteArray();
    }

    private static byte[] ascii(String value) {
        return value.getBytes(StandardCharsets.ISO_8859_1);
    }

    /** A growable byte sink; the file is a few kilobytes at most. */
    private static final class ByteBuffer {
        private byte[] bytes = new byte[4096];
        private int length = 0;

        void append(byte[] more) {
            while (length + more.length > bytes.length) {
                byte[] grown = new byte[bytes.length * 2];
                System.arraycopy(bytes, 0, grown, 0, length);
                bytes = grown;
            }
            System.arraycopy(more, 0, bytes, length, more.length);
            length += more.length;
        }

        int size() {
            return length;
        }

        byte[] toByteArray() {
            byte[] result = new byte[length];
            System.arraycopy(bytes, 0, result, 0, length);
            return result;
        }
    }
}
