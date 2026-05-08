package com.lark.oapi.core;

import com.lark.oapi.core.utils.Strings;

public final class UserAgent {
    private UserAgent() {
    }

    public static String build(String source) {
        String base = "oapi-sdk-java/" + Constants.VERSION;
        if (Strings.isEmpty(source)) {
            return base;
        }
        String clean = sanitizeSource(source);
        return Strings.isEmpty(clean) ? base : base + " source/" + clean;
    }

    static String sanitizeSource(String source) {
        StringBuilder builder = new StringBuilder();
        boolean previousWasSeparator = false;
        for (int i = 0; i < source.length(); i++) {
            char ch = source.charAt(i);
            if (isSourceTokenChar(ch)) {
                builder.append(ch);
                previousWasSeparator = false;
            } else if (!previousWasSeparator && builder.length() > 0) {
                builder.append('-');
                previousWasSeparator = true;
            }
        }
        int length = builder.length();
        if (length > 0 && builder.charAt(length - 1) == '-') {
            builder.deleteCharAt(length - 1);
        }
        return builder.toString();
    }

    private static boolean isSourceTokenChar(char ch) {
        return (ch >= 'a' && ch <= 'z')
                || (ch >= 'A' && ch <= 'Z')
                || (ch >= '0' && ch <= '9')
                || ch == '.'
                || ch == '_'
                || ch == '-';
    }
}
