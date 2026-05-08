package com.lark.oapi.channel;

import com.lark.oapi.channel.config.LarkChannelOptions;

final class ChannelRuntimeConfig {
    private final LarkChannelOptions options;

    ChannelRuntimeConfig(LarkChannelOptions options) {
        this.options = options;
    }

    void updatePolicy(LarkChannelOptions.PolicyConfig partial) {
        if (partial == null) {
            return;
        }
        LarkChannelOptions.PolicyConfig policy = options.getPolicy();
        if (policy == null) {
            return;
        }
        policy.setGroupAllowlist(partial.getGroupAllowlist());
        policy.setDmMode(partial.getDmMode());
        policy.setDmAllowlist(partial.getDmAllowlist());
        policy.setRequireMention(partial.isRequireMention());
        policy.setRespondToMentionAll(partial.isRespondToMentionAll());
    }

    LarkChannelOptions.PolicyConfig getPolicy() {
        return options.getPolicy();
    }
}
