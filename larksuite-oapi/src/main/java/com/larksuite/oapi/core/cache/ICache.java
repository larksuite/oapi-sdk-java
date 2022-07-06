package com.larksuite.oapi.core.cache;

import java.util.concurrent.TimeUnit;

public interface ICache {
    String get(String key) throws Exception;

    void set(String key, String value, int expire, TimeUnit timeUnit) throws Exception;
}
