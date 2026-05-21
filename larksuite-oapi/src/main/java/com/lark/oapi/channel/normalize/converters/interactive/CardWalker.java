package com.lark.oapi.channel.normalize.converters.interactive;

import com.google.gson.JsonElement;
import com.lark.oapi.channel.normalize.NormalizeTexts;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class CardWalker {
    private CardWalker() {
    }

    public static List<String> collectVisibleTexts(JsonElement element) {
        List<String> pieces = new ArrayList<String>();
        NormalizeTexts.collectInteractiveText(element, pieces);
        Set<String> seen = new LinkedHashSet<String>();
        List<String> output = new ArrayList<String>();
        for (String piece : pieces) {
            String trimmed = piece == null ? "" : piece.trim();
            if (trimmed.isEmpty() || seen.contains(trimmed)) {
                continue;
            }
            seen.add(trimmed);
            output.add(trimmed);
        }
        return output;
    }
}
