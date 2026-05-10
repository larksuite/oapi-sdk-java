package com.lark.oapi.channel.safety;

import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.model.BotIdentity;
import com.lark.oapi.channel.model.NormalizedMessage;
import com.lark.oapi.channel.model.RejectEvent;
import com.lark.oapi.channel.model.RejectReason;
import java.util.List;

/**
 * Pipeline entry facade for the channel safety layer.
 *
 * Three tiers of protection, each targeting different event shapes:
 * - pushMessage: full pipeline (stale + dedup + policy + lock + batch + queue)
 * - pushAction: dedup + lock + queue, for card button clicks and doc comments
 * - pushLight: dedup only, for reactions
 */
public class SafetyPipeline {
    private final SeenCache seenCache;
    private final ProcessingLock lock;
    private final PolicyGate policy;
    private final ChatPipelineManager manager;
    private final long staleWindow;
    private final boolean queueEnabled;

    private final OnReject onReject;
    private final OnMessageDispatch onMessage;

    public SafetyPipeline(SafetyPipelineOptions opts) {
        LarkChannelOptions.SafetyConfig config = opts.getConfig();
        this.staleWindow = config.getStaleMessageWindowMs();
        this.queueEnabled = config.isChatQueueEnabled();
        this.onReject = opts.getOnReject();
        this.onMessage = opts.getOnMessage();
        this.seenCache = new SeenCache(config, opts.getCache());
        this.lock = new ProcessingLock(config.getProcessingLockTtlMs());
        this.policy = new PolicyGate(opts.getPolicy());
        this.policy.setBotIdentity(opts.getBotIdentity());
        this.manager = new ChatPipelineManager(config.getBatchText());
    }

    // tier 1: full pipeline for IM messages

    public void pushMessage(final NormalizedMessage msg) {
        if (onMessage == null) {
            throw new IllegalStateException("onMessage handler is not configured");
        }
        if (msg == null) {
            return;
        }
        final String eventId = eventId(msg);
        if (isStale(msg)) {
            return;
        }
        if (seenCache.contains(eventId)) {
            return;
        }
        RejectReason rejectReason = policy.evaluate(msg);
        if (rejectReason != null) {
            if (onReject != null) {
                onReject.onReject(new RejectEvent(rejectReason, msg.getRaw()));
            }
            return;
        }
        if (!lock.tryAcquire(eventId)) {
            return;
        }

        FlushHandler dispatchHandler = new FlushHandler() {
            @Override
            public void flush(BatchedDispatch batch) {
                dispatchMessageBatch(batch);
            }
        };
        if (queueEnabled && msg.getChatId() != null && !msg.getChatId().isEmpty()) {
            manager.push(msg.getChatId(), msg, dispatchHandler);
            return;
        }
        dispatchHandler.flush(new BatchedDispatch(msg, java.util.Collections.singletonList(eventId)));
    }

    // tier 2: dedup + lock + queue for cardAction and comment

    public void pushAction(String eventId, String queueScope, Runnable handler) {
        if (seenCache.contains(eventId)) {
            return;
        }
        if (!lock.tryAcquire(eventId)) {
            return;
        }
        Runnable task = guardedTask(eventId, handler);
        if (queueEnabled && queueScope != null && !queueScope.isEmpty()) {
            manager.run(queueScope, task);
            return;
        }
        task.run();
    }

    // tier 3: dedup only for reactions

    public void pushLight(String eventId, Runnable handler) {
        if (seenCache.contains(eventId)) {
            return;
        }
        seenCache.mark(eventId);
        handler.run();
    }

    // runtime config

    public RejectReason checkPolicy(NormalizedMessage message) {
        return policy.evaluate(message);
    }

    public void setBotIdentity(BotIdentity botIdentity) {
        policy.setBotIdentity(botIdentity);
    }

    public void clearSeen() {
        seenCache.clear();
    }

    public void dispose() {
        manager.dispose();
        lock.clear();
        seenCache.clear();
    }

    private void dispatchMessageBatch(BatchedDispatch batch) {
        try {
            onMessage.onMessage(batch.getMessage());
        } finally {
            List<String> sourceIds = batch.getSourceIds();
            for (String id : sourceIds) {
                if (id != null) {
                    seenCache.mark(id);
                    lock.release(id);
                }
            }
        }
    }

    private Runnable guardedTask(final String eventId, final Runnable handler) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    handler.run();
                    seenCache.mark(eventId);
                } finally {
                    lock.release(eventId);
                }
            }
        };
    }

    private boolean isStale(NormalizedMessage message) {
        return message.getCreateTime() > 0L && System.currentTimeMillis() - message.getCreateTime() > staleWindow;
    }

    private String eventId(NormalizedMessage msg) {
        return msg.getMessageId() == null ? "" : msg.getMessageId();
    }
}
