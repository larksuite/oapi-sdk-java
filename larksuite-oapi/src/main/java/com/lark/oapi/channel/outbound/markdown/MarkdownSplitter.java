package com.lark.oapi.channel.outbound.markdown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MarkdownSplitter {
    private MarkdownSplitter() {
    }

    public static List<String> splitWithCodeFences(String text, int limit) {
        if (text == null) {
            return Collections.singletonList("");
        }
        if (text.length() <= limit) {
            return Collections.singletonList(text);
        }
        List<String> out = new ArrayList<String>();
        String[] lines = text.split("\n", -1);
        List<String> buf = new ArrayList<String>();
        int bufLen = 0;
        String fenceLang = null;
        for (String line : lines) {
            boolean isFence = line.matches("^```\\w*\\s*$");
            boolean isHeading = line.matches("^#{1,6}\\s.*$");
            int lineLen = line.length() + (buf.isEmpty() ? 0 : 1);
            boolean nearFull = bufLen > limit * 0.75;
            if (!buf.isEmpty() && (bufLen + lineLen > limit || (isHeading && nearFull))) {
                flushChunk(out, buf, fenceLang);
                bufLen = currentLength(buf);
            }
            buf.add(line);
            bufLen += lineLen;
            if (isFence) {
                if (fenceLang == null) {
                    fenceLang = line.length() > 3 ? line.substring(3).trim() : "";
                } else {
                    fenceLang = null;
                }
            }
        }
        flushChunk(out, buf, fenceLang);
        return out;
    }

    public static List<String> splitPlain(String text, int limit) {
        if (text == null) {
            return Collections.singletonList("");
        }
        if (text.length() <= limit) {
            return Collections.singletonList(text);
        }
        List<String> out = new ArrayList<String>();
        int start = 0;
        while (start < text.length()) {
            int end = Math.min(start + limit, text.length());
            out.add(text.substring(start, end));
            start = end;
        }
        return out;
    }

    private static void flushChunk(List<String> out, List<String> buf, String fenceLang) {
        if (buf.isEmpty()) {
            return;
        }
        String chunk = joinLines(buf);
        buf.clear();
        if (fenceLang != null) {
            chunk = chunk + "\n```";
        }
        out.add(chunk);
        if (fenceLang != null) {
            buf.add("```" + fenceLang);
        }
    }

    private static int currentLength(List<String> lines) {
        return joinLines(lines).length();
    }

    private static String joinLines(List<String> lines) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lines.size(); i++) {
            if (i > 0) {
                builder.append('\n');
            }
            builder.append(lines.get(i));
        }
        return builder.toString();
    }
}
