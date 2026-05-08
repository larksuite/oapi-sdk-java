package com.lark.oapi.channel.safety;

import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.model.NormalizedMessage;
import com.lark.oapi.channel.model.RejectReason;
import com.lark.oapi.core.cache.ICache;

public class SafetyPipeline {
    public interface RejectListener {
        void onReject(RejectReason reason, Object raw);
    }

    private final LarkChannelOptions.SafetyConfig config;
    private final SeenCache seenCache;
    private final ProcessingLock processingLock;
    private final PolicyGate policyGate;
    private final ChatPipeline chatPipeline;

    public SafetyPipeline(LarkChannelOptions.SafetyConfig config, LarkChannelOptions.PolicyConfig policy, ICache cache) {
        this.config = config;
        this.seenCache = new SeenCache(config, cache);
        this.processingLock = new ProcessingLock(config.getProcessingLockTtlMs());
        this.policyGate = new PolicyGate(policy);
        this.chatPipeline = new ChatPipeline();
    }

    public RejectReason checkPolicy(NormalizedMessage message) {
        return policyGate.evaluate(message);
    }

    public void pushMessage(String dedupKey, String scope, NormalizedMessage message, Runnable task, RejectListener rejectListener) {
        if (isStale(message)) {
            return;
        }
        if (seenCache.contains(dedupKey)) {
            return;
        }
        RejectReason rejectReason = policyGate.evaluate(message);
        if (rejectReason != null) {
            if (rejectListener != null) {
                rejectListener.onReject(rejectReason, message == null ? null : message.getRaw());
            }
            return;
        }
        runWithGuards(dedupKey, scope, task);
    }

    public void pushAction(String dedupKey, String scope, Runnable task) {
        if (seenCache.contains(dedupKey)) {
            return;
        }
        runWithGuards(dedupKey, scope, task);
    }

    public void pushLight(String dedupKey, Runnable task) {
        if (seenCache.contains(dedupKey)) {
            return;
        }
        seenCache.mark(dedupKey);
        task.run();
    }

    public void clearSeen() {
        seenCache.clear();
    }

    public void dispose() {
        chatPipeline.flushAll();
        chatPipeline.clear();
        processingLock.clear();
        seenCache.clear();
    }

    private void runWithGuards(String dedupKey, String scope, Runnable task) {
        if (!processingLock.tryAcquire(dedupKey)) {
            return;
        }
        Runnable guarded = new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                    seenCache.mark(dedupKey);
                } finally {
                    processingLock.release(dedupKey);
                }
            }
        };
        if (config.isChatQueueEnabled() && scope != null && !scope.isEmpty()) {
            chatPipeline.run(scope, guarded);
            return;
        }
        guarded.run();
    }

    private boolean isStale(NormalizedMessage message) {
        if (message == null || message.getCreateTime() <= 0L) {
            return false;
        }
        long now = System.currentTimeMillis();
        return now - message.getCreateTime() > config.getStaleMessageWindowMs();
    }
}
