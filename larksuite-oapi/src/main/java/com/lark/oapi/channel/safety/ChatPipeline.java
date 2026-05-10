package com.lark.oapi.channel.safety;

import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.model.MentionInfo;
import com.lark.oapi.channel.model.NormalizedMessage;
import com.lark.oapi.channel.model.ResourceDescriptor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Per-scope pipeline that does two things at once:
 * - debounce-based batch aggregation for IM messages
 * - strict serialization of pending batch flushes and one-shot tasks
 */
class ChatPipeline {
    private final LarkChannelOptions.BatchTextConfig config;
    private final boolean serialOnly;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(runnable -> {
        Thread thread = new Thread(runnable, "lark-channel-chat-pipeline");
        thread.setDaemon(true);
        return thread;
    });
    private final Object lock = new Object();
    private final List<NormalizedMessage> buffer = new ArrayList<>();
    private int bufferChars;
    private ScheduledFuture<?> timer;
    private FlushHandler pendingHandler;

    ChatPipeline(LarkChannelOptions.BatchTextConfig config, boolean serialOnly) {
        this.config = config == null ? new LarkChannelOptions.BatchTextConfig() : config;
        this.serialOnly = serialOnly;
    }

    void push(NormalizedMessage message, FlushHandler handler) {
        synchronized (lock) {
            buffer.add(message);
            bufferChars += message.getContent() == null ? 0 : message.getContent().length();
            if (pendingHandler == null) {
                pendingHandler = handler;
            }

            if (buffer.size() >= config.getMaxMessages() || bufferChars >= config.getMaxChars()) {
                clearTimerLocked();
                enqueueFlushLocked();
                return;
            }

            if (config.getDelayMs() <= 0L || serialOnly) {
                clearTimerLocked();
                enqueueFlushLocked();
                return;
            }

            clearTimerLocked();
            long delay = bufferChars >= config.getLongThresholdChars()
                    ? config.getLongDelayMs()
                    : config.getDelayMs();
            timer = scheduler.schedule(this::flushNow, Math.max(0L, delay), TimeUnit.MILLISECONDS);
        }
    }

    void run(Runnable task) {
        synchronized (lock) {
            if (!buffer.isEmpty()) {
                clearTimerLocked();
                enqueueFlushLocked();
            }
            task.run();
        }
    }

    void flushNow() {
        synchronized (lock) {
            clearTimerLocked();
            enqueueFlushLocked();
        }
    }

    void dispose() {
        synchronized (lock) {
            clearTimerLocked();
            buffer.clear();
            pendingHandler = null;
        }
        scheduler.shutdownNow();
    }

    private void clearTimerLocked() {
        if (timer != null) {
            timer.cancel(false);
            timer = null;
        }
    }

    private void enqueueFlushLocked() {
        if (buffer.isEmpty() || pendingHandler == null) {
            return;
        }
        List<NormalizedMessage> batch = new ArrayList<>(buffer);
        FlushHandler handler = pendingHandler;
        buffer.clear();
        bufferChars = 0;
        pendingHandler = null;
        handler.flush(new BatchedDispatch(mergeBatch(batch), sourceIds(batch)));
    }

    /**
     * Merge a batch of NormalizedMessages from the same chat into a single representative message.
     * Keeps the latest-arrival metadata and unions content, resources and mentions.
     */
    private static NormalizedMessage mergeBatch(List<NormalizedMessage> batch) {
        if (batch.size() == 1) {
            return batch.get(0);
        }
        NormalizedMessage last = batch.get(batch.size() - 1);
        StringBuilder content = new StringBuilder();
        boolean mentionAll = false;
        boolean mentionedBot = false;
        for (NormalizedMessage message : batch) {
            if (message.getContent() != null && !message.getContent().isEmpty()) {
                if (content.length() > 0) {
                    content.append("\n\n");
                }
                content.append(message.getContent());
            }
            mentionAll = mentionAll || message.isMentionAll();
            mentionedBot = mentionedBot || message.isMentionedBot();
        }
        return new NormalizedMessage(
                last.getMessageId(),
                last.getChatId(),
                last.getChatType(),
                last.getSenderId(),
                last.getSenderName(),
                content.toString(),
                last.getRawContentType(),
                mergeResources(batch),
                mergeMentions(batch),
                mentionAll,
                mentionedBot,
                last.getRootId(),
                last.getThreadId(),
                last.getReplyToMessageId(),
                last.getCreateTime(),
                last.getRaw());
    }

    private static List<String> sourceIds(List<NormalizedMessage> batch) {
        List<String> ids = new ArrayList<>();
        for (NormalizedMessage message : batch) {
            ids.add(message.getMessageId());
        }
        return ids;
    }

    private static List<ResourceDescriptor> mergeResources(List<NormalizedMessage> batch) {
        List<ResourceDescriptor> merged = new ArrayList<>();
        HashSet<String> seen = new HashSet<>();
        for (NormalizedMessage message : batch) {
            for (ResourceDescriptor resource : message.getResources()) {
                String key = resource.getFileKey();
                if (key != null && seen.contains(key)) {
                    continue;
                }
                if (key != null) {
                    seen.add(key);
                }
                merged.add(resource);
            }
        }
        return merged;
    }

    private static List<MentionInfo> mergeMentions(List<NormalizedMessage> batch) {
        List<MentionInfo> merged = new ArrayList<>();
        HashSet<String> seen = new HashSet<>();
        for (NormalizedMessage message : batch) {
            for (MentionInfo mention : message.getMentions()) {
                String key = mention.getOpenId() != null ? mention.getOpenId() : mention.getKey();
                if (key != null && seen.contains(key)) {
                    continue;
                }
                if (key != null) {
                    seen.add(key);
                }
                merged.add(mention);
            }
        }
        return merged;
    }
}
