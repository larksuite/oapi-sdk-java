package com.lark.oapi.channel.config;

import com.lark.oapi.core.auth.ClientAssertionProvider;
import com.lark.oapi.core.cache.ICache;
import com.lark.oapi.core.httpclient.IHttpTransport;
import com.lark.oapi.core.request.RequestOptions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Configuration for {@code LarkChannel}.
 *
 * <p>The options keep Java SDK conventions such as builders and mutable nested
 * config objects for runtime policy updates.
 */
public class LarkChannelOptions {
    private final String appId;
    private final String appSecret;
    private final String transport;
    private final WebhookOptions webhook;
    private final SafetyConfig safety;
    private final PolicyConfig policy;
    private final OutboundConfig outbound;
    private final ICache cache;
    private final String domain;
    private final IHttpTransport httpTransport;
    private final RequestOptions httpInstance;
    private final String source;
    private final boolean includeRawInMessage;
    private final ClientAssertionProvider clientAssertionProvider;
    private final String oauthBaseUrl;

    private LarkChannelOptions(Builder builder) {
        this.appId = builder.appId;
        this.appSecret = builder.appSecret;
        this.transport = builder.transport;
        this.webhook = builder.webhook;
        this.safety = builder.safety;
        this.policy = builder.policy;
        this.outbound = builder.outbound;
        this.cache = builder.cache;
        this.domain = builder.domain;
        this.httpTransport = builder.httpTransport;
        this.httpInstance = builder.httpInstance;
        this.source = builder.source;
        this.includeRawInMessage = builder.includeRawInMessage;
        this.clientAssertionProvider = builder.clientAssertionProvider;
        this.oauthBaseUrl = builder.oauthBaseUrl;
    }

    public static Builder newBuilder(String appId, String appSecret) {
        return new Builder(appId, appSecret);
    }

