package com.lark.oapi.channel.normalize;

import com.lark.oapi.channel.model.MentionInfo;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MentionState {
    private final List<MentionInfo> mentions;
    private final Map<String, MentionInfo> byKey;
    private final Map<String, MentionInfo> byOpenId;
    private final boolean mentionAll;
    private final boolean mentionedBot;

    public MentionState(List<MentionInfo> mentions, Map<String, MentionInfo> byKey, Map<String, MentionInfo> byOpenId,
                        boolean mentionAll, boolean mentionedBot) {
        this.mentions = mentions == null ? Collections.<MentionInfo>emptyList() : mentions;
        this.byKey = byKey == null ? Collections.<String, MentionInfo>emptyMap() : byKey;
        this.byOpenId = byOpenId == null ? Collections.<String, MentionInfo>emptyMap() : byOpenId;
        this.mentionAll = mentionAll;
        this.mentionedBot = mentionedBot;
    }

    public List<MentionInfo> getMentions() {
        return mentions;
    }

    public Map<String, MentionInfo> getByKey() {
        return byKey;
    }

    public Map<String, MentionInfo> getByOpenId() {
        return byOpenId;
    }

    public boolean isMentionAll() {
        return mentionAll;
    }

    public boolean isMentionedBot() {
        return mentionedBot;
    }
}
