package com.lark.oapi.core.cache;

import java.util.concurrent.TimeUnit;

public interface ICache {

  String get(String key);

  void set(String key, String value, int expire, TimeUnit timeUnit);
}
