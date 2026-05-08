package com.lark.oapi.channel.safety;

import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.core.cache.ICache;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

class SeenCache {
    private final LarkChannelOptions.SafetyConfig config;
    private final ICache externalCache;
    private final ConcurrentHashMap<String, Long> memory = new ConcurrentHashMap<String, Long>();
    private volatile long lastSweepAt;

    SeenCache(LarkChannelOptions.SafetyConfig config, ICache externalCache) {
        this.config = config;
        this.externalCache = externalCache;
    }

    boolean contains(String key) {
        sweepIfNeeded();
        Long expireAt = memory.get(key);
        long now = System.currentTimeMillis();
        if (expireAt != null) {
            if (expireAt.longValue() > now) {
                return true;
            }
            memory.remove(key, expireAt);
        }
        if (externalCache == null) {
            return false;
        }
        String value = externalCache.get(namespaced(key));
        return value != null && !value.isEmpty();
    }

    void mark(String key) {
        sweepIfNeeded();
        long expireAt = System.currentTimeMillis() + config.getDedupTtlMs();
        memory.put(key, Long.valueOf(expireAt));
        trimIfNeeded();
        if (externalCache != null) {
            long seconds = Math.max(1L, TimeUnit.MILLISECONDS.toSeconds(config.getDedupTtlMs()));
            externalCache.set(namespaced(key), "1", (int) Math.min(Integer.MAX_VALUE, seconds), TimeUnit.SECONDS);
        }
    }

    void clear() {
        memory.clear();
    }

    private void sweepIfNeeded() {
        long now = System.currentTimeMillis();
        if (now - lastSweepAt < config.getDedupSweepMs()) {
            return;
        }
        lastSweepAt = now;
        Iterator<Map.Entry<String, Long>> iterator = memory.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Long> entry = iterator.next();
            if (entry.getValue().longValue() <= now) {
                iterator.remove();
            }
        }
    }

    private void trimIfNeeded() {
        int maxEntries = config.getDedupMaxEntries();
        if (maxEntries <= 0 || memory.size() <= maxEntries) {
            return;
        }
        String oldestKey = null;
        long oldestExpireAt = Long.MAX_VALUE;
        for (Map.Entry<String, Long> entry : memory.entrySet()) {
            if (entry.getValue().longValue() < oldestExpireAt) {
                oldestExpireAt = entry.getValue().longValue();
                oldestKey = entry.getKey();
            }
        }
        if (oldestKey != null) {
            memory.remove(oldestKey);
        }
    }

    private String namespaced(String key) {
        return config.getDedupNamespace() + ":" + key;
    }
}
