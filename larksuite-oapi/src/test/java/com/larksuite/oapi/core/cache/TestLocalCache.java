package com.larksuite.oapi.core.cache;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TestLocalCache {

    @Test
    public void testCache() {
        LocalCache localCache = LocalCacheSingleton.getInstance();
        localCache.set("key1", "value1", 1, TimeUnit.SECONDS);

        String value = localCache.get("key1");
        assert value.equals("value1");
    }

    @Test
    public void testCacheKeyTimeout() throws InterruptedException {
        LocalCache localCache = LocalCacheSingleton.getInstance();
        localCache.set("key1", "value1", 1, TimeUnit.MILLISECONDS);

        Thread.sleep(2);

        String value = localCache.get("key1");
        assert value.equals("");
    }
}
