package com.larksuite.oapi.core;

import java.util.concurrent.TimeUnit;

public interface IStore {

    String get(String key) throws Exception;

    void put(String key, String value, int expire, TimeUnit timeUnit) throws Exception;

}
