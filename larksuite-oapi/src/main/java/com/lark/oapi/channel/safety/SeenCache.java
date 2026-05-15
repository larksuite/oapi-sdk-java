package com.lark.oapi.channel.safety;

import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.core.cache.ICache;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

class SeenCache {
    private final LarkChannelOptions.SafetyConfig config;
    private final ICache externalCache;
    private final LinkedHashMap<String, Long> memory = new LinkedHashMap<String, Long>(16, 0.75f, true);
    private volatile long lastSweepAt;

    SeenCache(LarkChannelOptions.SafetyConfig config, ICache externalCache) {
        this.config = config;
        this.externalCache = externalCache;
    }

    boolean contains(String key) {
        sweepIfNeeded();
        long now = System.currentTimeMillis();
        synchronized (memory) {
            Long expireAt = memory.get(key);
            if (expireAt != null) {
                if (expireAt.longValue() > now) {
                    return true;
                }
                memory.remove(key);
            }
        }
        if (externalCache == null) {
            return false;
        }
        String value = externalCache.get(namespaced(key));
        if (value == null || value.isEmpty()) {
            return false;
        }
        putMemory(key, now + config.getDedupTtlMs());
        return true;
    }

    void mark(String key) {
        sweepIfNeeded();
        long expireAt = System.currentTimeMillis() + config.getDedupTtlMs();
        putMemory(key, expireAt);
        if (externalCache != null) {
            long seconds = Math.max(1L, TimeUnit.MILLISECONDS.toSeconds(config.getDedupTtlMs()));
            try {
                externalCache.set(namespaced(key), "1", (int) Math.min(Integer.MAX_VALUE, seconds), TimeUnit.SECONDS);
            } catch (RuntimeException ignored) {
                // Match NodeJS: long-term cache failures are tolerated because
                // the in-memory tier remains authoritative during this process.
            }
        }
    }

    void clear() {
        synchronized (memory) {
            memory.clear();
        }
    }

    private void sweepIfNeeded() {
        long now = System.currentTimeMillis();
        if (now - lastSweepAt < config.getDedupSweepMs()) {
            return;
        }
        lastSweepAt = now;
        synchronized (memory) {
            Iterator<Map.Entry<String, Long>> iterator = memory.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Long> entry = iterator.next();
                if (entry.getValue().longValue() <= now) {
                    iterator.remove();
                }
            }
        }
    }

    private void putMemory(String key, long expireAt) {
        synchronized (memory) {
            memory.put(key, Long.valueOf(expireAt));
            trimIfNeededLocked();
        }
    }

    private void trimIfNeededLocked() {
        int maxEntries = config.getDedupMaxEntries();
        if (maxEntries <= 0 || memory.size() <= maxEntries) {
            return;
        }
        Iterator<Map.Entry<String, Long>> iterator = memory.entrySet().iterator();
        while (memory.size() > maxEntries && iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    private String namespaced(String key) {
        return config.getDedupNamespace() + ":" + key;
    }
}
