package com.lark.oapi.channel.safety;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class ProcessingLock {
    private final long ttlMs;
    private final ConcurrentHashMap<String, Long> locks = new ConcurrentHashMap<String, Long>();

    ProcessingLock(long ttlMs) {
        this.ttlMs = ttlMs;
    }

    boolean tryAcquire(String key) {
        if (key == null || key.isEmpty()) {
            return true;
        }
        long now = System.currentTimeMillis();
        Long expireAt = locks.get(key);
        if (expireAt != null && expireAt.longValue() > now) {
            return false;
        }
        locks.put(key, Long.valueOf(now + ttlMs));
        sweep(now);
        return true;
    }

    void release(String key) {
        if (key == null || key.isEmpty()) {
            return;
        }
        locks.remove(key);
    }

    void clear() {
        locks.clear();
    }

    private void sweep(long now) {
        Iterator<Map.Entry<String, Long>> iterator = locks.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Long> entry = iterator.next();
            if (entry.getValue().longValue() <= now) {
                iterator.remove();
            }
        }
    }
}
