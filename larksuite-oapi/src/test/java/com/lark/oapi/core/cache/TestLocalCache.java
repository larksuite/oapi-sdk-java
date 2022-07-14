package com.lark.oapi.core.cache;

import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class TestLocalCache {

  @Test
  public void testCache() {
    LocalCache localCache = LocalCache.getInstance();
    localCache.set("key1", "value1", 1, TimeUnit.SECONDS);

    String value = localCache.get("key1");
    assert value.equals("value1");
  }

  @Test
  public void testCacheKeyTimeout() throws InterruptedException {
    LocalCache localCache = LocalCache.getInstance();
    localCache.set("key1", "value1", 1, TimeUnit.MILLISECONDS);

    Thread.sleep(2);

    String value = localCache.get("key1");
    assert value.equals("");
  }
}
