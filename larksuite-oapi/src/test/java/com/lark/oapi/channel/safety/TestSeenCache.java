package com.lark.oapi.channel.safety;

import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.core.cache.ICache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

public class TestSeenCache {
    @Test
    public void testMemoryHitRefreshesLruPosition() {
        LarkChannelOptions.SafetyConfig config = new LarkChannelOptions.SafetyConfig();
        config.setDedupMaxEntries(3);
        SeenCache cache = new SeenCache(config, null);

        cache.mark("a");
        cache.mark("b");
        cache.mark("c");
        Assert.assertTrue(cache.contains("a"));
        cache.mark("d");

        Assert.assertTrue(cache.contains("a"));
        Assert.assertFalse(cache.contains("b"));
        Assert.assertTrue(cache.contains("c"));
        Assert.assertTrue(cache.contains("d"));
    }

    @Test
    public void testExternalCacheHitBackfillsMemory() {
        LarkChannelOptions.SafetyConfig config = new LarkChannelOptions.SafetyConfig();
        CountingCache external = new CountingCache();
        external.values.put("channel:seen:m1", "1");
        SeenCache cache = new SeenCache(config, external);

        Assert.assertTrue(cache.contains("m1"));
        Assert.assertEquals(1, external.getCalls);

        Assert.assertTrue(cache.contains("m1"));
        Assert.assertEquals(1, external.getCalls);
    }

    @Test
    public void testExternalCacheSetFailureDoesNotThrow() {
        LarkChannelOptions.SafetyConfig config = new LarkChannelOptions.SafetyConfig();
        SeenCache cache = new SeenCache(config, new FailingSetCache());

        cache.mark("m1");

        Assert.assertTrue(cache.contains("m1"));
    }

    private static class CountingCache implements ICache {
        private final Map<String, String> values = new HashMap<String, String>();
        private int getCalls;

        @Override
        public String get(String key) {
            getCalls++;
            return values.get(key);
        }

        @Override
        public void set(String key, String value, int expire, TimeUnit timeUnit) {
            values.put(key, value);
        }
    }

    private static class FailingSetCache implements ICache {
        @Override
        public String get(String key) {
            return null;
        }

        @Override
        public void set(String key, String value, int expire, TimeUnit timeUnit) {
            throw new RuntimeException("backend down");
        }
    }
}
