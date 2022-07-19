package com.lark.oapi.core.cache;

import java.util.concurrent.TimeUnit;

public interface ICache {

  // 获取缓存值
  String get(String key);

  // 设置缓存值
  void set(String key, String value, int expire, TimeUnit timeUnit);
}