    public String getAppId() {
        return appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public String getTransport() {
        return transport;
    }

    public WebhookOptions getWebhook() {
        return webhook;
    }

    public SafetyConfig getSafety() {
        return safety;
    }

    public PolicyConfig getPolicy() {
        return policy;
    }

    public OutboundConfig getOutbound() {
        return outbound;
    }

    public ICache getCache() {
        return cache;
    }

    public String getDomain() {
        return domain;
    }

    public IHttpTransport getHttpTransport() {
        return httpTransport;
    }

    public RequestOptions getHttpInstance() {
        return httpInstance;
    }

    public String getSource() {
        return source;
    }

    public ClientAssertionProvider getClientAssertionProvider() {
        return clientAssertionProvider;
    }

    public String getOAuthBaseUrl() {
        return oauthBaseUrl;
    }

    /**
     * Whether normalized events should carry the original Feishu event body.
     *
     * <p>This getter keeps the historical Java name. New code can configure
     * the same flag with {@link Builder#includeRawEvent(boolean)}.
     */
    public boolean isIncludeRawInMessage() {
        return includeRawInMessage;
    }

    /**
     * Preferred name for {@link #isIncludeRawInMessage()}.
     */
    public boolean isIncludeRawEvent() {
        return includeRawInMessage;
    }

    /**
     * Builder for immutable top-level channel options.
     */
    public static final class Builder {
        private final String appId;
        private final String appSecret;
        private String transport = "websocket";
        private WebhookOptions webhook = new WebhookOptions();
        private SafetyConfig safety = new SafetyConfig();
        private PolicyConfig policy = new PolicyConfig();
        private OutboundConfig outbound = new OutboundConfig();
        private ICache cache;
        private String domain;
        private IHttpTransport httpTransport;
        private RequestOptions httpInstance;
        private String source;
        private boolean includeRawInMessage;
        private ClientAssertionProvider clientAssertionProvider;
        private String oauthBaseUrl;

        private Builder(String appId, String appSecret) {
            this.appId = appId;
            this.appSecret = appSecret;
        }

        /**
         * Set the inbound transport: {@code websocket} (default) or
         * {@code webhook}.
         */
        public Builder transport(String transport) {
            this.transport = transport;
            return this;
        }

        public Builder webhook(WebhookOptions webhook) {
            this.webhook = webhook;
            return this;
        }

        public Builder safety(SafetyConfig safety) {
            this.safety = safety;
            return this;
        }

        public Builder policy(PolicyConfig policy) {
            this.policy = policy;
            return this;
        }

        public Builder outbound(OutboundConfig outbound) {
            this.outbound = outbound;
            return this;
        }

        public Builder cache(ICache cache) {
            this.cache = cache;
            return this;
        }

        public Builder domain(String domain) {
            this.domain = domain;
            return this;
        }

        public Builder httpTransport(IHttpTransport httpTransport) {
            this.httpTransport = httpTransport;
            return this;
        }

        public Builder httpInstance(RequestOptions httpInstance) {
            this.httpInstance = httpInstance;
            return this;
        }

        public Builder source(String source) {
            this.source = source;
            return this;
        }

        public Builder clientAssertionProvider(ClientAssertionProvider clientAssertionProvider) {
            this.clientAssertionProvider = clientAssertionProvider;
            return this;
        }

        public Builder oauthBaseUrl(String oauthBaseUrl) {
            this.oauthBaseUrl = oauthBaseUrl;
            return this;
        }

        /**
         * Attach the raw Feishu event body to normalized events. Useful when a
         * handler needs fields that the normalizer intentionally drops, such as
         * tenant metadata or vendor extensions.
         */
        public Builder includeRawEvent(boolean includeRawEvent) {
            this.includeRawInMessage = includeRawEvent;
            return this;
        }

        /**
         * @deprecated Use {@link #includeRawEvent(boolean)}. Retained for
         * compatibility with the first Java channel preview.
         */
        @Deprecated
        public Builder includeRawInMessage(boolean includeRawInMessage) {
            this.includeRawInMessage = includeRawInMessage;
            return this;
        }

        public LarkChannelOptions build() {
            return new LarkChannelOptions(this);
        }
    }

    /**
     * Webhook verification settings used by {@code createWebhookDispatcher()}.
     */
    public static class WebhookOptions {
        private String verificationToken;
        private String encryptKey;

        public String getVerificationToken() {
            return verificationToken;
        }

        public void setVerificationToken(String verificationToken) {
            this.verificationToken = verificationToken;
        }

        public String getEncryptKey() {
            return encryptKey;
        }

        public void setEncryptKey(String encryptKey) {
            this.encryptKey = encryptKey;
        }
    }

    /**
     * Safety policy that decides whether inbound messages should be handled or
     * rejected before user code runs.
     */
    public static class PolicyConfig {
        private List<String> groupAllowlist = Collections.emptyList();
        private String dmMode = "open";
        private List<String> dmAllowlist = Collections.emptyList();
        private boolean requireMention = true;
        private boolean respondToMentionAll = false;

        public List<String> getGroupAllowlist() {
            return groupAllowlist;
        }

        public void setGroupAllowlist(List<String> groupAllowlist) {
            this.groupAllowlist = groupAllowlist == null ? Collections.<String>emptyList() : groupAllowlist;
        }

        public void setGroupAllowlist(String... groupAllowlist) {
            setGroupAllowlist(Arrays.asList(groupAllowlist));
        }

        public String getDmMode() {
            return dmMode;
        }

        public void setDmMode(String dmMode) {
            this.dmMode = dmMode;
        }

        public List<String> getDmAllowlist() {
            return dmAllowlist;
        }

        public void setDmAllowlist(List<String> dmAllowlist) {
            this.dmAllowlist = dmAllowlist == null ? Collections.<String>emptyList() : dmAllowlist;
        }

        public void setDmAllowlist(String... dmAllowlist) {
            setDmAllowlist(Arrays.asList(dmAllowlist));
        }

        public boolean isRequireMention() {
            return requireMention;
        }

        public void setRequireMention(boolean requireMention) {
            this.requireMention = requireMention;
        }

        public boolean isRespondToMentionAll() {
            return respondToMentionAll;
        }

        public void setRespondToMentionAll(boolean respondToMentionAll) {
            this.respondToMentionAll = respondToMentionAll;
        }
    }

    /**
     * Safety pipeline tuning: stale event filtering, deduplication, per-chat
     * serialization and short-message batching.
     */
    public static class SafetyConfig {
        private long dedupTtlMs = 12L * 60L * 60L * 1000L;
        private int dedupMaxEntries = 5000;
        private long dedupSweepMs = 5L * 60L * 1000L;
        private long staleMessageWindowMs = 30L * 60L * 1000L;
        private boolean chatQueueEnabled = true;
        private long processingLockTtlMs = 5L * 60L * 1000L;
        private String dedupNamespace = "channel:seen";
        private BatchTextConfig batchText = new BatchTextConfig();

        public long getDedupTtlMs() {
            return dedupTtlMs;
        }

        public void setDedupTtlMs(long dedupTtlMs) {
            this.dedupTtlMs = dedupTtlMs;
        }

        public int getDedupMaxEntries() {
            return dedupMaxEntries;
        }

        public void setDedupMaxEntries(int dedupMaxEntries) {
            this.dedupMaxEntries = dedupMaxEntries;
        }

        public long getDedupSweepMs() {
            return dedupSweepMs;
        }

        public void setDedupSweepMs(long dedupSweepMs) {
            this.dedupSweepMs = dedupSweepMs;
        }

        public long getStaleMessageWindowMs() {
            return staleMessageWindowMs;
        }

        public void setStaleMessageWindowMs(long staleMessageWindowMs) {
            this.staleMessageWindowMs = staleMessageWindowMs;
        }

        public boolean isChatQueueEnabled() {
            return chatQueueEnabled;
        }

        public void setChatQueueEnabled(boolean chatQueueEnabled) {
            this.chatQueueEnabled = chatQueueEnabled;
        }

        public long getProcessingLockTtlMs() {
            return processingLockTtlMs;
        }

        public void setProcessingLockTtlMs(long processingLockTtlMs) {
            this.processingLockTtlMs = processingLockTtlMs;
        }

        public String getDedupNamespace() {
            return dedupNamespace;
        }

        public void setDedupNamespace(String dedupNamespace) {
            this.dedupNamespace = dedupNamespace;
        }

        public BatchTextConfig getBatchText() {
            return batchText;
        }

        public void setBatchText(BatchTextConfig batchText) {
            this.batchText = batchText == null ? new BatchTextConfig() : batchText;
        }
    }

    /**
     * Text batching thresholds used by the message safety pipeline.
     */
    public static class BatchTextConfig {
        private long delayMs = 600L;
        private int longThresholdChars = 1000;
        private long longDelayMs = 2000L;
        private int maxMessages = 8;
        private int maxChars = 4000;

        public long getDelayMs() {
            return delayMs;
        }

        public void setDelayMs(long delayMs) {
            this.delayMs = delayMs;
        }

        public int getLongThresholdChars() {
            return longThresholdChars;
        }

        public void setLongThresholdChars(int longThresholdChars) {
            this.longThresholdChars = longThresholdChars;
        }

        public long getLongDelayMs() {
            return longDelayMs;
        }

        public void setLongDelayMs(long longDelayMs) {
            this.longDelayMs = longDelayMs;
        }

        public int getMaxMessages() {
            return maxMessages;
        }

        public void setMaxMessages(int maxMessages) {
            this.maxMessages = maxMessages;
        }

        public int getMaxChars() {
            return maxChars;
        }

        public void setMaxChars(int maxChars) {
            this.maxChars = maxChars;
        }
    }

    /**
     * Outbound sending, media upload, streaming and retry configuration.
     */
    public static class OutboundConfig {
        private int textChunkLimit = 3500;
        private int streamThrottleMs = 100;
        private int streamThrottleChars = 50;
        private String streamInitialText = "Thinking...";
        private boolean ssrfGuardEnabled = true;
        private List<String> ssrfAllowlist = Collections.emptyList();
        private RetryConfig retry = new RetryConfig();
        private List<String> allowedFileDirs = Collections.emptyList();

        public int getTextChunkLimit() {
            return textChunkLimit;
        }

        public void setTextChunkLimit(int textChunkLimit) {
            this.textChunkLimit = textChunkLimit;
        }

        public int getStreamThrottleMs() {
            return streamThrottleMs;
        }

        public void setStreamThrottleMs(int streamThrottleMs) {
            this.streamThrottleMs = streamThrottleMs;
        }

        public int getStreamThrottleChars() {
            return streamThrottleChars;
        }

        public void setStreamThrottleChars(int streamThrottleChars) {
            this.streamThrottleChars = streamThrottleChars;
        }

        public String getStreamInitialText() {
            return streamInitialText;
        }

        public void setStreamInitialText(String streamInitialText) {
            this.streamInitialText = streamInitialText;
        }

        public boolean isSsrfGuardEnabled() {
            return ssrfGuardEnabled;
        }

        public void setSsrfGuardEnabled(boolean ssrfGuardEnabled) {
            this.ssrfGuardEnabled = ssrfGuardEnabled;
        }

        public List<String> getSsrfAllowlist() {
            return ssrfAllowlist;
        }

        public void setSsrfAllowlist(List<String> ssrfAllowlist) {
            this.ssrfAllowlist = ssrfAllowlist == null ? Collections.<String>emptyList() : ssrfAllowlist;
        }

        public RetryConfig getRetry() {
            return retry;
        }

        public void setRetry(RetryConfig retry) {
            this.retry = retry;
        }

        public List<String> getAllowedFileDirs() {
            return allowedFileDirs;
        }

        public void setAllowedFileDirs(List<String> allowedFileDirs) {
            this.allowedFileDirs = allowedFileDirs == null ? Collections.<String>emptyList() : allowedFileDirs;
        }
    }

    /**
     * Retry configuration for retryable outbound API failures.
     */
    public static class RetryConfig {
        private int maxAttempts = 3;
        private long baseDelayMs = 500L;

        public int getMaxAttempts() {
            return maxAttempts;
        }

        public void setMaxAttempts(int maxAttempts) {
            this.maxAttempts = maxAttempts;
        }

        public long getBaseDelayMs() {
            return baseDelayMs;
        }

        public void setBaseDelayMs(long baseDelayMs) {
            this.baseDelayMs = baseDelayMs;
        }
    }
}
