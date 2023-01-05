/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lark.oapi.core.utils;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//org.springframework.http.converter.ResourceHttpMessageConverter
public class FileNameParser {

    private static final Pattern BASE64_ENCODED_PATTERN = Pattern.compile(
            "=\\?([0-9a-zA-Z-_]+)\\?B\\?([+/0-9a-zA-Z]+=*)\\?=");

    public static String parseFileName(String contentDisposition) {
        if (Strings.isEmpty(contentDisposition)) {
            return "";
        }
        List<String> parts = tokenize(contentDisposition);
        String type = (String) parts.get(0);
        String name = null;
        String filename = null;
        Charset charset = null;
        Long size = null;
        ZonedDateTime creationDate = null;
        ZonedDateTime modificationDate = null;
        ZonedDateTime readDate = null;

        for (int i = 1; i < parts.size(); ++i) {
            String part = (String) parts.get(i);
            int eqIndex = part.indexOf(61);
            if (eqIndex == -1) {
                throw new IllegalArgumentException("Invalid content disposition format");
            }

            String attribute = part.substring(0, eqIndex);
            String value =
                    part.startsWith("\"", eqIndex + 1) && part.endsWith("\"") ? part.substring(eqIndex + 2,
                            part.length() - 1) : part.substring(eqIndex + 1);
            if (attribute.equals("name")) {
                name = value;
            } else if (!attribute.equals("filename*")) {
                if (attribute.equals("filename") && filename == null) {
                    if (value.startsWith("=?")) {
                        Matcher matcher = BASE64_ENCODED_PATTERN.matcher(value);
                        if (matcher.find()) {
                            String match1 = matcher.group(1);
                            String match2 = matcher.group(2);
                            filename = new String(Base64.getDecoder().decode(match2), Charset.forName(match1));
                        } else {
                            filename = value;
                        }
                    } else {
                        filename = value;
                    }
                } else if (attribute.equals("size")) {
                    size = Long.parseLong(value);
                } else if (attribute.equals("creation-date")) {
                    try {
                        creationDate = ZonedDateTime.parse(value, DateTimeFormatter.RFC_1123_DATE_TIME);
                    } catch (DateTimeParseException var20) {
                    }
                } else if (attribute.equals("modification-date")) {
                    try {
                        modificationDate = ZonedDateTime.parse(value, DateTimeFormatter.RFC_1123_DATE_TIME);
                    } catch (DateTimeParseException var19) {
                    }
                } else if (attribute.equals("read-date")) {
                    try {
                        readDate = ZonedDateTime.parse(value, DateTimeFormatter.RFC_1123_DATE_TIME);
                    } catch (DateTimeParseException var18) {
                    }
                }
            } else {
                int idx1 = value.indexOf(39);
                int idx2 = value.indexOf(39, idx1 + 1);
                if (idx1 != -1 && idx2 != -1) {
                    charset = Charset.forName(value.substring(0, idx1).trim());
                    //  Assert.isTrue(StandardCharsets.UTF_8.equals(charset) || StandardCharsets.ISO_8859_1.equals(charset), "Charset should be UTF-8 or ISO-8859-1");
                    filename = decodeFilename(value.substring(idx2 + 1), charset);
                } else {
                    filename = decodeFilename(value, StandardCharsets.US_ASCII);
                }
            }
        }

        return filename;

    }

    private static List<String> tokenize(String headerValue) {
        int index = headerValue.indexOf(59);
        String type = (index >= 0 ? headerValue.substring(0, index) : headerValue).trim();
        if (type.isEmpty()) {
            throw new IllegalArgumentException("Content-Disposition header must not be empty");
        } else {
            List<String> parts = new ArrayList();
            parts.add(type);
            int nextIndex;
            if (index >= 0) {
                do {
                    nextIndex = index + 1;
                    boolean quoted = false;

                    for (boolean escaped = false; nextIndex < headerValue.length(); ++nextIndex) {
                        char ch = headerValue.charAt(nextIndex);
                        if (ch == ';') {
                            if (!quoted) {
                                break;
                            }
                        } else if (!escaped && ch == '"') {
                            quoted = !quoted;
                        }

                        escaped = !escaped && ch == '\\';
                    }

                    String part = headerValue.substring(index + 1, nextIndex).trim();
                    if (!part.isEmpty()) {
                        parts.add(part);
                    }

                    index = nextIndex;
                } while (nextIndex < headerValue.length());
            }

            return parts;
        }
    }

    private static String decodeFilename(String filename, Charset charset) {
        byte[] value = filename.getBytes(charset);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int index = 0;

        while (true) {
            while (index < value.length) {
                byte b = value[index];
                if (!isRFC5987AttrChar(b)) {
                    if (b != 37 || index >= value.length - 2) {
                        throw new IllegalArgumentException(
                                "Invalid header field parameter format (as defined in RFC 5987)");
                    }

                    char[] array = new char[]{(char) value[index + 1], (char) value[index + 2]};

                    try {
                        baos.write(Integer.parseInt(String.valueOf(array), 16));
                    } catch (NumberFormatException var8) {
                        throw new IllegalArgumentException(
                                "Invalid header field parameter format (as defined in RFC 5987)", var8);
                    }

                    index += 3;
                } else {
                    baos.write((char) b);
                    ++index;
                }
            }

            return copyToString(baos, charset);
        }
    }

    public static String copyToString(ByteArrayOutputStream baos, Charset charset) {

        try {
            return baos.toString(charset.name());
        } catch (UnsupportedEncodingException var3) {
            throw new IllegalArgumentException("Invalid charset name: " + charset, var3);
        }
    }

    private static boolean isRFC5987AttrChar(byte c) {
        return c >= 48 && c <= 57 || c >= 97 && c <= 122 || c >= 65 && c <= 90 || c == 33 || c == 35
                || c == 36 || c == 38 || c == 43 || c == 45 || c == 46 || c == 94 || c == 95 || c == 96
                || c == 124 || c == 126;
    }

}
